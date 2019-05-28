package com.tencent.mm.plugin.profile.ui;

import android.content.Context;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.profile.ui.HelperHeaderPreference.a;

final class q implements a {
    private Context context;

    public q(Context context) {
        this.context = context;
    }

    public final CharSequence getHint() {
        AppMethodBeat.i(23615);
        String string = this.context.getString(R.string.aw2);
        AppMethodBeat.o(23615);
        return string;
    }

    public final void a(HelperHeaderPreference helperHeaderPreference) {
        boolean z;
        AppMethodBeat.i(23616);
        if ((r.YK() & Utility.DEFAULT_STREAM_BUFFER_SIZE) == 0) {
            z = true;
        } else {
            z = false;
        }
        helperHeaderPreference.jR(z);
        AppMethodBeat.o(23616);
    }
}
