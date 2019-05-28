package com.tencent.p177mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.pluginsdk.s */
public class C44071s {
    private LinkedList<C40448a> vay = new LinkedList();

    /* renamed from: com.tencent.mm.pluginsdk.s$a */
    public class C40448a {
        public String detail;
        public String key;
        public long time;

        C40448a(String str, long j, String str2) {
            this.key = str;
            this.time = j;
            this.detail = str2;
        }
    }

    public C44071s() {
        AppMethodBeat.m2504i(105834);
        AppMethodBeat.m2505o(105834);
    }

    /* renamed from: aI */
    public final void mo69758aI(String str, long j) {
        AppMethodBeat.m2504i(105835);
        m79220c(str, j, "");
        AppMethodBeat.m2505o(105835);
    }

    /* renamed from: c */
    private void m79220c(String str, long j, String str2) {
        AppMethodBeat.m2504i(105836);
        this.vay.add(new C40448a(str, j, str2));
        AppMethodBeat.m2505o(105836);
    }

    public final long ais(String str) {
        AppMethodBeat.m2504i(105837);
        Iterator it = this.vay.iterator();
        while (it.hasNext()) {
            C40448a c40448a = (C40448a) it.next();
            if (c40448a.key.equals(str)) {
                long j = c40448a.time;
                AppMethodBeat.m2505o(105837);
                return j;
            }
        }
        AppMethodBeat.m2505o(105837);
        return 0;
    }
}
