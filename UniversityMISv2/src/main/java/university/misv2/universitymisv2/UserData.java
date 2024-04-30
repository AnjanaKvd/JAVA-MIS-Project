package university.misv2.universitymisv2;

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
            return "/university/misv2/universitymisv2/images/profile_images/profile-default.jpeg";
        }else{
            return userProfileImage;
        }
    }
    public static void setUserProfileImage(String profileImage) {
        userProfileImage = profileImage;
    }
}