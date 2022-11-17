package com.appprivatestudio.calculator.core.actions

import java.math.BigDecimal


interface BaseAction {
    @Throws(RuntimeException::class)
    fun apply(leftOperand: BigDecimal, rightOperand: BigDecimal): BigDecimal
    fun defaultValue(): BigDecimal
}