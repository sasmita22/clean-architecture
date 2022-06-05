package com.hiroshisasmita.cleanarchitecture.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.liveData
import androidx.paging.map
import com.hiroshisasmita.cleanarchitecture.domain.model.PopularMovieDomain
import com.hiroshisasmita.cleanarchitecture.domain.usecase.GetPopularMoviesUseCase
import com.hiroshisasmita.cleanarchitecture.domain.usecase.GetPopularMoviesUseCase.RequestValues
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(
    private val useCase: GetPopularMoviesUseCase
): ViewModel() {

    private val _movies: MutableLiveData<PagingData<PopularMovieDomain>> = MutableLiveData()
    val movies: LiveData<PagingData<PopularMovieDomain>> = _movies

    init {
        fetchPopularMovies()
    }

    fun fetchPopularMovies() {
        viewModelScope.launch {
            useCase.execute(RequestValues())
                .paging
                .cachedIn(viewModelScope)
                .collect {
                    _movies.postValue(it)
                }
        }
    }
}
