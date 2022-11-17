package com.appprivatestudio.calculator.core.actions

import java.math.BigDecimal
import java.math.RoundingMode

object DivideAction : BaseAction {
    override fun apply(leftOperand: BigDecimal, rightOperand: BigDecimal): BigDecimal {
        return leftOperand.divide(rightOperand, 15, RoundingMode.HALF_UP)
            .stripTrailingZeros()
            .toPlainString()
            .toBigDecimal()
    }
    override fun defaultValue() = 1.toBigDecimal()
}