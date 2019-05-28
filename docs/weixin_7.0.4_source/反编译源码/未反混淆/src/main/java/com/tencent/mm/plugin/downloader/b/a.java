package com.tencent.mm.plugin.downloader.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public final class a implements k {
    private static Set<b> jfv = new CopyOnWriteArraySet();
    private static a kKh = null;
    private static BroadcastReceiver kKi = null;
    private static c kKj = new c<hg>() {
        {
            AppMethodBeat.i(2283);
            this.xxI = hg.class.getName().hashCode();
            AppMethodBeat.o(2283);
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            AppMethodBeat.i(2284);
            hg hgVar = (hg) bVar;
            String str = hgVar.cCb.url;
            if (!bo.isNullOrNil(str)) {
                com.tencent.mm.plugin.downloader.f.a Iq = com.tencent.mm.plugin.downloader.model.c.Iq(str);
                if (Iq != null) {
                    hgVar.cCc.csB = Iq.field_appId;
                }
            }
            AppMethodBeat.o(2284);
            return false;
        }
    };

    public interface b {
        void E(int i, long j);
    }

    static class a extends BroadcastReceiver {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(2285);
            if (context == null || intent == null) {
                AppMethodBeat.o(2285);
                return;
            }
            String action = intent.getAction();
            ab.i("MicroMsg.DownloadEventBus", action);
            if (bo.isNullOrNil(action)) {
                ab.e("MicroMsg.DownloadEventBus", "action is null or nill, ignore");
                AppMethodBeat.o(2285);
            } else if (action.equals("android.intent.action.PACKAGE_ADDED") || action.equals("android.intent.action.PACKAGE_REPLACED")) {
                action = "";
                try {
                    action = intent.getDataString();
                } catch (Exception e) {
                    ab.e("MicroMsg.DownloadEventBus", "%s", bo.l(e));
                }
                ab.i("MicroMsg.DownloadEventBus", "get added package name : %s", action);
                if (bo.isNullOrNil(action)) {
                    ab.e("MicroMsg.DownloadEventBus", "get installed broadcast, while the package name is null or nil");
                    AppMethodBeat.o(2285);
                    return;
                }
                if (action.startsWith("package:")) {
                    action = action.substring(8);
                }
                if (!g.RK() || com.tencent.mm.kernel.a.QT()) {
                    ab.e("MicroMsg.DownloadEventBus", "no user login");
                    AppMethodBeat.o(2285);
                    return;
                }
                com.tencent.mm.plugin.downloader.f.a aVar;
                com.tencent.mm.plugin.downloader.f.b XS = com.tencent.mm.plugin.downloader.model.c.XS();
                if (XS == null) {
                    aVar = null;
                } else if (bo.isNullOrNil(action)) {
                    ab.e("MicroMsg.FileDownloadInfoStorage", "Null or nil PakcageName");
                    aVar = null;
                } else {
                    Cursor rawQuery = XS.rawQuery("select * from FileDownloadInfo where packageName='" + action + "' order by downloadId desc limit 1", new String[0]);
                    if (rawQuery == null) {
                        aVar = null;
                    } else {
                        if (rawQuery.moveToFirst()) {
                            aVar = new com.tencent.mm.plugin.downloader.f.a();
                            aVar.d(rawQuery);
                        } else {
                            aVar = null;
                        }
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    }
                }
                if (aVar == null) {
                    AppMethodBeat.o(2285);
                    return;
                }
                a.hk(aVar.field_downloadId);
                AppMethodBeat.o(2285);
            } else {
                AppMethodBeat.o(2285);
            }
        }
    }

    static /* synthetic */ void hk(long j) {
        AppMethodBeat.i(2299);
        D(9, j);
        AppMethodBeat.o(2299);
    }

    static {
        AppMethodBeat.i(2300);
        AppMethodBeat.o(2300);
    }

    public static void a(b bVar) {
        AppMethodBeat.i(2286);
        if (bVar != null) {
            jfv.add(bVar);
        }
        AppMethodBeat.o(2286);
    }

    public static void b(b bVar) {
        AppMethodBeat.i(2287);
        if (bVar != null) {
            jfv.remove(bVar);
        }
        AppMethodBeat.o(2287);
    }

    public static void bie() {
        AppMethodBeat.i(2288);
        if (kKh == null) {
            kKh = new a();
        }
        if (kKi == null) {
            kKi = new a();
        }
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.a(kKh);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        ah.getContext().registerReceiver(kKi, intentFilter);
        com.tencent.mm.sdk.b.a.xxA.c(kKj);
        AppMethodBeat.o(2288);
    }

    public static void bgr() {
        AppMethodBeat.i(2289);
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(kKh);
        ah.getContext().unregisterReceiver(kKi);
        kKh = null;
        kKi = null;
        jfv.clear();
        com.tencent.mm.sdk.b.a.xxA.d(kKj);
        AppMethodBeat.o(2289);
    }

    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.i(2290);
        D(1, j);
        AppMethodBeat.o(2290);
    }

    public final void b(long j, String str, boolean z) {
        AppMethodBeat.i(2291);
        D(3, j);
        AppMethodBeat.o(2291);
    }

    public final void b(long j, int i, boolean z) {
        AppMethodBeat.i(2292);
        D(5, j);
        AppMethodBeat.o(2292);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.i(2293);
        D(4, j);
        AppMethodBeat.o(2293);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.i(2294);
        D(2, j);
        AppMethodBeat.o(2294);
    }

    public final void gm(long j) {
        AppMethodBeat.i(2295);
        D(6, j);
        AppMethodBeat.o(2295);
    }

    public final void i(long j, String str) {
        AppMethodBeat.i(2296);
        D(7, j);
        AppMethodBeat.o(2296);
    }

    public final void gn(long j) {
        AppMethodBeat.i(2297);
        D(8, j);
        AppMethodBeat.o(2297);
    }

    private static void D(int i, long j) {
        AppMethodBeat.i(2298);
        ab.i("MicroMsg.DownloadEventBus", "dispatch event = %d, id = %d", Integer.valueOf(i), Long.valueOf(j));
        com.tencent.mm.plugin.downloader.f.a hv = com.tencent.mm.plugin.downloader.model.c.hv(j);
        if (hv == null) {
            AppMethodBeat.o(2298);
            return;
        }
        for (b E : jfv) {
            E.E(i, hv.field_downloadId);
        }
        AppMethodBeat.o(2298);
    }
}
