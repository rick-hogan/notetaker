package com.hogan.repository;

import com.hogan.model.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by hogie on 1/7/18.
 */
public interface NoteRepository extends CrudRepository<Note, Integer> {

    List<Note> findAllByBodyContainingIgnoreCase(String query);
    List<Note> findAll();
    int deleteById(Integer id);
}
