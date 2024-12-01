import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Instruction instruction = new Instruction("Instruction", 1);
        Ingredient ingredient = new Ingredient("Ingredient name", "Unit", 1);
        Category category = new Category("Category title", "Category description");
        User creator = new User("Adam", "Smith", "adam.smith@example.com", "password");

        ArrayList<Instruction> instructions = new ArrayList<Instruction>();
        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

        instructions.add(instruction);
        ingredients.add(ingredient);


        Recipe recipe = new Recipe("Recipe Title", "Recipe Description", "10min", "15min", category, ingredients, instructions, creator);

        recipe.viewRecipeDetails();

        Recipe recipe1 = new Recipe().addRecipe(sc);

        recipe1.viewRecipeDetails();

    }
}