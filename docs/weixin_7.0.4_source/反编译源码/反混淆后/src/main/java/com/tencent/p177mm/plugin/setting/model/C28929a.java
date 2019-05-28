package com.tencent.p177mm.plugin.setting.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1682b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1814al;
import com.tencent.p177mm.model.C6668bk.C1835a;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/* renamed from: com.tencent.mm.plugin.setting.model.a */
public final class C28929a {
    public static C3778a qjB;
    private static C28929a qjC;
    public boolean fPO = false;

    /* renamed from: com.tencent.mm.plugin.setting.model.a$a */
    public interface C3778a {
        /* renamed from: Ci */
        void mo8450Ci(int i);
    }

    /* renamed from: com.tencent.mm.plugin.setting.model.a$2 */
    public class C131892 implements C1814al {
        /* renamed from: kx */
        public final void mo5389kx(int i) {
            AppMethodBeat.m2504i(126837);
            if (i < 0 || i >= 100) {
                C1682b.m3429a(null);
                C28929a.this.fPO = false;
            }
            C4990ab.m7411d("MicroMsg.FixToolsUplogModel", "ipxx progress:%d, isUploading:%b", Integer.valueOf(i), Boolean.valueOf(C28929a.this.fPO));
            C28929a.qjB.mo8450Ci(i);
            AppMethodBeat.m2505o(126837);
        }
    }

    /* renamed from: com.tencent.mm.plugin.setting.model.a$1 */
    public class C289301 implements C1835a {
        final /* synthetic */ String ewe;
        final /* synthetic */ int gdi;

        public C289301(String str, int i) {
            this.ewe = str;
            this.gdi = i;
        }

        /* renamed from: a */
        public final void mo4918a(C1902e c1902e) {
            AppMethodBeat.m2504i(126836);
            C1720g.m3540Rg().mo14540a(1, "", 0, false);
            C4990ab.dot();
            C1720g.m3540Rg().mo14540a(2, this.ewe, this.gdi, C1720g.m3531RK());
            AppMethodBeat.m2505o(126836);
        }
    }

    public static C28929a cir() {
        AppMethodBeat.m2504i(126838);
        if (qjC == null) {
            qjC = new C28929a();
        }
        C28929a c28929a = qjC;
        AppMethodBeat.m2505o(126838);
        return c28929a;
    }

    /* renamed from: Ff */
    public static long m45955Ff(String str) {
        AppMethodBeat.m2504i(126839);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        long anU = C5046bo.anU();
        try {
            anU = simpleDateFormat.parse(str).getTime();
        } catch (ParseException e) {
            C4990ab.m7413e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", str, C5046bo.dpG());
        }
        AppMethodBeat.m2505o(126839);
        return anU;
    }
}
