package com.reservaonline.reservaOnline.repositorios;

import com.reservaonline.reservaOnline.modelos.Funcionario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepositorio extends JpaRepository<Funcionario, Long> {

}
