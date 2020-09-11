package com.example.dagger2.model

import java.io.Serializable

data class AddressDTO(
	val street: String? = null,
	val suite: String? = null,
	val city: String? = null,
	val zipcode: String? = null,
	val geo: GeoDTO? = null
)