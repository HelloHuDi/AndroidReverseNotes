package com.tencent.mm.cd;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class c {
    private static int index = 0;
    private static boolean on = false;
    private static a ybp = null;
    private static long ybq = 0;
    private static int ybr = 0;

    public static void k(Exception exception) {
        AppMethodBeat.i(59033);
        if (on) {
            ab.e("MicroMsg.DKTest", "exception:%s", bo.l(exception));
        }
        AppMethodBeat.o(59033);
    }

    static void begin() {
        AppMethodBeat.i(59034);
        if (on) {
            ybp = new a();
            index++;
            AppMethodBeat.o(59034);
            return;
        }
        AppMethodBeat.o(59034);
    }

    private static void s(Cursor cursor) {
        AppMethodBeat.i(59035);
        if (!on) {
            AppMethodBeat.o(59035);
        } else if (cursor == null) {
            AppMethodBeat.o(59035);
        } else {
            ybr = cursor.getCount();
            a aVar = new a();
            for (int i = 0; i < ybr; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            ybq = aVar.Mr();
            AppMethodBeat.o(59035);
        }
    }

    static void a(String str, Cursor cursor, long j) {
        AppMethodBeat.i(59036);
        if (on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + ybp.Mr() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                s(cursor);
                str2 = str2 + "[cuCnt:" + ybr + ",cuTime:" + ybq + "]";
            }
            str2 = str2 + "[" + str + "]--";
            ab.v("MicroMsg.dbtest", str2 + bo.dpG());
            AppMethodBeat.o(59036);
            return;
        }
        AppMethodBeat.o(59036);
    }
}
