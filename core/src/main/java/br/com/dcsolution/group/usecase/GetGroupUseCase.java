package br.com.dcsolution.group.usecase;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dto.GroupDto;

public interface GetGroupUseCase {
    PaginationDto<GroupDto> findAll(final Integer currentPage, final Integer size);
}
