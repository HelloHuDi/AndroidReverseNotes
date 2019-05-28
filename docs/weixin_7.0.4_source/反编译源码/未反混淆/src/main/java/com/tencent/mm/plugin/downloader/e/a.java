package com.tencent.mm.plugin.downloader.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.f.b;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import java.util.Iterator;
import java.util.LinkedList;

public final class a {
    private static BroadcastReceiver kNB = null;
    private static int kNC = -1;

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(2478);
            if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
                ab.e("MicroMsg.Downloader.NetWorkManager", "acc has not ready");
                AppMethodBeat.o(2478);
                return;
            }
            int netType = at.getNetType(ah.getContext());
            if (netType == a.kNC) {
                AppMethodBeat.o(2478);
                return;
            }
            a.kNC = netType;
            ab.i("MicroMsg.Downloader.NetWorkManager", "onNetStateChange, netState = ".concat(String.valueOf(netType)));
            LinkedList linkedList;
            Iterator it;
            com.tencent.mm.plugin.downloader.f.a aVar;
            d bij;
            long j;
            com.tencent.mm.plugin.downloader.g.a bin;
            if (at.isWifi(netType)) {
                b XS = c.XS();
                if (XS == null) {
                    linkedList = null;
                } else {
                    String str = "select * from FileDownloadInfo where status<>1 and status<>3 and downloadInWifi=1";
                    ab.i("MicroMsg.FileDownloadInfoStorage", "getDownloadInWifiPauseTasks, sql = ".concat(String.valueOf(str)));
                    Cursor rawQuery = XS.rawQuery(str, new String[0]);
                    linkedList = new LinkedList();
                    if (rawQuery != null) {
                        while (rawQuery.moveToNext()) {
                            com.tencent.mm.plugin.downloader.f.a aVar2 = new com.tencent.mm.plugin.downloader.f.a();
                            aVar2.d(rawQuery);
                            linkedList.add(aVar2);
                        }
                        rawQuery.close();
                    }
                }
                if (linkedList != null) {
                    it = linkedList.iterator();
                    while (it.hasNext()) {
                        aVar = (com.tencent.mm.plugin.downloader.f.a) it.next();
                        ab.i("MicroMsg.Downloader.NetWorkManager", "resumeTask, appId = %s, state = %d", aVar.field_appId, Integer.valueOf(aVar.field_status));
                        if (aVar.field_status == 2) {
                            bij = d.bij();
                            j = aVar.field_downloadId;
                            aVar = c.hv(j);
                            if (aVar == null || aVar.field_downloaderType != 3) {
                                bin = bij.bin();
                                com.tencent.mm.game.report.api.b.eBF.a(j, new com.tencent.mm.game.report.api.a(14));
                                bin.n(j, true);
                            } else {
                                com.tencent.mm.plugin.downloader.model.a bio = bij.bio();
                                com.tencent.mm.game.report.api.b.eBF.a(j, new com.tencent.mm.game.report.api.a(14));
                                bio.n(j, true);
                            }
                        } else if (aVar.field_status == 0 && aVar.field_reserveInWifi) {
                            bij = d.bij();
                            if (aVar.field_downloaderType == 3) {
                                bij.bio().a(aVar);
                            } else {
                                bij.bik().a(aVar);
                            }
                        }
                    }
                }
                AppMethodBeat.o(2478);
                return;
            }
            linkedList = c.bii();
            if (linkedList != null) {
                it = linkedList.iterator();
                while (it.hasNext()) {
                    aVar = (com.tencent.mm.plugin.downloader.f.a) it.next();
                    ab.i("MicroMsg.Downloader.NetWorkManager", "pauseTask, appId: " + aVar.field_appId);
                    bij = d.bij();
                    j = aVar.field_downloadId;
                    aVar = c.hv(j);
                    if (aVar == null || aVar.field_downloaderType != 3) {
                        bin = bij.bin();
                        com.tencent.mm.game.report.api.b.eBF.a(j, new com.tencent.mm.game.report.api.a(13));
                        bin.hn(j);
                    } else {
                        bij.bio().hq(j);
                    }
                }
            }
            AppMethodBeat.o(2478);
        }
    }

    public static void bie() {
        AppMethodBeat.i(2479);
        if (kNB == null) {
            kNB = new a();
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            ah.getContext().registerReceiver(kNB, intentFilter);
            AppMethodBeat.o(2479);
        } catch (Exception e) {
            ab.e("MicroMsg.Downloader.NetWorkManager", e.getMessage());
            AppMethodBeat.o(2479);
        }
    }

    public static void bgr() {
        AppMethodBeat.i(2480);
        if (kNB != null) {
            try {
                ah.getContext().unregisterReceiver(kNB);
            } catch (Exception e) {
                ab.e("MicroMsg.Downloader.NetWorkManager", e.getMessage());
            }
        }
        kNB = null;
        AppMethodBeat.o(2480);
    }
}
