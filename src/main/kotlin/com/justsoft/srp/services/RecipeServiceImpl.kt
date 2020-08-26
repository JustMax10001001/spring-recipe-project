package com.justsoft.srp.services

import com.justsoft.srp.model.Recipe
import com.justsoft.srp.repostitory.RecipeRepository
import org.springframework.stereotype.Service

@Service
class RecipeServiceImpl(
        private val recipeRepository: RecipeRepository
) : RecipeService {

    override fun getRecipes(): Set<Recipe> =
            HashSet<Recipe>().apply {
                addAll(recipeRepository.findAll())
            }
}