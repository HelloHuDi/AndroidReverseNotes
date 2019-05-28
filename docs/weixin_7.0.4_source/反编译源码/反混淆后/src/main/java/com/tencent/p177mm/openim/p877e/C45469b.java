package com.tencent.p177mm.openim.p877e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.openim.e.b */
public final class C45469b extends C7563j<C9775a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C9775a.ccO, "OpenIMAccTypeInfo")};
    public C7480h fni;

    static {
        AppMethodBeat.m2504i(78984);
        AppMethodBeat.m2505o(78984);
    }

    public C45469b(C7480h c7480h) {
        super(c7480h, C9775a.ccO, "OpenIMAccTypeInfo", null);
        this.fni = c7480h;
    }

    /* renamed from: a */
    public final boolean mo73271a(C9775a c9775a) {
        AppMethodBeat.m2504i(78982);
        c9775a.field_updateTime = C5046bo.anT();
        boolean a = super.mo10099a(c9775a);
        AppMethodBeat.m2505o(78982);
        return a;
    }
}
