package com.tencent.p177mm.plugin.appbrand.report.quality;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.sdk.platformtools.C4996ah;

/* renamed from: com.tencent.mm.plugin.appbrand.report.quality.i */
public enum C19704i {
    ;

    /* renamed from: com.tencent.mm.plugin.appbrand.report.quality.i$a */
    public static class C19705a {
        public int iCV;
        public int iCW;
        public int iCX;
        public int iCY;
    }

    private C19704i(String str) {
    }

    static {
        AppMethodBeat.m2505o(132702);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static C19705a aLB() {
        MemoryInfo memoryInfo;
        AppMethodBeat.m2504i(132701);
        C19705a c19705a = new C19705a();
        ActivityManager activityManager = (ActivityManager) C4996ah.getContext().getSystemService("activity");
        if (activityManager != null) {
            MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
                if (memoryInfo != null) {
                    AppMethodBeat.m2505o(132701);
                    return c19705a;
                }
                c19705a.iCV = memoryInfo.getTotalPss() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                c19705a.iCW = memoryInfo.nativePss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                c19705a.iCX = memoryInfo.dalvikPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                c19705a.iCY = memoryInfo.otherPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                AppMethodBeat.m2505o(132701);
                return c19705a;
            }
        }
        memoryInfo = null;
        if (memoryInfo != null) {
        }
    }
}
