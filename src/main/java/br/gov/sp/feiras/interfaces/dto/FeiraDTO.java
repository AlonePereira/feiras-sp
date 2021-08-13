package br.gov.sp.feiras.interfaces.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeiraDTO {

    private Double lat;

    @JsonProperty("long")
    private Double lon;

    private String setcens;

    @JsonProperty("areap")
    private String areaP;

    @JsonProperty("coddist")
    private Integer codDist;

    private String distrito;

    @JsonProperty("codsubpref")
    private Integer codigoSubPrefeitura;

    @JsonProperty("subprefe")
    private String subPrefeitura;

    private String regiao5;
    private String regiao8;

    @JsonProperty("nome_feira")
    private String nomeFeira;
    private String registro;
    private String logradouro;
    private String numero;
    private String bairro;
    private String referencia;

}
