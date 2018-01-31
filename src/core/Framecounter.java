package core;

public class Framecounter {
    private int count ;
    private int maxcount;
    public Framecounter(int maxcount){
        this.maxcount = maxcount;
        this.count =0;
    }

    public boolean run(){
        if (count>maxcount) return true;
        else count +=1;
        return false;
    }

    public void reset() {
        count =0;
    }

    public boolean bossrun() {
        count+=1;
        if (count == maxcount) return true;
        return false;
    }
}
