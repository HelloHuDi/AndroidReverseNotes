package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTException {
    public static void report(Exception exception) {
        AppMethodBeat.m2504i(118084);
        YTLogger.m50245e("YTException", "[YTException.report] ");
        AppMethodBeat.m2505o(118084);
    }

    public static void report(Exception exception, String str, String str2) {
        AppMethodBeat.m2504i(118085);
        YTLogger.m50248w("YTException".concat(String.valueOf(str)), str2);
        AppMethodBeat.m2505o(118085);
    }
}
