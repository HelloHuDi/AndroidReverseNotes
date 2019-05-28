package com.google.android.exoplayer2.p105f.p798a;

import com.google.android.exoplayer2.p105f.C41611i;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.f.a.e */
public final class C45030e extends C41611i {
    private final C32043d bmz;

    public C45030e(C32043d c32043d) {
        this.bmz = c32043d;
    }

    public final void release() {
        AppMethodBeat.m2504i(95616);
        C32043d c32043d = this.bmz;
        clear();
        c32043d.bmw.add(this);
        AppMethodBeat.m2505o(95616);
    }
}
