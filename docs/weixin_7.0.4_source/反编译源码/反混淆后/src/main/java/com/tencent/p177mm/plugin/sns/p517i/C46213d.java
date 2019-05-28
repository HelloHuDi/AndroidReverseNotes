package com.tencent.p177mm.plugin.sns.p517i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C18388rq;
import com.tencent.p177mm.p230g.p232b.p233a.C32675p;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.sns.i.d */
public final class C46213d {
    private static C46213d qSX = null;
    private C4884c<C18388rq> ecA;
    public HashMap<Integer, String> qSY;

    /* renamed from: com.tencent.mm.plugin.sns.i.d$1 */
    class C462121 extends C4884c<C18388rq> {
        C462121() {
            AppMethodBeat.m2504i(36874);
            this.xxI = C18388rq.class.getName().hashCode();
            AppMethodBeat.m2505o(36874);
        }

        /* renamed from: a */
        public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
            AppMethodBeat.m2504i(36875);
            final C18388rq c18388rq = (C18388rq) c4883b;
            C7305d.xDG.execute(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(36873);
                    C46213d.m86419a(C46213d.this, c18388rq.cNC.cND, c18388rq.cNC.cNF);
                    AppMethodBeat.m2505o(36873);
                }
            });
            AppMethodBeat.m2505o(36875);
            return false;
        }
    }

    private C46213d() {
        AppMethodBeat.m2504i(36876);
        this.qSY = null;
        this.ecA = new C462121();
        this.qSY = new HashMap();
        C4879a.xxA.mo10051b(this.ecA);
        AppMethodBeat.m2505o(36876);
    }

    public static C46213d coE() {
        AppMethodBeat.m2504i(36877);
        if (qSX == null) {
            qSX = new C46213d();
        }
        C46213d c46213d = qSX;
        AppMethodBeat.m2505o(36877);
        return c46213d;
    }

    /* renamed from: a */
    static /* synthetic */ void m86419a(C46213d c46213d, long j, HashMap hashMap) {
        AppMethodBeat.m2504i(36878);
        if (!(hashMap == null || hashMap.isEmpty())) {
            for (Integer intValue : hashMap.keySet()) {
                int intValue2 = intValue.intValue();
                String str = (String) c46213d.qSY.remove(Integer.valueOf(intValue2));
                if (!C5046bo.isNullOrNil(str)) {
                    try {
                        intValue2 = ((Integer) hashMap.get(Integer.valueOf(intValue2))).intValue() == 1 ? 1 : 2;
                    } catch (Exception e) {
                        intValue2 = 0;
                    }
                    C32675p c32675p = new C32675p(str);
                    c32675p.mo53207eM(C29036i.m46117jV(j));
                    c32675p.cWH = (long) intValue2;
                    c32675p.ajK();
                    C4990ab.m7417i("MicroMsg.SnsPostReportLogic", "report sns image exif [%s]", c32675p.mo4983Fk());
                }
            }
        }
        AppMethodBeat.m2505o(36878);
    }
}
