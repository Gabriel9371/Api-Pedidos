package br.com.PedidosAPI.ordering_system.dto.clienteDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClienteCreateRequest {

    @NotBlank(message = "nome é obrigatorio!")
    private String nome;

    @NotBlank(message = "email é obrigatorio!")
    @Email
    private String email;


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
