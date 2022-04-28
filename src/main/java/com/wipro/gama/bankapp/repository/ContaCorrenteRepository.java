package com.wipro.gama.bankapp.repository;

import com.wipro.gama.bankapp.model.ContaCorrente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Integer> {

}