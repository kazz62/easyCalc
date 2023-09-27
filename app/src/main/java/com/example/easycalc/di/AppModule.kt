package com.example.easycalc.di

import com.example.easycalc.HomeScreen.HomeViewModel
import com.example.easycalc.againstTheWatch.AgainstTheWatchViewModel
import com.example.easycalc.menu.MenuViewModel
import com.example.easycalc.repository.EasyCalcRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideEasyCalcRepository(): EasyCalcRepository {
        return EasyCalcRepository()
    }

    @Provides
    fun provideHomeViewModel(repository: EasyCalcRepository): HomeViewModel {
        return HomeViewModel(repository)
    }

    @Provides
    fun provideMenuViewModel(): MenuViewModel {
        return MenuViewModel()
    }
    @Provides
    fun provideAgainstTheWatchViewModel(): AgainstTheWatchViewModel {
        return AgainstTheWatchViewModel()
    }
}
