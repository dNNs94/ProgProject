package battleship;

public class Client {

    public static void main(String[] args) {
        int[][][] player = {{{1, 1, -1, -1, -1, -1, -1, -1}, {2, 3, -1, -1, -1, -1, -1, -1}},{{2,2,-1,-1,-1,-1,-1,-1},{2,3,-1,-1,-1,-1,-1,-1}},
                {{3,3,3,-1,-1,-1,-1,-1},{2,3,4,-1,-1,-1,-1,-1}},{{4,4,4,-1,-1,-1,-1,-1},{2,3,4,-1,-1,-1,-1,-1}},
                {{5,5,5,5,-1,-1,-1,-1},{2,3,4,5,-1,-1,-1,-1}},{{6,6,6,6,-1,-1,-1,-1},{2,3,4,5,-1,-1,-1,-1}},
                {{7,7,7,7,7,-1,-1,-1},{2,3,4,5,6,-1,-1,-1}},{{8,8,8,8,8,-1,-1,-1},{2,3,4,5,6,-1,-1,-1}}};

        new Board(new Player("player1", player), new Player("player2", player));
    }
}


