package com.tencent.mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

public final class c {
    public static a hv(long j) {
        AppMethodBeat.i(2396);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2396);
            return null;
        }
        a hC = XS.hC(j);
        AppMethodBeat.o(2396);
        return hC;
    }

    public static a In(String str) {
        AppMethodBeat.i(2397);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2397);
            return null;
        }
        a In = XS.In(str);
        AppMethodBeat.o(2397);
        return In;
    }

    public static long d(a aVar) {
        AppMethodBeat.i(2398);
        if (aVar == null) {
            AppMethodBeat.o(2398);
            return -1;
        }
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2398);
            return -1;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        ab.i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + aVar.field_downloadId + ", ret=" + XS.b((com.tencent.mm.sdk.e.c) aVar));
        long j = aVar.field_downloadId;
        AppMethodBeat.o(2398);
        return j;
    }

    public static long e(a aVar) {
        AppMethodBeat.i(2399);
        if (aVar == null) {
            AppMethodBeat.o(2399);
            return -1;
        }
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2399);
            return -1;
        }
        aVar.field_updateTime = System.currentTimeMillis();
        boolean c = XS.c(aVar, new String[0]);
        ab.i("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(aVar.field_downloadId), Boolean.valueOf(c), Integer.valueOf(aVar.field_status));
        long j = aVar.field_downloadId;
        AppMethodBeat.o(2399);
        return j;
    }

    public static boolean Io(String str) {
        AppMethodBeat.i(2400);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2400);
            return false;
        }
        boolean Io = XS.Io(str);
        AppMethodBeat.o(2400);
        return Io;
    }

    public static boolean Ip(String str) {
        AppMethodBeat.i(2401);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2401);
            return false;
        }
        boolean Ip = XS.Ip(str);
        AppMethodBeat.o(2401);
        return Ip;
    }

    public static a Iq(String str) {
        AppMethodBeat.i(2402);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2402);
            return null;
        }
        a Iq = XS.Iq(str);
        AppMethodBeat.o(2402);
        return Iq;
    }

    public static boolean hw(long j) {
        AppMethodBeat.i(2403);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2403);
            return false;
        }
        a aVar = new a();
        aVar.field_downloadId = j;
        boolean a = XS.a((com.tencent.mm.sdk.e.c) aVar, new String[0]);
        AppMethodBeat.o(2403);
        return a;
    }

    public static LinkedList<a> bii() {
        AppMethodBeat.i(2404);
        b XS = XS();
        if (XS == null) {
            AppMethodBeat.o(2404);
            return null;
        }
        String str = "select * from FileDownloadInfo where status=1 and downloadInWifi=1";
        ab.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = ".concat(String.valueOf(str)));
        Cursor rawQuery = XS.rawQuery(str, new String[0]);
        LinkedList<a> linkedList = new LinkedList();
        if (rawQuery == null) {
            AppMethodBeat.o(2404);
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            a aVar = new a();
            aVar.d(rawQuery);
            linkedList.add(aVar);
        }
        rawQuery.close();
        AppMethodBeat.o(2404);
        return linkedList;
    }

    public static b XS() {
        AppMethodBeat.i(2405);
        if (g.RN().QY()) {
            g.RN();
            if (!com.tencent.mm.kernel.a.QT()) {
                if (g.K(d.class) == null) {
                    ab.e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
                    AppMethodBeat.o(2405);
                    return null;
                }
                b XS = ((d) g.K(d.class)).XS();
                AppMethodBeat.o(2405);
                return XS;
            }
        }
        ab.e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        AppMethodBeat.o(2405);
        return null;
    }
}
