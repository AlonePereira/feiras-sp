package br.gov.sp.feiras.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class FeiraDTO {

    @NotNull(message = "lat é Obrigatório")
    private Double lat;

    @NotNull(message = "long é Obrigatório")
    @JsonProperty("long")
    private Double lon;

    @NotBlank(message = "setcens é Obrigatório")
    private String setcens;

    @NotBlank(message = "areap é Obrigatório")
    @JsonProperty("areap")
    private String areaP;

    @NotNull(message = "coddist é Obrigatório")
    @Min(value = 1, message = "Valor de coddist está inválido, o valor mínimo é 1")
    @JsonProperty("coddist")
    private Integer codDist;

    @NotBlank(message = "distrito é Obrigatório")
    private String distrito;

    @NotNull(message = "codsubpref é Obrigatório")
    @Min(value = 1, message = "Valor de codsubpref está inválido, o valor mínimo é 1")
    @JsonProperty("codsubpref")
    private Integer codigoSubPrefeitura;

    @NotBlank(message = "subprefe é Obrigatório")
    @JsonProperty("subprefe")
    private String subPrefeitura;

    @NotBlank(message = "regiao5 é Obrigatório")
    private String regiao5;

    @NotBlank(message = "regiao8 é Obrigatório")
    private String regiao8;

    @NotBlank(message = "nome_feira é Obrigatório")
    @JsonProperty("nome_feira")
    private String nomeFeira;

    @NotBlank(message = "Registro é obrigatório")
    private String registro;

    @NotBlank(message = "logradouro é Obrigatório")
    private String logradouro;

    private String numero;

    @NotBlank(message = "bairro é Obrigatório")
    private String bairro;

    private String referencia;

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
