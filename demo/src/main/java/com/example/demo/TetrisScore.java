// src/main/java/com/example/demo/TetrisScore.java
package com.example.demo;

public class TetrisScore {
    private String player;
    private int score;

    public TetrisScore() {}
    public TetrisScore(String player, int score) {
        this.player = player;
        this.score = score;
    }

    public String getPlayer() { return player; }
    public void setPlayer(String player) { this.player = player; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
}