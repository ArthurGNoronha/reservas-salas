package com.response.dto;

public class ValidateResponseDTO {
    private boolean existe;
    private String nome;

    public ValidateResponseDTO() {}

    public ValidateResponseDTO(boolean existe, String nome) {
        this.existe = existe;
        this.nome = nome;
    }

    public boolean isExiste() { return existe; }
    public void setExiste(boolean existe) { this.existe = existe; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}