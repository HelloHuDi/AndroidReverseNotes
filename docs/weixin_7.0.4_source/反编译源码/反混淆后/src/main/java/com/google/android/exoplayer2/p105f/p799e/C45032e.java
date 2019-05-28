package com.google.android.exoplayer2.p105f.p799e;

import android.support.p057v4.widget.C8415j;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.p105f.C17659d;
import com.google.android.exoplayer2.p105f.C32044a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

/* renamed from: com.google.android.exoplayer2.f.e.e */
final class C45032e implements C17659d {
    private final C25535b bod;
    private final long[] boe;
    private final Map<String, C8674d> bof;
    private final Map<String, C8673c> bog;

    public C45032e(C25535b c25535b, Map<String, C8674d> map, Map<String, C8673c> map2) {
        AppMethodBeat.m2504i(95694);
        this.bod = c25535b;
        this.bog = map2;
        this.bof = Collections.unmodifiableMap(map);
        this.boe = c25535b.mo42791tb();
        AppMethodBeat.m2505o(95694);
    }

    /* renamed from: aj */
    public final int mo2575aj(long j) {
        AppMethodBeat.m2504i(95695);
        int a = C17675v.m27554a(this.boe, j, false, false);
        if (a < this.boe.length) {
            AppMethodBeat.m2505o(95695);
            return a;
        }
        AppMethodBeat.m2505o(95695);
        return -1;
    }

    /* renamed from: sG */
    public final int mo2578sG() {
        return this.boe.length;
    }

    /* renamed from: et */
    public final long mo2577et(int i) {
        return this.boe[i];
    }

    /* renamed from: ak */
    public final List<C32044a> mo2576ak(long j) {
        AppMethodBeat.m2504i(95696);
        C25535b c25535b = this.bod;
        Map map = this.bof;
        Map map2 = this.bog;
        Map treeMap = new TreeMap();
        c25535b.mo42788a(j, false, c25535b.bnN, treeMap);
        c25535b.mo42790b(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            C8673c c8673c = (C8673c) map2.get(entry.getKey());
            arrayList.add(new C32044a(C25535b.m40363a((SpannableStringBuilder) entry.getValue()), null, c8673c.bkW, c8673c.lineType, c8673c.bkX, c8673c.bkY, C8415j.INVALID_ID, c8673c.width));
        }
        AppMethodBeat.m2505o(95696);
        return arrayList;
    }
}
