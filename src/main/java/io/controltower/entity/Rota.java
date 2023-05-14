package io.controltower.entity;

import com.sun.istack.NotNull;
import io.controltower.entity.enums.Status;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "O campo 'Placa' é obrigatório.")
    private String placa;
    @NotBlank(message = "O campo 'Frota' é obrigatório.")
    private String frota;
    @NotBlank(message = "O campo 'Motorista' é obrigatório.")
    private String motorista;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date data;
    @NotBlank(message = "O campo 'Origem' é obrigatório.")
    private String origem;
    @NotBlank(message = "O campo 'Destino' é obrigatório.")
    private String destino;
    private String observacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFrota() {
        return frota;
    }

    public void setFrota(String frota) {
        this.frota = frota;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rota rota = (Rota) o;

        if (!id.equals(rota.id)) return false;
        if (!Objects.equals(placa, rota.placa)) return false;
        if (!Objects.equals(frota, rota.frota)) return false;
        if (!Objects.equals(motorista, rota.motorista)) return false;
        if (status != rota.status) return false;
        if (!Objects.equals(data, rota.data)) return false;
        if (!Objects.equals(origem, rota.origem)) return false;
        if (!Objects.equals(destino, rota.destino)) return false;
        return Objects.equals(observacao, rota.observacao);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (placa != null ? placa.hashCode() : 0);
        result = 31 * result + (frota != null ? frota.hashCode() : 0);
        result = 31 * result + (motorista != null ? motorista.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (origem != null ? origem.hashCode() : 0);
        result = 31 * result + (destino != null ? destino.hashCode() : 0);
        result = 31 * result + (observacao != null ? observacao.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Rota{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", frota='" + frota + '\'' +
                ", motorista='" + motorista + '\'' +
                ", status=" + status +
                ", data=" + data +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
