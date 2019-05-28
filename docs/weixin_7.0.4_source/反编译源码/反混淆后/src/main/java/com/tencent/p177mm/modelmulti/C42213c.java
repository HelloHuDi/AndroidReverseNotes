package com.tencent.p177mm.modelmulti;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.network.C1902e;
import com.tencent.p177mm.network.C1918k;
import com.tencent.p177mm.network.C1929q;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.afh;
import com.tencent.p177mm.protocal.protobuf.afi;
import com.tencent.p177mm.protocal.protobuf.atz;
import com.tencent.p177mm.protocal.protobuf.aub;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.List;

/* renamed from: com.tencent.mm.modelmulti.c */
public final class C42213c extends C1207m implements C1918k {
    private C1202f ehi;
    public final C7472b fAT;

    public C42213c(List<atz> list, long j, aub aub) {
        AppMethodBeat.m2504i(16494);
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new afh();
        c1196a.fsK = new afi();
        c1196a.uri = "/cgi-bin/mmo2o-bin/getbeaconspushmessage";
        this.fAT = c1196a.acD();
        afh afh = (afh) this.fAT.fsG.fsP;
        afh.wmF.addAll(list);
        afh.wmI = j;
        afh.wmH = aub;
        C4990ab.m7417i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma]getBeaconsPushMessageReq.beacons.size:%d", Integer.valueOf(afh.wmF.size()));
        AppMethodBeat.m2505o(16494);
    }

    /* renamed from: a */
    public final void mo4498a(int i, int i2, int i3, String str, C1929q c1929q, byte[] bArr) {
        AppMethodBeat.m2504i(16495);
        C4990ab.m7417i("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:netId:%s,errType:%s,errCode:%s,errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.ehi.onSceneEnd(i2, i3, str, this);
        afh afh = (afh) this.fAT.fsG.fsP;
        atz atz = (atz) afh.wmF.get(0);
        aub aub = afh.wmH;
        afi afi = (afi) ((C7472b) c1929q).fsH.fsP;
        if (i2 == 0 && i3 == 0) {
            if (afi.result != 0) {
                C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), atz.eCq, Integer.valueOf(atz.major), Integer.valueOf(atz.minor), String.valueOf(aub.latitude), String.valueOf(aub.longitude), Integer.valueOf(2), Integer.valueOf(afi.result));
            }
            C4990ab.m7410d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end ok");
            AppMethodBeat.m2505o(16495);
            return;
        }
        C7060h.pYm.mo8381e(12659, Integer.valueOf(1), Integer.valueOf(r2.size()), atz.eCq, Integer.valueOf(atz.major), Integer.valueOf(atz.minor), String.valueOf(aub.latitude), String.valueOf(aub.longitude), Integer.valueOf(1), Integer.valueOf(afi.result));
        C4990ab.m7410d("MicroMsg.NetSceneGetBeaconsPushMessage", "[kevinkma][NetSceneGetBeaconsPushMessage]:net end not ok");
        AppMethodBeat.m2505o(16495);
    }

    public final int getType() {
        return 1708;
    }

    /* renamed from: a */
    public final int mo4456a(C1902e c1902e, C1202f c1202f) {
        AppMethodBeat.m2504i(16496);
        this.ehi = c1202f;
        int a = mo4457a(c1902e, this.fAT, this);
        AppMethodBeat.m2505o(16496);
        return a;
    }
}
