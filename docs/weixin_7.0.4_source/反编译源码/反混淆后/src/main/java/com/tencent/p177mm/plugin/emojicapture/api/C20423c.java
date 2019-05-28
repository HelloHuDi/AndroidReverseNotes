package com.tencent.p177mm.plugin.emojicapture.api;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextThemeWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.modelcontrol.C42204d;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.plugin.emojicapture.api.C27791b.C27790a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.soter.core.biometric.FaceManager;

/* renamed from: com.tencent.mm.plugin.emojicapture.api.c */
public final class C20423c {
    /* renamed from: an */
    public static void m31581an(Context context, String str) {
        AppMethodBeat.m2504i(57469);
        C20423c.m31582h(context, str, C5046bo.isNullOrNil(str) ? 2 : 1);
        AppMethodBeat.m2505o(57469);
    }

    /* renamed from: h */
    public static void m31582h(final Context context, String str, int i) {
        AppMethodBeat.m2504i(57470);
        long currentTimeMillis = System.currentTimeMillis();
        Object obj = !C5046bo.isNullOrNil(str) ? 1 : null;
        if (i == 1) {
            C7060h.pYm.mo8381e(15982, Integer.valueOf(2), Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
        } else if (i == 2) {
            long currentTimeMillis2 = System.currentTimeMillis();
            currentTimeMillis2 -= C1720g.m3536RP().mo5239Ry().mo16814a(C5127a.USERINFO_EMOJI_CAPTURE_PANEL_FROM_TIPS_TIME_LONG, currentTimeMillis2);
            C7060h.pYm.mo8381e(15982, Integer.valueOf(1), Long.valueOf(currentTimeMillis), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), Long.valueOf(currentTimeMillis2));
        }
        try {
            final Intent intent = new Intent(context, Class.forName("com.tencent.mm.plugin.emojicapture.ui.EmojiCaptureUI"));
            intent.putExtra("key_video_params", C42204d.afF().afG());
            intent.putExtra("key_enter_time", currentTimeMillis);
            intent.putExtra("enter_scene", i);
            intent.putExtra("key_capture_max_duration", C26373g.m41964Nu().getInt("EmoticonCameraCaptureMaxDuration", 5));
            if (obj != null) {
                intent.putExtra("key_imitated_md5", str);
            }
            ((C27791b) C1720g.m3530M(C27791b.class)).preCheck(context, i, new C27790a() {
                final /* synthetic */ int val$requestCode = FaceManager.FACE_ACQUIRED_HACKER;

                /* renamed from: gA */
                public final void mo35707gA(boolean z) {
                    AppMethodBeat.m2504i(57468);
                    if (z) {
                        if (context instanceof Activity) {
                            ((Activity) context).startActivityForResult(intent, this.val$requestCode);
                            AppMethodBeat.m2505o(57468);
                            return;
                        } else if (context instanceof ContextThemeWrapper) {
                            Context baseContext = ((ContextThemeWrapper) context).getBaseContext();
                            if (baseContext instanceof Activity) {
                                ((Activity) baseContext).startActivityForResult(intent, this.val$requestCode);
                                AppMethodBeat.m2505o(57468);
                                return;
                            }
                            context.startActivity(intent);
                            AppMethodBeat.m2505o(57468);
                            return;
                        } else {
                            context.startActivity(intent);
                        }
                    }
                    AppMethodBeat.m2505o(57468);
                }
            });
            AppMethodBeat.m2505o(57470);
        } catch (ClassNotFoundException e) {
            C4990ab.printErrStackTrace("MicroMsg.TakeEmojiCapture", e, "takeEmojiCapture failed", new Object[0]);
            AppMethodBeat.m2505o(57470);
        }
    }
}
