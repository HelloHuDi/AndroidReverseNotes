package com.tencent.p177mm.audio.mix.p1181b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p830a.C37484c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.audio.mix.b.d */
public class C45166d {
    private static C45166d ckR;
    public volatile LinkedList<String> ckO = new LinkedList();
    public volatile HashMap<String, C37484c> ckP = new HashMap();
    public volatile Object ckQ = new Object();

    private C45166d() {
        AppMethodBeat.m2504i(136992);
        AppMethodBeat.m2505o(136992);
    }

    /* renamed from: Dm */
    public static C45166d m83168Dm() {
        AppMethodBeat.m2504i(136993);
        if (ckR == null) {
            synchronized (C45166d.class) {
                try {
                    if (ckR == null) {
                        ckR = new C45166d();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136993);
                    }
                }
            }
        }
        C45166d c45166d = ckR;
        AppMethodBeat.m2505o(136993);
        return c45166d;
    }

    /* renamed from: dv */
    public final C37484c mo73133dv(String str) {
        C37484c c37484c;
        AppMethodBeat.m2504i(136994);
        synchronized (this.ckQ) {
            try {
                if (!this.ckO.contains(str)) {
                    this.ckO.add(str);
                }
                c37484c = (C37484c) this.ckP.get(str);
                if (c37484c == null) {
                    c37484c = new C37484c(str);
                    this.ckP.put(str, c37484c);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136994);
            }
        }
        return c37484c;
    }

    /* renamed from: dw */
    public final int mo73134dw(String str) {
        AppMethodBeat.m2504i(136995);
        synchronized (this.ckQ) {
            try {
                if (this.ckO.contains(str)) {
                    C37484c c37484c = (C37484c) this.ckP.get(str);
                    if (c37484c != null) {
                        int size = c37484c.size();
                        AppMethodBeat.m2505o(136995);
                        return size;
                    }
                    AppMethodBeat.m2505o(136995);
                    return 0;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136995);
            }
        }
        return 0;
    }

    /* renamed from: dx */
    public final boolean mo73135dx(String str) {
        AppMethodBeat.m2504i(136996);
        synchronized (this.ckQ) {
            try {
                if (this.ckO.contains(str)) {
                    C37484c c37484c = (C37484c) this.ckP.get(str);
                    if (c37484c == null || c37484c.size() <= 0 || !c37484c.cky) {
                        AppMethodBeat.m2505o(136996);
                        return false;
                    }
                    AppMethodBeat.m2505o(136996);
                    return true;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136996);
            }
        }
        return false;
    }

    /* renamed from: dy */
    public final long mo73136dy(String str) {
        AppMethodBeat.m2504i(136998);
        synchronized (this.ckQ) {
            try {
                if (this.ckO.contains(str)) {
                    C37484c c37484c = (C37484c) this.ckP.get(str);
                    if (c37484c == null || !c37484c.cky) {
                        AppMethodBeat.m2505o(136998);
                        return 0;
                    }
                    long Da = c37484c.mo60394Da();
                    AppMethodBeat.m2505o(136998);
                    return Da;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136998);
            }
        }
        return 0;
    }

    /* renamed from: Dn */
    public final long mo73130Dn() {
        AppMethodBeat.m2504i(136999);
        long j = 0;
        synchronized (this.ckQ) {
            try {
                Iterator it = this.ckO.iterator();
                while (it.hasNext()) {
                    long j2;
                    C37484c c37484c = (C37484c) this.ckP.get((String) it.next());
                    if (c37484c == null || !c37484c.cky || c37484c.ckB) {
                        j2 = j;
                    } else {
                        j2 = c37484c.mo60394Da() + j;
                    }
                    j = j2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136999);
            }
        }
        return j;
    }

    /* renamed from: Do */
    public final ArrayList<String> mo73131Do() {
        ArrayList<String> arrayList;
        AppMethodBeat.m2504i(137000);
        synchronized (this.ckQ) {
            try {
                arrayList = new ArrayList();
                arrayList.addAll(this.ckO);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(137000);
            }
        }
        return arrayList;
    }

    public final void clearCache() {
        AppMethodBeat.m2504i(136997);
        synchronized (this.ckQ) {
            try {
                Iterator it = this.ckO.iterator();
                while (it.hasNext()) {
                    C37484c c37484c = (C37484c) this.ckP.get((String) it.next());
                    if (c37484c != null) {
                        c37484c.reset();
                    }
                }
                this.ckO.clear();
                this.ckP.clear();
            } finally {
                AppMethodBeat.m2505o(136997);
            }
        }
    }
}
