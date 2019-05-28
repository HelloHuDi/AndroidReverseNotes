package com.tencent.p177mm.kernel;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.api.C1672d;
import com.tencent.p177mm.model.C1814al;
import com.tencent.p177mm.model.C1841cc;
import com.tencent.p177mm.model.C1841cc.C1840a;
import com.tencent.p177mm.model.C6668bk;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.network.C1897b.C1895a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1909h.C1910a;
import com.tencent.p177mm.network.C1923n;
import com.tencent.p177mm.network.C1923n.C1924a;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1225b;
import com.tencent.p177mm.p183ai.C6300p;
import com.tencent.p177mm.p183ai.C6300p.C1213a;
import com.tencent.p177mm.p217ci.C6454a;
import com.tencent.p177mm.p217ci.C6454a.C1387a;
import com.tencent.p177mm.p230g.p231a.C6510kr;
import com.tencent.p177mm.protocal.C4787a;
import com.tencent.p177mm.protocal.C4845x.C4846a;
import com.tencent.p177mm.protocal.C4845x.C4847b;
import com.tencent.p177mm.protocal.C4848y.C4849a;
import com.tencent.p177mm.sdk.p599a.C4871a;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.kernel.b */
public final class C1682b {
    public static String eJm = "wechatnetwork";
    private static C1814al eJr = null;
    public final C1691a eJn;
    public final C6300p eJo;
    private HashSet<C1923n> eJp = new HashSet();
    public C1923n eJq = new C16882();

    /* renamed from: com.tencent.mm.kernel.b$1 */
    class C16831 implements C1225b {
        C16831() {
        }

