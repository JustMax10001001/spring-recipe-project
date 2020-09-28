package com.justsoft.srp.controller

import com.justsoft.srp.model.Recipe
import com.justsoft.srp.services.RecipeService
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.mockito.ArgumentCaptor
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.springframework.ui.Model

internal class IndexControllerTest {

    @Mock
    private lateinit var recipeService: RecipeService

    private lateinit var indexController: IndexController

    @BeforeEach
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        indexController = IndexController(recipeService)
    }

    @Test
    fun indexPage() {
        val model = mock(Model::class.java)
        val recipe = mock(Recipe::class.java)
        val set = setOf(recipe)

        val attrs = mutableMapOf<String, Any?>()
        val stringCaptor = ArgumentCaptor.forClass(String::class.java)
        val anyCaptor = ArgumentCaptor.forClass(Any::class.java)
        `when`(model.getAttribute(stringCaptor.capture())).thenAnswer { attrs[stringCaptor.value] }
        `when`(model.addAttribute(stringCaptor.capture(), anyCaptor.capture())).thenAnswer {
            val obj = anyCaptor.value
            attrs[stringCaptor.value] = obj
            model
        }

        `when`(recipeService.getRecipes()).thenReturn(set)

        assertEquals("index", indexController.indexPage(model))
        assertEquals(set, model.getAttribute("recipes"))
    }
}