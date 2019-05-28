package com.google.firebase;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class c implements BackgroundStateChangeListener {
    c() {
    }

    public final void onBackgroundStateChanged(boolean z) {
        AppMethodBeat.i(10639);
        a.uu();
        AppMethodBeat.o(10639);
    }
}
