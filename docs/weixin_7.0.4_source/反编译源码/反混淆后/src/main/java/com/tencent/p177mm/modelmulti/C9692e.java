package com.tencent.p177mm.modelmulti;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
import com.tencent.p177mm.p183ai.C32231g;
import com.tencent.p177mm.p183ai.C6297k;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33333a;
import com.tencent.p177mm.plugin.zero.C44038c;
import com.tencent.p177mm.protocal.C44203s.C15405a;
import com.tencent.p177mm.protocal.C44203s.C30255b;
import com.tencent.p177mm.protocal.C4836l.C4834d;
import com.tencent.p177mm.protocal.C4836l.C4835e;
import com.tencent.p177mm.protocal.protobuf.C40573tb;
import com.tencent.p177mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.p177mm.protocal.protobuf.beb;
import com.tencent.p177mm.protocal.protobuf.bec;
import com.tencent.p177mm.sdk.platformtools.C4988aa;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.modelmulti.e */
public final class C9692e extends C1207m implements C1918k {
    C1446a eOm;
    C1202f ehi;
    final Queue<C9696a> fCB = new LinkedList();
    private StringBuilder fHL = new StringBuilder();
    WeakReference<C32231g> fHU = null;
    final beb fHV = new beb();
    int fHW = 0;
    boolean fHX = false;
    int fHY = 0;
    int fHZ = 0;
    boolean fIa = false;
    private final C7564ap frk = new C7564ap(C1720g.m3539RS().oAl.getLooper(), new C96931(), true);
    private int retryCount = 3;

