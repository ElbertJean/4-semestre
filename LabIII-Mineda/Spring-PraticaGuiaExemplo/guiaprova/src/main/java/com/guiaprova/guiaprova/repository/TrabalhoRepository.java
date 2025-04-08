package com.guiaprova.guiaprova.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.guiaprova.guiaprova.entity.Trabalho;

@Repository
public interface TrabalhoRepository extends JpaRepository<Trabalho, Long> {
    
    @Query("SELECT t FROM Trabalho t WHERE LOWER(t.titulo) LIKE LOWER(CONCAT('%', :palavra, '%')) AND t.nota > :nota")
    List<Trabalho> findByTitleAndNote(@Param("palavra") String palavra, @Param("nota") Integer nota);

}
