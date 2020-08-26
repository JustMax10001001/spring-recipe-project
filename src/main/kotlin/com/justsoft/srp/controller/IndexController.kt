package com.justsoft.srp.controller

import com.justsoft.srp.model.RecipeCategory
import com.justsoft.srp.repostitory.IngredientMeasurementUnitRepository
import com.justsoft.srp.repostitory.RecipeCategoryRepository
import com.justsoft.srp.repostitory.RecipeRepository
import com.justsoft.srp.services.RecipeService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class IndexController(
        private val recipeService: RecipeService
) {

    @RequestMapping("/", "", "/index")
    fun indexPage(model: Model): String {
        model["recipes"] = recipeService.getRecipes()

        return "index"
    }
}