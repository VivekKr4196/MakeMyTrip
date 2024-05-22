package com.vivek.response;

import lombok.Data;

@Data
public class Ticket {
    private Integer ticketNumber;
    private String name;
    private Double cost;
    private String from;
    private String to;
    private String doj;
    private String status;
    private String trainNumber;
}
