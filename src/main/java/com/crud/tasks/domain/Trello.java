package com.crud.tasks.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;


@AllArgsConstructor
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@CrossOrigin("*")
public class Trello {


    @JsonProperty("board")
    private int board;

    @JsonProperty("card")
    private int card;

    @JsonProperty("lists")
    private List<TrelloListDto> lists;
}