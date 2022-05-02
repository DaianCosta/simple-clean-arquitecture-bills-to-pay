package br.com.dcsolution.common.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaginationDto<T> {

    private final Long totalItems;
    private final Integer totalPages;
    private final Integer currentPage;
    private final Integer size;
    private final List<T> content;

    public PaginationDto(Long totalItems,
                         Integer totalPages,
                         Integer currentPage,
                         Integer size,
                         List<T> content) {
        this.totalItems = Objects.requireNonNullElse(totalItems, 0L);
        this.totalPages = Objects.requireNonNullElse(totalPages, 0);
        this.currentPage = Objects.requireNonNullElse(currentPage, 1);
        this.size = Objects.requireNonNullElse(size, 10);
        this.content = Objects.requireNonNullElse(content, new ArrayList<>());
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getSize() {
        return size;
    }

    public List<T> getContent() {
        return content;
    }
}

