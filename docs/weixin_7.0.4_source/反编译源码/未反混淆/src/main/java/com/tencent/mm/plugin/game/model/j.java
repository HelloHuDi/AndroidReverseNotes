package com.tencent.mm.plugin.game.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

public final class j implements k {
    private static Set<a> jfv = Collections.synchronizedSet(new HashSet());
    private static j mVT = null;
    private static HashMap<String, b> mVU = new HashMap();

    public interface a {
        void f(int i, String str, boolean z);
    }

    static class b {
        String appId = "";
        String cvZ = "";
        String cvq = "";
        String mVX = "";
        boolean mVY = false;
        int scene = 0;

        b(String str, int i, String str2, String str3, String str4) {
            this.cvZ = str;
            this.scene = i;
            this.appId = str2;
            this.mVX = str3;
            this.cvq = str4;
        }
    }

    static {
        AppMethodBeat.i(111270);
        AppMethodBeat.o(111270);
    }

    private j() {
    }

    public static j bEg() {
        AppMethodBeat.i(111250);
        if (mVT == null) {
            mVT = new j();
        }
        j jVar = mVT;
        AppMethodBeat.o(111250);
        return jVar;
    }

    public static void a(a aVar) {
        AppMethodBeat.i(111251);
        synchronized (jfv) {
            try {
                jfv.add(aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(111251);
            }
        }
    }

    public static void b(a aVar) {
        AppMethodBeat.i(111252);
        synchronized (jfv) {
            try {
                jfv.remove(aVar);
                ab.d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", Integer.valueOf(jfv.size()), aVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(111252);
            }
        }
    }

    public static void bie() {
        AppMethodBeat.i(111253);
        if (mVT == null) {
            mVT = new j();
        }
        com.tencent.mm.plugin.downloader.b.a.a(new com.tencent.mm.plugin.downloader.b.a.b() {
            public final void E(int i, long j) {
                AppMethodBeat.i(111247);
                if (i == 9) {
                    j.iO(j);
                }
                AppMethodBeat.o(111247);
            }
        });
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.a(mVT);
        AppMethodBeat.o(111253);
    }

    public static void bgr() {
        AppMethodBeat.i(111254);
        d.bij();
        com.tencent.mm.plugin.downloader.model.b.b(mVT);
        mVT = null;
        jfv.clear();
        mVU.clear();
        AppMethodBeat.o(111254);
    }

    /* JADX WARNING: Missing block: B:4:0x001e, code skipped:
            r3 = com.tencent.mm.game.report.api.b.eBF.eZ(r24.field_downloadId);
     */
    /* JADX WARNING: Missing block: B:5:0x0028, code skipped:
            if (r3 == null) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:6:0x002a, code skipped:
            r5 = r3.eBE;
            com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.GameDownloadEventBus", "downloadReportInfo.opId: %d", java.lang.Integer.valueOf(r5));
     */
    /* JADX WARNING: Missing block: B:8:0x0047, code skipped:
            if (r24.field_finishTime <= 0) goto L_0x019b;
     */
    /* JADX WARNING: Missing block: B:9:0x0049, code skipped:
            r16 = r24.field_finishTime;
     */
    /* JADX WARNING: Missing block: B:10:0x004f, code skipped:
            r2 = com.tencent.mm.game.report.api.b.eBF;
            r3 = r24.field_appId;
            r4 = r24.field_scene;
            r6 = r24.field_startSize;
            r8 = r24.field_downloadedSize - r24.field_startSize;
            r10 = r24.field_totalSize;
            r12 = r24.field_downloadUrl;
            r13 = r24.field_errCode;
            r14 = r24.field_downloaderType;
            r15 = r24.field_channelId;
            r16 = (r16 - r24.field_startTime) / 1000;
            r18 = r24.field_startState;
            r19 = r24.field_downloadId;
            r21 = r24.field_extInfo;
     */
    /* JADX WARNING: Missing block: B:11:0x009e, code skipped:
            if (r24.field_reserveInWifi == false) goto L_0x01a3;
     */
    /* JADX WARNING: Missing block: B:12:0x00a0, code skipped:
            r22 = 1;
     */
    /* JADX WARNING: Missing block: B:13:0x00a2, code skipped:
            r2.a(r3, r4, r5, r6, r8, r10, r12, r13, r14, r15, r16, r18, r19, r21, r22);
     */
    /* JADX WARNING: Missing block: B:14:0x00aa, code skipped:
            if (r24.field_status == 2) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:16:0x00b1, code skipped:
            if (r24.field_status == 5) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:18:0x00b8, code skipped:
            if (r24.field_status == 4) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:20:0x00bf, code skipped:
            if (r24.field_status == 3) goto L_0x00c7;
     */
    /* JADX WARNING: Missing block: B:22:0x00c5, code skipped:
            if (r24.field_status != 0) goto L_0x00f1;
     */
    /* JADX WARNING: Missing block: B:23:0x00c7, code skipped:
            r2 = r24.field_downloadId;
            com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
            r4 = com.tencent.mm.sdk.platformtools.ah.getContext().getSharedPreferences("download_pref", 0);
     */
    /* JADX WARNING: Missing block: B:24:0x00e0, code skipped:
            if (r4 == null) goto L_0x00f1;
     */
    /* JADX WARNING: Missing block: B:25:0x00e2, code skipped:
            r4.edit().remove(java.lang.String.valueOf(r2)).apply();
     */
    /* JADX WARNING: Missing block: B:26:0x00f1, code skipped:
            if (r23 != null) goto L_0x01a7;
     */
    /* JADX WARNING: Missing block: B:27:0x00f3, code skipped:
            com.tencent.mm.game.report.api.b.eBF.a(r24.field_appId, r24.field_scene, r5, r24.field_md5, r24.field_downloadUrl, "", r24.field_extInfo);
     */
    /* JADX WARNING: Missing block: B:28:0x010f, code skipped:
            r2 = r24.field_appId;
            r1 = r28;
            com.tencent.mm.sdk.platformtools.al.d(new com.tencent.mm.plugin.game.model.j.AnonymousClass2(r25));
     */
    /* JADX WARNING: Missing block: B:42:0x019b, code skipped:
            r16 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Missing block: B:43:0x01a3, code skipped:
            r22 = 0;
     */
    /* JADX WARNING: Missing block: B:44:0x01a7, code skipped:
            com.tencent.mm.game.report.api.b.eBF.a(r23.appId, r23.scene, r5, r23.cvZ, r24.field_downloadUrl, r23.mVX, r23.cvq);
     */
    /* JADX WARNING: Missing block: B:45:0x01c6, code skipped:
            r5 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void y(long j, int i) {
        AppMethodBeat.i(111255);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            b bVar = (b) mVU.get(hv.field_downloadUrl);
            int i2 = 0;
            switch (i) {
                case 1:
                    i2 = 1;
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 0);
                    if (bVar != null) {
                        if (!bVar.mVY) {
                            com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 2);
                            break;
                        } else {
                            com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 1);
                            break;
                        }
                    }
                    break;
                case 2:
                    i2 = 6;
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 3);
                    break;
                case 3:
                    i2 = 3;
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 6);
                    break;
                case 4:
                    i2 = 2;
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 5);
                    break;
                case 5:
                    i2 = 8;
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 7);
                    break;
                case 6:
                    break;
                case 7:
                    i2 = 7;
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 4);
                    break;
            }
        }
        AppMethodBeat.o(111255);
    }

    public static void a(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.i(111256);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111256);
            return;
        }
        b bVar = new b(str2, i, str3, "", str4);
        bVar.mVY = true;
        mVU.put(str, bVar);
        AppMethodBeat.o(111256);
    }

    public static void n(String str, String str2, String str3, String str4) {
        AppMethodBeat.i(111257);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111257);
            return;
        }
        mVU.put(str, new b(str2, 1002, str3, "", str4));
        AppMethodBeat.o(111257);
    }

    public static void a(String str, String str2, int i, String str3, String str4, String str5) {
        AppMethodBeat.i(111258);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111258);
            return;
        }
        mVU.put(str, new b(str2, i, str3, str4, str5));
        AppMethodBeat.o(111258);
    }

    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.i(111259);
        y(j, 1);
        AppMethodBeat.o(111259);
    }

    public final void b(long j, String str, boolean z) {
        AppMethodBeat.i(111260);
        ab.i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", str, Boolean.valueOf(e.ct(str)));
        com.tencent.mm.plugin.downloader.f.a hv;
        if (bo.isNullOrNil(str) || !e.ct(str)) {
            hv = c.hv(j);
            if (hv != null) {
                hv.field_status = 4;
                hv.field_errCode = com.tencent.mm.plugin.downloader.a.a.kJZ;
                c.e(hv);
            }
            b(j, com.tencent.mm.plugin.downloader.a.a.kJZ, z);
            if (hv != null) {
                com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 9);
            }
            AppMethodBeat.o(111260);
            return;
        }
        y(j, 3);
        if (z) {
            hv = c.hv(j);
            if (hv != null) {
                String str2 = hv.field_appId;
                ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCW();
                t.b(str2, 5, 0, null, null);
            }
        }
        com.tencent.mm.plugin.game.c.a.iN(j);
        AppMethodBeat.o(111260);
    }

    public final void b(long j, int i, boolean z) {
        AppMethodBeat.i(111261);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null || !hv.field_downloadInWifi || at.isWifi(ah.getContext())) {
            y(j, 5);
            e(j, i, z);
            com.tencent.mm.plugin.game.c.a.iN(j);
            AppMethodBeat.o(111261);
            return;
        }
        ab.i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
        hv.field_status = 2;
        hv.field_errCode = 0;
        c.e(hv);
        com.tencent.mm.game.report.api.b.eBF.a(hv.field_appId, hv.field_scene, 13, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
        AppMethodBeat.o(111261);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.i(111262);
        y(j, 4);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            e.as(ah.getContext(), hv.field_appId);
        }
        AppMethodBeat.o(111262);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.i(111263);
        y(j, 2);
        AppMethodBeat.o(111263);
    }

    public final void gm(long j) {
        AppMethodBeat.i(111264);
        y(j, 6);
        AppMethodBeat.o(111264);
    }

    public final void i(long j, String str) {
        AppMethodBeat.i(111265);
        y(j, 7);
        AppMethodBeat.o(111265);
    }

    public final void gn(long j) {
    }

    private static void e(long j, int i, boolean z) {
        AppMethodBeat.i(111266);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv != null) {
            String str = null;
            if (i == com.tencent.mm.plugin.downloader.a.a.kJW) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ChannelId", hv.field_channelId);
                    jSONObject.put("DownloadSize", hv.field_downloadedSize);
                    str = com.tencent.mm.plugin.game.e.a.kY(jSONObject.toString());
                    ab.d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                } catch (Exception e) {
                    ab.e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e.getMessage());
                }
            }
            a(hv.field_appId, i, z, str);
        }
        AppMethodBeat.o(111266);
    }

    public static void a(String str, int i, boolean z, String str2) {
        AppMethodBeat.i(111267);
        if (i == 710 || i == 711) {
            i = com.tencent.mm.plugin.downloader.a.a.kJY;
        }
        ab.i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", str, Integer.valueOf(i));
        if (z) {
            ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCW();
            t.b(str, 4, i, null, str2);
            AppMethodBeat.o(111267);
            return;
        }
        ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCW();
        t.b(str, 2, i, null, str2);
        AppMethodBeat.o(111267);
    }

    public static void ex(String str, String str2) {
        AppMethodBeat.i(111268);
        ((com.tencent.mm.plugin.game.a.b) g.K(com.tencent.mm.plugin.game.a.b.class)).bCW();
        t.b(str, 6, 0, null, str2);
        AppMethodBeat.o(111268);
    }

    static /* synthetic */ void iO(final long j) {
        AppMethodBeat.i(111269);
        com.tencent.mm.sdk.g.d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(111249);
                com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
                if (hv == null) {
                    ab.e("MicroMsg.GameDownloadEventBus", "fInfo is null");
                    AppMethodBeat.o(111249);
                    return;
                }
                if (hv.field_status == 3) {
                    int i;
                    if (e.ct(hv.field_filePath)) {
                        ab.i("MicroMsg.GameDownloadEventBus", "onInstallFinish, delete file: %s", hv.field_filePath);
                        e.deleteFile(hv.field_filePath);
                    }
                    c.hw(j);
                    com.tencent.mm.game.report.api.b bVar = com.tencent.mm.game.report.api.b.eBF;
                    String str = hv.field_appId;
                    int i2 = hv.field_scene;
                    long j = hv.field_startSize;
                    long j2 = hv.field_downloadedSize - hv.field_startSize;
                    long j3 = hv.field_totalSize;
                    String str2 = hv.field_downloadUrl;
                    int i3 = hv.field_downloaderType;
                    String str3 = hv.field_channelId;
                    long j4 = (hv.field_finishTime - hv.field_startTime) / 1000;
                    int i4 = hv.field_startState;
                    long j5 = hv.field_downloadId;
                    String str4 = hv.field_extInfo;
                    if (hv.field_reserveInWifi) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    bVar.a(str, i2, 5, j, j2, j3, str2, 0, i3, str3, j4, i4, j5, str4, i);
                    com.tencent.mm.game.report.api.b.eBF.j(hv.field_appId, 8);
                    b bVar2 = (b) j.mVU.get(hv.field_downloadUrl);
                    if (bVar2 == null) {
                        com.tencent.mm.game.report.api.b.eBF.a(hv.field_appId, hv.field_scene, 5, hv.field_md5, hv.field_downloadUrl, "", hv.field_extInfo);
                        AppMethodBeat.o(111249);
                        return;
                    }
                    long j6;
                    com.tencent.mm.game.report.api.b.eBF.a(bVar2.appId, bVar2.scene, 5, bVar2.cvZ, hv.field_downloadUrl, bVar2.mVX, bVar2.cvq);
                    String str5 = hv.field_packageName;
                    SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("install_begin_time", 0);
                    if (sharedPreferences != null) {
                        j6 = sharedPreferences.getLong(str5, 0);
                    } else {
                        j6 = 0;
                    }
                    if (System.currentTimeMillis() - j6 <= 600000) {
                        com.tencent.mm.game.report.api.b.eBF.a(hv.field_appId, hv.field_scene, 17, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, 0, hv.field_downloaderType, hv.field_channelId, (hv.field_finishTime - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                    }
                }
                AppMethodBeat.o(111249);
            }
        }, "onInstallFinish");
        AppMethodBeat.o(111269);
    }
}
