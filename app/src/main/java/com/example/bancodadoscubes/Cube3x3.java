package com.example.bancodadoscubes;

public class Cube3x3 {
    private long _id;
    private float tempo;

    public Cube3x3(long _id, Float tempo){
        this._id = _id;
        this.tempo = tempo;
    }

    public long get_id(){return _id; }
    public void set_id(long _id){this._id = _id; }
    public float getTempo() {return tempo; }
    public void setTempo(float tempo) {this.tempo = tempo; }

    @Override
    public String toString(){
        return "\n" + "Tempo "+"\n"+tempo+"\n";
    }

}

