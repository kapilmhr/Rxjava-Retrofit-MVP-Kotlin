package app.frantic.rxjavamvpkotlin.network

import app.frantic.rxjavamvpkotlin.model.Flower
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET

interface RequestAPI {

    @GET("feeds/flowers.json")
    fun getFlowerList(): Observable<List<Flower>>
}