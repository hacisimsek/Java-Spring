package com.haydikodlayal.m.springelasticsearchexample.repository;

import com.haydikodlayal.m.springelasticsearchexample.entity.User;
import java.util.List;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {
    @Query("{\"bool\": {\"must\": [{\"match\": {\"name\": \"?0\"}}]}}")
    List<User> getByCustomQuery(String search);

    List<User> findByNameOrSurnameLike(String name, String surname);

    List<User> findByNameOrSurnameOrEmailLike(String name, String surname, String email);

}