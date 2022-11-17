package com.appprivatestudio.calculator.core.actions

import java.math.BigDecimal

object SubstructAction : BaseAction {
    override fun apply(leftOperand: BigDecimal, rightOperand: BigDecimal): BigDecimal {
        return leftOperand.subtract(rightOperand)
    }
    override fun defaultValue() = 0.toBigDecimal()
}