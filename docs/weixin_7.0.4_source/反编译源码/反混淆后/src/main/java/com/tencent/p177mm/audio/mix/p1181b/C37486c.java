package com.tencent.p177mm.audio.mix.p1181b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p830a.C45164d;
import java.util.ArrayList;

/* renamed from: com.tencent.mm.audio.mix.b.c */
public class C37486c {
    private static C37486c ckN;
    private ArrayList<C45164d> ckL = new ArrayList();
    private Object sLock = new Object();

    private C37486c() {
        AppMethodBeat.m2504i(136987);
        AppMethodBeat.m2505o(136987);
    }

    /* renamed from: Dk */
    public static C37486c m63255Dk() {
        AppMethodBeat.m2504i(136988);
        if (ckN == null) {
            synchronized (C37486c.class) {
                try {
                    if (ckN == null) {
                        ckN = new C37486c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136988);
                    }
                }
            }
        }
        C37486c c37486c = ckN;
        AppMethodBeat.m2505o(136988);
        return c37486c;
    }

    /* renamed from: Dj */
    public final C45164d mo60403Dj() {
        C45164d c45164d;
        AppMethodBeat.m2504i(136989);
        synchronized (this.sLock) {
            try {
                if (this.ckL.size() > 0) {
                    c45164d = (C45164d) this.ckL.remove(this.ckL.size() - 1);
                } else {
                    c45164d = new C45164d();
                    AppMethodBeat.m2505o(136989);
                    return c45164d;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136989);
            }
        }
        return c45164d;
    }

    /* renamed from: b */
    public final void mo60405b(C45164d c45164d) {
        AppMethodBeat.m2504i(136990);
        if (c45164d == null || c45164d.ckv == null) {
            AppMethodBeat.m2505o(136990);
            return;
        }
        c45164d.reset();
        synchronized (this.sLock) {
            try {
                this.ckL.add(0, c45164d);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(136990);
            }
        }
    }

    /* renamed from: Dl */
    public final synchronized long mo60404Dl() {
        long size;
        AppMethodBeat.m2504i(136991);
        size = (long) (this.ckL.size() * 3536);
        AppMethodBeat.m2505o(136991);
        return size;
    }
}
