import java.util.Arrays;

/**
 * The maze class is used to
 * represent a maze and solve
 * it.
 */
public class Maze {

    /**
     * The grid is used to hold
     * the current instance of the
     * maze.
     */
    private String[][]grid;

    /**
     * The regexMove String
     * is used to check to make
     * sure a move is valid.
     */
    private String regexMove=".*[\\.].*";

    /**
     * The constructor is used to create
     * a new maze by passing a 2d array of
     * strings to represent the maze.
     *
     * @param array the param array is used
     *              to set the grid to the
     *              maze representation.
     */
    public Maze(String[][]array){
        this.grid=array;
    }

    /**
     * The getStart method is used to find the
     * start of the maze. It begins by searching
     * the west wall and then continues to check
     * clockwise until an entrance is found.
     *
     * @return The return is an int array
     *         with 2 values. The values represent
     *         the beginning of the maze.
     */
    public int[]getStart(){
        int[]start={-1,-1};
        for(int i=0;i<3;i++){
            switch(i){
                case 0:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[j][0].matches(regexMove)){
                            start[0]=j;
                            start[1]=0;
                            return start;
                        }
                    }
                    break;
                case 1:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[0][j].matches(regexMove)){
                            start[0]=0;
                            start[1]=j;
                            return start;
                        }
                    }
                    break;
                case 2:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[j][this.grid.length-1].matches(regexMove)){
                            start[0]=j;
                            start[1]=this.grid.length-1;
                            return start;
                        }
                    }
                    break;
                case 3:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[this.grid.length-1][j].matches(regexMove)){
                            start[0]=this.grid.length-1;
                            start[1]=j;
                            return start;
                        }
                    }
                    break;
            }
        }
        return start;
    }

    /**
     * The getEnd method is used to find the
     * end of the maze. It begins by searching
     * the east wall and then continues to check
     * clockwise until an entrance is found.
     *
     * @return The return is an int array
     *         with 2 values. The values represent
     *         the end of the maze.
     */
    public int[]getEnd(){
        int[]end={-1,-1};
        for(int i=0;i<3;i++){
            switch(i){
                case 0:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[j][this.grid.length-1].matches(regexMove)){
                            end[0]=j;
                            end[1]=this.grid.length-1;
                            return end;
                        }
                    }
                    break;
                case 1:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[this.grid.length-1][j].matches(regexMove)){
                            end[0]=this.grid.length-1;
                            end[1]=j;
                            return end;
                        }
                    }
                    break;
                case 2:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[j][0].matches(regexMove)){
                            end[0]=j;
                            end[1]=0;
                            return end;
                        }
                    }
                    break;
                case 3:
                    for(int j=0;j<this.grid.length;j++){
                        if(this.grid[0][j].matches(regexMove)){
                            end[0]=0;
                            end[1]=j;
                            return end;
                        }
                    }
                    break;


            }
        }
        return end;
    }

    /**
     * The getGridPoint method is used to
     * get the string in the given grid
     * positions.
     *
     * @param x The param x is which array in
     *          the 2d array to search.
     * @param y The param y is the position to
     *          check in the array.
     * @return The return is the string in
     *         the given position.
     */
    public String getGridPoint(int x,int y){
        return this.grid[x][y];
    }

    /**
     * The setGridPoint method is used to change
     * the strings in the maze representation.
     *
     * @param x The param x is which array in
     *          the 2d array to search.
     * @param y The param y is the position to
     *          check in the array.
     * @param s The param s is the string
     *          to set the string in the
     *          representation to.
     */
    public void setGridPoint(int x,int y,String s){
        this.grid[x][y]=s;
    }

    /**
     * The printGrid method is used to
     * print the maze representation for
     * the user to see.
     */
    public void printGrid(){
       for(int i=0;i<this.grid.length;i++){
           System.out.println(Arrays.toString(grid[i]));
       }
       System.out.println();
    }

    /**
     * The RecursiveMazeRunner method is used to
     * find the path to the end of the maze using
     * a recursive back tracking. The tests are all
     * contained in try blocks used to catch out of
     * bounds exceptions.
     *
     * @param currentX the currentX is the current array
     *                 in the 2d array that was checked.
     * @param currentY the currentY is the current position
     *                 in the array that was checked.
     * @param endX  The endX is the array in the
     *              2d array that the end is located.
     * @param endY The endY is the position in the array
     *             that the end is located.
     * @return The return is the boolean value true if
     *         the end was found.
     */
    public boolean RecursiveMazeRunner(int currentX, int currentY, int endX, int endY){
        printGrid();
        this.setGridPoint(currentX,currentY,"0");
        if((currentX==endX)&&(currentY==endY)) {
            this.setGridPoint(currentX,currentY,"X");
            return true;
        }
        try {
            if (this.getGridPoint(currentX-1,currentY).matches(regexMove)) {
                if (RecursiveMazeRunner(currentX-1, currentY, endX, endY)) {
                    this.setGridPoint(currentX,currentY,"X");
                    printGrid();
                    return true;
                }else{
                    this.setGridPoint(currentX,currentY,"0");
                    printGrid();
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        try {
            if (this.getGridPoint(currentX,currentY-1).matches(regexMove)) {
                if (RecursiveMazeRunner(currentX, currentY-1, endX, endY)) {
                    this.setGridPoint(currentX,currentY,"X");
                    printGrid();
                    return true;
                }else{
                    this.setGridPoint(currentX,currentY,"0");
                    printGrid();
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        try {
            if (this.getGridPoint(currentX+1,currentY).matches(regexMove)) {
                if (RecursiveMazeRunner(currentX+1, currentY, endX, endY)) {
                    this.setGridPoint(currentX,currentY,"X");
                    printGrid();
                    return true;
                }else{
                    this.setGridPoint(currentX,currentY,"0");
                    printGrid();
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        try {
            if (this.getGridPoint(currentX,currentY+1).matches(regexMove)) {
                if (RecursiveMazeRunner(currentX, currentY+1, endX, endY)) {
                    this.setGridPoint(currentX,currentY,"X");
                    printGrid();
                    return true;
                }else{
                    this.setGridPoint(currentX,currentY,"0");
                    printGrid();
                }
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        return false;
    }
}
