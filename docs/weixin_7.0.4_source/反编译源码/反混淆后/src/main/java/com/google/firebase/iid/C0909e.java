package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.e */
final class C0909e extends C32098c<Bundle> {
    C0909e(int i, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(Bundle bundle) {
        AppMethodBeat.m2504i(108715);
        Object bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        mo52662p(bundle2);
        AppMethodBeat.m2505o(108715);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzw() {
        return false;
    }
}
