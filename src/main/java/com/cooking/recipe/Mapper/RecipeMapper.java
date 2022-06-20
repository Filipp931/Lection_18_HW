package com.cooking.recipe.Mapper;

import com.cooking.recipe.Entity.Recipe;
import org.springframework.jdbc.core.RowMapper;

import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;


public class RecipeMapper implements RowMapper<Recipe> {

    @Override
    public Recipe mapRow(ResultSet rs, int rowNum) throws SQLException {
        Recipe recipe = new Recipe();
        recipe.setId(rs.getLong("id"));
        recipe.setRecipeName(rs.getString("recipe"));
        Blob ingredientsBlob = rs.getBlob("Ingredients");
        Map<String, Double> ingredients = null;
        try {
            ingredients = (Map<String, Double>) new ObjectInputStream(ingredientsBlob.getBinaryStream()).readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        recipe.setIngredients(ingredients);
        return recipe;
    }

}
