package com.tencent.mm.plugin.appbrand.jsapi.audio;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.t;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class m extends a {
    public static final int CTRL_INDEX = 481;
    public static final String NAME = "setInnerAudioOption";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(137794);
        boolean optBoolean = jSONObject.optBoolean("mixWithOther", true);
        com.tencent.mm.ag.a aVar = new com.tencent.mm.ag.a();
        aVar.fqI = optBoolean;
        ab.i("MicroMsg.AudioPlayerHelper", "setAudioContextOption, mixWithOther:%b", Boolean.valueOf(aVar.fqI));
        t tVar = new t();
        tVar.csI.action = 19;
        tVar.csI.csM = aVar;
        com.tencent.mm.plugin.music.b.a.a(tVar);
        cVar.M(i, j("ok", null));
        AppMethodBeat.o(137794);
    }
}
