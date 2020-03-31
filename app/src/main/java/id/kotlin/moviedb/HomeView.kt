package id.kotlin.moviedb

interface HomeView {

    fun onShowLoading()
    fun onHideLoading()
    fun onResponse(result: List<Result>)
    fun onFailure(error: Throwable)
}