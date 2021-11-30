package com.example.pfotenfreunde.model.pet;

import com.example.pfotenfreunde.model.Picture;

import java.util.List;

public class Pet {
    private String name;
    private String description;
    private PetType petType;
    private List<PetAttribute> attributes;
    private List<Preference> preferences;
    private List<Picture> pictures;

    public Pet(String name, String description, PetType petType, List<PetAttribute> attributes, List<Preference> preferences, List<Picture> pictures) {
        this.name = name;
        this.description = description;
        this.petType = petType;
        this.attributes = attributes;
        this.preferences = preferences;
        this.pictures = pictures;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public List<PetAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<PetAttribute> attributes) {
        this.attributes = attributes;
    }

    public List<Preference> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<Preference> preferences) {
        this.preferences = preferences;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }
}
