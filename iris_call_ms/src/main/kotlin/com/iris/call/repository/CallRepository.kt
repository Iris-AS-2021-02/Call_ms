package com.iris.call.repository

import com.iris.call.model.Call
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CallRepository: JpaRepository<Call, Int> {
    fun findByUserId(userId :String):List<Call>
}