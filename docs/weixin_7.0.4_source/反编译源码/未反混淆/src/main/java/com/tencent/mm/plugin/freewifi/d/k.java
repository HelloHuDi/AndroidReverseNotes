package com.tencent.mm.plugin.freewifi.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.buc;
import com.tencent.mm.protocal.protobuf.di;
import com.tencent.mm.protocal.protobuf.lf;
import com.tencent.mm.protocal.protobuf.lg;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class k extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20795);
        a aVar = new a();
        aVar.fsJ = new lf();
        aVar.fsK = new lg();
        aVar.uri = "/cgi-bin/mmo2o-bin/bizwificonnect";
        aVar.fsI = 1705;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20795);
    }

    public final int getType() {
        return 1705;
    }

    public k(String str, buc buc, int i, String str2) {
        AppMethodBeat.i(20796);
        bzd();
        if (!(8 == i && 9 == i)) {
            ab.e("MicroMsg.FreeWifi.NetSceneScanAndReportNearFieldFreeWifi", "invalid channel, channel is :%d", Integer.valueOf(i));
        }
        lf lfVar = (lf) this.ehh.fsG.fsP;
        lfVar.vMR = str;
        lfVar.vOL = buc;
        lfVar.vAM = i;
        lfVar.vAN = str2;
        AppMethodBeat.o(20796);
    }

    public final String bzq() {
        AppMethodBeat.i(20797);
        LinkedList linkedList = ((lg) this.ehh.fsH.fsP).vOM;
        if (linkedList == null || linkedList.size() != 1) {
            AppMethodBeat.o(20797);
            return null;
        }
        String str = ((di) linkedList.get(0)).vFm;
        AppMethodBeat.o(20797);
        return str;
    }
}
