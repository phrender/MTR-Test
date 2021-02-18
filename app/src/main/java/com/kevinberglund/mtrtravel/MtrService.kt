package com.kevinberglund.mtrtravel

import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

class MtrService(
        private val baseUrl: String,
        cache: File?
) {

    private val CACHE_SIZE_BYTES: Long = 16 * 1024 * 1024;
    private val httpCLientCache: Cache? = if (cache != null) Cache(cache, CACHE_SIZE_BYTES) else null
    val retrofit by lazy { makeRetrofit() }

    private fun makeRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(makeHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()

    private fun makeHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor())
        .cache(httpCLientCache)
        .build()

    private fun loggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
        return loggingInterceptor
    }
}