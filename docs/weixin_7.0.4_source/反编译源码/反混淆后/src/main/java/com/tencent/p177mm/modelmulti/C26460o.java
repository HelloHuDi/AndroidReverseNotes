package com.tencent.p177mm.modelmulti;

import android.os.PowerManager;
import com.tencent.mars.comm.WakerLock;
import com.tencent.mars.comm.WakerLock.IAutoUnlockCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C37617g;
import com.tencent.p177mm.hardcoder.WXHardCoderJNI;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.model.C1839cb;
import com.tencent.p177mm.modelmulti.C42215j.C42216a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C32597lx;
import com.tencent.p177mm.p230g.p231a.C42059so;
import com.tencent.p177mm.p230g.p231a.C45364rv;
import com.tencent.p177mm.p230g.p231a.C6459ak;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.platformtools.C1947ae;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.C44038c;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C30256t.C23473a;
import com.tencent.p177mm.protocal.C30256t.C7290b;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C35956tc;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.bej;
import com.tencent.p177mm.protocal.protobuf.bek;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelmulti.o */
public final class C26460o {
    private static Boolean fJf = null;
    private WakerLock ecc = null;
    public Queue<C26464c> fJg = new LinkedList();
    public Queue<C26464c> fJh = new LinkedList();
    private HashMap<C26464c, Long> fJi = new HashMap();
    public C26464c fJj = null;
    private long fJk = 0;

    /* renamed from: com.tencent.mm.modelmulti.o$d */
    class C1860d implements C26464c {
        C1860d() {
        }

        /* renamed from: c */
        public final boolean mo5436c(Queue<C26464c> queue) {
            AppMethodBeat.m2504i(58402);
            PInt pInt = new PInt();
            C1720g.m3537RQ();
            C1720g.m3534RN();
            byte[] a = C37617g.m63509a(pInt, C1668a.m3383QF());
            String str = "MicroMsg.SyncService";
            String str2 = "%s index:%d, buf.len:%d ";
            Object[] objArr = new Object[3];
            objArr[0] = this;
            objArr[1] = Integer.valueOf(pInt.value);
            objArr[2] = Integer.valueOf(a != null ? a.length : -1);
            C4990ab.m7417i(str, str2, objArr);
            if (pInt.value == 0 || C5046bo.m7540cb(a)) {
                AppMethodBeat.m2505o(58402);
                return false;
            }
            final int i = pInt.value;
            bek bek = null;
            try {
                C7290b c7290b = new C7290b();
                c7290b.mo5744P(a);
                bek = c7290b.vyH;
            } catch (Exception e) {
                C7053e.pXa.mo8378a(99, 38, 1, false);
                C4990ab.m7413e("MicroMsg.SyncService", "%s index:%s Resp fromProtoBuf failed e[%s]", this, Integer.valueOf(i), e.getMessage());
                C1720g.m3537RQ();
                C1720g.m3534RN();
                C37617g.m63510bO(i, C1668a.m3383QF());
            } catch (Error e2) {
                C7053e.pXa.mo8378a(99, 39, 1, false);
                long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
                long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
                C4990ab.m7417i("MicroMsg.SyncService", "%s index:%s memoryInfo avail/total, dalvik[%dk, %dk, user:%dk] Error[%s]", this, Integer.valueOf(i), Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory), e2.getMessage());
                C1720g.m3537RQ();
                C1720g.m3534RN();
                C37617g.m63510bO(i, C1668a.m3383QF());
            }
            if (bek == null) {
                AppMethodBeat.m2505o(58402);
                return false;
            }
            C7053e.pXa.mo8378a(99, 20, 1, false);
            C26462a c26462a = new C26462a(C26460o.this, this, true, bek, new C26461b() {
                /* renamed from: lO */
                public final boolean mo5435lO(int i) {
                    AppMethodBeat.m2504i(58401);
                    C4990ab.m7417i("MicroMsg.SyncService", "%s onFinishCmd index:%s ", C1860d.this, Integer.valueOf(i));
                    int i2 = i;
                    C1720g.m3537RQ();
                    C1720g.m3534RN();
                    C37617g.m63510bO(i2, C1668a.m3383QF());
                    C26460o.m42147a(C26460o.this, C1860d.this);
                    AppMethodBeat.m2505o(58401);
                    return true;
                }
            }, (byte) 0);
            AppMethodBeat.m2505o(58402);
            return true;
        }

