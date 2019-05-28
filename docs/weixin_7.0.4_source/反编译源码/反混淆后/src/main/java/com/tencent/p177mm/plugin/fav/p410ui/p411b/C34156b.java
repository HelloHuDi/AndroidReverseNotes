package com.tencent.p177mm.plugin.fav.p410ui.p411b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C12027a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;

/* renamed from: com.tencent.mm.plugin.fav.ui.b.b */
public final class C34156b extends C12027a {
    /* renamed from: a */
    public final C45970e mo5978a(Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(74499);
        C11881c c11881c = new C11881c(context, c39133b, i);
        AppMethodBeat.m2505o(74499);
        return c11881c;
    }

    public final int getType() {
        return 4192;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
