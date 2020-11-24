package com.savior.companydatabaseservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Company {
    private final UUID id;
    private final String name;
    private final String website;

    public Company(@JsonProperty("id") UUID id,
                   @JsonProperty("name") String name,
                   @JsonProperty("website") String website) {
        this.id = id;
        this.name = name;
        this.website = website;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }
}
