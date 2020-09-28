package com.justsoft.srp.repository

import com.justsoft.srp.repostitory.IngredientMeasurementUnitRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
class IngredientMeasurementUnitRepositoryIT {

    @Autowired
    lateinit var ingredientMeasurementUnitRepository: IngredientMeasurementUnitRepository

    @Test
    fun test_findTeaspoonByName() {
        val teaspoon = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("teaspoon")

        assertNotNull(teaspoon)
        assertEquals("Teaspoon", teaspoon?.unitName)
    }

    @Test
    fun test_findCupByName(){
        val cup = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("cup")

        assertNotNull(cup)
        assertEquals("Cup", cup?.unitName)
    }
}