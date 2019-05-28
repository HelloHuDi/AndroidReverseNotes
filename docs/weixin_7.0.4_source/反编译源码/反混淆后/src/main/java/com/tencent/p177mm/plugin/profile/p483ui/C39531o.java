package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;

/* renamed from: com.tencent.mm.plugin.profile.ui.o */
final class C39531o implements C39507a {
    private final Context context;

    public C39531o(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.m2504i(23611);
        String string = this.context.getString(C25738R.string.awi);
        AppMethodBeat.m2505o(23611);
        return string;
    }

    /* renamed from: a */
    public final void mo36975a(HelperHeaderPreference helperHeaderPreference) {
        AppMethodBeat.m2504i(23612);
        helperHeaderPreference.mo62463jR(true);
        AppMethodBeat.m2505o(23612);
    }
}
