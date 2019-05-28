package com.google.android.gms.common.images.internal;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends ConstantState {
    private zzb() {
    }

    /* synthetic */ zzb(zza zza) {
        this();
    }

    public final int getChangingConfigurations() {
        return 0;
    }

    public final Drawable newDrawable() {
        AppMethodBeat.m2504i(61297);
        zza zzcp = zza.zzqj;
        AppMethodBeat.m2505o(61297);
        return zzcp;
    }
}
