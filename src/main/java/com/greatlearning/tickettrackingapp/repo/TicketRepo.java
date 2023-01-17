package com.greatlearning.tickettrackingapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.greatlearning.tickettrackingapp.entity.Ticket;

@Repository
public interface TicketRepo extends JpaRepository<Ticket, Integer> {

	// custom query for search operation
	@Query(value = "select * from Tickets t where t.title like %:keyword% or t.description like %:keyword%", nativeQuery = true)
	List<Ticket> findByKeyword(@Param("keyword") String keyword);
}
