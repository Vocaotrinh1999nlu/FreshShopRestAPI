package vct.freshshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import vct.freshshop.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query("SELECT r FROM Role r WHERE r.name = ?1")
	public Role getRoleByName(String name);
}
