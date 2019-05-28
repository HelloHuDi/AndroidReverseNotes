package com.tencent.p177mm.plugin.appbrand;

import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.page.p327a.C42642c.C2405a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.tencent.mm.plugin.appbrand.n */
public final class C38450n {
    private static final Map<String, C38450n> eGg = new C6197a();
    private static final C38450n gPb = new C38450n();
    public volatile String gPc;
    public final AtomicInteger gPd = new AtomicInteger();
    public final AtomicBoolean gPe = new AtomicBoolean(false);
    public C2405a gPf = null;
    public volatile String gPg;
    public volatile String gPh;
    public volatile boolean gPi;
    public volatile boolean gPj;
    public volatile boolean gPk;
    public volatile boolean gPl = false;
    public volatile boolean gPm = false;
    public volatile boolean gPn = false;

    static {
        AppMethodBeat.m2504i(86746);
        AppMethodBeat.m2505o(86746);
    }

    private C38450n() {
        AppMethodBeat.m2504i(86739);
        AppMethodBeat.m2505o(86739);
    }

    /* renamed from: wX */
    public static C38450n m65045wX(String str) {
        AppMethodBeat.m2504i(86740);
        C38450n wY = C38450n.m65046wY(str);
        AppMethodBeat.m2505o(86740);
        return wY;
    }

    /* renamed from: wY */
    private static C38450n m65046wY(String str) {
        AppMethodBeat.m2504i(86741);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(86741);
            return null;
        }
        C38450n c38450n;
        synchronized (eGg) {
            try {
                c38450n = (C38450n) eGg.get(str);
                if (c38450n == null) {
                    c38450n = new C38450n();
                    eGg.put(str, c38450n);
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86741);
            }
        }
        return c38450n;
    }

    /* renamed from: wZ */
    private static C38450n m65047wZ(String str) {
        AppMethodBeat.m2504i(86742);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(86742);
            return null;
        }
        C38450n c38450n;
        synchronized (eGg) {
            try {
                c38450n = (C38450n) eGg.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86742);
            }
        }
        return c38450n;
    }

    static void remove(String str) {
        AppMethodBeat.m2504i(86743);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(86743);
            return;
        }
        synchronized (eGg) {
            try {
                eGg.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86743);
            }
        }
    }

    /* renamed from: xa */
    public static C38450n m65048xa(String str) {
        AppMethodBeat.m2504i(86744);
        C38450n wZ = C38450n.m65047wZ(str);
        if (wZ == null) {
            wZ = gPb;
            AppMethodBeat.m2505o(86744);
            return wZ;
        }
        AppMethodBeat.m2505o(86744);
        return wZ;
    }

    /* renamed from: xb */
    public static C38450n m65049xb(String str) {
        AppMethodBeat.m2504i(86745);
        C38450n wY = C38450n.m65046wY(str);
        AppMethodBeat.m2505o(86745);
        return wY;
    }
}
