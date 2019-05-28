package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ane;
import com.tencent.p177mm.protocal.protobuf.anf;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.o */
public final class C14516o extends C1207m implements C1918k {
    private C1202f eIc;
    public final C7472b ehh;
    public Object tag;

    public C14516o(String str, String str2, int i, int i2) {
        AppMethodBeat.m2504i(6607);
        C4990ab.m7411d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", str, str2, Integer.valueOf(i), Integer.valueOf(i2));
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ane();
        c1196a.fsK = new anf();
        c1196a.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        this.ehh = c1196a.acD();
        ane ane = (ane) this.ehh.fsG.fsP;
        ane.URL = str;
        ane.wrL = str2;
        ane.Width = i;
        ane.Height = i2;
        AppMethodBeat.m2505o(6607);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6608);
        C4990ab.m7416i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.eIc.onSceneEnd(i2, i3, str, this);
        if (i2 == 0 && i3 == 0) {
            AppMethodBeat.m2505o(6608);
            return;
        }
        C4990ab.m7412e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        AppMethodBeat.m2505o(6608);
    }

    public final int getType() {
        return 673;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6609);
        C4990ab.m7416i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6609);
        return a;
    }
}
