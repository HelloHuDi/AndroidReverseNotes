package com.tencent.p177mm.compatible.p219b;

import android.media.AudioRecord;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.compatible.b.d */
public final class C18170d extends AudioRecord {
    public C18170d(int i, int i2, int i3, int i4) {
        super(i, i2, i3, 2, i4);
        AppMethodBeat.m2504i(92834);
        C1407g.m2964iN(hashCode());
        AppMethodBeat.m2505o(92834);
    }

    public final void release() {
        AppMethodBeat.m2504i(92835);
        super.release();
        C1407g.m2965iO(hashCode());
        AppMethodBeat.m2505o(92835);
    }
}
