package br.com.ifpe.oxefood.api.Produto;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.Produto.Produto;
import br.com.ifpe.oxefood.modelo.Produto.ProdutoService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/Produto")
public class ProdutoController extends GenericController {

   @Autowired
   private ProdutoService ProdutoService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

       Produto Produto = ProdutoService.save(request.build());
       return new ResponseEntity<Produto>(Produto, HttpStatus.CREATED);
   }
}


