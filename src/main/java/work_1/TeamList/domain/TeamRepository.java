package work_1.TeamList.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TeamRepository extends CrudRepository<Team, Long>{

	List<Team> findByName(String name);
	
}

