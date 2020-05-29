package br.com.cadastrocomjpa.cadastrocomjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.cadastrocomjpa.cadastrocomjpa.DAO.CadastroRepositorio;
import br.com.cadastrocomjpa.cadastrocomjpa.DAO.Pessoa;

@Controller
public class Controlador {

    @Autowired
    CadastroRepositorio repositorio;

    @PostMapping(value = "index")
    public ModelAndView postMethodName(@RequestParam String nome, @RequestParam String cpf, @RequestParam String email,
            @RequestParam String dataN) {

        // Cria Objeto Pessoa
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setCpf(cpf);
        pessoa.setEmail(email);
        pessoa.setDataN(dataN);

        //Envia Onjeto Pessoa para o repositorio/Banco
        repositorio.save(pessoa);

        // Cria e retorna Modelo
        ModelAndView modelo = new ModelAndView();

        return modelo;

    }
}