package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.GmsClientEventManager.GmsClientEventState;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzaw implements GmsClientEventState {
    private final /* synthetic */ zzav zzit;

    zzaw(zzav zzav) {
        this.zzit = zzav;
    }

    public final Bundle getConnectionHint() {
        return null;
    }

    public final boolean isConnected() {
        AppMethodBeat.i(60809);
        boolean isConnected = this.zzit.isConnected();
        AppMethodBeat.o(60809);
        return isConnected;
    }
}
