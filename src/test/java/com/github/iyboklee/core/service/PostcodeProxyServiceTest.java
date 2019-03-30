/**
 * @Author iyboklee (iyboklee@gmail.com)
 */
package com.github.iyboklee.core.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.iyboklee.core.model.Postcodes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostcodeProxyServiceTest {

    @Autowired private PostcodeProxyService postcodeProxyService;

    @Test
    public void searchTest() throws Exception {
        String query = "와부읍 도곡리";
        int page = 1;

        Postcodes result = postcodeProxyService.search(query, page);
        Assert.assertFalse(result.isEmpty());
        Assert.assertEquals(300, result.getTotalCount());
        Assert.assertEquals(15, result.getPageSize());

        result.getList().forEach(postcode -> log.info("Postcode: {}", postcode));
    }

}