package com.tencent.mm.plugin.freewifi.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    private String cuH;
    private String cxb;
    private int mwD;

    static class a {
        private static d mwE = new d();

        static {
            AppMethodBeat.i(20804);
            AppMethodBeat.o(20804);
        }
    }

    /* synthetic */ d(byte b) {
        this();
    }

    private d() {
    }

    public final synchronized boolean v(int i, String str, String str2) {
        boolean z = true;
        synchronized (this) {
            boolean z2;
            AppMethodBeat.i(20805);
            ab.i("MicroMsg.FreeWifi.Protocol31Locker", "threeOneStartUpType=%d, apKey=%s, ticket=%s", Integer.valueOf(i), str, str2);
            if (i == 1 || i == 2 || i == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z2) {
                AppMethodBeat.o(20805);
            } else if (m.isEmpty(str) || m.isEmpty(str2)) {
                AppMethodBeat.o(20805);
                z = false;
            } else if (str.equals(this.cuH) && str2.equals(this.cxb) && this.mwD != i) {
                AppMethodBeat.o(20805);
                z = false;
            } else {
                this.mwD = i;
                this.cuH = str;
                this.cxb = str2;
                AppMethodBeat.o(20805);
            }
        }
        return z;
    }
}
