package com.pvasilev.uplabs.following

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FollowingArgs(val nickname: String) : Parcelable