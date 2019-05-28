package com.tencent.p177mm.modelmulti;

import android.os.PowerManager;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.booter.C37617g;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.compatible.util.C1448h;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1207m.C1206b;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.p230g.p231a.C32597lx;
import com.tencent.p177mm.p230g.p231a.C45364rv;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.plugin.zero.C44038c;
import com.tencent.p177mm.pointers.PInt;
import com.tencent.p177mm.protocal.C30256t.C23473a;
import com.tencent.p177mm.protocal.C30256t.C7290b;
import com.tencent.p177mm.protocal.C44098aa;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.C7243d;
import com.tencent.p177mm.protocal.protobuf.C35956tc;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.bej;
import com.tencent.p177mm.sdk.p599a.C4872b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5007an;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import com.tencent.view.C31128d;
import java.util.LinkedList;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelmulti.j */
public final class C42215j extends C1207m implements C1918k {
    protected static int fHJ = 7;
    private static int fIB = 0;
    private static boolean fIy = false;
    public String TAG;
    private String aIm;
    private C1446a eOm;
    private C1202f ehi;
    private int errCode;
    private int errType;
    private int fHK;
    private long fHM;
    private boolean fHN;
    private C7564ap fIA;
    private int fIC;
    private boolean fID;
    private String fIE;
    public C7290b fIF;
    private long fIG;
    private boolean fIa;
    public C18670p fIx;
    private boolean fIz;
    private C7564ap frk;

    /* renamed from: com.tencent.mm.modelmulti.j$3 */
    class C186673 implements C5015a {
        private int fIJ = 0;
        private long fIK = 0;
        private int fIL = 0;

