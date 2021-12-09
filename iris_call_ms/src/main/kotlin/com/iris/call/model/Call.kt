package com.iris.call.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name="calls")
data class Call (
    @Id
    @GeneratedValue
    val call_id:Int,

    val userId: String,
    val call_date: String,
    val call_started: String,
    val call_finished: String,
    val call_duration: String
)
