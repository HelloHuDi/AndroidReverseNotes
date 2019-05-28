package com.tencent.p177mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p1176ag.C17874a;
import com.tencent.p177mm.p230g.p231a.C42063t;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.music.p460b.C46093a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.audio.m */
public final class C42475m extends C10296a {
    public static final int CTRL_INDEX = 481;
    public static final String NAME = "setInnerAudioOption";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(137794);
        boolean optBoolean = jSONObject.optBoolean("mixWithOther", true);
        C17874a c17874a = new C17874a();
        c17874a.fqI = optBoolean;
        C4990ab.m7417i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", Boolean.valueOf(c17874a.fqI));
        C42063t c42063t = new C42063t();
        c42063t.csI.action = 19;
        c42063t.csI.csM = c17874a;
        C46093a.m85964a(c42063t);
        c2241c.mo6107M(i, mo73394j("ok", null));
        AppMethodBeat.m2505o(137794);
    }
}
