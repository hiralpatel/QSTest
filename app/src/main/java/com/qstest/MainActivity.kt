package com.qstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import com.google.firebase.database.*
import com.qstest.model.Product

import java.lang.Exception


class MainActivity : AppCompatActivity() {
    private val allProduct: ArrayList<Product> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        getValues("-M4nT_Qdig3KKwi2vuWi")
        getValues("-M4nFFLU8piQPRZ9LE0o")
        getValues("-M3aFvVkId616SAaT3pj")
        getValues("-M3PbvM3nriWxrN1WRCs")
        getValues("-M3PSNonubQkS9932TqB")
        getValues("-M3MLWxNW4okVXlB9jKY")

        Handler().postDelayed(Runnable {
            println("result $allProduct")
        }, 15000)
    }

    private fun getValues(ID: String) {
        allProduct.add(Product(ID, "", "", "", ""))
        val database = FirebaseDatabase.getInstance()
        val refDB = database.reference
        getVal(refDB, ID, "product-name")
        getVal(refDB, ID, "product-desc")
        getVal(refDB, ID, "product-image")
        getVal(refDB, ID, "product-price")
    }

    private fun getVal(refDB: DatabaseReference, ID: String, key: String) {
        refDB.child(key).child(ID)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    try {
                        if (snapshot.value != null) {
                            try {
                                Log.e(
                                    "TAG",
                                    "" + snapshot.value
                                ) // your name values you will get here
                                if (key == "product-name")
                                    allProduct.find { it.id == ID }?.name = snapshot.value?.toString()
                                if (key == "product-desc")
                                    allProduct.find { it.id == ID }?.desc= snapshot.value?.toString()
                                if (key == "product-image")
                                    allProduct.find { it.id == ID }?.img = snapshot.value?.toString()
                                if (key == "product-price")
                                    allProduct.find { it.id == ID }?.price = snapshot.value?.toString()
                            } catch (e: Exception) {
                                e.printStackTrace()
                            }
                        } else {
                            Log.e("TAG", " it's null.")
                        }
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }

                override fun onCancelled(p0: DatabaseError) {
                    Log.e("onCancelled", " cancelled")
                }
            })
    }
}