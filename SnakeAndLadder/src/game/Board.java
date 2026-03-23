package game;

import java.util.*;

public class Board {

    private int size;
    private Map<Integer, Jump> jumps;

    public Board(int size, Difficulty difficulty) {
        this.size = size;
        this.jumps = new HashMap<>();
        initializeJumps(difficulty);
    }

    private void initializeJumps(Difficulty difficulty) {
        int n = size;

        Random rand = new Random();

        for (int i = 0; i < n; i++) {

            // Snake
            int head = rand.nextInt(size * size - 1) + 2;
            int tail = rand.nextInt(head - 1) + 1;

            jumps.put(head, new Jump(head, tail));

            // Ladder
            int start = rand.nextInt(size * size - 1) + 1;
            int end = rand.nextInt(size * size - start) + start + 1;

            jumps.put(start, new Jump(start, end));
        }
    }

    public int resolveJump(int position) {
        if (jumps.containsKey(position)) {
            Jump jump = jumps.get(position);
            System.out.println("Jump from " + jump.getStart() + " to " + jump.getEnd());
            return jump.getEnd();
        }
        return position;
    }

    public int getSize() {
        return size;
    }
}