package com.journaler.api.service;

import com.journaler.api.data.Note;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
    public List<Note> getNotes() {
        return Arrays.asList(
                new Note(
                        UUID.randomUUID().toString(),
                        "My first note",
                        "This is a message for the 1st note."
                ),
                new Note(
                        UUID.randomUUID().toString(),
                        "My second note",
                        "This is a message for the 2nd note."
                )
        );
    }

    public Note insertNote(Note note) {
        note.setId(UUID.randomUUID().toString());
        return note;
    }

    public Boolean deleteNote(String id) {
        return true;
    }

    public Boolean updateNote(Note note) {
        return true;
    }
}
