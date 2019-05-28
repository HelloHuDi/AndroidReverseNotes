package com.tencent.mm.plugin.sns.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.bl;
import com.tencent.mm.protocal.protobuf.bm;
import com.tencent.mm.protocal.protobuf.bn;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;

public final class d extends m implements k {
    private b ehh;
    public f ehi;

    public d(String str, int i, bo boVar, int i2, int i3, int i4, com.tencent.mm.bt.b bVar, com.tencent.mm.bt.b bVar2) {
        this(str, i, 1, 0, null, boVar, i2, "", i3, i4, 0, 0, 0, bVar, bVar2);
    }

    public d(String str, int i, int i2, int i3, bl blVar, bo boVar, int i4, String str2, int i5, int i6, int i7, int i8, int i9, com.tencent.mm.bt.b bVar, com.tencent.mm.bt.b bVar2) {
        int i10;
        AppMethodBeat.i(35705);
        a aVar = new a();
        aVar.fsJ = new bm();
        aVar.fsK = new bn();
        if (i6 != 2) {
            aVar.uri = "/cgi-bin/mmoc-bin/ad/exposure";
            aVar.fsI = 1231;
        } else {
            aVar.uri = "/cgi-bin/mmux-bin/adexposure";
            aVar.fsI = 1875;
        }
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        ab.i("MicroMsg.NetSceneAdExposure", "uri %s", this.ehh.uri);
        bm bmVar = (bm) this.ehh.fsG.fsP;
        bmVar.vDK = i3;
        bmVar.type = i2;
        bmVar.scene = i;
        bmVar.qEg = str;
        bmVar.vDN = i5;
        bmVar.vDO = i7;
        bmVar.vDP = i8;
        bmVar.vDz = i9;
        if (blVar != null) {
            bmVar.vDL = blVar;
            ab.i("MicroMsg.NetSceneAdExposure", "exposure_info " + blVar.vDI);
        }
        if (boVar != null) {
            bmVar.vDM = boVar;
            ab.i("MicroMsg.NetSceneAdExposure", "social_info " + boVar.vDR + " " + boVar.vDQ);
        }
        bmVar.bssid = at.gF(ah.getContext());
        bmVar.ssid = at.gE(ah.getContext());
        bmVar.vDu = System.currentTimeMillis();
        bmVar.vDw = i4;
        if (str2 != null) {
            bmVar.vDt = str2;
        }
        if (bVar2 != null) {
            bmVar.vDB = bVar2;
        }
        if (bVar != null) {
            bmVar.vDA = bVar;
        }
        String str3 = "MicroMsg.NetSceneAdExposure";
        StringBuilder append = new StringBuilder("##viewid:").append(str).append(" scene:").append(i).append(" exposureScene:").append(i2).append(" duration:").append(i3).append(" feed_duration:").append(i7).append(" feed_full_duration:").append(i8).append(" ad_type:").append(i4).append(" exposureCount:").append(i5).append(" descXml:").append(str2).append(" flip_status:").append(i9).append(" self_info.length:");
        if (bVar2 == null) {
            i10 = 0;
        } else {
            i10 = bVar2.wR.length;
        }
        append = append.append(i10).append(" source_info.length:");
        if (bVar == null) {
            i10 = 0;
        } else {
            i10 = bVar.wR.length;
        }
        ab.i(str3, append.append(i10).toString());
        AppMethodBeat.o(35705);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(35706);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(35706);
        return a;
    }

    public final int getType() {
        return 1231;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(35707);
        ab.i("MicroMsg.NetSceneAdExposure", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        bn bnVar = (bn) this.ehh.fsH.fsP;
        ab.i("MicroMsg.NetSceneAdExposure", "resp " + bnVar.ret + " msg: " + bnVar.bzH);
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(35707);
    }
}
