package com.example.androidpokedex.di

import com.example.androidpokedex.data.network.PokeApi
import com.example.androidpokedex.repository.IPokemonRepository
import com.example.androidpokedex.repository.PokemonRepository
import com.example.androidpokedex.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun providePokemonRepository(api: PokeApi): IPokemonRepository = PokemonRepository(api)

    @Singleton
    @Provides
    fun providePokeApi(): PokeApi =
        Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PokeApi::class.java)
}
