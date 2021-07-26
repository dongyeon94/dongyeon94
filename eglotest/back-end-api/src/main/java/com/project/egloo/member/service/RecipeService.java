package com.project.egloo.member.service;

import com.project.egloo.member.domain.IngredientRecipeMapping;
import com.project.egloo.member.repository.IngredientRecipeMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RecipeService {

    @Autowired
    private IngredientRecipeMappingRepository ingredientRecipeMappingRepository;


    public List findRecipe() {
        return ingredientRecipeMappingRepository.findByRecipe_id(2L);
    }
    public List findinde(ArrayList lis) {
        ArrayList intersec = new ArrayList();
        for(int i=0; i < lis.size(); i++){
            List inner =  ingredientRecipeMappingRepository.findByIngredient_id(Long.parseLong((String) lis.get(i)));
            List out = new ArrayList();
            for(int j=0; j < inner.size(); j++){
                IngredientRecipeMapping map = (IngredientRecipeMapping) inner.get(j);
                out.add(map.getRecipe().getId());
            }
            System.out.println(out.toString());
            intersec.add(out);
        }
        System.out.println("======================================");
        System.out.println(intersec.toString());
        System.out.println(intersection(intersec));
        System.out.println("======================================");
        return ingredientRecipeMappingRepository.findByIngredient_id(2L);
    }


    public HashSet intersection(ArrayList inputArrays)
    {
        HashSet intersectionSet = new HashSet((Collection) inputArrays.get(0));
        System.out.println("*******************************************");
        System.out.println(intersectionSet);
        for (int i = 1; i < inputArrays.size(); i++)
        {
            System.out.println("--------------------------------------------------");
            HashSet innerset = new HashSet((Collection) inputArrays.get(i));
            intersectionSet.retainAll(innerset);
            System.out.println(intersectionSet.toString());
            System.out.println("--------------------------------------------------");
        }
        System.out.println("*******************************************");
        return intersectionSet;
    }
}
