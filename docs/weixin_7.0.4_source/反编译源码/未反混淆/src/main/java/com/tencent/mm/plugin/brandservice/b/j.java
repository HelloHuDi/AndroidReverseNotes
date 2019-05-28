package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.lk;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.List;

public final class j extends m implements k {
    private final b ehh;
    private f ehi;

    public j(List<lk> list) {
        AppMethodBeat.i(13852);
        a aVar = new a();
        aVar.fsJ = new bxl();
        aVar.fsK = new bxm();
        aVar.uri = "/cgi-bin/micromsg-bin/setapplist";
        this.ehh = aVar.acD();
        bxl bxl = (bxl) this.ehh.fsG.fsP;
        LinkedList linkedList = new LinkedList();
        for (lk lkVar : list) {
            ah ahVar = new ah();
            ahVar.jBB = lkVar.userName;
            linkedList.add(ahVar);
        }
        bxl.jBv = linkedList.size();
        bxl.jBw = linkedList;
        ab.i("MicroMsg.BrandService.NetSceneSetAppList", "info: upload size %d, toString %s", Integer.valueOf(linkedList.size()), linkedList.toString());
        AppMethodBeat.o(13852);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13853);
        ab.i("MicroMsg.BrandService.NetSceneSetAppList", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            ab.i("MicroMsg.BrandService.NetSceneSetAppList", "ok, hash code is %d", Integer.valueOf(((bxm) this.ehh.fsH.fsP).wlU));
            com.tencent.mm.plugin.brandservice.b.h(196610, Integer.valueOf(r0.wlU));
            com.tencent.mm.plugin.brandservice.b.h(196611, Boolean.FALSE);
        } else {
            com.tencent.mm.plugin.brandservice.b.h(196611, Boolean.TRUE);
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13853);
    }

    public final int getType() {
        return 386;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(13854);
        this.ehi = fVar;
        ab.i("MicroMsg.BrandService.NetSceneSetAppList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13854);
        return a;
    }
}
