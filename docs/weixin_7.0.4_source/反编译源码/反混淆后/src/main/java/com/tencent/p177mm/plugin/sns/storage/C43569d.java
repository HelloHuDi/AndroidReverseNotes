package com.tencent.p177mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.p603e.C4925c.C4924a;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;

/* renamed from: com.tencent.mm.plugin.sns.storage.d */
public final class C43569d extends C7563j<C21989c> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C21989c.ccO, "CanvasInfo")};

    static {
        AppMethodBeat.m2504i(36919);
        AppMethodBeat.m2505o(36919);
    }

    public C43569d(C4927e c4927e) {
        this(c4927e, C21989c.ccO, "CanvasInfo");
    }

    private C43569d(C4927e c4927e, C4924a c4924a, String str) {
        super(c4927e, c4924a, str, null);
    }

    /* renamed from: a */
    public final void mo69147a(C21989c c21989c) {
        AppMethodBeat.m2504i(36918);
        if (c21989c == null) {
            AppMethodBeat.m2505o(36918);
            return;
        }
        c21989c.field_createTime = System.currentTimeMillis();
        if (!mo10101b((C4925c) c21989c)) {
            mo10103c(c21989c, new String[0]);
        }
        AppMethodBeat.m2505o(36918);
    }
}
