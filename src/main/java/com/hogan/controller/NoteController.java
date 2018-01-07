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
 * Created by hogie on 1/7/18.
 */
@RestController
@RequestMapping("/api/notes")
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Note> getNote(@RequestParam("query") Optional<String> query) {

        if (query.isPresent()) {
            return noteRepository.findAllByBodyContainingIgnoreCase(query.get());
        }

        return noteRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Note setNote(@RequestBody Note note) {

        // todo: gently resolve no note being available

        note = noteRepository.save(note);

        return note;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Note getNoteById(@PathVariable("id") int id) {

        Note note = noteRepository.findOne(id);

        if (note != null) {
            return note;
        }
        
        return new Note("Note does not exist");
    }
    @Transactional
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity updateNoteById(@PathVariable("id") int id) {

        int rows = noteRepository.deleteById(id);

        if (rows == 1) {
            return new ResponseEntity(HttpStatus.OK);
        }

        return new ResponseEntity(HttpStatus.valueOf(410));

    }
}
