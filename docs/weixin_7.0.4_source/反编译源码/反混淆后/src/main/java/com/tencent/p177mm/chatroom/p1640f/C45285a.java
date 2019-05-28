package com.tencent.p177mm.chatroom.p1640f;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.chatroom.f.a */
public final class C45285a {
    /* renamed from: bP */
    public static int m83496bP(int i, int i2) {
        AppMethodBeat.m2504i(104481);
        switch (i) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                AppMethodBeat.m2505o(104481);
                return 31;
            case 1:
                if ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) {
                    AppMethodBeat.m2505o(104481);
                    return 28;
                }
                AppMethodBeat.m2505o(104481);
                return 29;
            case 3:
            case 5:
            case 8:
            case 10:
                AppMethodBeat.m2505o(104481);
                return 30;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid Month");
                AppMethodBeat.m2505o(104481);
                throw illegalArgumentException;
        }
    }
}
