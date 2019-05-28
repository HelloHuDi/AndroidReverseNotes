package com.tencent.mm.compatible.b;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e extends AudioTrack {
    public e(int i, int i2, int i3, int i4) {
        super(i, i2, i3, 2, i4, 1);
        AppMethodBeat.i(92836);
        g.iL(hashCode());
        AppMethodBeat.o(92836);
    }

    public final void release() {
        AppMethodBeat.i(92837);
        super.release();
        g.iM(hashCode());
        AppMethodBeat.o(92837);
    }
}
