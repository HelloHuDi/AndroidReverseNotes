package com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.C27360b;
import com.tencent.p177mm.plugin.appbrand.widget.desktop.dynamicbackground.DynamicBackgroundGLSurfaceView.C27360b.C27362a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import p000a.C0220l;

@C0220l(dWo = {1, 1, 13}, dWp = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001bH\u0002J\u0006\u0010\u001f\u001a\u00020\u001bJ\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, dWq = {"Lcom/tencent/mm/plugin/appbrand/widget/desktop/dynamicbackground/DynamicBackgroundConfig;", "", "()V", "BAN_FPS", "", "CURRENT_DRAW_FPS", "", "DEFAULT_DRAW_FPS", "FRAME_PER_SECOND", "HIGH_FPS", "LAST_APP_FPS", "LOWEST_DRAW_FPS", "LOW_FPS", "MIDDLE_FPS", "MONITOR_CHECK_FPS_DURATION", "", "MONITOR_LAST_CHECK_FPS_TIME", "SLEEP_TIME_IN_MS_PER_FRAME", "", "getSLEEP_TIME_IN_MS_PER_FRAME", "()F", "setSLEEP_TIME_IN_MS_PER_FRAME", "(F)V", "TAG", "lastAppFps", "lastCheckTime", "adjustDynamicBackgroundDrawFps", "", "appFps", "", "computeSleepTimePerFrame", "init", "needMonitorFps", "", "plugin-appbrand-integration_release"})
/* renamed from: com.tencent.mm.plugin.appbrand.widget.desktop.dynamicbackground.b */
public final class C38583b {
    public static int iZd = 20;
    private static float iZe = 16.0f;
    public static int iZf;
    public static final C38583b iZg = new C38583b();
    private static long lastCheckTime = -1;

    static {
        AppMethodBeat.m2504i(135223);
        AppMethodBeat.m2505o(135223);
    }

    private C38583b() {
    }

    public static float aPz() {
        return iZe;
    }

    public static boolean aPA() {
        boolean z;
        AppMethodBeat.m2504i(135221);
        SharedPreferences doB = C4996ah.doB();
        if (doB != null) {
            long j = doB.getLong("monitory_last_check_time", -1);
            if (iZf == 0) {
                iZf = doB.getInt("current_app_fps", 0);
            }
            C4990ab.m7411d("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps lastAppFps: %d, lastCheckTime: %d", Integer.valueOf(iZf), Long.valueOf(j));
            if (j == -1 || iZf <= 45 || System.currentTimeMillis() - j > 3600000) {
                doB.edit().putLong("monitory_last_check_time", System.currentTimeMillis()).apply();
                z = true;
            } else {
                z = false;
            }
            C4990ab.m7417i("MicroMsg.DynamicBackgroundConfig", "alvinluo needMonitorFps needCheck: %b", Boolean.valueOf(z));
        } else {
            z = false;
        }
        AppMethodBeat.m2505o(135221);
        return z;
    }

    public static void aPB() {
        AppMethodBeat.m2504i(135222);
        SharedPreferences doB = C4996ah.doB();
        iZd = doB != null ? doB.getInt("current_draw_fps", 20) : 20;
        iZe = (1000.0f / ((float) iZd)) - 20.0f;
        if (iZd == 2) {
            C27362a c27362a = C27360b.iZv;
            C4990ab.m7417i("MicroMsg.DynamicBgSurfaceView", "alvinluo updateAlphaAnimation %d", Long.valueOf(1500));
            C27360b.iZu = 1500;
        }
        C4990ab.m7417i("MicroMsg.DynamicBackgroundConfig", "alvinluo computeSleepTimePerFrame: %f, fps: %d, DEFAULT_DRAW_FPS: %d", Float.valueOf(iZe), Integer.valueOf(iZd), Integer.valueOf(20));
        AppMethodBeat.m2505o(135222);
    }
}
