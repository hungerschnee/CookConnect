import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recipe {
    private String title;
    private String description;
    private String prepTime;
    private User creator;
    //    private List<Binary> image; // too complex for implementation
    private ArrayList<Ingredient> ingredients;
    private ArrayList<Instruction> instructions;
    private ArrayList<Review> reviews;
    private Category category;
    private String cookTime;
    private RecipeState recipeState;

    // Constructors
    public Recipe() {

    }

    public Recipe(String title, String description, String prepTime, String cookTime, Category category, ArrayList<Ingredient> ingredients, ArrayList<Instruction> instructions, User creator) {
        this.title = title;
        this.description = description;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
        this.category = category;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.creator = creator;
        this.recipeState = RecipeState.DRAFT;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public RecipeState getRecipeState() {
        return recipeState;
    }

    public void setRecipeState(RecipeState recipeState) {
        this.recipeState = recipeState;
    }

    // Method for adding a new recipe
    public Recipe addRecipe(Scanner scanner) {

        System.out.println("Enter details for the new recipe:");

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Description: ");
        String description = scanner.nextLine();

        System.out.print("Prep Time: ");
        String prepTime = scanner.nextLine();

        System.out.print("Cook Time: ");
        String cookTime = scanner.nextLine();

        System.out.print("Category: ");
        Category category = Category.addCategory(scanner);

        ArrayList<Ingredient> ingredients = new ArrayList<>();
        System.out.println("Ingredients: ");
        do {
            ingredients.add(Ingredient.addIngredient(scanner));
            System.out.println("more | stop");
        } while(scanner.nextLine().equalsIgnoreCase("more"));

        ArrayList<Instruction> instructions = new ArrayList<>();
        System.out.println("Instructions: ");
        do {
            instructions.add(Instruction.addInstruction(scanner));
            System.out.println("more | stop");
        } while(scanner.nextLine().equalsIgnoreCase("more"));

        System.out.println("Creator: ");
        User creator = User.createUser(scanner);

        return new Recipe(title, description, prepTime, cookTime, category, ingredients, instructions, creator);
    }

    public void editRecipe(Recipe newRecipe, Recipe oldRecipe) {
        // Logic for editing a recipe
    }

    // Method for deleting a Recipe
    public void deleteRecipe(Scanner scanner, ArrayList<Recipe> recipes) {
        System.out.println("Available Recipes:");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ". " + recipes.get(i).getTitle());
        }

        System.out.print("Enter the number of the recipe to delete: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice > 0 && choice <= recipes.size()) {
            Recipe deletedRecipe = recipes.remove(choice - 1);
            System.out.println(deletedRecipe.getTitle() + " deleted successfully.");
        } else {
            System.out.println("Invalid choice. No recipe deleted.");
        }
    }

    public void viewRecipeDetails() {
        System.out.println("Recipe Details:");
        System.out.println("Title: " + this.getTitle());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Prep Time: " + this.getPrepTime());
        System.out.println("Cook Time: " + this.getCookTime());
        System.out.println("Category: " + this.getCategory().getTitle());

        System.out.println("Ingredients: ");
        this.getIngredients().forEach(ingredient -> System.out.println("\tQuantity: " + ingredient.getQuantity() + ", Unit: " + ingredient.getUnit() + ", Name: " + ingredient.getName()));

        System.out.println("Instructions:");
        this.getInstructions().forEach(instruction -> System.out.println("\tStepNumber: " + instruction.getStepNumber() + ", Description: " + instruction.getStepDescription()));

        System.out.println("Creator: " + this.creator.getFirstName() + " " + this.creator.getLastName());
        System.out.println("State: " + this.getRecipeState());
    }

    public void filterRecipe() {
        // Logic to filter recipes (e.g., by category, ingredients) (too complex for implementation)
    }

    public void addImage() {
        // Logic to add an image
    }

    public void removeImage() {
        // logic to remove an image
    }

}
