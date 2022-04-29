package com.wipro.gama.bankapp.repository;

import com.wipro.gama.bankapp.model.Historico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricoRepository extends JpaRepository<Historico, Integer> {

}
