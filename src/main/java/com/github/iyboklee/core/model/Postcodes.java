/**
 * @Author iyboklee (iyboklee@gmail.com)
 */
package com.github.iyboklee.core.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Postcodes {

    private int totalCount;
    private int page;
    private int size;
    private List<Postcode> list;

    public Postcodes(int totalCount, int page, List<Postcode> list) {
        this.totalCount = totalCount;
        this.page = page;
        this.list = list;
        this.size = list != null ? list.size() : 0;
    }

    public boolean isEmpty() {
        return totalCount == 0 || size == 0;
    }

    public int getPageSize() {
        return size;
    }

}
