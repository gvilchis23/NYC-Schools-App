package com.schools.data

import com.google.gson.annotations.SerializedName

data class GsonSchoolsResponse (
    @SerializedName("dbn")
    val dbn : String? = null,
    @SerializedName("school_name")
    val schoolName: String? = null,
    @SerializedName("boro")
    val boro : String? = null,
    @SerializedName("overview_paragraph")
    val overviewParagraph: String? = null,
    @SerializedName("phone_number")
    val phoneNumber: String? = null,
    @SerializedName("school_email")
    val schoolEmail : String? = null,
    @SerializedName("website" )
    val website: String? = null
)

fun GsonSchoolsResponse.asSchools(): Schools {
    return Schools (
        dbn = dbn,
        schoolName = schoolName,
        boro = boro,
        overviewParagraph = overviewParagraph,
        phoneNumber = phoneNumber,
        schoolEmail = schoolEmail,
        website = website
    )
}