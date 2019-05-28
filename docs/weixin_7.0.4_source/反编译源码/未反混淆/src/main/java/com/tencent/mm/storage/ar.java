package com.tencent.mm.storage;

public final class ar {
    public String cwg;
    public String lcC;
    public int xXV;
    private boolean xXW;
    public int xXX;
    public int xXY;
    public String xXZ;
    public String xYa;
    public String xYb;

    public ar() {
        this.xXW = false;
        this.xXV = -1;
    }

    public ar(String str) {
        this.xXW = false;
        this.cwg = str;
        this.xXV = -1;
    }

    public final void Mo(int i) {
        if (!(this.xXV == -1 || this.xXV == i || i != 7)) {
            this.xXW = true;
        }
        this.xXV = i;
    }
}
