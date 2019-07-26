package com.br.facezup.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.facezup.models.PostagemModel;
import com.br.facezup.services.PostagemService;
@Controller
public class postagemController {

	@RestController
	@RequestMapping("/postagens")
	public class PostagemController {

		@Autowired
		private PostagemService postagemService;

		@GetMapping
		public ResponseEntity<?> mostrarPostagens(){
			if(postagemService.quantityOfPost() > 0) {
				return ResponseEntity.ok(postagemService.quantityOfPost());
			}
			return ResponseEntity.noContent().build();
		}

		@GetMapping("/{id}")
		public ResponseEntity<PostagemModel> pegarMensagem(@PathVariable int id) {
			PostagemModel postagem = postagemService.pegarPostagemPeloID(id);
			if(postagem == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(postagem);
		}

	
		@PutMapping("/{id}")
		public ResponseEntity<PostagemModel> atualizarPostagem(@PathVariable int id, @RequestBody PostagemModel postagem) {
			postagemService.updatePostagem(id, postagem);
			return ResponseEntity.ok(postagem);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> apagarPostagem(@PathVariable int id) {
			postagemService.deleteMesseger(id);
			return ResponseEntity.ok().build();
		}
	}
}