package game;

public class Message implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    public String model;
    public String content1;
    public String content2;
    @Override
    public String toString(){
        return model+" "+content1+" "+content2;
    }
}