        C186673() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(58381);
            C44038c c44038c = new C44038c();
            if (!C1720g.m3531RK()) {
                C4990ab.m7413e(C42215j.this.TAG, "syncRespHandler acc is not ready STOP :%s", C42215j.this.fIF);
                C42215j.this.fIF = null;
                AppMethodBeat.m2505o(58381);
                return false;
            } else if (C42215j.this.fIa) {
                c44038c.mo69731cd(C42215j.this);
                C42215j.this.fIF = null;
                AppMethodBeat.m2505o(58381);
                return false;
            } else if (C42215j.this.fIF == null || C42215j.this.fIF.vyH.vTR == null || C42215j.this.fIF.vyH.vTR.jBw == null) {
                C4990ab.m7413e(C42215j.this.TAG, "syncRespHandler CmdList is null! Stop Processing :%s", C42215j.this.fIF);
                c44038c.mo69731cd(C42215j.this);
                C42215j.this.fIF = null;
                AppMethodBeat.m2505o(58381);
                return false;
            } else {
                LinkedList linkedList = C42215j.this.fIF.vyH.vTR.jBw;
                c44038c.mo69729ca(C42215j.this);
                this.fIL++;
                long anU = C5046bo.anU();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < 5) {
                        if (this.fIJ < linkedList.size()) {
                            C4990ab.m7419v(C42215j.this.TAG, "syncRespHandler i:%d curidx:%d size:%d cmdid:%d cmdbuf:%d", Integer.valueOf(i2), Integer.valueOf(this.fIJ), Integer.valueOf(linkedList.size()), Integer.valueOf(((C40573tb) linkedList.get(this.fIJ)).wat), Integer.valueOf(((C40573tb) linkedList.get(this.fIJ)).wau.getILen()));
                            linkedList.size();
                            if (!c44038c.mo69728a((C40573tb) linkedList.get(this.fIJ), false)) {
                                C4990ab.m7421w(C42215j.this.TAG, "DoCmd Failed index:%d", Integer.valueOf(this.fIJ));
                            }
                            this.fIJ++;
                        }
                        if (this.fIJ >= linkedList.size()) {
                            this.fIK += C5046bo.m7566gb(anU);
                            C4990ab.m7417i(C42215j.this.TAG, "syncRespHandler process DONE idx:%d size:%d time[%d,%d] count:%d %s", Integer.valueOf(this.fIJ), Integer.valueOf(linkedList.size()), Long.valueOf(C5046bo.m7566gb(C42215j.this.fIG)), Long.valueOf(this.fIK), Integer.valueOf(this.fIL), C42215j.this.fIF);
                            C42215j.this.mo67744a(C42215j.this.fIF);
                            c44038c.mo69730cc(C42215j.this);
                            C7053e.pXa.mo8378a(99, (long) C5046bo.m7567h((Integer) C7053e.m11772a((int) this.fIK, new int[]{100, 300, 1000, AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS}, new Integer[]{Integer.valueOf(240), Integer.valueOf(C31128d.MIC_PTU_SHISHANG2), Integer.valueOf(C31128d.MIC_PTU_SHIGUANG), Integer.valueOf(C31128d.MIC_PTU_LENGMEIREN), Integer.valueOf(236)})), 1, false);
                            C7053e.pXa.mo8378a(99, (long) C5046bo.m7567h((Integer) C7053e.m11772a(linkedList.size(), new int[]{0, 1, 2, 3, 5, 10}, new Integer[]{Integer.valueOf(249), Integer.valueOf(C31128d.MIC_PTU_ZIPAI_THURSDAY), Integer.valueOf(247), Integer.valueOf(C31128d.MIC_PTU_ZIPAI_FAIRYTALE), Integer.valueOf(C31128d.MIC_PTU_ZIPAI_LIGHTWHITE), Integer.valueOf(244), Integer.valueOf(243)})), 1, false);
                            C7053e.pXa.mo8378a(99, C4872b.foreground ? 241 : 242, 1, false);
                            C7053e.pXa.mo8378a(99, (long) C42215j.this.fIC, 1, false);
                            C7053e.pXa.mo8378a(99, 0, 1, false);
                            C7053e c7053e = C7053e.pXa;
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(linkedList.size());
                            objArr[1] = Long.valueOf(r10);
                            objArr[2] = Integer.valueOf(C42215j.this.fIC);
                            objArr[3] = Integer.valueOf(C42215j.this.fIF.vyH.vQe);
                            objArr[4] = Long.valueOf(this.fIK);
                            objArr[5] = Integer.valueOf(this.fIL);
                            objArr[6] = C42215j.this.fIE;
                            objArr[7] = Integer.valueOf(C4872b.foreground ? 1 : 2);
                            c7053e.mo8381e(12063, objArr);
                            C42215j.this.fIF = null;
                            AppMethodBeat.m2505o(58381);
                            return false;
                        }
                        if (C5046bo.m7566gb(anU) > 500) {
                            C4990ab.m7411d(C42215j.this.TAG, "syncRespHandler PAUSE by 500ms  time:%d  processcount:%d sum:%d ,%s", Long.valueOf(C5046bo.m7566gb(anU)), Integer.valueOf(i2), Integer.valueOf(this.fIJ), C42215j.this.fIF);
                            this.fIK += C5046bo.m7566gb(anU);
                            AppMethodBeat.m2505o(58381);
                            return true;
                        }
                        i = i2 + 1;
                    } else {
                        this.fIK += C5046bo.m7566gb(anU);
                        AppMethodBeat.m2505o(58381);
                        return true;
                    }
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.j$a */
    public static class C42216a extends C6297k {
        private final C23473a fHQ;
        private final C7290b fHR;
        private final boolean fHS;

        public C42216a() {
            AppMethodBeat.m2504i(58382);
            this.fHQ = new C23473a();
            this.fHR = new C7290b();
            this.fHS = false;
            AppMethodBeat.m2505o(58382);
        }

        public C42216a(C7290b c7290b) {
            AppMethodBeat.m2504i(58383);
            this.fHQ = new C23473a();
            this.fHR = c7290b;
            this.fHS = true;
            AppMethodBeat.m2505o(58383);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fHQ;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fHR;
        }

        public final int getType() {
            return 138;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newsync";
        }
    }

