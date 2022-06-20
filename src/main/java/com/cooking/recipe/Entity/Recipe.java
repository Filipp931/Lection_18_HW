package com.cooking.recipe.Entity;

import java.util.HashMap;
import java.util.Map;

public class Recipe {
    private long id;
    private String recipeName;
    private Map<String, Double> ingredients;

    public Recipe(String recipeName, Map<String, Double> ingredients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
    }

    public Recipe() {
        ingredients = new HashMap<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public Map<String, Double> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Map<String, Double> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", recipeName='" + recipeName + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
