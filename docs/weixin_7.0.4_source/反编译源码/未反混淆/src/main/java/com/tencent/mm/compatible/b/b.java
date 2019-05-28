package com.tencent.mm.compatible.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.locks.Lock;

public final class b {
    public int eoJ = 0;
    public int eoK = 0;
    public byte[] eoL = null;
    public int eoM = 0;
    public int eoN = 0;
    public boolean eoO = false;
    public Lock eoP = null;

    public final int KH() {
        AppMethodBeat.i(92829);
        if (this.eoO) {
            this.eoP.lock();
        }
        if (this.eoM == this.eoN) {
            AppMethodBeat.o(92829);
            return 0;
        }
        if (this.eoM < this.eoN) {
            this.eoK = this.eoN - this.eoM;
        } else if (this.eoM > this.eoN) {
            this.eoK = (this.eoN + this.eoJ) - this.eoM;
        }
        if (this.eoO) {
            this.eoP.unlock();
        }
        int i = this.eoK;
        AppMethodBeat.o(92829);
        return i;
    }
}