        public final String toString() {
            AppMethodBeat.m2504i(58403);
            String str = "LightPush[" + hashCode() + "]";
            AppMethodBeat.m2505o(58403);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.o$e */
    class C6678e extends C1207m implements C26464c, C1918k {
        int fHJ;
        C1202f fJv;
        boolean fJw;
        private boolean fJx = false;
        private C1929q ftU;
        int scene;

        /* renamed from: c */
        public final boolean mo5436c(Queue<C26464c> queue) {
            String str;
            AppMethodBeat.m2504i(58405);
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
            C4990ab.m7417i(str2, str3, objArr);
            if (queue != null) {
                C26460o.m42154b((Queue) queue);
                boolean z = false;
                boolean z2 = false;
                while (!queue.isEmpty()) {
                    C6678e c6678e = (C6678e) queue.poll();
                    this.fHJ |= c6678e.fHJ;
                    if (c6678e.scene == 3) {
                        z = true;
                    } else if (c6678e.fJw) {
                        z2 = true;
                    }
                    C4990ab.m7417i("MicroMsg.SyncService", "%s pop:%s[%s] scene:%s selector:%s iscontinue:%s hashcont:%s hasBgfg:%s", this, Integer.valueOf(queue.size()), c6678e, Integer.valueOf(c6678e.scene), Integer.valueOf(c6678e.fHJ), Boolean.valueOf(c6678e.fJw), Boolean.valueOf(z2), Boolean.valueOf(z));
                }
                if (z) {
                    this.scene = 3;
                } else if (z2) {
                    this.scene = 6;
                }
            }
            if (C1720g.m3531RK() && !C1668a.m3393QT()) {
                C1720g.m3537RQ();
                if (C1720g.m3536RP() != null) {
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP().mo5239Ry() != null) {
                        C1720g.m3537RQ();
                        long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(8196, null), 0);
                        if (a != 0) {
                            C1720g.m3537RQ();
                            C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf(0));
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
                        this.ftU = new C42216a();
                        bej bej = ((C23473a) this.ftU.acF()).vyG;
                        bej.wIx = i;
                        bej.vTN = this.fHJ;
                        bej.Scene = this.scene;
                        C1720g.m3537RQ();
                        bej.vTO = C1946aa.m4152ad(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, new byte[0]))));
                        bej.wIw = new C35956tc();
                        bej.vIk = C7243d.eSg;
                        C4990ab.m7417i("MicroMsg.SyncService", "%s continueFlag:%s SyncMsgDigest:%s Selector:%d Scene:%d device:%s", this, Long.valueOf(a), Integer.valueOf(bej.wIx), Integer.valueOf(bej.vTN), Integer.valueOf(this.scene), bej.vIk);
                        C4990ab.m7417i("MicroMsg.SyncService", "%s Req synckey %s", this, C44098aa.m79381bP(C5046bo.anf(str)));
                        C26460o.m42146a(this);
                        C1720g.m3537RQ();
                        if (C1720g.m3535RO().eJo.mo14541a((C1207m) this, 0)) {
                            AppMethodBeat.m2505o(58405);
                            return true;
                        }
                        C7053e.pXa.mo8381e(11098, Integer.valueOf(3500), this.scene + ";" + C4872b.foreground + ";" + C26460o.ahZ());
                        C4990ab.m7413e("MicroMsg.SyncService", "%s NetSceneQueue doScene failed. ", this);
                        C7053e.pXa.mo8378a(99, 41, 1, false);
                        AppMethodBeat.m2505o(58405);
                        return false;
                    }
                }
            }
            Object[] objArr2 = new Object[4];
            objArr2[0] = this;
            objArr2[1] = Boolean.valueOf(C1720g.m3531RK());
            objArr2[2] = Boolean.valueOf(C1668a.m3393QT());
            C1720g.m3537RQ();
            objArr2[3] = C1720g.m3536RP();
            C4990ab.m7413e("MicroMsg.SyncService", "%s accready:%s hold:%s accstg:%s ", objArr2);
            AppMethodBeat.m2505o(58405);
            return false;
        }

        public final String toString() {
            AppMethodBeat.m2504i(58406);
            String str = "NetSync[" + hashCode() + "]";
            AppMethodBeat.m2505o(58406);
            return str;
        }

        public C6678e(int i, int i2, boolean z) {
            this.scene = i;
            this.fHJ = i2;
            this.fJw = z;
        }

        public final int getType() {
            return 138;
        }

        /* renamed from: a */
        public final int mo4456a(C1902e c1902e, C1202f c1202f) {
            AppMethodBeat.m2504i(58407);
            this.fJv = c1202f;
            int a = mo4457a(c1902e, this.ftU, this);
            AppMethodBeat.m2505o(58407);
            return a;
        }

        public final boolean acM() {
            return false;
        }

        /* renamed from: a */
        public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
            AppMethodBeat.m2504i(58408);
            if (c1929q == null || c1929q.getType() != 138) {
                C7053e.pXa.mo8378a(99, 44, 1, false);
                String str2 = "MicroMsg.SyncService";
                String str3 = "%s onGYNetEnd error type:%d";
                Object[] objArr = new Object[2];
                objArr[0] = this;
                objArr[1] = Integer.valueOf(c1929q == null ? -2 : c1929q.getType());
                C4990ab.m7413e(str2, str3, objArr);
                AppMethodBeat.m2505o(58408);
            } else if (this.fJx) {
                C4990ab.m7413e("MicroMsg.SyncService", "%s onGYNetEnd has been callback  , give up  ", this);
                AppMethodBeat.m2505o(58408);
            } else {
                boolean z;
                int doL;
                this.fJx = true;
                C26460o.m42139J("Check rr failed.", c1929q == this.ftU);
                if (i2 == 0 && i3 == 0) {
                    z = true;
                } else {
                    C4990ab.m7413e("MicroMsg.SyncService", "%s onGYNetEnd scene error Callback [%s,%s,%s ] rr:%s", this, Integer.valueOf(i2), Integer.valueOf(i3), str, c1929q);
                    if (i2 == 4 && i3 == -2006) {
                        C4990ab.m7421w("MicroMsg.SyncService", "%s onGYNetEnd MM_ERR_KEYBUF_INVALID , not merge key buf", this);
                        C7053e.pXa.mo8378a(99, 42, 1, false);
                        z = false;
                    } else {
                        C7053e.pXa.mo8381e(11098, Integer.valueOf(3501), this.scene + ";" + i2 + ";" + i3 + ";" + C4872b.foreground + ";" + C26460o.ahZ());
                        C7053e.pXa.mo8378a(99, 43, 1, false);
                        this.fJv.onSceneEnd(i2, i3, str, this);
                        C26460o.m42147a(C26460o.this, (C26464c) this);
                        AppMethodBeat.m2505o(58408);
                        return;
                    }
                }
                bek bek = ((C7290b) c1929q.mo5618ZS()).vyH;
                boolean z2 = WXHardCoderJNI.hcReceiveMsgEnable;
                int i4 = WXHardCoderJNI.hcReceiveMsgDelay;
                int i5 = WXHardCoderJNI.hcReceiveMsgCPU;
                int i6 = WXHardCoderJNI.hcReceiveMsgIO;
                if (WXHardCoderJNI.hcReceiveMsgThr) {
                    doL = C1720g.m3539RS().doL();
                } else {
                    doL = 0;
                }
                i4 = WXHardCoderJNI.startPerformance(z2, i4, i5, i6, doL, WXHardCoderJNI.hcReceiveMsgTimeout, 201, WXHardCoderJNI.hcReceiveMsgAction, "MicroMsg.SyncService");
                final bek bek2 = bek;
                C26462a c26462a = new C26462a(C26460o.this, this, z, bek, new C26461b() {
                    /* renamed from: lO */
                    public final boolean mo5435lO(int i) {
                        AppMethodBeat.m2504i(58404);
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf((long) bek2.vQe));
                        boolean z = (bek2.vQe & C6678e.this.fHJ) != 0;
                        C4990ab.m7417i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag:%s canCont:%s SNSSYNCKEY:%s StorySyncKey:%s  NetSceneMinSync.this.selecto:%s", C6678e.this, Integer.valueOf(bek2.vQe), Boolean.valueOf(z), Integer.valueOf(bek2.vQe & 256), Integer.valueOf(bek2.vQe & 128), Integer.valueOf(C6678e.this.fHJ));
                        if (!(z || (bek2.vQe & 256) == 0)) {
                            C45364rv c45364rv = new C45364rv();
                            c45364rv.cNO.cvp = 3;
                            C4879a.xxA.mo10055m(c45364rv);
                        }
                        if (!(z || (bek2.vQe & 2097152) == 0)) {
                            C4879a.xxA.mo10055m(new C32597lx());
                        }
                        if (!(z || (bek2.vQe & 128) == 0)) {
                            C4879a.xxA.mo10055m(new C42059so());
                        }
                        if (z) {
                            if (i == 0 && C6678e.this.fJw) {
                                C4990ab.m7421w("MicroMsg.SyncService", "%s onFinishCmd is continue Sync , but no Cmd , I will not continue again.", C6678e.this);
                            } else {
                                C26460o.m42141a(C26460o.this, C6678e.this.scene, C6678e.this.fHJ);
                            }
                        }
                        C6678e.this.fJv.onSceneEnd(0, 0, "", C6678e.this);
                        C26460o.m42147a(C26460o.this, C6678e.this);
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcReceiveMsgEnable, i4);
                        AppMethodBeat.m2505o(58404);
                        return true;
                    }
                }, (byte) 0);
                AppMethodBeat.m2505o(58408);
            }
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.o$f */
    class C9697f implements C26464c {
        int fHK;
        long fJB;
        bek fJp;

        /* renamed from: com.tencent.mm.modelmulti.o$f$1 */
        class C96981 implements C26461b {
            C96981() {
            }

            /* renamed from: lO */
            public final boolean mo5435lO(int i) {
                AppMethodBeat.m2504i(58409);
                C4990ab.m7417i("MicroMsg.SyncService", "%s onFinishCmd resp:%s pushSycnFlag:%s recvTime:%s", C9697f.this, C9697f.this.fJp, Integer.valueOf(C9697f.this.fHK), Long.valueOf(C9697f.this.fJB));
                if ((C9697f.this.fHK & 1) > 0) {
                    C1720g.m3537RQ();
                    C1720g.m3540Rg().mo14541a(new C26448f(C9697f.this.fJB, C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)))), 0);
                }
                C26460o.m42147a(C26460o.this, C9697f.this);
                AppMethodBeat.m2505o(58409);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.modelmulti.o$f$2 */
        class C96992 implements Runnable {
            C96992() {
            }

            public final void run() {
                AppMethodBeat.m2504i(58410);
                C4990ab.m7417i("MicroMsg.SyncService", "%s onFinishCmd ContinueFlag[%s]", C9697f.this, Integer.valueOf(C9697f.this.fJp.vQe));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf((long) C9697f.this.fJp.vQe));
                if ((C9697f.this.fJp.vQe & 256) != 0) {
                    C45364rv c45364rv = new C45364rv();
                    c45364rv.cNO.cvp = 2;
                    C4879a.xxA.mo10055m(c45364rv);
                    C7053e.pXa.mo8378a(99, 22, 1, false);
                    C4990ab.m7417i("MicroMsg.SyncService", "%s onFinishCmd publish SnsSyncEvent", C9697f.this);
                }
                AppMethodBeat.m2505o(58410);
            }
        }

        public C9697f(C7290b c7290b, int i, long j) {
            AppMethodBeat.m2504i(58411);
            this.fJp = c7290b == null ? null : c7290b.vyH;
            this.fJB = j;
            this.fHK = i;
            AppMethodBeat.m2505o(58411);
        }

        /* renamed from: c */
        public final boolean mo5436c(Queue<C26464c> queue) {
            AppMethodBeat.m2504i(58412);
            if (this.fJp == null) {
                C7053e.pXa.mo8378a(99, 40, 1, false);
                C4990ab.m7413e("MicroMsg.SyncService", "%s run resp == null", this);
                AppMethodBeat.m2505o(58412);
                return false;
            } else if (10018 == C1947ae.giz) {
                C4990ab.m7413e("MicroMsg.SyncService", "%s Give up for test", this);
                AppMethodBeat.m2505o(58412);
                return false;
            } else {
                C26462a c26462a = new C26462a(C26460o.this, this, true, this.fJp, new C96981(), (byte) 0);
                C1720g.m3539RS().mo10310m(new C96992(), 100);
                C7053e.pXa.mo8378a(99, 21, 1, false);
                AppMethodBeat.m2505o(58412);
                return true;
            }
        }

        public final String toString() {
            AppMethodBeat.m2504i(58413);
            String str = "NotifyData[" + hashCode() + "]";
            AppMethodBeat.m2505o(58413);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.o$1 */
    class C264581 implements IAutoUnlockCallback {
        C264581() {
        }

        public final void autoUnlockCallback() {
            AppMethodBeat.m2504i(58396);
            C4990ab.m7413e("MicroMsg.SyncService", "ERROR: %s auto unlock syncWakerLock", C26460o.this.fJj);
            C26460o.m42153b(C26460o.this.fJj);
            AppMethodBeat.m2505o(58396);
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.o$b */
    interface C26461b {
        /* renamed from: lO */
        boolean mo5435lO(int i);
    }

    /* renamed from: com.tencent.mm.modelmulti.o$a */
    class C26462a {
        int fHZ;
        boolean fJo;
        bek fJp;
        C26461b fJq;
        C26464c fJr;
        C7564ap fJs;

        /* renamed from: com.tencent.mm.modelmulti.o$a$1 */
        class C264631 implements C5015a {
            C264631() {
            }

            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(58399);
                if (C1720g.m3531RK() && !C1668a.m3393QT()) {
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP() != null) {
                        C1720g.m3537RQ();
                        if (C1720g.m3536RP().mo5239Ry() != null) {
                            LinkedList linkedList = C26462a.this.fJp.vTR.jBw;
                            C44038c c44038c = new C44038c();
                            c44038c.mo69729ca(C26462a.this.fJr);
                            long anU = C5046bo.anU();
                            while (C26462a.this.fHZ < linkedList.size()) {
                                linkedList.size();
                                if (!c44038c.mo69728a((C40573tb) linkedList.get(C26462a.this.fHZ), false)) {
                                    C7053e.pXa.mo8378a(99, 46, 1, false);
                                }
                                C26462a c26462a = C26462a.this;
                                c26462a.fHZ++;
                                C4990ab.m7417i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s", C26462a.this.fJr, Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(linkedList.size()), Integer.valueOf(C26462a.this.fHZ - 1));
                                if (C5046bo.m7566gb(anU) >= 500) {
                                    break;
                                }
                            }
                            c44038c.mo69730cc(C26462a.this.fJr);
                            if (C26462a.this.fHZ < linkedList.size()) {
                                C4990ab.m7417i("MicroMsg.SyncService", "processResp %s time:%s size:%s index:%s Shold Continue.", C26462a.this.fJr, Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(linkedList.size()), Integer.valueOf(C26462a.this.fHZ - 1));
                                AppMethodBeat.m2505o(58399);
                                return true;
                            }
                            C26460o.m42150a(C26462a.this.fJo, C26462a.this.fJp, C26462a.this.fJr);
                            C26462a.this.fJq.mo5435lO(linkedList.size());
                            AppMethodBeat.m2505o(58399);
                            return false;
                        }
                    }
                }
                Object[] objArr = new Object[4];
                objArr[0] = C26462a.this.fJr;
                objArr[1] = Boolean.valueOf(C1720g.m3531RK());
                objArr[2] = Boolean.valueOf(C1668a.m3393QT());
                C1720g.m3537RQ();
                objArr[3] = C1720g.m3536RP();
                C4990ab.m7413e("MicroMsg.SyncService", "processResp %s accready:%s hold:%s accstg:%s ", objArr);
                C26462a.this.fJq.mo5435lO(0);
                AppMethodBeat.m2505o(58399);
                return false;
            }
        }

        /* synthetic */ C26462a(C26460o c26460o, C26464c c26464c, boolean z, bek bek, C26461b c26461b, byte b) {
            this(c26464c, z, bek, c26461b);
        }

        private C26462a(C26464c c26464c, boolean z, bek bek, C26461b c26461b) {
            AppMethodBeat.m2504i(58400);
            this.fHZ = 0;
            this.fJo = false;
            this.fJp = null;
            this.fJq = null;
            this.fJs = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C264631(), true);
            this.fJq = c26461b;
            this.fJr = c26464c;
            this.fJo = z;
            this.fJp = bek;
            this.fHZ = 0;
            String str = "";
            boolean z2 = (this.fJq == null || this.fJr == null) ? false : true;
            C26460o.m42139J(str, z2);
            if (this.fJp == null) {
                C26460o.m42139J("resp Not null", false);
                C4990ab.m7421w("MicroMsg.SyncService", "CmdProcHandler %s NewSyncResponse is null", this.fJr);
                this.fJq.mo5435lO(0);
                AppMethodBeat.m2505o(58400);
                return;
            }
            if (C1720g.m3531RK() && !C1668a.m3393QT()) {
                C1720g.m3537RQ();
                if (C1720g.m3536RP() != null) {
                    C1720g.m3537RQ();
                    if (C1720g.m3536RP().mo5239Ry() != null) {
                        C26460o.m42149a(bek);
                        long j = (long) bek.wIz;
                        if (String.valueOf(j).length() == 10) {
                            j *= 1000;
                        }
                        long currentTimeMillis = System.currentTimeMillis() - j;
                        long j2 = currentTimeMillis / 1000;
                        C4990ab.m7417i("MicroMsg.SyncService", "[oneliang] client time is:%s,server time is:%s,diff time is:%s, diff second time is:%s,just save millisecond diff time", Long.valueOf(System.currentTimeMillis()), Long.valueOf(j), Long.valueOf(currentTimeMillis), Long.valueOf(j2));
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_CLIENT_SERVER_DIFF_TIME_LONG, Long.valueOf(currentTimeMillis));
                        C1839cb.m3785fo(j);
                        C1720g.m3537RQ();
                        C1720g.m3534RN().mo5163cd(this.fJp.jBT, this.fJp.wIy);
                        C1720g.m3537RQ();
                        C1720g.m3534RN();
                        C1668a.m3403jO(this.fJp.jBT);
                        if (this.fJp.vTR == null || this.fJp.vTR.jBw == null || this.fJp.vTR.jBw.size() <= 0) {
                            C4990ab.m7421w("MicroMsg.SyncService", "CmdProcHandler %s cmdlist is null.  synckey may be changed, I have to merge it.", this.fJr);
                            C26460o.m42150a(z, this.fJp, this.fJr);
                            this.fJq.mo5435lO(0);
                            AppMethodBeat.m2505o(58400);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.SyncService", "CmdProcHandler %s Start docmd:%s respStatus:%s respOnlineVer:%s", this.fJr, Integer.valueOf(this.fJp.vTR.jBw.size()), Integer.valueOf(this.fJp.jBT), Integer.valueOf(this.fJp.wIy));
                        this.fJs.mo16770ae(50, 50);
                        AppMethodBeat.m2505o(58400);
                        return;
                    }
                }
            }
            Object[] objArr = new Object[4];
            objArr[0] = this.fJr;
            objArr[1] = Boolean.valueOf(C1720g.m3531RK());
            objArr[2] = Boolean.valueOf(C1668a.m3393QT());
            C1720g.m3537RQ();
            objArr[3] = C1720g.m3536RP();
            C4990ab.m7413e("MicroMsg.SyncService", "CmdProcHandler %s accready:%s hold:%s accstg:%s ", objArr);
            this.fJq.mo5435lO(0);
            AppMethodBeat.m2505o(58400);
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.o$c */
    public interface C26464c {
        /* renamed from: c */
        boolean mo5436c(Queue<C26464c> queue);
    }

    public C26460o() {
        AppMethodBeat.m2504i(58414);
        AppMethodBeat.m2505o(58414);
    }

    /* renamed from: J */
    static /* synthetic */ void m42139J(String str, boolean z) {
        AppMethodBeat.m2504i(58427);
        C26460o.assertTrue(str, z);
        AppMethodBeat.m2505o(58427);
    }

    static /* synthetic */ boolean ahZ() {
        AppMethodBeat.m2504i(58434);
        boolean ahS = C26460o.ahS();
        AppMethodBeat.m2505o(58434);
        return ahS;
    }

    /* renamed from: f */
    static /* synthetic */ void m42159f(C26460o c26460o) {
        AppMethodBeat.m2504i(58429);
        c26460o.ahY();
        AppMethodBeat.m2505o(58429);
    }

    /* renamed from: XF */
    private static boolean m42140XF() {
        AppMethodBeat.m2504i(58415);
        if (C1668a.m3393QT() || !C1720g.m3531RK()) {
            AppMethodBeat.m2505o(58415);
            return false;
        } else if (fJf != null) {
            boolean booleanValue = fJf.booleanValue();
            AppMethodBeat.m2505o(58415);
            return booleanValue;
        } else {
            fJf = Boolean.TRUE;
            AppMethodBeat.m2505o(58415);
            return true;
        }
    }

    private static void assertTrue(String str, boolean z) {
        AppMethodBeat.m2504i(58416);
        if (z) {
            AppMethodBeat.m2505o(58416);
            return;
        }
        C4990ab.m7413e("MicroMsg.SyncService", "ASSERT now msg:%s", str);
        Assert.assertTrue(str, z);
        AppMethodBeat.m2505o(58416);
    }

    /* renamed from: a */
    public final int mo44214a(long j, int i, String str) {
        AppMethodBeat.m2504i(58417);
        C4990ab.m7417i("MicroMsg.SyncService", "dealWithSelectoru checkUse:%s selector:%d aiScene:%d xml:%s ", Boolean.valueOf(C26460o.m42140XF()), Long.valueOf(j), Integer.valueOf(i), str);
        int i2 = 0;
        if ((256 & j) != 0) {
            C4879a.xxA.mo10055m(new C45364rv());
        }
        if ((2097152 & j) != 0) {
            C4879a.xxA.mo10055m(new C32597lx());
        }
        if ((128 & j) != 0) {
            C4879a.xxA.mo10055m(new C42059so());
        }
        long j2 = ((-257 & j) & -2097153) & 95;
        if (j2 != 0 && C1720g.m3531RK()) {
            C1720g.m3537RQ();
            if (C1720g.m3536RP().mo5239Ry() != null) {
                C4990ab.m7417i("MicroMsg.SyncService", "ContinueFlag:%s", Long.valueOf(j2));
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf(j2));
                if (r1) {
                    i2 = m42160h(i, 7, false);
                } else {
                    C1207m c42215j = new C42215j(i);
                    i2 = c42215j.hashCode();
                    C4990ab.m7417i("MicroMsg.SyncService", "dealWithSelector syncHash: %d", Integer.valueOf(i2));
                    C1720g.m3537RQ();
                    if (!C1720g.m3535RO().eJo.mo14541a(c42215j, 0)) {
                        C4990ab.m7421w("MicroMsg.SyncService", "dealWithSelector doScene failed, hash: %d, zero hash will be return.", Integer.valueOf(i2));
                        i2 = 0;
                    }
                }
            }
        }
        if (!C5046bo.isNullOrNil(str)) {
            C6459ak c6459ak = new C6459ak();
            c6459ak.cto.type = 3;
            c6459ak.cto.ctq = str;
            C4879a.xxA.mo10055m(c6459ak);
        }
        AppMethodBeat.m2505o(58417);
        return i2;
    }

    /* renamed from: a */
    public final void mo44215a(C7290b c7290b, int i, long j) {
        AppMethodBeat.m2504i(58418);
        C4990ab.m7417i("MicroMsg.SyncService", "triggerNotifyDataSync checkUse:%s resp:%s syncflag:%s recvtime:%s", Boolean.valueOf(C26460o.m42140XF()), c7290b, Integer.valueOf(i), Long.valueOf(j));
        if (C26460o.m42140XF()) {
            m42144a(new C9697f(c7290b, i, j));
            AppMethodBeat.m2505o(58418);
            return;
        }
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(new C42215j(c7290b, i, j), 0);
        AppMethodBeat.m2505o(58418);
    }

    /* renamed from: lN */
    public final int mo44216lN(int i) {
        AppMethodBeat.m2504i(58419);
        C4990ab.m7417i("MicroMsg.SyncService", "triggerSync checkUse:%s scene:%s [%s]", Boolean.valueOf(C26460o.m42140XF()), Integer.valueOf(i), C5046bo.dpG());
        int h;
        if (C26460o.m42140XF()) {
            h = m42160h(i, 7, false);
            AppMethodBeat.m2505o(58419);
            return h;
        }
        C1207m c42215j = new C42215j(i);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c42215j, 0);
        h = c42215j.hashCode();
        AppMethodBeat.m2505o(58419);
        return h;
    }

    /* renamed from: h */
    private int m42160h(int i, int i2, boolean z) {
        AppMethodBeat.m2504i(58420);
        C26464c c6678e = new C6678e(i, i2, z);
        m42144a(c6678e);
        int hashCode = c6678e.hashCode();
        AppMethodBeat.m2505o(58420);
        return hashCode;
    }

    /* renamed from: sR */
    private synchronized void m42161sR(String str) {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.m2504i(58421);
            C4990ab.m7417i("MicroMsg.SyncService", "wakelock tag:%s syncWakerLock:%s [%s]", str, this.ecc, C5046bo.dpG());
            if (this.ecc == null) {
                this.ecc = new WakerLock(C4996ah.getContext(), "MicroMsg.SyncService", new C264581());
            }
            String str2 = "lock";
            if (this.ecc.isLocking()) {
                z = false;
            }
            C26460o.assertTrue(str2, z);
            if (!C4872b.foreground) {
                this.ecc.lock(30000, str);
            }
            AppMethodBeat.m2505o(58421);
        }
    }

    private synchronized void ahY() {
        AppMethodBeat.m2504i(58422);
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
            objArr[1] = Boolean.valueOf(C4872b.foreground);
            C4990ab.m7421w(str2, str3, objArr);
            AppMethodBeat.m2505o(58422);
        } else {
            this.ecc.unLock();
            AppMethodBeat.m2505o(58422);
        }
    }

    /* renamed from: a */
    private void m42144a(final C26464c c26464c) {
        AppMethodBeat.m2504i(58423);
        if (C37942k.ahT()) {
            C4990ab.m7413e("MicroMsg.SyncService", "tryStart dkinit never do sync before init done :%s ", c26464c);
            AppMethodBeat.m2505o(58423);
            return;
        }
        C1720g.m3539RS().mo10302aa(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(58397);
                if (c26464c != null) {
                    if (c26464c instanceof C9697f) {
                        C26460o.this.fJh.add(c26464c);
                    } else {
                        C26460o.this.fJg.add(c26464c);
                    }
                }
                C26460o.m42147a(C26460o.this, null);
                AppMethodBeat.m2505o(58397);
            }
        });
        AppMethodBeat.m2505o(58423);
    }

    private static boolean ahS() {
        AppMethodBeat.m2504i(58424);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) C4996ah.getContext().getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.m2505o(58424);
            return booleanValue;
        } catch (Exception e) {
            C7053e.pXa.mo8378a(99, 45, 1, false);
            C4990ab.m7413e("MicroMsg.SyncService", "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.TRUE, C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58424);
            return true;
        }
    }
}
