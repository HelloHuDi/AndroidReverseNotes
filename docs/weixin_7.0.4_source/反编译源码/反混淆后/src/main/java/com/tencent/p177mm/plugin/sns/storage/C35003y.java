package com.tencent.p177mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.sns.storage.y */
public final class C35003y extends C7563j<C43574x> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C43574x.ccO, "UxCanvasInfo")};

    static {
        AppMethodBeat.m2504i(38034);
        AppMethodBeat.m2505o(38034);
    }

    public C35003y(C4927e c4927e) {
        this(c4927e, C43574x.ccO, "UxCanvasInfo");
    }

    private C35003y(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
    }

    /* renamed from: a */
    public final void mo55582a(C43574x c43574x) {
        AppMethodBeat.m2504i(38033);
        if (c43574x == null || C5046bo.isNullOrNil(c43574x.field_canvasXml)) {
            AppMethodBeat.m2505o(38033);
            return;
        }
        c43574x.field_createTime = System.currentTimeMillis();
        if (!mo10101b((C4925c) c43574x)) {
            mo10103c(c43574x, new String[0]);
        }
        AppMethodBeat.m2505o(38033);
    }
}
