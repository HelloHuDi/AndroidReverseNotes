package com.tencent.p177mm.plugin.appbrand.jsapi.offlinevoice;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.C18507c;
import com.tencent.p177mm.ipcinvoker.C37866a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.offlinevoice.a */
public class C42556a implements C37866a<Bundle, Bundle> {
    /* renamed from: a */
    public final /* synthetic */ void mo5958a(Object obj, C18507c c18507c) {
        AppMethodBeat.m2504i(131365);
        StringBuilder stringBuilder = new StringBuilder("0,");
        C19463d.aEF();
        String stringBuilder2 = stringBuilder.append(C19463d.aED()).toString();
        C19463d.aEF();
        C4990ab.m7417i("MicroMsg.OfflineVoice.IPCLoadPaySpeechDialectConfig", "idsStr:%s  resId:%s", stringBuilder2, C19463d.aEE());
        Bundle bundle = new Bundle();
        bundle.putString("idsStr", stringBuilder2);
        bundle.putString("resId", r1);
        if (c18507c != null) {
            c18507c.mo5960ao(bundle);
        }
        AppMethodBeat.m2505o(131365);
    }
}
