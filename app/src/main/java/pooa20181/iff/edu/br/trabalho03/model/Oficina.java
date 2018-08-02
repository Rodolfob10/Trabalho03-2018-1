package pooa20181.iff.edu.br.trabalho03.model;

import java.io.Serializable;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Oficina extends RealmObject implements Serializable {


    @PrimaryKey
    private int id;
    private String nome;



    private String rua;
    private String bairro;
    private String municipio;
    private Double latitude;
    private Double longitude;



    public Oficina(){

    }

    public Oficina(int id, String nome, String rua)
    {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
    }

    public Oficina(int id, String nome, String rua, String bairro,
                     String municipio, Double latitude, Double longitude)
    {
        this.id = id;
        this.nome = nome;
        this.rua = rua;
        this.bairro = bairro;
        this.municipio = municipio;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}

