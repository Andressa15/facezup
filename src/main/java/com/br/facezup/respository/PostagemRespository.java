package com.br.facezup.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.facezup.models.PostagemModel;

@Repository
public interface PostagemRespository extends CrudRepository<PostagemModel, Integer> {

}
