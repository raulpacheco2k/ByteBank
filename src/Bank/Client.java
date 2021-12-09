package Bank;

import InternalSystem.Authenticable;

public class Client extends Person implements Authenticable {

    private String password;

    public Client(String full_name, String profession, String document_cpf) {
        super(full_name, profession, document_cpf);
    }

    @Override
    public String getSenha() {
        return this.password;
    }

    @Override
    public void setSenha(String password) {
        this.password = password;
    }
}
