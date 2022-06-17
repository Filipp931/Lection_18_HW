package com.cooking.recipe.DAO;

import com.cooking.recipe.Entity.Recipe;
import com.cooking.recipe.Mapper.RecipeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RecipeDao {
    private final JdbcTemplate recipeJdbcTemplate;

    String FIND_BY_NAME = "SELECT * FROM cooking.recipes WHERE recipe LIKE ?";
    String SELECT_ALL = "SELECT * FROM cooking.recipes";
    String INSERT_INTO = "INSERT INTO cooking.recipes (recipe, Ingredients) VALUES (?, ?)";

    @Autowired
    public RecipeDao(JdbcTemplate recipeJdbcTemplate) {
        this.recipeJdbcTemplate = recipeJdbcTemplate;
    }

    public List<Recipe> getRecipeByName(String namePart){
        String nameForSearch = '%' + namePart +'%';
        return recipeJdbcTemplate.query(FIND_BY_NAME, new RecipeMapper(), nameForSearch);
    }

    public List<Recipe> getAllRecipes(){
        return recipeJdbcTemplate.query(SELECT_ALL, new RecipeMapper());
    }

    public void addNewRecipe(Recipe recipe){
        byte[] ingredientsBlob = SerializationUtils.serialize(recipe.getIngredients());
        Blob blob = null;
        try {
            blob = new SerialBlob(ingredientsBlob);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        recipeJdbcTemplate.update(INSERT_INTO, recipe.getRecipeName(), blob);
    }



}
