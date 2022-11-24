package com.example.bancodadoscubes;

public class Cube2x2 {
    private long _id;
    private String tempo2x2;

    public Cube2x2(long _id, String tempo2x2){
        this._id = _id;
        this.tempo2x2 = tempo2x2;
    }

    public long get_id(){return _id; }
    public void set_id(long _id){this._id = _id; }
    public String getTempo2x2() {return tempo2x2; }
    public void setTempo(String tempo) {this.tempo2x2 = tempo; }

    @Override
    public String toString(){
        return "\n" + "Tempo "+"\n"+tempo2x2+"\n";
    }

}
