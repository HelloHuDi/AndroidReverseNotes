package com.tencent.p177mm.plugin.profile.p483ui;

import android.content.Context;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.plugin.profile.p483ui.HelperHeaderPreference.C39507a;

/* renamed from: com.tencent.mm.plugin.profile.ui.q */
final class C21502q implements C39507a {
    private Context context;

    public C21502q(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.m2504i(23615);
        String string = this.context.getString(C25738R.string.aw2);
        AppMethodBeat.m2505o(23615);
        return string;
    }

    /* renamed from: a */
    public final void mo36975a(HelperHeaderPreference helperHeaderPreference) {
        boolean z;
        AppMethodBeat.m2504i(23616);
        if ((C1853r.m3829YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            z = true;
        } else {
            z = false;
        }
        helperHeaderPreference.mo62463jR(z);
        AppMethodBeat.m2505o(23616);
    }
}
