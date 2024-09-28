package com.vereshchagin.nikolay.core_ui.presentation

object WordDeclension {

    fun normalizeType(number: Int): DeclensionType {
        val normNumber = number % 10
        if (number in 11..19) {
            return DeclensionType.Third
        }
        if (normNumber in 2..4) {
            return DeclensionType.Second
        }
        if (normNumber == 1) {
            return DeclensionType.First
        }
        return DeclensionType.Third
    }

    enum class DeclensionType {
        First,
        Second,
        Third
    }
}