package com.tencent.mm.plugin.appbrand.permission;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.report.model.j;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;

public final class a extends c {
    private final o iwd;
    private final h iwe;
    private final com.tencent.mm.plugin.appbrand.jsapi.o.a iwf = new com.tencent.mm.plugin.appbrand.jsapi.o.a();

    public a(o oVar, h hVar) {
        super(oVar, hVar, oVar.xY());
        AppMethodBeat.i(132501);
        this.iwd = oVar;
        this.iwe = hVar;
        AppMethodBeat.o(132501);
    }

    public final boolean a(m mVar, String str, int i, com.tencent.mm.plugin.appbrand.jsapi.c.a aVar) {
        String str2;
        AppMethodBeat.i(132502);
        com.tencent.mm.plugin.appbrand.jsapi.o.a aVar2 = this.iwf;
        h hVar = this.iwe;
        r atJ = this.iwd.atJ();
        if (atJ == null || atJ.getCurrentPage() == null) {
            str2 = "";
        } else {
            str2 = atJ.getCurrentPage().getCurrentUrl();
        }
        if (!j.DD(mVar.getName())) {
            com.tencent.mm.plugin.appbrand.jsapi.o.c cVar = new com.tencent.mm.plugin.appbrand.jsapi.o.c(hVar, mVar, str, bo.yz(), str2);
            synchronized (aVar2.hVp) {
                try {
                    aVar2.hVp.put(i, cVar);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(132502);
                    }
                }
            }
        }
        boolean a = super.a(mVar, str, i, aVar);
        AppMethodBeat.o(132502);
        return a;
    }

    public final void D(int i, String str) {
        AppMethodBeat.i(132503);
        super.D(i, str);
        this.iwf.W(i, str);
        AppMethodBeat.o(132503);
    }

    public final void a(m mVar, String str, int i, String str2) {
        AppMethodBeat.i(132504);
        super.a(mVar, str, i, str2);
        if (!TextUtils.isEmpty(str2)) {
            if ((f.IS_FLAVOR_RED || d.vxs || d.vxr) && "fail:internal error invalid js component".equals(str2)) {
                ClassCastException classCastException = new ClassCastException(String.format("Mismatch api(%s) component", new Object[]{mVar.getName()}));
                AppMethodBeat.o(132504);
                throw classCastException;
            }
            this.iwf.W(i, str2);
        }
        AppMethodBeat.o(132504);
    }
}
