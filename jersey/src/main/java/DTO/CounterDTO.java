package DTO;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CounterDTO {
    private final int value;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    Date date;

    public CounterDTO(int value) {
        this.value = value;
        this.date = new Date(System.currentTimeMillis());
    }
    public int getValue() {
        return value;
    }
}
