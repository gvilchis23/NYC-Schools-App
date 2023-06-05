package com.schools.repository

import com.schools.data.GsonSATResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.schools.data.GsonSchoolsResponse
import com.schools.repository.remote.retrofitgson.RetrofitGsonSchoolsService


class MainRepository(
    private val retrofitGsonWebService: RetrofitGsonSchoolsService
) {

    companion object {
        const val BASE_URL = "https://data.cityofnewyork.us/"
    }


    suspend fun getRetrofitGsonSchools(): List<GsonSchoolsResponse> = withContext(Dispatchers.IO) {
        retrofitGsonWebService.fetchSchools()
        return@withContext retrofitGsonWebService.fetchSchools()
    }

    suspend fun getRetrofitGsonSatScores(): List<GsonSATResponse> = withContext(Dispatchers.IO) {
        retrofitGsonWebService.fetchSatScores()
        return@withContext retrofitGsonWebService.fetchSatScores()
    }
}