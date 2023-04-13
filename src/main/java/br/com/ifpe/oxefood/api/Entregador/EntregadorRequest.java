package br.com.ifpe.oxefood.api.Entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.Entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {

   private String nome;

   private String cpf;

   private String rg;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate dataNascimento;

   private String foneCelular;

   private String foneFixo;

   private Integer qtdEntregasRealizadas;

   private Double Valorfrete;

   private String enderecoRua;

   private String enderecoNumero;

   private String enderecoBairro;

   private String enderecoCidade;

   private String enderecoCep;

   private String enderecoUf;

   private String enderecoComplemento;

   private Boolean ativo;

   public Entregador build() {

       return Entregador.builder()
               .nome(nome)
               .cpf(cpf)
               .rg(rg)
               .dataNascimento(dataNascimento)
               .foneCelular(foneCelular)
               .foneFixo(foneFixo)
               .qtdEntregasRealizadas(qtdEntregasRealizadas)
               .Valorfrete(Valorfrete)
               .enderecoRua(enderecoRua)
               .enderecoNumero(enderecoBairro)
               .enderecoBairro(enderecoBairro)
               .enderecoCidade(enderecoCidade)
               .enderecoCep(enderecoCep)
               .enderecoUf(enderecoUf)
               .enderecoComplemento(enderecoComplemento)
               .ativo (ativo)
              
               .build();
   }
}
