package com.tencent.p177mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5059g;
import com.tencent.xweb.C46838x;
import com.tencent.xweb.WebView;
import com.tencent.xweb.p685x5.sdk.C24544d;
import com.tencent.xweb.p685x5.sdk.C24548f;
import com.tencent.xweb.util.C6036c;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.pluginsdk.model.v */
public final class C46499v {
    private static final Map<String, Object> vbK = new HashMap();

    /* renamed from: com.tencent.mm.pluginsdk.model.v$a */
    public static final class C30086a {
        private static boolean vbL = false;

        /* renamed from: com.tencent.mm.pluginsdk.model.v$a$1 */
        static class C232531 implements C6036c {
            C232531() {
            }

            /* renamed from: i */
            public final void mo4779i(String str, String str2) {
                AppMethodBeat.m2504i(114660);
                C4990ab.m7416i(str, str2);
                AppMethodBeat.m2505o(114660);
            }

            /* renamed from: e */
            public final void mo4778e(String str, String str2) {
                AppMethodBeat.m2504i(114661);
                C4990ab.m7412e(str, str2);
                AppMethodBeat.m2505o(114661);
            }

            /* renamed from: w */
            public final void mo4781w(String str, String str2) {
                AppMethodBeat.m2504i(114662);
                C4990ab.m7420w(str, str2);
                AppMethodBeat.m2505o(114662);
            }

            /* renamed from: d */
            public final void mo4777d(String str, String str2) {
                AppMethodBeat.m2504i(114663);
                C4990ab.m7410d(str, str2);
                AppMethodBeat.m2505o(114663);
            }

            /* renamed from: v */
            public final void mo4780v(String str, String str2) {
                AppMethodBeat.m2504i(114664);
                C4990ab.m7418v(str, str2);
                AppMethodBeat.m2505o(114664);
            }
        }

        static {
            AppMethodBeat.m2504i(114673);
            C4990ab.m7416i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
            C46838x.m89072a(C4996ah.getContext(), new C232531());
            AppMethodBeat.m2505o(114673);
        }

