package com.tencent.p177mm.plugin.downloader;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.bucket.C18523a;
import com.tencent.p177mm.kernel.api.bucket.C26346d;
import com.tencent.p177mm.p213cd.C7480h;
import com.tencent.p177mm.p213cd.C7480h.C1366d;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C38855d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.downloader.b */
public final class C2881b implements C18523a, C26346d, C45826d {
    private C42912b kJH;
    private long kJI = 0;

    /* renamed from: com.tencent.mm.plugin.downloader.b$1 */
    class C28821 implements C1366d {
        C28821() {
        }

        /* renamed from: Af */
        public final String[] mo4750Af() {
            return C42912b.fnj;
        }
    }

    /* renamed from: com.tencent.mm.plugin.downloader.b$2 */
    class C28832 implements Runnable {
        C28832() {
        }

        public final void run() {
            AppMethodBeat.m2504i(2271);
            C2881b.bid();
            AppMethodBeat.m2505o(2271);
        }
    }

    public final void onDataBaseOpened(C7480h c7480h, C7480h c7480h2) {
        AppMethodBeat.m2504i(2272);
        this.kJH = new C42912b(c7480h);
        AppMethodBeat.m2505o(2272);
    }

    public final void onDataBaseClosed(C7480h c7480h, C7480h c7480h2) {
    }

    /* renamed from: XS */
    public final C42912b mo7017XS() {
        AppMethodBeat.m2504i(2273);
        C1720g.m3537RQ();
        C1720g.m3534RN().mo5159QU();
        C42912b c42912b = this.kJH;
        AppMethodBeat.m2505o(2273);
        return c42912b;
    }

    public final HashMap<Integer, C1366d> collectDatabaseFactory() {
        AppMethodBeat.m2504i(2274);
        C4990ab.m7410d("MicroMsg.FileDownloaderService", "collectDatabaseFactory");
        HashMap hashMap = new HashMap();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new C28821());
        AppMethodBeat.m2505o(2274);
        return hashMap;
    }

    /* renamed from: fZ */
    public final void mo7018fZ(boolean z) {
        AppMethodBeat.m2504i(2275);
        C4990ab.m7416i("MicroMsg.FileDownloaderService", "active: ".concat(String.valueOf(z)));
        if (!z && (System.currentTimeMillis() - this.kJI) / 1000 > 1800) {
            C7305d.post(new C28832(), "checkDownloadFile");
            this.kJI = System.currentTimeMillis();
        }
        AppMethodBeat.m2505o(2275);
    }

    static /* synthetic */ void bid() {
        List list;
        AppMethodBeat.m2504i(2276);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            list = null;
        } else {
            String str = "select * from FileDownloadInfo";
            C4990ab.m7416i("MicroMsg.FileDownloadInfoStorage", "getAllTasks, sql = ".concat(String.valueOf(str)));
            Cursor rawQuery = XS.rawQuery(str, new String[0]);
            list = new LinkedList();
            if (rawQuery != null) {
                while (rawQuery.moveToNext()) {
                    C42911a c42911a = new C42911a();
                    c42911a.mo8995d(rawQuery);
                    list.add(c42911a);
                }
                rawQuery.close();
            }
        }
        if (!C5046bo.m7548ek(list)) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C42911a c42911a2 = (C42911a) it.next();
                long currentTimeMillis = (System.currentTimeMillis() - c42911a2.field_updateTime) / 1000;
                int i = c42911a2.field_totalSize > 0 ? (int) ((c42911a2.field_downloadedSize * 100) / c42911a2.field_totalSize) : 0;
                if (c42911a2.field_status != 1) {
                    boolean z;
                    if (c42911a2.field_status == 3) {
                        if (currentTimeMillis >= 2592000) {
                            z = true;
                        }
                        z = false;
                    } else {
                        if (currentTimeMillis >= 172800) {
                            C7060h.pYm.mo8378a(710, 20, 1, false);
                            z = true;
                        }
                        z = false;
                    }
                    if (z) {
                        C5730e.deleteFile(c42911a2.field_filePath);
                        C2895c.m5148hw(c42911a2.field_downloadId);
                        ((C38855d) C1720g.m3528K(C38855d.class)).mo61734kP(c42911a2.field_appId);
                    }
                    C4990ab.m7417i("MicroMsg.FileDownloaderService", "checkRemovedDownloadFile, appId: %s, interval: %d, percent: %d, delete: %b", c42911a2.field_appId, Long.valueOf(currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
                }
            }
        }
        AppMethodBeat.m2505o(2276);
    }
}
