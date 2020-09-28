package com.justsoft.srp.repostitory

import com.justsoft.srp.model.IngredientMeasurementUnit
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface IngredientMeasurementUnitRepository: CrudRepository<IngredientMeasurementUnit, Long> {

    fun findByUnitName(unitName: String): IngredientMeasurementUnit?

    fun findByUnitNameIgnoreCase(unitName: String): IngredientMeasurementUnit?
}