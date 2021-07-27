package com.coco.shows.framework.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coco.shows.domain.model.Show
import com.coco.shows.domain.usecase.GetShows
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowsViewModel @Inject constructor(private val getShows: GetShows) : ViewModel() {

    private val _shows = MutableLiveData<List<Show>>()
    val shows: LiveData<List<Show>> get() = _shows


}