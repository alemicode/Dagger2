package com.example.dagger2.model

import java.io.Serializable

data class UserDTO(
	val id: Int? = null,
	val name: String? = null,
	val username: String? = null,
	val email: String? = null,
	val address: AddressDTO? = null,
	val phone: String? = null,
	val website: String? = null,
	val company: CompanyDTO? = null
)