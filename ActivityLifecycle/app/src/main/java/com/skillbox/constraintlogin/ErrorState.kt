package com.skillbox.constraintlogin

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ErrorState(
    var error: String
): Parcelable {

    fun changeText(text: String): String {
        error = text
        return error
    }
}
