package model;

public class About {
    private String versionNumber;
    private String userName;
    private String teamName;
    private ArrayList<Developer> teamMembers;    
    
    public About(String userName, String teamName, ArrayList<Developer> teamMembers,
            String versionNumber) {
        this.userName = userName;
        this.teamName = teamName;
        this.teamMembers = new ArrayList<>(teamMembers);
        this.versionNumber = versionNumber;
    }
    
    public String getUsername() {
        return userName;
    }
    
    public String getTeamName() {
        return teamName;
    }
    
    public String getVersion() {
        return versionNumber; 
    }
    
    public ArrayList<Developer> getDevelopers() {
        return teamMembers;
    }
    
    public void addDeveloper(Developer dev) {
        teamMembers.add(dev);
    }
}
