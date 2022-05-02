package br.com.dcsolution.group.presenter.converter;

import br.com.dcsolution.group.entity.Group;
import br.com.dcsolution.group.presenter.request.GroupRequest;

public final class GroupRestConverterStub {

    final static String NAME = "free-card";

    public static GroupRequest groupInputToGroupException() {
        return new GroupRequest();
    }

    public static GroupRequest groupInputToGroup() {
        final GroupRequest groupInput = new GroupRequest();
        groupInput.setName(NAME);

        return groupInput;
    }

    public static Group group() {
        return new Group(1, NAME);
    }
}
