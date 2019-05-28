package com.tencent.p177mm.plugin.fts.p424ui.p1266b;

import android.content.Context;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C12027a;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e;
import com.tencent.p177mm.plugin.fts.p419a.p421d.C45970e.C39133b;
import com.tencent.p177mm.plugin.fts.p424ui.p426d.C34229a;

/* renamed from: com.tencent.mm.plugin.fts.ui.b.a */
public final class C45975a extends C12027a {
    /* renamed from: a */
    public final C45970e mo5978a(Context context, C39133b c39133b, int i) {
        AppMethodBeat.m2504i(62040);
        C34229a c34229a = new C34229a(context, c39133b, i);
        AppMethodBeat.m2505o(62040);
        return c34229a;
    }

    public final int getType() {
        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
