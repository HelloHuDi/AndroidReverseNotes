package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ft;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends c<ft> {
    public a() {
        AppMethodBeat.i(25324);
        this.xxI = ft.class.getName().hashCode();
        AppMethodBeat.o(25324);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(25325);
        ft ftVar = (ft) bVar;
        if (ftVar == null) {
            AppMethodBeat.o(25325);
            return false;
        } else if (bo.isNullOrNil(ftVar.czK.fileName)) {
            ab.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo fileName is null");
            AppMethodBeat.o(25325);
            return false;
        } else {
            p uZ = m.ama().uZ(ftVar.czK.fileName);
            if (uZ == null) {
                ab.e("MicroMsg.VoiceTransformTextClickEventListener", "alvinluo voiceInfo is null");
                AppMethodBeat.o(25325);
                return false;
            }
            String str;
            int i;
            if (ftVar.czK.czL == 1 || ftVar.czK.czL == 2) {
                str = uZ.clientId;
                i = ftVar.czK.scene;
                ab.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
                h.pYm.e(14220, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
            } else if (ftVar.czK.czL == 3) {
                str = uZ.clientId;
                i = ftVar.czK.scene;
                ab.i("MicroMsg.VoiceTransformTextReporter", "alvinluo reportTransformTextDoubleClick voiceId: %s, clickScene: %d", str, Integer.valueOf(i));
                h.pYm.e(14220, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), str);
            }
            AppMethodBeat.o(25325);
            return true;
        }
    }
}