    public C42215j(int i) {
        AppMethodBeat.m2504i(58384);
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
        C4990ab.m7417i(this.TAG, "dkpush NetSceneSync scene:%d stack:%s", Integer.valueOf(i), C5046bo.dpG());
        this.fIE = C5007an.doQ();
        this.eOm = new C1446a();
        if (this.fIx == null) {
            this.fIx = new C18670p();
        }
        this.fIx.fJD = i;
        C1720g.m3537RQ();
        if (C1720g.m3536RP() != null && C1720g.m3531RK()) {
            C1720g.m3537RQ();
            if (!(C1720g.m3536RP().mo5239Ry() == null || C1668a.m3393QT())) {
                C1720g.m3537RQ();
                long a = C5046bo.m7514a((Long) C1720g.m3536RP().mo5239Ry().get(8196, null), 0);
                if (a != 0) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf(0));
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
            C4990ab.m7417i(this.TAG, "summerbadcr NetSceneSync aiScene[%d], selector[%d], syncScene[%d]", Integer.valueOf(i), Integer.valueOf(fHJ), Integer.valueOf(this.fIC));
        } else {
            this.fIC = i;
        }
        if (fIB == 0) {
            ahR();
        }
        AppMethodBeat.m2505o(58384);
    }

    public C42215j(final C7290b c7290b, int i, long j) {
        this(8);
        AppMethodBeat.m2504i(58385);
        this.fIE = C5007an.doQ();
        C4990ab.m7417i(this.TAG, "dkpush NOTIFYDATA resp size:%d pushSyncFlag:%d  recvTime:%d", Long.valueOf(c7290b.bufferSize), Integer.valueOf(i), Long.valueOf(j));
        this.fHK = i;
        this.fHM = j;
        this.frk = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C5015a() {
            /* renamed from: BI */
            public final boolean mo4499BI() {
                AppMethodBeat.m2504i(58379);
                C42215j.this.fHN = true;
                C42216a c42216a = new C42216a(c7290b);
                C7053e.pXa.mo8378a(99, 230, 1, false);
                C42215j.this.mo4498a(-1, 0, 0, "", c42216a, null);
                AppMethodBeat.m2505o(58379);
                return false;
            }
        }, false);
        if (fIB == 0) {
            ahR();
        }
        AppMethodBeat.m2505o(58385);
    }

    /* renamed from: a */
    public final boolean mo4459a(C1207m c1207m) {
        boolean z = true;
        AppMethodBeat.m2504i(58386);
        if (c1207m instanceof C42215j) {
            C42215j c42215j = (C42215j) c1207m;
            if (c42215j.fIz || !fIy) {
                AppMethodBeat.m2505o(58386);
                return false;
            }
            C4990ab.m7413e(this.TAG, "old not busy and notified, maybe cancel old scene, last dispatch=%d", Long.valueOf(c42215j.ftg));
            if (C5046bo.m7525az(c42215j.ftg) <= 360000) {
                z = false;
            }
            if (z) {
                C4990ab.m7416i(this.TAG, "summerworker NetSceneSync timeout");
                Runnable findTaskByRunTime = C1720g.m3539RS().doN().findTaskByRunTime(0);
                if (findTaskByRunTime != null) {
                    C4990ab.m7412e(this.TAG, "summerworker worker is just blocked by task: " + C7306ak.dump(findTaskByRunTime, false));
                    AppMethodBeat.m2505o(58386);
                    return false;
                }
            }
            AppMethodBeat.m2505o(58386);
            return z;
        }
        AppMethodBeat.m2505o(58386);
        return false;
    }

    public final boolean acI() {
        return true;
    }

