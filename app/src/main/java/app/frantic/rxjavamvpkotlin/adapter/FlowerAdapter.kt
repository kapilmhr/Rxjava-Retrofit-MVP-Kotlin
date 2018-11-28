package app.frantic.rxjavamvpkotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.frantic.rxjavamvpkotlin.R
import app.frantic.rxjavamvpkotlin.model.Flower
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.layout_flower_item.view.*

class FlowerAdapter(var flowerList:List<Flower>) : RecyclerView.Adapter<FlowerAdapter.MyHolder>() {
    var context:Context?= null
    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): MyHolder {
        context = parent!!.context
        var view: View = LayoutInflater.from(context).inflate(R.layout.layout_flower_item, parent, false)
        return MyHolder(view)
    }

    override fun getItemCount(): Int {
        return flowerList.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val flower = flowerList.get(position)
        holder.name.text = flower.name
        holder.price.text = "Price: $${flower.price}"
        holder.category.text = "Category: ${flower.category}"
        Glide.with(context!!).load("http://services.hanselandpetal.com/photos/${flower.photo}").into(holder.image)
    }

    class MyHolder(itemView:View) :RecyclerView.ViewHolder(itemView){
        val name = itemView.name
        val price = itemView.price
        val category = itemView.category
        val image = itemView.imageView

    }
}