package br.com.dcsolution.group.entrypoint.rest.controller;

import br.com.dcsolution.common.dto.PaginationDto;
import br.com.dcsolution.group.dto.GroupDto;
import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.presenter.request.GroupRequest;
import br.com.dcsolution.group.presenter.converter.GroupRestConverter;
import br.com.dcsolution.group.usecase.CreateGroupUseCase;
import br.com.dcsolution.group.usecase.GetGroupUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/group")
public class GroupController {

    private final CreateGroupUseCase groupUseCase;
    private final GroupRestConverter groupRestConverter;
    private final GetGroupUseCase getGroupUseCase;

    @Autowired
    public GroupController(final CreateGroupUseCase groupUseCase,
                           final GroupRestConverter groupRestConverter,
                           final GetGroupUseCase getGroupUseCase) {
        this.groupUseCase = groupUseCase;
        this.groupRestConverter = groupRestConverter;
        this.getGroupUseCase = getGroupUseCase;
    }

    @GetMapping
    public ResponseEntity<PaginationDto<GroupDto>> findAll(@RequestParam final Integer page,
                                                           @RequestParam final Integer size) {
        return new ResponseEntity<>(getGroupUseCase.findAll(page, size), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> post(@RequestBody @Valid GroupRequest groupInput) {
        final Group group = groupRestConverter.groupInputToGroup(groupInput);
        groupUseCase.execute(group);
        return ResponseEntity.ok().build();
    }
}
