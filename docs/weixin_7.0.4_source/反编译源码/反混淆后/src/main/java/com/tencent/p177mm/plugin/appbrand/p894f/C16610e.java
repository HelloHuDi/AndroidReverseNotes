package com.tencent.p177mm.plugin.appbrand.p894f;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C12027a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;

/* renamed from: com.tencent.mm.plugin.appbrand.f.e */
public final class C16610e extends C12027a {
    /* renamed from: a */
    public final C45970e mo5978a(Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(129975);
        C10226f c10226f = new C10226f(context, c39133b, i);
        AppMethodBeat.m2505o(129975);
        return c10226f;
    }

    public final int getType() {
        return 4224;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
