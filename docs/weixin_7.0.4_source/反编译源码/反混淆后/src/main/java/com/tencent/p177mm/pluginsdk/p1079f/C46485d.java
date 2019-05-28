package com.tencent.p177mm.pluginsdk.p1079f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p599a.C4872b;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.pluginsdk.f.d */
public final class C46485d {
    public static C46485d vdw = new C46485d("default");
    private boolean nDl = false;
    private ConcurrentHashMap<String, Integer> vdt = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> vdu = new ConcurrentHashMap();
    private String vdv = "";

    static {
        AppMethodBeat.m2504i(79452);
        AppMethodBeat.m2505o(79452);
    }

    public C46485d(String str) {
        AppMethodBeat.m2504i(79450);
        if (C4872b.dnO()) {
            this.nDl = true;
        }
        this.vdv = str;
        AppMethodBeat.m2505o(79450);
    }

    public final void aiV(String str) {
        AppMethodBeat.m2504i(79451);
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
            AppMethodBeat.m2505o(79451);
            return;
        }
        AppMethodBeat.m2505o(79451);
    }
}
