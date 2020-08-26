package com.justsoft.srp.repostitory

import com.justsoft.srp.model.RecipeCategory
import org.springframework.data.repository.CrudRepository
import java.util.*

interface RecipeCategoryRepository: CrudRepository<RecipeCategory, Long> {

    fun findByName(name: String): RecipeCategory?

    fun findByNameIgnoreCase(name: String): RecipeCategory?
}