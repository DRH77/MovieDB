package id.kotlin.moviedb.di.builder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import id.kotlin.moviedb.di.module.HomeModule
import id.kotlin.moviedb.di.scope.Presentation
import id.kotlin.moviedb.presentation.HomeActivity

@Module
abstract class ActivityBuilder {

    @Presentation
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun contributeHomeActivity(): HomeActivity
}