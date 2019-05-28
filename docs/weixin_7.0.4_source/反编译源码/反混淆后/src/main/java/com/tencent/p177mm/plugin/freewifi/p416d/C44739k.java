package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C40542lf;
import com.tencent.p177mm.protocal.protobuf.C46561lg;
import com.tencent.p177mm.protocal.protobuf.C7258di;
import com.tencent.p177mm.protocal.protobuf.buc;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.freewifi.d.k */
public final class C44739k extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20795);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C40542lf();
        c1196a.fsK = new C46561lg();
        c1196a.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        c1196a.fsI = 1705;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20795);
    }

    public final int getType() {
        return 1705;
    }

    public C44739k(String str, buc buc, int i, String str2) {
        AppMethodBeat.m2504i(20796);
        bzd();
        if (!(8 == i && 9 == i)) {
            C4990ab.m7413e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", Integer.valueOf(i));
        }
        C40542lf c40542lf = (C40542lf) this.ehh.fsG.fsP;
        c40542lf.vMR = str;
        c40542lf.vOL = buc;
        c40542lf.vAM = i;
        c40542lf.vAN = str2;
        AppMethodBeat.m2505o(20796);
    }

    public final String bzq() {
        AppMethodBeat.m2504i(20797);
        LinkedList linkedList = ((C46561lg) this.ehh.fsH.fsP).vOM;
        if (linkedList == null || linkedList.size() != 1) {
            AppMethodBeat.m2505o(20797);
            return null;
        }
        String str = ((C7258di) linkedList.get(0)).vFm;
        AppMethodBeat.m2505o(20797);
        return str;
    }
}
