package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.exdevice.b.k;
import com.tencent.mm.plugin.exdevice.h.b;
import com.tencent.mm.plugin.exdevice.model.i.a;
import com.tencent.mm.plugin.exdevice.service.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;

public final class af implements f {
    c ecA = new c<vi>() {
        {
            AppMethodBeat.i(19407);
            this.xxI = vi.class.getName().hashCode();
            AppMethodBeat.o(19407);
        }

        private boolean a(final vi viVar) {
            boolean z = true;
            AppMethodBeat.i(19408);
            if (viVar instanceof vi) {
                switch (viVar.cSq.cuy) {
                    case 1:
                        ab.i("MicroMsg.WearHardDeviceLogic", "receive register deviceId=%s", viVar.cSq.ceI);
                        i.lto.a(ah.getContext(), new a() {
                            public final void gM(boolean z) {
                                AppMethodBeat.i(19406);
                                if (z) {
                                    af.aA(viVar.cSq.ceI, true);
                                    AppMethodBeat.o(19406);
                                    return;
                                }
                                ab.e("MicroMsg.WearHardDeviceLogic", "GetBoundDeviceLogic Fail, deviceId=%s|deviceType=%s", viVar.cSq.ceI, viVar.cSq.cws);
                                af.aA(viVar.cSq.ceI, false);
                                AppMethodBeat.o(19406);
                            }
                        });
                        break;
                    case 3:
                        b Kv = ad.boW().Kv(viVar.cSq.ceI);
                        vi.a aVar = viVar.cSq;
                        if (Kv == null) {
                            z = false;
                        }
                        aVar.cxT = z;
                        break;
                    case 4:
                        ab.i("MicroMsg.WearHardDeviceLogic", "receive send deviceId=%s", viVar.cSq.ceI);
                        aw.Rg().a(538, af.this);
                        aw.Rg().a(new w(0, viVar.cSq.cws, viVar.cSq.ceI, k.f.boz(), bo.anU(), viVar.cSq.data, 1), 0);
                        break;
                    case 7:
                        aw.Rg().a(541, af.this);
                        aw.Rg().a(new r("AndroidWear", viVar.cSq.cws, viVar.cSq.ceI, 1, new byte[0]), 0);
                        break;
                    case 11:
                        if (!bo.bI(ah.getContext(), ah.getPackageName() + ":exdevice")) {
                            d.dI(ah.getContext());
                            break;
                        }
                        break;
                }
            }
            AppMethodBeat.o(19408);
            return false;
        }
    };

    public af() {
        AppMethodBeat.i(19410);
        com.tencent.mm.sdk.b.a.xxA.c(this.ecA);
        AppMethodBeat.o(19410);
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(19411);
        if (mVar instanceof r) {
            aw.Rg().b(541, (f) this);
            r rVar = (r) mVar;
            if (i == 0 && i2 == 0) {
                ay(rVar.ltF, true);
                AppMethodBeat.o(19411);
                return;
            }
            ay(rVar.ltF, false);
            AppMethodBeat.o(19411);
            return;
        }
        if (mVar instanceof w) {
            aw.Rg().b(538, (f) this);
            w wVar = (w) mVar;
            if (i == 0 && i2 == 0) {
                az(wVar.ltH, true);
                AppMethodBeat.o(19411);
                return;
            }
            az(wVar.ltH, false);
        }
        AppMethodBeat.o(19411);
    }

    private static void ay(String str, boolean z) {
        AppMethodBeat.i(19412);
        ab.i("MicroMsg.WearHardDeviceLogic", "publish auth response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        vi viVar = new vi();
        viVar.cSq.cuy = 8;
        viVar.cSq.cxT = z;
        viVar.cSq.ceI = str;
        com.tencent.mm.sdk.b.a.xxA.m(viVar);
        AppMethodBeat.o(19412);
    }

    private static void az(String str, boolean z) {
        AppMethodBeat.i(19413);
        ab.i("MicroMsg.WearHardDeviceLogic", "publish send response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        vi viVar = new vi();
        viVar.cSq.cuy = 5;
        viVar.cSq.cxT = z;
        viVar.cSq.ceI = str;
        com.tencent.mm.sdk.b.a.xxA.m(viVar);
        AppMethodBeat.o(19413);
    }

    static /* synthetic */ void aA(String str, boolean z) {
        AppMethodBeat.i(19414);
        ab.i("MicroMsg.WearHardDeviceLogic", "publish register response deviceId=%s | isSuccess=%b", str, Boolean.valueOf(z));
        vi viVar = new vi();
        viVar.cSq.cuy = 2;
        viVar.cSq.cxT = z;
        viVar.cSq.ceI = str;
        com.tencent.mm.sdk.b.a.xxA.m(viVar);
        AppMethodBeat.o(19414);
    }
}
