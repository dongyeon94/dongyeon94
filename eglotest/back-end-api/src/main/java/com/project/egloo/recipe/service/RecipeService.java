package com.project.egloo.recipe.service;

import com.project.egloo.common.StatusCode;
import com.project.egloo.ingredient.domain.Ingredient;
import com.project.egloo.ingredient.repository.IngredientRepository;
import com.project.egloo.recipe.domain.Recipe;
import com.project.egloo.recipe.repository.CategoryRepository;
import com.project.egloo.recipe.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestMethodNotSupportedException;

import javax.transaction.Transactional;
import java.util.*;

@Service
public class RecipeService {


    @Autowired
    private RecipeRepository recipeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private IngredientRepository ingredientRepository;

    public HashMap getRecipeByIngredients(ArrayList lis) {
        ArrayList intersection = new ArrayList();
//        for(int i=0; i < lis.size(); i++){
//            List mappingList =  ingredientRecipeMappingRepository.findByIngredient_id(Long.parseLong((String) lis.get(i)));
//            List recipeNames = new ArrayList();
//            for(int j=0; j < mappingList.size(); j++){
//                IngredientRecipeMapping map = (IngredientRecipeMapping) mappingList.get(j);
//                recipeNames.add(map.getRecipe().getName());
//            }
//            intersection.add(recipeNames);
//        }
        return  response(intersection(intersection));
    }

    public HashSet intersection(ArrayList inputArrays)
    {
        HashSet intersectionSet = new HashSet((Collection) inputArrays.get(0));
        for (int i = 1; i < inputArrays.size(); i++)
        {
            HashSet innerset = new HashSet((Collection) inputArrays.get(i));
            intersectionSet.retainAll(innerset);
        }
        return intersectionSet;
    }


    public HashMap addNewRecipe(String recipeName, HashMap<String,Integer> ingredientAmount){

        Recipe recipe = new Recipe();
        recipe.setName(recipeName);
        recipeRepository.save(recipe);

        Optional<Recipe> recipeObject  = recipeRepository.findByName(recipeName);
        recipeSave(recipeObject.get(), ingredientAmount);

        return response(HttpStatus.OK);
    }


    @Transactional
    public void recipeSave(Recipe recipe, HashMap<String,Integer> ingredientAmount){

//        for(String key : ingredientAmount.keySet()) {
//            IngredientRecipeMapping ingredientRecipeMapping = new IngredientRecipeMapping();
//
//            ingredientRecipeMapping.setRecipe(recipe);
//            Optional<Ingredient> ingredient = ingredientRepository.findByName(key);
//            ingredientRecipeMapping.setIngredient(ingredient.get());
//            ingredientRecipeMapping.setQuantity(ingredientAmount.get(key));
//
//            ingredientRecipeMappingRepository.recipeInsert(ingredientRecipeMapping);
//        }
    }

    public HashMap response(Object object){
        HashMap res = new HashMap();
        res.put("code", StatusCode.SUCCESS_OK);
        res.put("msg",object);
        res.put("errors","");
        return res;
    }

    @Transactional
    public void tst() throws HttpRequestMethodNotSupportedException {
        Optional<Recipe> recipe  = recipeRepository.findByName("re1");
        Optional<Ingredient> ingredients =  ingredientRepository.findByName("감자");
        Optional<Ingredient> ingredients2 =  ingredientRepository.findByName("고구마");
        Recipe recipe1 = new Recipe();


        Set<Ingredient> li = new HashSet<>();
        li.add(ingredients.get());
        li.add(ingredients2.get());
//        System.out.println("---1111111---------------");
//
        recipe1.setIngredients(li);
        System.out.println(recipe1);
        recipeRepository.save(recipe1);

    }
}
