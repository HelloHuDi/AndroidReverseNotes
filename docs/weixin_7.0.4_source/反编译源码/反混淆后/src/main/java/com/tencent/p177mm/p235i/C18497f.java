package com.tencent.p177mm.p235i;

import com.tencent.mars.cdn.CdnLogic.BatchSnsReqImageData;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.i.f */
public final class C18497f extends C26325e {
    public String cFc;
    public int counter = 0;
    public BatchSnsReqImageData[] egb;
    public int egj;
    public volatile boolean egk = false;
    public int gXe;

    /* renamed from: Jo */
    public final boolean mo33736Jo() {
        if (this.egj == this.counter) {
            return true;
        }
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(128596);
        String format = String.format("feedId: %s, count:%d", new Object[]{this.cFc, Integer.valueOf(this.egj)});
        AppMethodBeat.m2505o(128596);
        return format;
    }
}
