package br.com.ifpe.oxefood.modelo.cupomDesconto;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class cupomService extends GenericService {

   @Autowired
   private cupomRepository repository;

   @Transactional
   public cupomDesconto save(cupomDesconto cupomDesconto) {

       super.preencherCamposAuditoria(cupomDesconto);
       return repository.save(cupomDesconto);
   }

   public List<cupomDesconto> listarTodos() {
  
    return repository.findAll();
}

public cupomDesconto obterPorID(Long id) {

    return repository.findById(id).get();
}


}
