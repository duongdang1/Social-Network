package assignment;

public class ProfileManager {
    private final GraphInterface<Profile> allProfiles;

    public ProfileManager () {
        allProfiles = new Graph<>();
    }

    public void addProfile (Profile p) {
        allProfiles.addVertex(p);
    }

    public void createFriendship (Profile a, Profile b) {
        a.addFriend(b);
        b.addFriend(a);
        allProfiles.addEdge(a, b);
        allProfiles.addEdge(b, a);
    }

    public String display (Profile p) {
        QueueInterface<Profile> profiles = allProfiles.getBreadthFirstTraversal(p);
        String profileString = "";
        while (!profiles.isEmpty()) {
            Profile currentProfile =  profiles.dequeue();
            profileString += "Name: " + currentProfile.getName() + "\n" +
                    "Status: " + currentProfile.getStatus() + "\n" +
                    "Number of friend profiles: " + currentProfile.getNumberOfFriends() + "\n";
            profileString +=  "Friends:" + "\n";
            for (int i = 0; i < currentProfile.getNumberOfFriends(); i ++) {
                profileString += "        " + currentProfile.getFriends().get(i).getName() + "\n";


            }
            profileString += " \n";
        }

        return profileString;
    }

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("Test addProfile\n");
        ProfileManager p = new ProfileManager();
        Profile a = new Profile();
        a.setName("Hung");
        Profile b = new Profile();
        b.setName("Dang");
        p.addProfile(a);
        System.out.println(p.display(a));
        System.out.println();
        System.out.println("==============================");
        System.out.println("Test createFriendShip\n");
        p.addProfile(b);
        p.createFriendship(a,b);
        System.out.println(p.display(a));
    }
}
