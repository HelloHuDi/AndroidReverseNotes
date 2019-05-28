package com.tencent.p177mm.pluginsdk.model;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.model.s */
public final class C14893s {
    private static volatile C14893s vbB = null;

    /* renamed from: com.tencent.mm.pluginsdk.model.s$a */
    public static class C14894a {
        public int vbC;
        public int vbD;
        public String vbE;
        public int vbF;
        public String vbG;
    }

    private C14893s() {
    }

    public static C14893s dhn() {
        AppMethodBeat.m2504i(125829);
        if (vbB == null) {
            synchronized (C14893s.class) {
                try {
                    if (vbB == null) {
                        vbB = new C14893s();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(125829);
                    }
                }
            }
        }
        C14893s c14893s = vbB;
        AppMethodBeat.m2505o(125829);
        return c14893s;
    }

    /* renamed from: y */
    public static C30081r m23163y(int i, Bundle bundle) {
        AppMethodBeat.m2504i(125830);
        C30081r c40446w;
        switch (i) {
            case 1:
                c40446w = new C40446w();
                AppMethodBeat.m2505o(125830);
                return c40446w;
            case 2:
                c40446w = new C14868a(bundle);
                AppMethodBeat.m2505o(125830);
                return c40446w;
            default:
                C44065o c44065o = new C44065o();
                AppMethodBeat.m2505o(125830);
                return c44065o;
        }
    }

    /* renamed from: Kq */
    public static int m23158Kq(int i) {
        AppMethodBeat.m2504i(125831);
        switch (i) {
            case 0:
                int i2 = C5046bo.getInt(C26373g.m41965Nv().mo5301O("QQBroswer", "RecommendCount"), 5);
                AppMethodBeat.m2505o(125831);
                return i2;
            case 1:
                AppMethodBeat.m2505o(125831);
                return BaseClientBuilder.API_PRIORITY_OTHER;
            default:
                AppMethodBeat.m2505o(125831);
                return 5;
        }
    }

    /* renamed from: Kr */
    public static void m23159Kr(int i) {
        AppMethodBeat.m2504i(125832);
        switch (i) {
            case 0:
                C7060h.pYm.mo8381e(10998, Integer.valueOf(0));
                AppMethodBeat.m2505o(125832);
                return;
            case 1:
                C7060h.pYm.mo8381e(11091, Integer.valueOf(0));
                break;
        }
        AppMethodBeat.m2505o(125832);
    }

    /* renamed from: Ks */
    public static void m23160Ks(int i) {
        AppMethodBeat.m2504i(125833);
        switch (i) {
            case 0:
                C7060h.pYm.mo8381e(10998, Integer.valueOf(1));
                AppMethodBeat.m2505o(125833);
                return;
            case 1:
                C7060h.pYm.mo8381e(11091, Integer.valueOf(1));
                break;
        }
        AppMethodBeat.m2505o(125833);
    }

    /* renamed from: Kt */
    public static void m23161Kt(int i) {
        AppMethodBeat.m2504i(125834);
        switch (i) {
            case 0:
                C7060h.pYm.mo8381e(10998, Integer.valueOf(3));
                AppMethodBeat.m2505o(125834);
                return;
            case 1:
                C7060h.pYm.mo8381e(11091, Integer.valueOf(3));
                break;
        }
        AppMethodBeat.m2505o(125834);
    }

    /* renamed from: Ku */
    public static void m23162Ku(int i) {
        AppMethodBeat.m2504i(125835);
        switch (i) {
            case 0:
                C7060h.pYm.mo8381e(10998, Integer.valueOf(2));
                AppMethodBeat.m2505o(125835);
                return;
            case 1:
                C7060h.pYm.mo8381e(11091, Integer.valueOf(2));
                break;
        }
        AppMethodBeat.m2505o(125835);
    }
}
