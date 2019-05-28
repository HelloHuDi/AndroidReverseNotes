package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;

/* renamed from: com.tencent.mm.plugin.profile.ui.r */
final class C21503r implements C39507a {
    private Context context;

    public C21503r(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.m2504i(23617);
        String string = this.context.getString(C25738R.string.awe);
        AppMethodBeat.m2505o(23617);
        return string;
    }

    /* renamed from: a */
    public final void mo36975a(HelperHeaderPreference helperHeaderPreference) {
        AppMethodBeat.m2504i(23618);
        helperHeaderPreference.mo62463jR((C1853r.m3829YK() & 32768) == 0);
        AppMethodBeat.m2505o(23618);
    }
}
