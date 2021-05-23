package com.seo.app.GeneralDiscussion.dto;

import lombok.*;

@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private int question_id;
    private String name;
    private int id;
    private String message;
    private String time;
}
