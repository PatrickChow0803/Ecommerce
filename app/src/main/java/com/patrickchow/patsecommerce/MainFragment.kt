package com.patrickchow.patsecommerce

import android.app.ListActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.patrickchow.patsecommerce.model.Product
import com.patrickchow.patsecommerce.networking.ServiceMaker
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)

        var products = listOf<Product>()


        val call: Call<List<Product>> = ServiceMaker.create().getClothes()

        call.enqueue(object: Callback<List<Product>> {
            override fun onFailure(call: Call<List<Product>>, t: Throwable) {
                Log.i("onFailure", t?.message)
            }

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
//                products.add(Product(response.body()?.get(0)?.title,
//                                     response.body()?.get(0)?.photoUrl,
//                                     response.body()?.get(0)?.price))

                products = response.body()!!


                root.rv_items.apply{
                    layoutManager = GridLayoutManager(activity, 2)
                    adapter = ProductsAdapter(products)
                }
            }
        })


        return root
    }
}