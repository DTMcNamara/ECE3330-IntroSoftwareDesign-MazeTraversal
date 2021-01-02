/**
 * The MazeRunner class is used
 * to test the maze class and
 * the function to solve it.
 */
public class MazeRunner {

    /**
     * The String[][] maze0 is the
     * representation of the test maze.
     */
    private static String[][]maze0={
        {"#","#","#","#","#","#","#","#","#","#","#","#"},
        {"#",".",".",".","#",".",".",".",".",".",".","#"},
        {".",".","#",".","#",".","#","#","#","#",".","#"},
        {"#","#","#",".","#",".",".",".",".","#",".","#"},
        {"#",".",".",".",".","#","#","#",".","#",".","."},
        {"#","#","#","#",".","#",".","#",".","#",".","#"},
        {"#",".",".","#",".","#",".","#",".","#",".","#"},
        {"#","#",".","#",".","#",".","#",".","#",".","#"},
        {"#",".",".",".",".",".",".",".",".","#",".","#"},
        {"#","#","#","#","#","#",".","#","#","#",".","#"},
        {"#",".",".",".",".",".",".","#",".",".",".","#"},
        {"#","#","#","#","#","#","#","#","#","#","#","#"}
    };

    /**
     * The int[]Maze0Start is used to
     * hold the start of the maze.
     */
    private static int[]maze0Start;

    /**
     * The int[]Maze0End is used to
     * hold the end of the maze.
     */
    private static int[]maze0End;

    /**
     * The main method collects the
     * maze start and end, then passes
     * them to the recursive maze solver
     * to solve.
     *
     * @param args
     */
    public static void main(String[] args) {
        Maze m = new Maze(maze0);
        maze0Start=m.getStart();
        maze0End=m.getEnd();
        m.RecursiveMazeRunner(maze0Start[0],maze0Start[1],maze0End[0],maze0End[1]);
    }
}
