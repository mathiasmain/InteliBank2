public enum EUser {

    ADMIN, CLIENT;

    public static String getType(EUser user_type) {
        if (user_type == EUser.ADMIN) {
            return "Admin";
        } else {
            return "Client";
        }
    }
}
