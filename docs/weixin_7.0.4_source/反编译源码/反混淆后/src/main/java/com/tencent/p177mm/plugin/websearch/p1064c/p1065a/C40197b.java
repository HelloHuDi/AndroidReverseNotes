package com.tencent.p177mm.plugin.websearch.p1064c.p1065a;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.plugin.fts.p419a.C12029n;
import com.tencent.p177mm.plugin.fts.p419a.C28114l;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C20846i;
import com.tencent.p177mm.plugin.fts.p419a.p420a.C28109j;
import com.tencent.p177mm.plugin.fts.p419a.p975c.C39132b;
import com.tencent.p177mm.plugin.websearch.p1064c.p1065a.C35577c.C35578a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* renamed from: com.tencent.mm.plugin.websearch.c.a.b */
public final class C40197b implements C35577c {
    Map<C29745a, C35578a> jxd = new HashMap();
    Map<C29745a, CountDownLatch> uce = new ConcurrentHashMap();
    private C28114l ucf = new C355761();
    private C28114l ucg = new C144292();

    /* renamed from: com.tencent.mm.plugin.websearch.c.a.b$2 */
    class C144292 implements C28114l {
        C144292() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(91369);
            C29745a c29745a = (C29745a) c28109j.mEx.mDs;
            if (c29745a == null) {
                AppMethodBeat.m2505o(91369);
                return;
            }
            C35578a c35578a = (C35578a) C40197b.this.jxd.remove(c29745a);
            if (c35578a == null) {
                AppMethodBeat.m2505o(91369);
                return;
            }
            switch (c28109j.bFZ) {
                case -3:
                case -2:
                case -1:
                    c29745a.mo47990dZ(Collections.emptyList());
                    break;
                case 0:
                    if (c28109j.mEy != null && c28109j.mEy.size() != 0) {
                        c29745a.mo47990dZ(c28109j.mEy);
                        break;
                    }
                    C4990ab.m7416i("FTSMatchContact", "local contact search size 0");
                    c35578a.cVJ();
                    AppMethodBeat.m2505o(91369);
                    return;
                    break;
            }
            c35578a.cVJ();
            AppMethodBeat.m2505o(91369);
        }
    }

    /* renamed from: com.tencent.mm.plugin.websearch.c.a.b$1 */
    class C355761 implements C28114l {
        C355761() {
        }

        /* renamed from: b */
        public final void mo8215b(C28109j c28109j) {
            AppMethodBeat.m2504i(91368);
            C29745a c29745a = (C29745a) c28109j.mEx.mDs;
            if (c29745a == null) {
                AppMethodBeat.m2505o(91368);
                return;
            }
            CountDownLatch countDownLatch = (CountDownLatch) C40197b.this.uce.remove(c29745a);
            switch (c28109j.bFZ) {
                case -3:
                case -2:
                case -1:
                    c29745a.mo47990dZ(Collections.emptyList());
                    break;
                case 0:
                    if (c28109j.mEy != null && c28109j.mEy.size() != 0) {
                        c29745a.mo47990dZ(c28109j.mEy);
                        break;
                    }
                    C4990ab.m7416i("FTSMatchContact", "local contact search size 0");
                    c29745a.mo47990dZ(Collections.emptyList());
                    countDownLatch.countDown();
                    AppMethodBeat.m2505o(91368);
                    return;
                    break;
            }
            countDownLatch.countDown();
            AppMethodBeat.m2505o(91368);
        }
    }

    public C40197b() {
        AppMethodBeat.m2504i(91370);
        AppMethodBeat.m2505o(91370);
    }

    public final C29745a adR(String str) {
        AppMethodBeat.m2504i(91371);
        C29745a c35579e = new C35579e(str);
        CountDownLatch countDownLatch = (CountDownLatch) this.uce.get(c35579e);
        if (countDownLatch != null) {
            C4990ab.m7417i("FTSMatchContact", "have a running task ,wait for result, query %s,maxMatch %d", str, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        } else if (C40197b.m68936a(c35579e, this.ucf)) {
            C4990ab.m7417i("FTSMatchContact", "not have a running task ,start new task, query %s,maxMatch %d", str, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
            countDownLatch = new CountDownLatch(1);
            this.uce.put(c35579e, countDownLatch);
        } else {
            C4990ab.m7417i("FTSMatchContact", "start new task fail, query %s,maxMatch %d", str, Integer.valueOf(BaseClientBuilder.API_PRIORITY_OTHER));
        }
        if (countDownLatch != null) {
            try {
                countDownLatch.await(FaceGestureDetGLThread.BRIGHTNESS_DURATION, TimeUnit.MILLISECONDS);
            } catch (Exception e) {
                C4990ab.printErrStackTrace("FTSMatchContact", e, "", new Object[0]);
            }
        }
        this.uce.remove(c35579e);
        AppMethodBeat.m2505o(91371);
        return c35579e;
    }

    /* renamed from: a */
    public final void mo56307a(C29745a c29745a, C35578a c35578a) {
        AppMethodBeat.m2504i(91372);
        this.jxd.put(c29745a, c35578a);
        C40197b.m68936a(c29745a, this.ucg);
        AppMethodBeat.m2505o(91372);
    }

    /* renamed from: a */
    private static boolean m68936a(C29745a c29745a, C28114l c28114l) {
        AppMethodBeat.m2504i(91373);
        if (C5046bo.isNullOrNil(c29745a.query)) {
            AppMethodBeat.m2505o(91373);
            return false;
        }
        int[] iArr = new int[]{WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT};
        int[] iArr2 = new int[]{1, 5};
        C20846i c20846i = new C20846i();
        c20846i.query = c29745a.query;
        c20846i.mEr = iArr;
        c20846i.mEs = iArr2;
        c20846i.mEt = c29745a.ucd;
        c20846i.mEv = C39132b.mEV;
        c20846i.mEu = new HashSet();
        c20846i.mEw = c28114l;
        c20846i.scene = 1;
        ((C12029n) C1720g.m3530M(C12029n.class)).search(2, c20846i).mDs = c29745a;
        AppMethodBeat.m2505o(91373);
        return true;
    }
}
