package com.tencent.p177mm.plugin.game.model;

import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C45405b;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C11511k;
import com.tencent.p177mm.plugin.downloader.model.C2886b;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.plugin.downloader.p939a.C11498a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a;
import com.tencent.p177mm.plugin.downloader.p940b.C33903a.C11501b;
import com.tencent.p177mm.plugin.game.p1268a.C43156b;
import com.tencent.p177mm.plugin.game.p1402c.C28176a;
import com.tencent.p177mm.plugin.game.p1485e.C34276a;
import com.tencent.p177mm.sdk.p604g.C7305d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.vfs.C5730e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.game.model.j */
public final class C20998j implements C11511k {
    private static Set<C20997a> jfv = Collections.synchronizedSet(new HashSet());
    private static C20998j mVT = null;
    private static HashMap<String, C20999b> mVU = new HashMap();

    /* renamed from: com.tencent.mm.plugin.game.model.j$a */
    public interface C20997a {
        /* renamed from: f */
        void mo36316f(int i, String str, boolean z);
    }

    /* renamed from: com.tencent.mm.plugin.game.model.j$b */
    static class C20999b {
        String appId = "";
        String cvZ = "";
        String cvq = "";
        String mVX = "";
        boolean mVY = false;
        int scene = 0;

        C20999b(String str, int i, String str2, String str3, String str4) {
            this.cvZ = str;
            this.scene = i;
            this.appId = str2;
            this.mVX = str3;
            this.cvq = str4;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.j$1 */
    static class C210001 implements C11501b {
        C210001() {
        }

        /* renamed from: E */
        public final void mo23220E(int i, long j) {
            AppMethodBeat.m2504i(111247);
            if (i == 9) {
                C20998j.m32291iO(j);
            }
            AppMethodBeat.m2505o(111247);
        }
    }

    static {
        AppMethodBeat.m2504i(111270);
        AppMethodBeat.m2505o(111270);
    }

    private C20998j() {
    }

    public static C20998j bEg() {
        AppMethodBeat.m2504i(111250);
        if (mVT == null) {
            mVT = new C20998j();
        }
        C20998j c20998j = mVT;
        AppMethodBeat.m2505o(111250);
        return c20998j;
    }

    /* renamed from: a */
    public static void m32284a(C20997a c20997a) {
        AppMethodBeat.m2504i(111251);
        synchronized (jfv) {
            try {
                jfv.add(c20997a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(111251);
            }
        }
    }

    /* renamed from: b */
    public static void m32288b(C20997a c20997a) {
        AppMethodBeat.m2504i(111252);
        synchronized (jfv) {
            try {
                jfv.remove(c20997a);
                C4990ab.m7411d("MicroMsg.GameDownloadEventBus", "removeListener, size:%d, listener:%s", Integer.valueOf(jfv.size()), c20997a);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(111252);
            }
        }
    }

    public static void bie() {
        AppMethodBeat.m2504i(111253);
        if (mVT == null) {
            mVT = new C20998j();
        }
        C33903a.m55476a(new C210001());
        C2896d.bij();
        C2886b.m5129a(mVT);
        AppMethodBeat.m2505o(111253);
    }

    public static void bgr() {
        AppMethodBeat.m2504i(111254);
        C2896d.bij();
        C2886b.m5130b(mVT);
        mVT = null;
        jfv.clear();
        mVU.clear();
        AppMethodBeat.m2505o(111254);
    }

    /* JADX WARNING: Missing block: B:4:0x001e, code skipped:
            r3 = com.tencent.p177mm.game.report.api.C45405b.eBF.mo60570eZ(r24.field_downloadId);
     */
    /* JADX WARNING: Missing block: B:5:0x0028, code skipped:
            if (r3 == null) goto L_0x01c6;
     */
    /* JADX WARNING: Missing block: B:6:0x002a, code skipped:
            r5 = r3.eBE;
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7417i("MicroMsg.GameDownloadEventBus", "downloadReportInfo.opId: %d", java.lang.Integer.valueOf(r5));
     */
    /* JADX WARNING: Missing block: B:8:0x0047, code skipped:
            if (r24.field_finishTime <= 0) goto L_0x019b;
     */
    /* JADX WARNING: Missing block: B:9:0x0049, code skipped:
            r16 = r24.field_finishTime;
     */
    /* JADX WARNING: Missing block: B:10:0x004f, code skipped:
            r2 = com.tencent.p177mm.game.report.api.C45405b.eBF;
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
            r2.mo60568a(r3, r4, r5, r6, r8, r10, r12, r13, r14, r15, r16, r18, r19, r21, r22);
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
            com.tencent.p177mm.sdk.platformtools.C4990ab.m7410d("MicroMsg.FileDownloadSP", "clearDownloadSpeedStr");
            r4 = com.tencent.p177mm.sdk.platformtools.C4996ah.getContext().getSharedPreferences("download_pref", 0);
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
            com.tencent.p177mm.game.report.api.C45405b.eBF.mo60569a(r24.field_appId, r24.field_scene, r5, r24.field_md5, r24.field_downloadUrl, "", r24.field_extInfo);
     */
    /* JADX WARNING: Missing block: B:28:0x010f, code skipped:
            r2 = r24.field_appId;
            r1 = r28;
            com.tencent.p177mm.sdk.platformtools.C5004al.m7441d(new com.tencent.p177mm.plugin.game.model.C20998j.C210012(r25));
     */
    /* JADX WARNING: Missing block: B:42:0x019b, code skipped:
            r16 = java.lang.System.currentTimeMillis();
     */
    /* JADX WARNING: Missing block: B:43:0x01a3, code skipped:
            r22 = 0;
     */
    /* JADX WARNING: Missing block: B:44:0x01a7, code skipped:
            com.tencent.p177mm.game.report.api.C45405b.eBF.mo60569a(r23.appId, r23.scene, r5, r23.cvZ, r24.field_downloadUrl, r23.mVX, r23.cvq);
     */
    /* JADX WARNING: Missing block: B:45:0x01c6, code skipped:
            r5 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: y */
    private void m32293y(long j, int i) {
        AppMethodBeat.m2504i(111255);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C20999b c20999b = (C20999b) mVU.get(hv.field_downloadUrl);
            int i2 = 0;
            switch (i) {
                case 1:
                    i2 = 1;
                    C45405b.eBF.mo60571j(hv.field_appId, 0);
                    if (c20999b != null) {
                        if (!c20999b.mVY) {
                            C45405b.eBF.mo60571j(hv.field_appId, 2);
                            break;
                        } else {
                            C45405b.eBF.mo60571j(hv.field_appId, 1);
                            break;
                        }
                    }
                    break;
                case 2:
                    i2 = 6;
                    C45405b.eBF.mo60571j(hv.field_appId, 3);
                    break;
                case 3:
                    i2 = 3;
                    C45405b.eBF.mo60571j(hv.field_appId, 6);
                    break;
                case 4:
                    i2 = 2;
                    C45405b.eBF.mo60571j(hv.field_appId, 5);
                    break;
                case 5:
                    i2 = 8;
                    C45405b.eBF.mo60571j(hv.field_appId, 7);
                    break;
                case 6:
                    break;
                case 7:
                    i2 = 7;
                    C45405b.eBF.mo60571j(hv.field_appId, 4);
                    break;
            }
        }
        AppMethodBeat.m2505o(111255);
    }

    /* renamed from: a */
    public static void m32286a(String str, String str2, int i, String str3, String str4) {
        AppMethodBeat.m2504i(111256);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111256);
            return;
        }
        C20999b c20999b = new C20999b(str2, i, str3, "", str4);
        c20999b.mVY = true;
        mVU.put(str, c20999b);
        AppMethodBeat.m2505o(111256);
    }

