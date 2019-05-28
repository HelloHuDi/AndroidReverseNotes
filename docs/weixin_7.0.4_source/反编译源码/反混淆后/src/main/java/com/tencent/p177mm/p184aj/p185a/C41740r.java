package com.tencent.p177mm.p184aj.p185a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.C15359lj;
import com.tencent.p177mm.protocal.protobuf.afr;
import com.tencent.p177mm.protocal.protobuf.afs;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/* renamed from: com.tencent.mm.aj.a.r */
public final class C41740r extends C1207m implements C1918k {
    Object data;
    public C7472b ehh;
    private C1202f ehi;
    Map<String, String> fyh = new HashMap();

    public C41740r(LinkedList<C15359lj> linkedList, Object obj) {
        AppMethodBeat.m2504i(11624);
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            C15359lj c15359lj = (C15359lj) it.next();
            LinkedList linkedList2 = c15359lj.vOW;
            String str = c15359lj.vNb;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.fyh.put((String) it2.next(), str);
                }
            }
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afr();
        c1196a.fsK = new afs();
        c1196a.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        c1196a.fsI = 1353;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        ((afr) this.ehh.fsG.fsP).wmU = linkedList;
        this.data = obj;
        AppMethodBeat.m2505o(11624);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(11625);
        C4990ab.m7411d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.ehi != null) {
            this.ehi.onSceneEnd(i2, i3, str, this);
        }
        AppMethodBeat.m2505o(11625);
    }

    public final int getType() {
        return 1353;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(11626);
        this.ehi = c1202f;
        C4990ab.m7416i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(11626);
        return a;
    }
}
