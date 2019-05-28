package com.tencent.mm.app;

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
import com.tencent.mm.loader.j.a;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ao.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class h {
    public static String a(final Application application, final String str) {
        AppMethodBeat.i(115032);
        if (!"com.tencent.mm:cuploader".equals(str)) {
            ao.a(new d() {
                public final void a(ao aoVar, String str, Throwable th) {
                    AppMethodBeat.i(115031);
                    ab.e("MicroMsg.FirstCrashCatcher", "reportException()");
                    Application application = application;
                    String str2 = str;
                    ab.e("MicroMsg.FirstCrashCatcher", "reportThrowable:".concat(String.valueOf(str)));
                    try {
                        Object format;
                        StringBuilder stringBuilder = new StringBuilder(2560);
                        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(stringBuilder);
                        stringBuilderPrinter.println("#client.version=" + a.CLIENT_VERSION);
                        if (f.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.revision=123321123");
                        } else {
                            stringBuilderPrinter.println("#accinfo.revision=" + a.Uk());
                        }
                        Object T = c.eSp.T("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        if (T == null || T.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            T = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
                        }
                        stringBuilderPrinter.println("#accinfo.uin=".concat(String.valueOf(T)));
                        StringBuilder append = new StringBuilder("#accinfo.runtime=").append(bo.anU() - b.cdW).append("(");
                        if (str2 == null) {
                            str2 = "";
                        }
                        stringBuilderPrinter.println(append.append(str2).append(") by cup").toString());
                        if (f.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.build=99/88/2077 66:55 PM:amm-dev");
                        } else {
                            stringBuilderPrinter.println("#accinfo.build=" + a.TIME + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + a.HOSTNAME + ":0");
                        }
                        String str3 = "";
                        try {
                            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
                            StatFs statFs2 = new StatFs(b.eSl);
                            int memoryClass = ((ActivityManager) application.getSystemService("activity")).getMemoryClass();
                            int largeMemoryClass = ((ActivityManager) application.getSystemService("activity")).getLargeMemoryClass();
                            format = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", new Object[]{Integer.valueOf(memoryClass), Integer.valueOf(largeMemoryClass), r5.getAbsolutePath(), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), b.eSl, Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks())});
                        } catch (Exception e) {
                            str2 = str3;
                        }
                        u.f(th);
                        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(format)));
                        Date date = new Date();
                        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(date));
                        stringBuilderPrinter.println("#crashContent=");
                        if (f.aV(ah.getContext()) == 1) {
                            str = str.substring(0, f.aW(ah.getContext()));
                        }
                        f.e(ah.getContext(), ah.getProcessName(), "first");
                        stringBuilderPrinter.println(str);
                        ab.e("MicroMsg.FirstCrashCatcher", "cpu catch crash:".concat(String.valueOf(str)));
                        Intent intent = new Intent();
                        intent.setAction("INTENT_ACTION_UNCATCH");
                        intent.putExtra("INTENT_EXTRA_USER_NAME", c.eSp.T("login_user_name", "never_login_crash"));
                        intent.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(stringBuilder.toString().getBytes(), 2));
                        intent.putExtra("INTENT_EXTRA_DATA_PATH", b.eSj + "crash/");
                        intent.putExtra("INTENT_EXTRA_SDCARD_PATH", b.eSo);
                        intent.putExtra("INTENT_EXTRA_UIN", c.eSp.T("last_login_uin", AppEventsConstants.EVENT_PARAM_VALUE_NO));
                        intent.putExtra("INTENT_EXTRA_CLIENT_VERSION", a.CLIENT_VERSION);
                        intent.putExtra("INTENT_EXTRA_DEVICE_TYPE", a.eSg);
                        intent.putExtra("INTENT_EXTRA_TAG", "exception");
                        String str4 = "INTENT_EXTRA_HOST";
                        intent.putExtra(str4, "http://" + application.getSharedPreferences("system_config_prefs", 0).getString("support.weixin.qq.com", "support.weixin.qq.com"));
                        intent.setClassName(application, application.getPackageName() + ".crash.CrashUploaderService");
                        com.tencent.mm.service.c.a(intent, "cuploader", true, new Intent().setClassName(application, application.getPackageName() + ".crash.CuploaderProcessServicer"));
                        AppMethodBeat.o(115031);
                    } catch (Exception e2) {
                        AppMethodBeat.o(115031);
                    }
                }
            });
            ao.a(new ao.a() {
                public final void Bl() {
                    String str = a.eSh;
                }
            });
        }
        AppMethodBeat.o(115032);
        return str;
    }
}
