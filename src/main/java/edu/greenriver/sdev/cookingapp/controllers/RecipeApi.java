package edu.greenriver.sdev.cookingapp.controllers;

import edu.greenriver.sdev.cookingapp.model.Recipe;
import edu.greenriver.sdev.cookingapp.services.RecipeService;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("recipes") //all paths start with "recipes"
public class RecipeApi
{
    private RecipeService service;

    public RecipeApi(RecipeService service)
    {
        this.service = service;
    }
    //http://localhost:8080/recipes
    @GetMapping("")
    public List<Recipe> allRecipes()
    {
        return service.allRecipes();
    }

    //http://localhost:8080/recipes/{recipeName}
    @GetMapping("{recipeName}")
    public Recipe recipeByName(@PathVariable String recipeName)
    {
        return service.findRecipeByName(recipeName);
    }

    //http://localhost:8080/recipes
    @PostMapping("")
    public void addRecipe(@RequestBody Recipe recipe)
    {
        service.addRecipe(recipe);
    }

    public void updateRecipe(){}

    public void deleteRecipe(){}
}
