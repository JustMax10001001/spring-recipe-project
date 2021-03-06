package com.justsoft.srp.model

import com.justsoft.srp.dsl.RecipeDslMarker
import javax.persistence.*

@Entity
@RecipeDslMarker
class Recipe(
        @Column(nullable = false) var name: String,
        @Column(nullable = false) var description: String,
        @Column(nullable = false) var prepTime: Int,
        @Column(nullable = false) var cookTime: Int,
        @Column(nullable = false) var numberOfServings: Int,
        @Column(nullable = false) var url: String,
        @Column(nullable = false) var source: String,
        @Column(nullable = false) var directions: String,

        @Column(nullable = false)
        @Enumerated(value = EnumType.STRING)
        var difficulty: RecipeDifficulty,

        @Lob
        var image: ByteArray?,

        @OneToOne(cascade = [CascadeType.ALL])
        var notes: Notes,

        @OneToMany(cascade = [CascadeType.ALL], mappedBy = "recipe", fetch = FetchType.EAGER)
        val ingredients: MutableSet<Ingredient> = HashSet(),

        @ManyToMany
        @JoinTable(name = "recipe_category", joinColumns = [JoinColumn(name = "recipe_id")],
                inverseJoinColumns = [JoinColumn(name = "category_id")])
        val categories: MutableSet<RecipeCategory> = HashSet()
) : BaseEntity() {

    fun addIngredient(description: String, amount: Number, amountMeasurementUnit: IngredientMeasurementUnit) {
        ingredients.add(Ingredient(description, amount, amountMeasurementUnit, this))
    }
}

