package com.tencent.p177mm.plugin.downloader;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.p850a.C9541b;
import com.tencent.p177mm.kernel.C1706e.C1705c;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.kernel.api.C1671c;
import com.tencent.p177mm.kernel.p241b.C1681g;
import com.tencent.p177mm.kernel.p241b.C7597f;
import com.tencent.p177mm.plugin.cdndownloader.C42877a;
import com.tencent.p177mm.plugin.cdndownloader.p1543b.C38782a;
import com.tencent.p177mm.plugin.cdndownloader.p936g.C11369a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C33917a;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadService;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.downloader.p1248e.C20317a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader.p939a.C38842c;
import com.tencent.p177mm.plugin.downloader.p939a.C38843e;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.downloader.PluginDownloader */
public class PluginDownloader extends C7597f implements C1671c, C38843e {
    private static C2880a kJK;

    /* renamed from: com.tencent.mm.plugin.downloader.PluginDownloader$1 */
    class C76331 implements Runnable {
        C76331() {
        }

        public final void run() {
            AppMethodBeat.m2504i(2277);
            PluginDownloader.access$000(PluginDownloader.this);
            AppMethodBeat.m2505o(2277);
        }
    }

    static /* synthetic */ void access$000(PluginDownloader pluginDownloader) {
        AppMethodBeat.m2504i(2282);
        pluginDownloader.resumeDownloadTaskWhenProcessRestart();
        AppMethodBeat.m2505o(2282);
    }

    public void configure(C1681g c1681g) {
    }

    public void execute(C1681g c1681g) {
        AppMethodBeat.m2504i(2278);
        C4990ab.m7410d("MicroMsg.PluginDownloader", "execute");
        if (c1681g.mo5181SG()) {
            C1720g.m3542a(C45826d.class, new C2881b());
            C1720g.m3542a(C38782a.class, new C42877a());
            C2880a c2880a = new C2880a(C33917a.kMy);
            kJK = c2880a;
            c2880a.startWatching();
        }
        AppMethodBeat.m2505o(2278);
    }

    public void onAccountInitialized(C1705c c1705c) {
        AppMethodBeat.m2504i(2279);
        C4990ab.m7416i("MicroMsg.PluginDownloader", "onAccountInitialized");
        C20317a.bie();
        C11369a.aNS().mo10310m(new C76331(), 500);
        C33903a.bie();
        AppMethodBeat.m2505o(2279);
    }

    public void onAccountRelease() {
        AppMethodBeat.m2504i(2280);
        C4990ab.m7416i("MicroMsg.PluginDownloader", "onAccountRelease");
        C20317a.bgr();
        C33903a.bgr();
        C38842c.clearCache();
        AppMethodBeat.m2505o(2280);
    }

    private void resumeDownloadTaskWhenProcessRestart() {
        List list;
        AppMethodBeat.m2504i(2281);
        C42912b XS = C2895c.m5144XS();
        if (XS == null) {
            list = null;
        } else {
            C4990ab.m7416i("MicroMsg.FileDownloadInfoStorage", "getRunningDownloadInfos: select * from FileDownloadInfo where status=1");
            Cursor rawQuery = XS.rawQuery("select * from FileDownloadInfo where status=1", new String[0]);
            if (rawQuery == null) {
                C4990ab.m7416i("MicroMsg.FileDownloadInfoStorage", "cursor is null");
                list = null;
            } else {
                list = new LinkedList();
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
                FileDownloadTaskInfo hm = C2896d.bij().mo7048hm(c42911a2.field_downloadId);
                C2896d bij;
                long j;
                if (hm.status == 3) {
                    C4990ab.m7416i("MicroMsg.PluginDownloader", "has download finish");
                    c42911a2.field_finishTime = System.currentTimeMillis();
                    c42911a2.field_downloadedSize = c42911a2.field_totalSize;
                    c42911a2.field_status = 6;
                    C4990ab.m7417i("MicroMsg.PluginDownloader", "download succeed, downloadedSize = %d, startSize = %d", Long.valueOf(c42911a2.field_downloadedSize), Long.valueOf(c42911a2.field_startSize));
                    C2895c.m5146e(c42911a2);
                    bij = C2896d.bij();
                    j = c42911a2.field_downloadId;
                    if (bij.kMT != null) {
                        bij.kMT.mo7029hu(j);
                    }
                    Intent intent = new Intent();
                    intent.putExtra(FileDownloadService.kNn, 1);
                    intent.setClass(C4996ah.getContext(), FileDownloadService.class);
                    intent.putExtra(FileDownloadService.EXTRA_ID, c42911a2.field_downloadId);
                    try {
                        C4996ah.getContext().startService(intent);
                    } catch (Exception e) {
                        C4990ab.m7412e("MicroMsg.PluginDownloader", e.getMessage());
                    }
                    C7060h.pYm.mo8378a(710, 12, 1, false);
                } else if (hm.status != 1) {
                    C7060h.pYm.mo8378a(710, 14, 1, false);
                    C4990ab.m7416i("MicroMsg.PluginDownloader", "download fail, all process dead, appId: " + c42911a2.field_appId);
                    j = (System.currentTimeMillis() - c42911a2.field_updateTime) / 1000;
                    C4990ab.m7416i("MicroMsg.PluginDownloader", "lastTime = ".concat(String.valueOf(j)));
                    if (j <= 1800) {
                        C4990ab.m7417i("MicroMsg.PluginDownloader", "in half hour, net: %s, downloadInWifi: %b, expt: %b", C5023at.getNetTypeString(C4996ah.getContext()), Boolean.valueOf(hm.kNt), Boolean.valueOf(((C9541b) C1720g.m3528K(C9541b.class)).mo20808a(C11745a.clicfg_download_resume_not_in_wifi)));
                        if (C5023at.isWifi(C4996ah.getContext())) {
                            C4990ab.m7416i("MicroMsg.PluginDownloader", "in half hour, in wifi, restart");
                            C2896d.bij().mo7051hp(c42911a2.field_downloadId);
                            C7060h.pYm.mo8378a(710, 15, 1, false);
                        } else if (hm.kNt || !r1) {
                            C7060h.pYm.mo8378a(710, 17, 1, false);
                        } else {
                            C4990ab.m7416i("MicroMsg.PluginDownloader", "download not in wifi");
                            C2896d.bij().mo7051hp(c42911a2.field_downloadId);
                            C7060h.pYm.mo8378a(710, 19, 1, false);
                        }
                    } else {
                        C7060h.pYm.mo8378a(710, 16, 1, false);
                        if (!C5023at.isWifi(C4996ah.getContext())) {
                            C7060h.pYm.mo8378a(710, 17, 1, false);
                        }
                    }
                    c42911a2.field_finishTime = System.currentTimeMillis();
                    c42911a2.field_status = 4;
                    c42911a2.field_errCode = C11498a.kJU;
                    C2895c.m5146e(c42911a2);
                    bij = C2896d.bij();
                    j = c42911a2.field_downloadId;
                    int i = c42911a2.field_errCode;
                    if (bij.kMT != null) {
                        bij.kMT.mo7025d(j, i, false);
                    }
                } else {
                    C4990ab.m7416i("MicroMsg.PluginDownloader", "download process alive, still downloading: " + c42911a2.field_appId);
                    C7060h.pYm.mo8378a(710, 13, 1, false);
                }
            }
        }
        AppMethodBeat.m2505o(2281);
    }
}
