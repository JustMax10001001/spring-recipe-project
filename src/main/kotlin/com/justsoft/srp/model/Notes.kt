package com.justsoft.srp.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Lob
import javax.persistence.OneToOne

@Entity
class Notes(
        @OneToOne
        var recipe: Recipe?,

        @Lob
        @Column(nullable = false)
        var recipeNotes: String
): BaseEntity()
