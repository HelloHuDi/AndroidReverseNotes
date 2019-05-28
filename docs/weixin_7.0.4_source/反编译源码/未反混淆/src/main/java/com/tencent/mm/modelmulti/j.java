package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.zero.c;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.protocal.t.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import junit.framework.Assert;

public final class j extends m implements k {
    protected static int fHJ = 7;
    private static int fIB = 0;
    private static boolean fIy = false;
    public String TAG;
    private String aIm;
    private com.tencent.mm.compatible.util.g.a eOm;
    private f ehi;
    private int errCode;
    private int errType;
    private int fHK;
    private long fHM;
    private boolean fHN;
    private ap fIA;
    private int fIC;
    private boolean fID;
    private String fIE;
    public b fIF;
    private long fIG;
    private boolean fIa;
    public p fIx;
    private boolean fIz;
    private ap frk;

    public static class a extends com.tencent.mm.ai.k {
        private final com.tencent.mm.protocal.t.a fHQ;
        private final b fHR;
        private final boolean fHS;

        public a() {
            AppMethodBeat.i(58382);
            this.fHQ = new com.tencent.mm.protocal.t.a();
            this.fHR = new b();
            this.fHS = false;
            AppMethodBeat.o(58382);
        }

        public a(b bVar) {
            AppMethodBeat.i(58383);
            this.fHQ = new com.tencent.mm.protocal.t.a();
            this.fHR = bVar;
            this.fHS = true;
            AppMethodBeat.o(58383);
        }

        public final d ZR() {
            return this.fHQ;
        }

        public final e ZS() {
            return this.fHR;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }
    }

    public j(int i) {
        AppMethodBeat.i(58384);
        this.TAG = "MicroMsg.NetSceneSync";
        this.errType = 0;
        this.errCode = 0;
        this.aIm = "";
        this.fIx = null;
        this.fIz = false;
        this.fHK = 0;
        this.frk = null;
        this.fIA = null;
        this.fHM = -1;
        this.fHN = false;
        this.fID = false;
        this.fIa = false;
        this.fIE = "";
        this.fIF = null;
        this.fIG = 0;
        this.TAG += "[" + hashCode() + "]";
        ab.i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", Integer.valueOf(i), bo.dpG());
        this.fIE = an.doQ();
        this.eOm = new com.tencent.mm.compatible.util.g.a();
        if (this.fIx == null) {
            this.fIx = new p();
        }
        this.fIx.fJD = i;
        g.RQ();
        if (g.RP() != null && g.RK()) {
            g.RQ();
            if (!(g.RP().Ry() == null || com.tencent.mm.kernel.a.QT())) {
                g.RQ();
                long a = bo.a((Long) g.RP().Ry().get(8196, null), 0);
                if (a != 0) {
                    g.RQ();
                    g.RP().Ry().set(8196, Long.valueOf(0));
                    int i2 = (int) (a | ((long) fHJ));
                    fHJ = i2;
                    fHJ = i2 & 95;
                }
            }
        }
        if (i == 1) {
            fIy = true;
        }
        if (i == 1010) {
            fHJ |= 16;
            fIy = true;
            this.fIC = 7;
        } else if (i == 1011) {
            fHJ |= 64;
            fIy = true;
            this.fIC = 7;
        } else if (i == 3) {
            fHJ |= 262144;
            fIy = true;
            this.fIC = 3;
            ab.i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", Integer.valueOf(i), Integer.valueOf(fHJ), Integer.valueOf(this.fIC));
        } else {
            this.fIC = i;
        }
        if (fIB == 0) {
            ahR();
        }
        AppMethodBeat.o(58384);
    }

