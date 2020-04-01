package id.kotlin.moviedb.presentation

import id.kotlin.moviedb.data.Result

interface HomeView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(result: List<Result>)
    fun onFailure(error: Throwable)
}