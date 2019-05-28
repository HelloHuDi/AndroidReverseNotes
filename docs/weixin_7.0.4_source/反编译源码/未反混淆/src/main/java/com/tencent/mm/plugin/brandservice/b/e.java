package com.tencent.mm.plugin.brandservice.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.adv;
import com.tencent.mm.protocal.protobuf.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends m implements k {
    private final b ehh;
    private f ehi;
    LinkedList<String> jKy;

    public e() {
        String str;
        AppMethodBeat.i(13836);
        a aVar = new a();
        aVar.fsJ = new adu();
        aVar.fsK = new adv();
        aVar.uri = "/cgi-bin/micromsg-bin/getapplist";
        this.ehh = aVar.acD();
        this.jKy = new LinkedList();
        adu adu = (adu) this.ehh.fsG.fsP;
        g.RQ();
        Object obj = g.RP().Ry().get(196610, null);
        String str2 = "MicroMsg.BrandService.BrandServiceApplication";
        String str3 = "get config, key[%d], value[%s]";
        Object[] objArr = new Object[2];
        objArr[0] = Integer.valueOf(196610);
        if (obj == null) {
            str = BuildConfig.COMMAND;
        } else {
            str = obj.toString();
        }
        objArr[1] = str;
        ab.i(str2, str3, objArr);
        adu.wlU = bo.a((Integer) obj, 0);
        ab.i("MicroMsg.BrandService.NetSceneGetAppList", "info: request hash code %d", Integer.valueOf(adu.wlU));
        AppMethodBeat.o(13836);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(13837);
        ab.w("MicroMsg.BrandService.NetSceneGetAppList", "on scene end code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 == 0 && i3 == 0) {
            adv adv = (adv) this.ehh.fsH.fsP;
            ab.i("MicroMsg.BrandService.NetSceneGetAppList", "ok, hash code is %d, count is %d", Integer.valueOf(adv.wlU), Integer.valueOf(adv.jBv));
            com.tencent.mm.plugin.brandservice.b.h(196610, Integer.valueOf(adv.wlU));
            Iterator it = adv.jBw.iterator();
            while (it.hasNext()) {
                this.jKy.add(((ah) it.next()).jBB);
            }
        }
        this.ehi.onSceneEnd(i2, i3, str, this);
        AppMethodBeat.o(13837);
    }

    public final int getType() {
        return 387;
    }

    public final int a(com.tencent.mm.network.e eVar, f fVar) {
        AppMethodBeat.i(13838);
        this.ehi = fVar;
        ab.i("MicroMsg.BrandService.NetSceneGetAppList", "do scene");
        int a = a(eVar, this.ehh, this);
        AppMethodBeat.o(13838);
        return a;
    }
}
