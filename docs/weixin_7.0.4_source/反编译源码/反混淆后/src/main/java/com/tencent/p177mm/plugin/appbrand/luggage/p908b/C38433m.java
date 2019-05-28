package com.tencent.p177mm.plugin.appbrand.luggage.p908b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.p1219d.C33139b;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.luggage.b.m */
public final class C38433m implements C33139b {
    private List<C33139b> ikl = new LinkedList();

    public C38433m(C6750i c6750i) {
        AppMethodBeat.m2504i(86994);
        this.ikl.add(new C10606o(c6750i));
        this.ikl.add(new C19594j(c6750i));
        AppMethodBeat.m2505o(86994);
    }

    /* renamed from: a */
    public final boolean mo22118a(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(86995);
        if (c2241c == null || str == null || str.length() == 0) {
            AppMethodBeat.m2505o(86995);
            return false;
        }
        for (C33139b a : this.ikl) {
            if (a.mo22118a(c2241c, str)) {
                AppMethodBeat.m2505o(86995);
                return true;
            }
        }
        AppMethodBeat.m2505o(86995);
        return false;
    }

    /* renamed from: b */
    public final String mo22120b(C2241c c2241c, String str) {
        AppMethodBeat.m2504i(86996);
        if (c2241c == null || str == null || str.length() == 0) {
            AppMethodBeat.m2505o(86996);
            return str;
        }
        for (C33139b c33139b : this.ikl) {
            if (c33139b.mo22118a(c2241c, str)) {
                str = c33139b.mo22120b(c2241c, str);
                AppMethodBeat.m2505o(86996);
                return str;
            }
        }
        AppMethodBeat.m2505o(86996);
        return str;
    }
}
