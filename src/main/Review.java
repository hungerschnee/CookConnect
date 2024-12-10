import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Review {
    private double rating;
    private String comment;
    private Date date;
    private Recipe recipe;

    // No args constructor
    public Review() {
    }

    // All args constructor
    public Review(String comment, Date date, double rating, Recipe recipe) {
        this.comment = comment;
        this.date = date;
        this.rating = rating;
        this.recipe = recipe;
    }

    // Getters and Setters
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    // Method for adding a review
    public Review writeReview(Scanner scanner, Recipe recipe) {
        System.out.println("Enter details for the review for the  " + recipe.getTitle() + " recipe:");

        System.out.print("Rating (1.0 to 5.0): ");
        double rating = -1;

        // Check if rating is valid
        while (rating < 1.0 || rating > 5.0) {
            try {
                rating = Double.parseDouble(scanner.nextLine());
                if (rating < 1.0 || rating > 5.0) {
                    System.out.println("Please enter a valid rating between 1.0 and 5.0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric rating between 1.0 and 5.0.");
            }
        }

        System.out.print("Comment: ");
        String comment = scanner.nextLine();

        Date date = new Date();

        // Date formatting
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = formatter.format(date);

        System.out.print("Date: " + formattedDate);

        // Return the new Review instance
        return new Review(comment, date, rating, recipe);
    }

    public void deleteReview(Scanner scanner, Review review) {
        // Logic for deleting review
    }

    public void editReview(Scanner scanner, Review review) {
        // Logic for deleting review
    }
}
