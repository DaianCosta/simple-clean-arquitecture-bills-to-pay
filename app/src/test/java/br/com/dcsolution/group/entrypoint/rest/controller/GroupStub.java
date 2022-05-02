package br.com.dcsolution.group.entrypoint.rest.controller;

import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.presenter.request.GroupRequest;

public final class GroupStub {

    final static String NAME = "free-card";

    public static GroupRequest groupInputStub() {
        final GroupRequest groupInput = new GroupRequest();
        groupInput.setName(NAME);
        return groupInput;
    }

    public static Group groupStub() {
        return new Group(1, NAME);
    }

    public static Group groupErrorStub() {
        return new Group(null, null);
    }
}
