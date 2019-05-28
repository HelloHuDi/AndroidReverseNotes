package com.google.android.exoplayer2.p105f.p107f;

import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.f.b */
final class C0857b implements C17659d {
    public static final C0857b boq = new C0857b();
    private final List<C32044a> blz;

    static {
        AppMethodBeat.m2504i(95707);
        AppMethodBeat.m2505o(95707);
    }

    public C0857b(C32044a c32044a) {
        AppMethodBeat.m2504i(95703);
        this.blz = Collections.singletonList(c32044a);
        AppMethodBeat.m2505o(95703);
    }

    private C0857b() {
        AppMethodBeat.m2504i(95704);
        this.blz = Collections.emptyList();
        AppMethodBeat.m2505o(95704);
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
        AppMethodBeat.m2504i(95705);
        C45039a.checkArgument(i == 0);
        AppMethodBeat.m2505o(95705);
        return 0;
    }

    /* renamed from: ak */
    public final List<C32044a> mo2576ak(long j) {
        AppMethodBeat.m2504i(95706);
        if (j >= 0) {
            List list = this.blz;
            AppMethodBeat.m2505o(95706);
            return list;
        }
        List<C32044a> emptyList = Collections.emptyList();
        AppMethodBeat.m2505o(95706);
        return emptyList;
    }
}
