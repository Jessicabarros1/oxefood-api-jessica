package br.com.ifpe.oxefood.api.Produto;

import java.util.List;

import javax.validation.Valid;

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

import br.com.ifpe.oxefood.modelo.Produto.Produto;
import br.com.ifpe.oxefood.modelo.Produto.ProdutoService;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoCliente;
import br.com.ifpe.oxefood.modelo.cliente.EnderecoClienteRequest;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/Produto")
public class ProdutoController extends GenericController {

   @Autowired
   private ProdutoService ProdutoService;

   @Autowired
   private CategoriaProdutoService categoriaProdutoService;

   @PostMapping
   public ResponseEntity<Produto> save(@RequestBody @Valid ProdutoRequest request) {

       Produto produtoNovo = request.build();
       produtoNovo.setCategoria(CategoriaProdutoService.obterPorID(request.getIdCategoria()));
       Produto produto = produtoService.save(produtoNovo);
       return new ResponseEntity<Produto>(produto, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Produto> listarTodos() {
  
       return ProdutoService.listarTodos();
   }

   @GetMapping("/{id}")
   public Produto obterPorID(@PathVariable Long id) {

       return ProdutoService.obterPorID(id);
   }

   @PutMapping("/{id}")
   public ResponseEntity<Produto> update(@PathVariable("id") Long id, @RequestBody ProdutoRequest request) {

      Produto produto = request.build();
       produto.setCategoria(categoriaProdutoService.obterPorID(request.getIdCategoria()));
       produtoService.update(id, produto);
   }

    @DeleteMapping("/{id}")
   public ResponseEntity<Void> delete(@PathVariable Long id) {

       ProdutoService.delete(id);
       return ResponseEntity.ok().build();


       @PostMapping("/endereco/{clienteId}")
   public ResponseEntity<EnderecoCliente> adicionarEnderecoCliente(@PathVariable("clienteId") Long clienteId, @RequestBody @Valid EnderecoClienteRequest request) {

       EnderecoCliente endereco = clienteService.adicionarEnderecoCliente(clienteId, request.build());
       return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.CREATED);
   }

   @PutMapping("/endereco/{enderecoId}")
   public ResponseEntity<EnderecoCliente> atualizarEnderecoCliente(@PathVariable("enderecoId") Long enderecoId, @RequestBody EnderecoClienteRequest request) {

       EnderecoCliente endereco = clienteService.atualizarEnderecoCliente(enderecoId, request.build());
       return new ResponseEntity<EnderecoCliente>(endereco, HttpStatus.OK);
   }
  
   @DeleteMapping("/endereco/{enderecoId}")
   public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("enderecoId") Long enderecoId) {

       clienteService.removerEnderecoCliente(enderecoId);
       return ResponseEntity.noContent().build();



}


