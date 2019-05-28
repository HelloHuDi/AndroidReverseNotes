package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.l;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.Closeable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class u implements Closeable {
    private final WxaPkgWrappingInfo gTr;
    private final Map<String, ao> gTs = new HashMap();

    u(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        AppMethodBeat.i(86796);
        this.gTr = wxaPkgWrappingInfo;
        this.gTr.awr();
        AppMethodBeat.o(86796);
    }

    /* Access modifiers changed, original: final */
    public final ao findAppropriateModuleInfo(String str) {
        AppMethodBeat.i(86797);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(86797);
            return null;
        }
        String str2;
        String yk = l.yk(str);
        Iterator it = this.gTr.gVx.iterator();
        while (it.hasNext()) {
            ModulePkgInfo modulePkgInfo = (ModulePkgInfo) it.next();
            if (yk.startsWith(modulePkgInfo.name)) {
                str2 = modulePkgInfo.name;
                break;
            }
        }
        str2 = null;
        if (bo.isNullOrNil(str2)) {
            str2 = "__APP__";
        }
        ao xr = xr(str2);
        AppMethodBeat.o(86797);
        return xr;
    }

    /* Access modifiers changed, original: final */
    public final void avK() {
        AppMethodBeat.i(86798);
        synchronized (this.gTs) {
            try {
                xr("__APP__");
                Iterator it = this.gTr.gVx.iterator();
                while (it.hasNext()) {
                    xr(((ModulePkgInfo) it.next()).name);
                }
            } finally {
                AppMethodBeat.o(86798);
            }
        }
    }

    private ao xr(String str) {
        ao aoVar;
        AppMethodBeat.i(86799);
        synchronized (this.gTs) {
            try {
                aoVar = (ao) this.gTs.get(str);
                if (aoVar != null) {
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
                    if (bo.isNullOrNil(str2)) {
                    } else {
                        aoVar = new ao(str2);
                        this.gTs.put(str, aoVar);
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(86799);
            }
        }
        if (aoVar != null) {
            aoVar.avW();
        }
        AppMethodBeat.o(86799);
        return aoVar;
    }

    public final void close() {
        AppMethodBeat.i(86800);
        synchronized (this.gTs) {
            try {
                Collection<ao> values = this.gTs.values();
            } finally {
                while (true) {
                }
                AppMethodBeat.o(86800);
            }
        }
        for (ao close : values) {
            close.close();
        }
    }
}
