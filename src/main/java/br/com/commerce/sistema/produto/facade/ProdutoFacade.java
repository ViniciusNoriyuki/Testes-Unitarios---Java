package br.com.commerce.sistema.produto.facade;

import br.com.commerce.sistema.produto.mapper.ProdutoMapper;
import br.com.commerce.sistema.produto.model.ProdutoEntity;
import br.com.commerce.sistema.produto.model.ProdutoEntrada;
import br.com.commerce.sistema.produto.model.ProdutoSaida;
import br.com.commerce.sistema.produto.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoFacade {

    @Autowired
    ProdutoRepository produtoRepository;

    public ProdutoSaida criarProduto(ProdutoEntrada entrada) throws Exception {

        // ENTRADA PARA ENTIDADE =>
        ProdutoEntity produtoEntity = ProdutoMapper.Instance.converterEntradaParaEntity(entrada);

        // ENTIDADE PARA BANCO =>
        produtoEntity = produtoRepository.save(produtoEntity);

        // ENTIDADE PARA SAIDA
        ProdutoSaida saida = ProdutoMapper.Instance.converterEntityParaSaida(produtoEntity);

        return saida;
    }

    public ProdutoEntity retornarProdutoEntity(Long idProduto) throws Exception {
        ProdutoEntity entidade;
        Optional<ProdutoEntity> retornoBanco = produtoRepository.findById(idProduto);

        if (!retornoBanco.isPresent()) {
            throw new Exception("Nao encontrado!");
        }
        entidade = retornoBanco.get();

        return entidade;
    }
}
