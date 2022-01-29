package com.reservaonline.reservaOnline.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservaonline.reservaOnline.modelos.Permissao;

public interface PermissaoRepositorio extends JpaRepository<Permissao, Long> {

}