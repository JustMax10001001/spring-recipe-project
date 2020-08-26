package com.justsoft.srp.repostitory

import com.justsoft.srp.model.IngredientMeasurementUnit
import org.springframework.data.repository.CrudRepository
import java.util.*

interface IngredientMeasurementUnitRepository: CrudRepository<IngredientMeasurementUnit, Long> {

    fun findByUnitName(unitName: String): IngredientMeasurementUnit?

    fun findByUnitNameIgnoreCase(unitName: String): IngredientMeasurementUnit?
}