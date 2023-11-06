package org.example.ticketing.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieReservation {
    public String id;
    public Boolean isComplete;

    public MovieReservation(String id, Boolean isComplete) {
        this.id = id;
        this.isComplete = isComplete;
    }
}
