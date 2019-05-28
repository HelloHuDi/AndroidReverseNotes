package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zzb extends DialogRedirect {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zzsh;

    zzb(Intent intent, Activity activity, int i) {
        this.zzsh = intent;
        this.val$activity = activity;
        this.val$requestCode = i;
    }

    public final void redirect() {
        AppMethodBeat.m2504i(61401);
        if (this.zzsh != null) {
            this.val$activity.startActivityForResult(this.zzsh, this.val$requestCode);
        }
        AppMethodBeat.m2505o(61401);
    }
}
