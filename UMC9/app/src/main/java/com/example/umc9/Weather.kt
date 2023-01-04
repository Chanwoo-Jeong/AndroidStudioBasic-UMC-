package com.example.umc9

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Weather (
    @SerializedName("id") var id: Int = 0,
    @SerializedName("main") var main : String? ,
    @SerializedName("description") var description: String? ,
    @SerializedName("icon") var icon : String?
) : Serializable {

}




