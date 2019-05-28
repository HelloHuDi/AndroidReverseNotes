package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.audio.d;
import com.tencent.mm.plugin.appbrand.jsapi.audio.f;
import com.tencent.mm.plugin.appbrand.jsapi.audio.h;
import com.tencent.mm.plugin.appbrand.jsapi.audio.l;
import com.tencent.mm.plugin.appbrand.jsapi.b;
import com.tencent.mm.plugin.appbrand.jsapi.b.e;
import com.tencent.mm.plugin.appbrand.jsapi.p.b.a;
import com.tencent.mm.plugin.appbrand.jsapi.p.c;
import java.util.Collection;
import java.util.HashSet;

public class j implements g {
    public static final j iwZ = new j();
    protected Collection<Class<? extends b>> ixa = new HashSet();
    protected Collection<Class<? extends b>> ixb = new HashSet();

    static {
        AppMethodBeat.i(102307);
        AppMethodBeat.o(102307);
    }

    protected j() {
        AppMethodBeat.i(102304);
        this.ixa.add(a.class);
        this.ixa.add(c.a.class);
        this.ixb.add(e.class);
        this.ixb.add(com.tencent.mm.plugin.appbrand.jsapi.k.b.class);
        this.ixb.add(f.class);
        this.ixb.add(JsApiGetMusicPlayerState.class);
        this.ixb.add(JsApiGetBackgroundAudioState.class);
        this.ixb.add(d.class);
        this.ixb.add(f.class);
        this.ixb.add(l.class);
        this.ixb.add(h.class);
        AppMethodBeat.o(102304);
    }

    public final boolean a(b bVar) {
        AppMethodBeat.i(102305);
        if (bVar == null) {
            AppMethodBeat.o(102305);
            return false;
        }
        boolean ak = ak(bVar.getClass());
        AppMethodBeat.o(102305);
        return ak;
    }

    public final boolean ak(Class<? extends b> cls) {
        AppMethodBeat.i(102306);
        if (cls == null) {
            AppMethodBeat.o(102306);
            return false;
        } else if (this.ixb.contains(cls) || this.ixa.contains(cls)) {
            AppMethodBeat.o(102306);
            return true;
        } else {
            AppMethodBeat.o(102306);
            return false;
        }
    }
}
