package br.com.ifpe.oxefood.api.categoriaProduto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.Where;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.CategoriaProduto.categoriaProdutoService;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import br.com.ifpe.oxefood.util.entity.GenericController;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "CategoriaProduto")
@Where(clause ="habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class categoriaProdutoController extends EntidadeAuditavel{

    @Colunm
    private String descricao;
    
@RestController
@RequestMapping("/api/categoriaProduto")
public class ClienteController extends GenericController {

    @Autowired 
    private categoriaProdutoService;

   @PostMapping
   public ResponseEntity<CategoriaProduto> save(@RequestBody @Valid CategoriaProdutoRequest request) {

       CategoriaProduto categoriaProdutoNovo = request.build();
       CategoriaProduto categoriaProduto = categoriaProdutoService.save(categoriaProdutoNovo);
       return new ResponseEntity<CategoriaProduto>(categoriaProduto, HttpStatus.CREATED);
   }

   @GetMapping
   public List<CategoriaProduto> listarTodos() {
  
       return categoriaProdutoService.listarTodos();
   }

   @GetMapping("/{id}")
   public CategoriaProduto obterPorID(@PathVariable Long id) {

       return categoriaProdutoService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<categoriaProdutoService> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request) {

       categoriaProdutoService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       categoriaProdutoService.delete(id);
       return ResponseEntity.ok().build();
   } 
}
}
