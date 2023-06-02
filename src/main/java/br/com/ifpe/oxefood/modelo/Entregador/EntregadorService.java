package br.com.ifpe.oxefood.modelo.Entregador;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifpe.oxefood.util.entity.GenericService;

@Service
public class EntregadorService extends GenericService {

   @Autowired
   private EntregadorRepository repository;

   @Transactional
   public Entregador save(Entregador entregador) {

       super.preencherCamposAuditoria(entregador);
       return repository.save(entregador);
   }

   public List<Entregador> listarTodos() {
  
    return repository.findAll();
}

public Entregador obterPorID(Long id) {

    return repository.findById(id).get();
}

@Transactional
public void update(Long id, Entregador EntregadorAlterado) {

   Entregador Entregador = repository.findById(id).get();
   Entregador.setNome(EntregadorAlterado.getNome());
   Entregador.setCpf(EntregadorAlterado.getCpf());
   Entregador.setRg(EntregadorAlterado.getRg());
   Entregador.setDataNascimento(EntregadorAlterado.getDataNascimento());
   Entregador.setFoneCelular(EntregadorAlterado.getFoneCelular());
   Entregador.setFoneFixo(EntregadorAlterado.getFoneFixo());
   Entregador.setQtdEntregasRealizadas(EntregadorAlterado.getQtdEntregasRealizadas());
   Entregador.setValorFrete(EntregadorAlterado.getValorFrete());
   Entregador.setEnderecoRua(EntregadorAlterado.getEnderecoRua());
   Entregador.setEnderecoNumero(EntregadorAlterado.getEnderecoNumero());
   Entregador.setEnderecoBairro(EntregadorAlterado.getEnderecoBairro());
   Entregador.setEnderecoCidade(EntregadorAlterado.getEnderecoCidade());
   Entregador.setEnderecoCep(EntregadorAlterado.getEnderecoCep());
   Entregador.setEnderecoUf(EntregadorAlterado.getEnderecoUf());
   Entregador.setEnderecoComplemento(EntregadorAlterado.getEnderecoComplemento());
   Entregador.setAtivo(EntregadorAlterado.getAtivo());
     
   super.preencherCamposAuditoria(Entregador);
   repository.save(Entregador);

}
}