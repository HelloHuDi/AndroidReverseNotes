package com.tencent.p177mm.p182ah;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C7564ap;
import com.tencent.p177mm.sdk.platformtools.C7564ap.C5015a;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ah.n */
public final class C45140n {
    private static List<String> fsk = null;
    private static int fsl = 0;
    private static C17882a fsm = new C17882a(new C17883b());

    /* renamed from: com.tencent.mm.ah.n$a */
    static class C17882a extends C7564ap {
        final C17883b fsn;

        public C17882a(C17883b c17883b) {
            super(c17883b, true);
            this.fsn = c17883b;
        }
    }

    /* renamed from: com.tencent.mm.ah.n$b */
    static class C17883b implements C5015a {
        Runnable fso;

        C17883b() {
        }

        /* renamed from: BI */
        public final boolean mo4499BI() {
            AppMethodBeat.m2504i(77950);
            int size = C45140n.fsk.size();
            C4990ab.m7412e("MicroMsg.RemoveAvatarTask", "RemoveOldAvatar left count:".concat(String.valueOf(size)));
            if (size <= 2000 || C45140n.fsl >= 300) {
                if (this.fso != null) {
                    this.fso.run();
                }
                C45140n.fsl = 0;
                AppMethodBeat.m2505o(77950);
                return false;
            }
            long iV = C1720g.m3536RP().eJN.mo15639iV(Thread.currentThread().getId());
            int i = size - 1;
            while (true) {
                int i2 = i;
                if (i2 >= size - 30) {
                    C45140n.acr();
                    String str = (String) C45140n.fsk.get(i2);
                    C45140n.fsk.remove(i2);
                    C17884o.acd();
                    C41732d.m73516E(str, false);
                    C17884o.acd();
                    C41732d.m73516E(str, true);
                    C17884o.act().mo33393qp(str);
                    i = i2 - 1;
                } else {
                    C1720g.m3536RP().eJN.mo15640mB(iV);
                    AppMethodBeat.m2505o(77950);
                    return true;
                }
            }
        }
    }

    static /* synthetic */ int acr() {
        int i = fsl;
        fsl = i + 1;
        return i;
    }

    static {
        AppMethodBeat.m2504i(77953);
        AppMethodBeat.m2505o(77953);
    }

    /* renamed from: x */
    public static void m83007x(Runnable runnable) {
        AppMethodBeat.m2504i(77951);
        if (C1720g.m3534RN().mo5161QY()) {
            C17881i act = C17884o.act();
            ArrayList arrayList = new ArrayList();
            Cursor a = act.fni.mo10104a("select username from img_flag where username not in (select username from rcontact ) and username not like \"%@qqim\" and username not like \"%@bottle\";", null, 2);
            while (a.moveToNext()) {
                arrayList.add(a.getString(0));
            }
            a.close();
            fsk = arrayList;
            if (arrayList.size() <= 0) {
                AppMethodBeat.m2505o(77951);
                return;
            }
            fsm.fsn.fso = runnable;
            fsm.mo16770ae(10, 10);
            AppMethodBeat.m2505o(77951);
            return;
        }
        AppMethodBeat.m2505o(77951);
    }

    public static void acp() {
        AppMethodBeat.m2504i(77952);
        fsl = 0;
        fsm.stopTimer();
        AppMethodBeat.m2505o(77952);
    }
}
