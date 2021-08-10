package br.gov.sp.feiras.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;

@Entity
@Table(name = "feiras")
public class Feira {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(nullable = false, name = "LAT")
    private Double lat;

    @Column(nullable = false, name = "LONG")
    private Double lon;

    @Column(nullable = false, name = "SETCENS")
    private String setcens;

    @Column(nullable = false, name = "AREAP")
    private String areaP;

    @Column(nullable = false, name = "CODDIST")
    private Integer codDist;

    @Column(nullable = false, name = "DISTRITO")
    private String distrito;

    @Column(nullable = false, name = "CODSUBPREF")
    private Integer codigoSubPrefeitura;

    @Column(nullable = false, name = "SUBPREFE")
    private String subPrefeitura;

    @Column(nullable = false, name = "REGIAO5")
    private String regiao5;

    @Column(nullable = false, name = "REGIAO8")
    private String regiao8;

    @Column(nullable = false, name = "NOME_FEIRA")
    private String nomeFeira;

    @Column(nullable = false, name = "REGISTRO")
    private String registro;

    @Column(nullable = false, name = "LOGRADOURO")
    private String logradouro;

    @Column(nullable = false, name = "NUMERO")
    private String numero;

    @Column(nullable = false, name = "BAIRRO")
    private String bairro;

    @Column(nullable = false, name = "REFERENCIA")
    private String referencia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getSetcens() {
        return setcens;
    }

    public void setSetcens(String setcens) {
        this.setcens = setcens;
    }

    public String getAreaP() {
        return areaP;
    }

    public void setAreaP(String areaP) {
        this.areaP = areaP;
    }

    public Integer getCodDist() {
        return codDist;
    }

    public void setCodDist(Integer codDist) {
        this.codDist = codDist;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Integer getCodigoSubPrefeitura() {
        return codigoSubPrefeitura;
    }

    public void setCodigoSubPrefeitura(Integer codigoSubPrefeitura) {
        this.codigoSubPrefeitura = codigoSubPrefeitura;
    }

    public String getSubPrefeitura() {
        return subPrefeitura;
    }

    public void setSubPrefeitura(String subPrefeitura) {
        this.subPrefeitura = subPrefeitura;
    }

    public String getRegiao5() {
        return regiao5;
    }

    public void setRegiao5(String regiao5) {
        this.regiao5 = regiao5;
    }

    public String getRegiao8() {
        return regiao8;
    }

    public void setRegiao8(String regiao8) {
        this.regiao8 = regiao8;
    }

    public String getNomeFeira() {
        return nomeFeira;
    }

    public void setNomeFeira(String nomeFeira) {
        this.nomeFeira = nomeFeira;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

}
