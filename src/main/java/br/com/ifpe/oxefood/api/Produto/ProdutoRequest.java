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

    private Long idCategoria;

   private String codigo;

   private String titulo;

   private String descricao;

   private Double valorUnitario;

   private Integer tempodeEntregaMinimo;

   private Integer tempodeEntregaMaximo;

   public Produto build() {

       return Produto.builder()
               .codigo(codigo)
               .titulo(titulo)
               .descricao(descricao)
               .valorUnitario(valorUnitario)
               .tempoEntregaMinimo(tempodeEntregaMinimo)
               .tempoEntregaMaximo(tempodeEntregaMaximo)
               .build();
   }
}

