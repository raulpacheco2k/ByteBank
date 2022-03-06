package br.com.bytebank.HumanResources.Interfaces;

public interface Bonifiable<T>{
    public T setBonus();
    public double getBonus();
    public double calculateBonus(double bonus);
}
