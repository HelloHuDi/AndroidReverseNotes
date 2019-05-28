package com.tencent.p177mm.plugin.freewifi.p974e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.freewifi.e.d */
public final class C39105d {
    private String cuH;
    private String cxb;
    private int mwD;

    /* renamed from: com.tencent.mm.plugin.freewifi.e.d$a */
    static class C39106a {
        private static C39105d mwE = new C39105d();

        static {
            AppMethodBeat.m2504i(20804);
            AppMethodBeat.m2505o(20804);
        }
    }

    /* synthetic */ C39105d(byte b) {
        this();
    }

    private C39105d() {
    }

    /* renamed from: v */
    public final synchronized boolean mo62007v(int i, String str, String str2) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            AppMethodBeat.m2504i(20805);
            C4990ab.m7417i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", Integer.valueOf(i), str, str2);
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.m2505o(20805);
            } else if (C34189m.isEmpty(str) || C34189m.isEmpty(str2)) {
                AppMethodBeat.m2505o(20805);
                z = false;
            } else if (str.equals(this.cuH) && str2.equals(this.cxb) && this.mwD != i) {
                AppMethodBeat.m2505o(20805);
                z = false;
            } else {
                this.mwD = i;
                this.cuH = str;
                this.cxb = str2;
                AppMethodBeat.m2505o(20805);
            }
        }
        return z;
    }
}
