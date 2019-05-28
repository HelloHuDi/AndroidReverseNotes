package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzwo extends ContentObserver {
    zzwo(Handler handler) {
        super(null);
    }

    public final void onChange(boolean z) {
        AppMethodBeat.m2504i(69752);
        zzwn.zzbmk.set(true);
        AppMethodBeat.m2505o(69752);
    }
}
