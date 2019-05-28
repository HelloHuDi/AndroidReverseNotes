package com.tencent.mm.ui.chatting.j;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static final b yZH = new b();
    public int mCount;
    public int mSuccessCount;
    public int tVN;
    public int yZI;
    public int yZJ;
    public int yZK;

    static {
        AppMethodBeat.i(32672);
        AppMethodBeat.o(32672);
    }

    public final void c(boolean z, boolean z2, String str) {
        AppMethodBeat.i(32667);
        ab.i("MicroMsg.GetChatroomReporter", "[recordFetch] isDown:" + z + " isSuccess:" + z2 + " chatroomid:" + str);
        if (z) {
            this.yZI++;
        } else {
            this.yZJ++;
        }
        this.mCount++;
        if (z2) {
            this.mSuccessCount++;
            AppMethodBeat.o(32667);
            return;
        }
        this.tVN++;
        AppMethodBeat.o(32667);
    }

    public final void Pi(int i) {
        this.yZK += i;
    }

    public static void ax(String str, int i, int i2) {
        AppMethodBeat.i(32668);
        ab.i("MicroMsg.GetChatroomReporter", "[report] chatroomId:%s cleanCount:%s count:%s ", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (i > 0) {
            e.pXa.a(403, 67, 1, true);
            e.pXa.a(403, 68, (long) i, true);
        }
        e.pXa.a(403, 70, (long) i2, true);
        if (i2 <= 5) {
            e.pXa.a(403, 71, 1, true);
            AppMethodBeat.o(32668);
        } else if (i2 <= 10) {
            e.pXa.a(403, 72, 1, true);
            AppMethodBeat.o(32668);
        } else if (i2 <= 20) {
            e.pXa.a(403, 73, 1, true);
            AppMethodBeat.o(32668);
        } else if (i2 <= 30) {
            e.pXa.a(403, 74, 1, true);
            AppMethodBeat.o(32668);
        } else if (i2 <= 50) {
            e.pXa.a(403, 75, 1, true);
            AppMethodBeat.o(32668);
        } else {
            e.pXa.a(403, 76, 1, true);
            AppMethodBeat.o(32668);
        }
    }

    public static void dGX() {
        AppMethodBeat.i(32669);
        e.pXa.a(403, 77, 1, true);
        AppMethodBeat.o(32669);
    }

    public static void dGY() {
        AppMethodBeat.i(32670);
        e.pXa.a(403, 41, 1, false);
        AppMethodBeat.o(32670);
    }

    public static void dGZ() {
        AppMethodBeat.i(32671);
        e.pXa.a(403, 78, 1, false);
        AppMethodBeat.o(32671);
    }
}
