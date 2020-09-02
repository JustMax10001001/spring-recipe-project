package com.justsoft.srp.model

import javax.persistence.*

@Entity
class Ingredient(
        @Column(nullable = false)
        var description: String,

        @Column(nullable = false)
        var amount: Number,

        @OneToOne(fetch = FetchType.EAGER)
        var amountMeasurementUnit: IngredientMeasurementUnit,

        @ManyToOne
        var recipe: Recipe?
): BaseEntity()

