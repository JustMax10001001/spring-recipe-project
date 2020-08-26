package com.justsoft.srp.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.ManyToMany
import javax.persistence.Table

@Entity
@Table(name = "category")
class RecipeCategory(
        @Column(nullable = false) var name: String,
        @ManyToMany(mappedBy = "categories") val recipes: MutableSet<Recipe> = HashSet()
): BaseEntity()
