package com.wipro.gama.bankapp.repository;

import com.wipro.gama.bankapp.model.ContaEspecial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaEspecialRepository extends JpaRepository<ContaEspecial, Integer> {


}
