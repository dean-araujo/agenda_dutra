package com.deanaraujo.agenda.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.deanaraujo.agenda.entity.ContactEntity;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
	
	@Query("SELECT c FROM ContactEntity c WHERE c.id = :pId")
	public Optional<ContactEntity> searchById(@Param("pId")Long id);
	
}
