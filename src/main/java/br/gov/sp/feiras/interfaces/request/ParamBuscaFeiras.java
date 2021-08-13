package br.gov.sp.feiras.interfaces.request;

public class ParamBuscaFeiras {

    private String distrito;
    private String regiao5;
    private String nomeFeira;
    private String bairro;

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getRegiao5() {
        return regiao5;
    }

    public void setRegiao5(String regiao5) {
        this.regiao5 = regiao5;
    }

    public String getNomeFeira() {
        return nomeFeira;
    }

    public void setNomeFeira(String nomeFeira) {
        this.nomeFeira = nomeFeira;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

}
