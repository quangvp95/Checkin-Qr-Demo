package com.coccoc.checkin.network

import com.coccoc.checkin.model.HistoryResponse
import com.coccoc.checkin.model.QrResult
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

const val BASE_URL = "https://checkin.coccoc.io/"
const val CHECK_IN_SESSION_SUBMIT: String = "checkin_session_submit"
const val CHECK_IN_HISTORY: String = "checkin_history"

interface ApiService {
    @GET(CHECK_IN_HISTORY)
    fun getCheckInHistory(): Observable<HistoryResponse>

    @POST(CHECK_IN_SESSION_SUBMIT)
    fun checkin(@Body action: QrResult?): Call<Void>

    companion object {
//        private val logging: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
//        private val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(logging).build()

        fun create(): ApiService {
            val retrofit = Retrofit.Builder()
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
//                .client(client)
                .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}