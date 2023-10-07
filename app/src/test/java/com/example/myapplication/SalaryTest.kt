package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

class SalaryTest {

    @Test
    fun `calculate salary with only normal hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1000F, totalSalary)
    }

    @Test
    fun `calculate salary with only fifty percent hours`() {
        val salary = Salary(
            baseSalary = 100F,
            fiftyPercentHours = 10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1500F, totalSalary)
    }

    @Test
    fun `calculate salary with only hundred percent hours`() {
        val salary = Salary(
            baseSalary = 100F,
            hundredPercentHours = 10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2000F, totalSalary)
    }

    @Test
    fun `calculate salary with only one fifty percent hours`() {
        val salary = Salary(
            baseSalary = 100F,
            oneFiftyPercentHours = 10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2500F, totalSalary)
    }

    @Test
    fun `calculate salary with all types of hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 10F,
            fiftyPercentHours = 10F,
            hundredPercentHours = 10F,
            oneFiftyPercentHours = 10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(7000F, totalSalary)
    }

    @Test
    fun `calculate salary after tax`() {
        val salary = Salary(
            baseSalary = 100F,
            tax = 10F,
            normalHours = 10F,
            fiftyPercentHours = 10F,
            hundredPercentHours = 10F,
            oneFiftyPercentHours = 10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(6300F, totalSalary)
    }
}