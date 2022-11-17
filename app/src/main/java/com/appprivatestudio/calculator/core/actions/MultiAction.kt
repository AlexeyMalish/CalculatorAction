package com.appprivatestudio.calculator.core.actions

import java.math.BigDecimal

object MultiAction : BaseAction {
    override fun apply(leftOperand: BigDecimal, rightOperand: BigDecimal): BigDecimal {
        return leftOperand.multiply(rightOperand)
    }

    override fun defaultValue() = 1.toBigDecimal()
}