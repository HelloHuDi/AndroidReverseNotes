package com.tencent.p177mm.plugin.appbrand.game.p295e;

import com.tencent.luggage.sdk.p819a.p820a.C45126b;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.game.C42439b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45572aq;
import com.tencent.p177mm.plugin.appbrand.p328r.C42668g;
import com.tencent.p177mm.plugin.appbrand.widget.C45713c;
import com.tencent.p177mm.plugin.report.service.C7060h;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.appbrand.game.e.e */
public final class C42446e extends C45572aq<C19722s> {
    public static final int CTRL_INDEX = 40;
    public static final String NAME = "getSystemInfo";
    private boolean hso = false;

    /* renamed from: a */
    public final /* synthetic */ Map mo67966a(C45126b c45126b) {
        AppMethodBeat.m2504i(130198);
        Map c = m75174c((C19722s) c45126b);
        AppMethodBeat.m2505o(130198);
        return c;
    }

    /* renamed from: d */
    public final /* synthetic */ Map mo61033d(C2241c c2241c) {
        AppMethodBeat.m2504i(130199);
        Map c = m75174c((C19722s) c2241c);
        AppMethodBeat.m2505o(130199);
        return c;
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0074  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: c */
    private Map<String, Object> m75174c(C19722s c19722s) {
        int pZ;
        int pZ2;
        int i;
        int i2;
        C7060h c7060h;
        Object[] objArr;
        int i3 = 1;
        AppMethodBeat.m2504i(130197);
        Map a = super.mo67966a(c19722s);
        if (c19722s.getRuntime() != null && c19722s.getRuntime().mo65903xy()) {
            MBRuntime mBRuntime = ((C42439b) c19722s).getMBRuntime();
            int systemDisplayWidth = mBRuntime.getSystemDisplayWidth();
            int systemDisplayHeight = mBRuntime.getSystemDisplayHeight();
            a.put("screenWidth", Integer.valueOf(systemDisplayWidth));
            a.put("screenHeight", Integer.valueOf(systemDisplayHeight));
            if (!(c19722s == null || this.hso)) {
                this.hso = true;
                try {
                    C45713c c45713c = c19722s.getRuntime().gNE;
                    if (c45713c.isLaidOut()) {
                        try {
                            pZ = C42668g.m75569pZ(c45713c.getMeasuredWidth());
                            try {
                                pZ2 = C42668g.m75569pZ(c45713c.getMeasuredHeight());
                                i = 1;
                            } catch (Exception e) {
                                i = 1;
                                i2 = i;
                                pZ2 = 0;
                                if (pZ == systemDisplayWidth) {
                                }
                                c7060h = C7060h.pYm;
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
                                c7060h.mo8381e(16892, objArr);
                                AppMethodBeat.m2505o(130197);
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
                c7060h = C7060h.pYm;
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
                c7060h.mo8381e(16892, objArr);
            }
        }
        AppMethodBeat.m2505o(130197);
        return a;
    }
}
