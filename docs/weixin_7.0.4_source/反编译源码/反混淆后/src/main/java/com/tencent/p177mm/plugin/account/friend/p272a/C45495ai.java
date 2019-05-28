package com.tencent.p177mm.plugin.account.friend.p272a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.protocal.protobuf.bts;
import com.tencent.p177mm.protocal.protobuf.bwv;
import com.tencent.p177mm.protocal.protobuf.bww;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.wxmm.v2helper;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.account.friend.a.ai */
public final class C45495ai extends C1207m implements C1918k {
    private final C7472b ehh;
    private C1202f ehi = null;

    public C45495ai(String str, List<String> list) {
        AppMethodBeat.m2504i(108478);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new bwv();
        c1196a.fsK = new bww();
        c1196a.uri = "/cgi-bin/micromsg-bin/sendsmstomfriend";
        c1196a.fsI = v2helper.EMethodSetSendToNetworkOn;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        this.ehh = c1196a.acD();
        bwv bwv = (bwv) this.ehh.fsG.fsP;
        bwv.wdB = str;
        bwv.wCo = new LinkedList();
        bwv.wCn = list.size();
        for (String str2 : list) {
            if (!C5046bo.isNullOrNil(str2)) {
                bwv.wCo.add(new bts().alV(str2));
            }
        }
        AppMethodBeat.m2505o(108478);
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(108479);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.ehh, this);
        AppMethodBeat.m2505o(108479);
        return a;
    }

    public final int getType() {
        return v2helper.EMethodSetSendToNetworkOn;
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(108480);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.m2505o(108480);
    }
}
