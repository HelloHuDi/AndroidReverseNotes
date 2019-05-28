package com.tencent.mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bi;

public final class f {
    public e eeb;

    public static class a {
        private static final f eec = new f();

        static {
            AppMethodBeat.i(15964);
            AppMethodBeat.o(15964);
        }
    }

    /* synthetic */ f(byte b) {
        this();
    }

    private f() {
        AppMethodBeat.i(15965);
        this.eeb = new e();
        AppMethodBeat.o(15965);
    }

    public static boolean a(String str, bi biVar, int i, boolean z) {
        AppMethodBeat.i(15966);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(15966);
            return false;
        }
        boolean a = c.a(str, biVar, i, z);
        AppMethodBeat.o(15966);
        return a;
    }

    public final int b(NotificationItem notificationItem) {
        AppMethodBeat.i(15967);
        int a = this.eeb.a(notificationItem);
        AppMethodBeat.o(15967);
        return a;
    }

    public final Notification a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.i(15968);
        Notification a = this.eeb.a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.o(15968);
        return a;
    }
}
