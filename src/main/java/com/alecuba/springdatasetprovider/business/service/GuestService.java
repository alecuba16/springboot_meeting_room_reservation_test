package com.alecuba.springdatasetprovider.business.service;

import com.alecuba.springdatasetprovider.business.domain.RoomReservation;
import com.alecuba.springdatasetprovider.data.entity.Guest;
import com.alecuba.springdatasetprovider.data.entity.Reservation;
import com.alecuba.springdatasetprovider.data.entity.Room;
import com.alecuba.springdatasetprovider.data.repository.GuestRepository;
import com.alecuba.springdatasetprovider.data.repository.ReservationRepository;
import com.alecuba.springdatasetprovider.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests(){
        Iterable<Guest> guests = this.guestRepository.findAll();
        List<Guest> guestsList = new ArrayList<Guest>();
        guests.forEach(guestsList::add);

        guestsList.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest o1, Guest o2) {
                if (o1.getLastName() == o2.getLastName()){
                    return o1.getFirstName().compareTo(o2.getFirstName());
                }
                return o1.getLastName().compareTo(o2.getLastName());
            }
        });
        return guestsList;
    }
}
