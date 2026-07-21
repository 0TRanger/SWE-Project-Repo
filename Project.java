package projman;

import java.util.ArrayList;
import java.io.Serializable;

public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String description;
    private String managerName;
    private ArrayList<String> teamMembers;
    private ArrayList<Risk> risks;
    private ArrayList<Requirement> requirements;

    /**
     * Full Constructor with all parameters for class variables. (I decided to write more constructors than we will need, and we can decide which ones are the best to keep when integrating the console menu inputs.)
     * @param name The name of the project. Does not need to be unique, as the descriptions can help differentiate the projects
     * @param description A short project description for labeling purposes
     * @param managerName The name of the project manager if there is one, can be empty (I am unsure if the Manager name should be added to the teamMember list, but I didn't think it was correct, so I did not implement it)
     * @param teamMembers A list of all the team members on the project
     * @param risks A list of all the risks associated with the project
     * @param requirements A list of all the requirements associated with the project. Ideally we can use one Requirement interface and extend it with both functional and non-functional requirement types
     */
    public Project(String name, String description, String managerName, ArrayList<String> teamMembers, ArrayList<Risk> risks, ArrayList<Requirement> requirements){
        this.name = name;
        this.description = description;
        this.managerName = managerName;
        this.teamMembers = teamMembers;
        this.risks = risks;
        this.requirements = requirements;
    }

    public Project(String name, String description, String managerName){
        this.name = name;
        this.description = description;
        this.managerName = managerName;
        this.teamMembers = new ArrayList<String>();
        this.risks = new ArrayList<Risk>();
        this.requirements = new ArrayList<Requirement>();
    }

    public Project(String name, String description){
        this.name = name;
        this.description = description;
        managerName = "No Manager";
        this.teamMembers = new ArrayList<String>();
        this.risks = new ArrayList<Risk>();
        this.requirements = new ArrayList<Requirement>();
    }

    /**
     * Most simple constructor with only a name given. Sets default values for other class variables and ensures the Arraylists are instantiated and not null
     * @param name Only the project name is used for creation.
     */
    public Project(String name){
        this.name = name;
        description = "No Description";
        managerName = "No Manager";
        this.teamMembers = new ArrayList<String>();
        this.risks = new ArrayList<Risk>();
        this.requirements = new ArrayList<Requirement>();
    }

    /*
     * Getter and Setter Methods. Arraylists only have getters here as the next section has the add and remove methods
     */

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public String getManagerName() {
        return managerName;
    }
    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public ArrayList<String> getTeamMembers() {
        return teamMembers;
    }
    public ArrayList<Risk> getRisks() {
        return risks;
    }
    public ArrayList<Requirement> getRequirements() {
        return requirements;
    }

    /*
     * Add and Remove Methods for Arraylists. The lookup and selection for object removal should be done through the console menu before calling these methods
     */

    public void addTeamMember(String teamMemberName){
        teamMembers.add(teamMemberName);
    }
    public void removeTeamMember(String teamMemberName){
        teamMembers.remove(teamMemberName);
    }
    public void addRisk(Risk newRisk){
        risks.add(newRisk);
    }
    public void removeRisk(Risk deleteRisk){
        risks.remove(deleteRisk);
    }
    public void addRequirement(Requirement newReq){
        requirements.add(newReq);
    }
    public void removeRequirement(Requirement deleteReq){
        requirements.remove(deleteReq);
    }

}
