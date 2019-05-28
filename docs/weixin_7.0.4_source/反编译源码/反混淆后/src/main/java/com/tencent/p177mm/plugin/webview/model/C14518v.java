package com.tencent.p177mm.plugin.webview.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.azk;
import com.tencent.p177mm.protocal.protobuf.azl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.webview.model.v */
public final class C14518v extends C1207m implements C1918k {
    private C1202f eIc;
    private final C7472b ehh;
    public String kKw;
    public String kKx;
    public String sign;
    public String ulZ;
    public int uma;

    public C14518v(String str, String str2, String str3) {
        AppMethodBeat.m2504i(6628);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new azk();
        c1196a.fsK = new azl();
        c1196a.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        this.ehh = c1196a.acD();
        azk azk = (azk) this.ehh.fsG.fsP;
        azk.app_id = str;
        azk.wmb = str2;
        azk.kfT = str3;
        AppMethodBeat.m2505o(6628);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(6629);
        C4990ab.m7417i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            azl azl = (azl) this.ehh.fsH.fsP;
            this.ulZ = azl.ulZ;
            this.sign = azl.sign;
            this.kKx = azl.kKx;
            this.kKw = azl.kKw;
            this.uma = azl.uma;
            C4990ab.m7411d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", this.ulZ, this.sign, this.kKx, this.kKw, Integer.valueOf(this.uma));
        }
        this.eIc.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(6629);
    }

    public final int getType() {
        return 1177;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(6630);
        this.eIc = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(6630);
        return a;
    }
}
