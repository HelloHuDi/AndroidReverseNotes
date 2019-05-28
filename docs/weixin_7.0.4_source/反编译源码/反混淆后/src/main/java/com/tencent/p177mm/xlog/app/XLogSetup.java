package com.tencent.p177mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C7306ak;

/* renamed from: com.tencent.mm.xlog.app.XLogSetup */
public class XLogSetup {
    public static Boolean appendIsSync;
    public static String cachePath;
    public static boolean hasInit = false;
    public static Boolean isLogcatOpen;
    public static String logPath;
    public static String nameprefix;
    private static boolean setup = false;
    public static Integer toolsLevel;
    public static Xlog xlog = new Xlog();

    static {
        AppMethodBeat.m2504i(59243);
        AppMethodBeat.m2505o(59243);
    }

    public static void realSetupXlog() {
        AppMethodBeat.m2504i(59241);
        XLogSetup.keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
        AppMethodBeat.m2505o(59241);
    }

    public static void keep_setupXLog(boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3) {
        AppMethodBeat.m2504i(59242);
        if (!hasInit) {
            PlatformComm.init(C4996ah.getContext(), new C7306ak(Looper.getMainLooper()));
            hasInit = true;
        }
        cachePath = str;
        logPath = str2;
        toolsLevel = num;
        appendIsSync = bool;
        isLogcatOpen = bool2;
        nameprefix = str3;
        if (!z) {
            AppMethodBeat.m2505o(59242);
        } else if (setup) {
            AppMethodBeat.m2505o(59242);
        } else {
            setup = true;
            C1449k.m3079a(C5754a.Aiz, XLogSetup.class.getClassLoader());
            C4990ab.m7407a(xlog);
            appendIsSync.booleanValue();
            Xlog.setConsoleLogOpen(isLogcatOpen.booleanValue());
            if (toolsLevel == null) {
                Xlog.AppenderOpen(2, 0, cachePath, logPath, nameprefix, 3);
                LogLogic.initIPxxLogInfo();
                AppMethodBeat.m2505o(59242);
                return;
            }
            Xlog.AppenderOpen(toolsLevel.intValue(), 1, cachePath, logPath, nameprefix, 0);
            AppMethodBeat.m2505o(59242);
        }
    }
}
