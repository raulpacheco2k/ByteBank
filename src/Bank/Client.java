package Bank;

import InternalSystem.Authenticable;
import InternalSystem.Authenticator;

public class Client extends Person implements Authenticable {

    private Authenticator authenticator;

    public Client(String full_name, String profession, String document_cpf) {
        super(full_name, profession, document_cpf);
        this.authenticator = new Authenticator();
    }

    @Override
    public String getPassword() {
        return this.authenticator.getPassword();
    }

    @Override
    public void setPassword(String password) {
        this.authenticator.setPassword(password);
    }
}
