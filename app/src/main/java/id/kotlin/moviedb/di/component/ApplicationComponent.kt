package id.kotlin.moviedb.di.component

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import id.kotlin.moviedb.MovieDBApp
import id.kotlin.moviedb.di.builder.ActivityBuilder
import id.kotlin.moviedb.di.module.NetworkModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    NetworkModule::class,
    ActivityBuilder::class
])

interface ApplicationComponent : AndroidInjector<MovieDBApp>