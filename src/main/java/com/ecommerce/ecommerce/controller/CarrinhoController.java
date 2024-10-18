package com.ecommerce.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.ecommerce.model.Carrinho;
import com.ecommerce.ecommerce.service.CarrinhoService;

@RestController
@RequestMapping("/api/carrinho")
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @PostMapping("/{carrinhoId}/adicionar/{produtoId}")
    public Carrinho adicionarProduto(@PathVariable Long carrinhoId, @PathVariable Long produtoId, @RequestParam Integer quantidade) {
        return carrinhoService.adicionarProduto(carrinhoId, produtoId, quantidade);
    }

    @DeleteMapping("/{carrinhoId}/remover/{itemCarrinhoId}")
    public Carrinho removerProduto(@PathVariable Long carrinhoId, @PathVariable Long itemCarrinhoId) {
        return carrinhoService.removerProduto(carrinhoId, itemCarrinhoId);
    }

    @GetMapping("/{carrinhoId}")
    public Carrinho visualizarCarrinho(@PathVariable Long carrinhoId) {
        return carrinhoService.visualizarCarrinho(carrinhoId);
    }
}

