package com.tencent.p177mm.plugin.nearlife.p1494b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C44178uv;
import com.tencent.p177mm.protocal.protobuf.C44179uw;
import com.tencent.p177mm.protocal.protobuf.axx;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.nearlife.b.b */
public final class C46110b extends C1207m implements C1918k {
    private C7472b fsB;
    private C1202f oRe;
    public String oRf;

    public C46110b(String str, String str2, String str3, axx axx, int i, LinkedList<bts> linkedList, String str4) {
        AppMethodBeat.m2504i(22924);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C44178uv();
        c1196a.fsK = new C44179uw();
        c1196a.uri = "/cgi-bin/micromsg-bin/createpoi";
        this.fsB = c1196a.acD();
        String bc = C5046bo.m7532bc(str4, "");
        String bc2 = C5046bo.m7532bc(null, "");
        C44178uv c44178uv = (C44178uv) this.fsB.fsG.fsP;
        c44178uv.Name = str;
        c44178uv.wcl = str2;
        c44178uv.wcn = axx;
        c44178uv.jBv = i;
        if (linkedList != null) {
            c44178uv.wco = linkedList;
        }
        c44178uv.wcp = bc;
        c44178uv.wcq = bc2;
        c44178uv.wcm = str3;
        C4990ab.m7411d("MicroMsg.NetSceneCreatePoi", "[req] name:%s, district:%s, Street: %s lat:%f, long:%f, count:%d, tel:%s, url:%s", str, str2, str3, Float.valueOf(axx.vRq), Float.valueOf(axx.vRp), Integer.valueOf(i), bc, bc2);
        AppMethodBeat.m2505o(22924);
    }

    public final int getType() {
        return 650;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(22925);
        this.oRe = c1202f;
        int a = mo4457a(c1902e, this.fsB, this);
        AppMethodBeat.m2505o(22925);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(22926);
        C4990ab.m7411d("MicroMsg.NetSceneCreatePoi", "netId:%d, errType:%d, errCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        C44179uw c44179uw = (C44179uw) this.fsB.fsH.fsP;
        if (this.fsB.fsH.vyl != 0) {
            this.oRe.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(22926);
            return;
        }
        this.oRf = c44179uw.wcr;
        C4990ab.m7410d("MicroMsg.NetSceneCreatePoi", "poi:" + this.oRf);
        this.oRe.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(22926);
    }
}
