package com.tencent.mm.plugin.appbrand.report.quality;

import android.app.ActivityManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.platformtools.ah;

public enum i {
    ;

    public static class a {
        public int iCV;
        public int iCW;
        public int iCX;
        public int iCY;
    }

    private i(String str) {
    }

    static {
        AppMethodBeat.o(132702);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static a aLB() {
        MemoryInfo memoryInfo;
        AppMethodBeat.i(132701);
        a aVar = new a();
        ActivityManager activityManager = (ActivityManager) ah.getContext().getSystemService("activity");
        if (activityManager != null) {
            MemoryInfo[] processMemoryInfo = activityManager.getProcessMemoryInfo(new int[]{Process.myPid()});
            if (processMemoryInfo != null && processMemoryInfo.length > 0) {
                memoryInfo = processMemoryInfo[0];
                if (memoryInfo != null) {
                    AppMethodBeat.o(132701);
                    return aVar;
                }
                aVar.iCV = memoryInfo.getTotalPss() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                aVar.iCW = memoryInfo.nativePss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                aVar.iCX = memoryInfo.dalvikPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                aVar.iCY = memoryInfo.otherPss / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
                AppMethodBeat.o(132701);
                return aVar;
            }
        }
        memoryInfo = null;
        if (memoryInfo != null) {
        }
    }
}
