package com.schools.data

import com.google.gson.annotations.SerializedName

data class GsonSATResponse (
    @SerializedName("dbn")
    val dbn : String? = null,
    @SerializedName("school_name")
    val schoolName: String? = null,
    @SerializedName("num_of_sat_test_takers")
    val numSatTestTakers : String? = null,
    @SerializedName("sat_critical_reading_avg_score")
    val satAverageReading: String? = null,
    @SerializedName("sat_math_avg_score")
    val satMathAvg: String? = null,
    @SerializedName("sat_writing_avg_score")
    val satWritingAvg : String? = null,

)

fun GsonSATResponse.asSatScores(): SatScores {
    return SatScores (
        dbn = dbn,
        schoolName = schoolName,
        numSatTestTakers = numSatTestTakers,
        satAverageReading = satAverageReading,
        satMathAvg = satMathAvg,
        satWritingAvg = satWritingAvg
    )
}