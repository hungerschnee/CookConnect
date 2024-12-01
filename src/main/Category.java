import java.util.Scanner;

public class Category {
    private String title;
    private String description;

    // Constructor
    public Category(String title, String description) {
        this.title = title;
        this.description = description;
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

    public static Category addCategory(Scanner scanner) {
        System.out.print("Enter Category Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Category Description: ");
        String description = scanner.nextLine();
        return new Category(title, description);
    }

    public void editCategory() {
        // Logic to edit this category
    }

    public void deleteCategory() {
        // Logic to delete this category
    }

    public void viewCategory() {
        // Logic to view details of this category
    }
}