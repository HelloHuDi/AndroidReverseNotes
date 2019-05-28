package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import javax.annotation.Nullable;

@VisibleForTesting
/* renamed from: com.google.firebase.iid.s */
final class C41652s extends BroadcastReceiver {
    @Nullable
    C41651r bwj;

    public C41652s(C41651r c41651r) {
        this.bwj = c41651r;
    }

    public final void onReceive(Context context, Intent intent) {
        AppMethodBeat.m2504i(108772);
        if (this.bwj == null) {
            AppMethodBeat.m2505o(108772);
        } else if (this.bwj.zzaj()) {
            FirebaseInstanceId.m40569uH();
            FirebaseInstanceId.m40566c(this.bwj, 0);
            this.bwj.getContext().unregisterReceiver(this);
            this.bwj = null;
            AppMethodBeat.m2505o(108772);
        } else {
            AppMethodBeat.m2505o(108772);
        }
    }
}
