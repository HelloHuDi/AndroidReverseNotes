package com.tencent.mm.modelmulti;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.g;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bec;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class e extends m implements k {
    com.tencent.mm.compatible.util.g.a eOm;
    f ehi;
    final Queue<a> fCB = new LinkedList();
    private StringBuilder fHL = new StringBuilder();
    WeakReference<g> fHU = null;
    final beb fHV = new beb();
    int fHW = 0;
    boolean fHX = false;
    int fHY = 0;
    int fHZ = 0;
    boolean fIa = false;
    private final ap frk = new ap(com.tencent.mm.kernel.g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
        public final boolean BI() {
            float f = 1.0f;
            AppMethodBeat.i(58360);
            if (!com.tencent.mm.kernel.g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
                AppMethodBeat.o(58360);
                return false;
            } else if (e.this.fIa) {
                ab.w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", Integer.valueOf(e.this.hashCode()));
                AppMethodBeat.o(58360);
                return false;
            } else if (e.this.fCB.isEmpty()) {
                ab.v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
                AppMethodBeat.o(58360);
                return false;
            } else {
                boolean z;
                ab.i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", Integer.valueOf(e.this.hashCode()), Long.valueOf(e.this.eOm.Mr()), Integer.valueOf(e.this.fCB.size()), Integer.valueOf(e.this.fHW), Boolean.valueOf(e.this.fHX), Integer.valueOf(e.this.fHZ), Integer.valueOf(e.this.fHY));
                com.tencent.mm.kernel.g.RQ();
                long iV = com.tencent.mm.kernel.g.RP().eJN.iV(Thread.currentThread().getId());
                c cVar = new c();
                cVar.ca("NetSceneInit");
                int i = e.this.fHX ? 40 : 10;
                int i2 = 0;
                while (i2 < i) {
                    final a aVar = (a) e.this.fCB.peek();
                    if (aVar.fIf != BaseClientBuilder.API_PRIORITY_OTHER) {
                        LinkedList linkedList = aVar.fIe.wHL;
                        if (linkedList != null && linkedList.size() > aVar.fCP) {
                            linkedList.size();
                            if (cVar.a((tb) linkedList.get(aVar.fCP), true)) {
                                aVar.fCP++;
                                e eVar = e.this;
                                eVar.fHZ++;
                                i2++;
                            }
                        }
                        e.this.fCB.poll();
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(8197, bo.cd(aa.a(aVar.fIe.wHH)));
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(8198, bo.cd(aa.a(aVar.fIe.wHI)));
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(16, Integer.valueOf(0));
                        ab.i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s", Long.valueOf((long) aVar.fIe.vQe));
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().set(8196, Long.valueOf((long) aVar.fIe.vQe));
                        com.tencent.mm.kernel.g.RQ();
                        com.tencent.mm.kernel.g.RP().Ry().dsb();
                        z = true;
                        break;
                    }
                    String str = "in Queue tail , resp should be null";
                    if (aVar.fIe == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Assert.assertTrue(str, z);
                    com.tencent.mm.kernel.g.RQ();
                    Object obj = (String) com.tencent.mm.kernel.g.RP().Ry().get(8198, null);
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(8195, obj);
                    ah.getContext().getSharedPreferences("notify_sync_pref", h.Mu()).edit().putString("notify_sync_key_keybuf", obj).commit();
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(8197, (Object) "");
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(8198, (Object) "");
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().set(15, Integer.valueOf(1));
                    com.tencent.mm.kernel.g.RQ();
                    com.tencent.mm.kernel.g.RP().Ry().dsb();
                    ab.i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", Integer.valueOf(e.this.hashCode()), Long.valueOf(e.this.eOm.Mr()), Integer.valueOf(e.this.fHW), Integer.valueOf(e.this.fHY), Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
                    com.tencent.mm.kernel.g.RS().aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(58359);
                            e.this.ehi.onSceneEnd(aVar.errType, aVar.errCode, aVar.aIm, e.this);
                            AppMethodBeat.o(58359);
                        }
                    });
                    z = false;
                }
                z = true;
                cVar.cc("NetSceneInit");
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RP().eJN.mB(iV);
                e eVar2 = e.this;
                if (eVar2.fHU == null) {
                    ab.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
                } else {
                    g gVar = (g) eVar2.fHU.get();
                    if (gVar == null) {
                        ab.w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
                    } else {
                        i = eVar2.fHW > 50 ? 50 : eVar2.fHW;
                        if (eVar2.fHX) {
                            float f2 = ((float) eVar2.fHZ) / ((float) eVar2.fHY);
                            if (f2 <= 1.0f) {
                                f = f2;
                            }
                            i2 = (int) ((((float) (100 - i)) * f) + ((float) i));
                        } else {
                            i2 = i;
                        }
                        ab.d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", Integer.valueOf(eVar2.fHZ), Integer.valueOf(eVar2.fHY), Float.valueOf(f), Integer.valueOf(i));
                        gVar.a(i2, 100, eVar2);
                    }
                }
                AppMethodBeat.o(58360);
                return z;
            }
        }
    }, true);
    private int retryCount = 3;

    public static class b extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.s.a fIg = new com.tencent.mm.protocal.s.a();
        private final com.tencent.mm.protocal.s.b fIh = new com.tencent.mm.protocal.s.b();

        public b() {
            AppMethodBeat.i(58361);
            AppMethodBeat.o(58361);
        }

        public final d ZR() {
            return this.fIg;
        }

        public final com.tencent.mm.protocal.l.e ZS() {
            return this.fIh;
        }

        public final int getType() {
            return com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }

    class a {
        String aIm;
        int errCode;
        int errType;
        int fCP = 0;
        bec fIe;
        int fIf = 0;

        a() {
        }
    }

    public e(g gVar) {
        AppMethodBeat.i(58362);
        ab.i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", Integer.valueOf(hashCode()), bo.dpG());
        this.fHL.append("stack:" + bo.dpG() + " time:" + bo.anT());
        this.fHU = new WeakReference(gVar);
        AppMethodBeat.o(58362);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(58363);
        this.eOm = new com.tencent.mm.compatible.util.g.a();
        this.ehi = fVar;
        beb beb = this.fHV;
        com.tencent.mm.kernel.g.RQ();
        beb.jBB = (String) com.tencent.mm.kernel.g.RP().Ry().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !bo.isNullOrNil(this.fHV.jBB));
        this.fHV.luQ = com.tencent.mm.sdk.platformtools.aa.dor();
        int a = a(eVar, null, null);
        AppMethodBeat.o(58363);
        return a;
    }

    private int a(com.tencent.mm.network.e eVar, SKBuiltinBuffer_t sKBuiltinBuffer_t, SKBuiltinBuffer_t sKBuiltinBuffer_t2) {
        AppMethodBeat.i(58364);
        this.fHL.append(" lastd:" + this.ftg + " dotime:" + bo.anT() + " net:" + at.getNetType(ah.getContext()));
        b bVar = new b();
        if (sKBuiltinBuffer_t == null) {
            com.tencent.mm.kernel.g.RQ();
            sKBuiltinBuffer_t = aa.ad(bo.anf(bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(8197, null))));
        }
        if (sKBuiltinBuffer_t2 == null) {
            com.tencent.mm.kernel.g.RQ();
            sKBuiltinBuffer_t2 = aa.ad(bo.anf(bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(8198, null))));
        }
        com.tencent.mm.kernel.g.RQ();
        if (bo.h((Integer) com.tencent.mm.kernel.g.RP().Ry().get(16, null)) == 0 || (sKBuiltinBuffer_t != null && sKBuiltinBuffer_t.getILen() > 0)) {
            com.tencent.mm.kernel.g.RQ();
            if (bo.nullAsNil((String) com.tencent.mm.kernel.g.RP().Ry().get(8195, null)).length() <= 0) {
                bVar.acF().vyf = 3;
            } else {
                bVar.acF().vyf = 4;
            }
        } else {
            bVar.acF().vyf = 7;
        }
        this.fHV.wHH = sKBuiltinBuffer_t;
        this.fHV.wHI = sKBuiltinBuffer_t2;
        ((com.tencent.mm.protocal.s.a) bVar.acF()).vyE = this.fHV;
        ab.i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", Integer.valueOf(hashCode()), Long.valueOf(this.eOm.Mr()), Integer.valueOf(this.fHW), this.fHV.jBB, this.fHV.luQ, Integer.valueOf(bVar.acF().vyf), bo.cd(aa.a(sKBuiltinBuffer_t)), bo.cd(aa.a(sKBuiltinBuffer_t2)));
        this.fHW++;
        int a = a(eVar, bVar, this);
        AppMethodBeat.o(58364);
        return a;
    }

    /* JADX WARNING: Missing block: B:14:0x00d0, code skipped:
            if (a(r8.ftf, null, null) == -1) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(58365);
        this.fHL.append(" endtime:" + bo.anT());
        ab.i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i));
        if (i2 == 4 && i3 == -100) {
            ab.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.fIa = true;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(58365);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            bec bec = ((com.tencent.mm.protocal.s.b) qVar.ZS()).vyF;
            this.fHY += bec.wHK;
            ab.i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.eOm.Mr()), Integer.valueOf(this.fHY), Integer.valueOf(this.fHW), Integer.valueOf(bec.vQe));
            a(this.fHW - 1, i2, i3, str, bec);
            if ((bec.vQe & 7) == 0 || super.acJ()) {
                ab.i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", Integer.valueOf(hashCode()), Long.valueOf(this.eOm.Mr()), Integer.valueOf(this.fHW));
                this.fHX = true;
                a(BaseClientBuilder.API_PRIORITY_OTHER, 0, 0, "", null);
            } else if (a(this.ftf, bec.wHH, bec.wHI) == -1) {
                ab.e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                a(BaseClientBuilder.API_PRIORITY_OTHER, 3, -1, "", null);
                AppMethodBeat.o(58365);
                return;
            }
            AppMethodBeat.o(58365);
        } else {
            ab.e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.retryCount > 0) {
                this.retryCount--;
            }
            this.fIa = true;
            this.ehi.onSceneEnd(3, -1, "", this);
            AppMethodBeat.o(58365);
        }
    }

    public final boolean acI() {
        return true;
    }

    public final void cancel() {
        AppMethodBeat.i(58366);
        ab.w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", bo.dpG());
        super.cancel();
        this.fIa = true;
        AppMethodBeat.o(58366);
    }

    private void a(int i, int i2, int i3, String str, bec bec) {
        AppMethodBeat.i(58367);
        a aVar = new a();
        aVar.fIf = i;
        aVar.errCode = i3;
        aVar.errType = i2;
        aVar.aIm = str;
        aVar.fIe = bec;
        this.fCB.add(aVar);
        if (this.frk.doT()) {
            this.frk.ae(50, 50);
        }
        AppMethodBeat.o(58367);
    }

    public final String getInfo() {
        AppMethodBeat.i(58368);
        String stringBuilder = this.fHL.toString();
        AppMethodBeat.o(58368);
        return stringBuilder;
    }

    public final int acn() {
        return 500;
    }

    public final com.tencent.mm.ai.m.b b(q qVar) {
        return com.tencent.mm.ai.m.b.EOk;
    }

    public final boolean acJ() {
        AppMethodBeat.i(139010);
        boolean acJ = super.acJ();
        AppMethodBeat.o(139010);
        return acJ;
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.k.a.CTRL_INDEX;
    }
}
