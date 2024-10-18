package com.ecommerce.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.ecommerce.model.Carrinho;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
}
