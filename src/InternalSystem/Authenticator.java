package InternalSystem;

public class Authenticator implements Authenticable {
    String password;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }
}
