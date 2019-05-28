package com.tencent.mm.plugin.order.a;

import android.os.Looper;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.order.model.c;
import com.tencent.mm.plugin.order.model.j;
import com.tencent.mm.protocal.protobuf.bjn;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b implements at {
    private static HashMap<Integer, d> eaA;
    private a kBx = new a() {
        public final void a(final e.a aVar) {
            AppMethodBeat.i(43730);
            final String a = aa.a(aVar.eAB.vED);
            ab.i("MicroMsg.SubCoreWalletOrder", "MallPayMsg:".concat(String.valueOf(a)));
            b.this.mHandler.post(new Runnable() {
                /* JADX WARNING: Missing block: B:32:0x00a4, code skipped:
            if (r4 != 1) goto L_0x014c;
     */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final void run() {
                    AppMethodBeat.i(43729);
                    c bYU = b.bYU();
                    String str = a;
                    String str2 = aVar.eAB.ptD;
                    if (!TextUtils.isEmpty(str)) {
                        j Ut = c.Ut(str);
                        if (Ut == null) {
                            ab.i("MicroMsg.MallPayMsgManager", "payMsg == null");
                            AppMethodBeat.o(43729);
                            return;
                        } else if (!(TextUtils.isEmpty(Ut.pde) && TextUtils.isEmpty(Ut.pdv) && TextUtils.isEmpty(Ut.pdu) && TextUtils.isEmpty(Ut.cJh) && TextUtils.isEmpty(Ut.pdq) && TextUtils.isEmpty(Ut.pdr) && TextUtils.isEmpty(Ut.pdp) && TextUtils.isEmpty(Ut.pdt) && TextUtils.isEmpty(Ut.pds) && TextUtils.isEmpty(Ut.pdo))) {
                            if (Ut.pdo != null && com.tencent.mm.plugin.order.c.c.isNumeric(Ut.pdo)) {
                                int intValue = Integer.valueOf(Ut.pdo).intValue();
                                if (intValue != 2) {
                                }
                            }
                            if (TextUtils.isEmpty(Ut.pdq)) {
                                Ut.cJb = str2;
                            } else {
                                Ut.cJb = str2 + Ut.pdq;
                            }
                            ab.i("MicroMsg.MallPayMsgManager", "msgid: " + Ut.cJb);
                            ab.i("MicroMsg.MallPayMsgManager", "msgType: " + Ut.pdo);
                            if (bYU.Uv(Ut.cJb)) {
                                ab.e("MicroMsg.MallPayMsgManager", "msg for id " + Ut.cJb + " is exist!!");
                                com.tencent.mm.plugin.order.b.a Ux = bYU.Ux(Ut.cJb);
                                bYU.Uu(Ut.cJb);
                                bYU.kbM.add(Ut);
                                bYU.a(Ut, str, Ux.field_isRead);
                            } else {
                                bYU.kbM.add(Ut);
                                bYU.a(Ut, str, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                            }
                            bYU.bYY();
                            b bYR = b.bYR();
                            if (Ut != null) {
                                bjn bjn = new bjn();
                                if (TextUtils.isEmpty(Ut.pdq) || !com.tencent.mm.plugin.order.c.c.isNumeric(Ut.pdq)) {
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
                    AppMethodBeat.o(43729);
                }
            });
            AppMethodBeat.o(43730);
        }
    };
    private List<WeakReference<Object>> kaD = new ArrayList();
    private ak mHandler = new ak(Looper.getMainLooper());
    com.tencent.mm.plugin.order.model.b pbB = null;
    private com.tencent.mm.plugin.order.b.b pbC;
    private c pbD = null;
    private a pbE = new a() {
        public final void a(e.a aVar) {
            AppMethodBeat.i(43728);
            final String a = aa.a(aVar.eAB.vED);
            ab.i("MicroMsg.SubCoreWalletOrder", "MallOrderNotifyConfXml:".concat(String.valueOf(a)));
            b.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43727);
                    b bVar = b.this;
                    g.RN().QU();
                    if (bVar.pbB == null) {
                        bVar.pbB = new com.tencent.mm.plugin.order.model.b();
                    }
                    com.tencent.mm.plugin.order.model.b bVar2 = bVar.pbB;
                    String str = a;
                    if (!bo.isNullOrNil(str)) {
                        Map z = br.z(str, "sysmsg");
                        if (z == null) {
                            AppMethodBeat.o(43727);
                            return;
                        }
                        try {
                            str = (String) z.get(".sysmsg.wxpay.transid");
                            if (!bo.isNullOrNil(str)) {
                                ab.d("MicroMsg.WalletOrdersManager", "transid ".concat(String.valueOf(str)));
                                if (!bVar2.pbV.contains(str)) {
                                    bVar2.pbV.add(str);
                                    g.RQ();
                                    g.RP().Ry().set(204817, Integer.valueOf(bVar2.pbV.size()));
                                    ab.d("MicroMsg.WalletOrdersManager", "notifyTrans.size() : " + bVar2.pbV.size());
                                    bVar2.bYV();
                                    b.bYR().aVU();
                                }
                            }
                            AppMethodBeat.o(43727);
                            return;
                        } catch (Exception e) {
                            ab.e("MicroMsg.WalletOrdersManager", "cmdid error");
                        }
                    }
                    AppMethodBeat.o(43727);
                }
            });
            AppMethodBeat.o(43728);
        }
    };

    public b() {
        AppMethodBeat.i(43731);
        AppMethodBeat.o(43731);
    }

    static {
        AppMethodBeat.i(43738);
        HashMap hashMap = new HashMap();
        eaA = hashMap;
        hashMap.put(Integer.valueOf("ORDERCOMMONMSGXML_TABLE".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.order.b.b.fnj;
            }
        });
        com.tencent.mm.wallet_core.a.g("ShowOrdersInfoProcess", a.class);
        AppMethodBeat.o(43738);
    }

    public static b bYR() {
        AppMethodBeat.i(43732);
        b bVar = (b) q.Y(b.class);
        AppMethodBeat.o(43732);
        return bVar;
    }

    public final void bYS() {
        AppMethodBeat.i(43733);
        if (this.kaD == null) {
            AppMethodBeat.o(43733);
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
                AppMethodBeat.o(43733);
                return;
            }
        }
    }

    public final void aVU() {
        AppMethodBeat.i(43734);
        if (this.kaD == null) {
            AppMethodBeat.o(43734);
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
                AppMethodBeat.o(43734);
                return;
            }
        }
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        this.pbB = null;
        this.pbD = null;
    }

    public final void onAccountRelease() {
    }

    public static com.tencent.mm.plugin.order.b.b bYT() {
        AppMethodBeat.i(43735);
        g.RN().QU();
        if (bYR().pbC == null) {
            b bYR = bYR();
            g.RQ();
            bYR.pbC = new com.tencent.mm.plugin.order.b.b(g.RP().eJN);
        }
        com.tencent.mm.plugin.order.b.b bVar = bYR().pbC;
        AppMethodBeat.o(43735);
        return bVar;
    }

    public static c bYU() {
        AppMethodBeat.i(43736);
        g.RN().QU();
        if (bYR().pbD == null) {
            bYR().pbD = new c();
        }
        c cVar = bYR().pbD;
        AppMethodBeat.o(43736);
        return cVar;
    }

    public static String bKP() {
        AppMethodBeat.i(43737);
        String str;
        if (g.RK()) {
            str = com.tencent.mm.plugin.i.c.XW() + "order";
            AppMethodBeat.o(43737);
            return str;
        }
        str = "";
        AppMethodBeat.o(43737);
        return str;
    }
}
