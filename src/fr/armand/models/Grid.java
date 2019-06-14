package fr.armand.models;


public class Grid {

    private int grid[][] = {{1,2},{1,2}};


    public void displayGrid()
    {
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                System.out.println(grid[i][y]);
            }
        }
    }
    public int getSize()
    {
        int ctt = 0;
        for (int i = 0; i < 3; i++) {
            for (int y = 0; y < 3; y++) {
                ctt++;
            }
        }
        return ctt;
    }

}
