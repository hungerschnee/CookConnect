import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class RecipeTest {


    ArrayList<Recipe> recipes = new ArrayList<>();

    @Before
    public void init()  {
        // Create a list of recipes
        recipes.add(new Recipe("Recipe 1", "Desc 1", "10 min", "20 min", new Category("Cat 1", "Desc"), new ArrayList<>(), new ArrayList<>(), new User("firstName1", "lastName1", "email1", "password1")));
        recipes.add(new Recipe("Recipe 2", "Desc 2", "15 min", "25 min", new Category("Cat 2", "Desc"), new ArrayList<>(), new ArrayList<>(), new User("firstName2", "lastName2", "email2", "password2")));
        recipes.add(new Recipe("Recipe 3", "Desc 3", "20 min", "30 min", new Category("Cat 3", "Desc"), new ArrayList<>(), new ArrayList<>(), new User("firstName3", "lastName3", "email3", "password3")));


    }

    @Test
    public void testAddRecipe() {
        Scanner scanner = getScanner();

        Recipe recipe = new Recipe().addRecipe(scanner);

        assertEquals("Test Recipe", recipe.getTitle());
        assertEquals("A delicious test recipe", recipe.getDescription());
        assertEquals("10 minutes", recipe.getPrepTime());
        assertEquals("20 minutes", recipe.getCookTime());

        // Category assertions
        assertEquals("Dessert", recipe.getCategory().getTitle());
        assertEquals("A sweet treat", recipe.getCategory().getDescription());

        // Ingredient assertions
        assertEquals(1, recipe.getIngredients().size());
        assertEquals("Flour", recipe.getIngredients().get(0).getName());
        assertEquals("cup", recipe.getIngredients().get(0).getUnit());
        assertEquals(1, recipe.getIngredients().get(0).getQuantity());

        // Instruction assertions
        assertEquals(1, recipe.getInstructions().size());
        assertEquals("Mix ingredients", recipe.getInstructions().get(0).getStepDescription());
        assertEquals(1, recipe.getInstructions().get(0).getStepNumber());

        // User assertions
        assertNotNull(recipe.getCreator());
        assertEquals("Adam", recipe.getCreator().getFirstName());
        assertEquals("Smith", recipe.getCreator().getLastName());
        assertEquals("adam.smith@example.com", recipe.getCreator().getEmail());
        assertEquals("password", recipe.getCreator().getPassword());
    }

    private static Scanner getScanner() {
        String input = "Test Recipe\n" +
                "A delicious test recipe\n" +
                "10 minutes\n" +
                "20 minutes\n" +
                "Dessert\n" +  // Category title
                "A sweet treat\n" + // Category description
                "Flour\n" + // Ingredient name
                "cup\n" + // Ingredient unit
                "1\n" + // Ingredient quantity
                "stop\n" +
                "Mix ingredients\n" + // Instruction description
                "1\n" + // Instruction step number
                "stop\n" +
                "Adam\n" + // User firstname
                "Smith\n" + // User lastname
                "adam.smith@example.com\n" + // User email
                "password\n";// User password
        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }

    @Test
    public void testDeleteRecipe() {
        // Create a list of recipes
//        ArrayList<Recipe> recipes = new ArrayList<>();
//        recipes.add(new Recipe("Recipe 1", "Desc 1", "10 min", "20 min", new Category("Cat 1", "Desc"), new ArrayList<>(), new ArrayList<>(), new User("firstName1", "lastName1", "email1", "password1")));
//        recipes.add(new Recipe("Recipe 2", "Desc 2", "15 min", "25 min", new Category("Cat 2", "Desc"), new ArrayList<>(), new ArrayList<>(), new User("firstName2", "lastName2", "email2", "password2")));
//        recipes.add(new Recipe("Recipe 3", "Desc 3", "20 min", "30 min", new Category("Cat 3", "Desc"), new ArrayList<>(), new ArrayList<>(), new User("firstName3", "lastName3", "email3", "password3")));

        // Simulate user input to delete the second recipe
        String input = "2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        assertEquals(3, recipes.size()); // Check if the list has three objects

        // Call the deleteRecipe method
        new Recipe().deleteRecipe(scanner, recipes);

        // Assertions
        assertEquals(2, recipes.size()); // Check if the list size is reduced
        assertEquals("Recipe 1", recipes.get(0).getTitle()); // Check if the first recipe remains
        assertEquals("Recipe 3", recipes.get(1).getTitle()); // Check if the third recipe remains
    }

    @Test
    public void testViewRecipeDetails() {
        // Redirect System.out to capture the output
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the method to be tested
        recipes.get(0).viewRecipeDetails();

        // Reset System.out
        System.setOut(System.out);

        // Get the system-dependent line separator
        String lineSeparator = System.lineSeparator();

        // Expected output based on the provided Recipe data, using the line separator
        String expectedOutput = "Recipe Details:" + lineSeparator +
                "Title: Recipe 1" + lineSeparator +
                "Description: Desc 1" + lineSeparator +
                "Prep Time: 10 min" + lineSeparator +
                "Cook Time: 20 min" + lineSeparator +
                "Category: Cat 1" + lineSeparator +
                "Ingredients: " + lineSeparator +
                "Instructions:" + lineSeparator +
                "Creator: firstName1 lastName1" + lineSeparator;

        // Assert that the output matches the expected output
        assertEquals(expectedOutput, outputStream.toString());
    }

}
