package com.tencent.mm.plugin.zero.tasks;

import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.wcdb.support.Log;
import com.tencent.wcdb.support.Log.LogCallback;
import java.util.HashSet;

public final class a extends com.tencent.mm.kernel.a.c.a {
    public final String name() {
        return "boot-db-prepare";
    }

    public final void execute(g gVar) {
        AppMethodBeat.i(58779);
        if (!k.kx("wcdb")) {
            k.a("wcdb", getClass().getClassLoader());
        }
        Log.setLogger(new LogCallback() {
            private final HashSet<String> vah = new HashSet();

            {
                AppMethodBeat.i(58777);
                AppMethodBeat.o(58777);
            }

            public final void println(int i, String str, String str2) {
                AppMethodBeat.i(58778);
                com.tencent.mm.sdk.platformtools.ab.a dos = ab.dos();
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                switch (i) {
                    case 2:
                        dos.logV(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(58778);
                        return;
                    case 3:
                        dos.logD(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(58778);
                        return;
                    case 4:
                        dos.logI(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(58778);
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
                                        AppMethodBeat.o(58778);
                                        break;
                                    }
                                }
                            }
                            if (!add) {
                                try {
                                    e.pXa.g("DBAutoIndex", substring, null);
                                    return;
                                } catch (Exception e) {
                                    ab.e("DBLogger", "Cannot report automatic index: " + e.getMessage());
                                }
                            }
                        }
                        AppMethodBeat.o(58778);
                        return;
                    case 6:
                        dos.logE(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(58778);
                        return;
                    case 7:
                        dos.logF(str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(58778);
                        return;
                    default:
                        AppMethodBeat.o(58778);
                        return;
                }
            }
        });
        AppMethodBeat.o(58779);
    }
}
