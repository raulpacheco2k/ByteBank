package br.com.bytebank.Bank.Models;

public abstract class Person {
    private String full_name;
    private String document_cpf;

    public Person(String full_name, String document_cpf) {
        this.full_name = full_name;
        this.document_cpf = document_cpf;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getDocument_cpf() {
        return document_cpf;
    }

    public void setDocument_cpf(String document_cpf) {
        this.document_cpf = document_cpf;
    }
}
