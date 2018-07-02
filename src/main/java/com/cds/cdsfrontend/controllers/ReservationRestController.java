package com.cds.cdsfrontend.controllers;

import com.cds.cdsfrontend.models.Reservation;
import com.cds.cdsfrontend.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ReservationRestController {

    // External field dependencies to be used in constructor DI.
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @RequestMapping(value = "/reservations", method = RequestMethod.GET)
    @ResponseBody
    Collection <Reservation> reservations() {
        return this.reservationRepository.findAll();
    }

    @RequestMapping(value = "/reservations/{name}", method = RequestMethod.GET)
    @ResponseBody
    Collection <Reservation> reservation(@PathVariable String name) {
        return this.reservationRepository.findByReservationName( name );
    }
}
