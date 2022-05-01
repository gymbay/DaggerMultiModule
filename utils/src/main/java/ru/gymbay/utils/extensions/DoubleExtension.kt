package ru.gymbay.utils.extensions

import java.text.DecimalFormat

fun Double.formatToString(): String {
    val formatter = DecimalFormat()
    formatter.decimalFormatSymbols.apply {
        groupingSeparator = ','
        decimalSeparator = '.'
    }
    return formatter.format(this)
}