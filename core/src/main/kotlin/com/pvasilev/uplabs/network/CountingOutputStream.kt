package com.pvasilev.uplabs.network

import java.io.OutputStream

open class CountingOutputStream(private val outputStream: OutputStream) : OutputStream() {
    var count: Int = 0
        private set

    override fun write(byte: Int) {
        outputStream.write(byte)
        count += 1
    }

    override fun write(bytes: ByteArray) {
        outputStream.write(bytes)
        count += bytes.size
    }

    override fun write(bytes: ByteArray, offset: Int, length: Int) {
        outputStream.write(bytes, offset, length)
        count += length
    }
}