package com.example.travel;

public class searchdetail {
    private String dest;
    private String arr;
    private String date;
    private String passen;
    private String classe;
    public searchdetail(){

    }
    public searchdetail(String dest, String arr, String date, String passen, String classe) {
        this.dest = dest;
        this.arr = arr;
        this.date = date;
        this.passen = passen;
        this.classe = classe;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getArr() {
        return arr;
    }

    public void setArr(String arr) {
        this.arr = arr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPassen() {
        return passen;
    }

    public void setPassen(String passen) {
        this.passen = passen;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }
}
