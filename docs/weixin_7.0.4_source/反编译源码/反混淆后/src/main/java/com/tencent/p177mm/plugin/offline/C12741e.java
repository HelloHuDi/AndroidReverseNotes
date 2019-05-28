package com.tencent.p177mm.plugin.offline;

import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.plugin.offline.C39473i.C21413a;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a.C28635a;
import com.tencent.p177mm.plugin.offline.p478a.C43354o;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.wallet_core.p649c.C40928b;
import java.lang.ref.WeakReference;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.offline.e */
public final class C12741e extends C39471a<C46119b> {
    public String oWS = "";
    private C21413a oWT = new C127421();

    /* renamed from: com.tencent.mm.plugin.offline.e$1 */
    class C127421 implements C21413a {
        C127421() {
        }

        public final void bXa() {
            AppMethodBeat.m2504i(43303);
            C12741e.this.aVU();
            AppMethodBeat.m2505o(43303);
        }
    }

    public final void aVU() {
        AppMethodBeat.m2504i(43304);
        if (this.oWP == null) {
            AppMethodBeat.m2505o(43304);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.oWP.size()) {
                WeakReference weakReference = (WeakReference) this.oWP.get(i2);
                if (weakReference != null) {
                    C46119b c46119b = (C46119b) weakReference.get();
                    if (c46119b != null) {
                        c46119b.bap();
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43304);
                return;
            }
        }
    }

    public C12741e() {
        AppMethodBeat.m2504i(43305);
        C7007k.bXg();
        if (C7007k.bXj() != null) {
            C7007k.bXg();
            C7007k.bXj().oXw = this.oWT;
        }
        AppMethodBeat.m2505o(43305);
    }

    private static void bWX() {
        AppMethodBeat.m2504i(43306);
        C7007k.bXg();
        C7007k.bXj().mo62420eP(1, 1);
        AppMethodBeat.m2505o(43306);
    }

    private static void bWY() {
        AppMethodBeat.m2504i(43307);
        C7007k.bXg();
        C7007k.bXj().mo62418Av(2);
        AppMethodBeat.m2505o(43307);
    }

    /* renamed from: c */
    private static void m20763c(int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(43308);
        C1207m c43354o = new C43354o(i, i2, i3, str);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c43354o, 0);
        AppMethodBeat.m2505o(43308);
    }

    /* renamed from: q */
    public final String mo24747q(int i, int i2, String str) {
        AppMethodBeat.m2504i(43309);
        C4990ab.m7417i("MicroMsg.OfflineCodesMgr", "generatetKey scene %s isSnapshot %s stack: %s", Integer.valueOf(i), Integer.valueOf(i2), C5046bo.dpG().toString());
        String r = mo24748r(i, i2, str);
        AppMethodBeat.m2505o(43309);
        return r;
    }

    /* renamed from: r */
    public final String mo24748r(int i, int i2, String str) {
        int i3 = 0;
        AppMethodBeat.m2504i(43310);
        int bWZ = C12741e.bWZ();
        String str2;
        if (bWZ > 0) {
            if (bWZ < C7007k.oXL) {
                C4990ab.m7417i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount < %s", Integer.valueOf(C7007k.oXL));
                C12741e.bWY();
            }
            C7007k.bXg();
            String Ax = C7007k.m11709Ax(196617);
            if (TextUtils.isEmpty(Ax)) {
                C4990ab.m7412e("MicroMsg.OfflineCodesMgr", "generateKey_V3 cn is null, the csr is not exist! cn:".concat(String.valueOf(Ax)));
                str2 = "";
                AppMethodBeat.m2505o(43310);
                return str2;
            }
            C40928b.dNJ();
            Ax = C40928b.getToken(Ax);
            if (TextUtils.isEmpty(Ax)) {
                C12741e.bWX();
                C4990ab.m7416i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null");
                str2 = "";
                AppMethodBeat.m2505o(43310);
                return str2;
            }
            if (Ax != null) {
                C4990ab.m7417i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code length : %s ext_business_attach %s %s", Integer.valueOf(Ax.length()), str, Ax);
            }
            C12741e.m20763c(bWZ - 1, i, i2, str);
            C4990ab.m7416i("MicroMsg.OfflineCodesMgr", "doNetSceneShowCode count " + (bWZ - 1));
            LinkedList Ug = C28630a.m45499Ug(C28630a.bYs());
            if (Ug == null || Ug.size() == 0) {
                C4990ab.m7416i("MicroMsg.OfflineCodesMgr", "generateKey_V3 cardList is null");
                C12741e.bWX();
                str2 = "";
                AppMethodBeat.m2505o(43310);
                return str2;
            } else if (Ax == null || !C28630a.isNumeric(Ax)) {
                C4990ab.m7416i("MicroMsg.OfflineCodesMgr", "generateKey_V3 code is null or is not isNumeric");
                str2 = "";
                AppMethodBeat.m2505o(43310);
                return str2;
            } else {
                long longValue = Long.valueOf(Ax, 10).longValue();
                long j = 0;
                int i4 = 0;
                while (i4 < Ug.size()) {
                    long j2;
                    C28635a c28635a = (C28635a) Ug.get(i4);
                    if (c28635a == null || c28635a.pbo == null || !c28635a.pbo.equals(this.oWS)) {
                        j2 = j;
                    } else {
                        j2 = (long) c28635a.pbm;
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
                if (TextUtils.isEmpty(C28630a.bYu())) {
                    str2 = "12".concat(String.valueOf(str2));
                } else {
                    str2 = C28630a.bYu() + str2;
                }
                AppMethodBeat.m2505o(43310);
                return str2;
            }
        }
        C7060h c7060h = C7060h.pYm;
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = Integer.valueOf(C28630a.m45520eA(C4996ah.getContext()) ? 0 : 1);
        if (C5023at.isNetworkConnected(C4996ah.getContext())) {
            i3 = 1;
        }
        objArr[2] = Integer.valueOf(i3);
        c7060h.mo8381e(14163, objArr);
        C7060h.pYm.mo8378a(135, 29, 1, true);
        if (C5023at.isNetworkConnected(C4996ah.getContext())) {
            C7060h.pYm.mo8378a(135, 31, 1, true);
        } else {
            C7060h.pYm.mo8378a(135, 30, 1, true);
        }
        C12741e.bWX();
        C4990ab.m7416i("MicroMsg.OfflineCodesMgr", "generateKey_V3 getTokenCount is 0");
        str2 = "";
        AppMethodBeat.m2505o(43310);
        return str2;
    }

    public static int bWZ() {
        AppMethodBeat.m2504i(43311);
        C7007k.bXg();
        C7007k.bXj();
        int bXf = C39473i.bXf();
        AppMethodBeat.m2505o(43311);
        return bXf;
    }
}
