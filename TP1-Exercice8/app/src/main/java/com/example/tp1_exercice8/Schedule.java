package com.example.tp1_exercice8;

public class Schedule {

    private String departure, arrival, date, trainNumber, duration;

    public Schedule(String departure, String arrival, String date, String trainNumber, String duration) {
        this.departure = departure;
        this.arrival = arrival;
        this.date = date;
        this.trainNumber = trainNumber;
        this.duration = duration;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public boolean match(String departure, String arrival) {
        return this.departure.equalsIgnoreCase(departure) && this.arrival.equalsIgnoreCase(arrival);
    }

    @Override
    public String toString() {
        return "Train " + trainNumber + " | " + date + " | " + departure + " -> " + arrival + " (" + duration + ")";
    }

}
