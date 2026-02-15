package com.my.practo.practo.repository;

import com.my.practo.practo.dto.RequestDTO;
import com.my.practo.practo.entity.Doctor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepositoryImpl implements DoctorRepositoryCustom{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Doctor> search(RequestDTO dto, Sort sort) {

        StringBuilder jpql = new StringBuilder("SELECT d FROM Doctor d WHERE 1=1");

        if (dto.query.getId() != null) {
            jpql.append(" AND d.id LIKE :id");
        }
        if (dto.query.getName() != null) {
            jpql.append(" AND LOWER(d.name) LIKE LOWER(:name)");
        }
        if (dto.query.getSpecialization() != null) {
            jpql.append(" AND LOWER(d.specialization) LIKE LOWER(:specialization)");
        }

        Query query = entityManager.createQuery(jpql.toString());

        if (dto.query.getId() != null) {
            query.setParameter("id", "%" + dto.query.getId() + "%");
        }
        if (dto.query.getName() != null) {
            query.setParameter("name", "%" + dto.query.getName() + "%");
        }
        if (dto.query.getSpecialization() != null) {
            query.setParameter("spec", "%" + dto.query.getSpecialization() + "%");
        }

        return query.getResultList();
    }
}