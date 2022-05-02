package br.com.dcsolution.group.usecase.impl;

import br.com.dcsolution.group.dataprovider.repository.GroupRepository;
import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.usecase.CreateGroupUseCase;

import javax.inject.Inject;
import javax.inject.Named;

@Named
class CreateGroupUseCaseImpl implements CreateGroupUseCase {

    private final GroupRepository groupRepository;

    @Inject
    CreateGroupUseCaseImpl(final GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public void execute(final Group group) {
        groupRepository.save(group);
    }
}
