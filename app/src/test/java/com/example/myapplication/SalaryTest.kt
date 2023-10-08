package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

class SalaryTest {

    @Test
    fun `calculate salary with only one set of normal hours`() {
        val workTimeRecords = mutableListOf(
            WorkTimeRecord(
                hours = 10F
            )
        )

        val salary = Salary(
            hourlyWage = 100F,
            workTimeRecords = workTimeRecords
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1000F, totalSalary)
    }

    @Test
    fun `calculate salary with two sets of normal hours`() {
        val workTimeRecords = mutableListOf(
            WorkTimeRecord(
                hours = 10F
            ),
            WorkTimeRecord(10F)
        )

        val salary = Salary(
            hourlyWage = 100F,
            workTimeRecords = workTimeRecords
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2000F, totalSalary)
    }

    @Test
    fun `calculate salary with bonus hours`() {
        val workTimeRecords = mutableListOf(
            WorkTimeRecord(
                hours = 10F,
                bonusInPercent = 30F
            ),
            WorkTimeRecord(
                hours = 5F,
                bonusInPercent = 50F
            )
        )

        val salary = Salary(
            hourlyWage = 100F,
            workTimeRecords = workTimeRecords
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2050F, totalSalary)
    }

    @Test
    fun `calculate salary with bonus hours and weekend bonus`() {
        val workTimeRecords = mutableListOf(
            WorkTimeRecord(
                hours = 10F,
                bonusInPercent = 50F,
                weekendHours = 5F
            ),
        )

        val salary = Salary(
            hourlyWage = 100F,
            workTimeRecords = workTimeRecords,
            weekendWage = 100F
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2000F, totalSalary)
    }

    @Test
    fun `calculate with everything`() {
        val workTimeRecords = mutableListOf(
            WorkTimeRecord(
                hours = 7F,
                bonusInPercent = 50F,
                weekendHours = 4F,
                nightHours = 3F
            ),
        )

        val salary = Salary(
            hourlyWage = 100F,
            tax = 30F,
            workTimeRecords = workTimeRecords,
            weekendWage = 100F,
            nightWage = 50F
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1120F, totalSalary)
    }

    @Test
    fun `calculate before tax`() {
        val workTimeRecords = mutableListOf(
            WorkTimeRecord(
                hours = 7F,
                bonusInPercent = 50F,
                weekendHours = 4F,
                nightHours = 3F
            ),
        )

        val salary = Salary(
            hourlyWage = 100F,
            workTimeRecords = workTimeRecords,
            weekendWage = 100F,
            nightWage = 50F
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1600F, totalSalary)
    }
}