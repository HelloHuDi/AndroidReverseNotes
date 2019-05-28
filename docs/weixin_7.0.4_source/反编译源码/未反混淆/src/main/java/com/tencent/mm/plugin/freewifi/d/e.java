package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.plugin.freewifi.model.j;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.acm;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class e extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20781);
        a aVar = new a();
        aVar.fsJ = new acm();
        aVar.fsK = new acn();
        aVar.uri = "/cgi-bin/mmo2o-bin/freewifireport";
        aVar.fsI = 1781;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20781);
    }

    public final int getType() {
        return 1781;
    }

    public e(LinkedList<acl> linkedList) {
        AppMethodBeat.i(20782);
        bzd();
        if (linkedList.size() > 0) {
            ((acm) this.ehh.fsG.fsP).wkj = linkedList;
        }
        AppMethodBeat.o(20782);
    }

    /* Access modifiers changed, original: protected|final */
    public final void b(int i, int i2, int i3, String str) {
        AppMethodBeat.i(20783);
        ab.i("MicroMsg.FreeWifi.NetSceneFreeWifiReport", "doBeforeCallback. netId=%d, errType=%d, errCode=%d, errMsg=%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (m.eg(i2, i3)) {
            j.bza().byI().post(new Runnable() {
                public final void run() {
                    if (((acn) e.this.ehh.fsH.fsP) == null) {
                    }
                }
            });
        }
        AppMethodBeat.o(20783);
    }

    public final LinkedList<acl> bzl() {
        acn acn = (acn) this.ehh.fsH.fsP;
        if (acn == null) {
            return null;
        }
        return acn.wkj;
    }
}
