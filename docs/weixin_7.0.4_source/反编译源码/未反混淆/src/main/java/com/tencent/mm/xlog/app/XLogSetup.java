package com.tencent.mm.xlog.app;

import android.os.Looper;
import com.tencent.mars.comm.PlatformComm;
import com.tencent.mars.xlog.LogLogic;
import com.tencent.mars.xlog.Xlog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

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
        AppMethodBeat.i(59243);
        AppMethodBeat.o(59243);
    }

    public static void realSetupXlog() {
        AppMethodBeat.i(59241);
        keep_setupXLog(true, cachePath, logPath, toolsLevel, appendIsSync, isLogcatOpen, nameprefix);
        AppMethodBeat.o(59241);
    }

    public static void keep_setupXLog(boolean z, String str, String str2, Integer num, Boolean bool, Boolean bool2, String str3) {
        AppMethodBeat.i(59242);
        if (!hasInit) {
            PlatformComm.init(ah.getContext(), new ak(Looper.getMainLooper()));
            hasInit = true;
        }
        cachePath = str;
        logPath = str2;
        toolsLevel = num;
        appendIsSync = bool;
        isLogcatOpen = bool2;
        nameprefix = str3;
        if (!z) {
            AppMethodBeat.o(59242);
        } else if (setup) {
            AppMethodBeat.o(59242);
        } else {
            setup = true;
            k.a(a.Aiz, XLogSetup.class.getClassLoader());
            ab.a(xlog);
            appendIsSync.booleanValue();
            Xlog.setConsoleLogOpen(isLogcatOpen.booleanValue());
            if (toolsLevel == null) {
                Xlog.AppenderOpen(2, 0, cachePath, logPath, nameprefix, 3);
                LogLogic.initIPxxLogInfo();
                AppMethodBeat.o(59242);
                return;
            }
            Xlog.AppenderOpen(toolsLevel.intValue(), 1, cachePath, logPath, nameprefix, 0);
            AppMethodBeat.o(59242);
        }
    }
}
