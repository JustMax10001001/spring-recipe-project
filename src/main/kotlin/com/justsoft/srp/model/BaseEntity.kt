package com.justsoft.srp.model

import java.io.Serializable
import javax.persistence.*

@MappedSuperclass
open class BaseEntity(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) open var id: Long? = null
) : Serializable