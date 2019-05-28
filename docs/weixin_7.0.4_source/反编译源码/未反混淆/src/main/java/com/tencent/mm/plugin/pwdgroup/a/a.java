package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.modelstat.o;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aal;
import com.tencent.mm.protocal.protobuf.aam;
import com.tencent.mm.protocal.protobuf.aan;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.LinkedList;

public final class a extends m implements k {
    public int czW;
    private b ehh;
    private f ehi;

    public a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        AppMethodBeat.i(23980);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new aal();
        aVar.fsK = new aam();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        this.ehh = aVar.acD();
        aal aal = (aal) this.ehh.fsG.fsP;
        this.czW = i;
        aal.OpCode = i;
        aal.wfF = str;
        aal.wdB = str2;
        aal.vRp = f2;
        aal.vRq = f;
        aal.wfG = i2;
        if (!bo.isNullOrNil(str3)) {
            aal.wfH = str3;
        }
        if (!bo.isNullOrNil(str4)) {
            aal.wfI = str4;
        }
        aal.wfJ = i3;
        ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3));
        o.a(TXLiveConstants.PLAY_EVT_PLAY_LOADING, f2, f, i2);
        AppMethodBeat.o(23980);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(23981);
        this.ehi = fVar;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(23981);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(23982);
        ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (this.czW == 0) {
            aam cbS = cbS();
            if (cbS != null) {
                LinkedList linkedList = cbS.vEh;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    ArrayList arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        aan aan = (aan) linkedList.get(i4);
                        h hVar = new h();
                        if (bo.isNullOrNil(aan.jBB)) {
                            hVar.username = aan.wfK;
                        } else {
                            hVar.username = aan.jBB;
                        }
                        ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", aan.jBB, aan.SmallImgUrl);
                        hVar.frV = aan.SmallImgUrl;
                        hVar.cB(true);
                        arrayList.add(hVar);
                    }
                    com.tencent.mm.ah.o.act().aa(arrayList);
                    ab.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", (System.currentTimeMillis() - currentTimeMillis));
                }
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(23982);
    }

    public final int getType() {
        return 653;
    }

    public final aam cbS() {
        return (aam) this.ehh.fsH.fsP;
    }
}
