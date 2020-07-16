package com.koflox.cleanarch.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.koflox.cleanarch.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        createLoggingInterceptor()
    }
    single {
        createOkHttpClient(get())
    }
    /*
    single {
        createWebService<SomeService>(get(), "SOME_BASE_URL")
    }
     */
}

private fun createOkHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor
): OkHttpClient = OkHttpClient.Builder()
    .addInterceptor(httpLoggingInterceptor)
    .build()

private fun createLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
    level = when {
        BuildConfig.DEBUG -> HttpLoggingInterceptor.Level.BODY
        else -> HttpLoggingInterceptor.Level.NONE
    }
}

private inline fun <reified T> createWebService(okHttpClient: OkHttpClient, url: String): T {
    val retrofit = Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory()).build()
    return retrofit.create(T::class.java)
}