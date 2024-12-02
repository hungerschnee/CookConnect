import java.util.Scanner;

public class Ingredient {
    private String name;
    private String unit;  // e.g., "cups", "grams", "teaspoons"
    private int quantity;

    // Constructor
    public Ingredient(String name, String unit, int quantity) {
        this.name = name;
        this.unit = unit;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Method to add an ingredient
    public static Ingredient addIngredient(Scanner scanner) {
        System.out.print("Enter ingredient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter ingredient unit: ");
        String unit = scanner.nextLine();
        System.out.print("Enter ingredient quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        return new Ingredient(name, unit, quantity);
    }

    public void editIngredient() {
        // Logic to edit this ingredient
    }

    public void deleteIngredient() {
        // Logic to delete this ingredient
    }

    public void viewIngredient() {
        // Logic to view details of this ingredient
    }
}
