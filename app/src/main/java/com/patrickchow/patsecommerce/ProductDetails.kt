package com.patrickchow.patsecommerce

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.product_details.*

class ProductDetails : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_details)

        val title = intent.getStringExtra("title")
        tv_title_details.text = title

        //Creates an alert dialog
        btn_availability.setOnClickListener {
            AlertDialog.Builder(this)
                .setMessage("$title is in stock!")

                //Gives the dialog an OK text.  You can alt+enter convert to lambda but I'll be keeping it like this just incase.
                .setPositiveButton("OK", object:DialogInterface.OnClickListener{
                    override fun onClick(p0: DialogInterface?, p1: Int) {

                    }

                })
                .create()
                .show()
        }
    }
}