package br.com.ifpe.oxefood.api.Entregador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.Entregador.Entregador;
import br.com.ifpe.oxefood.modelo.Entregador.EntregadorService;
import br.com.ifpe.oxefood.util.entity.GenericController;

@RestController
@RequestMapping("/api/Entregador")
public class entregadorController extends GenericController {
    @Autowired
    private EntregadorService EntregadorService;

   @PostMapping
   public ResponseEntity<Entregador> save(@RequestBody @Valid EntregadorRequest request) {

       Entregador Entregador = EntregadorService.save(request.build());
       return new ResponseEntity<Entregador>(Entregador, HttpStatus.CREATED);
   }

   @GetMapping
   public List<Entregador> listarTodos() {
  
       return EntregadorService.listarTodos();
   }

   @GetMapping("/{id}")
   public Entregador obterPorID(@PathVariable Long id) {

       return EntregadorService.obterPorID(id);
   }

   
   @PutMapping("/{id}")
   public ResponseEntity<Entregador> update(@PathVariable("id") Long id, @RequestBody EntregadorRequest request) {

       EntregadorService.update(id, request.build());
       return ResponseEntity.ok().build();
   }

}
