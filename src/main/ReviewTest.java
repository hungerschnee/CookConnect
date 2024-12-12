import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;

public class ReviewTest {

    Recipe recipe1;

    // Execution before any @Test method
    @Before
    public void init() {
        Category category1 = new Category("Category 1", "Category Description 1");
        User creator1 = new User("Albert", "Einstein", "aeinstein@gmail.com", "Einstein123");
        recipe1 = new Recipe();
        recipe1.setTitle("Recipe 1");
        recipe1.setDescription("Recipe Description");
        recipe1.setCookTime("30 min");
        recipe1.setPrepTime("10 min");
        recipe1.setCreator(creator1);
        recipe1.setCategory(category1);
    }

    @Test
    public void testWriteReview() {
        // Mock Scanner with input
        Scanner scanner = getScanner();

        // Call addReview
        Review review = new Review().writeReview(scanner, recipe1);

        // Review assertions
        assertNotNull(review);
        assertEquals(4.5, review.getRating(), 0.01);
        assertTrue(review.getRating() < 5 && review.getRating() >= 1);
        assertEquals("Great Recipe!", review.getComment());

        // Recipe assertions
        assertNotNull(review.getRecipe());
        assertEquals("Recipe 1", review.getRecipe().getTitle());
        assertEquals("Recipe Description", review.getRecipe().getDescription());
        assertEquals("30 min", review.getRecipe().getCookTime());
        assertEquals("10 min", review.getRecipe().getPrepTime());

        // Creator assertions
        assertNotNull(review.getRecipe().getCreator());
        assertEquals("Albert", review.getRecipe().getCreator().getFirstName());
        assertEquals("Einstein", review.getRecipe().getCreator().getLastName());
        assertEquals("aeinstein@gmail.com", review.getRecipe().getCreator().getEmail());

        // Category assertions
        assertNotNull(review.getRecipe().getCategory());
        assertEquals("Category 1", review.getRecipe().getCategory().getTitle());
        assertEquals("Category Description 1", review.getRecipe().getCategory().getDescription());
    }

    private static Scanner getScanner() {
        String input = 4.5+"\n" +
                "Great Recipe!\n";

        return new Scanner(new ByteArrayInputStream(input.getBytes()));
    }
}
