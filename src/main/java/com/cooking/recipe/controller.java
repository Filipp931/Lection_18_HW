package com.cooking.recipe;

import com.cooking.recipe.DAO.RecipeDao;
import com.cooking.recipe.Entity.Recipe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class controller {
    RecipeDao recipeDao;

    public controller(RecipeDao recipeDao) {
        this.recipeDao = recipeDao;
    }

    @GetMapping("/")
    public String main(Model model){
        List<Recipe> recipes = recipeDao.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "main.html";
    }

    @GetMapping("/addNewRecipe")
    String addNewRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "addNewRecipe.html";
    }

    @GetMapping("/{id}")
    String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("recipe", recipeDao.getById(id));
        return "editRecipe.html";
    }


    @PostMapping("/edit/{id}")
    String update(@ModelAttribute("recipe") Recipe recipe, @PathVariable long id){
        recipeDao.update(recipe);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    String edit(@PathVariable("id") long id) {
        recipeDao.delete(id);
        return "redirect:/";
    }



}
