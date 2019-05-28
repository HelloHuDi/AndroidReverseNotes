package com.tencent.p177mm.plugin.freewifi.p416d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.model.C11976j;
import com.tencent.p177mm.protocal.protobuf.acl;
import com.tencent.p177mm.protocal.protobuf.acm;
import com.tencent.p177mm.protocal.protobuf.acn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.freewifi.d.e */
public final class C45950e extends C43104c {

    /* renamed from: com.tencent.mm.plugin.freewifi.d.e$1 */
    class C31361 implements Runnable {
        C31361() {
        }

        public final void run() {
            if (((acn) C45950e.this.ehh.fsH.fsP) == null) {
            }
        }
    }

    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20781);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new acm();
        c1196a.fsK = new acn();
        c1196a.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        c1196a.fsI = 1781;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20781);
    }

    public final int getType() {
        return 1781;
    }

    public C45950e(LinkedList<acl> linkedList) {
        AppMethodBeat.m2504i(20782);
        bzd();
        if (linkedList.size() > 0) {
            ((acm) this.ehh.fsG.fsP).wkj = linkedList;
        }
        AppMethodBeat.m2505o(20782);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: b */
    public final void mo45999b(int i, int i2, int i3, String str) {
        AppMethodBeat.m2504i(20783);
        C4990ab.m7417i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (C34189m.m56074eg(i2, i3)) {
            C11976j.bza().byI().post(new C31361());
        }
        AppMethodBeat.m2505o(20783);
    }

    public final LinkedList<acl> bzl() {
        acn acn = (acn) this.ehh.fsH.fsP;
        if (acn == null) {
            return null;
        }
        return acn.wkj;
    }
}
