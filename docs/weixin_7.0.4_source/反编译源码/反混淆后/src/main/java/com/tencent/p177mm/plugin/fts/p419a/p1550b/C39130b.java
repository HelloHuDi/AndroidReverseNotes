package com.tencent.p177mm.plugin.fts.p419a.p1550b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.fts.a.b.b */
public final class C39130b {
    private HashSet<String> mEQ = new HashSet();
    public C45969c mER = new C45969c(' ');

    public C39130b() {
        AppMethodBeat.m2504i(114284);
        AppMethodBeat.m2505o(114284);
    }

    /* renamed from: Ni */
    public final void mo62033Ni(String str) {
        AppMethodBeat.m2504i(114285);
        if (this.mEQ.add(str)) {
            C45969c c45969c = this.mER;
            char[] toCharArray = str.toLowerCase().toCharArray();
            for (int i = 0; i < toCharArray.length; i++) {
                int i2 = toCharArray[i] - 97;
                if (c45969c.mES[i2] == null) {
                    c45969c.mES[i2] = new C45969c(toCharArray[i]);
                }
                c45969c = c45969c.mES[i2];
            }
            c45969c.mEP = true;
            AppMethodBeat.m2505o(114285);
            return;
        }
        AppMethodBeat.m2505o(114285);
    }

    /* renamed from: Nj */
    public final List<List<String>> mo62034Nj(String str) {
        AppMethodBeat.m2504i(114286);
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.offer(new C43122a(0, 0, null));
        char[] toCharArray = str.toLowerCase().toCharArray();
        ArrayList arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            C43122a c43122a = (C43122a) arrayDeque.poll();
            if (c43122a == null) {
                break;
            }
            int i = c43122a.end;
            C45969c c45969c = this.mER;
            while (i < toCharArray.length) {
                int i2 = toCharArray[i] - 97;
                if (c45969c.mES[i2] == null) {
                    break;
                }
                c45969c = c45969c.mES[i2];
                if (c45969c.mEP || i == toCharArray.length - 1) {
                    if (c43122a.bnR == null) {
                        c43122a.bnR = new ArrayList();
                    }
                    C43122a c43122a2 = new C43122a(c43122a.end, i + 1, c43122a);
                    c43122a.bnR.add(c43122a2);
                    if (c43122a2.end == toCharArray.length) {
                        c43122a2.mEP = true;
                    }
                    arrayDeque.offer(c43122a2);
                }
                i++;
            }
            if (c43122a.mEP) {
                ArrayList arrayList2 = new ArrayList();
                while (c43122a != null) {
                    if (c43122a.end > c43122a.start) {
                        arrayList2.add(str.substring(c43122a.start, c43122a.end));
                    }
                    c43122a = c43122a.mEO;
                }
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
        }
        AppMethodBeat.m2505o(114286);
        return arrayList;
    }
}
