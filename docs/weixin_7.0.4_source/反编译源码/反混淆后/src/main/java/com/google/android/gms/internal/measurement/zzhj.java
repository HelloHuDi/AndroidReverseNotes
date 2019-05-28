package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public final class zzhj extends zzjw {
    final Context zzqx;

    @VisibleForTesting
    public zzhj(Context context) {
        AppMethodBeat.m2504i(69148);
        Preconditions.checkNotNull(context);
        Context applicationContext = context.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzqx = applicationContext;
        AppMethodBeat.m2505o(69148);
    }
}
