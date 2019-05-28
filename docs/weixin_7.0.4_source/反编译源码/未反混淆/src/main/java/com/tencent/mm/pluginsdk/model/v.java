package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.g;
import com.tencent.xweb.WebView;
import com.tencent.xweb.util.c;
import com.tencent.xweb.x;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;
import java.util.HashMap;
import java.util.Map;

public final class v {
    private static final Map<String, Object> vbK = new HashMap();

    public static final class a {
        private static boolean vbL = false;

        static {
            AppMethodBeat.i(114673);
            ab.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
            x.a(ah.getContext(), new c() {
                public final void i(String str, String str2) {
                    AppMethodBeat.i(114660);
                    ab.i(str, str2);
                    AppMethodBeat.o(114660);
                }

                public final void e(String str, String str2) {
                    AppMethodBeat.i(114661);
                    ab.e(str, str2);
                    AppMethodBeat.o(114661);
                }

                public final void w(String str, String str2) {
                    AppMethodBeat.i(114662);
                    ab.w(str, str2);
                    AppMethodBeat.o(114662);
                }

                public final void d(String str, String str2) {
                    AppMethodBeat.i(114663);
                    ab.d(str, str2);
                    AppMethodBeat.o(114663);
                }

                public final void v(String str, String str2) {
                    AppMethodBeat.i(114664);
                    ab.v(str, str2);
                    AppMethodBeat.o(114664);
                }
            });
            AppMethodBeat.o(114673);
        }

        public static void fH(final Context context) {
            AppMethodBeat.i(114666);
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(114665);
                    Looper.myQueue().removeIdleHandler(this);
                    a.fI(context);
                    AppMethodBeat.o(114665);
                    return false;
                }
            });
            AppMethodBeat.o(114666);
        }

        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d8  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void fI(Context context) {
            long j;
            long currentTimeMillis;
            int i;
            AppMethodBeat.i(114667);
            ab.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                j = sharedPreferences.getLong("last_check_xwalk", 0);
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j >= 1800000) {
                    Editor edit = sharedPreferences.edit();
                    edit.putLong("last_check_xwalk", currentTimeMillis);
                    edit.apply();
                    Kv(4);
                }
            }
            ab.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)));
            if (sharedPreferences.getBoolean("tbs_download_oversea", false)) {
                i = 2;
            } else if (g.dnY()) {
                ab.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
                AppMethodBeat.o(114667);
                return;
            } else {
                i = 1;
            }
            if ("1".equals(sharedPreferences.getString("tbs_download", null))) {
                d.setUploadCode(ah.getContext(), 130);
                ab.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", r5, Boolean.valueOf(at.isWifi(context)));
                if (at.isWifi(context)) {
                    boolean z;
                    Intent intent;
                    if (sharedPreferences == null) {
                        ab.e("MicroMsg.TBSDownloadChecker", "sp is null");
                    } else {
                        j = sharedPreferences.getLong("last_check_ts", 0);
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j > 7200000) {
                            Editor edit2 = sharedPreferences.edit();
                            edit2.putLong("last_check_ts", currentTimeMillis);
                            edit2.apply();
                            z = true;
                            if (!z) {
                                ab.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getInstalledTbsCoreVersion(context)));
                                if (WebView.getInstalledTbsCoreVersion(context) > 0) {
                                    d.setUploadCode(ah.getContext(), 132);
                                    AppMethodBeat.o(114667);
                                    return;
                                }
                            }
                            intent = new Intent();
                            intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                            intent.putExtra("intent_extra_download_type", i);
                            com.tencent.mm.bp.d.j(intent, "sandbox");
                            ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                            AppMethodBeat.o(114667);
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                    }
                    intent = new Intent();
                    intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                    intent.putExtra("intent_extra_download_type", i);
                    com.tencent.mm.bp.d.j(intent, "sandbox");
                    ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                    AppMethodBeat.o(114667);
                    return;
                }
                ab.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
                d.setUploadCode(ah.getContext(), 131);
                AppMethodBeat.o(114667);
                return;
            }
            ab.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", sharedPreferences.getString("tbs_download", null));
            AppMethodBeat.o(114667);
        }

        public static void Kv(int i) {
            AppMethodBeat.i(114668);
            Intent intent = new Intent();
            intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", i);
            com.tencent.mm.bp.d.j(intent, "sandbox");
            ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk now");
            AppMethodBeat.o(114668);
        }

        public static void dho() {
            AppMethodBeat.i(114669);
            if (g.dnY()) {
                ab.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
                AppMethodBeat.o(114669);
                return;
            }
            if (f.jA(ah.getContext()) && WebView.getInstalledTbsCoreVersion(ah.getContext()) <= 0) {
                Intent intent = new Intent();
                intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", 1);
                com.tencent.mm.bp.d.j(intent, "sandbox");
                ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            }
            AppMethodBeat.o(114669);
        }

        public static boolean dhp() {
            AppMethodBeat.i(114670);
            boolean isDownloading = f.isDownloading();
            boolean tBSInstalling = d.getTBSInstalling();
            boolean z = vbL;
            if (isDownloading || tBSInstalling || z) {
                AppMethodBeat.o(114670);
                return true;
            }
            AppMethodBeat.o(114670);
            return false;
        }

        public static void ov(boolean z) {
            vbL = z;
        }

        public static int dhq() {
            AppMethodBeat.i(114671);
            if (com.tencent.mm.compatible.util.d.iW(19) || com.tencent.mm.compatible.util.d.fP(16)) {
                AppMethodBeat.o(114671);
                return 1;
            } else if (WebView.getInstalledTbsCoreVersion(ah.getContext()) > 0) {
                AppMethodBeat.o(114671);
                return 4;
            } else if (f.isDownloading()) {
                AppMethodBeat.o(114671);
                return 2;
            } else if (d.getTBSInstalling()) {
                AppMethodBeat.o(114671);
                return 3;
            } else {
                ab.i("MicroMsg.TBSDownloadChecker", "oversea = %b", Boolean.valueOf(ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)));
                if (ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)) {
                    AppMethodBeat.o(114671);
                    return 2;
                }
                ab.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
                AppMethodBeat.o(114671);
                return 0;
            }
        }

        public static void dhr() {
            AppMethodBeat.i(114672);
            Intent intent = new Intent();
            intent.setClassName(ah.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 2);
            intent.putExtra("intent_extra_download_ignore_network_type", true);
            com.tencent.mm.bp.d.j(intent, "sandbox");
            ab.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            SharedPreferences sharedPreferences = ah.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
            }
            AppMethodBeat.o(114672);
        }
    }

    static {
        AppMethodBeat.i(114675);
        AppMethodBeat.o(114675);
    }

    public static void r(String str, Object obj) {
        AppMethodBeat.i(114674);
        vbK.put(str, obj);
        d.initTbsSettings(vbK);
        AppMethodBeat.o(114674);
    }
}
