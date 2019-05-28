package com.tencent.p177mm.plugin.order.p1007a;

import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.order.model.C34664c;
import com.tencent.p177mm.plugin.order.model.C39481b;
import com.tencent.p177mm.plugin.order.model.C43365j;
import com.tencent.p177mm.plugin.order.p1008c.C12785c;
import com.tencent.p177mm.plugin.order.p767b.C34658a;
import com.tencent.p177mm.plugin.order.p767b.C7607b;
import com.tencent.p177mm.plugin.p1614i.C43217c;
import com.tencent.p177mm.protocal.protobuf.bjn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.wallet_core.C24143a;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.order.a.b */
public class C34657b implements C1816at {
    private static HashMap<Integer, C1366d> eaA;
    private C1837a kBx = new C286563();
    private List<WeakReference<Object>> kaD = new ArrayList();
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    C39481b pbB = null;
    private C7607b pbC;
    private C34664c pbD = null;
    private C1837a pbE = new C127812();

    /* renamed from: com.tencent.mm.plugin.order.a.b$2 */
    class C127812 implements C1837a {
        C127812() {
        }

        /* renamed from: a */
        public final void mo5414a(C1197a c1197a) {
            AppMethodBeat.m2504i(43728);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7416i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(a)));
            C34657b.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(43727);
                    C34657b c34657b = C34657b.this;
                    C1720g.m3534RN().mo5159QU();
                    if (c34657b.pbB == null) {
                        c34657b.pbB = new C39481b();
                    }
                    C39481b c39481b = c34657b.pbB;
                    String str = a;
                    if (!C5046bo.isNullOrNil(str)) {
                        Map z = C5049br.m7595z(str, "sysmsg");
                        if (z == null) {
                            AppMethodBeat.m2505o(43727);
                            return;
                        }
                        try {
                            str = (String) z.get(".sysmsg.wxpay.transid");
                            if (!C5046bo.isNullOrNil(str)) {
                                C4990ab.m7410d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(str)));
                                if (!c39481b.pbV.contains(str)) {
                                    c39481b.pbV.add(str);
                                    C1720g.m3537RQ();
                                    C1720g.m3536RP().mo5239Ry().set(204817, Integer.valueOf(c39481b.pbV.size()));
                                    C4990ab.m7410d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + c39481b.pbV.size());
                                    c39481b.bYV();
                                    C34657b.bYR().aVU();
                                }
                            }
                            AppMethodBeat.m2505o(43727);
                            return;
                        } catch (Exception e) {
                            C4990ab.m7412e("MicroMsg.WalletOrdersManager", "cmdid error");
                        }
                    }
                    AppMethodBeat.m2505o(43727);
                }
            });
            AppMethodBeat.m2505o(43728);
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.a.b$1 */
    static class C286541 implements C1366d {
        C286541() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7607b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.a.b$3 */
    class C286563 implements C1837a {
        C286563() {
        }

        /* renamed from: a */
        public final void mo5414a(final C1197a c1197a) {
            AppMethodBeat.m2504i(43730);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7416i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(a)));
            C34657b.this.mHandler.post(new Runnable() {
                /* JADX WARNING: Missing block: B:32:0x00a4, code skipped:
            if (r4 != 1) goto L_0x014c;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    AppMethodBeat.m2504i(43729);
                    C34664c bYU = C34657b.bYU();
                    String str = a;
                    String str2 = c1197a.eAB.ptD;
                    if (!TextUtils.isEmpty(str)) {
                        C43365j Ut = C34664c.m56903Ut(str);
                        if (Ut == null) {
                            C4990ab.m7416i("MicroMsg.MallPayMsgManager", "payMsg == null");
                            AppMethodBeat.m2505o(43729);
                            return;
                        } else if (!(TextUtils.isEmpty(Ut.pde) && TextUtils.isEmpty(Ut.pdv) && TextUtils.isEmpty(Ut.pdu) && TextUtils.isEmpty(Ut.cJh) && TextUtils.isEmpty(Ut.pdq) && TextUtils.isEmpty(Ut.pdr) && TextUtils.isEmpty(Ut.pdp) && TextUtils.isEmpty(Ut.pdt) && TextUtils.isEmpty(Ut.pds) && TextUtils.isEmpty(Ut.pdo))) {
                            if (Ut.pdo != null && C12785c.isNumeric(Ut.pdo)) {
                                int intValue = Integer.valueOf(Ut.pdo).intValue();
                                if (intValue != 2) {
                                }
                            }
                            if (TextUtils.isEmpty(Ut.pdq)) {
                                Ut.cJb = str2;
                            } else {
                                Ut.cJb = str2 + Ut.pdq;
                            }
                            C4990ab.m7416i("MicroMsg.MallPayMsgManager", "msgid: " + Ut.cJb);
                            C4990ab.m7416i("MicroMsg.MallPayMsgManager", "msgType: " + Ut.pdo);
                            if (bYU.mo55268Uv(Ut.cJb)) {
                                C4990ab.m7412e("MicroMsg.MallPayMsgManager", "msg for id " + Ut.cJb + " is exist!!");
                                C34658a Ux = bYU.mo55270Ux(Ut.cJb);
                                bYU.mo55267Uu(Ut.cJb);
                                bYU.kbM.add(Ut);
                                bYU.mo55271a(Ut, str, Ux.field_isRead);
                            } else {
                                bYU.kbM.add(Ut);
                                bYU.mo55271a(Ut, str, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            bYU.bYY();
                            C34657b bYR = C34657b.bYR();
                            if (Ut != null) {
                                bjn bjn = new bjn();
                                if (TextUtils.isEmpty(Ut.pdq) || !C12785c.isNumeric(Ut.pdq)) {
                                    bjn.pcX = (int) (System.currentTimeMillis() / 1000);
                                    bjn.pcZ = (int) (System.currentTimeMillis() / 1000);
                                } else {
                                    bjn.pcX = Integer.valueOf(Ut.pdq).intValue();
                                    bjn.pcZ = Integer.valueOf(Ut.pdq).intValue();
                                }
                                bjn.pdc = 100000;
                                bjn.pde = Ut.pde;
                                bjn.pcU = Ut.cJb;
                                bjn.pcY = Ut.pds;
                                bjn.wMU = -1;
                                bjn.pdf = Ut.pdp;
                                bjn.pdg = Ut.pds;
                                bjn.pdh = Ut.cJh;
                            }
                            bYR.bYS();
                        }
                    }
                    AppMethodBeat.m2505o(43729);
                }
            });
            AppMethodBeat.m2505o(43730);
        }
    }

    public C34657b() {
        AppMethodBeat.m2504i(43731);
        AppMethodBeat.m2505o(43731);
    }

    static {
        AppMethodBeat.m2504i(43738);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new C286541());
        C24143a.m37115g("ShowOrdersInfoProcess", C34656a.class);
        AppMethodBeat.m2505o(43738);
    }

    public static C34657b bYR() {
        AppMethodBeat.m2504i(43732);
        C34657b c34657b = (C34657b) C7485q.m12925Y(C34657b.class);
        AppMethodBeat.m2505o(43732);
        return c34657b;
    }

    public final void bYS() {
        AppMethodBeat.m2504i(43733);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(43733);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    weakReference.get();
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43733);
                return;
            }
        }
    }

    public final void aVU() {
        AppMethodBeat.m2504i(43734);
        if (this.kaD == null) {
            AppMethodBeat.m2505o(43734);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    weakReference.get();
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(43734);
                return;
            }
        }
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return eaA;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        this.pbB = null;
        this.pbD = null;
    }

    public final void onAccountRelease() {
    }

    public static C7607b bYT() {
        AppMethodBeat.m2504i(43735);
        C1720g.m3534RN().mo5159QU();
        if (C34657b.bYR().pbC == null) {
            C34657b bYR = C34657b.bYR();
            C1720g.m3537RQ();
            bYR.pbC = new C7607b(C1720g.m3536RP().eJN);
        }
        C7607b c7607b = C34657b.bYR().pbC;
        AppMethodBeat.m2505o(43735);
        return c7607b;
    }

    public static C34664c bYU() {
        AppMethodBeat.m2504i(43736);
        C1720g.m3534RN().mo5159QU();
        if (C34657b.bYR().pbD == null) {
            C34657b.bYR().pbD = new C34664c();
        }
        C34664c c34664c = C34657b.bYR().pbD;
        AppMethodBeat.m2505o(43736);
        return c34664c;
    }

    public static String bKP() {
        AppMethodBeat.m2504i(43737);
        String str;
        if (C1720g.m3531RK()) {
            str = C43217c.m76863XW() + "order";
            AppMethodBeat.m2505o(43737);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(43737);
        return str;
    }
}
