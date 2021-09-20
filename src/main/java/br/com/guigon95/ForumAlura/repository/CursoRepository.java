package br.com.guigon95.ForumAlura.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.guigon95.ForumAlura.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nomeCurso);

}
