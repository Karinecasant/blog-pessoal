package org.generation.blogPessoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.generation.blogPessoal.model.ContatoModel;

public interface ContatoRepository extends JpaRepository<ContatoModel, Long> {
}