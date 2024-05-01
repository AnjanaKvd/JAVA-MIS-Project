package university.misv2.universitymisv2;

import java.nio.file.Paths;

public class UserData {
    private static String loggedInUsername;
    private static String fullName;
    private static String userProfileImage;

    public static String getLoggedInUsername() {
        return loggedInUsername;
    }

    public static void setLoggedInUsername(String username) {
        loggedInUsername = username;
    }

    public static String getFullName() {
        return fullName;
    }

    public static void setFullName(String name) {
        fullName = name;
    }
    public static String getUserProfileImage() {
        if(userProfileImage == null){
            String currentAbsolutePath = Paths.get("").toAbsolutePath().toString();
            String defaultImagePath = "/profile_images/profile-default.jpeg";
           return currentAbsolutePath + defaultImagePath;
        }else{
            return userProfileImage;
        }
    }
    public static void setUserProfileImage(String profileImage) {
        userProfileImage = profileImage;
    }

    public static void clearUserData(){
        loggedInUsername = null;
        fullName = null;
        userProfileImage = null;
    }
}
