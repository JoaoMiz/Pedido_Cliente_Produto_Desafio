package xped.desafio.controller;

import xped.desafio.model.Pedido;
import xped.desafio.service.PedidoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List<Pedido> listarTodos() {
        return pedidoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Pedido buscarPorId(@PathVariable Long id) {
        return pedidoService.buscarPorId(id).orElse(null);
    }

    @GetMapping("/contar")
    public long contarPedidos() {
        return pedidoService.contarPedidos();
    }

    @PostMapping
    public Pedido salvar(@RequestBody Pedido pedido) {
        return pedidoService.salvar(pedido);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        pedidoService.deletar(id);
    }
}