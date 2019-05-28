package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C23405ke;
import com.tencent.p177mm.protocal.protobuf.afl;
import com.tencent.p177mm.protocal.protobuf.afm;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.a.p */
public final class C25762p extends C1207m implements C1918k {
    public C7472b ehh;
    private C1202f ehi;
    Map<String, String> fyg = new HashMap();

    public C25762p(LinkedList<C23405ke> linkedList) {
        AppMethodBeat.m2504i(11618);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C23405ke c23405ke = (C23405ke) it.next();
            String str = c23405ke.vMV;
            String str2 = c23405ke.vNb;
            if (!(str2 == null || str == null)) {
                this.fyg.put(str, str2);
            }
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afl();
        c1196a.fsK = new afm();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        c1196a.fsI = 1365;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((afl) this.ehh.fsG.fsP).wmS = linkedList;
        AppMethodBeat.m2505o(11618);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11619);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11619);
    }

    public final int getType() {
        return 1365;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11620);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11620);
        return a;
    }
}
