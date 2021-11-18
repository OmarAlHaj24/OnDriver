public class Admin extends User {
    public Admin(String username, String mobileNumber, String email, String password) {
        super(username, mobileNumber, email, password, UserStatus.admin);
    }

    public void verifyDriver(Driver driver) {
        driver.setVerified(true);
    }

    public Boolean suspend(String username) {
        DataManager manager = ListManager.getInstance();
        User user = manager.getUser(username);
        if (user == null) {
            return false;
        }
        if (user.getUserStatus() == UserStatus.suspended) {
            return false;
        }
        user.setUserStatus(UserStatus.suspended);
        return true;
    }
}
