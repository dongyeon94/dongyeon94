package com.project.egloo.ingredient.repository;

import com.project.egloo.ingredient.domain.IngredientRecipeIdClass;
import com.project.egloo.ingredient.domain.IngredientRecipeMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface IngredientRecipeMappingRepository extends JpaRepository<IngredientRecipeMapping, IngredientRecipeIdClass> {
    List<IngredientRecipeMapping> findByIngredient_id(Long ingredient_id);

    @Transactional @Modifying
    @Query(value = "INSERT INTO ingredient_recipe_mapping(ingredient_id, recipe_id, category_id, quantity, unit, check_ingredient) " +
            "VALUES(:#{#recipe.ingredient},  :#{#recipe.recipe}, :#{#recipe.category} ," +
            ":#{#recipe.quantity} ,:#{#recipe.unit} ,:#{#recipe.checkIngredient});" ,nativeQuery = true)
    void recipeInsert(@Param("recipe") IngredientRecipeMapping recipe);
}
