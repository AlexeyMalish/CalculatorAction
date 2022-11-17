package com.appprivatestudio.calculator.core

import com.appprivatestudio.calculator.core.actions.*
import com.appprivatestudio.calculator.core.exception.CalculateException


class CalculatorCore {

    var result = "0"
    var operator: Char? = '+'
    var isInInvalidState = false

    fun calculate(value: String): String {
        val operation = when (operator) {
            '+' -> AddAction
            '-' -> SubstructAction
            '*' -> MultiAction
            '/' -> DivideAction
            '^' -> PowerAction
            else -> throw CalculateException()
        }

        val rightHandSideValue = if (value.isEmpty()) {
            operation.defaultValue()
        } else {
            value.toBigDecimal()
        }

        result = try {
            operation.apply(result.toBigDecimal(), rightHandSideValue).toString()
        } catch (e: Exception) {
            isInInvalidState = true
            "Err"
        }
        return result
    }

    fun clear() {
        operator = '+'
        result = "0"
        isInInvalidState = false
    }
}