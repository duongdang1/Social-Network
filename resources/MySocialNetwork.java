package assignment;
import java.util.ArrayList;
/**
 * Example driver program * @author Zeynep Orhan *
 */
public class MySocialNetwork {
    public static void main(String[] args) {
        String name[] = { "Robert Downey", "Barack Obama", "Dwayne Johnson",
                "Jeff Bezos", "Cristiano Ronaldo","Princess Diana",
                "Socrates", "Martin Luther King", "Albert Einstein" };
        String status[] = { "Iron Man", "Former President", "WrestlerActor", "Billionaire", "Footballer", "KindHeart",
                "Philosopher", "Activist:I have a dream", "I did not fail Math" };
        ProfileManager dataStructuresClass = new ProfileManager();
        ArrayList<Profile> profiles = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Profile p = new Profile();
            p.setName(name[i]);
            p.setStatus(status[i]);
            profiles.add(p);
        }
        Profile start = profiles.get(0);
        System.out.println("~~~~~~~~~~~Adding all profiles with no friendships~~~~~~~~~~~~~\n\n");
        for (Profile p : profiles) {
            dataStructuresClass.addProfile(p);
            System.out.println("New profile added:\n" + p.display());
        }
        System.out.println("\n\n+++++++++New friendships++++++++++++\n\n");
        for (int i = 0; i < profiles.size() - 1; i++) {
            dataStructuresClass.createFriendship(profiles.get(i), profiles.get(i + 1));
            System.out.println(profiles.get(i).getName() + " and " + profiles.get(i + 1).getName()
                                                            +" are now friends");
        }
        System.out.println("\n\n+++++++++New friendships in Data Structures Class 2022++++++++++++\n\n");
        System.out.println(dataStructuresClass.display(start));
        System.out.println("\n\n+++++++++More new friendships++++++++++++\n\n");
        for (int i = 0; i < profiles.size() - 2; i++) {
            dataStructuresClass.createFriendship(profiles.get(i), profiles.get(i + 2));
            System.out.println(profiles.get(i).getName() + " and " + profiles.get(i + 2).getName()
                    + " are now friends");
        }
        System.out.println("\n\n+++++++++More friendships in Data Structures Class 2022++++++++++++++\n\n");
        System.out.println(dataStructuresClass.display(start));
        System.out.println("\n\n-----------------Goodbye old friends of Data Structures Class 2022-------------\n\n");
        for (int i = 0; i < profiles.size() - 2; i++) {
            Profile p1 = profiles.get(i);
            Profile p2 = profiles.get(i + 2);
            if (p1.removeFriend(p2))
                System.out.println(p1.getName() + " and " + p2.getName() + " are not friends anymore");
            else
                System.out.println(p1.getName() + " and " + p2.getName()
                        + " were not friends so nothing changed");
        }
        System.out.println("\n\n-------------After broken hearts in the old friendships of Data Structures Class 2022-------------\n\n");
        System.out.println(dataStructuresClass.display(start));

    }
}