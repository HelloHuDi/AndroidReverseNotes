package android.support.v7.widget;

import android.support.v4.widget.j;

final class as {
    int Ls = j.INVALID_ID;
    int aqm = j.INVALID_ID;
    int aqn = 0;
    int aqo = 0;
    boolean aqp = false;
    boolean hq = false;
    int xJ = 0;
    int xM = 0;

    as() {
    }

    public final void aI(int i, int i2) {
        this.aqm = i;
        this.Ls = i2;
        this.aqp = true;
        if (this.hq) {
            if (i2 != j.INVALID_ID) {
                this.xJ = i2;
            }
            if (i != j.INVALID_ID) {
                this.xM = i;
                return;
            }
            return;
        }
        if (i != j.INVALID_ID) {
            this.xJ = i;
        }
        if (i2 != j.INVALID_ID) {
            this.xM = i2;
        }
    }
}