    /* renamed from: n */
    public static void m32292n(String str, String str2, String str3, String str4) {
        AppMethodBeat.m2504i(111257);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111257);
            return;
        }
        mVU.put(str, new C20999b(str2, 1002, str3, "", str4));
        AppMethodBeat.m2505o(111257);
    }

    /* renamed from: a */
    public static void m32287a(String str, String str2, int i, String str3, String str4, String str5) {
        AppMethodBeat.m2504i(111258);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111258);
            return;
        }
        mVU.put(str, new C20999b(str2, i, str3, str4, str5));
        AppMethodBeat.m2505o(111258);
    }

    public final void onTaskStarted(long j, String str) {
        AppMethodBeat.m2504i(111259);
        m32293y(j, 1);
        AppMethodBeat.m2505o(111259);
    }

    /* renamed from: b */
    public final void mo7665b(long j, String str, boolean z) {
        AppMethodBeat.m2504i(111260);
        C4990ab.m7417i("MicroMsg.GameDownloadEventBus", "onTaskFinished, path = %s, fileExists = %b", str, Boolean.valueOf(C5730e.m8628ct(str)));
        C42911a hv;
        if (C5046bo.isNullOrNil(str) || !C5730e.m8628ct(str)) {
            hv = C2895c.m5147hv(j);
            if (hv != null) {
                hv.field_status = 4;
                hv.field_errCode = C11498a.kJZ;
                C2895c.m5146e(hv);
            }
            mo7664b(j, C11498a.kJZ, z);
            if (hv != null) {
                C45405b.eBF.mo60571j(hv.field_appId, 9);
            }
            AppMethodBeat.m2505o(111260);
            return;
        }
        m32293y(j, 3);
        if (z) {
            hv = C2895c.m5147hv(j);
            if (hv != null) {
                String str2 = hv.field_appId;
                ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
                C28236t.m44820b(str2, 5, 0, null, null);
            }
        }
        C28176a.m44756iN(j);
        AppMethodBeat.m2505o(111260);
    }

    /* renamed from: b */
    public final void mo7664b(long j, int i, boolean z) {
        AppMethodBeat.m2504i(111261);
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null || !hv.field_downloadInWifi || C5023at.isWifi(C4996ah.getContext())) {
            m32293y(j, 5);
            C20998j.m32289e(j, i, z);
            C28176a.m44756iN(j);
            AppMethodBeat.m2505o(111261);
            return;
        }
        C4990ab.m7416i("MicroMsg.GameDownloadEventBus", "wifi pause, return");
        hv.field_status = 2;
        hv.field_errCode = 0;
        C2895c.m5146e(hv);
        C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 13, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, hv.field_errCode, hv.field_downloaderType, hv.field_channelId, (System.currentTimeMillis() - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
        AppMethodBeat.m2505o(111261);
    }

    public final void onTaskRemoved(long j) {
        AppMethodBeat.m2504i(111262);
        m32293y(j, 4);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            C20993e.m32267as(C4996ah.getContext(), hv.field_appId);
        }
        AppMethodBeat.m2505o(111262);
    }

    public final void onTaskPaused(long j) {
        AppMethodBeat.m2504i(111263);
        m32293y(j, 2);
        AppMethodBeat.m2505o(111263);
    }

    /* renamed from: gm */
    public final void mo7667gm(long j) {
        AppMethodBeat.m2504i(111264);
        m32293y(j, 6);
        AppMethodBeat.m2505o(111264);
    }

    /* renamed from: i */
    public final void mo7669i(long j, String str) {
        AppMethodBeat.m2504i(111265);
        m32293y(j, 7);
        AppMethodBeat.m2505o(111265);
    }

    /* renamed from: gn */
    public final void mo7668gn(long j) {
    }

    /* renamed from: e */
    private static void m32289e(long j, int i, boolean z) {
        AppMethodBeat.m2504i(111266);
        C42911a hv = C2895c.m5147hv(j);
        if (hv != null) {
            String str = null;
            if (i == C11498a.kJW) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("ChannelId", hv.field_channelId);
                    jSONObject.put("DownloadSize", hv.field_downloadedSize);
                    str = C34276a.m56208kY(jSONObject.toString());
                    C4990ab.m7410d("MicroMsg.GameDownloadEventBus", "extInfo = " + jSONObject.toString());
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.GameDownloadEventBus", "reportDownloadFailed, e = " + e.getMessage());
                }
            }
            C20998j.m32285a(hv.field_appId, i, z, str);
        }
        AppMethodBeat.m2505o(111266);
    }

    /* renamed from: a */
    public static void m32285a(String str, int i, boolean z, String str2) {
        AppMethodBeat.m2504i(111267);
        if (i == 710 || i == 711) {
            i = C11498a.kJY;
        }
        C4990ab.m7417i("MicroMsg.GameDownloadEventBus", "appid = %s, errCode = %d", str, Integer.valueOf(i));
        if (z) {
            ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
            C28236t.m44820b(str, 4, i, null, str2);
            AppMethodBeat.m2505o(111267);
            return;
        }
        ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
        C28236t.m44820b(str, 2, i, null, str2);
        AppMethodBeat.m2505o(111267);
    }

    /* renamed from: ex */
    public static void m32290ex(String str, String str2) {
        AppMethodBeat.m2504i(111268);
        ((C43156b) C1720g.m3528K(C43156b.class)).bCW();
        C28236t.m44820b(str, 6, 0, null, str2);
        AppMethodBeat.m2505o(111268);
    }

    /* renamed from: iO */
    static /* synthetic */ void m32291iO(final long j) {
        AppMethodBeat.m2504i(111269);
        C7305d.post(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(111249);
                C42911a hv = C2895c.m5147hv(j);
                if (hv == null) {
                    C4990ab.m7412e("MicroMsg.GameDownloadEventBus", "fInfo is null");
                    AppMethodBeat.m2505o(111249);
                    return;
                }
                if (hv.field_status == 3) {
                    int i;
                    if (C5730e.m8628ct(hv.field_filePath)) {
                        C4990ab.m7417i("MicroMsg.GameDownloadEventBus", "onInstallFinish, delete file: %s", hv.field_filePath);
                        C5730e.deleteFile(hv.field_filePath);
                    }
                    C2895c.m5148hw(j);
                    C45405b c45405b = C45405b.eBF;
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
                    c45405b.mo60568a(str, i2, 5, j, j2, j3, str2, 0, i3, str3, j4, i4, j5, str4, i);
                    C45405b.eBF.mo60571j(hv.field_appId, 8);
                    C20999b c20999b = (C20999b) C20998j.mVU.get(hv.field_downloadUrl);
                    if (c20999b == null) {
                        C45405b.eBF.mo60569a(hv.field_appId, hv.field_scene, 5, hv.field_md5, hv.field_downloadUrl, "", hv.field_extInfo);
                        AppMethodBeat.m2505o(111249);
                        return;
                    }
                    long j6;
                    C45405b.eBF.mo60569a(c20999b.appId, c20999b.scene, 5, c20999b.cvZ, hv.field_downloadUrl, c20999b.mVX, c20999b.cvq);
                    String str5 = hv.field_packageName;
                    SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("install_begin_time", 0);
                    if (sharedPreferences != null) {
                        j6 = sharedPreferences.getLong(str5, 0);
                    } else {
                        j6 = 0;
                    }
                    if (System.currentTimeMillis() - j6 <= 600000) {
                        C45405b.eBF.mo60568a(hv.field_appId, hv.field_scene, 17, hv.field_startSize, hv.field_downloadedSize - hv.field_startSize, hv.field_totalSize, hv.field_downloadUrl, 0, hv.field_downloaderType, hv.field_channelId, (hv.field_finishTime - hv.field_startTime) / 1000, hv.field_startState, hv.field_downloadId, hv.field_extInfo, hv.field_reserveInWifi ? 1 : 0);
                    }
                }
                AppMethodBeat.m2505o(111249);
            }
        }, "onInstallFinish");
        AppMethodBeat.m2505o(111269);
    }
}
