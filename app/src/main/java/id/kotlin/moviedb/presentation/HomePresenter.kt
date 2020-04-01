package id.kotlin.moviedb.presentation

import id.kotlin.moviedb.data.HomeDataSource
import id.kotlin.moviedb.data.HomeResponse
import id.kotlin.moviedb.di.module.NetworkModule
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeView,
    private val dataSource: HomeDataSource
) {

    fun discoverMovie() {
        view.onShowLoading()

        //val dataSource = NetworkModule.providesHttpAdapter().create(HomeDataSource::class.java)
        dataSource.discoverMovie().enqueue(object : Callback<HomeResponse> {
            override fun onResponse(call: Call<HomeResponse>, response: Response<HomeResponse>) {
                view.onHideLoading()
                view.onResponse(response.body()?.results ?: emptyList())
            }

            override fun onFailure(call: Call<HomeResponse>, t: Throwable) {
                view.onHideLoading()
                view.onFailure(t)
            }
        })
    }
}