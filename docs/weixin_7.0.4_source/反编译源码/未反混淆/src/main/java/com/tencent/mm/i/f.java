package com.tencent.mm.i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f extends e {
    public String cFc;
    public int counter = 0;
    public BatchSnsReqImageData[] egb;
    public int egj;
    public volatile boolean egk = false;
    public int gXe;

    public final boolean Jo() {
        if (this.egj == this.counter) {
            return true;
        }
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(128596);
        String format = String.format("feedId: %s, count:%d", new Object[]{this.cFc, Integer.valueOf(this.egj)});
        AppMethodBeat.o(128596);
        return format;
    }
}
