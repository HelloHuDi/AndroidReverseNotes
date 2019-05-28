package com.google.android.exoplayer2.p105f;

import com.google.android.exoplayer2.p100b.C32022e;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.f.h */
public final class C41610h extends C32022e implements Comparable<C41610h> {
    public long aOr;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.m2504i(95656);
        C41610h c41610h = (C41610h) obj;
        if (mo42774qG() == c41610h.mo42774qG()) {
            long j = this.aSk - c41610h.aSk;
            if (j == 0) {
                AppMethodBeat.m2505o(95656);
                return 0;
            } else if (j > 0) {
                AppMethodBeat.m2505o(95656);
                return 1;
            } else {
                AppMethodBeat.m2505o(95656);
                return -1;
            }
        } else if (mo42774qG()) {
            AppMethodBeat.m2505o(95656);
            return 1;
        } else {
            AppMethodBeat.m2505o(95656);
            return -1;
        }
    }

    public C41610h() {
        super(1);
    }
}
