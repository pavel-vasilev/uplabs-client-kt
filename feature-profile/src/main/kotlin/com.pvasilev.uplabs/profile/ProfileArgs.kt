package com.pvasilev.uplabs.profile

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProfileArgs(val nickname: String) : Parcelable