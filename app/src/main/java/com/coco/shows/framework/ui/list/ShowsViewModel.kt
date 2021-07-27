package com.coco.shows.framework.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coco.shows.domain.model.Show
import com.coco.shows.domain.usecase.GetShows
import com.coco.shows.framework.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(private val getShows: GetShows) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val _shows = MutableLiveData<Resource<List<Show>>>()
    val shows: LiveData<Resource<List<Show>>>
        get() {
            if (_shows.value == null) refresh()
            return _shows
        }

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> get() = _loading

    private val _navigation = MutableLiveData<Int>()
    val navigation: LiveData<Int> get() = _navigation

    private fun refresh() {
        _loading.value = true
        compositeDisposable.add(
            getShows.invoke(LocalDate.now().format(DateTimeFormatter.ISO_DATE))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { r ->
                        if (r.isNullOrEmpty())
                            _shows.postValue(Resource.error("No data", null))
                        else _shows.postValue(Resource.success(r))
                        _loading.value = false
                    },
                    {
                        _shows.postValue(Resource.error("Error", null))
                        _loading.value = false
                    }
                )
        )
    }

    fun onItemClick(show: Show, position: Int) {
        _navigation.value = show.id
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}