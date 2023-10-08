package com.example.myapplication

data class Salary(
    var hourlyWage: Float = 0F,
    var tax: Float? = null,
    var weekendWage: Float = 0F,
    var nightWage: Float = 0F,
    var workTimeRecords: MutableList<WorkTimeRecord> = mutableListOf()
) {
    fun calculateTotalSalary(): Float {
        var total = 0F

        for (workTimeRecord in workTimeRecords) {
            var bonus = workTimeRecord.bonusInPercent

            bonus = if (bonus != null) {
                (bonus + 100) / 100
            } else {
                1F
            }

            total += workTimeRecord.hours * (bonus) * hourlyWage + (workTimeRecord.weekendHours * weekendWage) + (workTimeRecord.nightHours * nightWage)
        }

        if (tax != null) {
            return total * ((100 - tax!!) / 100)
        }

        return total
    }
}