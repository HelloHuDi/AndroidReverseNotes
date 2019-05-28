package com.google.android.exoplayer2.f.e;

import android.support.v4.widget.j;
import android.text.SpannableStringBuilder;
import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

final class e implements d {
    private final b bod;
    private final long[] boe;
    private final Map<String, d> bof;
    private final Map<String, c> bog;

    public e(b bVar, Map<String, d> map, Map<String, c> map2) {
        AppMethodBeat.i(95694);
        this.bod = bVar;
        this.bog = map2;
        this.bof = Collections.unmodifiableMap(map);
        this.boe = bVar.tb();
        AppMethodBeat.o(95694);
    }

    public final int aj(long j) {
        AppMethodBeat.i(95695);
        int a = v.a(this.boe, j, false, false);
        if (a < this.boe.length) {
            AppMethodBeat.o(95695);
            return a;
        }
        AppMethodBeat.o(95695);
        return -1;
    }

    public final int sG() {
        return this.boe.length;
    }

    public final long et(int i) {
        return this.boe[i];
    }

    public final List<a> ak(long j) {
        AppMethodBeat.i(95696);
        b bVar = this.bod;
        Map map = this.bof;
        Map map2 = this.bog;
        Map treeMap = new TreeMap();
        bVar.a(j, false, bVar.bnN, treeMap);
        bVar.b(map, treeMap);
        ArrayList arrayList = new ArrayList();
        for (Entry entry : treeMap.entrySet()) {
            c cVar = (c) map2.get(entry.getKey());
            arrayList.add(new a(b.a((SpannableStringBuilder) entry.getValue()), null, cVar.bkW, cVar.lineType, cVar.bkX, cVar.bkY, j.INVALID_ID, cVar.width));
        }
        AppMethodBeat.o(95696);
        return arrayList;
    }
}
