package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class f extends a<f> {
    public int AxA;
    public int AxB;
    public int AxC;
    public int AxD;
    public int AxE;
    public int AxF;
    public int AxG;
    public int Axx;

    public final /* synthetic */ int compareTo(Object obj) {
        f fVar = (f) obj;
        int hX = c.hX(this.AxA, fVar.AxA);
        if (hX != 0) {
            return hX;
        }
        hX = c.hY(this.Axx, fVar.Axx);
        if (hX != 0) {
            return hX;
        }
        hX = c.hX(this.AxB, fVar.AxB);
        if (hX != 0) {
            return hX;
        }
        hX = c.hY(this.AxC, fVar.AxC);
        if (hX != 0) {
            return hX;
        }
        hX = c.hX(this.AxD, fVar.AxD);
        if (hX != 0) {
            return hX;
        }
        hX = c.hY(this.AxE, fVar.AxE);
        if (hX != 0) {
            return hX;
        }
        hX = c.hY(this.AxF, fVar.AxF);
        if (hX == 0) {
            return c.hY(this.AxG, fVar.AxG);
        }
        return hX;
    }

    public f(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        super(i);
        this.AxA = i2;
        this.Axx = i3;
        this.AxB = i4;
        this.AxC = i5;
        this.AxD = i6;
        this.AxE = i7;
        this.AxF = i8;
        this.AxG = i9;
    }
}
