package com.tencent.mm.plugin.freewifi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.b;
import com.tencent.mm.plugin.freewifi.model.j;

public final class i {
    private b mtP;

    public static class a {
        private static i mtZ = new i();

        static {
            AppMethodBeat.i(20599);
            AppMethodBeat.o(20599);
        }
    }

    /* synthetic */ i(byte b) {
        this();
    }

    private i() {
        AppMethodBeat.i(20600);
        this.mtP = j.byX();
        AppMethodBeat.o(20600);
    }

    public final synchronized long lb(String str) {
        long j = 0;
        synchronized (this) {
            AppMethodBeat.i(20601);
            if (m.isEmpty(str)) {
                AppMethodBeat.o(20601);
            } else {
                try {
                    String MJ = this.mtP.MJ(str);
                    if (m.isEmpty(MJ)) {
                        AppMethodBeat.o(20601);
                    } else {
                        j = Long.valueOf(MJ).longValue();
                        AppMethodBeat.o(20601);
                    }
                } catch (Exception e) {
                    AppMethodBeat.o(20601);
                }
            }
        }
        return j;
    }

    public final synchronized int getInt(String str, int i) {
        AppMethodBeat.i(20602);
        if (m.isEmpty(str)) {
            AppMethodBeat.o(20602);
        } else {
            try {
                String MJ = this.mtP.MJ(str);
                if (m.isEmpty(MJ)) {
                    AppMethodBeat.o(20602);
                } else {
                    i = Integer.valueOf(MJ).intValue();
                    AppMethodBeat.o(20602);
                }
            } catch (Exception e) {
                AppMethodBeat.o(20602);
            }
        }
        return i;
    }

    public final synchronized void F(String str, long j) {
        AppMethodBeat.i(20603);
        this.mtP.et(str, String.valueOf(j));
        AppMethodBeat.o(20603);
    }

    public final synchronized void ch(String str, int i) {
        AppMethodBeat.i(20604);
        this.mtP.et(str, String.valueOf(i));
        AppMethodBeat.o(20604);
    }
}
