package br.com.ifpe.oxefood.api.cupomDesconto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.cupomDesconto.cupomDesconto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class cupomRequest {

   private Long id;

   private Long versao;

   private String codigoDesconto;

   private Double percentualDesconto;

   private String valorDesconto;

   private String valorMinimoPedidoPermitido;

   private String quantidadeMaximaUso;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate inicioVigencia;

   @JsonFormat(pattern = "dd/MM/yyyy")
   private LocalDate fimVigencia;

   public cupomDesconto build() {

       return cupomDesconto.builder()
                
               .id(id)
               .versao(versao)
               .codigoDesconto(codigoDesconto)
               .percentualDesconto(percentualDesconto)
               .valorDesconto(valorDesconto)
               .valorMinimoPedidoPermitido(valorDesconto)
               .quantidadeMaximaUso(quantidadeMaximaUso)
               .inicioVigencia(inicioVigencia)
               .fimVigencia(fimVigencia)

               .build();
   }
}
