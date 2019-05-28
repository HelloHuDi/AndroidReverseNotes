package com.google.android.exoplayer2.p105f.p1586c;

import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.f.c.b */
final class C41605b implements C17659d {
    private final long[] bnA;
    private final C32044a[] bnz;

    public C41605b(C32044a[] c32044aArr, long[] jArr) {
        this.bnz = c32044aArr;
        this.bnA = jArr;
    }

    /* renamed from: aj */
    public final int mo2575aj(long j) {
        AppMethodBeat.m2504i(95643);
        int a = C17675v.m27554a(this.bnA, j, false, false);
        if (a < this.bnA.length) {
            AppMethodBeat.m2505o(95643);
            return a;
        }
        AppMethodBeat.m2505o(95643);
        return -1;
    }

    /* renamed from: sG */
    public final int mo2578sG() {
        return this.bnA.length;
    }

    /* renamed from: et */
    public final long mo2577et(int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.m2504i(95644);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        C45039a.checkArgument(z);
        if (i >= this.bnA.length) {
            z2 = false;
        }
        C45039a.checkArgument(z2);
        long j = this.bnA[i];
        AppMethodBeat.m2505o(95644);
        return j;
    }

    /* renamed from: ak */
    public final List<C32044a> mo2576ak(long j) {
        AppMethodBeat.m2504i(95645);
        int a = C17675v.m27553a(this.bnA, j, false);
        if (a == -1 || this.bnz[a] == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.m2505o(95645);
            return emptyList;
        }
        List<C32044a> singletonList = Collections.singletonList(this.bnz[a]);
        AppMethodBeat.m2505o(95645);
        return singletonList;
    }
}
