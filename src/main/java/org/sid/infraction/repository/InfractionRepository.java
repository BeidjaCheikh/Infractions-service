package org.sid.infraction.repository;

import org.sid.infraction.entites.Infraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface InfractionRepository extends JpaRepository<Infraction,Long> {
    List<Infraction> findByRadarId(Long radarId);
}
