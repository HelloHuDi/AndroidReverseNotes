package com.tencent.mm.sdk.platformtools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class bg<T> {
    public Object[] gH;
    public int gI;

    public bg(int i) {
        AppMethodBeat.i(52275);
        if (i <= 0) {
            ab.e("MicroMsg.SimpleObjectPool", "The max pool size must be > 0");
            AppMethodBeat.o(52275);
            return;
        }
        this.gH = new Object[i];
        AppMethodBeat.o(52275);
    }

    public T aA() {
        if (this.gH == null || this.gI <= 0) {
            return null;
        }
        int i = this.gI - 1;
        T t = this.gH[i];
        this.gH[i] = null;
        this.gI--;
        return t;
    }

    public boolean release(T t) {
        AppMethodBeat.i(52276);
        if (this.gH == null) {
            AppMethodBeat.o(52276);
            return false;
        }
        int i;
        if (this.gH != null) {
            for (i = 0; i < this.gI; i++) {
                if (this.gH[i] == t) {
                    i = 1;
                    break;
                }
            }
        }
        boolean z = false;
        if (i != 0) {
            AppMethodBeat.o(52276);
            return false;
        } else if (this.gI >= this.gH.length || this.gI < 0) {
            ab.e("MicroMsg.SimpleObjectPool", "error index %d %d", Integer.valueOf(this.gI), Integer.valueOf(this.gH.length));
            AppMethodBeat.o(52276);
            return false;
        } else {
            this.gH[this.gI] = t;
            this.gI++;
            AppMethodBeat.o(52276);
            return true;
        }
    }
}
