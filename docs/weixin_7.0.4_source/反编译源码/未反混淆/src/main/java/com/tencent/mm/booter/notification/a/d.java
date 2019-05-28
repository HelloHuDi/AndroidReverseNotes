package com.tencent.mm.booter.notification.a;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public Intent mIntent;

    public static PendingIntent b(Context context, int i, Intent intent) {
        AppMethodBeat.i(16011);
        PendingIntent activity = PendingIntent.getActivity(context, i, intent, 134217728);
        AppMethodBeat.o(16011);
        return activity;
    }
}
