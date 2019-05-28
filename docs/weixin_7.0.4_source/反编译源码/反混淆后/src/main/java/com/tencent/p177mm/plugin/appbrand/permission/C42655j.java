package com.tencent.p177mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10332b;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C16633h;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C33242d;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C38261f;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.C44695l;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetMusicPlayerState;
import com.tencent.p177mm.plugin.appbrand.jsapi.p299b.C19311e;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33335b;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C38364b.C38363a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p313p.C38366c.C2332a;
import java.util.Collection;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.appbrand.permission.j */
public class C42655j implements C31331g {
    public static final C42655j iwZ = new C42655j();
    protected Collection<Class<? extends C10332b>> ixa = new HashSet();
    protected Collection<Class<? extends C10332b>> ixb = new HashSet();

    static {
        AppMethodBeat.m2504i(102307);
        AppMethodBeat.m2505o(102307);
    }

    protected C42655j() {
        AppMethodBeat.m2504i(102304);
        this.ixa.add(C38363a.class);
        this.ixa.add(C2332a.class);
        this.ixb.add(C19311e.class);
        this.ixb.add(C33335b.class);
        this.ixb.add(C38261f.class);
        this.ixb.add(JsApiGetMusicPlayerState.class);
        this.ixb.add(JsApiGetBackgroundAudioState.class);
        this.ixb.add(C33242d.class);
        this.ixb.add(C38261f.class);
        this.ixb.add(C44695l.class);
        this.ixb.add(C16633h.class);
        AppMethodBeat.m2505o(102304);
    }

    /* renamed from: a */
    public final boolean mo51294a(C10332b c10332b) {
        AppMethodBeat.m2504i(102305);
        if (c10332b == null) {
            AppMethodBeat.m2505o(102305);
            return false;
        }
        boolean ak = mo51295ak(c10332b.getClass());
        AppMethodBeat.m2505o(102305);
        return ak;
    }

    /* renamed from: ak */
    public final boolean mo51295ak(Class<? extends C10332b> cls) {
        AppMethodBeat.m2504i(102306);
        if (cls == null) {
            AppMethodBeat.m2505o(102306);
            return false;
        } else if (this.ixb.contains(cls) || this.ixa.contains(cls)) {
            AppMethodBeat.m2505o(102306);
            return true;
        } else {
            AppMethodBeat.m2505o(102306);
            return false;
        }
    }
}
