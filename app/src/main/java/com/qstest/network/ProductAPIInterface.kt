package com.qstest.network

import com.qstest.model.AllProductsIDs
import retrofit2.Response
import retrofit2.http.*

interface ProductAPIInterface {
    @GET("product-ids")
    suspend fun getProductsIDs(): Response<AllProductsIDs>
}