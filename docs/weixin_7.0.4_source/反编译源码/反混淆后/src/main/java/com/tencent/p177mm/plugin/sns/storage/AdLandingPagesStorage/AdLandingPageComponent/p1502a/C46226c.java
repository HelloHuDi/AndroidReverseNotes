package com.tencent.p177mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p1502a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.ajf;
import com.tencent.p177mm.protocal.protobuf.ajg;
import com.tencent.p177mm.protocal.protobuf.bex;
import com.tencent.p177mm.protocal.protobuf.bey;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a.c */
public final class C46226c extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    public String jsonString;

    public C46226c(String str, String str2, String str3) {
        AppMethodBeat.m2504i(37661);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new ajf();
        c1196a.fsK = new ajg();
        c1196a.uri = "/cgi-bin/mmgame-bin/getgamecanvasinfo";
        this.ehh = c1196a.acD();
        ajf ajf = (ajf) this.ehh.fsG.fsP;
        ajf.fKh = str;
        ajf.wpc = str2;
        ajf.wpd = str3;
        C4990ab.m7416i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: shareType:" + str2 + " sharedAppId :" + str);
        AppMethodBeat.m2505o(37661);
    }

    public C46226c(String str) {
        AppMethodBeat.m2504i(37662);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bex();
        c1196a.fsK = new bey();
        c1196a.uri = "/cgi-bin/mmux-bin/wxaapp/mmuxwxa_officialsync";
        this.ehh = c1196a.acD();
        ((bex) this.ehh.fsG.fsP).wIS = str;
        C4990ab.m7416i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "Req: syncBuffer:".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(37662);
    }

    public final int getType() {
        return this.ehh.fsI;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(37663);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(37663);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(37664);
        C4990ab.m7416i("MicroMsg.NetSceneLandingPagesDynamicUpdate", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str + " sceneType: " + this.ehh.fsI);
        if (this.ehh.fsI == 1337) {
            this.jsonString = ((ajg) ((C7472b) c1929q).fsH.fsP).wlX;
        } else if (this.ehh.fsI == 2721) {
            this.jsonString = ((bey) ((C7472b) c1929q).fsH.fsP).wIT;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(37664);
    }
}
