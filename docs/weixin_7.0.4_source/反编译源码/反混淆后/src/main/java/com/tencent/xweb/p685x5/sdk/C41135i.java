package com.tencent.xweb.p685x5.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;

/* renamed from: com.tencent.xweb.x5.sdk.i */
public final class C41135i implements C36599c {
    public final int getTbsCoreVersion(Context context) {
        AppMethodBeat.m2504i(85116);
        int tbsCoreVersion = WebView.getTbsCoreVersion(context);
        AppMethodBeat.m2505o(85116);
        return tbsCoreVersion;
    }

    public final int getTbsSDKVersion(Context context) {
        AppMethodBeat.m2504i(85117);
        int tbsSDKVersion = WebView.getTbsSDKVersion(context);
        AppMethodBeat.m2505o(85117);
        return tbsSDKVersion;
    }

    public final String getCrashExtraMessage(Context context) {
        AppMethodBeat.m2504i(85118);
        String crashExtraMessage = WebView.getCrashExtraMessage(context);
        AppMethodBeat.m2505o(85118);
        return crashExtraMessage;
    }

    public final boolean getCanReboot() {
        AppMethodBeat.m2504i(85119);
        boolean tbsNeedReboot = WebView.getTbsNeedReboot();
        AppMethodBeat.m2505o(85119);
        return tbsNeedReboot;
    }
}
