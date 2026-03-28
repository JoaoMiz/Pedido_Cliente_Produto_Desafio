package xped.desafio.service;

import xped.desafio.model.Cliente;
import xped.desafio.model.Pedido;
import xped.desafio.model.Produto;
import xped.desafio.repository.ClienteRepository;
import xped.desafio.repository.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xped.desafio.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    //Buscar entidades antes de fazer a persistencia, pra aparecer nome valor etc
    public Pedido salvar(Pedido pedido) {

        Cliente cliente = clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow();

        List<Produto> produtos = pedido.getProdutos().stream()
                .map(p -> produtoRepository.findById(p.getId()).orElseThrow())
                .toList();

        pedido.setCliente(cliente);
        pedido.setProdutos(produtos);

        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }

    public long contarPedidos() {
        return pedidoRepository.count();
    }
}