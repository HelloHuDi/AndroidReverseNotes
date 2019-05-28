package com.tencent.mm.pluginsdk.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public static d vdw = new d("default");
    private boolean nDl = false;
    private ConcurrentHashMap<String, Integer> vdt = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> vdu = new ConcurrentHashMap();
    private String vdv = "";

    static {
        AppMethodBeat.i(79452);
        AppMethodBeat.o(79452);
    }

    public d(String str) {
        AppMethodBeat.i(79450);
        if (b.dnO()) {
            this.nDl = true;
        }
        this.vdv = str;
        AppMethodBeat.o(79450);
    }

    public final void aiV(String str) {
        AppMethodBeat.i(79451);
        if (this.nDl) {
            int intValue;
            long longValue;
            if (this.vdt.containsKey(str)) {
                intValue = ((Integer) this.vdt.get(str)).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue + 1;
            this.vdt.put(str, Integer.valueOf(i));
            if (this.vdu.containsKey(str)) {
                longValue = ((Long) this.vdu.get(str)).longValue();
            } else {
                longValue = 0;
            }
            if (System.currentTimeMillis() - longValue > 1000) {
                new StringBuilder().append(this.vdv).append("user get fps ").append(i).append(" fpswraper: ").append(str);
                this.vdt.put(str, Integer.valueOf(0));
                this.vdu.put(str, Long.valueOf(System.currentTimeMillis()));
            }
            AppMethodBeat.o(79451);
            return;
        }
        AppMethodBeat.o(79451);
    }
}
