package com.justsoft.srp.repostitory

import com.justsoft.srp.model.Recipe
import org.springframework.data.repository.CrudRepository

interface RecipeRepository: CrudRepository<Recipe, Long>