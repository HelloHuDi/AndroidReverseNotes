package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;

/* renamed from: com.tencent.mm.plugin.profile.ui.s */
final class C21504s implements C39507a {
    private Context context;

    public C21504s(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.m2504i(23647);
        String string = this.context.getString(C25738R.string.axh);
        AppMethodBeat.m2505o(23647);
        return string;
    }

    /* renamed from: a */
    public final void mo36975a(HelperHeaderPreference helperHeaderPreference) {
        boolean z;
        AppMethodBeat.m2504i(23648);
        if ((C1853r.m3829YK() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        helperHeaderPreference.mo62463jR(z);
        AppMethodBeat.m2505o(23648);
    }
}
