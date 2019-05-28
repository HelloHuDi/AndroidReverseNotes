package com.tencent.p177mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C1819b;
import com.tencent.p177mm.model.C6673bz.C1837a;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.p230g.p231a.C6488hm;
import com.tencent.p177mm.p230g.p231a.C6553ut;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.auth.p1239a.C19933a;
import com.tencent.p177mm.plugin.auth.p1239a.C19934b;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6983p;
import com.tencent.p177mm.plugin.offline.p1006c.C28630a;
import com.tencent.p177mm.plugin.offline.p1496b.C34644a;
import com.tencent.p177mm.plugin.offline.p478a.C21405s;
import com.tencent.p177mm.plugin.offline.p478a.C21405s.C3562a;
import com.tencent.p177mm.plugin.offline.p479ui.C7014d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.C4824j.C4825f;
import com.tencent.p177mm.protocal.C4824j.C4826g;
import com.tencent.p177mm.protocal.C4842v.C4844b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.vending.p636b.C7358b;
import com.tencent.p177mm.wallet_core.C24143a;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.offline.k */
public class C7007k implements C1816at {
    private static Map<String, String> eGu = new HashMap();
    private static HashMap<Integer, C1366d> eaA = new HashMap();
    public static boolean oXK = false;
    public static int oXL = 10;
    private C7358b gRC;
    private C1837a kBx = new C70104();
    private C7306ak mHandler = new C7306ak(Looper.getMainLooper());
    private C21405s oXE = null;
    private C12741e oXF = null;
    private C39473i oXG = null;
    private C34644a oXH = null;
    private C7014d oXI = new C7014d();
    public C28636f oXJ = new C28636f();
    private C4884c<C6553ut> oXM = new C70051();
    private C28638m oXN;
    private C4884c<C6488hm> oXO = new C70095();
    private C4884c<C6459ak> oXP = new C70126();

    /* renamed from: com.tencent.mm.plugin.offline.k$1 */
    class C70051 extends C4884c<C6553ut> {
        C70051() {
            AppMethodBeat.m2504i(43353);
            this.xxI = C6553ut.class.getName().hashCode();
            AppMethodBeat.m2505o(43353);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43354);
            C6553ut c6553ut = (C6553ut) c4883b;
            if (!C5046bo.isNullOrNil(c6553ut.cRA.cRB)) {
                C28630a.m45497Ue(c6553ut.cRA.cRB);
            }
            AppMethodBeat.m2505o(43354);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.k$2 */
    static class C70062 implements C1366d {
        C70062() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C34644a.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.k$3 */
    class C70083 implements C19933a {
        C70083() {
        }

        /* renamed from: a */
        public final void mo5415a(C4825f c4825f, C4826g c4826g, boolean z) {
            AppMethodBeat.m2504i(43355);
            C4990ab.m7417i("MicroMsg.SubCoreOffline", "autoAuth: %s", Boolean.valueOf(z));
            if (!z) {
                C7007k.bXj().mo62419eO(7, 7);
            }
            AppMethodBeat.m2505o(43355);
        }

        /* renamed from: a */
        public final void mo5416a(C4844b c4844b, String str, int i, String str2, String str3, int i2) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.k$5 */
    class C70095 extends C4884c<C6488hm> {
        C70095() {
            AppMethodBeat.m2504i(43358);
            this.xxI = C6488hm.class.getName().hashCode();
            AppMethodBeat.m2505o(43358);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43359);
            C4990ab.m7416i("MicroMsg.SubCoreOffline", "receive disaster update token");
            C7007k.bXj().mo62419eO(0, 0);
            AppMethodBeat.m2505o(43359);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.k$4 */
    class C70104 implements C1837a {
        C70104() {
        }

