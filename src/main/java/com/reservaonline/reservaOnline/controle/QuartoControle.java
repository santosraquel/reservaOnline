package com.reservaonline.reservaOnline.controle;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.reservaonline.reservaOnline.modelos.Funcionario;
import com.reservaonline.reservaOnline.repositorios.CidadeRepositorio;
import com.reservaonline.reservaOnline.repositorios.FuncionarioRepositorio;

@Controller
public class QuartoControle {

    @Autowired
    private FuncionarioRepositorio quartoRepositorio;

    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    @GetMapping("/administrativo/quartos/cadastrar")
    public ModelAndView cadastrar(Quarto quarto) {
        ModelAndView mv = new ModelAndView("administrativo/quartos/cadastro");
        mv.addObject("quarto", quarto);
        mv.addObject("listaCidades", cidadeRepositorio.findAll());
        return mv;
    }

    @GetMapping("/administrativo/quartos/listar")
    public ModelAndView listar() {
        ModelAndView mv = new ModelAndView("administrativo/quartos/lista");
        mv.addObject("listaQuartos", quartoRepositorio.findAll());
        return mv;
    }

    @GetMapping("/administrativo/quartos/editar/{id}")
    public ModelAndView editar(@PathVariable("id") Long id) {
        Optional<Quarto> quarto = quartoRepositorio.findById(id);
        return cadastrar(quarto.get());
    }

    @GetMapping("/administrativo/quartos/remover/{id}")
    public ModelAndView remover(@PathVariable("id") Long id) {
        Optional<Quarto> quarto = quartoRepositorio.findById(id);
        quartoRepositorio.delete(quarto.get());
        return listar();
    }

    @PostMapping("/administrativo/quartos/salvar")
    public ModelAndView salvar(@Valid Quarto quarto, BindingResult result) {

        // System.out.println(result.getAllErrors());
        if (result.hasErrors()) {
            return cadastrar(quarto);
        }
        // quarto.setSenha(new
        // BCryptPasswordEncoder().encode(quarto.getSenha()));
        quartoRepositorio.saveAndFlush(quarto);

        return cadastrar(new Quarto());
    }

}

