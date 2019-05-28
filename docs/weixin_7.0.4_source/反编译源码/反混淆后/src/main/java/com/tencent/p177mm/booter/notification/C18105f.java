package com.tencent.p177mm.booter.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7620bi;

/* renamed from: com.tencent.mm.booter.notification.f */
public final class C18105f {
    public C25979e eeb;

    /* renamed from: com.tencent.mm.booter.notification.f$a */
    public static class C18104a {
        private static final C18105f eec = new C18105f();

        static {
            AppMethodBeat.m2504i(15964);
            AppMethodBeat.m2505o(15964);
        }
    }

    /* synthetic */ C18105f(byte b) {
        this();
    }

    private C18105f() {
        AppMethodBeat.m2504i(15965);
        this.eeb = new C25979e();
        AppMethodBeat.m2505o(15965);
    }

    /* renamed from: a */
    public static boolean m28525a(String str, C7620bi c7620bi, int i, boolean z) {
        AppMethodBeat.m2504i(15966);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(15966);
            return false;
        }
        boolean a = C44684c.m81269a(str, c7620bi, i, z);
        AppMethodBeat.m2505o(15966);
        return a;
    }

    /* renamed from: b */
    public final int mo33541b(NotificationItem notificationItem) {
        AppMethodBeat.m2504i(15967);
        int a = this.eeb.mo43866a(notificationItem);
        AppMethodBeat.m2505o(15967);
        return a;
    }

    /* renamed from: a */
    public final Notification mo33540a(Notification notification, int i, int i2, PendingIntent pendingIntent, String str, String str2, String str3, Bitmap bitmap, String str4) {
        AppMethodBeat.m2504i(15968);
        Notification a = this.eeb.mo43867a(notification, i, i2, pendingIntent, str, str2, str3, bitmap, str4);
        AppMethodBeat.m2505o(15968);
        return a;
    }
}
