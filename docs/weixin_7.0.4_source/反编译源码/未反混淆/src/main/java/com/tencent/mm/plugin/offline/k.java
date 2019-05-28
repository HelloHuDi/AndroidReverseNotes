package com.tencent.mm.plugin.offline;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.e;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.g.a.hm;
import com.tencent.mm.g.a.ut;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.bz.a;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.offline.a.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.v;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.vending.b.b;
import java.util.HashMap;
import java.util.Map;

public class k implements at {
    private static Map<String, String> eGu = new HashMap();
    private static HashMap<Integer, d> eaA = new HashMap();
    public static boolean oXK = false;
    public static int oXL = 10;
    private b gRC;
    private a kBx = new a() {
        public final void a(final e.a aVar) {
            AppMethodBeat.i(43357);
            final String a = aa.a(aVar.eAB.vED);
            ab.d("MicroMsg.SubCoreOffline", "OfflinePayMsg:".concat(String.valueOf(a)));
            k.this.mHandler.post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(43356);
                    s bXh = k.bXh();
                    String str = a;
                    long j = aVar.eAB.ptF;
                    ab.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is :".concat(String.valueOf(j)));
                    ab.i("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg content is :".concat(String.valueOf(str)));
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
                            ab.e("MicroMsg.WalletOfflineMsgManager", "mMsgIdList is null or size == 0");
                        }
                        obj = null;
                        if (obj != null) {
                            ab.e("MicroMsg.WalletOfflineMsgManager", "onReceiveMsg msg id is exist in list:".concat(String.valueOf(j)));
                            AppMethodBeat.o(43356);
                            return;
                        }
                        String str2 = null;
                        Map z = br.z(str, "sysmsg");
                        if (z != null) {
                            String str3 = (String) z.get(".sysmsg.paymsg.ack_key");
                            i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                            str2 = str3;
                        } else {
                            i = -1;
                        }
                        if (com.tencent.mm.plugin.offline.c.a.bYE()) {
                            ab.i("MicroMsg.WalletOfflineMsgManager", "pos is enabled. PayMsgType is %d", Integer.valueOf(i));
                            if (i == 7 || i == 10) {
                                bXh.TW(str);
                                bXh.TX(str);
                            } else if (g.fy(str2, str)) {
                                ab.i("MicroMsg.WalletOfflineMsgManager", "process msg from push");
                                h.pYm.a(135, 70, 1, true);
                                bXh.TW(str);
                                bXh.TX(str);
                            }
                        } else {
                            g.fy(str2, str);
                            bXh.TW(str);
                            bXh.TX(str);
                        }
                        if (bXh.oVR.size() > 10) {
                            bXh.oVR.remove(bXh.oVR.size() - 1);
                        }
                        bXh.oVR.add(0, Long.valueOf(j));
                    }
                    AppMethodBeat.o(43356);
                }
            });
            AppMethodBeat.o(43357);
        }
    };
    private ak mHandler = new ak(Looper.getMainLooper());
    private s oXE = null;
    private e oXF = null;
    private i oXG = null;
    private com.tencent.mm.plugin.offline.b.a oXH = null;
    private com.tencent.mm.plugin.offline.ui.d oXI = new com.tencent.mm.plugin.offline.ui.d();
    public f oXJ = new f();
    private c<ut> oXM = new c<ut>() {
        {
            AppMethodBeat.i(43353);
            this.xxI = ut.class.getName().hashCode();
            AppMethodBeat.o(43353);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43354);
            ut utVar = (ut) bVar;
            if (!bo.isNullOrNil(utVar.cRA.cRB)) {
                com.tencent.mm.plugin.offline.c.a.Ue(utVar.cRA.cRB);
            }
            AppMethodBeat.o(43354);
            return false;
        }
    };
    private m oXN;
    private c<hm> oXO = new c<hm>() {
        {
            AppMethodBeat.i(43358);
            this.xxI = hm.class.getName().hashCode();
            AppMethodBeat.o(43358);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43359);
            ab.i("MicroMsg.SubCoreOffline", "receive disaster update token");
            k.bXj().eO(0, 0);
            AppMethodBeat.o(43359);
            return false;
        }
    };
    private c<com.tencent.mm.g.a.ak> oXP = new c<com.tencent.mm.g.a.ak>() {
        {
            AppMethodBeat.i(43360);
            this.xxI = com.tencent.mm.g.a.ak.class.getName().hashCode();
            AppMethodBeat.o(43360);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(43361);
            ab.d("MicroMsg.SubCoreOffline", "receive broadcase event: %s", Integer.valueOf(((com.tencent.mm.g.a.ak) bVar).cto.type));
            if (((com.tencent.mm.g.a.ak) bVar).cto.type == 4) {
                ab.i("MicroMsg.SubCoreOffline", "receive old disaster event");
                k.bXj().eO(0, 0);
            }
            AppMethodBeat.o(43361);
            return false;
        }
    };

    public k() {
        AppMethodBeat.i(43362);
        AppMethodBeat.o(43362);
    }

    static {
        AppMethodBeat.i(43372);
        com.tencent.mm.wallet_core.a.g("OfflineBindCardRegProcess", d.class);
        com.tencent.mm.wallet_core.a.g("OfflineBindCardProcess", c.class);
        eaA.put(Integer.valueOf("OFFLINE_ORDER_STATUS".hashCode()), new d() {
            public final String[] Af() {
                return com.tencent.mm.plugin.offline.b.a.fnj;
            }
        });
        AppMethodBeat.o(43372);
    }

    public static k bXg() {
        AppMethodBeat.i(43363);
        k kVar = (k) q.Y(k.class);
        AppMethodBeat.o(43363);
        return kVar;
    }

    public final HashMap<Integer, d> Jx() {
        return eaA;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(43364);
        this.gRC = ((com.tencent.mm.plugin.auth.a.b) g.M(com.tencent.mm.plugin.auth.a.b.class)).addHandleAuthResponse(new com.tencent.mm.plugin.auth.a.a() {
            public final void a(f fVar, j.g gVar, boolean z) {
                AppMethodBeat.i(43355);
                ab.i("MicroMsg.SubCoreOffline", "autoAuth: %s", Boolean.valueOf(z));
                if (!z) {
                    k.bXj().eO(7, 7);
                }
                AppMethodBeat.o(43355);
            }

            public final void a(v.b bVar, String str, int i, String str2, String str3, int i2) {
            }
        });
        ((p) g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.kBx, true);
        com.tencent.mm.sdk.b.a.xxA.c(this.oXI);
        com.tencent.mm.sdk.b.a.xxA.c(this.oXM);
        this.oXO.dnU();
        this.oXP.dnU();
        this.oXE = null;
        this.oXF = null;
        this.oXG = null;
        this.oXN = new m();
        AppMethodBeat.o(43364);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(43365);
        ((p) g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.kBx, true);
        com.tencent.mm.sdk.b.a.xxA.d(this.oXI);
        com.tencent.mm.sdk.b.a.xxA.d(this.oXM);
        this.oXO.dead();
        this.oXP.dead();
        if (this.oXN != null) {
            s.a aVar = this.oXN;
            bXg();
            bXh().b(aVar);
            com.tencent.mm.sdk.b.a.xxA.d(aVar.nZv);
        }
        this.oXN = null;
        this.gRC.dead();
        AppMethodBeat.o(43365);
    }

    public static s bXh() {
        AppMethodBeat.i(43366);
        g.RN().QU();
        if (bXg().oXE == null) {
            bXg().oXE = new s();
        }
        s sVar = bXg().oXE;
        AppMethodBeat.o(43366);
        return sVar;
    }

    public static e bXi() {
        AppMethodBeat.i(43367);
        g.RN().QU();
        if (bXg().oXF == null) {
            bXg().oXF = new e();
        }
        e eVar = bXg().oXF;
        AppMethodBeat.o(43367);
        return eVar;
    }

    public static i bXj() {
        AppMethodBeat.i(43368);
        g.RN().QU();
        if (bXg().oXG == null) {
            bXg().oXG = new i();
        }
        i iVar = bXg().oXG;
        AppMethodBeat.o(43368);
        return iVar;
    }

    public static void aT(int i, String str) {
        AppMethodBeat.i(43369);
        if (str != null) {
            g.RQ();
            g.RP().Ry().set(i, (Object) str);
            g.RQ();
            g.RP().Ry().dsb();
        }
        AppMethodBeat.o(43369);
    }

    public static String Ax(int i) {
        AppMethodBeat.i(43370);
        g.RQ();
        String str = (String) g.RP().Ry().get(i, null);
        AppMethodBeat.o(43370);
        return str;
    }

    public static com.tencent.mm.plugin.offline.b.a bXk() {
        AppMethodBeat.i(43371);
        if (g.RK()) {
            if (bXg().oXH == null) {
                k bXg = bXg();
                g.RQ();
                bXg.oXH = new com.tencent.mm.plugin.offline.b.a(g.RP().eJN);
            }
            com.tencent.mm.plugin.offline.b.a aVar = bXg().oXH;
            AppMethodBeat.o(43371);
            return aVar;
        }
        com.tencent.mm.model.b bVar = new com.tencent.mm.model.b();
        AppMethodBeat.o(43371);
        throw bVar;
    }
}
