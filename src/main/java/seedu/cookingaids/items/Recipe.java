package seedu.cookingaids.items;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Recipe {
    private String recipeName;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> tags;

    @JsonCreator
    public Recipe(@JsonProperty("name") String recipeName,
                  @JsonProperty("ingredients") ArrayList<Ingredient> ingredients) {
        this.recipeName = recipeName;
        this.ingredients = (ingredients != null) ? ingredients : new ArrayList<>();
        this.tags = (tags != null) ? tags : new ArrayList<>();
    }

    public Recipe(String recipeName) {
        this.recipeName = recipeName;
        this.ingredients = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public Recipe(String recipeName, ArrayList<Ingredient> ingredients, ArrayList<String> tags) {
        this.recipeName = recipeName;
        this.ingredients = ingredients;
        this.tags = tags;
    }

    @JsonIgnore
    public String getRecipeName() {
        return this.recipeName;
    }

    @JsonIgnore
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public ArrayList<Ingredient> getIngredients() {
        return this.ingredients;
    }

    @JsonIgnore
    public String getIngredientsString() {
        String ingredientsString = "";
        for (Ingredient ingredient : this.ingredients) {
            ingredientsString += ingredient.getName() + " (" + ingredient.getQuantity() + "), ";
        }
        return ingredientsString.substring(0, ingredientsString.length() - 2);
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @java.lang.Override
    public java.lang.String toString() {
        String toReturn = "Recipe named '" + recipeName +
                "' needs ingredients: " + getIngredientsString();

        if (!tags.isEmpty()) {
            toReturn += "\ntagged as: " + tags;
        }

        return  toReturn;
    }

    @JsonProperty("name")
    public String getName() {
        return this.recipeName;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        //this.tags = tags;
        ArrayList<String> newTags = new ArrayList<>();
        for (String tag : tags) {
            newTags.add(tag.toLowerCase());
        }
        this.tags = newTags;
    }
}
