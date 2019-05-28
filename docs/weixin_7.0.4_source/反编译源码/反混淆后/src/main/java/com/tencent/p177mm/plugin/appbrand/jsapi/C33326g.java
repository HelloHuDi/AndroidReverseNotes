package com.tencent.p177mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10378a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10379b;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10380c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C10381d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C38290f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C45596f.C45595e;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.g */
public final class C33326g implements C45596f {
    public final Set<C45595e> hvU = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<C10379b> hvV = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<C10381d> hvW = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<C10380c> hvX = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<C10378a> hvY = Collections.newSetFromMap(new ConcurrentHashMap());
    public final Set<C38290f> hvZ = Collections.newSetFromMap(new ConcurrentHashMap());

    public C33326g() {
        AppMethodBeat.m2504i(91017);
        AppMethodBeat.m2505o(91017);
    }

    /* renamed from: a */
    public final void mo53831a(C38290f c38290f) {
        AppMethodBeat.m2504i(91018);
        this.hvZ.add(c38290f);
        AppMethodBeat.m2505o(91018);
    }

    /* renamed from: a */
    public final void mo53830a(C45595e c45595e) {
        AppMethodBeat.m2504i(91019);
        this.hvU.add(c45595e);
        AppMethodBeat.m2505o(91019);
    }

    /* renamed from: b */
    public final void mo53835b(C45595e c45595e) {
        AppMethodBeat.m2504i(91020);
        this.hvU.remove(c45595e);
        AppMethodBeat.m2505o(91020);
    }

    /* renamed from: a */
    public final void mo53827a(C10379b c10379b) {
        AppMethodBeat.m2504i(91021);
        this.hvV.add(c10379b);
        AppMethodBeat.m2505o(91021);
    }

    /* renamed from: b */
    public final void mo53832b(C10379b c10379b) {
        AppMethodBeat.m2504i(91022);
        this.hvV.remove(c10379b);
        AppMethodBeat.m2505o(91022);
    }

    /* renamed from: a */
    public final void mo53829a(C10381d c10381d) {
        AppMethodBeat.m2504i(91023);
        this.hvW.add(c10381d);
        AppMethodBeat.m2505o(91023);
    }

    /* renamed from: b */
    public final void mo53834b(C10381d c10381d) {
        AppMethodBeat.m2504i(91024);
        this.hvW.remove(c10381d);
        AppMethodBeat.m2505o(91024);
    }

    /* renamed from: a */
    public final void mo53828a(C10380c c10380c) {
        AppMethodBeat.m2504i(91025);
        this.hvX.add(c10380c);
        AppMethodBeat.m2505o(91025);
    }

    /* renamed from: b */
    public final void mo53833b(C10380c c10380c) {
        AppMethodBeat.m2504i(91026);
        this.hvX.remove(c10380c);
        AppMethodBeat.m2505o(91026);
    }
}
