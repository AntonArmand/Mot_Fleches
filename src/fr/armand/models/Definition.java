package fr.armand.models;

public class Definition {

    private String text;
    private int lenght;


    public void setText(String parText)
    {
        this.text = parText;
    }

    public void setLenght(int parLenght)
    {
        this.lenght = parLenght;
    }

    public String getText()
    {
        return this.text;
    }

    public int getLenght()
    {
        return this.lenght;
    }
    public enum Sens {
        BOT,
        RIGHT
    }

    public enum Direction {
        HORIZONTAL,
        VERTICAL
    }

}

