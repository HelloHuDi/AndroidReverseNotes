package com.tencent.p177mm.plugin.account.bind.p1217a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia;
import com.tencent.p177mm.protocal.protobuf.C15355jm;
import com.tencent.p177mm.protocal.protobuf.C35926jn;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.account.bind.a.a */
public final class C38018a extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;

    public C38018a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AppMethodBeat.m2504i(13317);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C15355jm();
        c1196a.fsK = new C35926jn();
        c1196a.uri = "/cgi-bin/micromsg-bin/bindlinkedincontact";
        c1196a.fsI = JsApiChooseMultiMedia.CTRL_INDEX;
        this.ehh = c1196a.acD();
        C15355jm c15355jm = (C15355jm) this.ehh.fsG.fsP;
        c15355jm.vIJ = 1;
        c15355jm.vLk = i;
        c15355jm.vLl = str;
        c15355jm.vLm = str2;
        c15355jm.vLn = str3;
        c15355jm.vLo = str4;
        c15355jm.vLp = str5;
        c15355jm.vLq = str6;
        c15355jm.vLr = str7;
        AppMethodBeat.m2505o(13317);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(13318);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(13318);
        return a;
    }

    public final int getType() {
        return JsApiChooseMultiMedia.CTRL_INDEX;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(13319);
        C4990ab.m7410d("MicroMsg.NetSceneBindLinkedinContact", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        C15355jm c15355jm = (C15355jm) this.ehh.fsG.fsP;
        if (i2 == 0 && i3 == 0) {
            C1720g.m3536RP().mo5239Ry().set(286722, c15355jm.vLm);
            C1720g.m3536RP().mo5239Ry().set(286721, c15355jm.vLl);
            C1720g.m3536RP().mo5239Ry().set(286723, c15355jm.vLn);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(13319);
    }
}
