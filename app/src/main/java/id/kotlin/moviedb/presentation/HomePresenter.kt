package id.kotlin.moviedb.presentation

import id.kotlin.moviedb.data.HomeDataSource
import id.kotlin.moviedb.data.HomeResponse
import id.kotlin.moviedb.di.module.NetworkModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomePresenter(
    private val view: HomeView,
    private val dataSource: HomeDataSource
) {

    private val disposables: CompositeDisposable = CompositeDisposable()

    fun discoverMovie() {
        view.onShowLoading()

        dataSource.discoverMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.onHideLoading()
                view.onResponse(response.results)
            }, { error ->
                view.onHideLoading()
                view.onFailure(error)
            }).addTo(disposables)
    }

    fun onDetach(){
        disposables.clear()
    }
}