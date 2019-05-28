package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b extends c<Void> {
    public b(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(108714);
        if (bundle.getBoolean("ack", false)) {
            p(null);
            AppMethodBeat.o(108714);
            return;
        }
        a(new d(4, "Invalid response to one way request"));
        AppMethodBeat.o(108714);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzw() {
        return true;
    }
}
