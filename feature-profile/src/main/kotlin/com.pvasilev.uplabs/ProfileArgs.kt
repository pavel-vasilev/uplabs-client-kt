package com.pvasilev.uplabs

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileArgs(val nickname: String) : Parcelable