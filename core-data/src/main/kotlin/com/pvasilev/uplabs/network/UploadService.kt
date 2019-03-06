package com.pvasilev.uplabs.network

import com.pvasilev.uplabs.models.SignedUrl
import io.reactivex.Completable
import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*

interface UploadService {
    @GET("uploads/signing_url")
    fun getSigningUrl(
        @Query("objectName") objectName: String,
        @Query("contentType") contentType: String
    ): Observable<SignedUrl>

    @PUT
    @Headers("x-amz-acl: public-read")
    fun upload(
        @Url signedUrl: String,
        @Header("Content-Type") contentType: String,
        @Body body: RequestBody
    ): Completable
}