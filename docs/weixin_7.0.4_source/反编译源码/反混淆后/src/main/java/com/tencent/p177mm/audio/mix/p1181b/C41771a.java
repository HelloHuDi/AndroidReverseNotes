package com.tencent.p177mm.audio.mix.p1181b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.audio.mix.p830a.C25836b;
import java.util.ArrayList;
import java.util.Arrays;

/* renamed from: com.tencent.mm.audio.mix.b.a */
public class C41771a {
    private static C41771a ckI;
    private ArrayList<C25836b> ckJ = new ArrayList();

    private C41771a() {
        AppMethodBeat.m2504i(136979);
        AppMethodBeat.m2505o(136979);
    }

    /* renamed from: Dg */
    public static C41771a m73730Dg() {
        AppMethodBeat.m2504i(136980);
        if (ckI == null) {
            synchronized (C41771a.class) {
                try {
                    if (ckI == null) {
                        ckI = new C41771a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(136980);
                    }
                }
            }
        }
        C41771a c41771a = ckI;
        AppMethodBeat.m2505o(136980);
        return c41771a;
    }

    /* renamed from: Dh */
    public final synchronized C25836b mo67524Dh() {
        C25836b c25836b;
        AppMethodBeat.m2504i(136981);
        if (this.ckJ.size() > 0) {
            c25836b = (C25836b) this.ckJ.remove(this.ckJ.size() - 1);
            AppMethodBeat.m2505o(136981);
        } else {
            c25836b = new C25836b();
            AppMethodBeat.m2505o(136981);
        }
        return c25836b;
    }

    /* renamed from: a */
    public final synchronized void mo67525a(C25836b c25836b) {
        AppMethodBeat.m2504i(136982);
        if (c25836b == null || c25836b.ckv == null) {
            AppMethodBeat.m2505o(136982);
        } else {
            c25836b.channels = 0;
            c25836b.sampleRate = 0;
            c25836b.ckw.clear();
            Arrays.fill(c25836b.ckv, 0, c25836b.ckv.length, (byte) 0);
            this.ckJ.add(0, c25836b);
            AppMethodBeat.m2505o(136982);
        }
    }
}
