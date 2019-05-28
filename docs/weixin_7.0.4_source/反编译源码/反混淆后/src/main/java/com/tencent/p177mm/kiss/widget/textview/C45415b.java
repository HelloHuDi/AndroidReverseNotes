package com.tencent.p177mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.kiss.widget.textview.b */
public final class C45415b {
    public ConcurrentHashMap<String, LinkedList<C37874f>> eNi = new ConcurrentHashMap();

    public C45415b() {
        AppMethodBeat.m2504i(105691);
        AppMethodBeat.m2505o(105691);
    }

    /* renamed from: a */
    public final synchronized void mo73208a(C37874f c37874f) {
        AppMethodBeat.m2504i(105692);
        if (c37874f == null || c37874f.eNM == null) {
            AppMethodBeat.m2505o(105692);
        } else {
            LinkedList linkedList = (LinkedList) this.eNi.get(c37874f.eNM.toString());
            if (linkedList == null) {
                linkedList = new LinkedList();
            }
            linkedList.add(c37874f);
            this.eNi.put(c37874f.eNM.toString(), linkedList);
            AppMethodBeat.m2505o(105692);
        }
    }

    /* renamed from: u */
    public final synchronized C37874f mo73209u(CharSequence charSequence) {
        C37874f c37874f;
        AppMethodBeat.m2504i(105693);
        LinkedList linkedList = (LinkedList) this.eNi.get(charSequence.toString());
        if (linkedList == null || linkedList.size() == 0) {
            c37874f = null;
            AppMethodBeat.m2505o(105693);
        } else {
            c37874f = (C37874f) linkedList.removeFirst();
            AppMethodBeat.m2505o(105693);
        }
        return c37874f;
    }
}
