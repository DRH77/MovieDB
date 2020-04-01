package id.kotlin.moviedb.di.module

import dagger.Binds
import dagger.Module
import dagger.Provides
import id.kotlin.moviedb.data.HomeDataSource
import id.kotlin.moviedb.presentation.HomeActivity
import id.kotlin.moviedb.presentation.HomePresenter
import id.kotlin.moviedb.presentation.HomeView
import retrofit2.Retrofit

@Module
abstract class HomeModule {

    @Module
    companion object {

        @JvmStatic
        @Provides
        fun providesHomeDataSource(retrofit: Retrofit): HomeDataSource = retrofit.create(HomeDataSource::class.java)

        @JvmStatic
        @Provides
        fun providesHomePresenter(
            view: HomeView,
            dataSource: HomeDataSource
        ): HomePresenter = HomePresenter(view, dataSource)

    }

    @Binds
    abstract fun bindHomeView(activity: HomeActivity): HomeView

}

