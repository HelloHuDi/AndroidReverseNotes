package com.tencent.p177mm.plugin.topstory.p539a.p1414b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.protocal.protobuf.chw;

/* renamed from: com.tencent.mm.plugin.topstory.a.b.b */
public final class C39960b {
    public long mLr = System.currentTimeMillis();
    public boolean pZZ;
    public chw sAX;
    public boolean sAY;

    public C39960b(chw chw) {
        AppMethodBeat.m2504i(96381);
        this.sAX = chw;
        AppMethodBeat.m2505o(96381);
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(96382);
        if (obj == null) {
            AppMethodBeat.m2505o(96382);
            return false;
        }
        boolean equals = this.sAX.xgS.equals(((C39960b) obj).sAX.xgS);
        AppMethodBeat.m2505o(96382);
        return equals;
    }
}
