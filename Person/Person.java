public class Person {
    private String Name;
    private byte alter;

    public Person(String Name, byte alter) {
        this.Name = Name;
        this.alter = alter;
    }
    public String getName(){
        return Name;
    }
    public byte getAlter(){
        return alter;
    }
    public void setAlter(int a){
        alter = (byte)a;
    }
}
