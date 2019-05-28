package com.tencent.p177mm.plugin.downloader.p1248e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37859a;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.C33917a;
import com.tencent.p177mm.plugin.downloader.p1249g.C33908a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p1607f.C42912b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.downloader.e.a */
public final class C20317a {
    private static BroadcastReceiver kNB = null;
    private static int kNC = -1;

    /* renamed from: com.tencent.mm.plugin.downloader.e.a$a */
    static class C20316a extends BroadcastReceiver {
        private C20316a() {
        }

        /* synthetic */ C20316a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(2478);
            if (!C1720g.m3531RK() || C1668a.m3393QT()) {
                C4990ab.m7412e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
                AppMethodBeat.m2505o(2478);
                return;
            }
            int netType = C5023at.getNetType(C4996ah.getContext());
            if (netType == C20317a.kNC) {
                AppMethodBeat.m2505o(2478);
                return;
            }
            C20317a.kNC = netType;
            C4990ab.m7416i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(netType)));
            LinkedList linkedList;
            Iterator it;
            C42911a c42911a;
            C2896d bij;
            long j;
            C33908a bin;
            if (C5023at.isWifi(netType)) {
                C42912b XS = C2895c.m5144XS();
                if (XS == null) {
                    linkedList = null;
                } else {
                    String str = "select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1";
                    C4990ab.m7416i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf(str)));
                    Cursor rawQuery = XS.rawQuery(str, new String[0]);
                    linkedList = new LinkedList();
                    if (rawQuery != null) {
                        while (rawQuery.moveToNext()) {
                            C42911a c42911a2 = new C42911a();
                            c42911a2.mo8995d(rawQuery);
                            linkedList.add(c42911a2);
                        }
                        rawQuery.close();
                    }
                }
                if (linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        c42911a = (C42911a) it.next();
                        C4990ab.m7417i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", c42911a.field_appId, Integer.valueOf(c42911a.field_status));
                        if (c42911a.field_status == 2) {
                            bij = C2896d.bij();
                            j = c42911a.field_downloadId;
                            c42911a = C2895c.m5147hv(j);
                            if (c42911a == null || c42911a.field_downloaderType != 3) {
                                bin = bij.bin();
                                C45405b.eBF.mo60567a(j, new C37859a(14));
                                bin.mo54460n(j, true);
                            } else {
                                C33917a bio = bij.bio();
                                C45405b.eBF.mo60567a(j, new C37859a(14));
                                bio.mo54466n(j, true);
                            }
                        } else if (c42911a.field_status == 0 && c42911a.field_reserveInWifi) {
                            bij = C2896d.bij();
                            if (c42911a.field_downloaderType == 3) {
                                bij.bio().mo23223a(c42911a);
                            } else {
                                bij.bik().mo23223a(c42911a);
                            }
                        }
                    }
                }
                AppMethodBeat.m2505o(2478);
                return;
            }
            linkedList = C2895c.bii();
            if (linkedList != null) {
                it = linkedList.iterator();
                while (it.hasNext()) {
                    c42911a = (C42911a) it.next();
                    C4990ab.m7416i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + c42911a.field_appId);
                    bij = C2896d.bij();
                    j = c42911a.field_downloadId;
                    c42911a = C2895c.m5147hv(j);
                    if (c42911a == null || c42911a.field_downloaderType != 3) {
                        bin = bij.bin();
                        C45405b.eBF.mo60567a(j, new C37859a(13));
                        bin.mo23227hn(j);
                    } else {
                        bij.bio().mo54465hq(j);
                    }
                }
            }
            AppMethodBeat.m2505o(2478);
        }
    }

    public static void bie() {
        AppMethodBeat.m2504i(2479);
        if (kNB == null) {
            kNB = new C20316a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            C4996ah.getContext().registerReceiver(kNB, intentFilter);
            AppMethodBeat.m2505o(2479);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.Downloader.NetWorkManager", e.getMessage());
            AppMethodBeat.m2505o(2479);
        }
    }

    public static void bgr() {
        AppMethodBeat.m2504i(2480);
        if (kNB != null) {
            try {
                C4996ah.getContext().unregisterReceiver(kNB);
            } catch (Exception e) {
                C4990ab.m7412e("MicroMsg.Downloader.NetWorkManager", e.getMessage());
            }
        }
        kNB = null;
        AppMethodBeat.m2505o(2480);
    }
}
