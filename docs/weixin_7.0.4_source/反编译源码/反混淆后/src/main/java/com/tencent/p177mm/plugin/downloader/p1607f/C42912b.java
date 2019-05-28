package com.tencent.p177mm.plugin.downloader.p1607f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.p603e.C4927e;
import com.tencent.p177mm.sdk.p603e.C7563j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader.f.b */
public final class C42912b extends C7563j<C42911a> {
    public static final String[] fnj = new String[]{C7563j.m13217a(C42911a.ccO, "FileDownloadInfo"), "CREATE INDEX IF NOT EXISTS filedownloadinfo_appId  on FileDownloadInfo  (  appId )", "CREATE INDEX IF NOT EXISTS filedownloadinfo_status  on FileDownloadInfo  (  status )"};

    static {
        AppMethodBeat.m2504i(2489);
        AppMethodBeat.m2505o(2489);
    }

    public C42912b(C4927e c4927e) {
        super(c4927e, C42911a.ccO, "FileDownloadInfo", null);
    }

    /* renamed from: In */
    public final C42911a mo68439In(String str) {
        C42911a c42911a = null;
        AppMethodBeat.m2504i(2482);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FileDownloadInfoStorage", "appId is null");
            AppMethodBeat.m2505o(2482);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where appId=\"" + str + "\"", new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.m2505o(2482);
            } else {
                if (rawQuery.moveToFirst()) {
                    c42911a = new C42911a();
                    c42911a.mo8995d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(2482);
            }
        }
        return c42911a;
    }

    /* renamed from: N */
    public static String m76187N(LinkedList<String> linkedList) {
        AppMethodBeat.m2504i(2483);
        String str = "";
        String str2;
        if (C5046bo.m7548ek(linkedList)) {
            str2 = "1=1";
            AppMethodBeat.m2505o(2483);
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
                AppMethodBeat.m2505o(2483);
                return str2;
            }
        }
    }

    /* renamed from: hC */
    public final C42911a mo68444hC(long j) {
        C42911a c42911a = null;
        AppMethodBeat.m2504i(2484);
        if (j < 0) {
            C4990ab.m7412e("MicroMsg.FileDownloadInfoStorage", "download id is not avaiable");
            AppMethodBeat.m2505o(2484);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadId=".concat(String.valueOf(j)), new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.m2505o(2484);
            } else {
                if (rawQuery.moveToFirst()) {
                    c42911a = new C42911a();
                    c42911a.mo8995d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(2484);
            }
        }
        return c42911a;
    }

    /* renamed from: Iq */
    public final C42911a mo68442Iq(String str) {
        C42911a c42911a = null;
        AppMethodBeat.m2504i(2485);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FileDownloadInfoStorage", "Null or nil url");
            AppMethodBeat.m2505o(2485);
        } else {
            Cursor rawQuery = rawQuery("select * from FileDownloadInfo where downloadUrlHashCode=" + str.hashCode(), new String[0]);
            if (rawQuery == null) {
                AppMethodBeat.m2505o(2485);
            } else {
                if (rawQuery.moveToFirst()) {
                    c42911a = new C42911a();
                    c42911a.mo8995d(rawQuery);
                }
                if (rawQuery != null) {
                    rawQuery.close();
                }
                AppMethodBeat.m2505o(2485);
            }
        }
        return c42911a;
    }

    public final boolean bit() {
        AppMethodBeat.m2504i(2486);
        boolean hY = mo16768hY("FileDownloadInfo", "delete from FileDownloadInfo");
        AppMethodBeat.m2505o(2486);
        return hY;
    }

    /* renamed from: Io */
    public final boolean mo68440Io(String str) {
        AppMethodBeat.m2504i(2487);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, url is null");
            AppMethodBeat.m2505o(2487);
            return false;
        }
        boolean hY = mo16768hY("FileDownloadInfo", "delete from FileDownloadInfo where downloadUrl=\"" + str + "\"");
        AppMethodBeat.m2505o(2487);
        return hY;
    }

    /* renamed from: Ip */
    public final boolean mo68441Ip(String str) {
        AppMethodBeat.m2504i(2488);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FileDownloadInfoStorage", "deledonloadinfo failed, appId is null");
            AppMethodBeat.m2505o(2488);
            return false;
        }
        boolean hY = mo16768hY("FileDownloadInfo", "delete from FileDownloadInfo where appId=\"" + str + "\"");
        AppMethodBeat.m2505o(2488);
        return hY;
    }
}
