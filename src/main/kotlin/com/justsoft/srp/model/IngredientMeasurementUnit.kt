package com.justsoft.srp.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "measurement_unit")
class IngredientMeasurementUnit(
        @Column(nullable = false, name = "UNIT_NAME") var unitName: String
): BaseEntity()