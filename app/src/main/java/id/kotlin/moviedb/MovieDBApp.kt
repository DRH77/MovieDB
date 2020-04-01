package id.kotlin.moviedb

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import id.kotlin.moviedb.di.component.DaggerApplicationComponent

class MovieDBApp : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerApplicationComponent.create().apply { inject(this@MovieDBApp)}
    }
}