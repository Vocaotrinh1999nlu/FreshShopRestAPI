package vct.freshshop.service.in;

import java.util.List;
import java.util.Optional;

public interface AbstractServiceInterface<T> {

	List<T> findAll();
	Optional<T> findById(int id);
	void save(T t);
	void update(T t1, T t2);
	void remove(T t);
	boolean isExistById(int id);
}
