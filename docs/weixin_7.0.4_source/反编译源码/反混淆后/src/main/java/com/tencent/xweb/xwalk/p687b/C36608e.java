package com.tencent.xweb.xwalk.p687b;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

/* renamed from: com.tencent.xweb.xwalk.b.e */
public final class C36608e implements XWalkInitListener, XWalkBackgroundUpdateListener {
    private static boolean ATA = false;
    private static C36608e ATB;
    public static boolean ATz = true;
    XWalkInitializer ASE;
    XWalkUpdater ASF;
    Context mContext;

    private C36608e(Context context) {
        AppMethodBeat.m2504i(85472);
        this.mContext = context;
        this.ASE = new XWalkInitializer(this, context);
        this.ASF = new XWalkUpdater((XWalkBackgroundUpdateListener) this, context);
        AppMethodBeat.m2505o(85472);
    }

    public final void onXWalkInitStarted() {
    }

    public final void onXWalkInitCancelled() {
    }

    public final void onXWalkInitFailed() {
    }

    public final void onXWalkInitCompleted() {
    }

    public final void onXWalkUpdateStarted() {
        AppMethodBeat.m2504i(85473);
        C36609f.dWg();
        AppMethodBeat.m2505o(85473);
    }

    public final void onXWalkUpdateProgress(int i) {
    }

    public final void onXWalkUpdateCancelled() {
        AppMethodBeat.m2504i(85474);
        C36609f.dWh();
        AppMethodBeat.m2505o(85474);
    }

    public final void onXWalkUpdateFailed(int i) {
        AppMethodBeat.m2504i(85475);
        C36609f.m60706SF(i);
        AppMethodBeat.m2505o(85475);
    }

    public final void onXWalkUpdateCompleted() {
        AppMethodBeat.m2504i(85476);
        C36609f.dWi();
        AppMethodBeat.m2505o(85476);
    }

    public static boolean isXWalkReady() {
        AppMethodBeat.m2504i(85477);
        if (!ATA || ATB == null) {
            AppMethodBeat.m2505o(85477);
            return false;
        }
        boolean isXWalkReady = ATB.ASE.isXWalkReady();
        AppMethodBeat.m2505o(85477);
        return isXWalkReady;
    }

    /* renamed from: jF */
    public static boolean m60705jF(Context context) {
        AppMethodBeat.m2504i(85478);
        if (ATA) {
            boolean z = ATA;
            AppMethodBeat.m2505o(85478);
            return z;
        }
        ATA = true;
        ATB = new C36608e(context);
        XWalkEnvironment.init(context);
        if (XWalkEnvironment.isDownloadMode()) {
            C36608e c36608e = ATB;
            if (!ATz) {
                HashMap hashMap = new HashMap();
                hashMap.put("UpdaterCheckType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                new C36609f(c36608e.ASF, hashMap).execute(new String[0]);
            }
            if (c36608e.ASE.tryInitSync()) {
                XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
                AppMethodBeat.m2505o(85478);
                return true;
            }
            AppMethodBeat.m2505o(85478);
            return false;
        }
        AppMethodBeat.m2505o(85478);
        return false;
    }
}
