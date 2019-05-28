package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

public final class i implements c {
    public final int getTbsCoreVersion(Context context) {
        AppMethodBeat.i(85116);
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        AppMethodBeat.o(85116);
        return tbsCoreVersion;
    }

    public final int getTbsSDKVersion(Context context) {
        AppMethodBeat.i(85117);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        AppMethodBeat.o(85117);
        return tbsSDKVersion;
    }

    public final String getCrashExtraMessage(Context context) {
        AppMethodBeat.i(85118);
        String crashExtraMessage = WebView.getCrashExtraMessage(context);
        AppMethodBeat.o(85118);
        return crashExtraMessage;
    }

    public final boolean getCanReboot() {
        AppMethodBeat.i(85119);
        boolean tbsNeedReboot = WebView.getTbsNeedReboot();
        AppMethodBeat.o(85119);
        return tbsNeedReboot;
    }
}
