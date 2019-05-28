package com.google.firebase.iid;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.iid.b */
public final class C36690b extends C32098c<Void> {
    public C36690b(int i, Bundle bundle) {
        super(i, 2, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void zzb(Bundle bundle) {
        AppMethodBeat.m2504i(108714);
        if (bundle.getBoolean("ack", false)) {
            mo52662p(null);
            AppMethodBeat.m2505o(108714);
            return;
        }
        mo52661a(new C0908d(4, "Invalid response to one way request"));
        AppMethodBeat.m2505o(108714);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzw() {
        return true;
    }
}
