package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.pb.common.c.c;

public final class j {
    public static boolean auS(String str) {
        AppMethodBeat.i(128001);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(128001);
            return false;
        }
        boolean startsWith = str.startsWith("client_");
        AppMethodBeat.o(128001);
        return startsWith;
    }

    public static int dTH() {
        int i = 0;
        AppMethodBeat.i(128002);
        try {
            i = a.dSR().nCF;
            AppMethodBeat.o(128002);
        } catch (Exception e) {
            c.w("tagorewang:VoiceGroupUtil", "getActiveRoomId err: ", e);
            AppMethodBeat.o(128002);
        }
        return i;
    }

    public static long dTI() {
        AppMethodBeat.i(128003);
        try {
            long j = a.dSR().sZg;
            AppMethodBeat.o(128003);
            return j;
        } catch (Exception e) {
            c.w("tagorewang:VoiceGroupUtil", "getActiveRoomKey err: ", e);
            AppMethodBeat.o(128003);
            return 0;
        }
    }
}
