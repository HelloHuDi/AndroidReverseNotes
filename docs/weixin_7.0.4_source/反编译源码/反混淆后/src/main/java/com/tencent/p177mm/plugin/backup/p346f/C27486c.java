package com.tencent.p177mm.plugin.backup.p346f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.backup.p342b.C33660a;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.backup.f.c */
public final class C27486c extends C33660a {
    private static String TAG = "MicroMsg.BackupItemFactory";
    private static C27486c jvu;
    private HashMap<Integer, C27487l> jvv;

    public static C27486c aTz() {
        C27486c c27486c;
        AppMethodBeat.m2504i(17451);
        if (jvu == null) {
            c27486c = new C27486c();
            jvu = c27486c;
            C33660a.m54968a(c27486c);
        }
        c27486c = jvu;
        AppMethodBeat.m2505o(17451);
        return c27486c;
    }

    public final void aSp() {
        jvu = null;
    }

    /* renamed from: rq */
    public final C27487l mo45286rq(int i) {
        AppMethodBeat.m2504i(17452);
        if (this.jvv == null) {
            aTA();
        }
        C27487l c27487l = (C27487l) this.jvv.get(Integer.valueOf(i));
        AppMethodBeat.m2505o(17452);
        return c27487l;
    }

    private void aTA() {
        AppMethodBeat.m2504i(17453);
        this.jvv = new HashMap();
        this.jvv.put(Integer.valueOf(3), new C38653d());
        this.jvv.put(Integer.valueOf(47), new C19971b());
        this.jvv.put(Integer.valueOf(49), new C31338a());
        this.jvv.put(Integer.valueOf(34), new C38654g());
        C42769f c42769f = new C42769f();
        this.jvv.put(Integer.valueOf(43), c42769f);
        this.jvv.put(Integer.valueOf(44), c42769f);
        this.jvv.put(Integer.valueOf(62), c42769f);
        C42768e c42768e = new C42768e();
        this.jvv.put(Integer.valueOf(48), c42768e);
        this.jvv.put(Integer.valueOf(42), c42768e);
        this.jvv.put(Integer.valueOf(66), c42768e);
        this.jvv.put(Integer.valueOf(Downloads.MIN_WAIT_FOR_NETWORK), c42768e);
        this.jvv.put(Integer.valueOf(1), c42768e);
        this.jvv.put(Integer.valueOf(37), c42768e);
        this.jvv.put(Integer.valueOf(40), c42768e);
        this.jvv.put(Integer.valueOf(50), c42768e);
        AppMethodBeat.m2505o(17453);
    }
}
