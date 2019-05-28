package com.tencent.mm.plugin.appbrand;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c.a;
import com.tencent.mm.plugin.appbrand.jsapi.c.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.e;
import com.tencent.mm.plugin.appbrand.permission.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bp;

public class c implements b {
    private final i gMH;
    private final e gMI;
    final com.tencent.mm.plugin.appbrand.jsapi.c gMJ;

    public c(i iVar, com.tencent.mm.plugin.appbrand.jsapi.c cVar, e eVar) {
        this.gMH = iVar;
        this.gMJ = cVar;
        this.gMI = eVar;
    }

    public void D(int i, String str) {
    }

    public boolean a(final m mVar, String str, int i, final a aVar) {
        AppMethodBeat.i(101710);
        e.a a = this.gMI.a(this.gMJ, (com.tencent.mm.plugin.appbrand.jsapi.b) mVar, str, new e.b() {
            public final void a(e.a aVar) {
                AppMethodBeat.i(101709);
                if (c.this.gMJ == null || !c.this.gMJ.isRunning()) {
                    AppMethodBeat.o(101709);
                } else if (aVar.ret == 0) {
                    aVar.proceed();
                    AppMethodBeat.o(101709);
                } else {
                    String str;
                    if (TextUtils.isEmpty(aVar.bzH)) {
                        str = "fail:internal error";
                    } else {
                        str = aVar.bzH;
                    }
                    aVar.AH(mVar.j(str, null));
                    AppMethodBeat.o(101709);
                }
            }
        });
        if (-2 == a.ret) {
            AppMethodBeat.o(101710);
            return true;
        } else if (a.ret != 0) {
            aVar.AH(mVar.j(a.bzH, null));
            AppMethodBeat.o(101710);
            return true;
        } else {
            AppMethodBeat.o(101710);
            return false;
        }
    }

    public void a(m mVar, String str, int i, String str2) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005e A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0029 A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0060 A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A:{Catch:{ NullPointerException -> 0x00f7 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(ah ahVar, a aVar) {
        AppMethodBeat.i(101711);
        com.tencent.mm.plugin.appbrand.b.c cVar = null;
        try {
            int i;
            com.tencent.mm.plugin.appbrand.b.c cVar2;
            int i2;
            if (this.gMH != null) {
                cVar = this.gMH.gNN;
                if (cVar != null) {
                    i = 1;
                    cVar2 = cVar;
                    if (!(i == 0 || cVar2.gWy.gWG.get())) {
                        if (this.gMJ.isRunning()) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        boolean z;
                        if (i2 == 0) {
                            ab.e("MicroMsg.AppBrandComponentInterceptor", "onDispatch, event[%s], appId[%s], runtimeStopped[%b], envStopped[%b]", ahVar.getName(), this.gMJ.getAppId(), Boolean.valueOf(z), Boolean.TRUE);
                            AppMethodBeat.o(101711);
                            return;
                        }
                        e eVar = this.gMI;
                        boolean z2 = cVar2.gWy.awz() == com.tencent.mm.plugin.appbrand.b.b.SUSPEND;
                        boolean a = eVar.a(this.gMJ, (com.tencent.mm.plugin.appbrand.jsapi.b) ahVar);
                        if (z2 || a) {
                            z = true;
                        } else {
                            z = false;
                        }
                        g gVar = (g) this.gMJ.B(g.class);
                        if (gVar == null || !gVar.a(ahVar)) {
                            i2 = 1;
                        } else {
                            i2 = 0;
                        }
                        if (i2 != 0) {
                            int a2 = eVar.a(this.gMJ, (com.tencent.mm.plugin.appbrand.jsapi.b) ahVar, null, false);
                            ab.i("MicroMsg.AppBrandComponentInterceptor", "dispatchToService, canSend %B, event %s, index %d, suspend %b, hasPermission %b", Boolean.valueOf(z), ahVar.getName(), Integer.valueOf(a2), Boolean.valueOf(z2), Boolean.valueOf(a));
                            if (i2 != 0 && bp.dpJ()) {
                                ab.d("MicroMsg.AppBrandComponentInterceptor", "dispatchToAutoTest, event %s, data %s, ", ahVar.getName(), ahVar.getData());
                            }
                        }
                        if (z) {
                            aVar.proceed();
                        }
                    }
                    AppMethodBeat.o(101711);
                    return;
                }
            }
            i = 0;
            cVar2 = cVar;
            if (this.gMJ.isRunning()) {
            }
            if (i2 == 0) {
            }
        } catch (NullPointerException e) {
            ab.printErrStackTrace("MicroMsg.AppBrandComponentInterceptor", e, "onDispatchImpl %s", ahVar.getName());
            AppMethodBeat.o(101711);
        }
    }
}
