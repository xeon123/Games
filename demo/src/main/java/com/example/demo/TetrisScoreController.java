// src/main/java/com/example/demo/TetrisScoreController.java
package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tetris/scores")
public class TetrisScoreController {

    @Autowired
    private TetrisScoreRepository repository;

    @PostMapping
    public void saveScore(@RequestBody TetrisScore score) {
        repository.save(score.getPlayer(), score.getScore());
    }

    @GetMapping
    public List<TetrisScore> getScores() {
        return repository.findAll();
    }
}
