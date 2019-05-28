package com.tencent.p177mm.plugin.qqmail.p486b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.appbrand.jsapi.video.C19517g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.qqmail.b.r */
public final class C21522r extends C1207m implements C1918k {
    private C7472b ehh;
    private C1202f ehi;
    private ArrayList<Long> puy;

    public C21522r(ArrayList<Long> arrayList) {
        AppMethodBeat.m2504i(67978);
        this.puy = arrayList;
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new C28740c();
        c1196a.fsK = new C12887d();
        c1196a.uri = "/cgi-bin/micromsg-bin/checkconversationfile";
        c1196a.fsI = C19517g.CTRL_INDEX;
        this.ehh = c1196a.acD();
        AppMethodBeat.m2505o(67978);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(67979);
        C4990ab.m7417i("MicroMsg.NetSceneCheckConversationFile", "onGYNetEnd, netId: %d, errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if ((i2 == 0 && i3 == 0) || this.ehi == null) {
            if (this.ehi != null) {
                this.ehi.onSceneEnd(i2, i3, str, this);
            }
            AppMethodBeat.m2505o(67979);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(67979);
    }

    public final int getType() {
        return C19517g.CTRL_INDEX;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(67980);
        this.ehi = c1202f;
        C28740c c28740c = (C28740c) this.ehh.fsG.fsP;
        c28740c.jBv = this.puy.size();
        LinkedList linkedList = new LinkedList();
        Iterator it = this.puy.iterator();
        while (it.hasNext()) {
            long longValue = ((Long) it.next()).longValue();
            C39537h c39537h = new C39537h();
            c39537h.ptF = longValue;
            linkedList.add(c39537h);
            C4990ab.m7417i("MicroMsg.NetSceneCheckConversationFile", "MsgId: %d", Long.valueOf(longValue));
        }
        c28740c.ptt = linkedList;
        C4990ab.m7417i("MicroMsg.NetSceneCheckConversationFile", "Count = %d, MsgInfoList.size = %d", Integer.valueOf(c28740c.jBv), Integer.valueOf(c28740c.ptt.size()));
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(67980);
        return a;
    }

    public final LinkedList<C46148g> ccu() {
        return ((C12887d) this.ehh.fsH.fsP).ptu;
    }
}
