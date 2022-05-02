package br.com.dcsolution.group.presenter.converter;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dataprovider.entity.GroupEntity;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.exception.BusinessException;
import br.com.dcsolution.group.presenter.request.GroupRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GroupRestConverterTest {

    @Spy
    private ModelMapper modelMapper = new ModelMapper();

    @InjectMocks
    private GroupRestConverter groupRestConverter;

    @Test
    void groupInputToGroupException() {
        final GroupRequest groupInput = GroupRestConverterStub.groupInputToGroupException();
        Assertions.assertThrows(BusinessException.class, () -> groupRestConverter.groupInputToGroup(groupInput));
    }

    @Test
    void groupInputToGroup() {
        final Group group = groupRestConverter.groupInputToGroup(GroupRestConverterStub.groupInputToGroup());
        Assertions.assertEquals(GroupRestConverterStub.NAME, group.getName());
    }

    @Test
    void groupToGroupEntity() {
        final GroupEntity groupEntity = groupRestConverter.groupToGroupEntity(GroupRestConverterStub.group());
        Assertions.assertEquals(GroupRestConverterStub.NAME, groupEntity.getName());
    }

    @Test
    void generatePageRequest() {
        final PageRequest result = groupRestConverter.generatePageRequest(1, 1);
        Assertions.assertEquals(1, result.getPageSize());
        Assertions.assertEquals(1, result.getOffset());
    }

    @Test
    void pageToPaginationDto() {
        final List<GroupEntity> items = new ArrayList<>();
        items.add(new GroupEntity());
        final Page<GroupEntity> page = new PageImpl<>(items);
        final PaginationDto<GroupDto> result = groupRestConverter.pageToPaginationDto(page);
        Assertions.assertEquals(1, result.getTotalItems());
    }
}