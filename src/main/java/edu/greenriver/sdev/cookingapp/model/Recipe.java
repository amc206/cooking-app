package edu.greenriver.sdev.cookingapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Recipe
{
    private String name;
    private List<String> ingredients;
    private double servings;
    private int cookTime;
    private boolean vegan;
}

