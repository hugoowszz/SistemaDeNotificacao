package org.example.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import org.example.entity.ReciboImutavel;
import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReciboRepository extends JpaRepository<ReciboImutavel, Integer> {
}
