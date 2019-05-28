package com.tencent.mm.plugin.collect.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.cd.h;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.g.a.k;
import com.tencent.mm.model.at;
import com.tencent.mm.model.cb;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.collect.model.d;
import com.tencent.mm.plugin.collect.model.g;
import com.tencent.mm.plugin.collect.model.o;
import com.tencent.mm.plugin.collect.model.t;
import com.tencent.mm.plugin.collect.model.u;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

public class a implements at {
    public boolean kBA = false;
    private c<k> kBB = new c<k>() {
        {
            AppMethodBeat.i(40908);
            this.xxI = k.class.getName().hashCode();
            AppMethodBeat.o(40908);
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            AppMethodBeat.i(40909);
            a.this.kBA = ((k) bVar).csh.csi;
            AppMethodBeat.o(40909);
            return false;
        }
    };
    private com.tencent.mm.model.bz.a kBx = new com.tencent.mm.model.bz.a() {
        public final void a(com.tencent.mm.ai.e.a aVar) {
            AppMethodBeat.i(40906);
            a.bgv();
            if (a.bgw() != null) {
                String a = aa.a(aVar.eAB.vED);
                a.bgv();
                d bgw = a.bgw();
                long j = (long) aVar.eAB.pcX;
                ab.v("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] content:".concat(String.valueOf(a)));
                if (bo.isNullOrNil(a)) {
                    ab.d("MicroMsg.CollectPayerMsgMgr", "func[onResvMsg] Msg content empty");
                    AppMethodBeat.o(40906);
                    return;
                }
                Map z = br.z(a, "sysmsg");
                int i = bo.getInt((String) z.get(".sysmsg.paymsg.PayMsgType"), 0);
                if (i == 9 || i == 26) {
                    t tVar = new t();
                    tVar.username = bo.nullAsNil((String) z.get(".sysmsg.paymsg.username"));
                    tVar.kCJ = bo.getDouble((String) z.get(".sysmsg.paymsg.fee"), 0.0d) / 100.0d;
                    tVar.cuZ = bo.nullAsNil((String) z.get(".sysmsg.paymsg.feetype"));
                    tVar.timestamp = bo.getInt((String) z.get(".sysmsg.paymsgtimestamp"), (int) bo.anT());
                    tVar.cAa = bo.nullAsNil((String) z.get(".sysmsg.paymsg.transid"));
                    tVar.eoz = bo.nullAsNil((String) z.get(".sysmsg.paymsg.displayname"));
                    tVar.scene = bo.getInt((String) z.get(".sysmsg.paymsg.scene"), 1);
                    tVar.status = bo.getInt((String) z.get(".sysmsg.paymsg.status"), 0);
                    tVar.msgType = i;
                    tVar.kCK = bo.nullAsNil((String) z.get(".sysmsg.paymsg.outtradeno"));
                    tVar.type = bo.nullAsNil((String) z.get(".sysmsg.paymsg.type"));
                    String nullAsNil = bo.nullAsNil((String) z.get(".sysmsg.paymsg.voice_content"));
                    for (com.tencent.mm.plugin.collect.model.d.a aVar2 : bgw.kaD) {
                        if (aVar2 != null) {
                            aVar2.a(tVar);
                        }
                    }
                    if (tVar.status == 1) {
                        bx bxVar = new bx();
                        bxVar.cuX.cuY = (int) Math.round(tVar.kCJ * 100.0d);
                        bxVar.cuX.cuZ = tVar.cuZ;
                        bxVar.cuX.cvb = tVar.type;
                        bxVar.cuX.cva = tVar.kCK;
                        bxVar.cuX.cvc = cb.aaE() - (j * 1000);
                        bxVar.cuX.cvd = 1;
                        bxVar.cuX.cve = nullAsNil;
                        com.tencent.mm.sdk.b.a.xxA.m(bxVar);
                    }
                    AppMethodBeat.o(40906);
                    return;
                }
                ab.i("MicroMsg.CollectPayerMsgMgr", "Not ftf collect msg type, ignore; type=".concat(String.valueOf(i)));
                AppMethodBeat.o(40906);
                return;
            }
            ab.w("MicroMsg.SubCoreCollect", "func[onRecieveMsg] payerMsgMgr null");
            AppMethodBeat.o(40906);
        }
    };
    private g kBy = new g();
    private u kBz = new u();

