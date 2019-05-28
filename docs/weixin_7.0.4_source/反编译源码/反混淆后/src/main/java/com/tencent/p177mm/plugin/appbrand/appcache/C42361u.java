package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42367l;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.u */
public final class C42361u implements Closeable {
    private final WxaPkgWrappingInfo gTr;
    private final Map<String, C45512ao> gTs = new HashMap();

    C42361u(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.m2504i(86796);
        this.gTr = wxaPkgWrappingInfo;
        this.gTr.awr();
        AppMethodBeat.m2505o(86796);
    }

    /* Access modifiers changed, original: final */
    public final C45512ao findAppropriateModuleInfo(String str) {
        AppMethodBeat.m2504i(86797);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(86797);
            return null;
        }
        String str2;
        String yk = C42367l.m74946yk(str);
        Iterator it = this.gTr.gVx.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
            if (yk.startsWith(modulePkgInfo.name)) {
                str2 = modulePkgInfo.name;
                break;
            }
        }
        str2 = null;
        if (C5046bo.isNullOrNil(str2)) {
            str2 = "__APP__";
        }
        C45512ao xr = m74918xr(str2);
        AppMethodBeat.m2505o(86797);
        return xr;
    }

    /* Access modifiers changed, original: final */
    public final void avK() {
        AppMethodBeat.m2504i(86798);
        synchronized (this.gTs) {
            try {
                m74918xr("__APP__");
                Iterator it = this.gTr.gVx.iterator();
                while (it.hasNext()) {
                    m74918xr(((ModulePkgInfo) it.next()).name);
                }
            } finally {
                AppMethodBeat.m2505o(86798);
            }
        }
    }

    /* renamed from: xr */
    private C45512ao m74918xr(String str) {
        C45512ao c45512ao;
        AppMethodBeat.m2504i(86799);
        synchronized (this.gTs) {
            try {
                c45512ao = (C45512ao) this.gTs.get(str);
                if (c45512ao != null) {
                } else {
                    String str2;
                    if ("__APP__".equals(str)) {
                        str2 = this.gTr.gSP;
                    } else {
                        Iterator it = this.gTr.gVx.iterator();
                        while (it.hasNext()) {
                            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
                            if (str.equals(modulePkgInfo.name)) {
                                str2 = modulePkgInfo.gSP;
                                break;
                            }
                        }
                        str2 = null;
                    }
                    if (C5046bo.isNullOrNil(str2)) {
                    } else {
                        c45512ao = new C45512ao(str2);
                        this.gTs.put(str, c45512ao);
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.m2505o(86799);
            }
        }
        if (c45512ao != null) {
            c45512ao.avW();
        }
        AppMethodBeat.m2505o(86799);
        return c45512ao;
    }

    public final void close() {
        AppMethodBeat.m2504i(86800);
        synchronized (this.gTs) {
            try {
                Collection<C45512ao> values = this.gTs.values();
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(86800);
            }
        }
        for (C45512ao close : values) {
            close.close();
        }
    }
}
