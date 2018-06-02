package com.journaler.api.controller;

import com.journaler.api.data.Note;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/notes")
public class NoteController {
    @GetMapping(value = "/obtain", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Note> getNotes() {
        return Arrays.asList(
                new Note(UUID.randomUUID().toString(),
                        "My First Note", "This is a message for the 1st note."),
                new Note(UUID.randomUUID().toString(),
                        "My second note",
                        "This is a message for the 2nd note." )
        );
    }

    @PutMapping(value="/insert",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Note insertNote(@RequestBody Note note) {
        note.setId(UUID.randomUUID().toString());
        return note;
    }

    @DeleteMapping(value = "/delete/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Boolean deleteNote(@PathVariable(name = "id") String id) {
        System.out.println(String.format("note: %s", id));
        return false;
    }

    @PostMapping(value = "/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Note updateNote(@RequestBody Note note) {
        note.setTitle(note.getTitle() + " updated");
        note.setMessage(note.getMessage() + " updated");
        return note;
    }

}
