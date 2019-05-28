package com.tencent.mm.plugin.downloader.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b extends j<a> {
    public static final String[] fnj = new String[]{j.a(a.ccO, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    static {
        AppMethodBeat.i(2489);
        AppMethodBeat.o(2489);
    }

    public b(e eVar) {
        super(eVar, a.ccO, "FileDownloadInfo", null);
    }

    public final a In(String str) {
        a aVar = null;
        AppMethodBeat.i(2482);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FileDownloadInfoStorage", "appId is null");
            AppMethodBeat.o(2482);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\"", new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.o(2482);
            } else {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(2482);
            }
        }
        return aVar;
    }

    public static String N(LinkedList<String> linkedList) {
        AppMethodBeat.i(2483);
        String str = "";
        String str2;
        if (bo.ek(linkedList)) {
            str2 = "1=1";
            AppMethodBeat.o(2483);
            return str2;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < linkedList.size() - 1) {
                str = str + "appId=\"" + ((String) linkedList.get(i2)) + "\" or ";
                i = i2 + 1;
            } else {
                str2 = str + "appId=\"" + ((String) linkedList.get(linkedList.size() - 1)) + "\"";
                AppMethodBeat.o(2483);
                return str2;
            }
        }
    }

    public final a hC(long j) {
        a aVar = null;
        AppMethodBeat.i(2484);
        if (j < 0) {
            ab.e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
            AppMethodBeat.o(2484);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=".concat(String.valueOf(j)), new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.o(2484);
            } else {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(2484);
            }
        }
        return aVar;
    }

    public final a Iq(String str) {
        a aVar = null;
        AppMethodBeat.i(2485);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            AppMethodBeat.o(2485);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.o(2485);
            } else {
                if (rawQuery.moveToFirst()) {
                    aVar = new a();
                    aVar.d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.o(2485);
            }
        }
        return aVar;
    }

    public final boolean bit() {
        AppMethodBeat.i(2486);
        boolean hY = hY("FileDownloadInfo", "delete from FileDownloadInfo");
        AppMethodBeat.o(2486);
        return hY;
    }

    public final boolean Io(String str) {
        AppMethodBeat.i(2487);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            AppMethodBeat.o(2487);
            return false;
        }
        boolean hY = hY("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
        AppMethodBeat.o(2487);
        return hY;
    }

    public final boolean Ip(String str) {
        AppMethodBeat.i(2488);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            AppMethodBeat.o(2488);
            return false;
        }
        boolean hY = hY("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
        AppMethodBeat.o(2488);
        return hY;
    }
}
