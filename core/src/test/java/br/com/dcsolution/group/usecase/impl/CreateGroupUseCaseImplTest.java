package br.com.dcsolution.group.usecase.impl;

import br.com.dcsolution.group.dataprovider.repository.GroupRepository;
import br.com.dcsolution.group.entity.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

class CreateGroupUseCaseImplTest {

    @Mock
    private GroupRepository groupRepository;

    @InjectMocks
    private CreateGroupUseCaseImpl groupUseCase;

    @BeforeEach
    void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        final Group group = new Group(null, "card");
        Mockito.doNothing().when(groupRepository).save(group);
        groupUseCase.execute(group);
        Mockito.verify(groupRepository, Mockito.times(1)).save(group);
    }

}