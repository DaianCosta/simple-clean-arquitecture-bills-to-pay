package br.com.dcsolution.group.usecase.impl;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dataprovider.repository.GroupRepository;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.usecase.GetGroupUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
class GetGroupUseCaseImpl implements GetGroupUseCase {
    private final GroupRepository groupRepository;

    @Inject
    GetGroupUseCaseImpl(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    @Override
    public PaginationDto<GroupDto> findAll(final Integer currentPage, final Integer size) {
        return groupRepository.findAll(currentPage, size);
    }
}