    public a() {
        AppMethodBeat.i(40910);
        AppMethodBeat.o(40910);
    }

    public static a bgv() {
        AppMethodBeat.i(40911);
        a aVar = (a) q.Y(a.class);
        AppMethodBeat.o(40911);
        return aVar;
    }

    public final HashMap<Integer, h.d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bA(boolean z) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(40912);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().a("paymsg", this.kBx, true);
        this.kBB.dnU();
        f fVar = this.kBy;
        fVar.dnU();
        fVar.kBO = new ConcurrentLinkedQueue();
        com.tencent.mm.plugin.collect.model.voice.a bgJ = com.tencent.mm.plugin.collect.model.voice.a.bgJ();
        bgJ.kCX = fVar;
        bgJ.kCY = new com.tencent.mm.plugin.collect.model.voice.a.b(bgJ.kCX);
        com.tencent.mm.kernel.g.RP().Ry().a(bgJ);
        com.tencent.mm.plugin.collect.model.voice.a.bgJ().bgK();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1384, fVar);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(1317, fVar);
        this.kBz.dnU();
        AppMethodBeat.o(40912);
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(40913);
        ((p) com.tencent.mm.kernel.g.M(p.class)).getSysCmdMsgExtension().b("paymsg", this.kBx, true);
        f fVar = this.kBy;
        fVar.dead();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1384, fVar);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(1317, fVar);
        g.bgB();
        com.tencent.mm.plugin.collect.model.voice.a bgJ = com.tencent.mm.plugin.collect.model.voice.a.bgJ();
        ab.i("MicroMsg.OfflineVoice.F2fRcvVoiceOffLineLogic", "destroy()");
        if (bgJ.kCW != null) {
            bgJ.kCW.kDp.destroy();
        }
        if (bgJ.kDb != null) {
            bgJ.kDb.dead();
        }
        if (bgJ.kDc != null) {
            bgJ.kDc.dead();
        }
        com.tencent.mm.kernel.g.RP().Ry().b(bgJ);
        com.tencent.mm.plugin.collect.model.voice.a.kCR = false;
        this.kBz.dead();
        this.kBB.dead();
        AppMethodBeat.o(40913);
    }

    public static d bgw() {
        AppMethodBeat.i(40914);
        com.tencent.mm.kernel.g.RN().QU();
        d dVar = d.kBH;
        AppMethodBeat.o(40914);
        return dVar;
    }

    public static boolean bgx() {
        AppMethodBeat.i(40915);
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_F2F_RING_TONE_STRING, (Object) "");
        long YE = r.YE();
        if (!bo.isNullOrNil(str) && !str.equals("in.caf")) {
            ab.i("MicroMsg.SubCoreCollect", "old version switch is open, sync to new version");
            com.tencent.mm.kernel.g.RP().Ry().set(147457, Long.valueOf(YE | 32768));
            bci bci = new bci();
            bci.pXD = 1;
            ((j) com.tencent.mm.kernel.g.K(j.class)).XL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(209, bci));
            AppMethodBeat.o(40915);
            return true;
        } else if ((YE & 32768) != 0) {
            AppMethodBeat.o(40915);
            return true;
        } else {
            AppMethodBeat.o(40915);
            return false;
        }
    }

    public final void bgy() {
        AppMethodBeat.i(40916);
        HZ("cash.caf");
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_F2F_RING_TONE_STRING, (Object) "cash.caf");
        AppMethodBeat.o(40916);
    }

    public final void bgz() {
        AppMethodBeat.i(40917);
        HZ("in.caf");
        com.tencent.mm.kernel.g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_F2F_RING_TONE_STRING, (Object) "in.caf");
        AppMethodBeat.o(40917);
    }

    private void HZ(String str) {
        AppMethodBeat.i(40918);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(304, new f() {
            public final void onSceneEnd(int i, int i2, String str, m mVar) {
                AppMethodBeat.i(40907);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.b(304, (f) this);
                if (!(i == 0 && i2 == 0)) {
                    ab.i("MicroMsg.SubCoreCollect", "set sound fail!");
                }
                AppMethodBeat.o(40907);
            }
        });
        m oVar = new o(bo.bc(str, ""));
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(oVar, 0);
        AppMethodBeat.o(40918);
    }
}
