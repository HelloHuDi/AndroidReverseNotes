package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class r implements a {
    private Context context;

    public r(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.i(23617);
        String string = this.context.getString(R.string.awe);
        AppMethodBeat.o(23617);
        return string;
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        AppMethodBeat.i(23618);
        helperHeaderPreference.jR((com.tencent.mm.model.r.YK() & 32768) == 0);
        AppMethodBeat.o(23618);
    }
}
