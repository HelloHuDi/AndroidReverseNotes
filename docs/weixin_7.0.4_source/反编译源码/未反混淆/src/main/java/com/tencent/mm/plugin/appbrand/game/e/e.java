package com.tencent.mm.plugin.appbrand.game.e;

import com.tencent.luggage.sdk.a.a.b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.r.g;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.report.service.h;
import java.util.Map;

public final class e extends aq<s> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private boolean hso = false;

    public final /* synthetic */ Map a(b bVar) {
        AppMethodBeat.i(130198);
        Map c = c((s) bVar);
        AppMethodBeat.o(130198);
        return c;
    }

    public final /* synthetic */ Map d(c cVar) {
        AppMethodBeat.i(130199);
        Map c = c((s) cVar);
        AppMethodBeat.o(130199);
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private Map<String, Object> c(s sVar) {
        int pZ;
        int pZ2;
        int i;
        int i2;
        h hVar;
        Object[] objArr;
        int i3 = 1;
        AppMethodBeat.i(130197);
        Map a = super.a(sVar);
        if (sVar.getRuntime() != null && sVar.getRuntime().xy()) {
            MBRuntime mBRuntime = ((com.tencent.mm.plugin.appbrand.game.b) sVar).getMBRuntime();
            int systemDisplayWidth = mBRuntime.getSystemDisplayWidth();
            int systemDisplayHeight = mBRuntime.getSystemDisplayHeight();
            a.put("screenWidth", Integer.valueOf(systemDisplayWidth));
            a.put("screenHeight", Integer.valueOf(systemDisplayHeight));
            if (!(sVar == null || this.hso)) {
                this.hso = true;
                try {
                    com.tencent.mm.plugin.appbrand.widget.c cVar = sVar.getRuntime().gNE;
                    if (cVar.isLaidOut()) {
                        try {
                            pZ = g.pZ(cVar.getMeasuredWidth());
                            try {
                                pZ2 = g.pZ(cVar.getMeasuredHeight());
                                i = 1;
                            } catch (Exception e) {
                                i = 1;
                                i2 = i;
                                pZ2 = 0;
                                if (pZ == systemDisplayWidth) {
                                }
                                hVar = h.pYm;
                                objArr = new Object[6];
                                if (i == 0) {
                                }
                                objArr[0] = Integer.valueOf(i);
                                objArr[1] = Integer.valueOf(systemDisplayWidth);
                                objArr[2] = Integer.valueOf(systemDisplayHeight);
                                if (i2 == 0) {
                                }
                                objArr[3] = Integer.valueOf(i3);
                                objArr[4] = Integer.valueOf(pZ);
                                objArr[5] = Integer.valueOf(pZ2);
                                hVar.e(16892, objArr);
                                AppMethodBeat.o(130197);
                                return a;
                            }
                        } catch (Exception e2) {
                            i = 1;
                            pZ = 0;
                        }
                    } else {
                        i = 0;
                        pZ2 = 0;
                        pZ = 0;
                    }
                    i2 = i;
                } catch (Exception e3) {
                    i = 0;
                    pZ = 0;
                }
                i = (pZ == systemDisplayWidth || pZ2 != systemDisplayHeight) ? 0 : 1;
                hVar = h.pYm;
                objArr = new Object[6];
                if (i == 0) {
                    i = 1;
                } else {
                    i = -1;
                }
                objArr[0] = Integer.valueOf(i);
                objArr[1] = Integer.valueOf(systemDisplayWidth);
                objArr[2] = Integer.valueOf(systemDisplayHeight);
                if (i2 == 0) {
                    i3 = -1;
                }
                objArr[3] = Integer.valueOf(i3);
                objArr[4] = Integer.valueOf(pZ);
                objArr[5] = Integer.valueOf(pZ2);
                hVar.e(16892, objArr);
            }
        }
        AppMethodBeat.o(130197);
        return a;
    }
}
