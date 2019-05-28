package com.tencent.p177mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p181af.C8909j;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.pluginsdk.model.app.k */
public final class C14884k extends C7563j<C8909j> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C8909j.ccO, "AppMessage")};

    static {
        AppMethodBeat.m2504i(79328);
        AppMethodBeat.m2505o(79328);
    }

    public C14884k(C4927e c4927e) {
        super(c4927e, C8909j.ccO, "AppMessage", null);
    }

    /* renamed from: ma */
    public final C8909j mo27204ma(long j) {
        AppMethodBeat.m2504i(79327);
        C4925c c8909j = new C8909j();
        c8909j.field_msgId = j;
        if (super.mo10102b(c8909j, new String[0])) {
            AppMethodBeat.m2505o(79327);
            return c8909j;
        }
        AppMethodBeat.m2505o(79327);
        return null;
    }
}
