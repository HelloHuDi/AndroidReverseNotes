package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class o implements a {
    private final Context context;

    public o(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.i(23611);
        String string = this.context.getString(R.string.awi);
        AppMethodBeat.o(23611);
        return string;
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        AppMethodBeat.i(23612);
        helperHeaderPreference.jR(true);
        AppMethodBeat.o(23612);
    }
}
