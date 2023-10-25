package com.example.ticketapp.di

import com.example.ticketapp.data.remote.api.ClienteApi
import com.example.ticketapp.data.remote.api.TicketApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }


    @Provides
    @Singleton
    fun provideTicketApi(moshi: Moshi): TicketApi {
        return Retrofit.Builder()
            .baseUrl("https://ticketws.azurewebsites.net")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(TicketApi::class.java)
    }

    @Provides
    @Singleton
    fun provideClienteApi(moshi: Moshi): ClienteApi {
        return Retrofit.Builder()
            .baseUrl("https://ticketws.azurewebsites.net")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ClienteApi::class.java)
    }
    /*
    @Provides
    @Singleton
    fun provideCoinRepository(coinApi: CoinApi): CoinsRepository {
        return CoinsRepository(coinApi)
    }*/
}