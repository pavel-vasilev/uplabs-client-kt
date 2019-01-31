package com.pvasilev.uplabs.followers

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class FollowersArgs(val nickname: String) : Parcelable