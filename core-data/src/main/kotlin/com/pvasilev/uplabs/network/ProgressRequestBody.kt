package com.pvasilev.uplabs.network

import okhttp3.MediaType
import okhttp3.RequestBody
import okio.BufferedSink
import okio.Okio

class ProgressRequestBody(
    private val requestBody: RequestBody,
    private val onProgressChangeListener: OnProgressChangeListener
) : RequestBody() {
    override fun contentType(): MediaType? = requestBody.contentType()

    override fun contentLength(): Long = requestBody.contentLength()

    override fun writeTo(sink: BufferedSink) {
        val outputStream = object : CountingOutputStream(sink.outputStream()) {
            override fun write(byte: Int) {
                super.write(byte)
                onProgressChangeListener.onProgressChanged(count.toFloat() / contentLength())
            }

            override fun write(bytes: ByteArray) {
                super.write(bytes)
                onProgressChangeListener.onProgressChanged(count.toFloat() / contentLength())
            }

            override fun write(bytes: ByteArray, offset: Int, length: Int) {
                super.write(bytes, offset, length)
                onProgressChangeListener.onProgressChanged(count.toFloat() / contentLength())
            }
        }
        val outerSink = Okio.buffer(Okio.sink(outputStream))
        requestBody.writeTo(outerSink)
        outerSink.flush()
    }

    interface OnProgressChangeListener {
        fun onProgressChanged(percent: Float)
    }
}