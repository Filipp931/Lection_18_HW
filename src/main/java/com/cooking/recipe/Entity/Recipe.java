package com.cooking.recipe.Entity;

import java.util.Map;

public class Recipe {
    private int id;
    private String recipeName;
    private Map<String, Double> ingredients;

    public Recipe(String recipeName, Map<String, Double> ingredients) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
    }

    public Recipe() {
    }

    public int getId() {
        return id;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public Map<String, Double> getIngredients() {
        return ingredients;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
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
