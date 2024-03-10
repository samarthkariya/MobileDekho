package com.service.post.Util;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class ResponsePage<T> {
    private List<T> content;
    private int number;
    private int size;
    private int totalPages;
    private long totalElements;

    @JsonCreator
    public ResponsePage(@JsonProperty("content") List<T> content,
                        @JsonProperty("number") int number,
                        @JsonProperty("size") int size,
                        @JsonProperty("totalPages") int totalPages,
                        @JsonProperty("totalElements") long totalElements ){
        this.content=content;
        this.number=number;
        this.size=size;
        this.totalPages=totalPages;
        this.totalElements=totalElements;
    }
    public ResponsePage(Page<T> page){
        this(page.getContent(), page.getNumber(), page.getSize(), page.getTotalPages(), page.getTotalElements());
    }
}
