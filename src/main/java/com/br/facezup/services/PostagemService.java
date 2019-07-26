package com.br.facezup.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.br.facezup.models.PostagemModel;
import com.br.facezup.respository.PostagemRespository;

@Service
public class PostagemService {
	@Autowired
	private PostagemRespository postagemRepository;

	public void salvarUsuario(PostagemModel user) {
		postagemRepository.save(user);
	}

	public void salvarPostagem(PostagemModel postagemModel) {
		postagemModel.setId(null);
		postagemRepository.save(postagemModel);
	}

	public  Iterable<PostagemModel> pegarTodosUsuarios(){
		return postagemRepository.findAll();
	}

	public PostagemModel procurarPostagem(Integer id) {
		return postagemRepository.findById(id).get();
	}

	public long quantityOfPost(){
		return postagemRepository.count();
	}
	public PostagemModel pegarPostagemPeloID(int id) {
		if(postagemRepository.existsById(id)) {
			return postagemRepository.findById(id).get();
		}
		return null;
	}
	public void updatePostagem(int id, PostagemModel postagem) {
		postagem.setId(id);
		postagemRepository.save(postagem);
	}
	public void deleteMesseger(int id) {
		postagemRepository.deleteById(id);
	}
}
