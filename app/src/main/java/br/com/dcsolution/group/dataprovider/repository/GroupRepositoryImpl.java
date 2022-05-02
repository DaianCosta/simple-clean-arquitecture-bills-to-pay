package br.com.dcsolution.group.dataprovider.repository;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dataprovider.entity.GroupEntity;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.presenter.converter.GroupRestConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
class GroupRepositoryImpl implements GroupRepository {

    private final GroupRepositoryJpa repositoryJpa;
    private final GroupRestConverter groupMapper;

    @Autowired
    GroupRepositoryImpl(final GroupRepositoryJpa repositoryJpa,
                        final GroupRestConverter groupMapper) {
        this.repositoryJpa = repositoryJpa;
        this.groupMapper = groupMapper;
    }

    @Override
    public PaginationDto<GroupDto> findAll(final Integer currentPage, final Integer size) {
       final Page<GroupEntity> result = repositoryJpa.findAll(groupMapper.generatePageRequest(currentPage, size));
       return groupMapper.pageToPaginationDto(result);
    }

    @Override
    public void save(Group group) {
        repositoryJpa.save(groupMapper.groupToGroupEntity(group));
    }
}
