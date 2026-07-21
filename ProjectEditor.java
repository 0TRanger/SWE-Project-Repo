package projman;

import java.util.Scanner;

public class ProjectEditor {

    private final Scanner sc;

    public ProjectEditor(Scanner sc) {
        this.sc = sc;
    }

    // Edits basic fields; pressing Enter keeps the current value
    public void editProjectBasics(Project p) {
        System.out.println("Editing project: " + p.getName());

        System.out.print("New name (Enter to keep '" + p.getName() + "'): ");
        String newName = sc.nextLine().trim();
        if (!newName.isEmpty()) {
            p.setName(newName);
        }

        System.out.print("New description (Enter to keep current): ");
        String newDesc = sc.nextLine().trim();
        if (!newDesc.isEmpty()) {
            p.setDescription(newDesc);
        }

        System.out.print("New manager name (Enter to keep '" + p.getManagerName() + "'): ");
        String newManager = sc.nextLine().trim();
        if (!newManager.isEmpty()) {
            p.setManagerName(newManager);
        }
        
        /* create array lists editor for the risks and requirements and store them in the new project return 
        statement below. I'd recommend using the team members arraylist  in ProjectCreator.java above as a blueprint to accomplish that
        
        */

        System.out.println("Done editing.");
    }
}
