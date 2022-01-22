package br.com.bytebank.InternalSystem.Models;

import br.com.bytebank.InternalSystem.Interfaces.Authenticable;

import java.util.Objects;

public class InternalSystem {
    public boolean authenticate(String password, Authenticable user){
        return Objects.equals(user.getPassword(), password);
    }
}
