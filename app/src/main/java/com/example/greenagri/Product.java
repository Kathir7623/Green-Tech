package com.example.greenagri;

public class Product {
    int id;
    String patentid, onone, ontwo, onthree, onfour, onfive;


    public Product(String onone, String ontwo, String onthree, String onfour, String onfive) {
        //this.patentid = patentid;
        this.onone = onone;
        this.ontwo = ontwo;
        this.onthree = onthree;
        this.onfour = onfour;
        this.onfive = onfive;


    }


    public String getOnone() {
        return onone;
    }

    public String getOntwo() {
        return ontwo;
    }

    public String getOnthree() {
        return onthree;
    }

    public String getOnfour() {
        return onfour;
    }

    public String getOnfive() {
        return onfive;
    }


}
