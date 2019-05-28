package com.tencent.mm.plugin.expt.hellhound.a.c;

import com.tencent.mm.protocal.protobuf.caz;

final class a {
    caz lMV;

    a() {
    }

    /* Access modifiers changed, original: final */
    public final boolean bqH() {
        int i;
        int i2 = this.lMV.xaf + this.lMV.qDY;
        int i3 = this.lMV.iev - this.lMV.xae;
        int i4 = this.lMV.y >= i2 ? this.lMV.y : i2;
        int i5 = this.lMV.height + this.lMV.y;
        if (i5 >= i3) {
            i = i3;
        } else {
            i = i5;
        }
        if (this.lMV.y >= i3) {
            return false;
        }
        if (i5 <= i2) {
            return false;
        }
        if (this.lMV.y >= i2 && i5 <= i3) {
            return true;
        }
        i4 = i - i4;
        if (((float) i4) / ((float) this.lMV.height) >= 0.9f) {
            return true;
        }
        return ((float) i4) / ((float) (i3 - i2)) >= 0.5f;
    }

    public final String toString() {
        return this.lMV.feedId;
    }
}
