package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p1570d.C40433a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C35787e;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p595b.C40427c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C30043n.C30044a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35791j;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C35792l;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C40432m;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.d */
final class C14853d extends C30044a<C14852c> {
    public C14853d(C14852c c14852c) {
        super(c14852c);
    }

    public final String awa() {
        return "CheckResUpdate";
    }

    /* renamed from: gh */
    public final boolean mo9636gh(long j) {
        AppMethodBeat.m2504i(79503);
        if (((C14852c) awh()).fileSize <= 0 || ((C14852c) awh()).fileSize == C40433a.m69347ek(getFilePath()) + j) {
            boolean gh = super.mo9636gh(j);
            AppMethodBeat.m2505o(79503);
            return gh;
        }
        AppMethodBeat.m2505o(79503);
        return false;
    }

    public final boolean awg() {
        AppMethodBeat.m2504i(79504);
        if (super.awg()) {
            C23236j.m35639z(((C14852c) awh()).vdK, 12);
            AppMethodBeat.m2505o(79504);
            return true;
        }
        C23236j.m35639z(((C14852c) awh()).vdK, 27);
        AppMethodBeat.m2505o(79504);
        return false;
    }

    /* renamed from: a */
    public final C40432m mo9630a(C35791j c35791j) {
        AppMethodBeat.m2504i(79505);
        C14852c c14852c = (C14852c) awh();
        String aiX = C30039i.aiX(c14852c.vdC);
        String str = c14852c.cvZ;
        C40432m c40432m;
        if (c14852c.ufy && C5046bo.nullAsNil(C1178g.m2587cz(C30039i.aiX(c14852c.vdC))).equals(str)) {
            C4990ab.m7416i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "file already cached and valid, send complete status");
            c40432m = new C40432m(c14852c, C40433a.m69347ek(aiX));
            AppMethodBeat.m2505o(79505);
            return c40432m;
        } else if (!C5046bo.m7540cb(((C14852c) awh()).veh) && C40433a.m69344D(C30039i.aiX(((C14852c) awh()).vdC), ((C14852c) awh()).veh) && C5046bo.nullAsNil(C1178g.m2587cz(C30039i.aiX(((C14852c) awh()).vdC))).equals(((C14852c) awh()).cvZ)) {
            C40432m c40432m2 = new C40432m((C35792l) awh(), C40433a.m69347ek(C30039i.aiX(((C14852c) awh()).vdC)));
            AppMethodBeat.m2505o(79505);
            return c40432m2;
        } else {
            C40432m a = super.mo9630a(c35791j);
            C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: network get over, received response = ".concat(String.valueOf(a)), c14852c.vdC);
            if (a == null) {
                c40432m = new C40432m("CheckResUpdate", dib(), getURL(), getFilePath(), 0, "", new C35787e());
                AppMethodBeat.m2505o(79505);
                return c40432m;
            }
            if (a.status == 2) {
                if (C5046bo.isNullOrNil(((C14852c) awh()).cvZ) || !((C14852c) awh()).cvZ.equals(C1178g.m2587cz(getFilePath()))) {
                    C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file invalid, md5 not match", c14852c.vdC);
                    c40432m = new C40432m("CheckResUpdate", dib(), getURL(), getFilePath(), a.aHW, a.bqF, new C40427c());
                    AppMethodBeat.m2505o(79505);
                    return c40432m;
                }
                C4990ab.m7417i("MicroMsg.ResDownloader.CheckResUpdate.NetworkRequestRunner", "%s: file valid, md5 ok", c14852c.vdC);
            }
            AppMethodBeat.m2505o(79505);
            return a;
        }
    }
}
