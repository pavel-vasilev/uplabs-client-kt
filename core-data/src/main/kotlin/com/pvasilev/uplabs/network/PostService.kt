package com.pvasilev.uplabs.network

import io.reactivex.Completable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

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
}