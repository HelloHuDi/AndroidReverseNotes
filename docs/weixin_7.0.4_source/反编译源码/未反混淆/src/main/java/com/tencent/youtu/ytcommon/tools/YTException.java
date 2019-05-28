package com.tencent.youtu.ytcommon.tools;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class YTException {
    public static void report(Exception exception) {
        AppMethodBeat.i(118084);
        YTLogger.e("YTException", "[YTException.report] ");
        AppMethodBeat.o(118084);
    }

    public static void report(Exception exception, String str, String str2) {
        AppMethodBeat.i(118085);
        YTLogger.w("YTException".concat(String.valueOf(str)), str2);
        AppMethodBeat.o(118085);
    }
}
