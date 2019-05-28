package com.tencent.p177mm.plugin.honey_pay.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.honey_pay.model.b */
public final class C39246b extends C7563j<C34334a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C34334a.ccO, "HoneyPayMsgRecord")};
    private static final String[] gmr = new String[]{"*", "rowid"};
    private C4927e bSd;

    static {
        AppMethodBeat.m2504i(41751);
        AppMethodBeat.m2505o(41751);
    }

    public C39246b(C4927e c4927e) {
        super(c4927e, C34334a.ccO, "HoneyPayMsgRecord", null);
        this.bSd = c4927e;
    }
}
