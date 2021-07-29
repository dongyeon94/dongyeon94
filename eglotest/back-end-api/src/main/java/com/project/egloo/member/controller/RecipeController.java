package com.project.egloo.member.controller;

import com.project.egloo.member.domain.Recipe;
import com.project.egloo.member.service.RecipeService;
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
    public HashMap addRecipe(Recipe recipe){
        return null;
    }
}
