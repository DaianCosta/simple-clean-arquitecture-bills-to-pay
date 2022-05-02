package br.com.dcsolution.group.entity;

import br.com.dcsolution.group.exception.BusinessException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GroupTest {

    @Test
    void createObject(){
        final String name = "card";
        final Group group = new Group(null, name);
        assertEquals(group.getName(),name);
    }

    @Test
    void groupBusinessExceptionName(){
        assertThrows(BusinessException.class,()-> new Group(null, null));
        assertThrows(BusinessException.class,()-> new Group(null, ""));
    }

}