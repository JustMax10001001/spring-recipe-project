package com.justsoft.srp.dsl

import com.justsoft.srp.model.*
import org.hibernate.Hibernate
import org.springframework.transaction.annotation.Transactional

@DslMarker
annotation class RecipeDslMarker

@RecipeDslMarker
class Ingredients(
) : ArrayList<Ingredient>() {
    fun ingredient(description: String, amount: Number, amountMeasurementUnit: IngredientMeasurementUnit): Ingredient {
        return Ingredient(description, amount, amountMeasurementUnit, null).also(this::add)
    }
}

@RecipeDslMarker
open class RecipeBuilder {
    lateinit var description: String
    lateinit var name: String
    var cookTime: Int = 0
    var prepTime = 0
    var numberOfServings: Int = 0
    lateinit var url: String
    lateinit var source: String
    lateinit var directions: String
    lateinit var difficulty: RecipeDifficulty
    var image: ByteArray? = null

    lateinit var notes: Notes

    private val ingredients: MutableSet<Ingredient> = HashSet()
    private val categories: MutableSet<RecipeCategory> = HashSet()

    fun notes(notes: String): Notes {
        return Notes(null, notes).also { this.notes = it }
    }

    fun notes(notes: String, init: Notes.() -> Unit): Notes {
        return notes(notes).also(init)
    }

    fun notes(init: Notes.() -> Unit): Notes {
        return Notes(null, "").also(init).also {
            this.notes = it
        }
    }

    fun ingredients(ingredientBuilder: Ingredients.() -> Unit) {
        this.ingredients.addAll(Ingredients().also(ingredientBuilder))
    }

    fun categories(vararg categories: RecipeCategory) {
        this.categories.addAll(categories)
    }

    @Transactional
    open fun build(): Recipe {
        val recipe = Recipe(name, description, prepTime, cookTime, numberOfServings, url, source, directions, difficulty,
                image, notes)
        notes.recipe = recipe
        Hibernate.initialize(recipe)
        ingredients.forEach { it.recipe = recipe }
        recipe.ingredients.addAll(ingredients)
        recipe.categories.addAll(categories)
        return recipe
    }
}

inline fun recipe(init: RecipeBuilder.() -> Unit): Recipe {
    return RecipeBuilder().also(init).build()
}