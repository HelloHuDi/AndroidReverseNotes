package com.tencent.mm.compatible.b;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d extends AudioRecord {
    public d(int i, int i2, int i3, int i4) {
        super(i, i2, i3, 2, i4);
        AppMethodBeat.i(92834);
        g.iN(hashCode());
        AppMethodBeat.o(92834);
    }

    public final void release() {
        AppMethodBeat.i(92835);
        super.release();
        g.iO(hashCode());
        AppMethodBeat.o(92835);
    }
}
