package com.example.myapplication

data class Salary(
    var baseSalary: Float = 0F,
    var tax: Float? = null,
    var normalHours: Float = 0F,
    var fiftyPercentHours: Float = 0F,
    var hundredPercentHours: Float = 0F,
    var oneFiftyPercentHours: Float = 0F,
) {

    fun calculateTotalSalary(): Float {
        val normalSalaryTotal = calculateNormalSalary()

        val bonusSalaryTotal = calculateTotalBonus()

        val totalSalaryBeforeTax = normalSalaryTotal + bonusSalaryTotal

        if (tax != null) {
            return totalSalaryBeforeTax * (tax!! / 100)
        }

        return totalSalaryBeforeTax
    }

    private fun calculateNormalSalary(): Float {
        return baseSalary * normalHours
    }

    private fun calculateTotalBonus(): Float {
        return (
                calculateBonusSalary(fiftyPercentHours, BonusPercent.FIFTY) +
                        calculateBonusSalary(hundredPercentHours, BonusPercent.HUNDRED) +
                        calculateBonusSalary(oneFiftyPercentHours, BonusPercent.ONE_FIFTY)
                )
    }

    private fun calculateBonusSalary(
        bonusPercentHours: Float,
        bonusPercent: BonusPercent
    ): Float {
        return bonusPercentHours * (bonusPercent.value * baseSalary)
    }
}

enum class BonusPercent(val value: Float) {
    FIFTY(1.5F),
    HUNDRED(2F),
    ONE_FIFTY(2.5F)
}
