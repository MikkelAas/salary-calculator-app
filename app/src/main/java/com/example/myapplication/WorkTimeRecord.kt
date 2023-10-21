package com.example.myapplication

data class WorkTimeRecord(
    var hours: Float = 0F,
    var bonusInPercent: Float? = null,
    var weekendHours: Float = 0F,
    var nightHours: Float = 0F
) {
    init {
        require(
            weekendHours + nightHours <= hours
        )
    }
}
