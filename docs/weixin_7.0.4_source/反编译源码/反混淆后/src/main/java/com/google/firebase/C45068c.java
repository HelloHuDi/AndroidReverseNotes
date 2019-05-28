package com.google.firebase;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.firebase.c */
final class C45068c implements BackgroundStateChangeListener {
    C45068c() {
    }

    public final void onBackgroundStateChanged(boolean z) {
        AppMethodBeat.m2504i(10639);
        C41642a.m73007uu();
        AppMethodBeat.m2505o(10639);
    }
}