        /* renamed from: a */
        public final void mo5414a(final C1197a c1197a) {
            AppMethodBeat.m2504i(43357);
            final String a = C1946aa.m4148a(c1197a.eAB.vED);
            C4990ab.m7410d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(a)));
            C7007k.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(43356);
                    C21405s bXh = C7007k.bXh();
                    String str = a;
                    long j = c1197a.eAB.ptF;
                    C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(j)));
                    C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str)));
                    if (!TextUtils.isEmpty(str)) {
                        int i;
                        Object obj;
                        if (bXh.oVR != null && bXh.oVR.size() != 0) {
                            int i2 = 0;
                            while (true) {
                                i = i2;
                                if (i >= bXh.oVR.size()) {
                                    break;
                                } else if (((Long) bXh.oVR.get(i)).longValue() == j) {
                                    obj = 1;
                                    break;
                                } else {
                                    i2 = i + 1;
                                }
                            }
                        } else {
                            C4990ab.m7412e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
                        }
                        obj = null;
                        if (obj != null) {
                            C4990ab.m7412e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(j)));
                            AppMethodBeat.m2505o(43356);
                            return;
                        }
                        String str2 = null;
                        Map z = C5049br.m7595z(str, "sysmsg");
                        if (z != null) {
                            String str3 = (String) z.get(".sysmsg.paymsg.ack_key");
                            i = C5046bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                            str2 = str3;
                        } else {
                            i = -1;
                        }
                        if (C28630a.bYE()) {
                            C4990ab.m7417i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", Integer.valueOf(i));
                            if (i == 7 || i == 10) {
                                bXh.mo36864TW(str);
                                bXh.mo36865TX(str);
                            } else if (C34645g.m56849fy(str2, str)) {
                                C4990ab.m7416i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                                C7060h.pYm.mo8378a(135, 70, 1, true);
                                bXh.mo36864TW(str);
                                bXh.mo36865TX(str);
                            }
                        } else {
                            C34645g.m56849fy(str2, str);
                            bXh.mo36864TW(str);
                            bXh.mo36865TX(str);
                        }
                        if (bXh.oVR.size() > 10) {
                            bXh.oVR.remove(bXh.oVR.size() - 1);
                        }
                        bXh.oVR.add(0, Long.valueOf(j));
                    }
                    AppMethodBeat.m2505o(43356);
                }
            });
            AppMethodBeat.m2505o(43357);
        }
    }

    /* renamed from: com.tencent.mm.plugin.offline.k$6 */
    class C70126 extends C4884c<C6459ak> {
        C70126() {
            AppMethodBeat.m2504i(43360);
            this.xxI = C6459ak.class.getName().hashCode();
            AppMethodBeat.m2505o(43360);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(43361);
            C4990ab.m7411d("MicroMsg.SubCoreOffline", "receive broadcase event: %s", Integer.valueOf(((C6459ak) c4883b).cto.type));
            if (((C6459ak) c4883b).cto.type == 4) {
                C4990ab.m7416i("MicroMsg.SubCoreOffline", "receive old disaster event");
                C7007k.bXj().mo62419eO(0, 0);
            }
            AppMethodBeat.m2505o(43361);
            return false;
        }
    }

    public C7007k() {
        AppMethodBeat.m2504i(43362);
        AppMethodBeat.m2505o(43362);
    }

    static {
        AppMethodBeat.m2504i(43372);
        C24143a.m37115g("OfflineBindCardRegProcess", C31377d.class);
        C24143a.m37115g("OfflineBindCardProcess", C12739c.class);
        eaA.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new C70062());
        AppMethodBeat.m2505o(43372);
    }

    public static C7007k bXg() {
        AppMethodBeat.m2504i(43363);
        C7007k c7007k = (C7007k) C7485q.m12925Y(C7007k.class);
        AppMethodBeat.m2505o(43363);
        return c7007k;
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
        AppMethodBeat.m2504i(43364);
        this.gRC = ((C19934b) C1720g.m3530M(C19934b.class)).addHandleAuthResponse(new C70083());
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14900a("paymsg", this.kBx, true);
        C4879a.xxA.mo10052c(this.oXI);
        C4879a.xxA.mo10052c(this.oXM);
        this.oXO.dnU();
        this.oXP.dnU();
        this.oXE = null;
        this.oXF = null;
        this.oXG = null;
        this.oXN = new C28638m();
        AppMethodBeat.m2505o(43364);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(43365);
        ((C6983p) C1720g.m3530M(C6983p.class)).getSysCmdMsgExtension().mo14903b("paymsg", this.kBx, true);
        C4879a.xxA.mo10053d(this.oXI);
        C4879a.xxA.mo10053d(this.oXM);
        this.oXO.dead();
        this.oXP.dead();
        if (this.oXN != null) {
            C3562a c3562a = this.oXN;
            C7007k.bXg();
            C7007k.bXh().mo36867b(c3562a);
            C4879a.xxA.mo10053d(c3562a.nZv);
        }
        this.oXN = null;
        this.gRC.dead();
        AppMethodBeat.m2505o(43365);
    }

    public static C21405s bXh() {
        AppMethodBeat.m2504i(43366);
        C1720g.m3534RN().mo5159QU();
        if (C7007k.bXg().oXE == null) {
            C7007k.bXg().oXE = new C21405s();
        }
        C21405s c21405s = C7007k.bXg().oXE;
        AppMethodBeat.m2505o(43366);
        return c21405s;
    }

    public static C12741e bXi() {
        AppMethodBeat.m2504i(43367);
        C1720g.m3534RN().mo5159QU();
        if (C7007k.bXg().oXF == null) {
            C7007k.bXg().oXF = new C12741e();
        }
        C12741e c12741e = C7007k.bXg().oXF;
        AppMethodBeat.m2505o(43367);
        return c12741e;
    }

    public static C39473i bXj() {
        AppMethodBeat.m2504i(43368);
        C1720g.m3534RN().mo5159QU();
        if (C7007k.bXg().oXG == null) {
            C7007k.bXg().oXG = new C39473i();
        }
        C39473i c39473i = C7007k.bXg().oXG;
        AppMethodBeat.m2505o(43368);
        return c39473i;
    }

    /* renamed from: aT */
    public static void m11711aT(int i, String str) {
        AppMethodBeat.m2504i(43369);
        if (str != null) {
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().set(i, (Object) str);
            C1720g.m3537RQ();
            C1720g.m3536RP().mo5239Ry().dsb();
        }
        AppMethodBeat.m2505o(43369);
    }

    /* renamed from: Ax */
    public static String m11709Ax(int i) {
        AppMethodBeat.m2504i(43370);
        C1720g.m3537RQ();
        String str = (String) C1720g.m3536RP().mo5239Ry().get(i, null);
        AppMethodBeat.m2505o(43370);
        return str;
    }

    public static C34644a bXk() {
        AppMethodBeat.m2504i(43371);
        if (C1720g.m3531RK()) {
            if (C7007k.bXg().oXH == null) {
                C7007k bXg = C7007k.bXg();
                C1720g.m3537RQ();
                bXg.oXH = new C34644a(C1720g.m3536RP().eJN);
            }
            C34644a c34644a = C7007k.bXg().oXH;
            AppMethodBeat.m2505o(43371);
            return c34644a;
        }
        C1819b c1819b = new C1819b();
        AppMethodBeat.m2505o(43371);
        throw c1819b;
    }
}
