package com.beca.concessionaria.repositories;

import com.beca.concessionaria.dminios.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface CarroRepository extends JpaRepository<Carro, Long> {
}