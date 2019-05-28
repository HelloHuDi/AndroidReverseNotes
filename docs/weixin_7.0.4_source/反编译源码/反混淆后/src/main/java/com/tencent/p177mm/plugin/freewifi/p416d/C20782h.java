package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.acq;
import com.tencent.p177mm.protocal.protobuf.ami;
import com.tencent.p177mm.protocal.protobuf.amj;

/* renamed from: com.tencent.mm.plugin.freewifi.d.h */
public final class C20782h extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20789);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ami();
        c1196a.fsK = new amj();
        c1196a.uri = "/cgi-bin/mmo2o-bin/getpcfrontpage";
        c1196a.fsI = 1760;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20789);
    }

    public final int getType() {
        return 1760;
    }

    public C20782h(String str, int i, String str2) {
        AppMethodBeat.m2504i(20790);
        bzd();
        ami ami = (ami) this.ehh.fsG.fsP;
        ami.appId = str;
        ami.mzT = i;
        ami.cxb = str2;
        AppMethodBeat.m2505o(20790);
    }

    public final acq bzh() {
        amj amj = (amj) this.ehh.fsH.fsP;
        if (amj != null) {
            return amj.vAY;
        }
        return null;
    }
}
