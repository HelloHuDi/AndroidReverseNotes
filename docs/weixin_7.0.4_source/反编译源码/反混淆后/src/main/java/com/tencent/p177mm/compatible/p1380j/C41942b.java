package com.tencent.p177mm.compatible.p1380j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.p1597a.C41933a;
import com.tencent.p177mm.compatible.p1597a.C41933a.C41932a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.compatible.j.b */
public final class C41942b {
    /* renamed from: s */
    public static boolean m74077s(Activity activity) {
        AppMethodBeat.m2504i(93117);
        final Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 0);
        C41933a.m74069a(8, new C41932a() {
            public final void run() {
                AppMethodBeat.m2504i(93116);
                intent.putExtra("android.intent.extra.durationLimit", 30);
                intent.putExtra("android.intent.extra.sizeLimit", 10485760);
                AppMethodBeat.m2505o(93116);
            }
        });
        try {
            activity.startActivityForResult(intent, 4372);
            AppMethodBeat.m2505o(93117);
            return true;
        } catch (ActivityNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.TakeVideoUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(93117);
            return false;
        }
    }
}
