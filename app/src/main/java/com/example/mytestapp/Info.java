package com.example.mytestapp;

public class Info {
    String id,op,cl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public  Info(String q1, String q2, String q3){
        id=q1;
        op=q2;
        cl=q3;

    }
}
