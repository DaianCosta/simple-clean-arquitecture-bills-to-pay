package br.com.dcsolution.group.presenter.converter;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dataprovider.entity.GroupEntity;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.presenter.request.GroupRequest;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class GroupRestConverter {

    private final ModelMapper modelMapper;

    @Autowired
    public GroupRestConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public GroupEntity groupToGroupEntity(final Group group) {
        return modelMapper.map(group, GroupEntity.class);
    }

    public Group groupInputToGroup(final GroupRequest groupInput) {
        return new Group(groupInput.getId(), groupInput.getName());
    }

    public List<GroupDto> groupOutputListToGroupList(final List<GroupEntity> groupEntityList) {
        return modelMapper.map(groupEntityList, new TypeToken<List<GroupDto>>() {
        }.getType());
    }

    public PageRequest generatePageRequest(final Integer currentPage, final Integer size) {
        return PageRequest.of(Objects.requireNonNullElse(currentPage, 1),
                Objects.requireNonNullElse(size, 10));
    }

    public PaginationDto<GroupDto> pageToPaginationDto(final Page<GroupEntity> page) {
        return new PaginationDto<>(page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getSize(),
                groupOutputListToGroupList(page.getContent()));
    }
}
