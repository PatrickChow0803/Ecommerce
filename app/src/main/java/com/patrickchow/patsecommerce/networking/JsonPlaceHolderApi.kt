package com.patrickchow.patsecommerce.networking

import com.patrickchow.patsecommerce.model.Product
import retrofit2.Call
import retrofit2.http.GET

interface JsonPlaceHolderApi {
    companion object{
        val BASE_URL = "https://finepointmobile.com/data/"
    }

    @GET("products.json")
    fun getClothes(): Call<List<Product>>
}

/*

    Example output

[
  {
    "name": "Small Jeans",
    "photo_url": "https://finepointmobile.com/data/jeans1.jpg",
    "description": "This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? ",
    "price": 29.49,
    "isOnSale": true
  },
  {
    "name": "Black Shirt",
    "photo_url": "https://finepointmobile.com/data/jeans2.jpg",
    "description": "This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? ",
    "price": 19.49,
    "isOnSale": false
  },
  {
    "name": "Red Jeans",
    "photo_url": "https://finepointmobile.com/data/jeans3.jpg",
    "description": "This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? This is a nice description. got it? ",
    "price": 24.49,
    "isOnSale": false
  },
 */