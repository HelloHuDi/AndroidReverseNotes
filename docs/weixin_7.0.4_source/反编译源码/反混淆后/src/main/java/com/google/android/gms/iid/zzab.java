package com.google.android.gms.iid;

import android.os.Bundle;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzab extends zzz<Bundle> {
    zzab(int i, int i2, Bundle bundle) {
        super(i, 1, bundle);
    }

    /* Access modifiers changed, original: final */
    public final void zzh(Bundle bundle) {
        AppMethodBeat.m2504i(57528);
        Object bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        if (Log.isLoggable("MessengerIpcClient", 3)) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(bundle2);
            new StringBuilder((String.valueOf(valueOf).length() + 16) + String.valueOf(valueOf2).length()).append("Finishing ").append(valueOf).append(" with ").append(valueOf2);
        }
        this.zzcl.setResult(bundle2);
        AppMethodBeat.m2505o(57528);
    }

    /* Access modifiers changed, original: final */
    public final boolean zzu() {
        return false;
    }
}
