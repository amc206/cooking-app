package edu.greenriver.sdev.cookingapp.services;

import edu.greenriver.sdev.cookingapp.model.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService
{
    private List<Recipe> recipes = new ArrayList<>(List.of(
            Recipe.builder()
                    .vegan(false)
                    .cookTime(45)
                    .name("Yellow Cake")
                    .ingredients(List.of(
                            "butter", "oil", "egg", "flour"
                    ))
                    .servings(15)
                    .build(),
            Recipe.builder()
                    .vegan(false)
                    .cookTime(20)
                    .name("Carne Asada Tacos")
                    .ingredients(List.of(
                            "carne asada", "corn tortillas", "cilantro", "salsa"
                    ))
                    .servings(5)
                    .build(),
            Recipe.builder()
                    .vegan(true)
                    .cookTime(45)
                    .name("Salad")
                    .ingredients(List.of(
                            "lettuce", "tomatoes", "carrots", "dressing"
                    ))
                    .servings(3)
                    .build()
    ));

    //GET requests (read)
    public List<Recipe> allRecipes()
    {
        return recipes;
    }

    public Recipe findRecipeByName(String recipeName)
    {
        return recipes.stream()
                .filter(rec -> rec.getName().equalsIgnoreCase(recipeName))
                .findFirst()
                .orElse(null);
    }

    //POST requests (create)
    public void addRecipe(Recipe newRecipe)
    {
        recipes.add(newRecipe);
    }

    //PUT requests (update)
    public void updateRecipe(Recipe updatedRecipe)
    {
        /*Recipe found = recipes.stream()
                .filter(rec -> rec.getName().equalsIgnoreCase(updatedRecipe.getName()))
                .findFirst()
                .orElse(null);*/

        Recipe found = findRecipeByName(updatedRecipe.getName());
        if (found != null)
        {
            found.setIngredients(updatedRecipe.getIngredients());
            found.setVegan(updatedRecipe.isVegan());
            found.setCookTime(updatedRecipe.getCookTime());
            found.setServings(updatedRecipe.getServings());
        }
    }

    //DELETE requests (delete)
    public void deleteRecipe(Recipe deleteRecipe)
    {
        //filter out just the matching recipe name
        recipes = recipes.stream()
                .filter(rec -> !rec.getName().equalsIgnoreCase(deleteRecipe.getName()))
                .toList();

        //another way to do it
        //Recipe found = findRecipeByName(deleteRecipe.getName());
        //recipes.remove(found);
    }
}