package ru.nsu.fit.grigor.employeeapp.library.network.retrofit

import android.util.Log
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import ru.nsu.fit.grigor.employeeapp.library.network.retrofit.adapters.DateAdapter

const val ORIGINAL = "ORIGINAL"
const val BACKEND_ENDPOINT = "https://gitlab.65apps.com"

inline fun <reified T> createRetrofitService(retrofit: Retrofit): T =
    retrofit.create(T::class.java)

inline fun <reified T> Scope.getRetrofit(): T =
    get(T::class, named(ORIGINAL).also { Log.d("getRetrofit", it.value) })

val NetworkModule: Module = module {
    single(named(ORIGINAL)) {
        provideOkHttpClient()
    }

    single(named(ORIGINAL)) {
        provideRetrofit(
            okHttpClient = get(named(ORIGINAL)),
            moshi = get(),
            url = BACKEND_ENDPOINT
        )
    }
    single { provideMoshi() }

}

fun provideRetrofit(
    okHttpClient: OkHttpClient,
    url: String,
    moshi: Moshi
): Retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(okHttpClient)
    .baseUrl(url)
    .build()

private fun provideOkHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder().build()
}

internal fun provideMoshi(): Moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .add(DateAdapter)
    .build()