        /* renamed from: fH */
        public static void m47650fH(final Context context) {
            AppMethodBeat.m2504i(114666);
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.m2504i(114665);
                    Looper.myQueue().removeIdleHandler(this);
                    C30086a.m47651fI(context);
                    AppMethodBeat.m2505o(114665);
                    return false;
                }
            });
            AppMethodBeat.m2505o(114666);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        /* renamed from: fI */
        public static void m47651fI(Context context) {
            long j;
            long currentTimeMillis;
            int i;
            AppMethodBeat.m2504i(114667);
            C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("last_check_xwalk", 0);
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j >= 1800000) {
                    Editor edit = sharedPreferences.edit();
                    edit.putLong("last_check_xwalk", currentTimeMillis);
                    edit.apply();
                    C30086a.m47649Kv(4);
                }
            }
            C4990ab.m7417i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)));
            if (sharedPreferences.getBoolean("tbs_download_oversea", false)) {
                i = 2;
            } else if (C5059g.dnY()) {
                C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
                AppMethodBeat.m2505o(114667);
                return;
            } else {
                i = 1;
            }
            if ("1".equals(sharedPreferences.getString("tbs_download", null))) {
                C24544d.setUploadCode(C4996ah.getContext(), 130);
                C4990ab.m7417i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", r5, Boolean.valueOf(C5023at.isWifi(context)));
                if (C5023at.isWifi(context)) {
                    boolean z;
                    Intent intent;
                    if (sharedPreferences == null) {
                        C4990ab.m7412e("MicroMsg.TBSDownloadChecker", "sp is null");
                    } else {
                        j = sharedPreferences.getLong("last_check_ts", 0);
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j > 7200000) {
                            Editor edit2 = sharedPreferences.edit();
                            edit2.putLong("last_check_ts", currentTimeMillis);
                            edit2.apply();
                            z = true;
                            if (!z) {
                                C4990ab.m7417i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getInstalledTbsCoreVersion(context)));
                                if (WebView.getInstalledTbsCoreVersion(context) > 0) {
                                    C24544d.setUploadCode(C4996ah.getContext(), 132);
                                    AppMethodBeat.m2505o(114667);
                                    return;
                                }
                            }
                            intent = new Intent();
                            intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                            intent.putExtra("intent_extra_download_type", i);
                            C25985d.m41477j(intent, "sandbox");
                            C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                            AppMethodBeat.m2505o(114667);
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    intent = new Intent();
                    intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                    intent.putExtra("intent_extra_download_type", i);
                    C25985d.m41477j(intent, "sandbox");
                    C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                    AppMethodBeat.m2505o(114667);
                    return;
                }
                C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
                C24544d.setUploadCode(C4996ah.getContext(), 131);
                AppMethodBeat.m2505o(114667);
                return;
            }
            C4990ab.m7417i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", sharedPreferences.getString("tbs_download", null));
            AppMethodBeat.m2505o(114667);
        }

        /* renamed from: Kv */
        public static void m47649Kv(int i) {
            AppMethodBeat.m2504i(114668);
            Intent intent = new Intent();
            intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", i);
            C25985d.m41477j(intent, "sandbox");
            C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
            AppMethodBeat.m2505o(114668);
        }

        public static void dho() {
            AppMethodBeat.m2504i(114669);
            if (C5059g.dnY()) {
                C4990ab.m7410d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
                AppMethodBeat.m2505o(114669);
                return;
            }
            if (C24548f.m38206jA(C4996ah.getContext()) && WebView.getInstalledTbsCoreVersion(C4996ah.getContext()) <= 0) {
                Intent intent = new Intent();
                intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", 1);
                C25985d.m41477j(intent, "sandbox");
                C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            }
            AppMethodBeat.m2505o(114669);
        }

        public static boolean dhp() {
            AppMethodBeat.m2504i(114670);
            boolean isDownloading = C24548f.isDownloading();
            boolean tBSInstalling = C24544d.getTBSInstalling();
            boolean z = vbL;
            if (isDownloading || tBSInstalling || z) {
                AppMethodBeat.m2505o(114670);
                return true;
            }
            AppMethodBeat.m2505o(114670);
            return false;
        }

        /* renamed from: ov */
        public static void m47652ov(boolean z) {
            vbL = z;
        }

        public static int dhq() {
            AppMethodBeat.m2504i(114671);
            if (C1443d.m3068iW(19) || C1443d.m3067fP(16)) {
                AppMethodBeat.m2505o(114671);
                return 1;
            } else if (WebView.getInstalledTbsCoreVersion(C4996ah.getContext()) > 0) {
                AppMethodBeat.m2505o(114671);
                return 4;
            } else if (C24548f.isDownloading()) {
                AppMethodBeat.m2505o(114671);
                return 2;
            } else if (C24544d.getTBSInstalling()) {
                AppMethodBeat.m2505o(114671);
                return 3;
            } else {
                C4990ab.m7417i("MicroMsg.TBSDownloadChecker", "oversea = %b", Boolean.valueOf(C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)));
                if (C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)) {
                    AppMethodBeat.m2505o(114671);
                    return 2;
                }
                C4990ab.m7412e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
                AppMethodBeat.m2505o(114671);
                return 0;
            }
        }

        public static void dhr() {
            AppMethodBeat.m2504i(114672);
            Intent intent = new Intent();
            intent.setClassName(C4996ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 2);
            intent.putExtra("intent_extra_download_ignore_network_type", true);
            C25985d.m41477j(intent, "sandbox");
            C4990ab.m7416i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            SharedPreferences sharedPreferences = C4996ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
            }
            AppMethodBeat.m2505o(114672);
        }
    }

    static {
        AppMethodBeat.m2504i(114675);
        AppMethodBeat.m2505o(114675);
    }

    /* renamed from: r */
    public static void m87769r(String str, Object obj) {
        AppMethodBeat.m2504i(114674);
        vbK.put(str, obj);
        C24544d.initTbsSettings(vbK);
        AppMethodBeat.m2505o(114674);
    }
}
