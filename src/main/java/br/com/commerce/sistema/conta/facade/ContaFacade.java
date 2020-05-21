package br.com.commerce.sistema.conta.facade;

import br.com.commerce.sistema.conta.mapper.ContaMapper;
import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.model.ContaEntrada;
import br.com.commerce.sistema.conta.model.ContaSaida;
import br.com.commerce.sistema.conta.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaFacade {

    @Autowired
    ContaRepository contaRepository;

    public ContaSaida criarConta(ContaEntrada entrada) throws Exception {

        // ENTRADA PARA ENTIDADE =>
        ContaEntity contaEntity = ContaMapper.Instance.converterEntradaParaEntity(entrada);
        contaEntity.setStatus("AGUARDANDO");

        // ENTIDADE PARA BANCO =>
        contaEntity = contaRepository.save(contaEntity);

        // ENTIDADE PARA SAIDA
        ContaSaida saida = ContaMapper.Instance.converterEntityParaSaida(contaEntity);

        return saida;
    }
}
