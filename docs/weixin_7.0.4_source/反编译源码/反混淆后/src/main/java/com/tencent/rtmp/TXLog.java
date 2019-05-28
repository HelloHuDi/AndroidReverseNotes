package com.tencent.rtmp;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TXLog {
    /* renamed from: d */
    public static void m71028d(String str, String str2) {
        AppMethodBeat.m2504i(65991);
        wrietLogMessage(1, str, str2);
        AppMethodBeat.m2505o(65991);
    }

    /* renamed from: i */
    public static void m71030i(String str, String str2) {
        AppMethodBeat.m2504i(65992);
        wrietLogMessage(2, str, str2);
        AppMethodBeat.m2505o(65992);
    }

    /* renamed from: w */
    public static void m71031w(String str, String str2) {
        AppMethodBeat.m2504i(65993);
        wrietLogMessage(3, str, str2);
        AppMethodBeat.m2505o(65993);
    }

    /* renamed from: e */
    public static void m71029e(String str, String str2) {
        AppMethodBeat.m2504i(65994);
        wrietLogMessage(4, str, str2);
        AppMethodBeat.m2505o(65994);
    }

    private static void wrietLogMessage(int i, String str, String str2) {
        AppMethodBeat.m2504i(65995);
        TXCLog.log(i, str, "thread ID:" + Thread.currentThread().getId() + "|line:-1|" + str2);
        AppMethodBeat.m2505o(65995);
    }
}
