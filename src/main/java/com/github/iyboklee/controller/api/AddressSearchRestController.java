/**
 * @Author iyboklee (iyboklee@gmail.com)
 */
package com.github.iyboklee.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.iyboklee.controller.model.response.ApiResult;
import com.github.iyboklee.core.model.Postcodes;
import com.github.iyboklee.core.service.PostcodeProxyService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/search")
public class AddressSearchRestController {

    @Autowired private PostcodeProxyService postcodeProxyService;

    @GetMapping
    public ApiResult<Postcodes> search(@RequestParam(value = "query") String query,
                                       @RequestParam(value = "page", required = false) Integer page) throws Exception {
        if (page == null || page < 1)
            page = 1;
        return new ApiResult<>(postcodeProxyService.search(query, page));
    }

}
