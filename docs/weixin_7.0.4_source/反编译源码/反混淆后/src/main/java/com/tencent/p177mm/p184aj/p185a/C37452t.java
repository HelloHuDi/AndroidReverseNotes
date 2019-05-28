package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aup;
import com.tencent.p177mm.protocal.protobuf.auq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.aj.a.t */
public final class C37452t extends C1207m implements C1918k {
    Object data;
    public C7472b ehh;
    private C1202f ehi;
    public String fye;

    public C37452t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        AppMethodBeat.m2504i(11630);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aup();
        c1196a.fsK = new auq();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        this.ehh = c1196a.acD();
        aup aup = (aup) this.ehh.fsG.fsP;
        aup.wbO = str;
        if (str2 == null) {
            str2 = "";
        }
        aup.wyL = str2;
        aup.wyM = linkedList;
        this.data = obj;
        AppMethodBeat.m2505o(11630);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11631);
        C4990ab.m7411d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11631);
    }

    public final int getType() {
        return 1389;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11632);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11632);
        return a;
    }

    public final auq afo() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (auq) this.ehh.fsH.fsP;
    }
}
