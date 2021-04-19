package com.kafka.example.demo.model

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonProperty

@JsonInclude(JsonInclude.Include.NON_NULL)
class JsonFriendlyModel (
    @JsonProperty("Name") var name: String? = null,
    @JsonProperty("City") var city: String? = null,
    @JsonProperty("State") var state: String? = null
)