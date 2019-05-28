package com.tencent.p177mm.p184aj;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aww;
import com.tencent.p177mm.protocal.protobuf.awx;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.aj.w */
public final class C32239w extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    public String fwO;
    public int fwP;
    public String tag;

    public C32239w(String str, LinkedList<String> linkedList) {
        this(str, linkedList, (byte) 0);
    }

    private C32239w(String str, LinkedList<String> linkedList, byte b) {
        AppMethodBeat.m2504i(11455);
        this.fwP = 1;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aww();
        c1196a.fsK = new awx();
        c1196a.uri = "/cgi-bin/mmkf-bin/kfgetinfolist";
        c1196a.fsI = 675;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        aww aww = (aww) this.ehh.fsG.fsP;
        aww.wAZ = str;
        aww.wBc = linkedList;
        this.fwO = str;
        this.fwP = 1;
        AppMethodBeat.m2505o(11455);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11456);
        C4990ab.m7417i("MicroMsg.NetSceneKFGetInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11456);
    }

    public final int getType() {
        return 675;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11457);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.NetSceneKFGetInfoList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11457);
        return a;
    }

    public final awx aeO() {
        if (this.ehh == null || this.ehh.fsH.fsP == null) {
            return null;
        }
        return (awx) this.ehh.fsH.fsP;
    }
}
