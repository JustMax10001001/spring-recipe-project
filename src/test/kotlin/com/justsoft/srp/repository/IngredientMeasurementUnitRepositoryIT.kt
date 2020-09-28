package com.justsoft.srp.repository

import com.justsoft.srp.repostitory.IngredientMeasurementUnitRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.context.junit4.SpringRunner

@ExtendWith(SpringExtension::class)
@SpringBootTest
class IngredientMeasurementUnitRepositoryIT {

    @Autowired
    lateinit var ingredientMeasurementUnitRepository: IngredientMeasurementUnitRepository

    @Test
    fun test_findByName() {
        val teaspoon = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("teaspoon")

        assertNotNull(teaspoon)
        assertEquals("Teaspoon", teaspoon?.unitName)
    }
}