    /* renamed from: com.tencent.mm.modelmulti.e$1 */
    class C96931 implements C5015a {
        C96931() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            float f = 1.0f;
            AppMethodBeat.m2504i(58360);
            if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7412e("MicroMsg.NetSceneInit.dkInit", "acc is not ready stop handle resp");
                AppMethodBeat.m2505o(58360);
                return false;
            } else if (C9692e.this.fIa) {
                C4990ab.m7421w("MicroMsg.NetSceneInit.dkInit", "Init CANCELED hash:%d", Integer.valueOf(C9692e.this.hashCode()));
                AppMethodBeat.m2505o(58360);
                return false;
            } else if (C9692e.this.fCB.isEmpty()) {
                C4990ab.m7418v("MicroMsg.NetSceneInit.dkInit", "queue maybe this time is null , wait doscene!");
                AppMethodBeat.m2505o(58360);
                return false;
            } else {
                boolean z;
                C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "pusher hash:%d time:%d list:%d [%d/%b,%d/%d]", Integer.valueOf(C9692e.this.hashCode()), Long.valueOf(C9692e.this.eOm.mo4908Mr()), Integer.valueOf(C9692e.this.fCB.size()), Integer.valueOf(C9692e.this.fHW), Boolean.valueOf(C9692e.this.fHX), Integer.valueOf(C9692e.this.fHZ), Integer.valueOf(C9692e.this.fHY));
                C1720g.m3537RQ();
                long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
                C44038c c44038c = new C44038c();
                c44038c.mo69729ca("NetSceneInit");
                int i = C9692e.this.fHX ? 40 : 10;
                int i2 = 0;
                while (i2 < i) {
                    final C9696a c9696a = (C9696a) C9692e.this.fCB.peek();
                    if (c9696a.fIf != BaseClientBuilder.API_PRIORITY_OTHER) {
                        LinkedList linkedList = c9696a.fIe.wHL;
                        if (linkedList != null && linkedList.size() > c9696a.fCP) {
                            linkedList.size();
                            if (c44038c.mo69728a((C40573tb) linkedList.get(c9696a.fCP), true)) {
                                c9696a.fCP++;
                                C9692e c9692e = C9692e.this;
                                c9692e.fHZ++;
                                i2++;
                            }
                        }
                        C9692e.this.fCB.poll();
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(8197, C5046bo.m7543cd(C1946aa.m4150a(c9696a.fIe.wHH)));
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(8198, C5046bo.m7543cd(C1946aa.m4150a(c9696a.fIe.wHI)));
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(16, Integer.valueOf(0));
                        C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "ContinueFlag:%s", Long.valueOf((long) c9696a.fIe.vQe));
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().set(8196, Long.valueOf((long) c9696a.fIe.vQe));
                        C1720g.m3537RQ();
                        C1720g.m3536RP().mo5239Ry().dsb();
                        z = true;
                        break;
                    }
                    String str = "in Queue tail , resp should be null";
                    if (c9696a.fIe == null) {
                        z = true;
                    } else {
                        z = false;
                    }
                    Assert.assertTrue(str, z);
                    C1720g.m3537RQ();
                    Object obj = (String) C1720g.m3536RP().mo5239Ry().get(8198, null);
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(8195, obj);
                    C4996ah.getContext().getSharedPreferences("notify_sync_pref", C1448h.m3078Mu()).edit().putString("notify_sync_key_keybuf", obj).commit();
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(8197, (Object) "");
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(8198, (Object) "");
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(15, Integer.valueOf(1));
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().dsb();
                    C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "INIT DONE: hash:%d time:%d netCnt:%d cmdCnt:%d err:[%d,%d] ", Integer.valueOf(C9692e.this.hashCode()), Long.valueOf(C9692e.this.eOm.mo4908Mr()), Integer.valueOf(C9692e.this.fHW), Integer.valueOf(C9692e.this.fHY), Integer.valueOf(c9696a.errType), Integer.valueOf(c9696a.errCode));
                    C1720g.m3539RS().mo10302aa(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(58359);
                            C9692e.this.ehi.onSceneEnd(c9696a.errType, c9696a.errCode, c9696a.aIm, C9692e.this);
                            AppMethodBeat.m2505o(58359);
                        }
                    });
                    z = false;
                }
                z = true;
                c44038c.mo69730cc("NetSceneInit");
                C1720g.m3537RQ();
                C1720g.m3536RP().eJN.mo15640mB(iV);
                C9692e c9692e2 = C9692e.this;
                if (c9692e2.fHU == null) {
                    C4990ab.m7420w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progressRef is null");
                } else {
                    C32231g c32231g = (C32231g) c9692e2.fHU.get();
                    if (c32231g == null) {
                        C4990ab.m7420w("MicroMsg.NetSceneInit.dkInit", "dkinit doProgressCallBack progress is null");
                    } else {
                        i = c9692e2.fHW > 50 ? 50 : c9692e2.fHW;
                        if (c9692e2.fHX) {
                            float f2 = ((float) c9692e2.fHZ) / ((float) c9692e2.fHY);
                            if (f2 <= 1.0f) {
                                f = f2;
                            }
                            i2 = (int) ((((float) (100 - i)) * f) + ((float) i));
                        } else {
                            i2 = i;
                        }
                        C4990ab.m7411d("MicroMsg.NetSceneInit.dkInit", "doProgressCallBack index:%d sum:%d ratiocmd:%f ratioDoScene:%d", Integer.valueOf(c9692e2.fHZ), Integer.valueOf(c9692e2.fHY), Float.valueOf(f), Integer.valueOf(i));
                        c32231g.mo8280a(i2, 100, c9692e2);
                    }
                }
                AppMethodBeat.m2505o(58360);
                return z;
            }
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.e$b */
    public static class C9695b extends C6297k {
        private final C15405a fIg = new C15405a();
        private final C30255b fIh = new C30255b();

        public C9695b() {
            AppMethodBeat.m2504i(58361);
            AppMethodBeat.m2505o(58361);
        }

        /* renamed from: ZR */
        public final C4834d mo14537ZR() {
            return this.fIg;
        }

        /* renamed from: ZS */
        public final C4835e mo5618ZS() {
            return this.fIh;
        }

        public final int getType() {
            return C33333a.CTRL_INDEX;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/newinit";
        }
    }

    /* renamed from: com.tencent.mm.modelmulti.e$a */
    class C9696a {
        String aIm;
        int errCode;
        int errType;
        int fCP = 0;
        bec fIe;
        int fIf = 0;

        C9696a() {
        }
    }

    public C9692e(C32231g c32231g) {
        AppMethodBeat.m2504i(58362);
        C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "NetSceneInit hash:%d stack:%s", Integer.valueOf(hashCode()), C5046bo.dpG());
        this.fHL.append("stack:" + C5046bo.dpG() + " time:" + C5046bo.anT());
        this.fHU = new WeakReference(c32231g);
        AppMethodBeat.m2505o(58362);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(58363);
        this.eOm = new C1446a();
        this.ehi = c1202f;
        beb beb = this.fHV;
        C1720g.m3537RQ();
        beb.jBB = (String) C1720g.m3536RP().mo5239Ry().get(2, null);
        Assert.assertTrue("by DK: req.UserName is null", !C5046bo.isNullOrNil(this.fHV.jBB));
        this.fHV.luQ = C4988aa.dor();
        int a = m17266a(c1902e, null, null);
        AppMethodBeat.m2505o(58363);
        return a;
    }

    /* renamed from: a */
    private int m17266a(C1902e c1902e, SKBuiltinBuffer_t sKBuiltinBuffer_t, SKBuiltinBuffer_t sKBuiltinBuffer_t2) {
        AppMethodBeat.m2504i(58364);
        this.fHL.append(" lastd:" + this.ftg + " dotime:" + C5046bo.anT() + " net:" + C5023at.getNetType(C4996ah.getContext()));
        C9695b c9695b = new C9695b();
        if (sKBuiltinBuffer_t == null) {
            C1720g.m3537RQ();
            sKBuiltinBuffer_t = C1946aa.m4152ad(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8197, null))));
        }
        if (sKBuiltinBuffer_t2 == null) {
            C1720g.m3537RQ();
            sKBuiltinBuffer_t2 = C1946aa.m4152ad(C5046bo.anf(C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8198, null))));
        }
        C1720g.m3537RQ();
        if (C5046bo.m7567h((Integer) C1720g.m3536RP().mo5239Ry().get(16, null)) == 0 || (sKBuiltinBuffer_t != null && sKBuiltinBuffer_t.getILen() > 0)) {
            C1720g.m3537RQ();
            if (C5046bo.nullAsNil((String) C1720g.m3536RP().mo5239Ry().get(8195, null)).length() <= 0) {
                c9695b.acF().vyf = 3;
            } else {
                c9695b.acF().vyf = 4;
            }
        } else {
            c9695b.acF().vyf = 7;
        }
        this.fHV.wHH = sKBuiltinBuffer_t;
        this.fHV.wHI = sKBuiltinBuffer_t2;
        ((C15405a) c9695b.acF()).vyE = this.fHV;
        C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "doScene hash:%d time:%d count:%d user%s lan:%s status:%d cur[%s] max[%s]", Integer.valueOf(hashCode()), Long.valueOf(this.eOm.mo4908Mr()), Integer.valueOf(this.fHW), this.fHV.jBB, this.fHV.luQ, Integer.valueOf(c9695b.acF().vyf), C5046bo.m7543cd(C1946aa.m4150a(sKBuiltinBuffer_t)), C5046bo.m7543cd(C1946aa.m4150a(sKBuiltinBuffer_t2)));
        this.fHW++;
        int a = mo4457a(c1902e, c9695b, this);
        AppMethodBeat.m2505o(58364);
        return a;
    }

    /* JADX WARNING: Missing block: B:14:0x00d0, code skipped:
            if (m17266a(r8.ftf, null, null) == -1) goto L_0x00d2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(58365);
        this.fHL.append(" endtime:" + C5046bo.anT());
        C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "summerinit onGYNetEnd [%d, %d, %s], tid:%d", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(i));
        if (i2 == 4 && i3 == -100) {
            C4990ab.m7413e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR hash:%d [%d,%d] KICK OUT : %s", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            this.fIa = true;
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(58365);
        } else if ((i2 == 0 && i3 == 0) || (i2 == 4 && i3 == -17)) {
            bec bec = ((C30255b) c1929q.mo5618ZS()).vyF;
            this.fHY += bec.wHK;
            C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd hash:%d [%d,%d] time:%d cmdSum:%d doscenecount:%d conFlag:%d", Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(this.eOm.mo4908Mr()), Integer.valueOf(this.fHY), Integer.valueOf(this.fHW), Integer.valueOf(bec.vQe));
            m17267a(this.fHW - 1, i2, i3, str, bec);
            if ((bec.vQe & 7) == 0 || super.acJ()) {
                C4990ab.m7417i("MicroMsg.NetSceneInit.dkInit", "NETWORK FINISH onGYNetEnd hash:%d time:%d netCnt:%d", Integer.valueOf(hashCode()), Long.valueOf(this.eOm.mo4908Mr()), Integer.valueOf(this.fHW));
                this.fHX = true;
                m17267a(BaseClientBuilder.API_PRIORITY_OTHER, 0, 0, "", null);
            } else if (m17266a(this.ftf, bec.wHH, bec.wHI) == -1) {
                C4990ab.m7412e("MicroMsg.NetSceneInit.dkInit", "doScene Failed stop init");
                m17267a(BaseClientBuilder.API_PRIORITY_OTHER, 3, -1, "", null);
                AppMethodBeat.m2505o(58365);
                return;
            }
            AppMethodBeat.m2505o(58365);
        } else {
            C4990ab.m7413e("MicroMsg.NetSceneInit.dkInit", "onGYNetEnd ERROR retry:%d hash:%d [%d,%d] %s", Integer.valueOf(this.retryCount), Integer.valueOf(hashCode()), Integer.valueOf(i2), Integer.valueOf(i3), str);
            if (this.retryCount > 0) {
                this.retryCount--;
            }
            this.fIa = true;
            this.ehi.onSceneEnd(3, -1, "", this);
            AppMethodBeat.m2505o(58365);
        }
    }

    public final boolean acI() {
        return true;
    }

    public final void cancel() {
        AppMethodBeat.m2504i(58366);
        C4990ab.m7421w("MicroMsg.NetSceneInit.dkInit", "init cancel by :%s", C5046bo.dpG());
        super.cancel();
        this.fIa = true;
        AppMethodBeat.m2505o(58366);
    }

    /* renamed from: a */
    private void m17267a(int i, int i2, int i3, String str, bec bec) {
        AppMethodBeat.m2504i(58367);
        C9696a c9696a = new C9696a();
        c9696a.fIf = i;
        c9696a.errCode = i3;
        c9696a.errType = i2;
        c9696a.aIm = str;
        c9696a.fIe = bec;
        this.fCB.add(c9696a);
        if (this.frk.doT()) {
            this.frk.mo16770ae(50, 50);
        }
        AppMethodBeat.m2505o(58367);
    }

    public final String getInfo() {
        AppMethodBeat.m2504i(58368);
        String stringBuilder = this.fHL.toString();
        AppMethodBeat.m2505o(58368);
        return stringBuilder;
    }

    public final int acn() {
        return 500;
    }

    /* renamed from: b */
    public final C1206b mo4468b(C1929q c1929q) {
        return C1206b.EOk;
    }

    public final boolean acJ() {
        AppMethodBeat.m2504i(139010);
        boolean acJ = super.acJ();
        AppMethodBeat.m2505o(139010);
        return acJ;
    }

    public final int getType() {
        return C33333a.CTRL_INDEX;
    }
}
