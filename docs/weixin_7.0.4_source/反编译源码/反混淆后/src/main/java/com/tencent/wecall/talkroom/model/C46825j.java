package com.tencent.wecall.talkroom.model;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p659pb.common.p1102c.C44443c;

/* renamed from: com.tencent.wecall.talkroom.model.j */
public final class C46825j {
    public static boolean auS(String str) {
        AppMethodBeat.m2504i(128001);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.m2505o(128001);
            return false;
        }
        boolean startsWith = str.startsWith("client_");
        AppMethodBeat.m2505o(128001);
        return startsWith;
    }

    public static int dTH() {
        int i = 0;
        AppMethodBeat.m2504i(128002);
        try {
            i = C41112a.dSR().nCF;
            AppMethodBeat.m2505o(128002);
        } catch (Exception e) {
            C44443c.m80392w("tagorewang:VoiceGroupUtil", "getActiveRoomId err: ", e);
            AppMethodBeat.m2505o(128002);
        }
        return i;
    }

    public static long dTI() {
        AppMethodBeat.m2504i(128003);
        try {
            long j = C41112a.dSR().sZg;
            AppMethodBeat.m2505o(128003);
            return j;
        } catch (Exception e) {
            C44443c.m80392w("tagorewang:VoiceGroupUtil", "getActiveRoomKey err: ", e);
            AppMethodBeat.m2505o(128003);
            return 0;
        }
    }
}
