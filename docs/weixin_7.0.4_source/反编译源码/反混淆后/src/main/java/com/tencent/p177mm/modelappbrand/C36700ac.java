package com.tencent.p177mm.modelappbrand;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.modelappbrand.ac */
public final class C36700ac implements C32805ab {
    private C26436f fpV;
    protected Map<String, C32811m> fpW = new HashMap();

    public C36700ac(C26436f c26436f) {
        AppMethodBeat.m2504i(70643);
        this.fpV = c26436f;
        AppMethodBeat.m2505o(70643);
    }

    public C36700ac(C32805ab c32805ab) {
        AppMethodBeat.m2504i(70644);
        if (c32805ab == null) {
            AppMethodBeat.m2505o(70644);
            return;
        }
        this.fpV = c32805ab.abN();
        m60893a(c32805ab);
        AppMethodBeat.m2505o(70644);
    }

    /* renamed from: a */
    private void m60893a(C32805ab c32805ab) {
        AppMethodBeat.m2504i(70645);
        for (C32811m a : c32805ab.abO()) {
            mo58565a(a);
        }
        AppMethodBeat.m2505o(70645);
    }

    public final C26436f abN() {
        return this.fpV;
    }

    /* renamed from: px */
    public final <T> T mo53363px(String str) {
        AppMethodBeat.m2504i(70646);
        Object obj = this.fpW.get(str);
        AppMethodBeat.m2505o(70646);
        return obj;
    }

    /* renamed from: a */
    public final void mo58565a(C32811m c32811m) {
        AppMethodBeat.m2504i(70647);
        this.fpW.put(c32811m.getName(), c32811m);
        AppMethodBeat.m2505o(70647);
    }

    public final List<C32811m> abO() {
        AppMethodBeat.m2504i(70648);
        ArrayList arrayList = new ArrayList(this.fpW.values());
        AppMethodBeat.m2505o(70648);
        return arrayList;
    }
}
