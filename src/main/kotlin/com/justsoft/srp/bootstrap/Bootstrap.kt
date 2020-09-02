package com.justsoft.srp.bootstrap

import com.justsoft.srp.model.*
import com.justsoft.srp.repostitory.IngredientMeasurementUnitRepository
import com.justsoft.srp.repostitory.RecipeCategoryRepository
import com.justsoft.srp.repostitory.RecipeRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Bootstrap(
        val recipeRepository: RecipeRepository,
        val ingredientMeasurementUnitRepository: IngredientMeasurementUnitRepository,
        val recipeCategoryRepository: RecipeCategoryRepository,
) : CommandLineRunner {

    override fun run(vararg args: String?) {
        recipeRepository.save(constructGuacamole())
        recipeRepository.save(constructTaco())

        //displayRecipes()
    }


    fun displayRecipes() {
        recipeRepository.findAll().forEach {
            println("Recipe: ${it.name}")
            it.ingredients.forEach { ingredient ->
                println("\t-${ingredient.amount} ${ingredient.amountMeasurementUnit.unitName} ${ingredient.description}")
            }
        }
    }

    private fun constructTaco(): Recipe {
        val recipe = Recipe(
                "Grilled Chicken Tacos",
                "Spicy grilled chicken tacos! Quick marinade, then grill. Ready in about 30 minutes. " +
                        "Great for a quick weeknight dinner, backyard cookouts, and tailgate parties.",
                15, 15, 4,
                "https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/",
                "SimplyRecipes", "OneDirection", RecipeDifficulty.HARD, null,
                Notes(
                        null, "1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" +
                        "2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder," +
                        " oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil" +
                        " to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" +
                        "Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" +
                        "3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer " +
                        "inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for " +
                        "5 minutes.\n" +
                        "4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over " +
                        "medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, " +
                        "turn it with tongs and heat for a few seconds on the other side.\n" +
                        "Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" +
                        "5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small" +
                        " handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and " +
                        "onion slices. Drizzle with the thinned sour cream. Serve with lime wedges."
                )
        )

        recipe.notes.recipe = recipe

        val pcs = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("pcs")!!
        val teaspoon = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("teaspoon")!!
        val tablespoon = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("tablespoon")!!
        val dash = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("dash")!!
        val cup = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("cup")!!
        val pint = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("pint")!!

        recipe.addIngredient("ancho chili powder", 2, tablespoon)
        recipe.addIngredient("dried oregano", 1, teaspoon)
        recipe.addIngredient("cumin", 1, teaspoon)
        recipe.addIngredient("sugar", 1, teaspoon)
        recipe.addIngredient("salt", 0.5, teaspoon)
        recipe.addIngredient("finely chopped garlic clove", 1, pcs)
        recipe.addIngredient("finely grated orange zest", 1, tablespoon)
        recipe.addIngredient("fresh-squeezed orange juice", 3, tablespoon)
        recipe.addIngredient("olive oil", 2, tablespoon)
        recipe.addIngredient("skinned boneless chicken thighs", 4, pcs)
        recipe.addIngredient("small corn tortillas", 8, pcs)
        recipe.addIngredient("baby arugula, sliced", 3, cup)
        recipe.addIngredient("radishes", 4, pcs)
        recipe.addIngredient("cheery tomatoes", 0.5, pint)
        recipe.addIngredient("thinly sliced red onion", 0.25, pcs)
        recipe.addIngredient("roughly chopped cilantro", 1, pcs)
        recipe.addIngredient("sour cream", 0.5, cup)
        recipe.addIngredient("lime, cut into wedges", 1, pcs)

        val categoryMexican = recipeCategoryRepository.findByName("Mexican")!!
        val categoryAmerican = recipeCategoryRepository.findByName("American")!!
        recipe.categories.add(categoryMexican)
        recipe.categories.add(categoryAmerican)
        return recipe
    }

    private fun constructGuacamole(): Recipe {
        val recipe = Recipe(
                "Perfect Guacamole",
                "The best guacamole keeps it simple: just ripe avocados, salt, a squeeze of lime, onions," +
                        " chiles, cilantro, and some chopped tomato. Serve it as a dip at your next party or spoon " +
                        "it on top of tacos for an easy dinner upgrade.",
                10, 15, 4,
                "https://www.simplyrecipes.com/recipes/perfect_guacamole/",
                "SimplyRecipes",
                "Some directions",
                RecipeDifficulty.MODERATE, null,
                Notes(null,
                        "1 Cut the avocado, remove flesh: Cut the avocados in half. Remove the pit. Score the inside " +
                                "of the avocado with a blunt knife and scoop out the flesh with a spoon. " +
                                "(See How to Cut and Peel an Avocado.) Place in a bowl.\n\n" +
                                "2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole " +
                                "should be a little chunky.)\n\n" +
                                "3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid " +
                                "in the lime juice will provide some balance to the richness of the avocado and will help delay " +
                                "the avocados from turning brown.\n\n" +
                                "Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in " +
                                "their hotness. So, start with a half of one chili pepper and add to the guacamole to your " +
                                "desired degree of hotness.\n\n" +
                                "Remember that much of this is done to taste because of the variability in the fresh " +
                                "ingredients. Start with this recipe and adjust to your taste.\n\n" +
                                "Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, " +
                                "add it just before serving.\n\n" +
                                "4 Serve: Serve immediately, or if making a few hours ahead, place plastic wrap on the surface " +
                                "of the guacamole and press down to cover it and to prevent air reaching it. (The oxygen in " +
                                "the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve."
                )
        )
        recipe.notes.recipe = recipe

        val pcs = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("pcs")!!
        val teaspoon = ingredientMeasurementUnitRepository.findByUnitNameIgnoreCase("teaspoon")!!
        val tablespoon = ingredientMeasurementUnitRepository.findByUnitName("Tablespoon")!!
        val dash = ingredientMeasurementUnitRepository.findByUnitName("Dash")!!

        recipe.addIngredient("ripe avocados", 2, pcs)
        recipe.addIngredient("of salt", 0.25, teaspoon)
        recipe.addIngredient("fresh lime or lemon juice", 1, tablespoon)
        recipe.addIngredient("minced red onion", 2, tablespoon)
        recipe.addIngredient("serrano chilies with stems and seeds removed, minced", 2, pcs)
        recipe.addIngredient("finely chopped cilantro", 2, tablespoon)
        recipe.addIngredient("freshly grated black pepper", 1, dash)
        recipe.addIngredient("ripe tomato with seeds and pulp removed and chopped", 0.5, pcs)
        recipe.addIngredient("red radishes or jicama, to garnish", 0, pcs)
        recipe.addIngredient("tortilla chips, to serve", 0, pcs)

        val categoryMexican = recipeCategoryRepository.findByName("Mexican")!!
        recipe.categories.add(categoryMexican)
        return recipe
    }
}