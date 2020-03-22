/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

/**
 *
 * @author Karina
 */
public class Tovar {

    public Tovar() {
        this.name = "";
        this.kol = 0;
        this.price = 0;
    }

    public Tovar(String name, int kol, double price) {
        this.name = name;
        this.kol = kol;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKol() {
        return kol;
    }

    public void setKol(int kol) {
        this.kol = kol;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    private String name;
    private int kol;
    private double price;
}
