package com.tencent.mm.plugin.topstory.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chw;

public final class b {
    public long mLr = System.currentTimeMillis();
    public boolean pZZ;
    public chw sAX;
    public boolean sAY;

    public b(chw chw) {
        AppMethodBeat.i(96381);
        this.sAX = chw;
        AppMethodBeat.o(96381);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(96382);
        if (obj == null) {
            AppMethodBeat.o(96382);
            return false;
        }
        boolean equals = this.sAX.xgS.equals(((b) obj).sAX.xgS);
        AppMethodBeat.o(96382);
        return equals;
    }
}
