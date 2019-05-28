package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15356kn;
import com.tencent.p177mm.protocal.protobuf.C30197ko;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.scanner.a.c */
public final class C21677c extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;

    public C21677c(String str, LinkedList<String> linkedList, int i, String str2, double d, double d2) {
        AppMethodBeat.m2504i(80831);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15356kn();
        c1196a.fsK = new C30197ko();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscangetactioninfo";
        c1196a.fsI = FilterEnum4Shaka.MIC_WEISHI_HUANGDAN;
        this.ehh = c1196a.acD();
        C15356kn c15356kn = (C15356kn) this.ehh.fsG.fsP;
        c15356kn.ProductID = str;
        c15356kn.Scene = i;
        c15356kn.vNG = str2;
        c15356kn.vNF = linkedList;
        c15356kn.vNI = d2;
        c15356kn.vNH = d;
        AppMethodBeat.m2505o(80831);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(80832);
        C4990ab.m7416i("MicroMsg.NetSceneGetActionInfo", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(80832);
    }

    public final int getType() {
        return FilterEnum4Shaka.MIC_WEISHI_HUANGDAN;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(80833);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(80833);
        return a;
    }
}
