package com.tencent.p177mm.kiss.widget.textview;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kiss.widget.textview.p1194a.C42149a;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.kiss.widget.textview.c */
public final class C37873c {
    public static C37873c eNj = new C37873c();
    public ConcurrentHashMap<Integer, C45415b> eNk = new ConcurrentHashMap();

    public C37873c() {
        AppMethodBeat.m2504i(105694);
        AppMethodBeat.m2505o(105694);
    }

    static {
        AppMethodBeat.m2504i(105699);
        AppMethodBeat.m2505o(105699);
    }

    /* renamed from: a */
    public final void mo60604a(C42149a c42149a, C37874f c37874f) {
        AppMethodBeat.m2504i(105695);
        if (c42149a == null) {
            AppMethodBeat.m2505o(105695);
            return;
        }
        C45415b c45415b = (C45415b) this.eNk.get(Integer.valueOf(c42149a.hashCode()));
        if (c45415b != null) {
            c45415b.mo73208a(c37874f);
            this.eNk.put(Integer.valueOf(c42149a.hashCode()), c45415b);
            AppMethodBeat.m2505o(105695);
            return;
        }
        c45415b = new C45415b();
        c45415b.mo73208a(c37874f);
        this.eNk.put(Integer.valueOf(c42149a.hashCode()), c45415b);
        AppMethodBeat.m2505o(105695);
    }

    /* renamed from: a */
    public final C37874f mo60603a(C42149a c42149a, CharSequence charSequence) {
        AppMethodBeat.m2504i(105696);
        if (c42149a != null) {
            C45415b c45415b = (C45415b) this.eNk.get(Integer.valueOf(c42149a.hashCode()));
            if (c45415b != null) {
                C37874f u = c45415b.mo73209u(charSequence);
                AppMethodBeat.m2505o(105696);
                return u;
            }
        }
        AppMethodBeat.m2505o(105696);
        return null;
    }

    /* renamed from: SN */
    public final void mo60602SN() {
        AppMethodBeat.m2504i(105697);
        for (C45415b c45415b : this.eNk.values()) {
            c45415b.eNi.clear();
        }
        this.eNk.clear();
        AppMethodBeat.m2505o(105697);
    }

    /* renamed from: a */
    public static int m63915a(C42149a c42149a) {
        AppMethodBeat.m2504i(105698);
        int hashCode = c42149a.hashCode();
        AppMethodBeat.m2505o(105698);
        return hashCode;
    }
}
