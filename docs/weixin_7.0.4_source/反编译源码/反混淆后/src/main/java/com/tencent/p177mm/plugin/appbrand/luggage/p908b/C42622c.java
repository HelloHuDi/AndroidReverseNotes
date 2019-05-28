package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import com.tencent.luggage.sdk.customize.C0997b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.appbrand.app.C42340f;
import com.tencent.p177mm.plugin.appbrand.appcache.C38105ax;
import com.tencent.p177mm.plugin.appbrand.appstorage.C42362b;
import com.tencent.p177mm.plugin.appbrand.config.C33134c;
import com.tencent.p177mm.plugin.appbrand.p1468a.C33065d;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C14839b.C14845c;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p594a.C30039i;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C14856q.C14857a;
import com.tencent.p177mm.pluginsdk.p592g.p593a.p596c.C44049s;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.c */
public final class C42622c implements C0997b {
    /* renamed from: E */
    public final <T> T mo3973E(Class<T> cls) {
        AppMethodBeat.m2504i(132096);
        Object E = C42340f.m74878E(cls);
        AppMethodBeat.m2505o(132096);
        return E;
    }

    /* renamed from: xF */
    public final C38105ax mo3974xF() {
        AppMethodBeat.m2504i(132097);
        C38105ax xF = ((C33065d) C1720g.m3528K(C33065d.class)).mo53635xF();
        AppMethodBeat.m2505o(132097);
        return xF;
    }

    /* renamed from: xG */
    public final C42362b mo3975xG() {
        AppMethodBeat.m2504i(132098);
        C42362b xG = C42340f.m74879xG();
        AppMethodBeat.m2505o(132098);
        return xG;
    }

    /* renamed from: xH */
    public final C33134c mo3976xH() {
        AppMethodBeat.m2504i(132099);
        C33134c xH = C42340f.m74880xH();
        AppMethodBeat.m2505o(132099);
        return xH;
    }

    /* renamed from: xI */
    public final void mo3977xI() {
        int i;
        AppMethodBeat.m2504i(132100);
        C14839b dif = C14845c.veg;
        C14845c.veg;
        C44049s ajg = C14857a.vfA.ajg(C30039i.m47549gN(38, 1));
        if (ajg == null) {
            i = 0;
        } else {
            i = C5046bo.getInt(ajg.field_fileVersion, 0);
        }
        dif.mo27152f(38, 1, i, false);
        AppMethodBeat.m2505o(132100);
    }
}
