package com.google.android.gms.wearable;

import com.google.android.gms.common.data.DataHolder;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzl implements Runnable {
    private final /* synthetic */ DataHolder zzan;
    private final /* synthetic */ zzd zzao;

    zzl(zzd zzd, DataHolder dataHolder) {
        this.zzao = zzd;
        this.zzan = dataHolder;
    }

    public final void run() {
        AppMethodBeat.m2504i(71482);
        DataEventBuffer dataEventBuffer = new DataEventBuffer(this.zzan);
        try {
            WearableListenerService.this.onDataChanged(dataEventBuffer);
        } finally {
            dataEventBuffer.release();
            AppMethodBeat.m2505o(71482);
        }
    }
}
