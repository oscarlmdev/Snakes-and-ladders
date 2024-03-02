public class SnakesLadders {
    private boolean gameOver;
    private int turn;
    private int n;
    private int iP1;
    private int iP2;

    private int[] board = {0, 1, 38,  3,  4,  5,  6, 14, 31,  9, 10,
                             11, 12, 13, 14, 26,  6, 17, 18, 19, 20,
                             42, 22, 23, 24, 25, 26, 27, 84, 29, 30,
                             31, 32, 33, 34, 35, 44, 37, 38, 39, 40,
                             41, 42, 43, 44, 45, 25, 47, 48, 11, 50,
                             67, 52, 53, 54, 55, 56, 57, 58, 59, 60,
                             61, 19, 63, 60, 65, 66, 67, 68, 69, 70,
                             91, 72, 73, 53, 75, 76, 77, 98, 79, 80,
                             81, 82, 83, 84, 85, 86, 94, 88, 68, 90,
                             91, 88, 93, 94, 75, 96, 97, 98, 80, 100};
    public SnakesLadders() {
        this.gameOver=false;
        this.turn=1;
        this.iP1=0;
        this.iP2=0;
    }

    public void switchTurn(){
        this.turn = turn==1 ? 2 : 1;
    }

     public String play(int die1, int die2) {
        int square;
        this.n=turn;
        if (gameOver) return "Game over!";
        int sum = die1 + die2;
        if (turn==1) {
            if (iP1+sum>board.length-1){
                this.iP1 = board[200-iP1-sum];
            }else{this.iP1 = board[iP1+sum];}
        } else {
            if (iP2+sum>board.length-1){
                this.iP2 = board[200-iP2-sum];
            }else{this.iP2 = board[iP2+sum];}
        }
        if (iP1==100 || iP2==100) {
            gameOver=true;
            return "Player "+turn+" Wins!";
        }
        square = n==1? iP1:iP2;
        if (die1!=die2 && iP1!=0) switchTurn();
        System.out.println("Player "+n+" is on square "+board[square]);
        return "Player "+n+" is on square "+board[square];
    }
}
