package com.ecommerce.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.ecommerce.model.Carrinho;
import com.ecommerce.ecommerce.model.ItemCarrinho;
import com.ecommerce.ecommerce.model.Produto;
import com.ecommerce.ecommerce.repository.CarrinhoRepository;
import com.ecommerce.ecommerce.repository.ItemCarrinhoRepository;
import com.ecommerce.ecommerce.repository.ProdutoRepository;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ItemCarrinhoRepository itemCarrinhoRepository;

    public Carrinho adicionarProduto(Long carrinhoId, Long produtoId, Integer quantidade) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        Produto produto = produtoRepository.findById(produtoId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        ItemCarrinho itemCarrinho = new ItemCarrinho();
        itemCarrinho.setProduto(produto);
        itemCarrinho.setQuantidade(quantidade);
        itemCarrinho.setPrecoUnitario(produto.getPreco());

        carrinho.getItens().add(itemCarrinho);
        atualizarValorTotal(carrinho);

        itemCarrinhoRepository.save(itemCarrinho);
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho removerProduto(Long carrinhoId, Long itemCarrinhoId) {
        Carrinho carrinho = carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));

        ItemCarrinho item = itemCarrinhoRepository.findById(itemCarrinhoId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        carrinho.getItens().remove(item);
        itemCarrinhoRepository.delete(item);
        atualizarValorTotal(carrinho);

        return carrinhoRepository.save(carrinho);
    }

    public Carrinho visualizarCarrinho(Long carrinhoId) {
        return carrinhoRepository.findById(carrinhoId)
                .orElseThrow(() -> new RuntimeException("Carrinho não encontrado"));
    }

    private void atualizarValorTotal(Carrinho carrinho) {
        Float valorTotal = carrinho.getItens().stream()
            .map(item -> item.getPrecoUnitario() * item.getQuantidade())
            .reduce(0.0f, Float::sum);  
    carrinho.setValorTotal(valorTotal);
    }
}

