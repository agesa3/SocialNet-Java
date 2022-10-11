package socialnetwork;

import java.util.List;

public class User {
    private int userId;
    private String username;
    private List<Integer> followersId;

    public User(int userId, String username, List<Integer> followersId) {
        this.userId = userId;
        this.username = username;
        this.followersId = followersId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Integer> getFollowersId() {
        return followersId;
    }

    public void setFollowersId(List<Integer> followersId) {
        this.followersId = followersId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", followersId=" + followersId +
                '}';
    }
}
