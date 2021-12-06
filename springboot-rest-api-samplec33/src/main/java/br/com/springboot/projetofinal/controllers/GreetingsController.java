package br.com.springboot.projetofinal.controllers;

import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import antlr.collections.List;
import br.com.springboot.projetofinal.modelo.Usuario;
import br.com.springboot.projetofinal.repository.UsuarioRepository;

/**
 *
 * A sample greetings controller to return greeting text
 */
@RestController
public class GreetingsController {
	@Autowired
	private UsuarioRepository usuarioRepository;
    /**
     *
     * @param name the name to greet
     * @return greeting text
     */
	
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String greetingText(@PathVariable String name) {
        return "hello" + name + "!";
    }
    
    @RequestMapping(value = "mostrarnome/{nome}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String Mostrarnome(@PathVariable String nome) {
    	
    	Usuario usuario = new Usuario();
    	usuario.setNome(nome);
    	
    	usuarioRepository.save(usuario);
    	return "seja bem vindo"+nome;
    	    	
    }
    @GetMapping(value="listatodos")
    @ResponseBody
    public ResponseEntity<java.util.List<Usuario>> listaUsuario(){
		
    	java.util.List<Usuario> usuarios= usuarioRepository.findAll();
    	return new ResponseEntity<java.util.List<Usuario>>(usuarios,HttpStatus.OK);
    	
    }
    
    @PostMapping(value="salvar")
    @ResponseBody
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuarios){
    	
    	Usuario user= usuarioRepository.save(usuarios);
    	return new ResponseEntity<Usuario>(user,HttpStatus.OK);
    }
   
   
}
