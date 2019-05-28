package com.tencent.p177mm.booter.notification.p841a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.booter.notification.a.d */
public final class C18100d {
    public Intent mIntent;

    /* renamed from: b */
    public static PendingIntent m28514b(Context context, int i, Intent intent) {
        AppMethodBeat.m2504i(16011);
        PendingIntent activity = PendingIntent.getActivity(context, i, intent, 134217728);
        AppMethodBeat.m2505o(16011);
        return activity;
    }
}
