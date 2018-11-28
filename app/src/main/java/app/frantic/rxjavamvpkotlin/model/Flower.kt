package app.frantic.rxjavamvpkotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class Flower {
    var category: String? = null
    var price: Double = 0.toDouble()
    var instructions: String? = null
    var photo: String? = null
    var name: String? = null
    var productId: Int = 0
}