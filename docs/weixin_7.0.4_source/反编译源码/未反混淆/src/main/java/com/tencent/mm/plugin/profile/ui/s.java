package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class s implements a {
    private Context context;

    public s(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.i(23647);
        String string = this.context.getString(R.string.axh);
        AppMethodBeat.o(23647);
        return string;
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        boolean z;
        AppMethodBeat.i(23648);
        if ((r.YK() & 16777216) == 0) {
            z = true;
        } else {
            z = false;
        }
        helperHeaderPreference.jR(z);
        AppMethodBeat.o(23648);
    }
}
