package br.com.dcsolution.common.dto;

import br.com.dcsolution.group.dto.GroupDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PaginationDtoTest {

    private final static int ONE = 1;

    @Test
    void createPagination() {
        final Long totalItems = 1L;
        final Integer totalPages = ONE;
        final Integer currentPage = ONE;
        final Integer size = 10;
        final List<GroupDto> content = new ArrayList<>();
        final GroupDto groupDto = new GroupDto();
        groupDto.setId(ONE);
        groupDto.setName("free-card");
        content.add(groupDto);

        final PaginationDto<GroupDto> result = new PaginationDto<>(totalItems,
                totalPages,
                currentPage,
                size,
                content);

        Assertions.assertEquals(ONE, result.getContent().size());
        Assertions.assertEquals(ONE, result.getTotalItems());
        Assertions.assertEquals(ONE, result.getCurrentPage());
        Assertions.assertEquals(10, result.getSize());
        Assertions.assertEquals(ONE, result.getTotalPages());
    }

    @Test
    void createPaginationIsNull() {

        final PaginationDto<GroupDto> result = new PaginationDto<>(null,
                null,
                null,
                null,
                null);

        Assertions.assertEquals(0, result.getContent().size());
        Assertions.assertEquals(0L, result.getTotalItems());
        Assertions.assertEquals(ONE, result.getCurrentPage());
        Assertions.assertEquals(10, result.getSize());
        Assertions.assertEquals(0, result.getTotalPages());
    }
}