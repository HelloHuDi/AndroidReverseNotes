package com.tencent.mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.lx;
import com.tencent.mm.g.a.rv;
import com.tencent.mm.g.a.so;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.model.cb;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bek;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.protocal.protobuf.tc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

public final class o {
    private static Boolean fJf = null;
    private WakerLock ecc = null;
    public Queue<c> fJg = new LinkedList();
    public Queue<c> fJh = new LinkedList();
    private HashMap<c, Long> fJi = new HashMap();
    public c fJj = null;
    private long fJk = 0;

    class d implements c {
        d() {
        }

        public final boolean c(Queue<c> queue) {
            AppMethodBeat.i(58402);
            PInt pInt = new PInt();
            g.RQ();
            g.RN();
            byte[] a = com.tencent.mm.booter.g.a(pInt, com.tencent.mm.kernel.a.QF());
            String str = "MicroMsg.SyncService";
            String str2 = "%s index:%d, buf.len:%d ";
            Object[] objArr = new Object[3];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(pInt.value);
            objArr[2] = Integer.valueOf(a != null ? a.length : -1);
            ab.i(str, str2, objArr);
            if (pInt.value == 0 || bo.cb(a)) {
                AppMethodBeat.o(58402);
                return false;
            }
            final int i = pInt.value;
            bek bek = null;
            try {
                com.tencent.mm.protocal.t.b bVar = new com.tencent.mm.protocal.t.b();
                bVar.P(a);
                bek = bVar.vyH;
            } catch (Exception e) {
                com.tencent.mm.plugin.report.e.pXa.a(99, 38, 1, false);
                ab.e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", this, Integer.valueOf(i), e.getMessage());
                g.RQ();
                g.RN();
                com.tencent.mm.booter.g.bO(i, com.tencent.mm.kernel.a.QF());
            } catch (Error e2) {
                com.tencent.mm.plugin.report.e.pXa.a(99, 39, 1, false);
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                ab.i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), e2.getMessage());
                g.RQ();
                g.RN();
                com.tencent.mm.booter.g.bO(i, com.tencent.mm.kernel.a.QF());
            }
            if (bek == null) {
                AppMethodBeat.o(58402);
                return false;
            }
            com.tencent.mm.plugin.report.e.pXa.a(99, 20, 1, false);
            a aVar = new a(o.this, this, true, bek, new b() {
                public final boolean lO(int i) {
                    AppMethodBeat.i(58401);
                    ab.i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", d.this, Integer.valueOf(i));
                    int i2 = i;
                    g.RQ();
                    g.RN();
                    com.tencent.mm.booter.g.bO(i2, com.tencent.mm.kernel.a.QF());
                    o.a(o.this, d.this);
                    AppMethodBeat.o(58401);
                    return true;
                }
            }, (byte) 0);
            AppMethodBeat.o(58402);
            return true;
        }

        public final String toString() {
            AppMethodBeat.i(58403);
            String str = "LightPush[" + hashCode() + "]";
            AppMethodBeat.o(58403);
            return str;
        }
    }

    class e extends m implements c, k {
        int fHJ;
        com.tencent.mm.ai.f fJv;
        boolean fJw;
        private boolean fJx = false;
        private q ftU;
        int scene;

        public final boolean c(Queue<c> queue) {
            String str;
            AppMethodBeat.i(58405);
            String str2 = "MicroMsg.SyncService";
            String str3 = "%s begin run scene:%s selector:%s isContinue:%s List:%s";
            Object[] objArr = new Object[5];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(this.scene);
            objArr[2] = Integer.valueOf(this.fHJ);
            objArr[3] = Boolean.valueOf(this.fJw);
            if (queue == null) {
                str = BuildConfig.COMMAND;
            } else {
                str = Integer.valueOf(queue.size());
            }
            objArr[4] = str;
            ab.i(str2, str3, objArr);
            if (queue != null) {
                o.b((Queue) queue);
                boolean z = false;
                boolean z2 = false;
                while (!queue.isEmpty()) {
                    e eVar = (e) queue.poll();
                    this.fHJ |= eVar.fHJ;
                    if (eVar.scene == 3) {
                        z = true;
                    } else if (eVar.fJw) {
                        z2 = true;
                    }
                    ab.i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", this, Integer.valueOf(queue.size()), eVar, Integer.valueOf(eVar.scene), Integer.valueOf(eVar.fHJ), Boolean.valueOf(eVar.fJw), Boolean.valueOf(z2), Boolean.valueOf(z));
                }
                if (z) {
                    this.scene = 3;
                } else if (z2) {
                    this.scene = 6;
                }
            }
            if (g.RK() && !com.tencent.mm.kernel.a.QT()) {
                g.RQ();
                if (g.RP() != null) {
                    g.RQ();
                    if (g.RP().Ry() != null) {
                        g.RQ();
                        long a = bo.a((Long) g.RP().Ry().get(8196, null), 0);
                        if (a != 0) {
                            g.RQ();
                            g.RP().Ry().set(8196, Long.valueOf(0));
                            this.fHJ = (int) (((long) this.fHJ) | a);
                            this.fHJ &= 95;
                        }
                        int i = this.scene == 3 ? 1 : 0;
                        if (this.scene == 1010) {
                            this.fHJ |= 16;
                            this.scene = 7;
                        } else if (this.scene == 1011) {
                            this.fHJ |= 64;
                            this.scene = 7;
                        } else if (this.scene == 3) {
                            this.fHJ |= 262144;
                            this.scene = 3;
                        }
                        if (this.fJw) {
                            this.scene = 6;
                        }
                        this.ftU = new com.tencent.mm.modelmulti.j.a();
                        bej bej = ((com.tencent.mm.protocal.t.a) this.ftU.acF()).vyG;
                        bej.wIx = i;
                        bej.vTN = this.fHJ;
                        bej.Scene = this.scene;
                        g.RQ();
                        bej.vTO = aa.ad(bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, new byte[0]))));
                        bej.wIw = new tc();
                        bej.vIk = com.tencent.mm.protocal.d.eSg;
                        ab.i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", this, Long.valueOf(a), Integer.valueOf(bej.wIx), Integer.valueOf(bej.vTN), Integer.valueOf(this.scene), bej.vIk);
                        ab.i("MicroMsg.SyncService", "%s Req synckey %s", this, com.tencent.mm.protocal.aa.bP(bo.anf(str)));
                        o.a(this);
                        g.RQ();
                        if (g.RO().eJo.a((m) this, 0)) {
                            AppMethodBeat.o(58405);
                            return true;
                        }
                        com.tencent.mm.plugin.report.e.pXa.e(11098, Integer.valueOf(3500), this.scene + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + o.ahZ());
                        ab.e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", this);
                        com.tencent.mm.plugin.report.e.pXa.a(99, 41, 1, false);
                        AppMethodBeat.o(58405);
                        return false;
                    }
                }
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = this;
            objArr2[1] = Boolean.valueOf(g.RK());
            objArr2[2] = Boolean.valueOf(com.tencent.mm.kernel.a.QT());
            g.RQ();
            objArr2[3] = g.RP();
            ab.e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
            AppMethodBeat.o(58405);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(58406);
            String str = "NetSync[" + hashCode() + "]";
            AppMethodBeat.o(58406);
            return str;
        }

        public e(int i, int i2, boolean z) {
            this.scene = i;
            this.fHJ = i2;
            this.fJw = z;
        }

        public final int getType() {
            return 138;
        }

        public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ai.f fVar) {
            AppMethodBeat.i(58407);
            this.fJv = fVar;
            int a = a(eVar, this.ftU, this);
            AppMethodBeat.o(58407);
            return a;
        }

        public final boolean acM() {
            return false;
        }

        public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
            AppMethodBeat.i(58408);
            if (qVar == null || qVar.getType() != 138) {
                com.tencent.mm.plugin.report.e.pXa.a(99, 44, 1, false);
                String str2 = "MicroMsg.SyncService";
                String str3 = "%s onGYNetEnd error type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = this;
                objArr[1] = Integer.valueOf(qVar == null ? -2 : qVar.getType());
                ab.e(str2, str3, objArr);
                AppMethodBeat.o(58408);
            } else if (this.fJx) {
                ab.e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", this);
                AppMethodBeat.o(58408);
            } else {
                boolean z;
                int doL;
                this.fJx = true;
                o.J("Check rr failed.", qVar == this.ftU);
                if (i2 == 0 && i3 == 0) {
                    z = true;
                } else {
                    ab.e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", this, Integer.valueOf(i2), Integer.valueOf(i3), str, qVar);
                    if (i2 == 4 && i3 == -2006) {
                        ab.w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", this);
                        com.tencent.mm.plugin.report.e.pXa.a(99, 42, 1, false);
                        z = false;
                    } else {
                        com.tencent.mm.plugin.report.e.pXa.e(11098, Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + com.tencent.mm.sdk.a.b.foreground + ";" + o.ahZ());
                        com.tencent.mm.plugin.report.e.pXa.a(99, 43, 1, false);
                        this.fJv.onSceneEnd(i2, i3, str, this);
                        o.a(o.this, (c) this);
                        AppMethodBeat.o(58408);
                        return;
                    }
                }
                bek bek = ((com.tencent.mm.protocal.t.b) qVar.ZS()).vyH;
                boolean z2 = WXHardCoderJNI.hcReceiveMsgEnable;
                int i4 = WXHardCoderJNI.hcReceiveMsgDelay;
                int i5 = WXHardCoderJNI.hcReceiveMsgCPU;
                int i6 = WXHardCoderJNI.hcReceiveMsgIO;
                if (WXHardCoderJNI.hcReceiveMsgThr) {
                    doL = g.RS().doL();
                } else {
                    doL = 0;
                }
                i4 = WXHardCoderJNI.startPerformance(z2, i4, i5, i6, doL, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
                final bek bek2 = bek;
                a aVar = new a(o.this, this, z, bek, new b() {
                    public final boolean lO(int i) {
                        AppMethodBeat.i(58404);
                        g.RQ();
                        g.RP().Ry().set(8196, Long.valueOf((long) bek2.vQe));
                        boolean z = (bek2.vQe & e.this.fHJ) != 0;
                        ab.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", e.this, Integer.valueOf(bek2.vQe), Boolean.valueOf(z), Integer.valueOf(bek2.vQe & 256), Integer.valueOf(bek2.vQe & 128), Integer.valueOf(e.this.fHJ));
                        if (!(z || (bek2.vQe & 256) == 0)) {
                            rv rvVar = new rv();
                            rvVar.cNO.cvp = 3;
                            com.tencent.mm.sdk.b.a.xxA.m(rvVar);
                        }
                        if (!(z || (bek2.vQe & 2097152) == 0)) {
                            com.tencent.mm.sdk.b.a.xxA.m(new lx());
                        }
                        if (!(z || (bek2.vQe & 128) == 0)) {
                            com.tencent.mm.sdk.b.a.xxA.m(new so());
                        }
                        if (z) {
                            if (i == 0 && e.this.fJw) {
                                ab.w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", e.this);
                            } else {
                                o.a(o.this, e.this.scene, e.this.fHJ);
                            }
                        }
                        e.this.fJv.onSceneEnd(0, 0, "", e.this);
                        o.a(o.this, e.this);
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, i4);
                        AppMethodBeat.o(58404);
                        return true;
                    }
                }, (byte) 0);
                AppMethodBeat.o(58408);
            }
        }
    }

    class f implements c {
        int fHK;
        long fJB;
        bek fJp;

        public f(com.tencent.mm.protocal.t.b bVar, int i, long j) {
            AppMethodBeat.i(58411);
            this.fJp = bVar == null ? null : bVar.vyH;
            this.fJB = j;
            this.fHK = i;
            AppMethodBeat.o(58411);
        }

        public final boolean c(Queue<c> queue) {
            AppMethodBeat.i(58412);
            if (this.fJp == null) {
                com.tencent.mm.plugin.report.e.pXa.a(99, 40, 1, false);
                ab.e("MicroMsg.SyncService", "%s run resp == null", this);
                AppMethodBeat.o(58412);
                return false;
            } else if (10018 == ae.giz) {
                ab.e("MicroMsg.SyncService", "%s Give up for test", this);
                AppMethodBeat.o(58412);
                return false;
            } else {
                a aVar = new a(o.this, this, true, this.fJp, new b() {
                    public final boolean lO(int i) {
                        AppMethodBeat.i(58409);
                        ab.i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", f.this, f.this.fJp, Integer.valueOf(f.this.fHK), Long.valueOf(f.this.fJB));
                        if ((f.this.fHK & 1) > 0) {
                            g.RQ();
                            g.Rg().a(new f(f.this.fJB, bo.anf(bo.nullAsNil((String) g.RP().Ry().get(8195, null)))), 0);
                        }
                        o.a(o.this, f.this);
                        AppMethodBeat.o(58409);
                        return true;
                    }
                }, (byte) 0);
                g.RS().m(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(58410);
                        ab.i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", f.this, Integer.valueOf(f.this.fJp.vQe));
                        g.RQ();
                        g.RP().Ry().set(8196, Long.valueOf((long) f.this.fJp.vQe));
                        if ((f.this.fJp.vQe & 256) != 0) {
                            rv rvVar = new rv();
                            rvVar.cNO.cvp = 2;
                            com.tencent.mm.sdk.b.a.xxA.m(rvVar);
                            com.tencent.mm.plugin.report.e.pXa.a(99, 22, 1, false);
                            ab.i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", f.this);
                        }
                        AppMethodBeat.o(58410);
                    }
                }, 100);
                com.tencent.mm.plugin.report.e.pXa.a(99, 21, 1, false);
                AppMethodBeat.o(58412);
                return true;
            }
        }

        public final String toString() {
            AppMethodBeat.i(58413);
            String str = "NotifyData[" + hashCode() + "]";
            AppMethodBeat.o(58413);
            return str;
        }
    }

    interface b {
        boolean lO(int i);
    }

    class a {
        int fHZ;
        boolean fJo;
        bek fJp;
        b fJq;
        c fJr;
        ap fJs;

        /* synthetic */ a(o oVar, c cVar, boolean z, bek bek, b bVar, byte b) {
            this(cVar, z, bek, bVar);
        }

        private a(c cVar, boolean z, bek bek, b bVar) {
            AppMethodBeat.i(58400);
            this.fHZ = 0;
            this.fJo = false;
            this.fJp = null;
            this.fJq = null;
            this.fJs = new ap(g.RS().oAl.getLooper(), new com.tencent.mm.sdk.platformtools.ap.a() {
                public final boolean BI() {
                    AppMethodBeat.i(58399);
                    if (g.RK() && !com.tencent.mm.kernel.a.QT()) {
                        g.RQ();
                        if (g.RP() != null) {
                            g.RQ();
                            if (g.RP().Ry() != null) {
                                LinkedList linkedList = a.this.fJp.vTR.jBw;
                                com.tencent.mm.plugin.zero.c cVar = new com.tencent.mm.plugin.zero.c();
                                cVar.ca(a.this.fJr);
                                long anU = bo.anU();
                                while (a.this.fHZ < linkedList.size()) {
                                    linkedList.size();
                                    if (!cVar.a((tb) linkedList.get(a.this.fHZ), false)) {
                                        com.tencent.mm.plugin.report.e.pXa.a(99, 46, 1, false);
                                    }
                                    a aVar = a.this;
                                    aVar.fHZ++;
                                    ab.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", a.this.fJr, Long.valueOf(bo.gb(anU)), Integer.valueOf(linkedList.size()), Integer.valueOf(a.this.fHZ - 1));
                                    if (bo.gb(anU) >= 500) {
                                        break;
                                    }
                                }
                                cVar.cc(a.this.fJr);
                                if (a.this.fHZ < linkedList.size()) {
                                    ab.i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", a.this.fJr, Long.valueOf(bo.gb(anU)), Integer.valueOf(linkedList.size()), Integer.valueOf(a.this.fHZ - 1));
                                    AppMethodBeat.o(58399);
                                    return true;
                                }
                                o.a(a.this.fJo, a.this.fJp, a.this.fJr);
                                a.this.fJq.lO(linkedList.size());
                                AppMethodBeat.o(58399);
                                return false;
                            }
                        }
                    }
                    Object[] objArr = new Object[4];
                    objArr[0] = a.this.fJr;
                    objArr[1] = Boolean.valueOf(g.RK());
                    objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.QT());
                    g.RQ();
                    objArr[3] = g.RP();
                    ab.e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
                    a.this.fJq.lO(0);
                    AppMethodBeat.o(58399);
                    return false;
                }
            }, true);
            this.fJq = bVar;
            this.fJr = cVar;
            this.fJo = z;
            this.fJp = bek;
            this.fHZ = 0;
            String str = "";
            boolean z2 = (this.fJq == null || this.fJr == null) ? false : true;
            o.J(str, z2);
            if (this.fJp == null) {
                o.J("resp Not null", false);
                ab.w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", this.fJr);
                this.fJq.lO(0);
                AppMethodBeat.o(58400);
                return;
            }
            if (g.RK() && !com.tencent.mm.kernel.a.QT()) {
                g.RQ();
                if (g.RP() != null) {
                    g.RQ();
                    if (g.RP().Ry() != null) {
                        o.a(bek);
                        long j = (long) bek.wIz;
                        if (String.valueOf(j).length() == 10) {
                            j *= 1000;
                        }
                        long currentTimeMillis = System.currentTimeMillis() - j;
                        long j2 = currentTimeMillis / 1000;
                        ab.i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                        g.RQ();
                        g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, Long.valueOf(currentTimeMillis));
                        cb.fo(j);
                        g.RQ();
                        g.RN().cd(this.fJp.jBT, this.fJp.wIy);
                        g.RQ();
                        g.RN();
                        com.tencent.mm.kernel.a.jO(this.fJp.jBT);
                        if (this.fJp.vTR == null || this.fJp.vTR.jBw == null || this.fJp.vTR.jBw.size() <= 0) {
                            ab.w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", this.fJr);
                            o.a(z, this.fJp, this.fJr);
                            this.fJq.lO(0);
                            AppMethodBeat.o(58400);
                            return;
                        }
                        ab.i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", this.fJr, Integer.valueOf(this.fJp.vTR.jBw.size()), Integer.valueOf(this.fJp.jBT), Integer.valueOf(this.fJp.wIy));
                        this.fJs.ae(50, 50);
                        AppMethodBeat.o(58400);
                        return;
                    }
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = this.fJr;
            objArr[1] = Boolean.valueOf(g.RK());
            objArr[2] = Boolean.valueOf(com.tencent.mm.kernel.a.QT());
            g.RQ();
            objArr[3] = g.RP();
            ab.e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
            this.fJq.lO(0);
            AppMethodBeat.o(58400);
        }
    }

    public interface c {
        boolean c(Queue<c> queue);
    }

    public o() {
        AppMethodBeat.i(58414);
        AppMethodBeat.o(58414);
    }

    static /* synthetic */ void J(String str, boolean z) {
        AppMethodBeat.i(58427);
        assertTrue(str, z);
        AppMethodBeat.o(58427);
    }

    static /* synthetic */ boolean ahZ() {
        AppMethodBeat.i(58434);
        boolean ahS = ahS();
        AppMethodBeat.o(58434);
        return ahS;
    }

    static /* synthetic */ void f(o oVar) {
        AppMethodBeat.i(58429);
        oVar.ahY();
        AppMethodBeat.o(58429);
    }

    private static boolean XF() {
        AppMethodBeat.i(58415);
        if (com.tencent.mm.kernel.a.QT() || !g.RK()) {
            AppMethodBeat.o(58415);
            return false;
        } else if (fJf != null) {
            boolean booleanValue = fJf.booleanValue();
            AppMethodBeat.o(58415);
            return booleanValue;
        } else {
            fJf = Boolean.TRUE;
            AppMethodBeat.o(58415);
            return true;
        }
    }

    private static void assertTrue(String str, boolean z) {
        AppMethodBeat.i(58416);
        if (z) {
            AppMethodBeat.o(58416);
            return;
        }
        ab.e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
        Assert.assertTrue(str, z);
        AppMethodBeat.o(58416);
    }

    public final int a(long j, int i, String str) {
        AppMethodBeat.i(58417);
        ab.i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", Boolean.valueOf(XF()), Long.valueOf(j), Integer.valueOf(i), str);
        int i2 = 0;
        if ((256 & j) != 0) {
            com.tencent.mm.sdk.b.a.xxA.m(new rv());
        }
        if ((2097152 & j) != 0) {
            com.tencent.mm.sdk.b.a.xxA.m(new lx());
        }
        if ((128 & j) != 0) {
            com.tencent.mm.sdk.b.a.xxA.m(new so());
        }
        long j2 = ((-257 & j) & -2097153) & 95;
        if (j2 != 0 && g.RK()) {
            g.RQ();
            if (g.RP().Ry() != null) {
                ab.i("MicroMsg.SyncService", "ContinueFlag:%s", Long.valueOf(j2));
                g.RQ();
                g.RP().Ry().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = h(i, 7, false);
                } else {
                    m jVar = new j(i);
                    i2 = jVar.hashCode();
                    ab.i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(i2));
                    g.RQ();
                    if (!g.RO().eJo.a(jVar, 0)) {
                        ab.w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(i2));
                        i2 = 0;
                    }
                }
            }
        }
        if (!bo.isNullOrNil(str)) {
            ak akVar = new ak();
            akVar.cto.type = 3;
            akVar.cto.ctq = str;
            com.tencent.mm.sdk.b.a.xxA.m(akVar);
        }
        AppMethodBeat.o(58417);
        return i2;
    }

    public final void a(com.tencent.mm.protocal.t.b bVar, int i, long j) {
        AppMethodBeat.i(58418);
        ab.i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", Boolean.valueOf(XF()), bVar, Integer.valueOf(i), Long.valueOf(j));
        if (XF()) {
            a(new f(bVar, i, j));
            AppMethodBeat.o(58418);
            return;
        }
        g.RQ();
        g.RO().eJo.a(new j(bVar, i, j), 0);
        AppMethodBeat.o(58418);
    }

    public final int lN(int i) {
        AppMethodBeat.i(58419);
        ab.i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(XF()), Integer.valueOf(i), bo.dpG());
        int h;
        if (XF()) {
            h = h(i, 7, false);
            AppMethodBeat.o(58419);
            return h;
        }
        m jVar = new j(i);
        g.RQ();
        g.RO().eJo.a(jVar, 0);
        h = jVar.hashCode();
        AppMethodBeat.o(58419);
        return h;
    }

    private int h(int i, int i2, boolean z) {
        AppMethodBeat.i(58420);
        c eVar = new e(i, i2, z);
        a(eVar);
        int hashCode = eVar.hashCode();
        AppMethodBeat.o(58420);
        return hashCode;
    }

    private synchronized void sR(String str) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(58421);
            ab.i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.ecc, bo.dpG());
            if (this.ecc == null) {
                this.ecc = new WakerLock(ah.getContext(), "MicroMsg.SyncService", new IAutoUnlockCallback() {
                    public final void autoUnlockCallback() {
                        AppMethodBeat.i(58396);
                        ab.e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", o.this.fJj);
                        o.b(o.this.fJj);
                        AppMethodBeat.o(58396);
                    }
                });
            }
            String str2 = "lock";
            if (this.ecc.isLocking()) {
                z = false;
            }
            assertTrue(str2, z);
            if (!com.tencent.mm.sdk.a.b.foreground) {
                this.ecc.lock(30000, str);
            }
            AppMethodBeat.o(58421);
        }
    }

    private synchronized void ahY() {
        AppMethodBeat.i(58422);
        if (this.ecc == null || !this.ecc.isLocking()) {
            String str;
            String str2 = "MicroMsg.SyncService";
            String str3 = "wakeUnlock syncWakerLock locking?:%s foreground:%s";
            Object[] objArr = new Object[2];
            if (this.ecc == null) {
                str = BuildConfig.COMMAND;
            } else {
                str = Boolean.valueOf(this.ecc.isLocking());
            }
            objArr[0] = str;
            objArr[1] = Boolean.valueOf(com.tencent.mm.sdk.a.b.foreground);
            ab.w(str2, str3, objArr);
            AppMethodBeat.o(58422);
        } else {
            this.ecc.unLock();
            AppMethodBeat.o(58422);
        }
    }

    private void a(final c cVar) {
        AppMethodBeat.i(58423);
        if (k.ahT()) {
            ab.e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", cVar);
            AppMethodBeat.o(58423);
            return;
        }
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58397);
                if (cVar != null) {
                    if (cVar instanceof f) {
                        o.this.fJh.add(cVar);
                    } else {
                        o.this.fJg.add(cVar);
                    }
                }
                o.a(o.this, null);
                AppMethodBeat.o(58397);
            }
        });
        AppMethodBeat.o(58423);
    }

    private static boolean ahS() {
        AppMethodBeat.i(58424);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) ah.getContext().getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.o(58424);
            return booleanValue;
        } catch (Exception e) {
            com.tencent.mm.plugin.report.e.pXa.a(99, 45, 1, false);
            ab.e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.TRUE, bo.l(e));
            AppMethodBeat.o(58424);
            return true;
        }
    }
}
