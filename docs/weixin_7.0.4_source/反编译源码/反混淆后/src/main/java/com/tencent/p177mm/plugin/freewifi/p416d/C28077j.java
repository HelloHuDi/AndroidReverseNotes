package com.tencent.p177mm.plugin.freewifi.p416d;

import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bai;
import com.tencent.p177mm.protocal.protobuf.baj;
import com.tencent.p177mm.protocal.protobuf.bak;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.freewifi.d.j */
public final class C28077j extends C43104c {
    /* Access modifiers changed, original: protected|final */
    public final void bzd() {
        AppMethodBeat.m2504i(20793);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bai();
        c1196a.fsK = new baj();
        c1196a.uri = "/cgi-bin/mmo2o-bin/manufacturerapinfo";
        c1196a.fsI = 1707;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(20793);
    }

    public final int getType() {
        return 1707;
    }

    public C28077j(LinkedList<bak> linkedList, int i) {
        AppMethodBeat.m2504i(20794);
        bzd();
        bai bai = (bai) this.ehh.fsG.fsP;
        bai.wEf = Build.BRAND;
        bai.wEe = i;
        bai.wEd = linkedList;
        AppMethodBeat.m2505o(20794);
    }

    public final baj bzp() {
        return (baj) this.ehh.fsH.fsP;
    }
}
