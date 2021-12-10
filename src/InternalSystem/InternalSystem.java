package InternalSystem;

import java.util.Objects;

public class InternalSystem {
    public boolean authenticate(String password, Authenticable user){
        return Objects.equals(user.getPassword(), password);
    }
}
