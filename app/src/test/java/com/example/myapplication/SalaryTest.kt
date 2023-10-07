package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

class SalaryTest {

    @Test
    fun `calculate salary with only normal hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 10F,
            0F,
            0F,
            0F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1000F, totalSalary)
    }

    @Test
    fun `calculate salary with only fifty percent hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 0F,
            10F,
            0F,
            0F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(1500F, totalSalary)
    }

    @Test
    fun `calculate salary with only hundred percent hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 0F,
            0F,
            10F,
            0F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2000F, totalSalary)
    }

    @Test
    fun `calculate salary with only one fifty percent hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 0F,
            0F,
            0F,
            10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(2500F, totalSalary)
    }

    @Test
    fun `calculate salary with all types of hours`() {
        val salary = Salary(
            baseSalary = 100F,
            normalHours = 10F,
            10F,
            10F,
            10F,
        )

        val totalSalary = salary.calculateTotalSalary()

        assertEquals(7000F, totalSalary)
    }
}