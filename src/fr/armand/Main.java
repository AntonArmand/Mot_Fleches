package fr.armand;

import fr.armand.models.Definition;
import fr.armand.models.Dictionary;
import fr.armand.models.Grid;

public class Main {

    public static void main(String[] args) {
        System.out.println("Program compiled sucessfuly");
        Dictionary dico = new Dictionary();
        //dico.searchByMatches("M....N");
        Grid grid = new Grid(10,10);
        grid.setCellDef(0,1, "note de musique", "mi", null, null,Definition.Direction.VI, null);
        grid.setCellDef(4,1, "parDef4", "ok", "parDef5", "lo", Definition.Direction.HD, Definition.Direction.VI);
        grid.setWord(4,1, "word", Definition.Direction.HD);
        grid.displayGrid2();
        System.out.println();
        System.out.println(grid.checkCell(2,1, Definition.Direction.HD));

    }
}
