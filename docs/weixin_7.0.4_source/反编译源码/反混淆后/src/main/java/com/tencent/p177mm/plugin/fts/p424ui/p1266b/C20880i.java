package com.tencent.p177mm.plugin.fts.p424ui.p1266b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C12027a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p424ui.p426d.C31364j;

/* renamed from: com.tencent.mm.plugin.fts.ui.b.i */
public final class C20880i extends C12027a {
    /* renamed from: a */
    public final C45970e mo5978a(Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(62048);
        C31364j c31364j = new C31364j(context, c39133b, i);
        AppMethodBeat.m2505o(62048);
        return c31364j;
    }

    public final int getType() {
        return 4176;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
