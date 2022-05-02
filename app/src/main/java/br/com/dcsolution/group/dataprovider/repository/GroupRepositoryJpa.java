package br.com.dcsolution.group.dataprovider.repository;

import br.com.dcsolution.group.dataprovider.entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

interface GroupRepositoryJpa extends JpaRepository<GroupEntity, Integer> {
}
