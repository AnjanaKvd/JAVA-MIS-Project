package university.misv2.universitymisv2;

public class UserData {
    private static int userId;

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        UserData.userId = userId;
    }
}
