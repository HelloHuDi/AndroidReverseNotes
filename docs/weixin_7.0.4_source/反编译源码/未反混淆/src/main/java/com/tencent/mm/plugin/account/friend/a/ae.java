package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.auz;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.LinkedList;

public final class ae extends m implements k {
    private final b ehh;
    private f ehi;
    private LinkedList<aux> gwg;
    public String gwh;

    public ae(ArrayList<String> arrayList) {
        int i = 0;
        AppMethodBeat.i(108462);
        a aVar = new a();
        aVar.fsJ = new auy();
        aVar.fsK = new auz();
        aVar.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        this.ehh = aVar.acD();
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
        AppMethodBeat.o(108462);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(108463);
        ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.ehi = fVar;
        auy auy = (auy) this.ehh.fsG.fsP;
        auy.jBv = this.gwg.size();
        auy.jBw = this.gwg;
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(108463);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(108464);
        ab.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.ehi.onSceneEnd(i2, i3, str, this);
            AppMethodBeat.o(108464);
            return;
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(108464);
    }

    public final auz aqh() {
        return (auz) this.ehh.fsH.fsP;
    }

    public final int getType() {
        return 489;
    }
}
