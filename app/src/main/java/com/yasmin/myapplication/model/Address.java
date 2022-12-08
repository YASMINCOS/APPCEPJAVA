package com.yasmin.myapplication.model;

public class Address {

    private String lograduro;
    private String bairro;
    private String localidade;
    private String uf;

    public String getLograduro() {
        return lograduro;
    }

    public void setLograduro(String lograduro) {
        this.lograduro = lograduro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }
}
