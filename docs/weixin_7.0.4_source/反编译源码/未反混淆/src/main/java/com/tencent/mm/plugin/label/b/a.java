package com.tencent.mm.plugin.label.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.cc;
import com.tencent.mm.protocal.protobuf.cd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.af;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends m implements k {
    private final b ehh;
    private f ehi;
    private LinkedList<axj> nHw = new LinkedList();

    public a(String str) {
        AppMethodBeat.i(22520);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cc();
        aVar.fsK = new cd();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        if (!bo.isNullOrNil(str)) {
            axj axj = new axj();
            axj.wBq = str;
            this.nHw.add(axj);
        }
        AppMethodBeat.o(22520);
    }

    public a(List<String> list) {
        AppMethodBeat.i(22521);
        com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
        aVar.fsJ = new cc();
        aVar.fsK = new cd();
        aVar.uri = "/cgi-bin/micromsg-bin/addcontactlabel";
        aVar.fsI = com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX;
        aVar.fsL = 0;
        aVar.fsM = 0;
        this.ehh = aVar.acD();
        if (list != null && list.size() > 0) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                axj axj = new axj();
                axj.wBq = (String) list.get(i);
                this.nHw.add(axj);
            }
        }
        AppMethodBeat.o(22521);
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(22522);
        ab.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene].");
        this.ehi = fVar;
        cc ccVar = (cc) this.ehh.fsG.fsP;
        if (this.nHw == null || this.nHw.size() <= 0) {
            ab.e("MicroMsg.Label.NetSceneAddContactLabel", "cpan[doScene] label list is null.");
            fVar.onSceneEnd(3, -1, "[doScene]empty contact list.", this);
            AppMethodBeat.o(22522);
            return 0;
        }
        ccVar.vEm = this.nHw;
        ccVar.vEl = this.nHw.size();
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(22522);
        return a;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(22523);
        ab.d("MicroMsg.Label.NetSceneAddContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        cd bJb = bJb();
        if (bJb != null) {
            LinkedList linkedList = bJb.vEm;
            ArrayList arrayList = new ArrayList();
            int size = linkedList.size();
            for (int i4 = 0; i4 < size; i4++) {
                axj axj = (axj) linkedList.get(i4);
                af afVar = new af();
                afVar.field_labelID = axj.wBr;
                afVar.field_labelName = axj.wBq;
                afVar.field_labelPYFull = g.vo(axj.wBq);
                afVar.field_labelPYShort = g.vp(axj.wBq);
                afVar.field_isTemporary = false;
                arrayList.add(afVar);
            }
            com.tencent.mm.plugin.label.e.bIZ().eq(arrayList);
            com.tencent.mm.plugin.label.e.bIZ().er(arrayList);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(22523);
    }

    public final int getType() {
        return com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.b.CTRL_INDEX;
    }

    public final cd bJb() {
        return (cd) this.ehh.fsH.fsP;
    }
}
