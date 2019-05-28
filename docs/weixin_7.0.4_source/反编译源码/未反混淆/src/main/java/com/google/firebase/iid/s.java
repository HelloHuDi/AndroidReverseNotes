package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@VisibleForTesting
final class s extends BroadcastReceiver {
    @Nullable
    r bwj;

    public s(r rVar) {
        this.bwj = rVar;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.i(108772);
        if (this.bwj == null) {
            AppMethodBeat.o(108772);
        } else if (this.bwj.zzaj()) {
            FirebaseInstanceId.uH();
            FirebaseInstanceId.c(this.bwj, 0);
            this.bwj.getContext().unregisterReceiver(this);
            this.bwj = null;
            AppMethodBeat.o(108772);
        } else {
            AppMethodBeat.o(108772);
        }
    }
}
