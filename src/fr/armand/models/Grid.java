package fr.armand.models;

public class Grid {

    private Cell grid[][];
    private int largeur;
    private int hauteur;

    public Grid(int largeur, int hauteur){
        this.largeur = largeur;
        this.hauteur = hauteur;
        setGrid(this.largeur,this.hauteur);
    }

    public void setGrid(int largeur, int longueur){
        grid = new Cell[largeur][longueur];
        for (int i = 0; i <= largeur - 1; i++) {
            for (int y = 0; y <= longueur - 1; y++) {
                grid[i][y] = new Cell(i, y);
            }
        }
    }
    public void setCellLetter(int parX, int parY, String parLetter)
    {
        if(grid[parX][parY].getType() == 0){
            grid[parX][parY].setType(1);
            grid[parX][parY].addLetter(parLetter);
        }
    }

    public void setCellDef(int parX, int parY, String parDef, String parMot, String parDef2, String parMot2, Definition.Direction parDirection, Definition.Direction parDirection2)
    {
        // Vérifie si la taille du mot passe dans les cellules adjacentes en fonction de sa direction
        if(checkCell(parX, parY,parDirection).length() >= parMot.length()) {
                if (parDef2 == null && parMot2 == null) {
                    grid[parX][parY].setType(2);

                    if (parDirection == Definition.Direction.HD) {
                        for (int i = 0; i < parMot.length(); i++) {
                            setCellLetter(parX, parY + 1 + i, (String.valueOf(parMot.charAt(i))));
                        }
                    }
                    if (parDirection == Definition.Direction.HI) {
                        for (int i = 0; i < parMot.length(); i++) {
                            setCellLetter(parX + 1, parY + i, (String.valueOf(parMot.charAt(i))));
                        }
                    }
                    if (parDirection == Definition.Direction.VD) {
                        for (int i = 0; i < parMot.length(); i++) {
                            setCellLetter(parX + 1 + i, parY, (String.valueOf(parMot.charAt(i))));
                        }
                    }
                    if (parDirection == Definition.Direction.VI) {
                        for (int i = 0; i < parMot.length(); i++) {
                            setCellLetter(parX + i, parY + 1, (String.valueOf(parMot.charAt(i))));
                        }
                    }
                } else {

                    System.out.println("DEF 2" + parMot + " " + parMot2);
                    grid[parX][parY].setType(3);
                    if (parDirection == Definition.Direction.HD) {
                        for (int i = 0; i < parMot2.length(); i++) {
                            setCellLetter(parX, parY + 1 + i, (String.valueOf(parMot2.charAt(i))));
                        }
                    }
                    if (parDirection == Definition.Direction.HI) {
                        for (int i = 0; i < parMot2.length(); i++) {
                            setCellLetter(parX + 1, parY + i, (String.valueOf(parMot2.charAt(i))));
                        }
                    }
                    if (parDirection == Definition.Direction.VD) {
                        for (int i = 0; i < parMot2.length(); i++) {
                            setCellLetter(parX + 1 + i, parY, (String.valueOf(parMot2.charAt(i))));
                        }
                    }
                    if (parDirection == Definition.Direction.VI) {
                        for (int i = 0; i < parMot2.length(); i++) {
                            setCellLetter(parX + i, parY + 1, (String.valueOf(parMot2.charAt(i))));
                        }
                    }



                }
                grid[parX][parY].addDef(parDef, parMot, parDef2, parMot2, parDirection);
            }

        }


    public void getCellDef(int parX, int parY, int idx)
    {
        grid[parX][parY].getDef(idx);
    }

    public String getCellLetter(int parX, int parY)
    {
        return grid[parX][parY].getLetter();
    }

    public void setWord(int parX, int parY, String parWord, Definition.Direction parDirection){

    }

    /** CONTROLLERS **/
    public int getGridSize()
    {
        int ctt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int y = 0; y < grid.length; y++) {
                ctt++;
            }
        }
        System.out.println(ctt);
        return ctt;
    }

    public void displayGrid(){
        int ctt = 0;
        for (int i = 0; i <= largeur - 1; i++) {
            for (int y = 0; y <= hauteur - 1; y++) {
                if (grid[i][y].getType() == 0) {
                    System.out.print(". ");
                } else if (grid[i][y].getType() == 1) {
                    System.out.print(grid[i][y].getLetter() + " ");
                } else if (grid[i][y].getType() == 2) {
                    System.out.print(grid[i][y].getDef(0));
                } else if (grid[i][y].getType() == 3) {
                    System.out.print(grid[i][y].getDef(0));
                    System.out.print(grid[i][y].getDef(1));

                }
            }
            System.out.println();

        }
    }

    public void displayGrid2(){
        int ctt = 0;
        for (int i = 0; i <= largeur - 1; i++) {
            for (int y = 0; y <= hauteur - 1; y++) {
                if (grid[i][y].getType() == 0) {
                    System.out.print(". ");
                } else if (grid[i][y].getType() == 1) {
                    System.out.print(grid[i][y].getLetter() + " ");
                } else if (grid[i][y].getType() == 2) {
                    System.out.print("2 ");
                } else if (grid[i][y].getType() == 3) {
                    System.out.print("3 ");
                }
            }
            System.out.println();

        }
    }

    public String checkCell(int parX, int parY, Definition.Direction parDirection)
    {
        String match = "";
        /** HORIZONTAL DIRECT -- START **/
        if(parDirection == Definition.Direction.HD){
            for(int i = parX + 1; i <= largeur - 1; i++){
                if(grid[parY][i].getType() == 0) {
                    match = match + ".";
                }
                else if(grid[parY][i].getType() == 1){
                    match += getCellLetter(parY,i);
                }
                else if(grid[parY][i].getType() == 2 || grid[parY][i].getType() == 3){
                    return match;
                }
            }
            return match;
        }
        /** HORIZONTAL DIRECT -- END **/
        /** HORIZONTAL INDIRECT -- START **/
        if(parDirection == Definition.Direction.HI){
            for(int i = parX; i <= largeur - 1; i++){
                if(grid[parY][i].getType() == 0) {
                    match = match + ".";
                }
                else if(grid[parY][i].getType() == 1){
                    match += getCellLetter(parY,i);
                }
                else if(grid[parY][i].getType() == 2 || grid[parY][i].getType() == 3){
                    return match;
                }
            }
            return match;
        }
        /** HORIZONTAL INDIRECT -- END **/

        /** VERTICAL DIRECT -- START **/
        if(parDirection == Definition.Direction.VD){
            for(int i = parY + 1; i <= hauteur - 1; i++){
                if(grid[i][parX].getType() == 0) {
                    match = match + ".";
                }
                else if(grid[i][parX].getType() == 1){
                    match += getCellLetter(i,parX);
                }
                else if(grid[i][parX].getType() == 2 || grid[i][parX].getType() == 3){
                    return match;
                }
            }
            return match;
        }
        /** VERTICAL DIRECT -- END **/
        /** VERTICAL INDIRECT -- START **/
        if(parDirection == Definition.Direction.VI){
            for(int i = parY; i <= hauteur - 1; i++){
                if(grid[i][parX].getType() == 0) {
                    match = match + ".";
                }
                else if(grid[i][parX].getType() == 1){
                    match += getCellLetter(i,parX);
                }
                else if(grid[i][parX].getType() == 2 || grid[i][parX].getType() == 3){
                    return match;
                }
            }
            return match;
        }
        /** VERTICAL INDIRECT -- END **/

        return match;
    }
}

