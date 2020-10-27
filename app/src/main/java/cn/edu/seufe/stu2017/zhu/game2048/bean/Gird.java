package cn.edu.seufe.stu2017.zhu.game2048.bean;


public class Gird {
    int value;

    public Gird(){
        this.value = 0;
    }

    public Gird(int inputValue){
        this.value = inputValue;
    }

    public Gird(Gird inputGird){
        this.value = inputGird.getValue();
    }



    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isEqual(Gird gird){
        if(gird.value == this.value)
            return true;
        else
            return false;
    }

}
