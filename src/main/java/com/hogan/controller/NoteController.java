package com.hogan.controller;

import com.hogan.model.Note;
import com.hogan.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Note REST Controller
 */
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    // Get all notes or all notes that contain the query if present
    @RequestMapping(method = RequestMethod.GET)
    public List<Note> getNote(@RequestParam("query") Optional<String> query) {

        // Check to see if query is present
        if (query.isPresent()) {
            return noteRepository.findAllByBodyContainingIgnoreCase(query.get());
        }

        return noteRepository.findAll();
    }

    // Create or update a note
    @RequestMapping(method = RequestMethod.POST)
    public Note setNote(@RequestBody Note note) {

        // If note does not exist we pass the id as 0
        note = noteRepository.save(note);

        return note;
    }

    // Get a single note by id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Note getNoteById(@PathVariable("id") int id) {

        Note note = noteRepository.findOne(id);

        // check to see if note exists
        if (note == null) {
            return new Note("Note does not exist.");

        }

        return note;
    }

    // Delete a note by id
    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity updateNoteById(@PathVariable("id") int id) {

        int rows = noteRepository.deleteById(id);

        // if returned rows is 1 then return a success
        if (rows == 1) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.valueOf(410));

    }
}
