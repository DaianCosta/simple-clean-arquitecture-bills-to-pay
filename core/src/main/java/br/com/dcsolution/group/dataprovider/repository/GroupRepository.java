package br.com.dcsolution.group.dataprovider.repository;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.entity.Group;

public interface GroupRepository {

    PaginationDto<GroupDto> findAll(final Integer currentPage, final Integer size);

    void save(final Group group);
}
