package com.greatlearning.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.greatlearning.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

	@Query(value = "select * from Tickets t where t.title like %:keyword% or t.description like %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);

}
