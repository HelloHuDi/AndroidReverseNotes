package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23437sa;
import com.tencent.p177mm.protocal.protobuf.C46584rz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.view.C31128d;

/* renamed from: com.tencent.mm.plugin.account.friend.a.y */
public final class C32970y extends C1207m implements C1918k {
    public static int gvV = 1;
    public static int gvW = 2;
    public static int gvX = 3;
    public static int gvY = 4;
    private C7472b ehh;
    private C1202f ehi;

    public C32970y(int i) {
        AppMethodBeat.m2504i(108432);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C46584rz();
        c1196a.fsK = new C23437sa();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkunbind";
        c1196a.fsI = C31128d.MIC_PTU_ZIPAI_LIGHTRED;
        this.ehh = c1196a.acD();
        ((C46584rz) this.ehh.fsG.fsP).vZq = i;
        AppMethodBeat.m2505o(108432);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108433);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108433);
        return a;
    }

    public final String aqd() {
        AppMethodBeat.m2504i(108434);
        try {
            String str = ((C23437sa) this.ehh.fsH.fsP).vZr;
            C4990ab.m7410d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(108434);
            return str;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e, "", new Object[0]);
            AppMethodBeat.m2505o(108434);
            return null;
        }
    }

    public final int getType() {
        return C31128d.MIC_PTU_ZIPAI_LIGHTRED;
    }

    public final C23437sa aqe() {
        return (C23437sa) this.ehh.fsH.fsP;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108435);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108435);
    }
}
