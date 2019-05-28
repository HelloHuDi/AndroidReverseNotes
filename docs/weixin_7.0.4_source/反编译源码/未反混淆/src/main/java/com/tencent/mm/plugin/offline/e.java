package com.tencent.mm.plugin.offline;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.offline.a.o;
import com.tencent.mm.plugin.offline.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.wallet_core.c.b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

public final class e extends a<b> {
    public String oWS = "";
    private a oWT = new a() {
        public final void bXa() {
            AppMethodBeat.i(43303);
            e.this.aVU();
            AppMethodBeat.o(43303);
        }
    };

    public final void aVU() {
        AppMethodBeat.i(43304);
        if (this.oWP == null) {
            AppMethodBeat.o(43304);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oWP.size()) {
                WeakReference weakReference = (WeakReference) this.oWP.get(i2);
                if (weakReference != null) {
                    b bVar = (b) weakReference.get();
                    if (bVar != null) {
                        bVar.bap();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43304);
                return;
            }
        }
    }

    public e() {
        AppMethodBeat.i(43305);
        k.bXg();
        if (k.bXj() != null) {
            k.bXg();
            k.bXj().oXw = this.oWT;
        }
        AppMethodBeat.o(43305);
    }

    private static void bWX() {
        AppMethodBeat.i(43306);
        k.bXg();
        k.bXj().eP(1, 1);
        AppMethodBeat.o(43306);
    }

    private static void bWY() {
        AppMethodBeat.i(43307);
        k.bXg();
        k.bXj().Av(2);
        AppMethodBeat.o(43307);
    }

    private static void c(int i, int i2, int i3, String str) {
        AppMethodBeat.i(43308);
        m oVar = new o(i, i2, i3, str);
        g.RQ();
        g.RO().eJo.a(oVar, 0);
        AppMethodBeat.o(43308);
    }

    public final String q(int i, int i2, String str) {
        AppMethodBeat.i(43309);
        ab.i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", Integer.valueOf(i), Integer.valueOf(i2), bo.dpG().toString());
        String r = r(i, i2, str);
        AppMethodBeat.o(43309);
        return r;
    }

    public final String r(int i, int i2, String str) {
        int i3 = 0;
        AppMethodBeat.i(43310);
        int bWZ = bWZ();
        String str2;
        if (bWZ > 0) {
            if (bWZ < k.oXL) {
                ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", Integer.valueOf(k.oXL));
                bWY();
            }
            k.bXg();
            String Ax = k.Ax(196617);
            if (TextUtils.isEmpty(Ax)) {
                ab.e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(Ax)));
                str2 = "";
                AppMethodBeat.o(43310);
                return str2;
            }
            b.dNJ();
            Ax = b.getToken(Ax);
            if (TextUtils.isEmpty(Ax)) {
                bWX();
                ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                str2 = "";
                AppMethodBeat.o(43310);
                return str2;
            }
            if (Ax != null) {
                ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", Integer.valueOf(Ax.length()), str, Ax);
            }
            c(bWZ - 1, i, i2, str);
            ab.i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (bWZ - 1));
            LinkedList Ug = com.tencent.mm.plugin.offline.c.a.Ug(com.tencent.mm.plugin.offline.c.a.bYs());
            if (Ug == null || Ug.size() == 0) {
                ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                bWX();
                str2 = "";
                AppMethodBeat.o(43310);
                return str2;
            } else if (Ax == null || !com.tencent.mm.plugin.offline.c.a.isNumeric(Ax)) {
                ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                str2 = "";
                AppMethodBeat.o(43310);
                return str2;
            } else {
                long longValue = Long.valueOf(Ax, 10).longValue();
                long j = 0;
                int i4 = 0;
                while (i4 < Ug.size()) {
                    long j2;
                    com.tencent.mm.plugin.offline.c.a.a aVar = (com.tencent.mm.plugin.offline.c.a.a) Ug.get(i4);
                    if (aVar == null || aVar.pbo == null || !aVar.pbo.equals(this.oWS)) {
                        j2 = j;
                    } else {
                        j2 = (long) aVar.pbm;
                    }
                    i4++;
                    j = j2;
                }
                str2 = String.valueOf((j << 48) | longValue);
                if (str2.length() == 15) {
                    str2 = AppEventsConstants.EVENT_PARAM_VALUE_NO.concat(String.valueOf(str2));
                } else if (str2.length() == 14) {
                    str2 = "00".concat(String.valueOf(str2));
                } else if (str2.length() == 13) {
                    str2 = "000".concat(String.valueOf(str2));
                } else if (str2.length() == 12) {
                    str2 = "0000".concat(String.valueOf(str2));
                }
                if (TextUtils.isEmpty(com.tencent.mm.plugin.offline.c.a.bYu())) {
                    str2 = "12".concat(String.valueOf(str2));
                } else {
                    str2 = com.tencent.mm.plugin.offline.c.a.bYu() + str2;
                }
                AppMethodBeat.o(43310);
                return str2;
            }
        }
        h hVar = h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(com.tencent.mm.plugin.offline.c.a.eA(ah.getContext()) ? 0 : 1);
        if (at.isNetworkConnected(ah.getContext())) {
            i3 = 1;
        }
        objArr[2] = Integer.valueOf(i3);
        hVar.e(14163, objArr);
        h.pYm.a(135, 29, 1, true);
        if (at.isNetworkConnected(ah.getContext())) {
            h.pYm.a(135, 31, 1, true);
        } else {
            h.pYm.a(135, 30, 1, true);
        }
        bWX();
        ab.i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        str2 = "";
        AppMethodBeat.o(43310);
        return str2;
    }

    public static int bWZ() {
        AppMethodBeat.i(43311);
        k.bXg();
        k.bXj();
        int bXf = i.bXf();
        AppMethodBeat.o(43311);
        return bXf;
    }
}
