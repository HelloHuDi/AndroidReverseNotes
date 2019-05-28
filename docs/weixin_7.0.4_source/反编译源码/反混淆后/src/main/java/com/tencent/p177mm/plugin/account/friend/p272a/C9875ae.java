package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.aux;
import com.tencent.p177mm.protocal.protobuf.auy;
import com.tencent.p177mm.protocal.protobuf.auz;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ae */
public final class C9875ae extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi;
    private LinkedList<aux> gwg;
    public String gwh;

    public C9875ae(ArrayList<String> arrayList) {
        int i = 0;
        AppMethodBeat.m2504i(108462);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new auy();
        c1196a.fsK = new auz();
        c1196a.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        this.ehh = c1196a.acD();
        this.gwg = new LinkedList();
        if (arrayList.size() > 0) {
            while (true) {
                int i2 = i;
                if (i2 >= arrayList.size()) {
                    break;
                }
                aux aux = new aux();
                aux.vLf = (String) arrayList.get(i2);
                this.gwg.add(aux);
                i = i2 + 1;
            }
        }
        AppMethodBeat.m2505o(108462);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108463);
        C4990ab.m7416i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.ehi = c1202f;
        auy auy = (auy) this.ehh.fsG.fsP;
        auy.jBv = this.gwg.size();
        auy.jBw = this.gwg;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108463);
        return a;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108464);
        C4990ab.m7417i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.m2505o(108464);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108464);
    }

    public final auz aqh() {
        return (auz) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 489;
    }
}
