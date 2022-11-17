package com.appprivatestudio.calculator.core.actions

import java.math.BigDecimal

object AddAction : BaseAction {
    override fun apply(leftOperand: BigDecimal, rightOperand: BigDecimal): BigDecimal {
        return leftOperand.add(rightOperand)
    }
    override fun defaultValue() = 0.toBigDecimal()
}