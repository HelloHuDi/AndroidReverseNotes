package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e extends c<Bundle> {
    e(int i, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(Bundle bundle) {
        AppMethodBeat.i(108715);
        Object bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        p(bundle2);
        AppMethodBeat.o(108715);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzw() {
        return false;
    }
}
