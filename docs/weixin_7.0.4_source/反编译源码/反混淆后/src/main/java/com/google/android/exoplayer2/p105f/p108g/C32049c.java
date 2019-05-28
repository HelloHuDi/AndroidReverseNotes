package com.google.android.exoplayer2.p105f.p108g;

import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.g.c */
final class C32049c implements C17659d {
    private final List<C32044a> blz;

    public C32049c(List<C32044a> list) {
        AppMethodBeat.m2504i(95720);
        this.blz = Collections.unmodifiableList(list);
        AppMethodBeat.m2505o(95720);
    }

    /* renamed from: aj */
    public final int mo2575aj(long j) {
        return j < 0 ? 0 : -1;
    }

    /* renamed from: sG */
    public final int mo2578sG() {
        return 1;
    }

    /* renamed from: et */
    public final long mo2577et(int i) {
        AppMethodBeat.m2504i(95721);
        C45039a.checkArgument(i == 0);
        AppMethodBeat.m2505o(95721);
        return 0;
    }

    /* renamed from: ak */
    public final List<C32044a> mo2576ak(long j) {
        AppMethodBeat.m2504i(95722);
        if (j >= 0) {
            List list = this.blz;
            AppMethodBeat.m2505o(95722);
            return list;
        }
        List<C32044a> emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(95722);
        return emptyList;
    }
}
