package app.frantic.rxjavamvpkotlin.network

import app.frantic.rxjavamvpkotlin.model.Flower
import io.reactivex.Observable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*
import java.io.IOException
import java.util.concurrent.TimeUnit

class RestApi{

    val requestAPI : RequestAPI

    init {
        val builder = OkHttpClient.Builder()
        builder.readTimeout(5000, TimeUnit.SECONDS)
        builder.connectTimeout(5000, TimeUnit.SECONDS)
        val client = builder.build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        requestAPI = retrofit.create(RequestAPI::class.java)
    }

    companion object {
        private val BASE_URL = "http://services.hanselandpetal.com/"
        private var restApi : RestApi? = null

        val instance: RestApi get() {
            if (restApi == null){
                restApi = RestApi()
            }
            return restApi as RestApi
        }
    }

}