package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class zze implements OnClickListener {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ Intent zzabl;

    zze(Context context, Intent intent) {
        this.val$context = context;
        this.zzabl = intent;
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(61639);
        try {
            this.val$context.startActivity(this.zzabl);
            AppMethodBeat.m2505o(61639);
        } catch (ActivityNotFoundException e) {
            AppMethodBeat.m2505o(61639);
        }
    }
}
