package com.google.android.gms.internal.stable;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzj extends ContentObserver {
    zzj(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.i(90492);
        zzi.zzagy.set(true);
        AppMethodBeat.o(90492);
    }
}
