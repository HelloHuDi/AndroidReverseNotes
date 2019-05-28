package com.tencent.p177mm.plugin.appbrand;

import android.support.p057v4.app.C6184a.C0315a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.p336ui.C19789k;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19691d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.a */
public final class C10048a {
    private static final Map<String, C41243o> gMD = new HashMap();
    private static Map<String, C0315a> gME = new HashMap();
    private static Map<String, C19789k> gMF = new HashMap();

    static {
        AppMethodBeat.m2504i(128924);
        AppMethodBeat.m2505o(128924);
    }

    public static void asC() {
        AppMethodBeat.m2504i(128918);
        LinkedList<C41243o> linkedList = new LinkedList();
        synchronized (gMD) {
            try {
                for (C41243o c41243o : gMD.values()) {
                    if (c41243o != null && c41243o.mo65903xy()) {
                        linkedList.add(c41243o);
                    }
                }
            } finally {
                AppMethodBeat.m2505o(128918);
            }
        }
        for (C41243o c41243o2 : linkedList) {
            c41243o2.atP();
        }
    }

    /* renamed from: wI */
    public static C41243o m17635wI(String str) {
        AppMethodBeat.m2504i(128921);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(128921);
            return null;
        }
        C41243o c41243o;
        synchronized (gMD) {
            try {
                c41243o = (C41243o) gMD.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(128921);
            }
        }
        return c41243o;
    }

    @Deprecated
    /* renamed from: wJ */
    public static AppBrandSysConfigWC m17636wJ(String str) {
        AppMethodBeat.m2504i(128922);
        C41243o wI = C10048a.m17635wI(str);
        if (wI == null) {
            AppMethodBeat.m2505o(128922);
            return null;
        }
        AppBrandSysConfigWC atH = wI.atH();
        AppMethodBeat.m2505o(128922);
        return atH;
    }

    @Deprecated
    /* renamed from: wK */
    public static AppBrandStatObject m17637wK(String str) {
        AppMethodBeat.m2504i(128923);
        C41243o wI = C10048a.m17635wI(str);
        if (wI == null) {
            AppMethodBeat.m2505o(128923);
            return null;
        }
        AppBrandStatObject appBrandStatObject = wI.mo43491ya().bQn;
        AppMethodBeat.m2505o(128923);
        return appBrandStatObject;
    }

    /* renamed from: a */
    static void m17633a(C41243o c41243o) {
        AppMethodBeat.m2504i(128919);
        if (C5046bo.isNullOrNil(c41243o.mAppId)) {
            C4990ab.m7412e("MicroMsg.AppBrandBridge", "clearRuntime with nil appId");
            AppMethodBeat.m2505o(128919);
            return;
        }
        synchronized (gMD) {
            try {
                C41243o c41243o2 = (C41243o) gMD.get(c41243o.mAppId);
                if (c41243o2 == null || c41243o2 == c41243o) {
                    gMD.put(c41243o.mAppId, null);
                } else {
                    C4990ab.m7413e("MicroMsg.AppBrandBridge", "clearRuntime with mismatch instance, stack %s", C5046bo.m7574l(new Throwable()));
                }
            } finally {
                AppMethodBeat.m2505o(128919);
            }
        }
    }

    /* renamed from: b */
    static void m17634b(C41243o c41243o) {
        AppMethodBeat.m2504i(128920);
        if (C5046bo.isNullOrNil(c41243o.mAppId)) {
            C4990ab.m7412e("MicroMsg.AppBrandBridge", "setRuntime with nil appId");
            AppMethodBeat.m2505o(128920);
            return;
        }
        synchronized (gMD) {
            try {
                gMD.put(c41243o.mAppId, c41243o);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(128920);
                }
            }
        }
        if (c41243o.atI() != null) {
            C19691d.m30511bs(c41243o.mAppId, c41243o.atI().bQe);
        }
        AppMethodBeat.m2505o(128920);
    }
}
