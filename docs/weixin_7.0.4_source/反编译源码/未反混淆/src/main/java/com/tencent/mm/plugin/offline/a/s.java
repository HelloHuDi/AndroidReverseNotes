package com.tencent.mm.plugin.offline.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.us;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.r;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public final class s {
    private List<WeakReference<a>> kaD = new ArrayList();
    public ArrayList<Long> oVR = new ArrayList();
    public b oYL = null;
    private HashSet<String> oYM = new HashSet();

    public interface a {
        boolean a(c cVar);
    }

    public class c {
        public int oYS;
    }

    public class b extends c {
        public String oYP;
        public String oYQ;
        public String oYR;

        public b() {
            super();
        }
    }

    public class h {
        public String cRb;
        public String cRc;
        public String cRd;
        public String cRe;
        public String cRf;
        public boolean oZd;

        public h(Map<String, String> map) {
            AppMethodBeat.i(43422);
            this.cRb = (String) map.get(".sysmsg.paymsg.guide_flag");
            this.cRc = (String) map.get(".sysmsg.paymsg.guide_wording");
            this.cRd = (String) map.get(".sysmsg.paymsg.left_button_wording");
            this.cRe = (String) map.get(".sysmsg.paymsg.right_button_wording");
            this.cRf = (String) map.get(".sysmsg.paymsg.upload_credit_url");
            this.oZd = "1".equals(map.get(".sysmsg.paymsg.guide_block"));
            AppMethodBeat.o(43422);
        }
    }

    public class d extends c {
        public String cBT;

        public d() {
            super();
        }
    }

    public class e extends c {
        public String oYT;
        public String oYU;
        public String oYV;
        public String oYW;
        public String oYX;
        public boolean oYY = true;

        public e() {
            super();
        }
    }

    public class g extends c {
        public String cBT;
        public String id;
        public int kKC;
        public String oZb;
        public String oZc;

        public g() {
            super();
        }
    }

    public class f extends c {
        public h cRz;
        public String oYZ;
        public Orders oZa;

        public f() {
            super();
        }
    }

    public s() {
        AppMethodBeat.i(43423);
        String bYn = com.tencent.mm.plugin.offline.c.a.bYn();
        if (!TextUtils.isEmpty(bYn)) {
            Map z = br.z(bYn, "sysmsg");
            if (z != null) {
                int i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
                if (i >= 0 && i == 4) {
                    ab.i("MicroMsg.WalletOfflineMsgManager", "msg type is 4 ");
                    b(O(z));
                }
            }
        }
        this.oVR.clear();
        AppMethodBeat.o(43423);
    }

    private void b(c cVar) {
        AppMethodBeat.i(43424);
        if (this.kaD == null) {
            AppMethodBeat.o(43424);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.kaD.size()) {
                break;
            }
            WeakReference weakReference = (WeakReference) this.kaD.get(i2);
            if (weakReference != null) {
                a aVar = (a) weakReference.get();
                if (aVar != null && aVar.a(cVar)) {
                    break;
                }
            }
            i = i2 + 1;
        }
        AppMethodBeat.o(43424);
    }

    public final void a(a aVar) {
        AppMethodBeat.i(43425);
        if (this.kaD == null) {
            this.kaD = new ArrayList();
        }
        this.kaD.add(new WeakReference(aVar));
        AppMethodBeat.o(43425);
    }

    public final void b(a aVar) {
        AppMethodBeat.i(43426);
        if (this.kaD == null) {
            AppMethodBeat.o(43426);
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.kaD.size()) {
                WeakReference weakReference = (WeakReference) this.kaD.get(i2);
                if (weakReference != null) {
                    a aVar2 = (a) weakReference.get();
                    if (aVar2 != null && aVar2.equals(aVar)) {
                        this.kaD.remove(weakReference);
                        AppMethodBeat.o(43426);
                        return;
                    }
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(43426);
                return;
            }
        }
    }

    public final void TW(String str) {
        AppMethodBeat.i(43427);
        com.tencent.mm.plugin.offline.c.a.Um("");
        com.tencent.mm.plugin.offline.c.a.Uo("");
        com.tencent.mm.plugin.offline.c.a.Un("");
        Map z = br.z(str, "sysmsg");
        if (z == null) {
            AppMethodBeat.o(43427);
            return;
        }
        int i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
        int i2 = bo.getInt((String) z.get(".sysmsg.paymsg.pay_cmd"), -1);
        String str2 = (String) z.get(".sysmsg.paymsg.req_key");
        com.tencent.mm.plugin.offline.c.a.Um((String) z.get(".sysmsg.paymsg.ack_key"));
        com.tencent.mm.plugin.offline.c.a.AE(i);
        com.tencent.mm.plugin.offline.c.a.Un(str2);
        int i3 = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), -1);
        ab.i("MicroMsg.WalletOfflineMsgManager", "msg type is ".concat(String.valueOf(i3)));
        ab.v("MicroMsg.WalletOfflineMsgManager", "msg type is type %d xml %s", Integer.valueOf(i3), str);
        if (i3 >= 0 && i3 == 4) {
            b(O(z));
            com.tencent.mm.plugin.offline.c.a.Ud(str);
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 5) {
            boolean z2;
            if (i2 == 1) {
                ab.i("MicroMsg.WalletOfflineMsgManager", "payCmd is PAY_CMD_OFFLINE_PAY_REFRESH_TOKEN (value is 1), refresh offline token");
                k.bXg();
                k.bXj().eO(4, 4);
                z2 = false;
            } else {
                z2 = true;
            }
            c P = P(z);
            P.oYY = z2;
            b(P);
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 6) {
            str2 = (String) z.get(".sysmsg.paymsg.transid");
            ab.i("helios", "MSG_TYPE_ORDER trasid=".concat(String.valueOf(str2)));
            if (!bo.isNullOrNil(str2)) {
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE2_DIALOG_BOOLEAN_SYNC, Boolean.TRUE);
            }
            ab.i("MicroMsg.WalletOfflineMsgManager", "orders xml: %s", str);
            b(Q(z));
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 7) {
            r.cPI().Km();
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 8) {
            b(S(z));
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 10) {
            k.bXg();
            k.bXj().eO(4, 4);
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 20) {
            us usVar = new us();
            usVar.cRy.cRz = new h(z);
            com.tencent.mm.sdk.b.a.xxA.m(usVar);
            AppMethodBeat.o(43427);
        } else if (i3 >= 0 && i3 == 23) {
            c R = R(z);
            synchronized (this.oYM) {
                try {
                    if (this.oYM.contains(R.cBT)) {
                        ab.i("MicroMsg.WalletOfflineMsgManager", "pass this msg %s", R.cBT);
                    } else {
                        this.oYM.add(R.cBT);
                        b(R);
                        AppMethodBeat.o(43427);
                    }
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(43427);
                }
            }
        } else if (i3 < 0 || i3 != 24) {
            AppMethodBeat.o(43427);
        } else {
            b(N(z));
            AppMethodBeat.o(43427);
        }
    }

    private d N(Map<String, String> map) {
        AppMethodBeat.i(43428);
        d dVar = new d();
        dVar.oYS = bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        dVar.cBT = (String) map.get(".sysmsg.paymsg.req_key");
        AppMethodBeat.o(43428);
        return dVar;
    }

    private b O(Map<String, String> map) {
        AppMethodBeat.i(43429);
        if (this.oYL == null) {
            this.oYL = new b();
        }
        this.oYL.oYS = bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        this.oYL.oYP = (String) map.get(".sysmsg.paymsg.isfreeze");
        this.oYL.oYQ = (String) map.get(".sysmsg.paymsg.freezetype");
        this.oYL.oYR = (String) map.get(".sysmsg.paymsg.freezemsg");
        b bVar = this.oYL;
        AppMethodBeat.o(43429);
        return bVar;
    }

    private e P(Map<String, String> map) {
        AppMethodBeat.i(43430);
        e eVar = new e();
        eVar.oYS = bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        eVar.oYT = (String) map.get(".sysmsg.paymsg.cftretcode");
        eVar.oYU = (String) map.get(".sysmsg.paymsg.cftretmsg");
        eVar.oYV = (String) map.get(".sysmsg.paymsg.wxretcode");
        eVar.oYW = (String) map.get(".sysmsg.paymsg.wxretmsg");
        eVar.oYX = (String) map.get(".sysmsg.paymsg.error_detail_url");
        eVar.oYY = true;
        AppMethodBeat.o(43430);
        return eVar;
    }

    private f Q(Map<String, String> map) {
        AppMethodBeat.i(43431);
        f fVar = new f();
        fVar.oYS = bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        fVar.oYZ = (String) map.get(".sysmsg.paymsg.transid");
        fVar.oZa = com.tencent.mm.plugin.offline.c.a.T(map);
        if (fVar.oZa.tAq.size() > 0) {
            com.tencent.mm.plugin.offline.c.a.Uo(((Commodity) fVar.oZa.tAq.get(0)).cAa);
        }
        if (map.containsKey(".sysmsg.paymsg.real_name_info")) {
            fVar.cRz = new h(map);
        }
        AppMethodBeat.o(43431);
        return fVar;
    }

    private d R(Map<String, String> map) {
        AppMethodBeat.i(43432);
        d dVar = new d();
        dVar.oYS = bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        dVar.cBT = (String) map.get(".sysmsg.paymsg.req_key");
        AppMethodBeat.o(43432);
        return dVar;
    }

    private g S(Map<String, String> map) {
        AppMethodBeat.i(43433);
        g gVar = new g();
        gVar.oYS = bo.getInt((String) map.get(".sysmsg.paymsg.PayMsgType"), -1);
        gVar.oZb = (String) map.get(".sysmsg.paymsg.good_name");
        gVar.oZc = (String) map.get(".sysmsg.paymsg.total_fee");
        gVar.cBT = (String) map.get(".sysmsg.paymsg.req_key");
        gVar.id = (String) map.get(".sysmsg.paymsg.id");
        String str = (String) map.get(".sysmsg.paymsg.confirm_type");
        ab.i("MicroMsg.WalletOfflineMsgManager", "msg confirm_type is" + gVar.kKC);
        if (TextUtils.isEmpty(str) || !str.equals("1")) {
            gVar.kKC = 0;
        } else {
            gVar.kKC = 1;
        }
        AppMethodBeat.o(43433);
        return gVar;
    }

    public final void TX(String str) {
        AppMethodBeat.i(43434);
        int i = bo.getInt((String) br.z(str, "sysmsg").get(".sysmsg.paymsg.PayMsgType"), -1);
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oXe));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oXd));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oXf));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oXc));
        hashSet.add(Integer.valueOf(com.tencent.mm.plugin.offline.g.oWZ));
        if (hashSet.contains(Integer.valueOf(i))) {
            com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                final /* synthetic */ boolean oYN = false;

                public final void run() {
                    AppMethodBeat.i(43421);
                    ab.v("MicroMsg.WalletOfflineMsgManager", "DO NetSceneOfflineAckMsg");
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RO().eJo.a(new b(this.oYN), 0);
                    AppMethodBeat.o(43421);
                }
            });
        }
        AppMethodBeat.o(43434);
    }
}