        /* renamed from: Rh */
        public final C6300p mo4497Rh() {
            AppMethodBeat.m2504i(57922);
            C6300p a = C1682b.this.eJo;
            AppMethodBeat.m2505o(57922);
            return a;
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$3 */
    class C16843 implements C1835a {
        C16843() {
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(57924);
            if (c1902e == null || c1902e.adg() == null) {
                AppMethodBeat.m2505o(57924);
                return;
            }
            c1902e.adg().reset();
            AppMethodBeat.m2505o(57924);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$6 */
    public class C16856 implements C4871a {
        /* renamed from: lG */
        public final void mo5190lG(String str) {
            AppMethodBeat.m2504i(57928);
            C4990ab.m7421w("MMKernel.CoreNetwork", "CallbackForReset errorStack %s ", str);
            C1720g.m3537RQ();
            if (C1720g.m3538RR() != null) {
                C1720g.m3537RQ();
                C1841cc RR = C1720g.m3538RR();
                RR.isRunning = true;
                for (C1840a c1840a : RR.fnN) {
                    if (c1840a != null) {
                        c1840a.aaG();
                    }
                }
                RR.isRunning = false;
            }
            C1720g.m3537RQ();
            if (C1720g.m3536RP() != null) {
                C1720g.m3537RQ();
                C1720g.m3536RP().mo5245jC(str);
            }
            AppMethodBeat.m2505o(57928);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$7 */
    public class C16867 implements C1895a {
        /* renamed from: Rk */
        public final C1902e mo5191Rk() {
            AppMethodBeat.m2504i(57929);
            try {
                C1902e c1902e = C1682b.this.eJo.ftA;
                AppMethodBeat.m2505o(57929);
                return c1902e;
            } catch (Throwable th) {
                C4990ab.m7413e("MMKernel.CoreNetwork", "%s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(57929);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$8 */
    public class C16878 implements C1895a {
        /* renamed from: Rk */
        public final C1902e mo5191Rk() {
            AppMethodBeat.m2504i(57930);
            try {
                C1902e c1902e = C1682b.this.eJo.ftA;
                AppMethodBeat.m2505o(57930);
                return c1902e;
            } catch (Throwable th) {
                C4990ab.m7413e("MMKernel.CoreNetwork", "%s", C5046bo.m7574l(th));
                AppMethodBeat.m2505o(57930);
                return null;
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$2 */
    class C16882 extends C1924a {
        C16882() {
        }

        /* renamed from: gl */
        public final void mo5192gl(int i) {
            AppMethodBeat.m2504i(57923);
            try {
                HashSet hashSet = new HashSet();
                synchronized (C1682b.this.eJp) {
                    hashSet.addAll(C1682b.this.eJp);
                }
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    ((C1923n) it.next()).mo5192gl(i);
                }
                AppMethodBeat.m2505o(57923);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MMKernel.CoreNetwork", e, "onNetworkChange caught crash", new Object[0]);
                AppMethodBeat.m2505o(57923);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(57923);
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$4 */
    public class C16894 extends C1910a {
        public final void networkAnalysisCallBack(int i, int i2, boolean z, String str) {
            AppMethodBeat.m2504i(57925);
            C4990ab.m7417i("MMKernel.CoreNetwork", "callback, kv:%s", str);
            C1682b.m3431b(i, i2, z, str);
            AppMethodBeat.m2505o(57925);
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$5 */
    public class C16905 extends C4849a {
        private byte[] eJt;

        /* renamed from: Ri */
        public final byte[] mo5195Ri() {
            AppMethodBeat.m2504i(57926);
            if (C1720g.m3531RK()) {
                C4846a c4846a = new C4846a();
                C1720g.m3537RQ();
                C1720g.m3534RN();
                c4846a.uin = C1668a.m3383QF();
                C1720g.m3537RQ();
                c4846a.fIi = C5046bo.anf((String) C1720g.m3536RP().mo5239Ry().get(8195, null));
                c4846a.netType = C4787a.getNetType(C4996ah.getContext());
                c4846a.vyo = C4787a.dlZ();
                try {
                    byte[] ZT = c4846a.mo5742ZT();
                    this.eJt = c4846a.eJt;
                    AppMethodBeat.m2505o(57926);
                    return ZT;
                } catch (Exception e) {
                    C4990ab.m7413e("MMKernel.CoreNetwork", "exception:%s", C5046bo.m7574l(e));
                    AppMethodBeat.m2505o(57926);
                    return null;
                }
            }
            AppMethodBeat.m2505o(57926);
            return null;
        }

        /* renamed from: K */
        public final int mo5194K(byte[] bArr) {
            int i = 0;
            AppMethodBeat.m2504i(57927);
            C4847b c4847b = new C4847b();
            try {
                c4847b.mo5744P(bArr);
                i = (int) c4847b.vyM;
                AppMethodBeat.m2505o(57927);
                return i;
            } catch (Exception e) {
                C4990ab.m7413e("MMKernel.CoreNetwork", "exception:%s", C5046bo.m7574l(e));
                AppMethodBeat.m2505o(57927);
                return i;
            }
        }

        /* renamed from: Rj */
        public final byte[] mo5196Rj() {
            return this.eJt;
        }
    }

    /* renamed from: com.tencent.mm.kernel.b$a */
    public static class C1691a extends C6454a<C1672d> implements C1672d {
        C1691a() {
        }

        /* renamed from: b */
        public final void mo5171b(final C1902e c1902e) {
            AppMethodBeat.m2504i(57932);
            mo14669a(new C1387a<C1672d>() {
                /* renamed from: ax */
                public final /* synthetic */ void mo4769ax(Object obj) {
                    AppMethodBeat.m2504i(57931);
                    ((C1672d) obj).mo5171b(c1902e);
                    AppMethodBeat.m2505o(57931);
                }
            });
            AppMethodBeat.m2505o(57932);
        }
    }

    public C1682b(C1213a c1213a, C1691a c1691a) {
        AppMethodBeat.m2504i(57933);
        this.eJo = C6300p.m10343a(c1213a);
        this.eJo.ftB = C1720g.m3539RS();
        C1226w.fuq = new C16831();
        this.eJn = c1691a;
        AppMethodBeat.m2505o(57933);
    }

    /* renamed from: a */
    public final void mo5187a(C1923n c1923n) {
        AppMethodBeat.m2504i(57934);
        synchronized (this.eJp) {
            try {
                this.eJp.add(c1923n);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57934);
            }
        }
    }

    /* renamed from: b */
    public final void mo5188b(C1923n c1923n) {
        AppMethodBeat.m2504i(57935);
        synchronized (this.eJp) {
            try {
                this.eJp.remove(c1923n);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(57935);
            }
        }
    }

    /* renamed from: Re */
    public static C1814al m3427Re() {
        return eJr;
    }

    /* renamed from: a */
    public static void m3429a(C1814al c1814al) {
        eJr = c1814al;
    }

    /* renamed from: Rg */
    public final C6300p mo5186Rg() {
        return this.eJo;
    }

    /* renamed from: b */
    public static void m3431b(int i, int i2, boolean z, String str) {
        AppMethodBeat.m2504i(57938);
        C6510kr c6510kr = new C6510kr();
        c6510kr.cGB.status = i;
        c6510kr.cGB.cGC = i2;
        c6510kr.cGB.cGD = z;
        c6510kr.cGB.cGE = str;
        C4879a.xxA.mo10055m(c6510kr);
        AppMethodBeat.m2505o(57938);
    }

    /* renamed from: Rf */
    public final void mo5185Rf() {
        AppMethodBeat.m2504i(57936);
        this.eJo.mo14541a(new C6668bk(new C16843(), "reset accinfo"), 0);
        AppMethodBeat.m2505o(57936);
    }

    /* renamed from: jQ */
    public final byte[] mo5189jQ(int i) {
        byte[] bArr = null;
        AppMethodBeat.m2504i(57937);
        try {
            if (this.eJo == null || this.eJo.ftA == null || this.eJo.ftA.adg() == null) {
                AppMethodBeat.m2505o(57937);
                return bArr;
            }
            bArr = this.eJo.ftA.adg().mo5490jQ(i);
            AppMethodBeat.m2505o(57937);
            return bArr;
        } catch (Exception e) {
            C4990ab.m7421w("MMKernel.CoreNetwork", "get session key error, %s", e.getMessage());
            C4990ab.m7413e("MMKernel.CoreNetwork", "exception:%s", C5046bo.m7574l(e));
            AppMethodBeat.m2505o(57937);
        }
    }
}
