package com.project.egloo.member.controller;

import com.project.egloo.member.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/recipe")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/")
    public String search(){
        return recipeService.findRecipe().toString();
    }

    @GetMapping("/2")
    public String search2(@RequestParam ArrayList lis){
        System.out.println(lis.toString());
        return recipeService.findinde(lis).toString();
    }
}
