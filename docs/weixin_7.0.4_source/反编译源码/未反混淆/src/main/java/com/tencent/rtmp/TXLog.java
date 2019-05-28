package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLog {
    public static void d(String str, String str2) {
        AppMethodBeat.i(65991);
        wrietLogMessage(1, str, str2);
        AppMethodBeat.o(65991);
    }

    public static void i(String str, String str2) {
        AppMethodBeat.i(65992);
        wrietLogMessage(2, str, str2);
        AppMethodBeat.o(65992);
    }

    public static void w(String str, String str2) {
        AppMethodBeat.i(65993);
        wrietLogMessage(3, str, str2);
        AppMethodBeat.o(65993);
    }

    public static void e(String str, String str2) {
        AppMethodBeat.i(65994);
        wrietLogMessage(4, str, str2);
        AppMethodBeat.o(65994);
    }

    private static void wrietLogMessage(int i, String str, String str2) {
        AppMethodBeat.i(65995);
        TXCLog.log(i, str, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + str2);
        AppMethodBeat.o(65995);
    }
}
