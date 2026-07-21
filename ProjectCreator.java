package projman;

import java.util.ArrayList;
import java.util.Scanner;

public class ProjectCreator {

    private final Scanner sc;

    public ProjectCreator(Scanner sc) {
        this.sc = sc;
    }

    // Create a minimal project (only name)
    public Project createProjectSimple() {
        System.out.print("Enter project name: ");
        String name = sc.nextLine().trim();
        return new Project(name);
    }

    // Create a project with full details (name, description, manager, team, risks, requirements)
    public Project createProjectFull() {
        System.out.print("Enter project name: ");
        String name = sc.nextLine().trim();

        System.out.print("Enter project description: ");
        String description = sc.nextLine().trim();

        System.out.print("Enter manager name (or leave blank for none): ");
        String managerName = sc.nextLine().trim();
        if (managerName.isEmpty()) managerName = "No Manager";

        ArrayList<String> teamMembers = new ArrayList<>();
        System.out.print("How many team members? ");
        int teamCount = readInt();
        for (int i = 0; i < teamCount; i++) {
            System.out.print("Team member " + (i + 1) + " name: ");
            teamMembers.add(sc.nextLine().trim());
        }
        
        ArrayList<Risk> risks = new ArrayList<>(); //placeholders
        ArrayList<Requirement> requirements = new ArrayList<>(); //placeholders

        /* create array lists for the risks and requirements and store them in the new project return 
        statement below. I'd recommend using the team members arraylist above as a blueprint to accomplish that
        
        */

        return new Project(name, description, managerName, teamMembers, risks, requirements);
    }

    // Helper to safely read an int from the scanner
    private int readInt() {
        while (true) {
            String line = sc.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid number: ");
            }
        }
    }
}
