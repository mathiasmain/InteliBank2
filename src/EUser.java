public enum EUser {

    ADMIN, CLIENT;

    public static String getType(EUser user_type) {
        if (user_type == EUser.ADMIN) {
            return "Admin";
        } else {
            return "Client";
        }
    }
    public static EUser toEnumUser(String user)
    {
        return switch (user) {
            case "ADMIN" -> EUser.ADMIN;
            case "CLIENT" -> EUser.CLIENT;
            default -> null;
        };
    }
}
