package socialnetwork;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //Here when the program first runs I populate the users with some data.This acts as our in memory db.
        //It populates data for our test user being UserA,userB,userC.
        //here i used just a simple integer for the user id.
        List<Integer> userAFollowers = new ArrayList<>();
        userAFollowers.add(2);
        userAFollowers.add(40);
        userAFollowers.add(6);
        userAFollowers.add(17);
        User userA = new User(1, "agesa", userAFollowers);

        //UserB
        List<Integer> userBFollowers = new LinkedList<>();
        userBFollowers.add(1);
        userBFollowers.add(4);
        userBFollowers.add(7);
        userBFollowers.add(8);
        User userB = new User(2, "John", userBFollowers);
        System.out.println(userB.toString());

        //userC
        List<Integer> userCFollowers = new ArrayList<>();
        userCFollowers.add(11);
        userCFollowers.add(4);
        userCFollowers.add(7);
        userCFollowers.add(8);
        User userC = new User(100, "Jane", userCFollowers);
        System.out.println(userC.toString()); //printing to see the details for userB

        //here we test our fuction for adding a new friend,we pass the user we want to add a friend to and also the id of the
        //friend we want to add.Here we test our unction by add a new friend to user C.
        addFriendship(userC, 54);
        //here we print to the list of friends for user C to see if it was updated.
        System.out.println("New User C friends: " + userCFollowers);
        //here we find suggested list of friends by comparing two user objects and identifying if they have mutual friends.
        getSuggestedFriends(userA, userC);

    }

    //here we have a function to add a new friend.
    //to add the user I will first check if the new user to be added is already connected to the existing user
    //if the user doesn't exist then I will add that user to then friendship of the given else I will return a string
    // saying the two users are already connected
    private static void addFriendship(User user, Integer userToAddId) {
        //userToAddId this is the id of the user that I want to add to be the friend of our user
        List<Integer> userFollowers = user.getFollowersId();
        System.out.println("Existing followers are " + userFollowers);
        int i = 0;
        while (i < userFollowers.size()) {
            if (Objects.equals(userFollowers.get(i), userToAddId)) {
                break;
            } else {
                userFollowers.add(userToAddId);

            }
            i++;
        }

        System.out.println("New  followers are " + userFollowers);

    }

    //get suggested friends
    //here I compare the list of friends between the users.
    public static void getSuggestedFriends(User a, User b) {
        List<Integer> userAFollowers = a.getFollowersId();
        List<Integer> userBFollowers = b.getFollowersId();
        List<Integer> suggestedFriendsList = new LinkedList<>();
        //here i will compare  to see if the two users have the same type of friend then
//        i will increment a counter for each positive result that is when the two users  are found to have the same friend Id
        int count = 0;
        for (Integer follower : userAFollowers) {
            for (Integer followerB : userBFollowers) {
                if (Objects.equals(followerB, follower)) {
                    count = count + 1;
                    suggestedFriendsList.add(follower);
                }
            }
        }
        System.out.println("Shared Mutual Friends" + suggestedFriendsList);

    }

}