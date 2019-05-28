package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1201e;
import com.tencent.p177mm.p183ai.C1201e.C1197a;
import com.tencent.p177mm.p183ai.C1201e.C1198b;
import com.tencent.p177mm.p183ai.C1201e.C1199c;
import com.tencent.p177mm.platformtools.C1946aa;
import com.tencent.p177mm.protocal.protobuf.C7254cm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5049br;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.model.bs */
public final class C9651bs implements C1201e {
    /* renamed from: b */
    public final C1198b mo4453b(C1197a c1197a) {
        boolean z = true;
        AppMethodBeat.m2504i(16347);
        C7254cm c7254cm = c1197a.eAB;
        Assert.assertTrue(c7254cm != null);
        if (c7254cm.vED == null) {
            z = false;
        }
        Assert.assertTrue(z);
        Object obj = (String) C5049br.m7595z(C1946aa.m4148a(c7254cm.vED), "tips").get(".tips.tip.url");
        C4990ab.m7418v("MicroMsg.SoftwareMsgExtension", "url:".concat(String.valueOf(obj)));
        C9638aw.m17190ZK();
        C18628c.m29072Ry().set(12308, obj);
        AppMethodBeat.m2505o(16347);
        return null;
    }

    /* renamed from: a */
    public final void mo4452a(C1199c c1199c) {
    }
}
