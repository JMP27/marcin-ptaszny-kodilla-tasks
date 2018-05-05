package com.crud.tasks.facade;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.facade.TrelloFacade;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class TrelloFacadeTestSuite {
    @InjectMocks
    private TrelloFacade trelloFacade;

    @Mock
    private TrelloValidator trelloValidator;

    @Mock
    private TrelloMapper trelloMapper;

    @Mock
    private TrelloService trelloService;

    @Test
    public void shouldFetchTrelloBoards() {
    //Given
    List<TrelloBoardDto> fetchedBoards = trelloFacade.fetchTrelloBoards();

    //When
    trelloFacade.fetchTrelloBoards();

    //Then

    Assert.assertEquals(0, fetchedBoards.size());
    System.out.println("the number of fetched boards is: " + fetchedBoards.size());
    }

    @Test
    public void shouldCreateCard() {
    //Given
    TrelloCardDto card = new TrelloCardDto("card1", "new", "pos", "12");

    //When
    trelloFacade.createCard(card);

    //Then
    Assert.assertEquals("card1", card.getName());
    System.out.println("the name is: " + card.getName());
    }

}


