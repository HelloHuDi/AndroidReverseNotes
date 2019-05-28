package com.tencent.mm.plugin.freewifi.d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.protocal.protobuf.bai;
import com.tencent.mm.protocal.protobuf.baj;
import com.tencent.mm.protocal.protobuf.bak;
import java.util.LinkedList;

public final class j extends c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.i(20793);
        a aVar = new a();
        aVar.fsJ = new bai();
        aVar.fsK = new baj();
        aVar.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        aVar.fsI = 1707;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        AppMethodBeat.o(20793);
    }

    public final int getType() {
        return 1707;
    }

    public j(LinkedList<bak> linkedList, int i) {
        AppMethodBeat.i(20794);
        bzd();
        bai bai = (bai) this.ehh.fsG.fsP;
        bai.wEf = Build.BRAND;
        bai.wEe = i;
        bai.wEd = linkedList;
        AppMethodBeat.o(20794);
    }

    public final baj bzp() {
        return (baj) this.ehh.fsH.fsP;
    }
}
