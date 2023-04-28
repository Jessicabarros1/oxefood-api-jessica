package br.com.ifpe.oxefood.api.Produto;

import br.com.ifpe.oxefood.modelo.Produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

   private String codigodoProduto;

   private String titulo;

   private String Descricao;

   private Double valorUnitario;

   private Integer tempodeEntregaMinimoemMinutos;

   private Integer tempodeEntregaMaximoemMinutos;

   public Produto build() {

       return Produto.builder()
               .codigo(codigodoProduto)
               .titulo(titulo)
               .descricao(Descricao)
               .valorUnitario(valorUnitario)
               .tempoEntregaMinimo(tempodeEntregaMinimoemMinutos)
               .tempoEntregaMaximo(tempodeEntregaMaximoemMinutos)
               .build();
   }
}

