package com.tencent.xweb.xwalk.b;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkInitializer;
import org.xwalk.core.XWalkInitializer.XWalkInitListener;
import org.xwalk.core.XWalkUpdater;
import org.xwalk.core.XWalkUpdater.XWalkBackgroundUpdateListener;

public final class e implements XWalkInitListener, XWalkBackgroundUpdateListener {
    private static boolean ATA = false;
    private static e ATB;
    public static boolean ATz = true;
    XWalkInitializer ASE;
    XWalkUpdater ASF;
    Context mContext;

    private e(Context context) {
        AppMethodBeat.i(85472);
        this.mContext = context;
        this.ASE = new XWalkInitializer(this, context);
        this.ASF = new XWalkUpdater((XWalkBackgroundUpdateListener) this, context);
        AppMethodBeat.o(85472);
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
        AppMethodBeat.i(85473);
        f.dWg();
        AppMethodBeat.o(85473);
    }

    public final void onXWalkUpdateProgress(int i) {
    }

    public final void onXWalkUpdateCancelled() {
        AppMethodBeat.i(85474);
        f.dWh();
        AppMethodBeat.o(85474);
    }

    public final void onXWalkUpdateFailed(int i) {
        AppMethodBeat.i(85475);
        f.SF(i);
        AppMethodBeat.o(85475);
    }

    public final void onXWalkUpdateCompleted() {
        AppMethodBeat.i(85476);
        f.dWi();
        AppMethodBeat.o(85476);
    }

    public static boolean isXWalkReady() {
        AppMethodBeat.i(85477);
        if (!ATA || ATB == null) {
            AppMethodBeat.o(85477);
            return false;
        }
        boolean isXWalkReady = ATB.ASE.isXWalkReady();
        AppMethodBeat.o(85477);
        return isXWalkReady;
    }

    public static boolean jF(Context context) {
        AppMethodBeat.i(85478);
        if (ATA) {
            boolean z = ATA;
            AppMethodBeat.o(85478);
            return z;
        }
        ATA = true;
        ATB = new e(context);
        XWalkEnvironment.init(context);
        if (XWalkEnvironment.isDownloadMode()) {
            e eVar = ATB;
            if (!ATz) {
                HashMap hashMap = new HashMap();
                hashMap.put("UpdaterCheckType", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                new f(eVar.ASF, hashMap).execute(new String[0]);
            }
            if (eVar.ASE.tryInitSync()) {
                XWalkInitializer.addXWalkInitializeLog("initSync Sucsess");
                AppMethodBeat.o(85478);
                return true;
            }
            AppMethodBeat.o(85478);
            return false;
        }
        AppMethodBeat.o(85478);
        return false;
    }
}
