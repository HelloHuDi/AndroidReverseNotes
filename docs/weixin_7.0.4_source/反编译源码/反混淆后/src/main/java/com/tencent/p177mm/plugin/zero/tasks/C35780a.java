package com.tencent.p177mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1449k;
import com.tencent.p177mm.kernel.p238a.p715c.C42148a;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.plugin.report.C7053e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4990ab.C4989a;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

/* renamed from: com.tencent.mm.plugin.zero.tasks.a */
public final class C35780a extends C42148a {

    /* renamed from: com.tencent.mm.plugin.zero.tasks.a$1 */
    class C357811 implements LogCallback {
        private final HashSet<String> vah = new HashSet();

        C357811() {
            AppMethodBeat.m2504i(58777);
            AppMethodBeat.m2505o(58777);
        }

        public final void println(int i, String str, String str2) {
            AppMethodBeat.m2504i(58778);
            C4989a dos = C4990ab.dos();
            int myPid = Process.myPid();
            int myTid = Process.myTid();
            switch (i) {
                case 2:
                    dos.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                    AppMethodBeat.m2505o(58778);
                    return;
                case 3:
                    dos.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                    AppMethodBeat.m2505o(58778);
                    return;
                case 4:
                    dos.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                    AppMethodBeat.m2505o(58778);
                    return;
                case 5:
                    dos.logW(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                    if (str.equals("WCDB.SQLite") && str2.startsWith("[SQLite ErrCode: 284] automatic index on ")) {
                        boolean add;
                        String substring = str2.substring(41);
                        synchronized (this.vah) {
                            try {
                                add = this.vah.add(substring);
                            } finally {
                                while (true) {
                                    AppMethodBeat.m2505o(58778);
                                    break;
                                }
                            }
                        }
                        if (!add) {
                            try {
                                C7053e.pXa.mo8382g("DBAutoIndex", substring, null);
                                return;
                            } catch (Exception e) {
                                C4990ab.m7412e("DBLogger", "Cannot report automatic index: " + e.getMessage());
                            }
                        }
                    }
                    AppMethodBeat.m2505o(58778);
                    return;
                case 6:
                    dos.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                    AppMethodBeat.m2505o(58778);
                    return;
                case 7:
                    dos.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                    AppMethodBeat.m2505o(58778);
                    return;
                default:
                    AppMethodBeat.m2505o(58778);
                    return;
            }
        }
    }

    public final String name() {
        return "boot-db-prepare";
    }

    public final void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(58779);
        if (!C1449k.m3080kx("wcdb")) {
            C1449k.m3079a("wcdb", getClass().getClassLoader());
        }
        Log.setLogger(new C357811());
        AppMethodBeat.m2505o(58779);
    }
}
