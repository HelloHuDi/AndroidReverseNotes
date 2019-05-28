package com.tencent.mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.sdk.platformtools.ab;

public class a implements com.tencent.mm.ipcinvoker.a<Bundle, Bundle> {
    public final /* synthetic */ void a(Object obj, c cVar) {
        AppMethodBeat.i(131365);
        StringBuilder stringBuilder = new StringBuilder("0,");
        d.aEF();
        String stringBuilder2 = stringBuilder.append(d.aED()).toString();
        d.aEF();
        ab.i("MicroMsg.OfflineVoice.IPCLoadPaySpeechDialectConfig", "idsStr:%s  resId:%s", stringBuilder2, d.aEE());
        Bundle bundle = new Bundle();
        bundle.putString("idsStr", stringBuilder2);
        bundle.putString("resId", r1);
        if (cVar != null) {
            cVar.ao(bundle);
        }
        AppMethodBeat.o(131365);
    }
}
