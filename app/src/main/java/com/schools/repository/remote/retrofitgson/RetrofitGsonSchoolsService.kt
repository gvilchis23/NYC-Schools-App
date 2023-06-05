package com.schools.repository.remote.retrofitgson

import com.schools.data.GsonSATResponse
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.schools.data.GsonSchoolsResponse
import com.schools.repository.MainRepository

class RetrofitGsonSchoolsService {

    private val api: RetrofitGsonSchoolsApi by lazy {
        createSchoolsApi()
    }

    //suspend is for coroutines
    suspend fun fetchSchools(): List<GsonSchoolsResponse> {
        return api.fetchSchools()
    }

    //suspend is for coroutines
    suspend fun fetchSatScores(): List<GsonSATResponse> {
        return api.fetchSatScores()
    }

    private fun createSchoolsApi(): RetrofitGsonSchoolsApi {

        val gsonConverterFactory = GsonConverterFactory.create()

        val retrofit = Retrofit.Builder()
            .baseUrl(MainRepository.BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .build()

        return retrofit.create(RetrofitGsonSchoolsApi::class.java)
    }
}