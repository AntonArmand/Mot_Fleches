package fr.armand.models;

public class Definition {

    private String intitule;
    private String word;
    private Direction direction;

    public Definition()
    {
        super();
    }

    public void setWord(String parWord){
        this.word = parWord;
    }

    public String getWord(){
        return this.word;
    }

    public void setIntitule(String parIntitule){
        this.intitule = parIntitule;
    }

    public String getIntitule(){
        return this.intitule + "";
    }

    public void setDirection(Direction parDirection)
    {
        this.direction = parDirection;
    }
    public Direction getDirection()
    {
        return this.direction;
    }

    public enum Direction {
        HD,
        HI,
        VD,
        VI
    }
}

