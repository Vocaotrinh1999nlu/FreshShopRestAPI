package vct.freshshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vct.freshshop.entity.Oder;

@Repository
public interface OderRepository extends JpaRepository<Oder, Integer> {

}
