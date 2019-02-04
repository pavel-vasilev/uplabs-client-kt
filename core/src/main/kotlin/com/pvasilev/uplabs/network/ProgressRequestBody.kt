package com.pvasilev.uplabs.network

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink
import okio.Okio

class ProgressRequestBody(private val requestBody: RequestBody, private val callback: (Float) -> Unit) : RequestBody() {
    override fun contentType(): MediaType? = requestBody.contentType()

    override fun contentLength(): Long = requestBody.contentLength()

    override fun writeTo(sink: BufferedSink) {
        val outputStream = object : CountingOutputStream(sink.outputStream()) {
            override fun write(byte: Int) {
                super.write(byte)
                callback(count.toFloat() / contentLength())
            }

            override fun write(bytes: ByteArray) {
                super.write(bytes)
                callback(count.toFloat() / contentLength())
            }

            override fun write(bytes: ByteArray, offset: Int, length: Int) {
                super.write(bytes, offset, length)
                callback(count.toFloat() / contentLength())
            }
        }
        val outerSink = Okio.buffer(Okio.sink(outputStream))
        requestBody.writeTo(outerSink)
        outerSink.flush()
    }
}