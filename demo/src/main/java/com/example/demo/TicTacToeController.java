// src/main/java/com/example/demo/TicTacToeController.java
package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/tictactoe")
@CrossOrigin // Allow frontend to call backend if running separately
public class TicTacToeController {
    private TicTacToeGame game = new TicTacToeGame();

    @GetMapping("/state")
    public TicTacToeGame getState() {
        return game;
    }

    @PostMapping("/move")
    public TicTacToeGame makeMove(@RequestBody Move move) {
        game.makeMove(move.getRow(), move.getCol());
        return game;
    }

    @PostMapping("/reset")
    public TicTacToeGame reset() {
        game.reset();
        return game;
    }

    public static class Move {
        private int row;
        private int col;
        public int getRow() { return row; }
        public void setRow(int row) { this.row = row; }
        public int getCol() { return col; }
        public void setCol(int col) { this.col = col; }
    }
}

