package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.afx;
import com.tencent.p177mm.protocal.protobuf.afy;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aj.t */
public final class C17904t extends C1207m implements C1918k {
    private Object data;
    public C7472b ehh;
    private C1202f ehi;

    /* renamed from: a */
    public static void m28113a(C1202f c1202f) {
        AppMethodBeat.m2504i(11444);
        C1720g.m3535RO().eJo.mo14539a(1285, c1202f);
        AppMethodBeat.m2505o(11444);
    }

    /* renamed from: b */
    public static void m28114b(C1202f c1202f) {
        AppMethodBeat.m2504i(11445);
        C1720g.m3535RO().eJo.mo14546b(1285, c1202f);
        AppMethodBeat.m2505o(11445);
    }

    /* renamed from: o */
    public static boolean m28115o(String str, String str2, String str3) {
        AppMethodBeat.m2504i(11446);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("brand_user_name", str2);
            jSONObject.put("bizchat_id", str3);
            boolean a = C1720g.m3535RO().eJo.mo14541a(new C17904t(str, jSONObject.toString()), 0);
            AppMethodBeat.m2505o(11446);
            return a;
        } catch (Exception e) {
            AppMethodBeat.m2505o(11446);
            return false;
        }
    }

    private C17904t(String str, String str2) {
        AppMethodBeat.m2504i(11447);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afx();
        c1196a.fsK = new afy();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiresult";
        this.ehh = c1196a.acD();
        afx afx = (afx) this.ehh.fsG.fsP;
        afx.wbO = str;
        afx.f17914Cn = 1;
        afx.data = str2;
        this.data = null;
        AppMethodBeat.m2505o(11447);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11448);
        C4990ab.m7411d("MicroMsg.NetSceneGetBizJsApiResult", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11448);
    }

    public final int getType() {
        return 1285;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11449);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneGetBizJsApiResult", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11449);
        return a;
    }
}
