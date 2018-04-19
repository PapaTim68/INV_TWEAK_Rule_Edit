package main;

public class DItem {


    private String Name;
    private int ID;
    private boolean isBlock;
    private String Mod;
    private String ModClass;

    public DItem(String Name,int ID,boolean HasBlock,String Mod,String ModClass) {
        this.Name = Name;
        this.ID = ID;
        this.isBlock = HasBlock;
        this.Mod = Mod;
        this.ModClass = ModClass;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    public boolean isBlock() {
        return isBlock;
    }

    public String getMod() {
        return Mod;
    }
    public String getModClass() {
        return ModClass;
    }
}
