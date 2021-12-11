package Bank;

import HumanResources.Occupation;
import InternalSystem.Authenticable;
import InternalSystem.Authenticator;

public class Client extends Person implements Authenticable {

    private Authenticator authenticator;
    public Occupation occupation;

    public Client(String full_name, String document_cpf, double salary, String profession) {
        super(full_name, document_cpf);
        this.authenticator = new Authenticator();
        this.occupation = new Occupation(salary, profession);
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
