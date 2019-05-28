package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.C24272a;
import com.tencent.smtt.utils.C30950k;
import com.tencent.smtt.utils.C36443b;
import com.tencent.smtt.utils.C36446v;
import com.tencent.smtt.utils.C44463n;
import com.tencent.smtt.utils.C44464o;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";
    /* renamed from: a */
    static boolean f4486a;
    /* renamed from: b */
    private static String f4487b;
    /* renamed from: c */
    private static Context f4488c;
    /* renamed from: d */
    private static Handler f4489d;
    /* renamed from: e */
    private static String f4490e;
    /* renamed from: f */
    private static Object f4491f = new byte[0];
    /* renamed from: g */
    private static C36431ag f4492g;
    /* renamed from: h */
    private static HandlerThread f4493h;
    /* renamed from: i */
    private static boolean f4494i = false;
    /* renamed from: j */
    private static boolean f4495j = false;
    /* renamed from: k */
    private static boolean f4496k = false;
    /* renamed from: l */
    private static long f4497l = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    /* renamed from: a */
    protected static File m37392a(int i) {
        AppMethodBeat.m2504i(64380);
        File file = null;
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            if (!str.equals(f4488c.getApplicationInfo().packageName)) {
                file = new File(C30950k.m49547a(f4488c, str, 4, false), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    TbsLog.m80434i(LOGTAG, "can not find local backup core file");
                } else if (C24272a.m37432a(f4488c, file) == i) {
                    TbsLog.m80434i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.m80434i(LOGTAG, "version is not match");
                }
            }
        }
        AppMethodBeat.m2505o(64380);
        return file;
    }

    /* renamed from: a */
    static String m37393a(Context context) {
        AppMethodBeat.m2504i(64377);
        String str;
        if (TextUtils.isEmpty(f4487b)) {
            Locale locale = Locale.getDefault();
            StringBuffer stringBuffer = new StringBuffer();
            String str2 = VERSION.RELEASE;
            try {
                str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
            } catch (Exception e) {
                str = str2;
            }
            if (str == null) {
                stringBuffer.append("1.0");
            } else if (str.length() > 0) {
                stringBuffer.append(str);
            } else {
                stringBuffer.append("1.0");
            }
            stringBuffer.append("; ");
            str = locale.getLanguage();
            if (str != null) {
                stringBuffer.append(str.toLowerCase());
                str = locale.getCountry();
                if (str != null) {
                    stringBuffer.append("-");
                    stringBuffer.append(str.toLowerCase());
                }
            } else {
                stringBuffer.append("en");
            }
            if ("REL".equals(VERSION.CODENAME)) {
                str2 = Build.MODEL;
                try {
                    str = new String(str2.getBytes("UTF-8"), "ISO8859-1");
                } catch (Exception e2) {
                    str = str2;
                }
                if (str == null) {
                    stringBuffer.append("; ");
                } else if (str.length() > 0) {
                    stringBuffer.append("; ");
                    stringBuffer.append(str);
                }
            }
            str = (Build.ID == null ? "" : Build.ID).replaceAll("[一-龥]", "");
            if (str == null) {
                stringBuffer.append(" Build/");
                stringBuffer.append("00");
            } else if (str.length() > 0) {
                stringBuffer.append(" Build/");
                stringBuffer.append(str);
            }
            str = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", new Object[]{stringBuffer});
            f4487b = str;
            AppMethodBeat.m2505o(64377);
            return str;
        }
        str = f4487b;
        AppMethodBeat.m2505o(64377);
        return str;
    }

    /* renamed from: a */
    private static String m37394a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    private static void m37395a(JSONArray jSONArray) {
        AppMethodBeat.m2504i(64367);
        for (String str : m37412e()) {
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(f4488c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f4488c, str, true);
                if (packageContext == null || C5813an.m8800a().mo12171f(packageContext)) {
                    boolean z;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (jSONArray.optInt(i) == sharedTbsCoreVersion) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    TbsLog.m80432e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                }
            }
        }
        AppMethodBeat.m2505o(64367);
    }

    /* renamed from: a */
    private static void m37396a(boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        int i = 0;
        AppMethodBeat.m2504i(64364);
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.queryConfig]");
        f4489d.removeMessages(100);
        Message obtain = Message.obtain(f4489d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        if (z) {
            i = 1;
        }
        obtain.arg1 = i;
        obtain.sendToTarget();
        AppMethodBeat.m2505o(64364);
    }

    /* renamed from: a */
    private static boolean m37397a(Context context, boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        Matcher matcher = null;
        AppMethodBeat.m2504i(64351);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (VERSION.SDK_INT < 8) {
            instance.setDownloadInterruptCode(ZipJNI.UNZ_PARAMERROR);
            AppMethodBeat.m2505o(64351);
            return false;
        }
        if (!instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.m80434i(LOGTAG, "needDownload-oversea is true, but not WX");
                z = false;
            }
            instance.f1368a.put(TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
            instance.commit();
            f4495j = z;
            TbsLog.m80434i(LOGTAG, "needDownload-first-called--isoversea = ".concat(String.valueOf(z)));
        }
        if (!getOverSea(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
            String string = instance.mPreferences.getString(TbsConfigKey.KEY_DEVICE_CPUABI, matcher);
            f4490e = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(f4490e);
                } catch (Exception e) {
                }
                if (matcher != null && matcher.find()) {
                    if (tbsDownloaderCallback != null) {
                        tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                    }
                    instance.setDownloadInterruptCode(ZipJNI.UNZ_INTERNALERROR);
                    AppMethodBeat.m2505o(64351);
                    return false;
                }
            }
            AppMethodBeat.m2505o(64351);
            return true;
        }
        TbsLog.m80434i(LOGTAG, "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
        if (tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        instance.setDownloadInterruptCode(ZipJNI.UNZ_BADZIPFILE);
        AppMethodBeat.m2505o(64351);
        return false;
    }

    /* renamed from: a */
    private static boolean m37398a(Context context, boolean z, boolean z2) {
        boolean z3;
        TbsLogInfo tbsLogInfo;
        AppMethodBeat.m2504i(64350);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        String str = null;
        if (!z) {
            String string = instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i = instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null);
            String a = C36443b.m60177a(f4488c);
            int b = C36443b.m60185b(f4488c);
            String a2 = C36443b.m60179a(f4488c, TBS_METADATA);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + a + " oldAppVersionName=" + string + " appVersionCode=" + b + " oldAppVersionCode=" + i + " appMetadata=" + a2 + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j = instance.mPreferences.getLong(TbsConfigKey.KEY_LAST_CHECK, 0);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=".concat(String.valueOf(contains)));
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long j2 = instance.mPreferences.getLong(TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0);
            long j3 = instance.mPreferences.getLong(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0);
            long retryInterval = instance.getRetryInterval();
            TbsLog.m80434i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(f4488c).getEmergentCoreVersion();
            int i2 = TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (currentTimeMillis - j <= 1000 * retryInterval && ((emergentCoreVersion <= C5813an.m8800a().mo12175j(f4488c) || emergentCoreVersion <= i2) && (!TbsShareManager.isThirdPartyApp(f4488c) || j2 <= 0 || currentTimeMillis - j2 <= retryInterval * 1000 || j3 >= 11))) {
                if (TbsShareManager.isThirdPartyApp(f4488c) && TbsShareManager.findCoreForThirdPartyApp(f4488c) == 0 && !m37411d()) {
                    C5813an.m8800a().mo12168d(f4488c);
                    z3 = true;
                    tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
                    tbsLogInfo.setErrorCode(-119);
                    tbsLogInfo.setFailDetail(str);
                    TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    AppMethodBeat.m2505o(64350);
                    return z3;
                }
                String str2;
                if (a == null || b == 0 || a2 == null) {
                    if (TbsShareManager.isThirdPartyApp(f4488c)) {
                        str2 = "timeNow - timeLastCheck is " + (currentTimeMillis - j) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(f4488c) + " sendRequestWithSameHostCoreVersion() is " + m37411d() + " appVersionName is " + a + " appVersionCode is " + b + " appMetadata is " + a2 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                    }
                    str2 = null;
                } else {
                    if (!(a.equals(string) && b == i && a2.equals(string2))) {
                        z3 = true;
                        if (!z3 && TbsShareManager.isThirdPartyApp(f4488c)) {
                            tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
                            tbsLogInfo.setErrorCode(-119);
                            tbsLogInfo.setFailDetail(str);
                            TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        }
                        AppMethodBeat.m2505o(64350);
                        return z3;
                    }
                    str2 = null;
                }
                str = str2;
                z3 = false;
                tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
                tbsLogInfo.setErrorCode(-119);
                tbsLogInfo.setFailDetail(str);
                TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                AppMethodBeat.m2505o(64350);
                return z3;
            }
        }
        z3 = true;
        tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
        tbsLogInfo.setErrorCode(-119);
        tbsLogInfo.setFailDetail(str);
        TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
        AppMethodBeat.m2505o(64350);
        return z3;
    }

    /* JADX WARNING: Missing block: B:127:0x0341, code skipped:
            if (r2 > 0) goto L_0x0343;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    /* renamed from: a */
    private static boolean m37399a(String str, int i, boolean z, boolean z2) {
        AppMethodBeat.m2504i(64375);
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] response=".concat(String.valueOf(str)));
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(f4488c);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                instance.setDownloadInterruptCode(-108);
            } else {
                instance.setDownloadInterruptCode(-208);
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            AppMethodBeat.m2505o(64375);
            return false;
        }
        JSONObject jSONObject = new JSONObject(str);
        int i2 = jSONObject.getInt("RET");
        if (i2 != 0) {
            if (z) {
                instance.setDownloadInterruptCode(-109);
            } else {
                instance.setDownloadInterruptCode(-209);
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=".concat(String.valueOf(i2)));
            AppMethodBeat.m2505o(64375);
            return false;
        }
        int optInt;
        boolean z3;
        boolean z4;
        int i3 = jSONObject.getInt("RESPONSECODE");
        String string = jSONObject.getString("DOWNLOADURL");
        String optString = jSONObject.optString("URLLIST", "");
        int i4 = jSONObject.getInt("TBSAPKSERVERVERSION");
        int i5 = jSONObject.getInt("DOWNLOADMAXFLOW");
        int i6 = jSONObject.getInt("DOWNLOAD_MIN_FREE_SPACE");
        int i7 = jSONObject.getInt("DOWNLOAD_SUCCESS_MAX_RETRYTIMES");
        int i8 = jSONObject.getInt("DOWNLOAD_FAILED_MAX_RETRYTIMES");
        long j = jSONObject.getLong("DOWNLOAD_SINGLE_TIMEOUT");
        long j2 = jSONObject.getLong("TBSAPKFILESIZE");
        long optLong = jSONObject.optLong("RETRY_INTERVAL", 0);
        int optInt2 = jSONObject.optInt("FLOWCTR", -1);
        i2 = 0;
        try {
            i2 = jSONObject.getInt("USEBBACKUPVER");
        } catch (Exception e) {
        }
        instance.f1368a.put(TbsConfigKey.KEY_USE_BACKUP_VERSION, Integer.valueOf(i2));
        if (z && QbSdk.f16247i && TbsShareManager.isThirdPartyApp(f4488c)) {
            try {
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(f4488c, TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME, jSONObject.optInt("BUGLY", 0) == 1);
            } catch (Throwable th) {
                TbsLog.m80434i("qbsdk", "throwable:" + th.toString());
            }
        }
        if (z) {
            try {
                optInt = jSONObject.optInt("TEMPLATESWITCH", 0);
                z3 = (optInt & 1) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(f4488c, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME, z3);
                TbsLog.m80438w(LOGTAG, "useCookieCompatiable:".concat(String.valueOf(z3)));
                z3 = (optInt & 2) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(f4488c, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME, z3);
                TbsLog.m80438w(LOGTAG, "disableGetApkVersionByReadFile:".concat(String.valueOf(z3)));
                z3 = (optInt & 4) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(f4488c, TbsExtensionFunctionManager.DISABLE_UNPREINIT, z3);
                QbSdk.setDisableUnpreinitBySwitch(z3);
                TbsLog.m80434i(LOGTAG, "disableUnpreinitBySwitch:".concat(String.valueOf(z3)));
                z3 = (optInt & 8) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(f4488c, TbsExtensionFunctionManager.DISABLE_USE_HOST_BACKUP_CORE, z3);
                QbSdk.setDisableUseHostBackupCoreBySwitch(z3);
                TbsLog.m80434i(LOGTAG, "disableUseHostBackupCoreBySwitch:".concat(String.valueOf(z3)));
            } catch (Throwable th2) {
                TbsLog.m80434i("qbsdk", "throwable:" + th2.toString());
            }
        }
        Object obj = null;
        int i9 = 0;
        int i10 = 0;
        Object obj2 = null;
        boolean z5 = true;
        CharSequence charSequence = "";
        try {
            obj = jSONObject.getString("PKGMD5");
            i9 = jSONObject.getInt("RESETX5");
            i10 = jSONObject.getInt("UPLOADLOG");
            if (jSONObject.has("RESETTOKEN")) {
                obj2 = jSONObject.getInt("RESETTOKEN") != 0 ? 1 : null;
            }
            if (jSONObject.has("SETTOKEN")) {
                charSequence = jSONObject.getString("SETTOKEN");
            }
            if (jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK")) {
                z5 = jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK") != 0;
            }
            z3 = jSONObject.has("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT") ? jSONObject.getInt("ENABLE_LOAD_RENAME_FILE_LOCK_WAIT") != 0 : true;
            z4 = z3;
        } catch (Exception e2) {
            charSequence = charSequence;
            z4 = true;
        }
        try {
            i2 = jSONObject.getInt("RESETDECOUPLECORE");
        } catch (Exception e3) {
            i2 = 0;
        }
        optInt = 0;
        try {
            optInt = jSONObject.getInt("RESETTODECOUPLECORE");
        } catch (Exception e4) {
        }
        synchronized (f4491f) {
            if (obj2 != null) {
                try {
                    instance.f1368a.put(TbsConfigKey.KEY_DESkEY_TOKEN, "");
                } catch (Throwable th3) {
                    while (true) {
                        AppMethodBeat.m2505o(64375);
                    }
                }
            }
            if (!TextUtils.isEmpty(charSequence) && charSequence.length() == 96) {
                instance.f1368a.put(TbsConfigKey.KEY_DESkEY_TOKEN, charSequence + "&" + C44464o.m80460c());
            }
        }
        if (i9 == 1) {
            if (z) {
                instance.setDownloadInterruptCode(-110);
            } else {
                instance.setDownloadInterruptCode(-210);
            }
            QbSdk.reset(f4488c, optInt == 1);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=".concat(String.valueOf(z)));
            AppMethodBeat.m2505o(64375);
            return false;
        }
        long j3;
        if (!z5) {
            instance.setTbsCoreLoadRenameFileLockEnable(z5);
        }
        if (!z4) {
            instance.setTbsCoreLoadRenameFileLockWaitEnable(z4);
        }
        if (i2 == 1) {
            QbSdk.resetDecoupleCore(f4488c);
        }
        if (i10 == 1) {
            f4489d.removeMessages(104);
            Message.obtain(f4489d, 104).sendToTarget();
        }
        if (optInt2 == 1) {
            j3 = optLong > 604800 ? 604800 : optLong;
        }
        j3 = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        if (getRetryIntervalInSeconds() >= 0) {
            j3 = getRetryIntervalInSeconds();
        }
        instance.f1368a.put(TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(j3));
        i2 = 0;
        optInt = 0;
        if (z) {
            try {
                i2 = jSONObject.getInt("DECOUPLECOREVERSION");
            } catch (Exception e5) {
            }
        } else {
            i2 = TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        }
        try {
            optInt = TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        } catch (Exception e6) {
        }
        if (z && !TbsShareManager.isThirdPartyApp(f4488c) && r2 == 0) {
            i2 = C5813an.m8800a().mo12174i(f4488c);
        }
        TbsLog.m80434i(LOGTAG, "in response decoupleCoreVersion is ".concat(String.valueOf(i2)));
        instance.f1368a.put(TbsConfigKey.KEY_DECOUPLECOREVERSION, Integer.valueOf(i2));
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(optInt));
        if (!TbsShareManager.isThirdPartyApp(f4488c)) {
            if (i2 > 0 && i2 != C5813an.m8800a().mo12174i(f4488c) && i2 == C5813an.m8800a().mo12175j(f4488c)) {
                C5813an.m8800a().mo12180o(f4488c);
            } else if (i2 == 0) {
                try {
                    C30950k.m49564b(C5813an.m8800a().mo12182q(f4488c));
                } catch (Throwable th4) {
                }
            }
        }
        if (TextUtils.isEmpty(string) && TbsShareManager.isThirdPartyApp(f4488c)) {
            instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            instance.commit();
            if (z) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(f4488c, i4, false);
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] return #4,current app is third app...");
            AppMethodBeat.m2505o(64375);
            return false;
        }
        TbsLog.m80434i(LOGTAG, "in response responseCode is ".concat(String.valueOf(i3)));
        if (i3 == 0) {
            instance.f1368a.put(TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
            instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            if (z) {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-111));
            } else {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-211));
                instance.setDownloadInterruptCode(-211);
            }
            instance.commit();
            if (!TbsShareManager.isThirdPartyApp(f4488c)) {
                startDecoupleCoreIfNeeded();
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
            AppMethodBeat.m2505o(64375);
            return false;
        }
        int i11 = TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (i11 > i4) {
            f4492g.mo57535d();
            C5813an.m8800a().mo12181p(f4488c);
        }
        Object obj3 = null;
        if (!TbsShareManager.isThirdPartyApp(f4488c)) {
            int h = C5813an.m8800a().mo12173h(f4488c);
            if (h >= i4) {
                obj3 = 1;
            }
            TbsLog.m80434i(LOGTAG, "tmpCoreVersion is " + h + " tbsDownloadVersion is" + i4);
        }
        if ((i >= i4 || TextUtils.isEmpty(string) || obj3 != null) && optInt != 1) {
            instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            if (!z) {
                i2 = -212;
                if (TextUtils.isEmpty(string)) {
                    i2 = -217;
                } else if (i4 <= 0) {
                    i2 = -218;
                } else if (i >= i4) {
                    i2 = -219;
                }
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(i2));
                instance.setDownloadInterruptCode(i2);
            } else if (TextUtils.isEmpty(string)) {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-124));
            } else if (i4 <= 0) {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-125));
            } else if (i >= i4) {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-127));
            } else {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-112));
            }
            instance.commit();
            TbsLog.m80434i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i4 + " tbsLastDownloadVersion=" + i11 + " downloadUrl=" + string);
            AppMethodBeat.m2505o(64375);
            return false;
        }
        if (!string.equals(instance.mPreferences.getString(TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
            f4492g.mo57535d();
            instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(0));
            instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(0));
        }
        instance.f1368a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i4));
        TbsLog.m80434i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is ".concat(String.valueOf(i4)));
        if (i4 > 0) {
            if (optInt == 1) {
                instance.f1368a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, Integer.valueOf(1));
            } else {
                instance.f1368a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, Integer.valueOf(0));
            }
            TbsLog.m80434i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is ".concat(String.valueOf(optInt)));
        }
        instance.f1368a.put(TbsConfigKey.KEY_TBSDOWNLOADURL, string);
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOADURL_LIST, optString);
        instance.f1368a.put(TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i5));
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i6));
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i7));
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i8));
        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j));
        instance.f1368a.put(TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j2));
        instance.commit();
        if (obj != null) {
            instance.f1368a.put(TbsConfigKey.KEY_TBSAPK_MD5, obj);
        }
        if (z2 || !C5813an.m8800a().mo12162b(f4488c, i4)) {
            TbsLogInfo tbsLogInfo;
            if (!z2) {
                C36431ag c36431ag = f4492g;
                z3 = i3 == 1 || i3 == 2;
                if (c36431ag.mo57531a(z2, z3)) {
                    instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                    tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
                    tbsLogInfo.setErrorCode(100);
                    tbsLogInfo.setFailDetail("use local backup apk in needDownload" + f4492g.f15141a);
                    if (TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                        TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                    } else {
                        TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                    TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] ##7 set needDownload=false");
                }
            }
            if (TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1 && f4492g.mo57529a()) {
                instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
                tbsLogInfo.setErrorCode(100);
                tbsLogInfo.setFailDetail("installDecoupleCoreFromBackup" + f4492g.f15141a);
                if (TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                    TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                } else {
                    TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                }
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] ##8 set needDownload=false");
            } else {
                if (!z) {
                    instance.setDownloadInterruptCode(-216);
                }
                instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] ##9 set needDownload=true");
            }
        } else {
            if (z) {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-113));
            } else {
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-213));
                instance.setDownloadInterruptCode(-213);
            }
            instance.f1368a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.readResponse] ##6 set needDownload=false");
        }
        if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
            instance.f1368a.put(TbsConfigKey.KEY_STOP_PRE_OAT, Boolean.TRUE);
        }
        instance.commit();
        AppMethodBeat.m2505o(64375);
        return true;
    }

    /* renamed from: b */
    protected static File m37403b(int i) {
        AppMethodBeat.m2504i(64381);
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        File file = null;
        int length = coreProviderAppList.length;
        int i2 = 0;
        while (i2 < length) {
            String str = coreProviderAppList[i2];
            File file2 = new File(C30950k.m49547a(f4488c, str, 4, false), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (!file2.exists() || C24272a.m37432a(f4488c, file2) != i) {
                file = new File(C30950k.m49547a(f4488c, str, 4, false), "x5.tbs.decouple");
                if (file.exists() && C24272a.m37432a(f4488c, file) == i) {
                    TbsLog.m80434i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                }
                i2++;
            } else {
                TbsLog.m80434i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                file = file2;
                break;
            }
        }
        AppMethodBeat.m2505o(64381);
        return file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:75:0x02b0 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0099 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02c0 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02df A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0124 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02e2 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012f A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x013c A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017c A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c6 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cb A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01da A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e3 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x02fd  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0221 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x008b A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0099 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x02b0 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x02c0 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0124 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x02df A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x012f A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x02e2 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x013c A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017c A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x01ba A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x01c6 A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x02f4  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01cb A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x01da A:{Catch:{ Exception -> 0x02bb }} */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01e3 A:{Catch:{ Exception -> 0x02bb }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static JSONObject m37404b(boolean z, boolean z2, boolean z3) {
        Object obj;
        Object simCountryIso;
        JSONObject jSONObject;
        int n;
        int i;
        boolean z4;
        boolean booleanValue;
        AppMethodBeat.m2504i(64371);
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(f4488c);
        String a = m37393a(f4488c);
        String d = C36443b.m60188d(f4488c);
        String c = C36443b.m60187c(f4488c);
        String f = C36443b.m60190f(f4488c);
        String str = "";
        String str2 = "";
        String id = TimeZone.getDefault().getID();
        if (id != null) {
            obj = id;
        } else {
            String obj2 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) f4488c.getSystemService("phone");
            if (telephonyManager != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj2);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (TbsShareManager.isThirdPartyApp(f4488c)) {
                    n = C5813an.m8800a().mo12179n(f4488c);
                    if (n == 0 && C5813an.m8800a().mo12178m(f4488c)) {
                        n = -1;
                        if (TbsConfig.APP_QQ.equals(f4488c.getApplicationInfo().packageName)) {
                            TbsDownloadUpload.clear();
                            TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(f4488c);
                            instance2.f17972a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, Integer.valueOf(-1));
                            instance2.commit();
                            TbsPVConfig.releaseInstance();
                            if (TbsPVConfig.getInstance(f4488c).getLocalCoreVersionMoreTimes() == 1) {
                                n = C5813an.m8800a().mo12175j(f4488c);
                            }
                        }
                    }
                    TbsLog.m80434i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + n + " isDownloadForeground=" + z2);
                    if (!z2) {
                        i = n;
                        if (z) {
                            jSONObject.put("FUNCTION", 2);
                        } else {
                            jSONObject.put("FUNCTION", i == 0 ? 0 : 1);
                        }
                        JSONArray f2;
                        if (TbsShareManager.isThirdPartyApp(f4488c)) {
                            f2 = m37413f();
                            jSONObject.put("TBSVLARR", f2);
                            instance.f1368a.put(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, f2.toString());
                            instance.commit();
                            if (QbSdk.f16241c) {
                                jSONObject.put("THIRDREQ", 1);
                            }
                        } else {
                            f2 = m37415h();
                            if (Apn.getApnType(f4488c) != 3 && f2.length() != 0 && i == 0 && z) {
                                jSONObject.put("TBSBACKUPARR", f2);
                            }
                        }
                        jSONObject.put("APPN", f4488c.getPackageName());
                        jSONObject.put("APPVN", m37394a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                        jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                        jSONObject.put("APPMETA", m37394a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
                        jSONObject.put("TBSSDKV", 43644);
                        jSONObject.put("TBSV", i);
                        jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                        instance.f1368a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
                        instance.commit();
                        if (i != 0) {
                            jSONObject.put("TBSBACKUPV", f4492g.mo57532b());
                        }
                        jSONObject.put("CPU", f4490e);
                        jSONObject.put("UA", a);
                        jSONObject.put("IMSI", m37394a(d));
                        jSONObject.put("IMEI", m37394a(c));
                        jSONObject.put("ANDROID_ID", m37394a(f));
                        if (!TbsShareManager.isThirdPartyApp(f4488c)) {
                            if (i != 0) {
                                jSONObject.put("STATUS", QbSdk.m71037a(f4488c, i) ? 0 : 1);
                            } else {
                                jSONObject.put("STATUS", 0);
                            }
                            jSONObject.put("TBSDV", C5813an.m8800a().mo12174i(f4488c));
                        }
                        z4 = TbsDownloadConfig.getInstance(f4488c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
                        simCountryIso = QbSdk.m71033a(f4488c, "can_unlzma", null);
                        booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                        simCountryIso = booleanValue ? !z4 ? 1 : null : null;
                        if (simCountryIso != null) {
                            jSONObject.put("REQUEST_LZMA", 1);
                        }
                        if (getOverSea(f4488c)) {
                            jSONObject.put("OVERSEA", 1);
                        }
                        if (z2) {
                            jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                        }
                        TbsLog.m80434i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                        AppMethodBeat.m2505o(64371);
                        return jSONObject;
                    } else if (!C5813an.m8800a().mo12178m(f4488c)) {
                        n = 0;
                    }
                } else {
                    n = QbSdk.f16241c ? TbsShareManager.m49460a(f4488c, false) : TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                }
                i = n;
                if (z) {
                }
                if (TbsShareManager.isThirdPartyApp(f4488c)) {
                }
                jSONObject.put("APPN", f4488c.getPackageName());
                jSONObject.put("APPVN", m37394a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                jSONObject.put("APPMETA", m37394a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
                jSONObject.put("TBSSDKV", 43644);
                jSONObject.put("TBSV", i);
                if (z3) {
                }
                jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                if (z3) {
                }
                instance.f1368a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
                instance.commit();
                if (i != 0) {
                }
                jSONObject.put("CPU", f4490e);
                jSONObject.put("UA", a);
                jSONObject.put("IMSI", m37394a(d));
                jSONObject.put("IMEI", m37394a(c));
                jSONObject.put("ANDROID_ID", m37394a(f));
                if (TbsShareManager.isThirdPartyApp(f4488c)) {
                }
                z4 = TbsDownloadConfig.getInstance(f4488c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
                simCountryIso = QbSdk.m71033a(f4488c, "can_unlzma", null);
                if (simCountryIso == null) {
                }
                if (booleanValue) {
                }
                if (simCountryIso != null) {
                }
                if (getOverSea(f4488c)) {
                }
                if (z2) {
                }
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                AppMethodBeat.m2505o(64371);
                return jSONObject;
            }
        } catch (Exception e) {
        }
        str = id;
        if (simCountryIso == null) {
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("TIMEZONEID", obj2);
            jSONObject.put("COUNTRYISO", simCountryIso);
            jSONObject.put("PROTOCOLVERSION", 1);
            if (TbsShareManager.isThirdPartyApp(f4488c)) {
            }
            i = n;
            if (z) {
            }
            if (TbsShareManager.isThirdPartyApp(f4488c)) {
            }
            jSONObject.put("APPN", f4488c.getPackageName());
            jSONObject.put("APPVN", m37394a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", m37394a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43644);
            jSONObject.put("TBSV", i);
            if (z3) {
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            if (z3) {
            }
            instance.f1368a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
            instance.commit();
            if (i != 0) {
            }
            jSONObject.put("CPU", f4490e);
            jSONObject.put("UA", a);
            jSONObject.put("IMSI", m37394a(d));
            jSONObject.put("IMEI", m37394a(c));
            jSONObject.put("ANDROID_ID", m37394a(f));
            if (TbsShareManager.isThirdPartyApp(f4488c)) {
            }
            z4 = TbsDownloadConfig.getInstance(f4488c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
            simCountryIso = QbSdk.m71033a(f4488c, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            if (booleanValue) {
            }
            if (simCountryIso != null) {
            }
            if (getOverSea(f4488c)) {
            }
            if (z2) {
            }
        } catch (Exception e2) {
        }
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        AppMethodBeat.m2505o(64371);
        return jSONObject;
    }

    @TargetApi(11)
    /* renamed from: b */
    static void m37405b(Context context) {
        AppMethodBeat.m2504i(64378);
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        C36431ag.m60066c(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
        AppMethodBeat.m2505o(64378);
    }

    /* renamed from: b */
    private static void m37406b(JSONArray jSONArray) {
        Object obj = null;
        AppMethodBeat.m2504i(64368);
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a = C5813an.m8800a().mo12148a(TbsShareManager.getHostCorePathAppDefined());
            for (int i = 0; i < jSONArray.length(); i++) {
                if (jSONArray.optInt(i) == a) {
                    obj = 1;
                    break;
                }
            }
            if (obj == null) {
                jSONArray.put(a);
            }
        }
        AppMethodBeat.m2505o(64368);
    }

    /* renamed from: b */
    private static boolean m37407b(boolean z, boolean z2) {
        AppMethodBeat.m2504i(64373);
        boolean c = m37410c(z, z2, false);
        AppMethodBeat.m2505o(64373);
        return c;
    }

    /* renamed from: c */
    private static synchronized void m37408c() {
        synchronized (TbsDownloader.class) {
            AppMethodBeat.m2504i(64363);
            if (f4493h == null) {
                f4493h = C24267al.m37429a();
                try {
                    f4492g = new C36431ag(f4488c);
                    f4489d = new C36433aj(f4493h.getLooper());
                } catch (Exception e) {
                    f4494i = true;
                    TbsLog.m80432e(LOGTAG, "TbsApkDownloader init has Exception");
                    AppMethodBeat.m2505o(64363);
                }
            }
            AppMethodBeat.m2505o(64363);
        }
        return;
    }

    /* renamed from: c */
    private static void m37409c(JSONArray jSONArray) {
        AppMethodBeat.m2504i(64370);
        if (!TbsPVConfig.getInstance(f4488c).isDisableHostBackupCore()) {
            for (String str : m37412e()) {
                Context packageContext;
                int i;
                boolean z;
                int backupCoreVersion = TbsShareManager.getBackupCoreVersion(f4488c, str);
                if (backupCoreVersion > 0) {
                    packageContext = TbsShareManager.getPackageContext(f4488c, str, false);
                    if (packageContext == null || C5813an.m8800a().mo12171f(packageContext)) {
                        for (i = 0; i < jSONArray.length(); i++) {
                            if (jSONArray.optInt(i) == backupCoreVersion) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        if (!z) {
                            jSONArray.put(backupCoreVersion);
                        }
                    } else {
                        TbsLog.m80432e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                    }
                }
                backupCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(f4488c, str);
                if (backupCoreVersion > 0) {
                    packageContext = TbsShareManager.getPackageContext(f4488c, str, false);
                    if (packageContext == null || C5813an.m8800a().mo12171f(packageContext)) {
                        for (i = 0; i < jSONArray.length(); i++) {
                            if (jSONArray.optInt(i) == backupCoreVersion) {
                                z = true;
                                break;
                            }
                        }
                        z = false;
                        if (!z) {
                            jSONArray.put(backupCoreVersion);
                        }
                    } else {
                        TbsLog.m80432e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                    }
                }
            }
        }
        AppMethodBeat.m2505o(64370);
    }

    /* renamed from: c */
    private static boolean m37410c(boolean z, boolean z2, boolean z3) {
        TbsDownloadUpload instance;
        AppMethodBeat.m2504i(64374);
        if (z) {
            instance = TbsDownloadUpload.getInstance(f4488c);
            instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(144));
            instance.commit();
        } else if (!z3) {
            instance = TbsDownloadUpload.getInstance(f4488c);
            instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_5));
            instance.commit();
        }
        if (QbSdk.f16252n != null && QbSdk.f16252n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.f16252n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            if (z) {
                instance = TbsDownloadUpload.getInstance(f4488c);
                instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(145));
                instance.commit();
            } else if (!z3) {
                instance = TbsDownloadUpload.getInstance(f4488c);
                instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_6));
                instance.commit();
            }
            AppMethodBeat.m2505o(64374);
            return false;
        }
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
        if (C5813an.m8800a().mo12165c(f4488c)) {
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            if (z) {
                instance = TbsDownloadUpload.getInstance(f4488c);
                instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(146));
                instance.commit();
            } else if (!z3) {
                instance = TbsDownloadUpload.getInstance(f4488c);
                instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(166));
                instance.commit();
            }
            AppMethodBeat.m2505o(64374);
            return false;
        }
        int i;
        boolean a;
        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(f4488c);
        File file = new File(C30950k.m49545a(f4488c, 1), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file2 = new File(C30950k.m49545a(f4488c, 2), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file3 = new File(C30950k.m49545a(f4488c, 3), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file4 = new File(C30950k.m49545a(f4488c, 4), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        if (!file4.exists()) {
            if (file3.exists()) {
                file3.renameTo(file4);
            } else if (file2.exists()) {
                file2.renameTo(file4);
            } else if (file.exists()) {
                file.renameTo(file4);
            }
        }
        if (f4490e == null) {
            f4490e = C36443b.m60176a();
            instance2.f1368a.put(TbsConfigKey.KEY_DEVICE_CPUABI, f4490e);
            instance2.commit();
        }
        Object obj = null;
        if (!TextUtils.isEmpty(f4490e)) {
            Matcher matcher = null;
            try {
                matcher = Pattern.compile("i686|mips|x86_64").matcher(f4490e);
            } catch (Exception e) {
            }
            if (matcher != null && matcher.find()) {
                if (TbsShareManager.isThirdPartyApp(f4488c)) {
                    TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f4488c).tbsLogInfo();
                    if (z) {
                        instance2.setDownloadInterruptCode(ZipJNI.UNZ_INTERNALERROR);
                        tbsLogInfo.setErrorCode(ZipJNI.UNZ_INTERNALERROR);
                    } else {
                        instance2.setDownloadInterruptCode(-205);
                        tbsLogInfo.setErrorCode(-205);
                    }
                    tbsLogInfo.setFailDetail("mycpu is " + f4490e);
                    TbsLogReport.getInstance(f4488c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                } else if (z) {
                    instance2.setDownloadInterruptCode(ZipJNI.UNZ_INTERNALERROR);
                } else {
                    instance2.setDownloadInterruptCode(-205);
                }
                obj = 1;
            }
        }
        instance2.f1368a.put(TbsConfigKey.KEY_APP_VERSIONNAME, C36443b.m60177a(f4488c));
        instance2.f1368a.put(TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(C36443b.m60185b(f4488c)));
        instance2.commit();
        JSONObject b = m37404b(z, z2, z3);
        int i2 = -1;
        try {
            i = b.getInt("TBSV");
        } catch (Exception e2) {
            i = i2;
        }
        if (!(obj == null && i == -1)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbsShareManager.isThirdPartyApp(f4488c)) {
                instance2.f1368a.put(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(currentTimeMillis - instance2.mPreferences.getLong(TbsConfigKey.KEY_REQUEST_FAIL, 0) < instance2.getRetryInterval() * 1000 ? 1 + instance2.mPreferences.getLong(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0) : 1));
            }
            instance2.f1368a.put(TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(currentTimeMillis));
            instance2.f1368a.put(TbsConfigKey.KEY_APP_VERSIONNAME, C36443b.m60177a(f4488c));
            instance2.f1368a.put(TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(C36443b.m60185b(f4488c)));
            instance2.f1368a.put(TbsConfigKey.KEY_APP_METADATA, C36443b.m60179a(f4488c, TBS_METADATA));
            instance2.commit();
            if (obj != null) {
                if (z) {
                    instance = TbsDownloadUpload.getInstance(f4488c);
                    instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_8));
                    instance.commit();
                } else if (!z3) {
                    instance = TbsDownloadUpload.getInstance(f4488c);
                    instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_8));
                    instance.commit();
                }
                AppMethodBeat.m2505o(64374);
                return false;
            }
        }
        if (i != -1) {
            try {
                String d = C36446v.m60195a(f4488c).mo57634d();
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(d)));
                TbsDownloadUpload instance3;
                if (z) {
                    instance3 = TbsDownloadUpload.getInstance(f4488c);
                    instance3.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(148));
                    instance3.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, Integer.valueOf(1));
                    instance3.commit();
                    TbsLog.m80434i(LOGTAG, "sendRequest query 148");
                } else if (!z3) {
                    instance3 = TbsDownloadUpload.getInstance(f4488c);
                    instance3.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(168));
                    instance3.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, Integer.valueOf(1));
                    instance3.commit();
                    TbsLog.m80434i(LOGTAG, "sendRequest download 168");
                }
                a = m37399a(C44463n.m80450a(d, b.toString().getBytes(ProtocolPackage.ServerEncoding), new C5812ak(instance2, z), false), i, z, z2);
            } catch (Throwable th) {
                if (z) {
                    instance2.setDownloadInterruptCode(ZipJNI.UNZ_ERR_OPEN_WRITE);
                    a = false;
                } else {
                    instance2.setDownloadInterruptCode(-206);
                    a = false;
                }
            }
        } else if (z) {
            instance = TbsDownloadUpload.getInstance(f4488c);
            instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(149));
            instance.commit();
            a = false;
        } else {
            if (!z3) {
                instance = TbsDownloadUpload.getInstance(f4488c);
                instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(169));
                instance.commit();
            }
            a = false;
        }
        AppMethodBeat.m2505o(64374);
        return a;
    }

    /* renamed from: d */
    private static boolean m37411d() {
        AppMethodBeat.m2504i(64365);
        try {
            boolean equals = TbsDownloadConfig.getInstance(f4488c).mPreferences.getString(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(m37413f().toString());
            AppMethodBeat.m2505o(64365);
            return equals;
        } catch (Exception e) {
            AppMethodBeat.m2505o(64365);
            return false;
        }
    }

    /* renamed from: e */
    private static String[] m37412e() {
        String[] strArr;
        AppMethodBeat.m2504i(64366);
        if (QbSdk.getOnlyDownload()) {
            strArr = new String[]{f4488c.getApplicationContext().getPackageName()};
        } else {
            String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
            String packageName = f4488c.getApplicationContext().getPackageName();
            if (packageName.equals(TbsShareManager.m49472f(f4488c))) {
                int length = coreProviderAppList.length;
                strArr = new String[(length + 1)];
                System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
                strArr[length] = packageName;
            } else {
                strArr = coreProviderAppList;
            }
        }
        AppMethodBeat.m2505o(64366);
        return strArr;
    }

    /* renamed from: f */
    private static JSONArray m37413f() {
        AppMethodBeat.m2504i(64369);
        if (TbsShareManager.isThirdPartyApp(f4488c)) {
            JSONArray jSONArray = new JSONArray();
            m37395a(jSONArray);
            m37409c(jSONArray);
            m37406b(jSONArray);
            AppMethodBeat.m2505o(64369);
            return jSONArray;
        }
        AppMethodBeat.m2505o(64369);
        return null;
    }

    /* renamed from: g */
    private static boolean m37414g() {
        AppMethodBeat.m2504i(64379);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(f4488c);
        if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.m80435i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            instance.setDownloadInterruptCode(-115);
            AppMethodBeat.m2505o(64379);
            return false;
        } else if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.m80435i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            instance.setDownloadInterruptCode(-116);
            AppMethodBeat.m2505o(64379);
            return false;
        } else if (C30950k.m49565b(f4488c)) {
            if (System.currentTimeMillis() - instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= 86400000) {
                long j = instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=".concat(String.valueOf(j)));
                if (j >= instance.getDownloadMaxflow()) {
                    TbsLog.m80435i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    instance.setDownloadInterruptCode(-120);
                    AppMethodBeat.m2505o(64379);
                    return false;
                }
            }
            AppMethodBeat.m2505o(64379);
            return true;
        } else {
            TbsLog.m80435i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            instance.setDownloadInterruptCode(-117);
            AppMethodBeat.m2505o(64379);
            return false;
        }
    }

    public static int getCoreShareDecoupleCoreVersion() {
        AppMethodBeat.m2504i(64357);
        int i = C5813an.m8800a().mo12174i(f4488c);
        AppMethodBeat.m2505o(64357);
        return i;
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        AppMethodBeat.m2504i(64356);
        int i = C5813an.m8800a().mo12174i(context);
        AppMethodBeat.m2505o(64356);
        return i;
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.m2504i(64372);
            if (!f4496k) {
                f4496k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                    f4495j = instance.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.m80434i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f4495j);
                }
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f4495j);
            }
            z = f4495j;
            AppMethodBeat.m2505o(64372);
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return f4497l;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return f4493h;
    }

    /* renamed from: h */
    private static JSONArray m37415h() {
        AppMethodBeat.m2504i(64382);
        JSONArray jSONArray = new JSONArray();
        for (String a : TbsShareManager.getCoreProviderAppList()) {
            File file = new File(C30950k.m49547a(f4488c, a, 4, false), getOverSea(f4488c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long a2 = (long) C24272a.m37432a(f4488c, file);
                if (a2 > 0) {
                    boolean z;
                    for (int i = 0; i < jSONArray.length(); i++) {
                        if (((long) jSONArray.optInt(i)) == a2) {
                            z = true;
                            break;
                        }
                    }
                    z = false;
                    if (!z) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(64382);
        return jSONArray;
    }

    public static boolean isDownloadForeground() {
        AppMethodBeat.m2504i(64362);
        if (f4492g == null || !f4492g.mo57536e()) {
            AppMethodBeat.m2505o(64362);
            return false;
        }
        AppMethodBeat.m2505o(64362);
        return true;
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.m2504i(64361);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.isDownloading] is " + f4486a);
            z = f4486a;
            AppMethodBeat.m2505o(64361);
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        AppMethodBeat.m2504i(64352);
        boolean needDownload = needDownload(context, z, false, null);
        AppMethodBeat.m2505o(64352);
        return needDownload;
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        AppMethodBeat.m2504i(64353);
        TbsDownloadUpload.clear();
        TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
        instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(140));
        instance.commit();
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        TbsLog.initIfNeed(context);
        if (C5813an.f1399b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_FALSE_1));
            instance.commit();
            AppMethodBeat.m2505o(64353);
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        f4488c = applicationContext;
        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(applicationContext);
        instance2.setDownloadInterruptCode(-100);
        if (m37397a(f4488c, z, tbsDownloaderCallback)) {
            m37408c();
            if (f4494i) {
                if (tbsDownloaderCallback != null) {
                    tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                }
                instance2.setDownloadInterruptCode(ZipJNI.UNZ_CRCERROR);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
                instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_3));
                instance.commit();
                instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_FALSE_3));
                instance.commit();
                AppMethodBeat.m2505o(64353);
                return false;
            }
            boolean contains;
            boolean z3;
            boolean z4;
            boolean a = m37398a(f4488c, z2, false);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=".concat(String.valueOf(a)));
            if (a) {
                m37396a(z2, tbsDownloaderCallback);
                instance2.setDownloadInterruptCode(-114);
            } else {
                instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_4));
                instance.commit();
            }
            f4489d.removeMessages(102);
            Message.obtain(f4489d, 102).sendToTarget();
            if (QbSdk.f16241c || !TbsShareManager.isThirdPartyApp(context)) {
                contains = instance2.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=".concat(String.valueOf(contains)));
                z3 = (contains || TbsShareManager.isThirdPartyApp(context)) ? instance2.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
            } else {
                z3 = false;
                contains = false;
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z3 + ",hasNeedDownloadKey=" + contains);
            if (!z3) {
                int n = C5813an.m8800a().mo12179n(f4488c);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + n + ",needSendRequest=" + a);
                if (a || n <= 0) {
                    f4489d.removeMessages(103);
                    if (n > 0 || a) {
                        Message.obtain(f4489d, 103, 1, 0, f4488c).sendToTarget();
                    } else {
                        Message.obtain(f4489d, 103, 0, 0, f4488c).sendToTarget();
                    }
                    instance2.setDownloadInterruptCode(-121);
                    z4 = z3;
                } else {
                    instance2.setDownloadInterruptCode(-119);
                    z4 = z3;
                }
            } else if (m37414g()) {
                instance2.setDownloadInterruptCode(-118);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#6");
                z4 = z3;
            } else {
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
                z4 = false;
            }
            if (!(a || tbsDownloaderCallback == null)) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(z4)));
            instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z4 ? ErrorCode.NEEDDOWNLOAD_TRUE : ErrorCode.NEEDDOWNLOAD_FALSE_4));
            instance.commit();
            AppMethodBeat.m2505o(64353);
            return z4;
        }
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
        instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(141));
        instance.commit();
        instance.f17972a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_FALSE_2));
        instance.commit();
        AppMethodBeat.m2505o(64353);
        return false;
    }

    public static boolean needDownloadDecoupleCore() {
        AppMethodBeat.m2504i(64358);
        if (TbsShareManager.isThirdPartyApp(f4488c)) {
            AppMethodBeat.m2505o(64358);
            return false;
        } else if (TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            AppMethodBeat.m2505o(64358);
            return false;
        } else {
            long j = TbsDownloadConfig.getInstance(f4488c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
            if (System.currentTimeMillis() - j < 1000 * TbsDownloadConfig.getInstance(f4488c).getRetryInterval()) {
                AppMethodBeat.m2505o(64358);
                return false;
            }
            int i = TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            if (i <= 0 || i == C5813an.m8800a().mo12174i(f4488c) || TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i) {
                AppMethodBeat.m2505o(64358);
                return false;
            }
            AppMethodBeat.m2505o(64358);
            return true;
        }
    }

    public static boolean needSendRequest(Context context, boolean z) {
        boolean z2 = true;
        AppMethodBeat.m2504i(64349);
        f4488c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (m37397a(f4488c, z, null)) {
            int n = C5813an.m8800a().mo12179n(context);
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(n)));
            if (n > 0) {
                AppMethodBeat.m2505o(64349);
                return false;
            } else if (m37398a(f4488c, false, true)) {
                AppMethodBeat.m2505o(64349);
                return true;
            } else {
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(f4488c);
                boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=".concat(String.valueOf(contains)));
                boolean z3 = !contains ? true : instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=".concat(String.valueOf(z3)));
                if (!(z3 && m37414g())) {
                    z2 = false;
                }
                TbsLog.m80434i(LOGTAG, "[TbsDownloader.needSendRequest] ret=".concat(String.valueOf(z2)));
                AppMethodBeat.m2505o(64349);
                return z2;
            }
        }
        AppMethodBeat.m2505o(64349);
        return false;
    }

    public static void setAppContext(Context context) {
        AppMethodBeat.m2504i(64348);
        if (!(context == null || context.getApplicationContext() == null)) {
            f4488c = context.getApplicationContext();
        }
        AppMethodBeat.m2505o(64348);
    }

    public static void setRetryIntervalInSeconds(Context context, long j) {
        AppMethodBeat.m2504i(64376);
        if (context == null) {
            AppMethodBeat.m2505o(64376);
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            f4497l = j;
        }
        TbsLog.m80434i(LOGTAG, "mRetryIntervalInSeconds is " + f4497l);
        AppMethodBeat.m2505o(64376);
    }

    public static boolean startDecoupleCoreIfNeeded() {
        AppMethodBeat.m2504i(64359);
        TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(f4488c)) {
            AppMethodBeat.m2505o(64359);
            return false;
        }
        TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            AppMethodBeat.m2505o(64359);
            return false;
        } else if (f4489d == null) {
            AppMethodBeat.m2505o(64359);
            return false;
        } else {
            TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded #2");
            long j = TbsDownloadConfig.getInstance(f4488c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
            if (System.currentTimeMillis() - j < 1000 * TbsDownloadConfig.getInstance(f4488c).getRetryInterval()) {
                AppMethodBeat.m2505o(64359);
                return false;
            }
            TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded #3");
            int i = TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            if (i <= 0 || i == C5813an.m8800a().mo12174i(f4488c)) {
                TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + C5813an.m8800a().mo12174i(f4488c));
            } else if (TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i || TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded #4");
                f4486a = true;
                f4489d.removeMessages(108);
                Message obtain = Message.obtain(f4489d, 108, QbSdk.f16251m);
                obtain.arg1 = 0;
                obtain.sendToTarget();
                TbsDownloadConfig.getInstance(f4488c).f1368a.put(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.m2505o(64359);
                return true;
            } else {
                TbsLog.m80434i(LOGTAG, "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(f4488c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0));
            }
            AppMethodBeat.m2505o(64359);
            return false;
        }
    }

    public static void startDownload(Context context) {
        AppMethodBeat.m2504i(64354);
        startDownload(context, false);
        AppMethodBeat.m2505o(64354);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        int i = 1;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.m2504i(64355);
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
            instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(160));
            instance.commit();
            TbsLog.m80434i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f4488c);
            if (C5813an.f1399b) {
                instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(161));
                instance.commit();
                AppMethodBeat.m2505o(64355);
            } else {
                f4486a = true;
                Context applicationContext = context.getApplicationContext();
                f4488c = applicationContext;
                TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.f16251m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(f4488c).setDownloadInterruptCode(-201);
                    instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_3));
                    instance.commit();
                    AppMethodBeat.m2505o(64355);
                } else {
                    m37408c();
                    if (f4494i) {
                        QbSdk.f16251m.onDownloadFinish(121);
                        TbsDownloadConfig.getInstance(f4488c).setDownloadInterruptCode(-202);
                        instance.f17972a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_4));
                        instance.commit();
                        AppMethodBeat.m2505o(64355);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        f4489d.removeMessages(101);
                        f4489d.removeMessages(100);
                        Message obtain = Message.obtain(f4489d, 101, QbSdk.f16251m);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                        AppMethodBeat.m2505o(64355);
                    }
                }
            }
        }
    }

    public static void stopDownload() {
        AppMethodBeat.m2504i(64360);
        if (f4494i) {
            AppMethodBeat.m2505o(64360);
            return;
        }
        TbsLog.m80434i(LOGTAG, "[TbsDownloader.stopDownload]");
        if (f4492g != null) {
            f4492g.mo57534c();
        }
        if (f4489d != null) {
            f4489d.removeMessages(100);
            f4489d.removeMessages(101);
            f4489d.removeMessages(108);
        }
        AppMethodBeat.m2505o(64360);
    }
}
