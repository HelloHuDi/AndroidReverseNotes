package com.google.android.gms.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzs implements OnTokenCanceledListener {
    private final /* synthetic */ TaskCompletionSource zzagc;

    zzs(TaskCompletionSource taskCompletionSource) {
        this.zzagc = taskCompletionSource;
    }

    public final void onCanceled() {
        AppMethodBeat.m2504i(57411);
        this.zzagc.zzafh.zzdp();
        AppMethodBeat.m2505o(57411);
    }
}
