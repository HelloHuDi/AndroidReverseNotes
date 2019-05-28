package com.tencent.p177mm.p213cd;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1447g.C1446a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.cd.c */
final class C1358c {
    private static int index = 0;
    /* renamed from: on */
    private static boolean f1227on = false;
    private static C1446a ybp = null;
    private static long ybq = 0;
    private static int ybr = 0;

    /* renamed from: k */
    public static void m2913k(Exception exception) {
        AppMethodBeat.m2504i(59033);
        if (f1227on) {
            C4990ab.m7413e("MicroMsg.DKTest", "exception:%s", C5046bo.m7574l(exception));
        }
        AppMethodBeat.m2505o(59033);
    }

    static void begin() {
        AppMethodBeat.m2504i(59034);
        if (f1227on) {
            ybp = new C1446a();
            index++;
            AppMethodBeat.m2505o(59034);
            return;
        }
        AppMethodBeat.m2505o(59034);
    }

    /* renamed from: s */
    private static void m2914s(Cursor cursor) {
        AppMethodBeat.m2504i(59035);
        if (!f1227on) {
            AppMethodBeat.m2505o(59035);
        } else if (cursor == null) {
            AppMethodBeat.m2505o(59035);
        } else {
            ybr = cursor.getCount();
            C1446a c1446a = new C1446a();
            for (int i = 0; i < ybr; i++) {
                cursor.moveToPosition(i);
            }
            cursor.moveToPosition(-1);
            ybq = c1446a.mo4908Mr();
            AppMethodBeat.m2505o(59035);
        }
    }

    /* renamed from: a */
    static void m2912a(String str, Cursor cursor, long j) {
        AppMethodBeat.m2504i(59036);
        if (f1227on) {
            String str2 = ("Thread:[" + Thread.currentThread().getId() + "," + Thread.currentThread().getName() + "]") + "[" + index + "][" + ybp.mo4908Mr() + "]";
            if (j != 0) {
                str2 = str2 + "[INTRANS]";
            }
            if (cursor != null) {
                C1358c.m2914s(cursor);
                str2 = str2 + "[cuCnt:" + ybr + ",cuTime:" + ybq + "]";
            }
            str2 = str2 + "[" + str + "]--";
            C4990ab.m7418v("MicroMsg.dbtest", str2 + C5046bo.dpG());
            AppMethodBeat.m2505o(59036);
            return;
        }
        AppMethodBeat.m2505o(59036);
    }
}
