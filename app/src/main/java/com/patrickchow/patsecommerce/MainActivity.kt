package com.patrickchow.patsecommerce

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.patrickchow.patsecommerce.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.title= "Clothing"

        // Makes the burger on the top left of toolbar
        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.open_drawer, R.string.close_drawer)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        //Sets click listener to the navigation
        nav_view.setNavigationItemSelectedListener {
            it.isChecked = true
            when(it.itemId){
                R.id.clothes_shirts -> {
                    Toast.makeText(this, "Shirts", Toast.LENGTH_SHORT).show()
                }

                R.id.clothes_jeans ->{
                    supportFragmentManager.beginTransaction().replace(R.id.frame_layout_fragment, JeansFragment()).commit()
                    Toast.makeText(this, "Jeans", Toast.LENGTH_SHORT).show()
                }

                R.id.cloths_pants -> {
                    Toast.makeText(this, "Pants", Toast.LENGTH_SHORT).show()
                }
            }
            drawer_layout.closeDrawers()
            true
        }

//        supportActionBar?.apply {
//            setDisplayHomeAsUpEnabled(true)
//        }

        val products = arrayListOf<Product>()

        for (i in 0..100){
            products.add(Product("Dress Shirt #$i", "https://images.unsplash.com/photo-1508138221679-760a23a2285b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&w=1000&q=80", 1.99))
        }

        rv_items.apply{
            layoutManager = GridLayoutManager(this@MainActivity, 2)
            adapter = ProductsAdapter(products)
        }
    }

    // Inflates the menu_sign and place it to the top right
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_sign, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Gives the item selected functionality
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.sign_in -> {
                Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show()
            }
            R.id.sign_out -> {
                Toast.makeText(this, "Signed Out", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}

