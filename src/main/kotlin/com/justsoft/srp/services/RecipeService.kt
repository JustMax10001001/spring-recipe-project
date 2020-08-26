package com.justsoft.srp.services

import com.justsoft.srp.model.Recipe

interface RecipeService {

    fun getRecipes(): Set<Recipe>
}