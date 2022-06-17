package com.cooking.recipe;

import com.cooking.recipe.DAO.RecipeDao;
import com.cooking.recipe.Entity.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.Map;

@ComponentScan
public class RecipeApplication {



    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RecipeApplication.class);
        RecipeDao recipeDao = context.getBean(RecipeDao.class);
       // addRecipes(recipeDao);
       // System.out.println(recipeDao.getAllRecipes().toString());
        System.out.println(recipeDao.getRecipeByName("Kek"));
    }

    private static void addRecipes(RecipeDao recipeDao){
        Recipe recipe1 = new Recipe();
        recipe1.setRecipeName("Keks");
        Map<String, Double> ingredients = new HashMap<>();
        ingredients.put("muka", 12.1);
        ingredients.put("egg", 3D);
        ingredients.put("sugar", 3.2);
        recipe1.setIngredients(ingredients);
        recipeDao.addNewRecipe(recipe1);
    }

}
