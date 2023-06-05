package com.schools.repository.remote.retrofitgson

import com.schools.data.GsonSATResponse
import retrofit2.http.GET
import com.schools.data.GsonSchoolsResponse

interface RetrofitGsonSchoolsApi {
    @GET("resource/s3k6-pzi2.json")
    suspend fun fetchSchools(): List<GsonSchoolsResponse>
    @GET("resource/f9bf-2cp4.json")
    suspend fun fetchSatScores(): List<GsonSATResponse>
}