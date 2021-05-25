package vct.freshshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vct.freshshop.entity.OderItem;

@Repository
public interface OderItemRepository extends JpaRepository<OderItem, Integer> {

}
