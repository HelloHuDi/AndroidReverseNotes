package com.tencent.p177mm.plugin.downloader.model;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.sdk.p603e.C4925c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader.model.c */
public final class C2895c {
    /* renamed from: hv */
    public static C42911a m5147hv(long j) {
        AppMethodBeat.m2504i(2396);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2396);
            return null;
        }
        C42911a hC = XS.mo68444hC(j);
        AppMethodBeat.m2505o(2396);
        return hC;
    }

    /* renamed from: In */
    public static C42911a m5140In(String str) {
        AppMethodBeat.m2504i(2397);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2397);
            return null;
        }
        C42911a In = XS.mo68439In(str);
        AppMethodBeat.m2505o(2397);
        return In;
    }

    /* renamed from: d */
    public static long m5145d(C42911a c42911a) {
        AppMethodBeat.m2504i(2398);
        if (c42911a == null) {
            AppMethodBeat.m2505o(2398);
            return -1;
        }
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2398);
            return -1;
        }
        c42911a.field_updateTime = System.currentTimeMillis();
        C4990ab.m7416i("MicroMsg.FileDownloadInfoDBHelper", "insert downloadinfo: " + c42911a.field_downloadId + ", ret=" + XS.mo10101b((C4925c) c42911a));
        long j = c42911a.field_downloadId;
        AppMethodBeat.m2505o(2398);
        return j;
    }

    /* renamed from: e */
    public static long m5146e(C42911a c42911a) {
        AppMethodBeat.m2504i(2399);
        if (c42911a == null) {
            AppMethodBeat.m2505o(2399);
            return -1;
        }
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2399);
            return -1;
        }
        c42911a.field_updateTime = System.currentTimeMillis();
        boolean c = XS.mo10103c(c42911a, new String[0]);
        C4990ab.m7417i("MicroMsg.FileDownloadInfoDBHelper", "Update Downloadinfo, ID: %d, ret: %b, Status: %d", Long.valueOf(c42911a.field_downloadId), Boolean.valueOf(c), Integer.valueOf(c42911a.field_status));
        long j = c42911a.field_downloadId;
        AppMethodBeat.m2505o(2399);
        return j;
    }

    /* renamed from: Io */
    public static boolean m5141Io(String str) {
        AppMethodBeat.m2504i(2400);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2400);
            return false;
        }
        boolean Io = XS.mo68440Io(str);
        AppMethodBeat.m2505o(2400);
        return Io;
    }

    /* renamed from: Ip */
    public static boolean m5142Ip(String str) {
        AppMethodBeat.m2504i(2401);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2401);
            return false;
        }
        boolean Ip = XS.mo68441Ip(str);
        AppMethodBeat.m2505o(2401);
        return Ip;
    }

    /* renamed from: Iq */
    public static C42911a m5143Iq(String str) {
        AppMethodBeat.m2504i(2402);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2402);
            return null;
        }
        C42911a Iq = XS.mo68442Iq(str);
        AppMethodBeat.m2505o(2402);
        return Iq;
    }

    /* renamed from: hw */
    public static boolean m5148hw(long j) {
        AppMethodBeat.m2504i(2403);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2403);
            return false;
        }
        C42911a c42911a = new C42911a();
        c42911a.field_downloadId = j;
        boolean a = XS.mo16760a((C4925c) c42911a, new String[0]);
        AppMethodBeat.m2505o(2403);
        return a;
    }

    public static LinkedList<C42911a> bii() {
        AppMethodBeat.m2504i(2404);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            AppMethodBeat.m2505o(2404);
            return null;
        }
        String str = "select * from FileDownloadInfo where status=1 and downloadInWifi=1";
        C4990ab.m7416i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiRunningTasks, sql = ".concat(String.valueOf(str)));
        Cursor rawQuery = XS.rawQuery(str, new String[0]);
        LinkedList<C42911a> linkedList = new LinkedList();
        if (rawQuery == null) {
            AppMethodBeat.m2505o(2404);
            return linkedList;
        }
        while (rawQuery.moveToNext()) {
            C42911a c42911a = new C42911a();
            c42911a.mo8995d(rawQuery);
            linkedList.add(c42911a);
        }
        rawQuery.close();
        AppMethodBeat.m2505o(2404);
        return linkedList;
    }

    /* renamed from: XS */
    public static C42912b m5144XS() {
        AppMethodBeat.m2504i(2405);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                if (C1720g.m3528K(C45826d.class) == null) {
                    C4990ab.m7412e("MicroMsg.FileDownloadInfoDBHelper", "service not ready");
                    AppMethodBeat.m2505o(2405);
                    return null;
                }
                C42912b XS = ((C45826d) C1720g.m3528K(C45826d.class)).mo7017XS();
                AppMethodBeat.m2505o(2405);
                return XS;
            }
        }
        C4990ab.m7412e("MicroMsg.FileDownloadInfoDBHelper", "no user login");
        AppMethodBeat.m2505o(2405);
        return null;
    }
}
