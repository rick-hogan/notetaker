package com.hogan.repository;

import com.hogan.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Repository where all Note Queries will be handled
 */
public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findAllByBodyContainingIgnoreCase(String query);
    List<Note> findAll();
    int deleteById(Integer id);
}
