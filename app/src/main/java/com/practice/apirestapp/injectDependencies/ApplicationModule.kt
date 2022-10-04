package com.practice.apirestapp.injectDependencies

import com.practice.apirestapp.data.repositories.BeerAPIRepository
import com.practice.apirestapp.data.repositories.BeerRepository
import com.practice.apirestapp.data.repositories.beers.api.BeerAPIClient
import com.practice.apirestapp.data.repositories.beers.api.BeerAPIMainProvider
import com.practice.apirestapp.data.repositories.beers.api.BeerAPIProvider
import com.practice.apirestapp.data.repositories.beers.api.BeerClient
import com.practice.apirestapp.ui.viewmodels.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val remoteRepositoryModule = module {
    //Provider
    single<BeerAPIProvider> { BeerAPIMainProvider() }
    //Client
    single<BeerClient> { BeerAPIClient(get()) }
    //Repository
    single<BeerRepository> { BeerAPIRepository(get()) }

    //ViewModel
    viewModel { MainViewModel(get()) }
}