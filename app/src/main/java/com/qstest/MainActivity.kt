package com.qstest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.*
import com.qstest.model.Product

import java.lang.Exception


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    fun init() {
        getValues("-M4nT_Qdig3KKwi2vuWi")
    }

    private fun getValues(ID: String) {
        val database = FirebaseDatabase.getInstance()
        val refDB = database.reference
//        val ob = Product(
//            getVal(refDB, ID, "product-name"), getVal(refDB, ID, "product-desc"),
//            getVal(refDB, ID, "product-image"), getVal(refDB, ID, "product-price")
//        )
//        println("obj: ${ob.name}  ${ob.price} ${ob.desc}  ${ob.img}  ")
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