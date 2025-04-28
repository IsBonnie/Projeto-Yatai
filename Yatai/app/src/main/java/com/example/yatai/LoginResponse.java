package com.example.yatai;

public class LoginResponse {
    private int usuarioId;
    private String usuarioNome;
    private String usuarioEmail;
    private String usuarioSenha;
    private String usuarioCpf;

    public LoginResponse(int usuarioId, String usuarioNome, String usuarioEmail, String usuarioSenha, String usuarioCpf) {
        this.usuarioId = usuarioId;
        this.usuarioNome = usuarioNome;
        this.usuarioEmail = usuarioEmail;
        this.usuarioSenha = usuarioSenha;
        this.usuarioCpf = usuarioCpf;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getUsuarioNome() {
        return usuarioNome;
    }

    public void setUsuarioNome(String usuarioNome) {
        this.usuarioNome = usuarioNome;
    }

    public String getUsuarioEmail() {
        return usuarioEmail;
    }

    public void setUsuarioEmail(String usuarioEmail) {
        this.usuarioEmail = usuarioEmail;
    }

    public String getUsuarioSenha() {
        return usuarioSenha;
    }

    public void setUsuarioSenha(String usuarioSenha) {
        this.usuarioSenha = usuarioSenha;
    }

    public String getUsuarioCpf() {
        return usuarioCpf;
    }

    public void setUsuarioCpf(String usuarioCpf) {
        this.usuarioCpf = usuarioCpf;
    }
}

