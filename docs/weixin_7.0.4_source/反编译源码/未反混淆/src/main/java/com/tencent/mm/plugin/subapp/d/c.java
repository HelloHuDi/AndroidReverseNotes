package com.tencent.mm.plugin.subapp.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fu;
import com.tencent.mm.modelvoice.m;
import com.tencent.mm.modelvoice.p;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bo;
import org.xwalk.core.Log;

public final class c extends com.tencent.mm.sdk.b.c<fu> {
    public c() {
        AppMethodBeat.i(25327);
        this.xxI = fu.class.getName().hashCode();
        AppMethodBeat.o(25327);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(25328);
        fu fuVar = (fu) bVar;
        if (fuVar == null) {
            AppMethodBeat.o(25328);
            return false;
        } else if (bo.isNullOrNil(fuVar.czM.fileName)) {
            Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo fileName is null");
            AppMethodBeat.o(25328);
            return false;
        } else {
            p uZ = m.ama().uZ(fuVar.czM.fileName);
            if (uZ == null) {
                Log.e("MicroMsg.VoiceTransformResultClickEventListener", "alvinluo voiceInfo is null");
                AppMethodBeat.o(25328);
                return false;
            }
            b.b(uZ.clientId, fuVar.czM.czN, fuVar.czM.czO, fuVar.czM.czP, fuVar.czM.result);
            AppMethodBeat.o(25328);
            return true;
        }
    }
}
