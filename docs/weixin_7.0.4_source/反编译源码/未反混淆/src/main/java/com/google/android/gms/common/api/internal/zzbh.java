package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzbh implements BackgroundStateChangeListener {
    private final /* synthetic */ GoogleApiManager zzjy;

    zzbh(GoogleApiManager googleApiManager) {
        this.zzjy = googleApiManager;
    }

    public final void onBackgroundStateChanged(boolean z) {
        AppMethodBeat.i(60836);
        this.zzjy.handler.sendMessage(this.zzjy.handler.obtainMessage(1, Boolean.valueOf(z)));
        AppMethodBeat.o(60836);
    }
}
