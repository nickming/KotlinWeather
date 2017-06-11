package com.nickming.kotlinlearning.dagger.module

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nickming.kotlinlearning.api.WeatherApi
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.schedulers.Schedulers
import java.io.File

/**
 * class description here
 * @author nickming
 * @version 1.0.0
 * @since 2017-06-10 下午4:03
 * Copyright (c) 2017 nickming All right reserved.
 */
@Module(includes = arrayOf(AppModule::class))
class ApiModule {

    @Provides fun provideRetrofit(baseUrl: HttpUrl, client: OkHttpClient, gson: Gson) =
            Retrofit.Builder()
                    .client(client)
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()

    @Provides fun provideOkHttp(context: Context, interceptor: HttpLoggingInterceptor): OkHttpClient {
        val cacheSize = 1024 * 1024 * 10L
        val cacheDir = File(context.cacheDir, "http")
        val cache = Cache(cacheDir, cacheSize)
        return OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build()
    }

    @Provides fun provideInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor {
            msg ->
            Log.i("okhttp3", msg)
        }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }

    @Provides fun provideBaseUrl() = HttpUrl.parse("https://free-api.heweather.com/")

    @Provides fun provideGson() = GsonBuilder().create()

    @Provides fun provideApi(retrofit: Retrofit) = retrofit.create(WeatherApi::class.java)
}