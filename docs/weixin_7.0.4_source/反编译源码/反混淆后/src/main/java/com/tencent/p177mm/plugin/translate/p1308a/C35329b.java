package com.tencent.p177mm.plugin.translate.p1308a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.apa;
import com.tencent.p177mm.protocal.protobuf.apb;
import com.tencent.p177mm.protocal.protobuf.cir;
import com.tencent.p177mm.protocal.protobuf.cis;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.translate.a.b */
public final class C35329b extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;
    public LinkedList<cis> sKv;

    public C35329b(LinkedList<cir> linkedList) {
        AppMethodBeat.m2504i(26058);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new apa();
        c1196a.fsK = new apb();
        c1196a.uri = "/cgi-bin/micromsg-bin/gettranstext";
        c1196a.fsI = 631;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        apa apa = (apa) this.ehh.fsG.fsP;
        apa.wtc = linkedList;
        apa.jBu = linkedList.size();
        AppMethodBeat.m2505o(26058);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(26059);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(26059);
        return a;
    }

    public final int getType() {
        return 631;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(26060);
        this.sKv = ((apb) this.ehh.fsH.fsP).wtc;
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(26060);
    }
}
