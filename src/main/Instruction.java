import java.util.Scanner;

public class Instruction {
    private String stepDescription;
    private int stepNumber;

    // Constructor
    public Instruction(String stepDescription, int stepNumber) {
        this.stepDescription = stepDescription;
        this.stepNumber = stepNumber;
    }

    // Getters and Setters
    public String getStepDescription() {
        return stepDescription;
    }

    public void setStepDescription(String stepDescription) {
        this.stepDescription = stepDescription;
    }

    public int getStepNumber() {
        return stepNumber;
    }

    public void setStepNumber(int stepNumber) {
        this.stepNumber = stepNumber;
    }

    public static Instruction addInstruction(Scanner scanner) {
        System.out.print("Enter step description: ");
        String stepDescription = scanner.nextLine();
        System.out.print("Enter step number: ");
        int stepNumber = scanner.nextInt();
        scanner.nextLine();
        return new Instruction(stepDescription, stepNumber);
    }

    public void editInstruction() {
        // Logic to edit this instruction
    }

    public void deleteInstruction() {
        // Logic to delete this instruction
    }

    public void viewInstruction() {
        // Logic to view this instruction
    }
}