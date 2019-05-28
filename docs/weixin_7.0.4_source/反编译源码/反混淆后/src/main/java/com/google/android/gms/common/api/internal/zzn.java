package com.google.android.gms.common.api.internal;

import android.app.Dialog;
import com.google.android.gms.common.api.internal.GooglePlayServicesUpdatedReceiver.Callback;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzn extends Callback {
    private final /* synthetic */ Dialog zzex;
    private final /* synthetic */ zzm zzey;

    zzn(zzm zzm, Dialog dialog) {
        this.zzey = zzm;
        this.zzex = dialog;
    }

    public final void zzv() {
        AppMethodBeat.m2504i(60941);
        this.zzey.zzew.zzt();
        if (this.zzex.isShowing()) {
            this.zzex.dismiss();
        }
        AppMethodBeat.m2505o(60941);
    }
}
