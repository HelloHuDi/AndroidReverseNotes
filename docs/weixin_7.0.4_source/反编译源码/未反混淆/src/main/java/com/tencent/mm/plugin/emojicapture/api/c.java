package com.tencent.mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.soter.core.biometric.FaceManager;

public final class c {
    public static void an(Context context, String str) {
        AppMethodBeat.i(57469);
        h(context, str, bo.isNullOrNil(str) ? 2 : 1);
        AppMethodBeat.o(57469);
    }

    public static void h(final Context context, String str, int i) {
        AppMethodBeat.i(57470);
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = !bo.isNullOrNil(str) ? 1 : null;
        if (i == 1) {
            h.pYm.e(15982, Integer.valueOf(2), Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (i == 2) {
            long currentTimeMillis2 = System.currentTimeMillis();
            currentTimeMillis2 -= g.RP().Ry().a(a.USERINFO_EMOJI_CAPTURE_PANEL_FROM_TIPS_TIME_LONG, currentTimeMillis2);
            h.pYm.e(15982, Integer.valueOf(1), Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(currentTimeMillis2));
        }
        try {
            final Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
            intent.putExtra("key_video_params", d.afF().afG());
            intent.putExtra("key_enter_time", currentTimeMillis);
            intent.putExtra("enter_scene", i);
            intent.putExtra("key_capture_max_duration", com.tencent.mm.m.g.Nu().getInt("EmoticonCameraCaptureMaxDuration", 5));
            if (obj != null) {
                intent.putExtra("key_imitated_md5", str);
            }
            ((b) g.M(b.class)).preCheck(context, i, new b.a() {
                final /* synthetic */ int val$requestCode = FaceManager.FACE_ACQUIRED_HACKER;

                public final void gA(boolean z) {
                    AppMethodBeat.i(57468);
                    if (z) {
                        if (context instanceof Activity) {
                            ((Activity) context).startActivityForResult(intent, this.val$requestCode);
                            AppMethodBeat.o(57468);
                            return;
                        } else if (context instanceof ContextThemeWrapper) {
                            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
                            if (baseContext instanceof Activity) {
                                ((Activity) baseContext).startActivityForResult(intent, this.val$requestCode);
                                AppMethodBeat.o(57468);
                                return;
                            }
                            context.startActivity(intent);
                            AppMethodBeat.o(57468);
                            return;
                        } else {
                            context.startActivity(intent);
                        }
                    }
                    AppMethodBeat.o(57468);
                }
            });
            AppMethodBeat.o(57470);
        } catch (ClassNotFoundException e) {
            ab.printErrStackTrace("MicroMsg.TakeEmojiCapture", e, "takeEmojiCapture failed", new Object[0]);
            AppMethodBeat.o(57470);
        }
    }
}
