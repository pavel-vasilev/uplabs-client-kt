package com.pvasilev.uplabs.models

enum class Tool(val label: String, val value: String) {
    Figma("Figma", "figma"),
    InDesign("InDesign", "indesign"),
    InVision("InVision Studio", "invision"),
    Photoshop("Photoshop", "photoshop"),
    Principle("Principle", "principle"),
    Sketch("Sketch", "sketch"),
    AdobeXD("Adobe XD", "xd");

    override fun toString() = label
}