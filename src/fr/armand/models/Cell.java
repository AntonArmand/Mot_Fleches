package fr.armand.models;

public class Cell{

    private Definition[] definitionArray = new Definition[2];
    private int coordX;
    private int coordY;
    private Letter letter;
    private int type;


    public Cell(int parCoordX, int parCoordY){
        this.coordY = parCoordY;
        this.coordX = parCoordX;
        this.type = 0;
    }

    public void addDef(String parDef, String parMot, String parDef2, String parMot2, Definition.Direction parDirection){
        this.definitionArray[0] = new Definition();
        this.definitionArray[0].setIntitule(parDef);
        this.definitionArray[0].setWord(parMot);
        this.definitionArray[0].setDirection(parDirection);
        this.definitionArray[1] = new Definition();
        this.definitionArray[1].setIntitule(parDef2);
        this.definitionArray[1].setWord(parMot2);
    }

    public void addLetter(String parLetter)
    {
        this.letter = new Letter();
        this.letter.setLetter(parLetter);
    }

    public void setType(int parType){

        this.type = parType;
    }


    public String getDef(int idx){
        return  this.definitionArray[idx].getIntitule() + " " + this.definitionArray[idx].getWord();
    }

    public String getWord(int idx){
        return  this.definitionArray[idx].getWord();
    }


    public String getLetter(){
        return letter.getLetter();
    }


    public int getType(){
        return this.type;
    }
    public int getCoordX(){
        return coordX;
    }
    public int getCoordY(){
        return coordY;
    }
}
