package com.pvasilev.uplabs.network

import com.pvasilev.uplabs.models.Post
import okhttp3.MediaType
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.http.GET
import java.lang.reflect.Type

class PostConverter(private val delegate: Converter<ResponseBody, Post>) : Converter<ResponseBody, Post> {
    override fun convert(value: ResponseBody): Post? {
        val selector = Post::class.java.getAnnotation(Selector::class.java)
        val body = Jsoup.parse(value.string())
            .select(selector.value)
            .attr(selector.attr)
        return delegate.convert(ResponseBody.create(MediaType.parse("application/json"), body))
    }

    companion object Factory : Converter.Factory() {
        override fun responseBodyConverter(
            type: Type,
            annotations: Array<Annotation>,
            retrofit: Retrofit
        ): Converter<ResponseBody, *>? {
            val annotation = annotations.mapNotNull { it as? GET }.firstOrNull()
            val delegate = retrofit.nextResponseBodyConverter<Post>(this, type, annotations)
            return if (annotation != null && annotation.value.isEmpty()) {
                PostConverter(delegate)
            } else {
                delegate
            }
        }
    }
}