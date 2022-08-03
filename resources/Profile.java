package assignment;

import java.util.ArrayList;

public class Profile {
    private String name;
    private String status;
    private ArrayList<Profile> friendProfiles;

    public Profile () {
        setName("");
        setStatus("NONE");
        friendProfiles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public ArrayList<Profile> getFriends() {
       return friendProfiles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void addFriend (Profile p) {
        if(friendProfiles.contains(p) || p.equals(this)) return;
        friendProfiles.add(p);
    }

    public int getNumberOfFriends () {
        return friendProfiles.size();
    }

    public boolean removeFriend (Profile p) {
        for (int i = 0; i < friendProfiles.size(); i++) {
            if (p.equals(friendProfiles.get(i))) {
                friendProfiles.remove(p);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;

        if (obj instanceof Profile) {
            Profile p = (Profile) obj;
            return getName().equals(p.getName()) &&
                    getStatus().equals(p.getStatus());
        }
        return false;
    }

    @Override
    public String toString () {
        return "Name: " + getName() + "\n" + "Status: " + getStatus() + "\n"
                + "Number of friend profiles: " + getNumberOfFriends();
    }

    public String display () {
        String profileString = "Name: " + getName() + "\n" +
                "Status: " + getStatus() + "\n" +
                "Number of friend profiles: " + getNumberOfFriends() + "\n";

        if (getNumberOfFriends() > 0) {
            profileString +=  "Friends:" + "\n";
            for (int i = 0; i < getNumberOfFriends(); i ++) {
                    profileString +="        " + friendProfiles.get(i).getName() + "\n" ;

            }
            profileString += "\n";
        }

        return profileString;
    }

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("Test Constructor\n");
        Profile profile = new Profile();
        profile.setStatus("Student1");
        profile.setName("Hung");
        System.out.println(profile.display());
        System.out.println();
        System.out.println("==============================");
        System.out.println("Test Getters\n");
        System.out.println("Name of profile: " + profile.getName());
        System.out.println("Status of profile: " + profile.getStatus());
        System.out.println();
        System.out.println("==============================");
        System.out.println("Test Setters\n");
        profile.setName("Dang");
        System.out.println("Set name to Dang: " + profile.display());
        profile.setStatus("Student2");
        System.out.println("Set status to Student2: " + profile.display());
        System.out.println();
        System.out.println("==============================");
        System.out.println("Test addFriend\n");
        Profile b = new Profile();
        b.setName("Hieu");
        b.setStatus("Student1");
        Profile c = new Profile();
        c.setName("Hung");
        c.setStatus("Student3");
        profile.addFriend(b);
        profile.addFriend(c);
        b.addFriend(c);
        b.addFriend(profile);
        c.addFriend(profile);
        c.addFriend(b);
        System.out.println(profile.display());
        System.out.println(b.display());
        System.out.println(c.display());
        System.out.println();
        System.out.println("==============================");
        System.out.println("Test removeFriend\n");
        b.removeFriend(c);
        profile.removeFriend(b);
        c.removeFriend(profile);
        System.out.println(profile.display());
        System.out.println(b.display());
        System.out.println(c.display());
    }

}
