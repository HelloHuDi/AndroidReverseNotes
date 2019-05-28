package com.tencent.p177mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.plugin.freewifi.p417g.C11961b;

/* renamed from: com.tencent.mm.plugin.freewifi.i */
public final class C11963i {
    private C11961b mtP;

    /* renamed from: com.tencent.mm.plugin.freewifi.i$a */
    public static class C11964a {
        private static C11963i mtZ = new C11963i();

        static {
            AppMethodBeat.m2504i(20599);
            AppMethodBeat.m2505o(20599);
        }
    }

    /* synthetic */ C11963i(byte b) {
        this();
    }

    private C11963i() {
        AppMethodBeat.m2504i(20600);
        this.mtP = C11976j.byX();
        AppMethodBeat.m2505o(20600);
    }

    /* renamed from: lb */
    public final synchronized long mo23808lb(String str) {
        long j = 0;
        synchronized (this) {
            AppMethodBeat.m2504i(20601);
            if (C34189m.isEmpty(str)) {
                AppMethodBeat.m2505o(20601);
            } else {
                try {
                    String MJ = this.mtP.mo23801MJ(str);
                    if (C34189m.isEmpty(MJ)) {
                        AppMethodBeat.m2505o(20601);
                    } else {
                        j = Long.valueOf(MJ).longValue();
                        AppMethodBeat.m2505o(20601);
                    }
                } catch (Exception e) {
                    AppMethodBeat.m2505o(20601);
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        AppMethodBeat.m2504i(20602);
        if (C34189m.isEmpty(str)) {
            AppMethodBeat.m2505o(20602);
        } else {
            try {
                String MJ = this.mtP.mo23801MJ(str);
                if (C34189m.isEmpty(MJ)) {
                    AppMethodBeat.m2505o(20602);
                } else {
                    i = Integer.valueOf(MJ).intValue();
                    AppMethodBeat.m2505o(20602);
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(20602);
            }
        }
        return i;
    }

    /* renamed from: F */
    public final synchronized void mo23805F(String str, long j) {
        AppMethodBeat.m2504i(20603);
        this.mtP.mo23804et(str, String.valueOf(j));
        AppMethodBeat.m2505o(20603);
    }

    /* renamed from: ch */
    public final synchronized void mo23806ch(String str, int i) {
        AppMethodBeat.m2504i(20604);
        this.mtP.mo23804et(str, String.valueOf(i));
        AppMethodBeat.m2505o(20604);
    }
}
