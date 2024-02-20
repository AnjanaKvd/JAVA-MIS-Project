package mis.university;

public class UserData {
    private static int userId;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserData.userId = userId;
    }
}