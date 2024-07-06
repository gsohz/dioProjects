package edu.gsohz.padroes_projeto_spring.repository;

import edu.gsohz.padroes_projeto_spring.model.Cliente;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}