package com.justsoft.srp.services

import com.justsoft.srp.dsl.recipe
import com.justsoft.srp.model.Recipe
import com.justsoft.srp.repostitory.RecipeRepository
import org.aspectj.lang.annotation.Before
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.times
import org.mockito.Mockito.verify
import org.mockito.MockitoAnnotations

internal class RecipeServiceImplTest {
    private lateinit var recipeServiceImpl: RecipeServiceImpl

    @Mock
    private lateinit var recipeRepository: RecipeRepository

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        recipeServiceImpl = RecipeServiceImpl(recipeRepository)
    }

    @Test
    fun getRecipes() {
        val recipe = Mockito.mock(Recipe::class.java)
        val set = setOf(recipe)

        Mockito.`when`(recipeServiceImpl.getRecipes()).thenReturn(set)

        val recipes = recipeServiceImpl.getRecipes()

        assertEquals(1, recipes.count()) { "Recipes list is empty" }
        verify(recipeRepository, times(1)).findAll()
    }
}