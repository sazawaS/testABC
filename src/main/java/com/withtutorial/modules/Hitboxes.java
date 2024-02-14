package com.withtutorial.modules;


public class Hitboxes extends ModuleBase
{
    private double size = 0.0F;
    private int increaseKey;
    private int decreaseKey;
    private int resetKey;

    public double getSize() {
        return size;
    }

    public void increaseSize(double size) {
        this.size += size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public int getIncreaseKey() {
        return increaseKey;
    }

    public void setIncreaseKey(int increaseKey) {
        this.increaseKey = increaseKey;
    }

    public int getDecreaseKey() {
        return decreaseKey;
    }

    public void setDecreaseKey(int decreaseKey) {
        this.decreaseKey = decreaseKey;
    }

    public void setResetKey(int resetKey) {this.resetKey = resetKey;}

    public int getResetKey() {return this.resetKey;}

}
