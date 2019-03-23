package com.pvasilev.uplabs.network

import com.pvasilev.uplabs.models.Post
import com.serjltt.moshi.adapters.Wrapped
import io.reactivex.Completable
import io.reactivex.Observable
import retrofit2.http.*

interface PostService {
    @POST("posts")
    @FormUrlEncoded
    fun create(
        @Field("authenticity_token") token: String,
        @Field("post[name]") name: String,
        @Field("post[description]") description: String,
        @Field("post[category_id]") category: Int,
        @Field("post[subcategory_id]") subcategory: Int,
        @Field("post[free_post]") isFree: Int,
        @Field("post[paid_post]") isPaid: Int,
        @Field("post[tools]") tools: String,
        @Field("post[source_file_url]") sourceUrl: String,
        @Field("post[custom_preview_url]") previewUrl: String,
        @Field("post[source_name]") sourceName: String = "image_url",
        @Field("post[source_format]") sourceFormat: String = "standard",
        @Field("post[section]") section: String = "showcase",
        @Field("post[extra_info]") extraInfo: String = "{}",
        @Field("post[payload]") payload: String = "{}",
        @Field("post[showcase_later]") showcaseLater: Int = 0
    ): Completable

    @Wrapped(path = ["post"])
    @GET("posts/{link}")
    fun getPost(@Path("link") link: String): Observable<Post>
}