    public j(final b bVar, int i, long j) {
        this(8);
        AppMethodBeat.i(58385);
        this.fIE = an.doQ();
        ab.i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", Long.valueOf(bVar.bufferSize), Integer.valueOf(i), Long.valueOf(j));
        this.fHK = i;
        this.fHM = j;
        this.frk = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
            public final boolean BI() {
                AppMethodBeat.i(58379);
                j.this.fHN = true;
                a aVar = new a(bVar);
                com.tencent.mm.plugin.report.e.pXa.a(99, 230, 1, false);
                j.this.a(-1, 0, 0, "", aVar, null);
                AppMethodBeat.o(58379);
                return false;
            }
        }, false);
        if (fIB == 0) {
            ahR();
        }
        AppMethodBeat.o(58385);
    }

    public final boolean a(m mVar) {
        boolean z = true;
        AppMethodBeat.i(58386);
        if (mVar instanceof j) {
            j jVar = (j) mVar;
            if (jVar.fIz || !fIy) {
                AppMethodBeat.o(58386);
                return false;
            }
            ab.e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", Long.valueOf(jVar.ftg));
            if (bo.az(jVar.ftg) <= 360000) {
                z = false;
            }
            if (z) {
                ab.i(this.TAG, "summerworker NetSceneSync timeout");
                Runnable findTaskByRunTime = g.RS().doN().findTaskByRunTime(0);
                if (findTaskByRunTime != null) {
                    ab.e(this.TAG, "summerworker worker is just blocked by task: " + ak.dump(findTaskByRunTime, false));
                    AppMethodBeat.o(58386);
                    return false;
                }
            }
            AppMethodBeat.o(58386);
            return z;
        }
        AppMethodBeat.o(58386);
        return false;
    }

    public final boolean acI() {
        return true;
    }

    public final int acn() {
        return 100;
    }

    public final m.b b(q qVar) {
        return m.b.EOk;
    }

    public final boolean acJ() {
        int i = 1;
        AppMethodBeat.i(58387);
        boolean acJ = super.acJ();
        if (acJ) {
            com.tencent.mm.plugin.report.e.pXa.a(99, 228, 1, false);
            com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.pXa;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            eVar.e(12063, objArr);
        }
        AppMethodBeat.o(58387);
        return acJ;
    }

    public final int getType() {
        return 138;
    }

    public final void cancel() {
        AppMethodBeat.i(58388);
        super.cancel();
        com.tencent.mm.plugin.report.e.pXa.a(99, 229, 1, false);
        this.fIa = true;
        AppMethodBeat.o(58388);
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(58389);
        if (k.ahT()) {
            fIB = 0;
            ab.e(this.TAG, "dkinit never do sync before init done");
            AppMethodBeat.o(58389);
            return -1;
        }
        this.ehi = fVar;
        if (this.fIx == null) {
            this.fIx = new p();
        }
        this.fIx.caA = com.tencent.mm.sdk.a.b.foreground;
        if (this.fIA != null) {
            ab.i(this.TAG, "pushSyncRespHandler not null");
            c(eVar);
            this.fIA.ae(0, 0);
            AppMethodBeat.o(58389);
            return 0;
        } else if (fIB > 0) {
            ab.w(this.TAG, "other sync is dealing with resp data :%d", Integer.valueOf(fIB));
            AppMethodBeat.o(58389);
            return -1;
        } else if (this.frk != null) {
            ab.i(this.TAG, "pusher not null");
            c(eVar);
            this.frk.ae(0, 0);
            AppMethodBeat.o(58389);
            return 0;
        } else {
            a aVar = new a();
            bej bej = ((com.tencent.mm.protocal.t.a) aVar.acF()).vyG;
            if (this.fIC == 3) {
                bej.wIx = 1;
            } else {
                bej.wIx = 0;
            }
            this.fIC = this.fID ? 6 : this.fIC;
            bej.vTN = fHJ;
            g.RQ();
            bej.vTO = aa.ad(bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, new byte[0]))));
            bej.Scene = this.fIC;
            bej.wIw = new tc();
            bej.vIk = com.tencent.mm.protocal.d.eSg;
            ab.i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", Integer.valueOf(bej.vTN), Integer.valueOf(bej.Scene), com.tencent.mm.protocal.aa.bP(r0));
            fIy = false;
            int a = a(eVar, aVar, this);
            AppMethodBeat.o(58389);
            return a;
        }
    }

    private boolean ahR() {
        AppMethodBeat.i(58390);
        PInt pInt = new PInt();
        g.RQ();
        g.RN();
        byte[] a = com.tencent.mm.booter.g.a(pInt, com.tencent.mm.kernel.a.QF());
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        ab.i(str, str2, objArr);
        fIB = pInt.value;
        if (pInt.value == 0 || bo.cb(a)) {
            fIB = 0;
            AppMethodBeat.o(58390);
            return false;
        }
        b bVar = new b();
        try {
            bVar.P(a);
            final a aVar = new a(bVar);
            this.fIA = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(58380);
                    j.this.fHN = true;
                    com.tencent.mm.plugin.report.e.pXa.a(99, 231, 1, false);
                    j.this.a(-1, 0, 0, "", aVar, null);
                    AppMethodBeat.o(58380);
                    return false;
                }
            }, false);
            AppMethodBeat.o(58390);
            return true;
        } catch (Exception e) {
            com.tencent.mm.plugin.report.e.pXa.a(99, 226, 1, false);
            ab.e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = fIB;
            g.RQ();
            g.RN();
            com.tencent.mm.booter.g.bO(i, com.tencent.mm.kernel.a.QF());
            fIB = 0;
            AppMethodBeat.o(58390);
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            ab.i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
            Assert.assertTrue("dealWithRespData error", false);
            AppMethodBeat.o(58390);
            return false;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(58391);
        String str2;
        if (qVar == null || qVar.getType() != 138) {
            String str3 = this.TAG;
            str2 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(qVar == null ? -2 : qVar.getType());
            ab.e(str3, str2, objArr);
            AppMethodBeat.o(58391);
            return;
        }
        boolean z;
        b bVar = (b) qVar.ZS();
        str2 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.eOm.Mr());
        objArr2[4] = Boolean.valueOf(this.fHN);
        objArr2[5] = Integer.valueOf(bVar.vyH.vTR == null ? -1 : bVar.vyH.vTR.jBv);
        objArr2[6] = this.frk;
        objArr2[7] = this.fIA;
        ab.i(str2, str4, objArr2);
        Object obj = (bVar.vyH.vTR == null ? -1 : bVar.vyH.vTR.jBv) > 0 ? 1 : null;
        if (!ahS()) {
            com.tencent.mm.plugin.report.e.pXa.a(99, obj != null ? 221 : 218, 1, false);
        } else if (com.tencent.mm.sdk.a.b.foreground) {
            com.tencent.mm.plugin.report.e.pXa.a(99, obj != null ? 219 : 216, 1, false);
        } else {
            com.tencent.mm.plugin.report.e.pXa.a(99, obj != null ? 220 : 217, 1, false);
        }
        this.frk = null;
        this.fIz = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            com.tencent.mm.plugin.report.e.pXa.a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            com.tencent.mm.plugin.report.e.pXa.a(99, 233, 1, false);
            byte[] a = aa.a(((com.tencent.mm.protocal.t.a) qVar.acF()).vyG.vTO);
            byte[] a2 = aa.a(bVar.vyH.vTO);
            ab.i(this.TAG, "onGYNetEnd replace key:%b req :%s", Boolean.valueOf(z), com.tencent.mm.protocal.aa.bP(a));
            ab.i(this.TAG, "onGYNetEnd replace key:%b resp:%s", Boolean.valueOf(z), com.tencent.mm.protocal.aa.bP(a2));
            if (!z) {
                if (bo.cb(a)) {
                    g.RQ();
                    a = bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, new byte[0])));
                    ab.d(this.TAG, "dkpush userinfo key : %d[%s]", Integer.valueOf(a.length), bo.ca(a));
                }
                a = com.tencent.mm.protocal.aa.j(a, a2);
                if (a == null || a.length <= 0) {
                    ab.w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                bVar.vyH.vTO = aa.ad(a);
            }
            g.RQ();
            g.RN().cd(bVar.vyH.jBT, bVar.vyH.wIy);
            g.RQ();
            g.RN();
            com.tencent.mm.kernel.a.jO(bVar.vyH.jBT);
            Assert.assertTrue(this.fIF == null);
            this.fIF = bVar;
            this.fIG = bo.anU();
            new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                private int fIJ = 0;
                private long fIK = 0;
                private int fIL = 0;

                public final boolean BI() {
                    AppMethodBeat.i(58381);
                    c cVar = new c();
                    if (!g.RK()) {
                        ab.e(j.this.TAG, "syncRespHandler acc is not ready STOP :%s", j.this.fIF);
                        j.this.fIF = null;
                        AppMethodBeat.o(58381);
                        return false;
                    } else if (j.this.fIa) {
                        cVar.cd(j.this);
                        j.this.fIF = null;
                        AppMethodBeat.o(58381);
                        return false;
                    } else if (j.this.fIF == null || j.this.fIF.vyH.vTR == null || j.this.fIF.vyH.vTR.jBw == null) {
                        ab.e(j.this.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", j.this.fIF);
                        cVar.cd(j.this);
                        j.this.fIF = null;
                        AppMethodBeat.o(58381);
                        return false;
                    } else {
                        LinkedList linkedList = j.this.fIF.vyH.vTR.jBw;
                        cVar.ca(j.this);
                        this.fIL++;
                        long anU = bo.anU();
                        int i = 0;
                        while (true) {
                            int i2 = i;
                            if (i2 < 5) {
                                if (this.fIJ < linkedList.size()) {
                                    ab.v(j.this.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", Integer.valueOf(i2), Integer.valueOf(this.fIJ), Integer.valueOf(linkedList.size()), Integer.valueOf(((tb) linkedList.get(this.fIJ)).wat), Integer.valueOf(((tb) linkedList.get(this.fIJ)).wau.getILen()));
                                    linkedList.size();
                                    if (!cVar.a((tb) linkedList.get(this.fIJ), false)) {
                                        ab.w(j.this.TAG, "DoCmd Failed index:%d", Integer.valueOf(this.fIJ));
                                    }
                                    this.fIJ++;
                                }
                                if (this.fIJ >= linkedList.size()) {
                                    this.fIK += bo.gb(anU);
                                    ab.i(j.this.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", Integer.valueOf(this.fIJ), Integer.valueOf(linkedList.size()), Long.valueOf(bo.gb(j.this.fIG)), Long.valueOf(this.fIK), Integer.valueOf(this.fIL), j.this.fIF);
                                    j.this.a(j.this.fIF);
                                    cVar.cc(j.this);
                                    com.tencent.mm.plugin.report.e.pXa.a(99, (long) bo.h((Integer) com.tencent.mm.plugin.report.e.a((int) this.fIK, new int[]{100, 300, 1000, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS}, new Integer[]{Integer.valueOf(240), Integer.valueOf(com.tencent.view.d.MIC_PTU_SHISHANG2), Integer.valueOf(com.tencent.view.d.MIC_PTU_SHIGUANG), Integer.valueOf(com.tencent.view.d.MIC_PTU_LENGMEIREN), Integer.valueOf(236)})), 1, false);
                                    com.tencent.mm.plugin.report.e.pXa.a(99, (long) bo.h((Integer) com.tencent.mm.plugin.report.e.a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(249), Integer.valueOf(com.tencent.view.d.MIC_PTU_ZIPAI_THURSDAY), Integer.valueOf(247), Integer.valueOf(com.tencent.view.d.MIC_PTU_ZIPAI_FAIRYTALE), Integer.valueOf(com.tencent.view.d.MIC_PTU_ZIPAI_LIGHTWHITE), Integer.valueOf(244), Integer.valueOf(243)})), 1, false);
                                    com.tencent.mm.plugin.report.e.pXa.a(99, com.tencent.mm.sdk.a.b.foreground ? 241 : 242, 1, false);
                                    com.tencent.mm.plugin.report.e.pXa.a(99, (long) j.this.fIC, 1, false);
                                    com.tencent.mm.plugin.report.e.pXa.a(99, 0, 1, false);
                                    com.tencent.mm.plugin.report.e eVar = com.tencent.mm.plugin.report.e.pXa;
                                    Object[] objArr = new Object[8];
                                    objArr[0] = Integer.valueOf(linkedList.size());
                                    objArr[1] = Long.valueOf(r10);
                                    objArr[2] = Integer.valueOf(j.this.fIC);
                                    objArr[3] = Integer.valueOf(j.this.fIF.vyH.vQe);
                                    objArr[4] = Long.valueOf(this.fIK);
                                    objArr[5] = Integer.valueOf(this.fIL);
                                    objArr[6] = j.this.fIE;
                                    objArr[7] = Integer.valueOf(com.tencent.mm.sdk.a.b.foreground ? 1 : 2);
                                    eVar.e(12063, objArr);
                                    j.this.fIF = null;
                                    AppMethodBeat.o(58381);
                                    return false;
                                }
                                if (bo.gb(anU) > 500) {
                                    ab.d(j.this.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", Long.valueOf(bo.gb(anU)), Integer.valueOf(i2), Integer.valueOf(this.fIJ), j.this.fIF);
                                    this.fIK += bo.gb(anU);
                                    AppMethodBeat.o(58381);
                                    return true;
                                }
                                i = i2 + 1;
                            } else {
                                this.fIK += bo.gb(anU);
                                AppMethodBeat.o(58381);
                                return true;
                            }
                        }
                    }
                }
            }, true).ae(50, 50);
            AppMethodBeat.o(58391);
            return;
        }
        if (this.fIF != null) {
            ab.i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.aIm = str;
            ((b) qVar.ZS()).vyH.vQe = 0;
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        com.tencent.mm.plugin.report.e.pXa.a(99, 232, 1, false);
        AppMethodBeat.o(58391);
    }

    /* Access modifiers changed, original: protected|final */
    public final void a(b bVar) {
        AppMethodBeat.i(58392);
        g.RQ();
        g.RP().Ry().set(8195, bo.cd(aa.a(bVar.vyH.vTO)));
        ah.getContext().getSharedPreferences("notify_sync_pref", h.Mu()).edit().putString("notify_sync_key_keybuf", bo.cd(aa.a(bVar.vyH.vTO))).commit();
        g.RQ();
        g.RP().Ry().set(8196, Long.valueOf((long) bVar.vyH.vQe));
        boolean z = ((bVar.vyH.vQe & fHJ) == 0 || super.acJ()) ? false : true;
        ab.i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", Boolean.valueOf(z), Integer.valueOf(bVar.vyH.vQe), Integer.valueOf(fHJ), Boolean.valueOf(super.acJ()));
        if (!(z || (bVar.vyH.vQe & 256) == 0)) {
            rv rvVar = new rv();
            rvVar.cNO.cvp = 1;
            com.tencent.mm.sdk.b.a.xxA.m(rvVar);
        }
        if (!(z || (bVar.vyH.vQe & 2097152) == 0)) {
            com.tencent.mm.sdk.b.a.xxA.m(new lx());
        }
        com.tencent.mm.plugin.report.e.pXa.a(99, z ? 234 : 235, 1, false);
        ab.i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", Integer.valueOf(bVar.vyH.vQe), Boolean.valueOf(this.fHN), Boolean.valueOf(z), Boolean.valueOf(fIy), Integer.valueOf(this.fHK), Boolean.valueOf(this.fID), this.fIA);
        int i;
        if (!this.fHN && z) {
            this.fID = true;
            a(this.ftf, this.ehi);
            AppMethodBeat.o(58392);
        } else if (fIy) {
            ab.i(this.TAG, "dkpush new notify pending, sync now");
            if (fIB != 0) {
                i = fIB;
                g.RQ();
                g.RN();
                com.tencent.mm.booter.g.bO(i, com.tencent.mm.kernel.a.QF());
            }
            fIB = 0;
            this.fIA = null;
            fIy = false;
            this.fID = true;
            a(this.ftf, this.ehi);
            AppMethodBeat.o(58392);
        } else if (this.fIA != null) {
            i = fIB;
            g.RQ();
            g.RN();
            com.tencent.mm.booter.g.bO(i, com.tencent.mm.kernel.a.QF());
            this.fIA = null;
            ahR();
            a(this.ftf, this.ehi);
            AppMethodBeat.o(58392);
        } else {
            if ((this.fHK & 1) > 0) {
                g.RQ();
                g.Rg().a(new f(this.fHM, bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, null)))), 0);
            }
            ab.d(this.TAG, "sync or init end: reset selector : now = " + fHJ + " default = 7");
            fHJ = 7;
            this.ehi.onSceneEnd(this.errType, this.errCode, this.aIm, this);
            AppMethodBeat.o(58392);
        }
    }

    private boolean ahS() {
        AppMethodBeat.i(58393);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ah.getContext().getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.o(58393);
            return booleanValue;
        } catch (Exception e) {
            ab.e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.TRUE, bo.l(e));
            AppMethodBeat.o(58393);
            return true;
        }
    }
}
