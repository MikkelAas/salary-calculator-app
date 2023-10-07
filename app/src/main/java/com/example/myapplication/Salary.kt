package com.example.myapplication

data class Salary(
    var baseSalary: Float,
    var normalHours: Float,
    var fiftyPercentHours: Float,
    var hundredPercentHours: Float,
    var oneFiftyPercentHours: Float,
) {

    fun calculateTotalSalary(): Float {
        val normalSalaryTotal = calculateNormalSalary()

        val bonusSalaryTotal = calculateTotalBonus()

        return normalSalaryTotal + bonusSalaryTotal
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
