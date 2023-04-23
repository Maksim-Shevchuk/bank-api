package by.vsu.bank.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
//todo check do we need @tostring in this class
public class ErrorModel {

    private String title;

    private String message;

    private Map<String, String> details;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
    private LocalDateTime timestamp;

    public ErrorModel(String title, String message, Map details) {
        this.title = title;
        this.message = message;
        this.details = details;
        this.timestamp = LocalDateTime.now();
    }

    public ErrorModel(String title, String message) {
        this(title, message, null);
    }

    public ErrorModel(String title) {
        this(title, null);
    }
}