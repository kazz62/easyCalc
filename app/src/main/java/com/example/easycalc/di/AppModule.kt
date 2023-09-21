package com.example.easycalc.di
import com.example.easycalc.HomeScreen.HomeViewModel
import com.example.easycalc.repository.EasyCalcRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.scopes.ViewModelScoped
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
}
