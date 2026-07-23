package org.example.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entity.ReciboImutavel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReciboRepository extends JpaRepository<ReciboImutavel, Integer> {

    List<ReciboImutavel> findAllBySucesso(Boolean sucesso);

    List<ReciboImutavel> findAllByCanalIgnoreCase(String canal);

    @Query("SELECT r FROM ReciboImutavel r WHERE r.destinatario LIKE %:dominio")
    List<ReciboImutavel> findAllByDominio(String dominio);

}
