package com.claimTransfer.repository;
import com.claimTransfer.model.CarsDtClaimsLogsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsDtClaimsLogsRepository extends JpaRepository<CarsDtClaimsLogsEntity, String> {

}