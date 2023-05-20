package org.sid.infraction.web;

import org.sid.infraction.entites.Infraction;
import org.sid.infraction.repository.InfractionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class RestAPI {
    private InfractionRepository infractionRepository;

    public RestAPI(InfractionRepository infractionRepository) {
        this.infractionRepository = infractionRepository;
    }

    @GetMapping("/infractions")
    public List<Infraction> getInfractions(){
        return infractionRepository.findAll();
    }

    // - Read by id
    @GetMapping("/infractions/{id}")
    public Infraction getInfractionById(@PathVariable("id") Long id){
        return infractionRepository.findById(id).get();
    }

    // - Save infraction
    @PostMapping("/infractions")
    public Infraction saveInfraction(@RequestBody Infraction infraction){
        return infractionRepository.save(infraction);
    }

    @PutMapping("/infractions/{id}")
    public Infraction updateInfraction(@PathVariable("id") Long id, @RequestBody Infraction infraction) {
        if (infractionRepository.existsById(id)) {
            Infraction savedInfraction = infractionRepository.findById(id).get();
            if (infraction.getVehicleSpeed() != null) savedInfraction.setVehicleSpeed(infraction.getVehicleSpeed());
            if (infraction.getRadarMaxSpeed() != null) savedInfraction.setRadarMaxSpeed(infraction.getRadarMaxSpeed());
            if (infraction.getAmount() != null) savedInfraction.setAmount(infraction.getAmount());
            if (infraction.getRadarId() != null) savedInfraction.setRadarId(infraction.getRadarId());
            if (infraction.getVehicleId() != null) savedInfraction.setVehicleId(infraction.getVehicleId());

            return infractionRepository.save(savedInfraction);
        }
        return null;
    }
    @DeleteMapping("/infractions/{id}")
    public boolean deleteInfraction(@PathVariable("id") Long id){
        if(infractionRepository.existsById(id)){
            infractionRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Custom operations
    // - Read by radar id
    @GetMapping("/infractions/radar/{id}")
    public List<Infraction> getInfractionsByRadarId(@PathVariable("id") Long id){
        return infractionRepository.findByRadarId(id);
    }
}