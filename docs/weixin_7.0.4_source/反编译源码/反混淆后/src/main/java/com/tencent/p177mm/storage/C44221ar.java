package com.tencent.p177mm.storage;

/* renamed from: com.tencent.mm.storage.ar */
public final class C44221ar {
    public String cwg;
    public String lcC;
    public int xXV;
    private boolean xXW;
    public int xXX;
    public int xXY;
    public String xXZ;
    public String xYa;
    public String xYb;

    public C44221ar() {
        this.xXW = false;
        this.xXV = -1;
    }

    public C44221ar(String str) {
        this.xXW = false;
        this.cwg = str;
        this.xXV = -1;
    }

    /* renamed from: Mo */
    public final void mo69859Mo(int i) {
        if (!(this.xXV == -1 || this.xXV == i || i != 7)) {
            this.xXW = true;
        }
        this.xXV = i;
    }
}
