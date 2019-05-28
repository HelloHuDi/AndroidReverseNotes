package com.tencent.p177mm.plugin.brandservice.p349ui.p927a;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C12027a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.a.b */
public final class C42805b extends C12027a {
    /* renamed from: a */
    public final C45970e mo5978a(Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(14087);
        C41259c c41259c = new C41259c(context, c39133b, i);
        AppMethodBeat.m2505o(14087);
        return c41259c;
    }

    public final int getType() {
        return 4208;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
