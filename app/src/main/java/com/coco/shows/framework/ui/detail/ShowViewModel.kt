package com.coco.shows.framework.ui.detail

import androidx.lifecycle.ViewModel
import com.coco.shows.domain.usecase.GetShowById
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShowViewModel @Inject constructor(private val getShowById: GetShowById) : ViewModel() {
}