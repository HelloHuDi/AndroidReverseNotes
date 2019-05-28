package com.tencent.mm.pluginsdk.model;

import android.os.Bundle;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;

public final class s {
    private static volatile s vbB = null;

    public static class a {
        public int vbC;
        public int vbD;
        public String vbE;
        public int vbF;
        public String vbG;
    }

    private s() {
    }

    public static s dhn() {
        AppMethodBeat.i(125829);
        if (vbB == null) {
            synchronized (s.class) {
                try {
                    if (vbB == null) {
                        vbB = new s();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(125829);
                    }
                }
            }
        }
        s sVar = vbB;
        AppMethodBeat.o(125829);
        return sVar;
    }

    public static r y(int i, Bundle bundle) {
        AppMethodBeat.i(125830);
        r wVar;
        switch (i) {
            case 1:
                wVar = new w();
                AppMethodBeat.o(125830);
                return wVar;
            case 2:
                wVar = new a(bundle);
                AppMethodBeat.o(125830);
                return wVar;
            default:
                o oVar = new o();
                AppMethodBeat.o(125830);
                return oVar;
        }
    }

    public static int Kq(int i) {
        AppMethodBeat.i(125831);
        switch (i) {
            case 0:
                int i2 = bo.getInt(g.Nv().O("QQBroswer", "RecommendCount"), 5);
                AppMethodBeat.o(125831);
                return i2;
            case 1:
                AppMethodBeat.o(125831);
                return BaseClientBuilder.API_PRIORITY_OTHER;
            default:
                AppMethodBeat.o(125831);
                return 5;
        }
    }

    public static void Kr(int i) {
        AppMethodBeat.i(125832);
        switch (i) {
            case 0:
                h.pYm.e(10998, Integer.valueOf(0));
                AppMethodBeat.o(125832);
                return;
            case 1:
                h.pYm.e(11091, Integer.valueOf(0));
                break;
        }
        AppMethodBeat.o(125832);
    }

    public static void Ks(int i) {
        AppMethodBeat.i(125833);
        switch (i) {
            case 0:
                h.pYm.e(10998, Integer.valueOf(1));
                AppMethodBeat.o(125833);
                return;
            case 1:
                h.pYm.e(11091, Integer.valueOf(1));
                break;
        }
        AppMethodBeat.o(125833);
    }

    public static void Kt(int i) {
        AppMethodBeat.i(125834);
        switch (i) {
            case 0:
                h.pYm.e(10998, Integer.valueOf(3));
                AppMethodBeat.o(125834);
                return;
            case 1:
                h.pYm.e(11091, Integer.valueOf(3));
                break;
        }
        AppMethodBeat.o(125834);
    }

    public static void Ku(int i) {
        AppMethodBeat.i(125835);
        switch (i) {
            case 0:
                h.pYm.e(10998, Integer.valueOf(2));
                AppMethodBeat.o(125835);
                return;
            case 1:
                h.pYm.e(11091, Integer.valueOf(2));
                break;
        }
        AppMethodBeat.o(125835);
    }
}
