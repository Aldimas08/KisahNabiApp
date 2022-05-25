package com.aldimas.kisahnabiapp.data.network

import com.aldimas.kisahnabiapp.data.KisahResponse
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET


//apiservice tidak bisa berdiri sndri memerlukan apiclient
interface ApiService {

    @GET("kisahnabi")
    fun getKisahNabi() : Flowable<List<KisahResponse>>
}