    public final int acn() {
        return 100;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final boolean acJ() {
        int i = 1;
        AppMethodBeat.m2504i(58387);
        boolean acJ = super.acJ();
        if (acJ) {
            C7053e.pXa.mo8378a(99, 228, 1, false);
            C7053e c7053e = C7053e.pXa;
            Object[] objArr = new Object[9];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(0);
            objArr[5] = Integer.valueOf(0);
            objArr[6] = Integer.valueOf(0);
            if (!C4872b.foreground) {
                i = 2;
            }
            objArr[7] = Integer.valueOf(i);
            objArr[8] = "9999";
            c7053e.mo8381e(12063, objArr);
        }
        AppMethodBeat.m2505o(58387);
        return acJ;
    }

    public final int getType() {
        return 138;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(58388);
        super.cancel();
        C7053e.pXa.mo8378a(99, 229, 1, false);
        this.fIa = true;
        AppMethodBeat.m2505o(58388);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(58389);
        if (C37942k.ahT()) {
            fIB = 0;
            C4990ab.m7412e(this.TAG, "dkinit never do sync before init done");
            AppMethodBeat.m2505o(58389);
            return -1;
        }
        this.ehi = c1202f;
        if (this.fIx == null) {
            this.fIx = new C18670p();
        }
        this.fIx.caA = C4872b.foreground;
        if (this.fIA != null) {
            C4990ab.m7416i(this.TAG, "pushSyncRespHandler not null");
            mo4470c(c1902e);
            this.fIA.mo16770ae(0, 0);
            AppMethodBeat.m2505o(58389);
            return 0;
        } else if (fIB > 0) {
            C4990ab.m7421w(this.TAG, "other sync is dealing with resp data :%d", Integer.valueOf(fIB));
            AppMethodBeat.m2505o(58389);
            return -1;
        } else if (this.frk != null) {
            C4990ab.m7416i(this.TAG, "pusher not null");
            mo4470c(c1902e);
            this.frk.mo16770ae(0, 0);
            AppMethodBeat.m2505o(58389);
            return 0;
        } else {
            C42216a c42216a = new C42216a();
            bej bej = ((C23473a) c42216a.acF()).vyG;
            if (this.fIC == 3) {
                bej.wIx = 1;
            } else {
                bej.wIx = 0;
            }
            this.fIC = this.fID ? 6 : this.fIC;
            bej.vTN = fHJ;
            C1720g.m3537RQ();
            bej.vTO = C1946aa.m4152ad(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, new byte[0]))));
            bej.Scene = this.fIC;
            bej.wIw = new C35956tc();
            bej.vIk = C7243d.eSg;
            C4990ab.m7417i(this.TAG, "doScene Selector:%d Scene:%d key[%s]", Integer.valueOf(bej.vTN), Integer.valueOf(bej.Scene), C44098aa.m79381bP(r0));
            fIy = false;
            int a = mo4457a(c1902e, c42216a, this);
            AppMethodBeat.m2505o(58389);
            return a;
        }
    }

    private boolean ahR() {
        AppMethodBeat.m2504i(58390);
        PInt pInt = new PInt();
        C1720g.m3537RQ();
        C1720g.m3534RN();
        byte[] a = C37617g.m63509a(pInt, C1668a.m3383QF());
        String str = this.TAG;
        String str2 = "dealWithRespData index:%d, hashcode:%d, buf.len:%d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(pInt.value);
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = Integer.valueOf(a != null ? a.length : 0);
        C4990ab.m7417i(str, str2, objArr);
        fIB = pInt.value;
        if (pInt.value == 0 || C5046bo.m7540cb(a)) {
            fIB = 0;
            AppMethodBeat.m2505o(58390);
            return false;
        }
        C7290b c7290b = new C7290b();
        try {
            c7290b.mo5744P(a);
            final C42216a c42216a = new C42216a(c7290b);
            this.fIA = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C5015a() {
                /* renamed from: BI */
                public final boolean mo4499BI() {
                    AppMethodBeat.m2504i(58380);
                    C42215j.this.fHN = true;
                    C7053e.pXa.mo8378a(99, 231, 1, false);
                    C42215j.this.mo4498a(-1, 0, 0, "", c42216a, null);
                    AppMethodBeat.m2505o(58380);
                    return false;
                }
            }, false);
            AppMethodBeat.m2505o(58390);
            return true;
        } catch (Exception e) {
            C7053e.pXa.mo8378a(99, 226, 1, false);
            C4990ab.m7412e(this.TAG, "dealWithRespData SyncResp fromProtoBuf failed");
            int i = fIB;
            C1720g.m3537RQ();
            C1720g.m3534RN();
            C37617g.m63510bO(i, C1668a.m3383QF());
            fIB = 0;
            AppMethodBeat.m2505o(58390);
            return false;
        } catch (Error e2) {
            long freeMemory = Runtime.getRuntime().freeMemory() / 1000;
            long totalMemory = Runtime.getRuntime().totalMemory() / 1000;
            C4990ab.m7417i(this.TAG, "dealWithRespData memoryInfo avail/total, dalvik[%dk, %dk, user:%dk]", Long.valueOf(freeMemory), Long.valueOf(totalMemory), Long.valueOf(totalMemory - freeMemory));
            Assert.assertTrue("dealWithRespData error", false);
            AppMethodBeat.m2505o(58390);
            return false;
        }
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(58391);
        String str2;
        if (c1929q == null || c1929q.getType() != 138) {
            String str3 = this.TAG;
            str2 = "onGYNetEnd error type:%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(c1929q == null ? -2 : c1929q.getType());
            C4990ab.m7413e(str3, str2, objArr);
            AppMethodBeat.m2505o(58391);
            return;
        }
        boolean z;
        C7290b c7290b = (C7290b) c1929q.mo5618ZS();
        str2 = this.TAG;
        String str4 = "onGYNetEnd:[%d,%d,%s] time:%d  isnotifydata:%b count:%d pusher:%s pushSyncRespHandler:%s ";
        Object[] objArr2 = new Object[8];
        objArr2[0] = Integer.valueOf(i2);
        objArr2[1] = Integer.valueOf(i3);
        objArr2[2] = str;
        objArr2[3] = Long.valueOf(this.eOm.mo4908Mr());
        objArr2[4] = Boolean.valueOf(this.fHN);
        objArr2[5] = Integer.valueOf(c7290b.vyH.vTR == null ? -1 : c7290b.vyH.vTR.jBv);
        objArr2[6] = this.frk;
        objArr2[7] = this.fIA;
        C4990ab.m7417i(str2, str4, objArr2);
        Object obj = (c7290b.vyH.vTR == null ? -1 : c7290b.vyH.vTR.jBv) > 0 ? 1 : null;
        if (!ahS()) {
            C7053e.pXa.mo8378a(99, obj != null ? 221 : 218, 1, false);
        } else if (C4872b.foreground) {
            C7053e.pXa.mo8378a(99, obj != null ? 219 : 216, 1, false);
        } else {
            C7053e.pXa.mo8378a(99, obj != null ? 220 : 217, 1, false);
        }
        this.frk = null;
        this.fIz = true;
        if (i2 == 4 && i3 == -2006) {
            z = true;
            i2 = 0;
            i3 = 0;
            C7053e.pXa.mo8378a(99, 227, 1, false);
        } else {
            z = false;
        }
        if (i2 == 0 && i3 == 0) {
            C7053e.pXa.mo8378a(99, 233, 1, false);
            byte[] a = C1946aa.m4150a(((C23473a) c1929q.acF()).vyG.vTO);
            byte[] a2 = C1946aa.m4150a(c7290b.vyH.vTO);
            C4990ab.m7417i(this.TAG, "onGYNetEnd replace key:%b req :%s", Boolean.valueOf(z), C44098aa.m79381bP(a));
            C4990ab.m7417i(this.TAG, "onGYNetEnd replace key:%b resp:%s", Boolean.valueOf(z), C44098aa.m79381bP(a2));
            if (!z) {
                if (C5046bo.m7540cb(a)) {
                    C1720g.m3537RQ();
                    a = C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, new byte[0])));
                    C4990ab.m7411d(this.TAG, "dkpush userinfo key : %d[%s]", Integer.valueOf(a.length), C5046bo.m7539ca(a));
                }
                a = C44098aa.m79382j(a, a2);
                if (a == null || a.length <= 0) {
                    C4990ab.m7420w(this.TAG, "merge key failed, use server side instead");
                    a = a2;
                }
                c7290b.vyH.vTO = C1946aa.m4152ad(a);
            }
            C1720g.m3537RQ();
            C1720g.m3534RN().mo5163cd(c7290b.vyH.jBT, c7290b.vyH.wIy);
            C1720g.m3537RQ();
            C1720g.m3534RN();
            C1668a.m3403jO(c7290b.vyH.jBT);
            Assert.assertTrue(this.fIF == null);
            this.fIF = c7290b;
            this.fIG = C5046bo.anU();
            new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C186673(), true).mo16770ae(50, 50);
            AppMethodBeat.m2505o(58391);
            return;
        }
        if (this.fIF != null) {
            C4990ab.m7416i(this.TAG, "oreh sync mIRH.processingResp is not null, and simulate not continue");
            this.errType = i2;
            this.errCode = i3;
            this.aIm = str;
            ((C7290b) c1929q.mo5618ZS()).vyH.vQe = 0;
        } else {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        C7053e.pXa.mo8378a(99, 232, 1, false);
        AppMethodBeat.m2505o(58391);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final void mo67744a(C7290b c7290b) {
        AppMethodBeat.m2504i(58392);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(8195, C5046bo.m7543cd(C1946aa.m4150a(c7290b.vyH.vTO)));
        C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).edit().putString("notify_sync_key_keybuf", C5046bo.m7543cd(C1946aa.m4150a(c7290b.vyH.vTO))).commit();
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf((long) c7290b.vyH.vQe));
        boolean z = ((c7290b.vyH.vQe & fHJ) == 0 || super.acJ()) ? false : true;
        C4990ab.m7417i(this.TAG, "canContinue cont:%b ContinueFlag:%d selector:%d securityLimitCountReach:%b", Boolean.valueOf(z), Integer.valueOf(c7290b.vyH.vQe), Integer.valueOf(fHJ), Boolean.valueOf(super.acJ()));
        if (!(z || (c7290b.vyH.vQe & 256) == 0)) {
            C45364rv c45364rv = new C45364rv();
            c45364rv.cNO.cvp = 1;
            C4879a.xxA.mo10055m(c45364rv);
        }
        if (!(z || (c7290b.vyH.vQe & 2097152) == 0)) {
            C4879a.xxA.mo10055m(new C32597lx());
        }
        C7053e.pXa.mo8378a(99, z ? 234 : 235, 1, false);
        C4990ab.m7417i(this.TAG, "onRespHandled continueFlag:%d isNotifyData:%b conCont:%b notifyPending:%b pushSyncFlag:%d isContinueScene:%b respHandler:%s ", Integer.valueOf(c7290b.vyH.vQe), Boolean.valueOf(this.fHN), Boolean.valueOf(z), Boolean.valueOf(fIy), Integer.valueOf(this.fHK), Boolean.valueOf(this.fID), this.fIA);
        int i;
        if (!this.fHN && z) {
            this.fID = true;
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(58392);
        } else if (fIy) {
            C4990ab.m7416i(this.TAG, "dkpush new notify pending, sync now");
            if (fIB != 0) {
                i = fIB;
                C1720g.m3537RQ();
                C1720g.m3534RN();
                C37617g.m63510bO(i, C1668a.m3383QF());
            }
            fIB = 0;
            this.fIA = null;
            fIy = false;
            this.fID = true;
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(58392);
        } else if (this.fIA != null) {
            i = fIB;
            C1720g.m3537RQ();
            C1720g.m3534RN();
            C37617g.m63510bO(i, C1668a.m3383QF());
            this.fIA = null;
            ahR();
            mo4456a(this.ftf, this.ehi);
            AppMethodBeat.m2505o(58392);
        } else {
            if ((this.fHK & 1) > 0) {
                C1720g.m3537RQ();
                C1720g.m3540Rg().mo14541a(new C26448f(this.fHM, C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)))), 0);
            }
            C4990ab.m7410d(this.TAG, "sync or init end: reset selector : now = " + fHJ + " default = 7");
            fHJ = 7;
            this.ehi.onSceneEnd(this.errType, this.errCode, this.aIm, this);
            AppMethodBeat.m2505o(58392);
        }
    }

    private boolean ahS() {
        AppMethodBeat.m2504i(58393);
        try {
            boolean booleanValue = ((Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) C4996ah.getContext().getSystemService("power"), new Object[0])).booleanValue();
            AppMethodBeat.m2505o(58393);
            return booleanValue;
        } catch (Exception e) {
            C4990ab.m7413e(this.TAG, "reflectScreenOn invoke ERROR use isScreenOn:%s e:%s", Boolean.TRUE, C5046bo.m7574l(e));
            AppMethodBeat.m2505o(58393);
            return true;
        }
    }
}
