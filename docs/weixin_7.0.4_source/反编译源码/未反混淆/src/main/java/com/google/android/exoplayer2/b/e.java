package com.google.android.exoplayer2.b;

import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class e extends a {
    public ByteBuffer aEY;
    public final b aSj = new b();
    public long aSk;
    public final int aSl;

    public e(int i) {
        AppMethodBeat.i(94739);
        this.aSl = i;
        AppMethodBeat.o(94739);
    }

    public final void dD(int i) {
        AppMethodBeat.i(94740);
        if (this.aEY == null) {
            this.aEY = dE(i);
            AppMethodBeat.o(94740);
            return;
        }
        int capacity = this.aEY.capacity();
        int position = this.aEY.position();
        int i2 = position + i;
        if (capacity >= i2) {
            AppMethodBeat.o(94740);
            return;
        }
        ByteBuffer dE = dE(i2);
        if (position > 0) {
            this.aEY.position(0);
            this.aEY.limit(position);
            dE.put(this.aEY);
        }
        this.aEY = dE;
        AppMethodBeat.o(94740);
    }

    public final boolean qK() {
        AppMethodBeat.i(94741);
        boolean dC = dC(ErrorDialogData.SUPPRESSED);
        AppMethodBeat.o(94741);
        return dC;
    }

    public final void qL() {
        AppMethodBeat.i(94742);
        this.aEY.flip();
        AppMethodBeat.o(94742);
    }

    public final void clear() {
        AppMethodBeat.i(94743);
        super.clear();
        if (this.aEY != null) {
            this.aEY.clear();
        }
        AppMethodBeat.o(94743);
    }

    private ByteBuffer dE(int i) {
        AppMethodBeat.i(94744);
        ByteBuffer allocate;
        if (this.aSl == 1) {
            allocate = ByteBuffer.allocate(i);
            AppMethodBeat.o(94744);
            return allocate;
        } else if (this.aSl == 2) {
            allocate = ByteBuffer.allocateDirect(i);
            AppMethodBeat.o(94744);
            return allocate;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("Buffer too small (" + (this.aEY == null ? 0 : this.aEY.capacity()) + " < " + i + ")");
            AppMethodBeat.o(94744);
            throw illegalStateException;
        }
    }
}
