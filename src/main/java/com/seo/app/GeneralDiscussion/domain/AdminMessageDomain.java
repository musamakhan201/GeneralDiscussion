package com.seo.app.GeneralDiscussion.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@ToString
@Getter
@Setter
@Entity
@AllArgsConstructor
@Table(name = "user_questions")
public class AdminMessageDomain {
    private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("question_id")
    @Column(name = "question_id")
    private int questionId;
    private String name;
    private int id;
    private String message;
    @Column(columnDefinition="DATETIME")
    @JsonProperty("message_time")
    private String messageTime;

    public AdminMessageDomain() {
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        messageTime = utc.format(DateTimeFormatter.ofPattern(DATETIME_FORMAT));
    }
}
