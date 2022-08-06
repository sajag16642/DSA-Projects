import javax.swing.*;
import java.awt.*;
public class NQueenVisualizer {
    final static int M = 8;
    static JLabel [][] jLabel = new JLabel[M][M];
    static int board[][] = new int[M][M];
    static void printSolution(){
        for(int i = 0; i < M; ++i){
            for(int j = 0; j < M; ++j){
                System.out.printf("%d ", board[i][j]);
            }
            System.out.printf("\n");
        }
    }
    static boolean isSafe( int row, int col ) {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < col; ++i)
            if (board[row][i] == 1)
                return false;
        for (int i = row, j = col; i >= 0 && j >= 0; --i, --j) {
            if (board[i][j] == 1)
                return false;
        }
        for (int i = row, j = col; i < M && j >= 0; ++i, --j){
            if (board[i][j] == 1)
                return false;
         }
        return true;
    }
    static boolean findSolution( int col ){
        if(col >= M)
            return true;
        for( int i = 0; i < M; ++i ){
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if( isSafe( i, col) == true ){
                board[i][col] = 1;
                jLabel[i][col].setBackground(Color.ORANGE);
                if( findSolution( col + 1) == true )
                    return true;
                board[i][col] = 0;
                jLabel[i][col].setBackground(Color.BLUE);
            }
        }
        return false;
    }
    static void solveNQueen(){
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                board[i][j] = 0;
                jLabel[i][j].setBackground(Color.BLUE);
            }
        }
        if( findSolution( 0 ) == false )
            System.out.println("No Solution.\n");
        else
            printSolution();
    }

    NQueenVisualizer() { 
        JFrame jFrame = new JFrame("NQueen Visualizer.");
 
        jFrame.setLayout(new GridLayout(M, M));
        jFrame.setSize(400, 400);
 
        jFrame.setDefaultCloseOperation(jFrame.EXIT_ON_CLOSE);
 
 
        for(int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                jLabel[i][j] = new JLabel( "(" + i + "," + j + ")" );
                jLabel[i][j].setHorizontalAlignment(SwingConstants.CENTER);
 
                jLabel[i][j].setSize(50, 50);
 
                jLabel[i][j].setOpaque(true);
 
                jFrame.add(jLabel[i][j]);
            }
        }
 
 
        jFrame.setVisible(true);
 
    }
 
    public static  void main( String args[] ){
 
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new NQueenVisualizer();
            }
        });
 
        solveNQueen();
 
    }
 
}
