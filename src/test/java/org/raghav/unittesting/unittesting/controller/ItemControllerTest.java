package org.raghav.unittesting.unittesting.controller;

import org.junit.jupiter.api.Test;
import org.raghav.unittesting.unittesting.model.Item;
import org.raghav.unittesting.unittesting.service.ItemBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemBusinessService businessService;

    @Test
    public void dummyItem_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/dummy-item")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                                  .andExpect(status().isOk())
                                  .andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}"))
                                  .andReturn();

        // verify "Hello World!!!"
        // Assertions.assertEquals("Hello World!!!", result.getResponse().getContentAsString());
    }

    @Test
    public void itemFromBusinessService_basic() throws Exception {
        when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "item2", 10, 10));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/item-from-business-service")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                                  .andExpect(status().isOk())
                                  .andExpect(content().json("{id:2,name:item2,price:10}"))
                                  .andReturn();

        // verify "Hello World!!!"
        // Assertions.assertEquals("Hello World!!!", result.getResponse().getContentAsString());
    }

    @Test
    public void retrieveAllItems_basic() throws Exception {
        when(businessService.retrieveAllItems())
                .thenReturn(
                        List.of(
                                new Item(1, "item1", 10, 20),
                                new Item(2, "item2", 20, 30),
                                new Item(3, "item3", 30, 40)
                        )
                );

        RequestBuilder request = MockMvcRequestBuilders
                .get("/all-items-from-database")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(request)
                                  .andExpect(status().isOk())
                                  .andExpect(content().json("[{id:1,name:item1,price:10},{id:2,name:item2,price:20},{id:3,name:item3,price:30}]"))
                                  .andReturn();

        // verify "Hello World!!!"
        // Assertions.assertEquals("Hello World!!!", result.getResponse().getContentAsString());
    }
}
