package br.com.commerce.sistema.usuario.facade;

import br.com.commerce.sistema.conta.model.ContaEntity;
import br.com.commerce.sistema.conta.repository.ContaRepository;
import br.com.commerce.sistema.usuario.mapper.UsuarioMapper;
import br.com.commerce.sistema.usuario.model.UsuarioEntity;
import br.com.commerce.sistema.usuario.model.UsuarioEntrada;
import br.com.commerce.sistema.usuario.model.UsuarioSaida;
import br.com.commerce.sistema.usuario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioFacade {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ContaRepository contaRepository;

    public UsuarioSaida criarUsuario(UsuarioEntrada entrada) throws Exception {

        // ENTRADA PARA ENTIDADE =>
        List<ContaEntity> listaContasAguardando = contaRepository.findByStatus("AGUARDANDO");
        listaContasAguardando.get(0).setStatus("ABERTA");

        List<ContaEntity> listaContas = new ArrayList<>();
        listaContas.add(listaContasAguardando.get(0));
        UsuarioEntity entidade = UsuarioMapper.Instance.converterEntradaParaEntity(entrada, listaContas);

        // ENTIDADE PARA BANCO =>
        entidade = usuarioRepository.save(entidade);

        // ENTIDADE PARA SAIDA
        UsuarioSaida saida = UsuarioMapper.Instance.converterEntityParaSaida(entidade);

        return saida;
    }

    public UsuarioEntity retornarUsuarioEntity(Long idUsuario) throws Exception {
        UsuarioEntity entidade;
        Optional<UsuarioEntity> retornoBanco = usuarioRepository.findById(idUsuario);

        if (!retornoBanco.isPresent()) {
            throw new Exception("Nao encontrado!");
        }
        entidade = retornoBanco.get();

        return entidade;
    }
}
