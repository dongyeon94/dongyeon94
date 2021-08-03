package com.project.egloo.ingredient.domain;

import com.project.egloo.common.ColumnDescription;
import com.project.egloo.recipe.domain.Recipe;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@Data
@DynamicInsert
public class Ingredient {

    @Id @GeneratedValue
    @ColumnDescription("PK")
    private Long    id;

//    @ManyToOne
//    @ColumnDescription("레시피")
//    private Recipe recipe;
    
    @ColumnDescription("재료 이름")
    private String name;

    @ColumnDescription("재료 이미지")
    private String ingredientImage;

    @ColumnDescription("재료 가격")
    private int price;
}