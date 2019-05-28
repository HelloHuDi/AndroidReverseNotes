package com.tencent.p177mm.plugin.appbrand.game.p292b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C12027a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;

/* renamed from: com.tencent.mm.plugin.appbrand.game.b.d */
public final class C2156d extends C12027a {
    /* renamed from: a */
    public final C45970e mo5978a(Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(130083);
        C10234e c10234e = new C10234e(context, c39133b, i);
        AppMethodBeat.m2505o(130083);
        return c10234e;
    }

    public final int getType() {
        return 4240;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
