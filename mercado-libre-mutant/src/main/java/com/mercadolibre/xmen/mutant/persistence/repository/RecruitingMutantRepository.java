package com.mercadolibre.xmen.mutant.persistence.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mercadolibre.xmen.mutant.persistence.entity.RecruitingMutantEntity;

@Repository
public interface RecruitingMutantRepository extends JpaRepository<RecruitingMutantEntity, Serializable> {
	public long countByMutant(boolean mutant);

}
