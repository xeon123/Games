// src/main/java/com/example/demo/TetrisScoreRepository.java
package com.example.demo;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class TetrisScoreRepository {
    // Key: player name, Value: score
    private final Map<String, Integer> scores = new ConcurrentHashMap<>();

    public void save(String player, int score) {
        // Only save if score is higher than previous
        scores.merge(player, score, Math::max);
    }

    public List<TetrisScore> findAll() {
        List<TetrisScore> list = new ArrayList<>();
        for (var entry : scores.entrySet()) {
            list.add(new TetrisScore(entry.getKey(), entry.getValue()));
        }
        // Sort by score descending
        list.sort((a, b) -> Integer.compare(b.getScore(), a.getScore()));
        return list;
    }
}
