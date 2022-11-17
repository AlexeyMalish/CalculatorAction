package com.appprivatestudio.calculator.core.actions

import java.math.BigDecimal
import kotlin.math.pow

object PowerAction : BaseAction {
    override fun apply(leftOperand: BigDecimal, rightOperand: BigDecimal): BigDecimal {
        return leftOperand.toDouble().pow(rightOperand.toDouble())
            .toBigDecimal()
            .stripTrailingZeros()
    }

    override fun defaultValue() = 1.toBigDecimal()
}