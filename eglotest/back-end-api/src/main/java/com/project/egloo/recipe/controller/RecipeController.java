package com.project.egloo.recipe.controller;

import com.project.egloo.recipe.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;


@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/getRecipeByIngredients")
    public HashMap recipeByIngredients(@RequestParam ArrayList ingredient){
        return recipeService.getRecipeByIngredients(ingredient);
    }

    @PostMapping("/addRecipe")
    public HashMap addRecipe(String recipeName, HashMap<String,Integer> ingredientAmount){
        recipeService.addNewRecipe(recipeName, ingredientAmount);
        return null;
    }

    @PostMapping("/tt")
    public HashMap ttt(){
        recipeService.tst();
        return null;
    }
}
