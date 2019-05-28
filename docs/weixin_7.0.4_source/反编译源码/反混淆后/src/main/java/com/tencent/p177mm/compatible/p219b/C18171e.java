package com.tencent.p177mm.compatible.p219b;

import android.media.AudioTrack;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.compatible.b.e */
public final class C18171e extends AudioTrack {
    public C18171e(int i, int i2, int i3, int i4) {
        super(i, i2, i3, 2, i4, 1);
        AppMethodBeat.m2504i(92836);
        C1407g.m2962iL(hashCode());
        AppMethodBeat.m2505o(92836);
    }

    public final void release() {
        AppMethodBeat.m2504i(92837);
        super.release();
        C1407g.m2963iM(hashCode());
        AppMethodBeat.m2505o(92837);
    }
}
