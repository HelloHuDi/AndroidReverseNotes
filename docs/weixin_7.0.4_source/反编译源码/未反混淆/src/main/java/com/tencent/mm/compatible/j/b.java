package com.tencent.mm.compatible.j;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.a.a;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static boolean s(Activity activity) {
        AppMethodBeat.i(93117);
        final Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 0);
        a.a(8, new a.a() {
            public final void run() {
                AppMethodBeat.i(93116);
                intent.putExtra("android.intent.extra.durationLimit", 30);
                intent.putExtra("android.intent.extra.sizeLimit", 10485760);
                AppMethodBeat.o(93116);
            }
        });
        try {
            activity.startActivityForResult(intent, 4372);
            AppMethodBeat.o(93117);
            return true;
        } catch (ActivityNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.TakeVideoUtil", e, "", new Object[0]);
            AppMethodBeat.o(93117);
            return false;
        }
    }
}
