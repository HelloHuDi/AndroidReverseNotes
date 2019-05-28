package com.tencent.p177mm.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Intent;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.p248j.C1760a;
import com.tencent.p177mm.loader.p248j.C1761b;
import com.tencent.p177mm.loader.p248j.C1762c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5013ao;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5009a;
import com.tencent.p177mm.sdk.platformtools.C5013ao.C5012d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.service.C5091c;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.tencent.mm.app.h */
public final class C1256h {

    /* renamed from: com.tencent.mm.app.h$2 */
    static class C12582 implements C5009a {
        C12582() {
        }

        /* renamed from: Bl */
        public final void mo4542Bl() {
            String str = C1760a.eSh;
        }
    }

    /* renamed from: a */
    public static String m2696a(final Application application, final String str) {
        AppMethodBeat.m2504i(115032);
        if (!"com.tencent.mm:cuploader".equals(str)) {
            C5013ao.m7458a(new C5012d() {
                /* renamed from: a */
                public final void mo4541a(C5013ao c5013ao, String str, Throwable th) {
                    AppMethodBeat.m2504i(115031);
                    C4990ab.m7412e("MicroMsg.FirstCrashCatcher", "reportException()");
                    Application application = application;
                    String str2 = str;
                    C4990ab.m7412e("MicroMsg.FirstCrashCatcher", "reportThrowable:".concat(String.valueOf(str)));
                    try {
                        Object format;
                        StringBuilder stringBuilder = new StringBuilder(2560);
                        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
                        stringBuilderPrinter.println("#client.version=" + C1760a.CLIENT_VERSION);
                        if (C5058f.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.revision=123321123");
                        } else {
                            stringBuilderPrinter.println("#accinfo.revision=" + C1760a.m3621Uk());
                        }
                        Object T = C1762c.eSp.mo5292T("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        if (T == null || T.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            T = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
                        }
                        stringBuilderPrinter.println("#accinfo.uin=".concat(String.valueOf(T)));
                        StringBuilder append = new StringBuilder("#accinfo.runtime=").append(C5046bo.anU() - C1244b.cdW).append("(");
                        if (str2 == null) {
                            str2 = "";
                        }
                        stringBuilderPrinter.println(append.append(str2).append(") by cup").toString());
                        if (C5058f.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.build=99/88/2077 66:55 PM:amm-dev");
                        } else {
                            stringBuilderPrinter.println("#accinfo.build=" + C1760a.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + C1760a.HOSTNAME + ":0");
                        }
                        String str3 = "";
                        try {
                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                            StatFs statFs2 = new StatFs(C1761b.eSl);
                            int memoryClass = ((ActivityManager) application.getSystemService("activity")).getMemoryClass();
                            int largeMemoryClass = ((ActivityManager) application.getSystemService("activity")).getLargeMemoryClass();
                            format = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), C1761b.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
                        } catch (Exception e) {
                            str2 = str3;
                        }
                        C1269u.m2728f(th);
                        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format)));
                        Date date = new Date();
                        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
                        stringBuilderPrinter.println("#crashContent=");
                        if (C1255f.m2693aV(C4996ah.getContext()) == 1) {
                            str = str.substring(0, C1255f.m2694aW(C4996ah.getContext()));
                        }
                        C1255f.m2695e(C4996ah.getContext(), C4996ah.getProcessName(), "first");
                        stringBuilderPrinter.println(str);
                        C4990ab.m7412e("MicroMsg.FirstCrashCatcher", "cpu catch crash:".concat(String.valueOf(str)));
                        Intent intent = new Intent();
                        intent.setAction("INTENT_ACTION_UNCATCH");
                        intent.putExtra("INTENT_EXTRA_USER_NAME", C1762c.eSp.mo5292T("login_user_name", "never_login_crash"));
                        intent.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                        intent.putExtra("INTENT_EXTRA_DATA_PATH", C1761b.eSj + "crash/");
                        intent.putExtra("INTENT_EXTRA_SDCARD_PATH", C1761b.eSo);
                        intent.putExtra("INTENT_EXTRA_UIN", C1762c.eSp.mo5292T("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                        intent.putExtra("INTENT_EXTRA_CLIENT_VERSION", C1760a.CLIENT_VERSION);
                        intent.putExtra("INTENT_EXTRA_DEVICE_TYPE", C1760a.eSg);
                        intent.putExtra("INTENT_EXTRA_TAG", "exception");
                        String str4 = "INTENT_EXTRA_HOST";
                        intent.putExtra(str4, "http://" + application.getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com"));
                        intent.setClassName(application, application.getPackageName() + ".crash.CrashUploaderService");
                        C5091c.m7718a(intent, "cuploader", true, new Intent().setClassName(application, application.getPackageName() + ".crash.CuploaderProcessServicer"));
                        AppMethodBeat.m2505o(115031);
                    } catch (Exception e2) {
                        AppMethodBeat.m2505o(115031);
                    }
                }
            });
            C5013ao.m7456a(new C12582());
        }
        AppMethodBeat.m2505o(115032);
        return str;
    }
}
