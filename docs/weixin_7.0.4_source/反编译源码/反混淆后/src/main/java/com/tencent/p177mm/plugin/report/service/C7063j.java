package com.tencent.p177mm.plugin.report.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1816at;
import com.tencent.p177mm.model.C7485q;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.p230g.p231a.C6504k;
import com.tencent.p177mm.platformtools.C1952t;
import com.tencent.p177mm.platformtools.C1952t.C1953a;
import com.tencent.p177mm.plugin.report.p498a.C7608b;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4995ag;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.report.service.j */
public class C7063j implements C1816at {
    private static HashMap<Integer, C1366d> jZD;
    private C4884c jOJ = new C70623();
    private C1953a jZF;
    public boolean pWV = false;
    public HashMap<String, List<C3743d>> pYD;
    public HashMap<String, String> pYE;

    /* renamed from: com.tencent.mm.plugin.report.service.j$2 */
    class C37522 implements Runnable {
        C37522() {
        }

        public final void run() {
            AppMethodBeat.m2504i(72804);
            if (C1720g.m3531RK()) {
                C5046bo.m7583o(C1720g.m3536RP().cachePath + "logcat/", "temp_", 10800000);
                AppMethodBeat.m2505o(72804);
                return;
            }
            AppMethodBeat.m2505o(72804);
        }

        public final String toString() {
            AppMethodBeat.m2504i(72805);
            String str = super.toString() + "|onAccountPostReset";
            AppMethodBeat.m2505o(72805);
            return str;
        }
    }

    /* renamed from: com.tencent.mm.plugin.report.service.j$1 */
    static class C70611 implements C1366d {
        C70611() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C7608b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.report.service.j$3 */
    class C70623 extends C4884c<C6504k> {
        C70623() {
            AppMethodBeat.m2504i(72806);
            this.xxI = C6504k.class.getName().hashCode();
            AppMethodBeat.m2505o(72806);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(72807);
            if (((C6504k) c4883b).csh.csi && !C1720g.m3534RN().mo5161QY()) {
                C4990ab.m7416i("MicroMsg.SubCoreReport", "mOnForegroundListener: account not ready");
            }
            AppMethodBeat.m2505o(72807);
            return false;
        }
    }

    static {
        AppMethodBeat.m2504i(72814);
        HashMap hashMap = new HashMap();
        jZD = hashMap;
        hashMap.put(Integer.valueOf("DUPLICATEKVLOG_TABLE".hashCode()), new C70611());
        AppMethodBeat.m2505o(72814);
    }

    public C7063j() {
        AppMethodBeat.m2504i(72808);
        AppMethodBeat.m2505o(72808);
    }

    public final void onAccountRelease() {
        AppMethodBeat.m2504i(72809);
        if (C7063j.cgu() != null) {
            C7063j cgu = C7063j.cgu();
            if (cgu.jZF != null) {
                cgu.jZF.mo5709mJ(cgu.hashCode());
                cgu.jZF = null;
            }
        }
        C4879a.xxA.mo10053d(this.jOJ);
        if (this.pYD != null) {
            this.pYD.clear();
        }
        if (this.pYE != null) {
            this.pYE.clear();
        }
        AppMethodBeat.m2505o(72809);
    }

    /* renamed from: Jx */
    public final HashMap<Integer, C1366d> mo5391Jx() {
        return null;
    }

    /* renamed from: iy */
    public final void mo5394iy(int i) {
    }

    /* renamed from: bz */
    public final void mo5393bz(boolean z) {
        AppMethodBeat.m2504i(72810);
        long currentTimeMillis = System.currentTimeMillis();
        this.jZF = C1952t.m4171a(hashCode(), C1720g.m3536RP().cachePath + "CommonOneMicroMsg.db", jZD, false);
        C4990ab.m7417i("MicroMsg.SubCoreReport", "summeranrt onAccountPostReset tid[%d] [%d]ms, stack[%s]", Long.valueOf(Thread.currentThread().getId()), Long.valueOf(System.currentTimeMillis() - currentTimeMillis), C5046bo.dpG());
        C4879a.xxA.mo10052c(this.jOJ);
        this.pYD = new HashMap();
        this.pYE = new HashMap();
        C1720g.m3537RQ();
        C1720g.m3539RS().mo10302aa(new C37522());
        AppMethodBeat.m2505o(72810);
    }

    /* renamed from: bA */
    public final void mo5392bA(boolean z) {
    }

    public static C7063j cgu() {
        AppMethodBeat.m2504i(72811);
        C7063j c7063j = (C7063j) C7485q.m12925Y(C7063j.class);
        AppMethodBeat.m2505o(72811);
        return c7063j;
    }

    /* renamed from: t */
    public final void mo15423t(long j, String str) {
        AppMethodBeat.m2504i(72812);
        if (this.pWV && this.pYD != null) {
            boolean z;
            List linkedList;
            C4990ab.m7419v("MicroMsg.SubCoreReport", "put kv info [%d %s]", Long.valueOf(j), str);
            List list = (List) this.pYD.get(String.valueOf(j));
            if (list == null) {
                z = false;
                linkedList = new LinkedList();
            } else {
                C3743d c3743d = (C3743d) list.get(list.size() - 1);
                if (C5046bo.m7566gb(c3743d.pXQ) < 1000) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c3743d.pXS = true;
                }
                linkedList = list;
            }
            linkedList.add(0, new C3743d(j, str, C5046bo.anU(), z));
            this.pYD.put(String.valueOf(j), linkedList);
        }
        AppMethodBeat.m2505o(72812);
    }

    /* renamed from: aa */
    public final void mo15422aa(String str, String str2, String str3) {
        AppMethodBeat.m2504i(72813);
        if (this.pWV && this.pYE != null) {
            C4990ab.m7419v("MicroMsg.SubCoreReport", "put kv info [%s %s %s]", str, str2, str3);
            this.pYE.put(C4995ag.m7428ck(str), str2 + str3);
        }
        AppMethodBeat.m2505o(72813);
    }
}
