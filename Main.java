package projman;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProjectDatabase db = new ProjectDatabase("projects.db");
        //main loop starts here
        while (true) {
            System.out.println("Welcome to the Project Manager Application");
            System.out.println("Please make a selection");
            System.out.println("1) Create a Project");
            System.out.println("2) Edit a Project");
            System.out.println("3) View a Project");
            System.out.println("0) Quit");
            System.out.print("Choose: ");

            int choice;
            try {
                choice = sc.nextInt();
                sc.nextLine(); // consume newline
            } catch (Exception e) {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // clear bad input
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.println("Do you want to make a simple project (name only) or full project (all attributes)");
                    System.out.println("1) For Simple Project");
                    System.out.println("2) For Full Project");
                    System.out.print("Choose: ");
                
                    int type = sc.nextInt();
                    sc.nextLine(); // consume newline
                
                    ProjectCreator creator = new ProjectCreator(sc);
                    Project p;
                
                    switch (type) {
                        case 1:
                            p = creator.createProjectSimple();
                            db.saveProject(p);
                            System.out.println("Project saved!");
                            break;
                        case 2:
                            p = creator.createProjectFull();
                            db.saveProject(p);
                            System.out.println("Project saved!");
                            break;
                        default:
                            System.out.println("Invalid selection.");
                            break;
                    }
                
                    break;
                }


                case 2: {
                    ArrayList<Project> projects = db.loadProjects();
                    if (projects.isEmpty()) {
                        System.out.println("No projects found. Create one first.");
                        break;
                    }
                
                    // list projects with indexes
                    System.out.println("Projects:");
                    for (int i = 0; i < projects.size(); i++) {
                        System.out.println((i + 1) + ") " + projects.get(i).getName());
                    }
                
                    System.out.print("Which project number do you want to edit? ");
                    int idx;
                    try {
                        idx = sc.nextInt();
                        sc.nextLine(); // consume newline
                    } catch (Exception e) {
                        System.out.println("Invalid input.");
                        sc.nextLine();
                        break;
                    }
                
                    if (idx < 1 || idx > projects.size()) {
                        System.out.println("That project number does not exist.");
                        break;
                    }
                
                    Project selected = projects.get(idx - 1);
                
                    // edit using ProjectEditor
                    ProjectEditor editor = new ProjectEditor(sc);
                    editor.editProjectBasics(selected);
                
                    // overwrite DB with updated list
                    db.saveAllProjects(projects);
                
                    System.out.println("Project updated!");
                    break;
                }


                case 3: {
                    ArrayList<Project> projects = db.loadProjects();
                    if (projects.isEmpty()) {
                        System.out.println("No projects found.");
                        break;
                    }

                    System.out.println("Projects:");
                    for (int i = 0; i < projects.size(); i++) {
                        Project p = projects.get(i);
                        System.out.println();
                        System.out.println("[" + (i + 1) + "]");
                        System.out.println("Name: " + p.getName());
                        System.out.println("Description: " + p.getDescription());
                        System.out.println("Manager: " + p.getManagerName());
                        /* you'll need to print the risk and requirement array lists here
                        */
                    }
                    System.out.println();
                    break;
                }

                case 0: {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }

            System.out.println();
        }
    }
}
