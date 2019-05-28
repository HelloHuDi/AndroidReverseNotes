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
import com.tencent.mm.plugin.appbrand.appstorage.ZipJNI;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsDownloadUpload.TbsUploadKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.TbsLogReport.EventType;
import com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.n;
import com.tencent.smtt.utils.o;
import com.tencent.smtt.utils.v;
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
    static boolean a;
    private static String b;
    private static Context c;
    private static Handler d;
    private static String e;
    private static Object f = new byte[0];
    private static ag g;
    private static HandlerThread h;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static long l = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i);
    }

    protected static File a(int i) {
        AppMethodBeat.i(64380);
        File file = null;
        for (String str : TbsShareManager.getCoreProviderAppList()) {
            if (!str.equals(c.getApplicationInfo().packageName)) {
                file = new File(k.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
                if (!file.exists()) {
                    TbsLog.i(LOGTAG, "can not find local backup core file");
                } else if (a.a(c, file) == i) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i(LOGTAG, "version is not match");
                }
            }
        }
        AppMethodBeat.o(64380);
        return file;
    }

    static String a(Context context) {
        AppMethodBeat.i(64377);
        String str;
        if (TextUtils.isEmpty(b)) {
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
            b = str;
            AppMethodBeat.o(64377);
            return str;
        }
        str = b;
        AppMethodBeat.o(64377);
        return str;
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static void a(JSONArray jSONArray) {
        AppMethodBeat.i(64367);
        for (String str : e()) {
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(c, str, true);
                if (packageContext == null || an.a().f(packageContext)) {
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
                    TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                }
            }
        }
        AppMethodBeat.o(64367);
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        int i = 0;
        AppMethodBeat.i(64364);
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        d.removeMessages(100);
        Message obtain = Message.obtain(d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        if (z) {
            i = 1;
        }
        obtain.arg1 = i;
        obtain.sendToTarget();
        AppMethodBeat.o(64364);
    }

    private static boolean a(Context context, boolean z, TbsDownloaderCallback tbsDownloaderCallback) {
        Matcher matcher = null;
        AppMethodBeat.i(64351);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (VERSION.SDK_INT < 8) {
            instance.setDownloadInterruptCode(ZipJNI.UNZ_PARAMERROR);
            AppMethodBeat.o(64351);
            return false;
        }
        if (!instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
            if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                z = false;
            }
            instance.a.put(TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
            instance.commit();
            j = z;
            TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = ".concat(String.valueOf(z)));
        }
        if (!getOverSea(context) || VERSION.SDK_INT == 16 || VERSION.SDK_INT == 17 || VERSION.SDK_INT == 18) {
            String string = instance.mPreferences.getString(TbsConfigKey.KEY_DEVICE_CPUABI, matcher);
            e = string;
            if (!TextUtils.isEmpty(string)) {
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
                } catch (Exception e) {
                }
                if (matcher != null && matcher.find()) {
                    if (tbsDownloaderCallback != null) {
                        tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                    }
                    instance.setDownloadInterruptCode(ZipJNI.UNZ_INTERNALERROR);
                    AppMethodBeat.o(64351);
                    return false;
                }
            }
            AppMethodBeat.o(64351);
            return true;
        }
        TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + VERSION.SDK_INT + ", and overea");
        if (tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        instance.setDownloadInterruptCode(ZipJNI.UNZ_BADZIPFILE);
        AppMethodBeat.o(64351);
        return false;
    }

    private static boolean a(Context context, boolean z, boolean z2) {
        boolean z3;
        TbsLogInfo tbsLogInfo;
        AppMethodBeat.i(64350);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        String str = null;
        if (!z) {
            String string = instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i = instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null);
            String a = b.a(c);
            int b = b.b(c);
            String a2 = b.a(c, TBS_METADATA);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + a + " oldAppVersionName=" + string + " appVersionCode=" + b + " oldAppVersionCode=" + i + " appMetadata=" + a2 + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j = instance.mPreferences.getLong(TbsConfigKey.KEY_LAST_CHECK, 0);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=".concat(String.valueOf(contains)));
                if (contains && j == 0) {
                    j = currentTimeMillis;
                }
            }
            long j2 = instance.mPreferences.getLong(TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0);
            long j3 = instance.mPreferences.getLong(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0);
            long retryInterval = instance.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(c).getEmergentCoreVersion();
            int i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (currentTimeMillis - j <= 1000 * retryInterval && ((emergentCoreVersion <= an.a().j(c) || emergentCoreVersion <= i2) && (!TbsShareManager.isThirdPartyApp(c) || j2 <= 0 || currentTimeMillis - j2 <= retryInterval * 1000 || j3 >= 11))) {
                if (TbsShareManager.isThirdPartyApp(c) && TbsShareManager.findCoreForThirdPartyApp(c) == 0 && !d()) {
                    an.a().d(c);
                    z3 = true;
                    tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                    tbsLogInfo.setErrorCode(-119);
                    tbsLogInfo.setFailDetail(str);
                    TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    AppMethodBeat.o(64350);
                    return z3;
                }
                String str2;
                if (a == null || b == 0 || a2 == null) {
                    if (TbsShareManager.isThirdPartyApp(c)) {
                        str2 = "timeNow - timeLastCheck is " + (currentTimeMillis - j) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(c) + " sendRequestWithSameHostCoreVersion() is " + d() + " appVersionName is " + a + " appVersionCode is " + b + " appMetadata is " + a2 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i + " oldAppVersionMetadata is " + string2;
                    }
                    str2 = null;
                } else {
                    if (!(a.equals(string) && b == i && a2.equals(string2))) {
                        z3 = true;
                        if (!z3 && TbsShareManager.isThirdPartyApp(c)) {
                            tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                            tbsLogInfo.setErrorCode(-119);
                            tbsLogInfo.setFailDetail(str);
                            TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                        }
                        AppMethodBeat.o(64350);
                        return z3;
                    }
                    str2 = null;
                }
                str = str2;
                z3 = false;
                tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                tbsLogInfo.setErrorCode(-119);
                tbsLogInfo.setFailDetail(str);
                TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                AppMethodBeat.o(64350);
                return z3;
            }
        }
        z3 = true;
        tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
        tbsLogInfo.setErrorCode(-119);
        tbsLogInfo.setFailDetail(str);
        TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
        AppMethodBeat.o(64350);
        return z3;
    }

    /* JADX WARNING: Missing block: B:127:0x0341, code skipped:
            if (r2 > 0) goto L_0x0343;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    @TargetApi(11)
    private static boolean a(String str, int i, boolean z, boolean z2) {
        AppMethodBeat.i(64375);
        TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] response=".concat(String.valueOf(str)));
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (TextUtils.isEmpty(str)) {
            if (z) {
                instance.setDownloadInterruptCode(-108);
            } else {
                instance.setDownloadInterruptCode(-208);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #1,response is empty...");
            AppMethodBeat.o(64375);
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
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #2,returnCode=".concat(String.valueOf(i2)));
            AppMethodBeat.o(64375);
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
        instance.a.put(TbsConfigKey.KEY_USE_BACKUP_VERSION, Integer.valueOf(i2));
        if (z && QbSdk.i && TbsShareManager.isThirdPartyApp(c)) {
            try {
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME, jSONObject.optInt("BUGLY", 0) == 1);
            } catch (Throwable th) {
                TbsLog.i("qbsdk", "throwable:" + th.toString());
            }
        }
        if (z) {
            try {
                optInt = jSONObject.optInt("TEMPLATESWITCH", 0);
                z3 = (optInt & 1) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME, z3);
                TbsLog.w(LOGTAG, "useCookieCompatiable:".concat(String.valueOf(z3)));
                z3 = (optInt & 2) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.DISABLE_GET_APK_VERSION_SWITCH_FILE_NAME, z3);
                TbsLog.w(LOGTAG, "disableGetApkVersionByReadFile:".concat(String.valueOf(z3)));
                z3 = (optInt & 4) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.DISABLE_UNPREINIT, z3);
                QbSdk.setDisableUnpreinitBySwitch(z3);
                TbsLog.i(LOGTAG, "disableUnpreinitBySwitch:".concat(String.valueOf(z3)));
                z3 = (optInt & 8) != 0;
                TbsExtensionFunctionManager.getInstance().setFunctionEnable(c, TbsExtensionFunctionManager.DISABLE_USE_HOST_BACKUP_CORE, z3);
                QbSdk.setDisableUseHostBackupCoreBySwitch(z3);
                TbsLog.i(LOGTAG, "disableUseHostBackupCoreBySwitch:".concat(String.valueOf(z3)));
            } catch (Throwable th2) {
                TbsLog.i("qbsdk", "throwable:" + th2.toString());
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
        synchronized (f) {
            if (obj2 != null) {
                try {
                    instance.a.put(TbsConfigKey.KEY_DESkEY_TOKEN, "");
                } catch (Throwable th3) {
                    while (true) {
                        AppMethodBeat.o(64375);
                    }
                }
            }
            if (!TextUtils.isEmpty(charSequence) && charSequence.length() == 96) {
                instance.a.put(TbsConfigKey.KEY_DESkEY_TOKEN, charSequence + "&" + o.c());
            }
        }
        if (i9 == 1) {
            if (z) {
                instance.setDownloadInterruptCode(-110);
            } else {
                instance.setDownloadInterruptCode(-210);
            }
            QbSdk.reset(c, optInt == 1);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #3,needResetTbs=1,isQuery=".concat(String.valueOf(z)));
            AppMethodBeat.o(64375);
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
            QbSdk.resetDecoupleCore(c);
        }
        if (i10 == 1) {
            d.removeMessages(104);
            Message.obtain(d, 104).sendToTarget();
        }
        if (optInt2 == 1) {
            j3 = optLong > 604800 ? 604800 : optLong;
        }
        j3 = TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
        if (getRetryIntervalInSeconds() >= 0) {
            j3 = getRetryIntervalInSeconds();
        }
        instance.a.put(TbsConfigKey.KEY_RETRY_INTERVAL, Long.valueOf(j3));
        i2 = 0;
        optInt = 0;
        if (z) {
            try {
                i2 = jSONObject.getInt("DECOUPLECOREVERSION");
            } catch (Exception e5) {
            }
        } else {
            i2 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
        }
        try {
            optInt = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0);
        } catch (Exception e6) {
        }
        if (z && !TbsShareManager.isThirdPartyApp(c) && r2 == 0) {
            i2 = an.a().i(c);
        }
        TbsLog.i(LOGTAG, "in response decoupleCoreVersion is ".concat(String.valueOf(i2)));
        instance.a.put(TbsConfigKey.KEY_DECOUPLECOREVERSION, Integer.valueOf(i2));
        instance.a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(optInt));
        if (!TbsShareManager.isThirdPartyApp(c)) {
            if (i2 > 0 && i2 != an.a().i(c) && i2 == an.a().j(c)) {
                an.a().o(c);
            } else if (i2 == 0) {
                try {
                    k.b(an.a().q(c));
                } catch (Throwable th4) {
                }
            }
        }
        if (TextUtils.isEmpty(string) && TbsShareManager.isThirdPartyApp(c)) {
            instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            instance.commit();
            if (z) {
                TbsShareManager.writeCoreInfoForThirdPartyApp(c, i4, false);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #4,current app is third app...");
            AppMethodBeat.o(64375);
            return false;
        }
        TbsLog.i(LOGTAG, "in response responseCode is ".concat(String.valueOf(i3)));
        if (i3 == 0) {
            instance.a.put(TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
            instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            if (z) {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-111));
            } else {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-211));
                instance.setDownloadInterruptCode(-211);
            }
            instance.commit();
            if (!TbsShareManager.isThirdPartyApp(c)) {
                startDecoupleCoreIfNeeded();
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] return #5,responseCode=0");
            AppMethodBeat.o(64375);
            return false;
        }
        int i11 = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (i11 > i4) {
            g.d();
            an.a().p(c);
        }
        Object obj3 = null;
        if (!TbsShareManager.isThirdPartyApp(c)) {
            int h = an.a().h(c);
            if (h >= i4) {
                obj3 = 1;
            }
            TbsLog.i(LOGTAG, "tmpCoreVersion is " + h + " tbsDownloadVersion is" + i4);
        }
        if ((i >= i4 || TextUtils.isEmpty(string) || obj3 != null) && optInt != 1) {
            instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            if (!z) {
                i2 = -212;
                if (TextUtils.isEmpty(string)) {
                    i2 = -217;
                } else if (i4 <= 0) {
                    i2 = -218;
                } else if (i >= i4) {
                    i2 = -219;
                }
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(i2));
                instance.setDownloadInterruptCode(i2);
            } else if (TextUtils.isEmpty(string)) {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-124));
            } else if (i4 <= 0) {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-125));
            } else if (i >= i4) {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-127));
            } else {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-112));
            }
            instance.commit();
            TbsLog.i(LOGTAG, "version error or downloadUrl empty ,return ahead tbsLocalVersion=" + i + " tbsDownloadVersion=" + i4 + " tbsLastDownloadVersion=" + i11 + " downloadUrl=" + string);
            AppMethodBeat.o(64375);
            return false;
        }
        if (!string.equals(instance.mPreferences.getString(TbsConfigKey.KEY_TBSDOWNLOADURL, null))) {
            g.d();
            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, Integer.valueOf(0));
            instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, Integer.valueOf(0));
        }
        instance.a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V, Integer.valueOf(i4));
        TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V is ".concat(String.valueOf(i4)));
        if (i4 > 0) {
            if (optInt == 1) {
                instance.a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, Integer.valueOf(1));
            } else {
                instance.a.put(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, Integer.valueOf(0));
            }
            TbsLog.i(LOGTAG, "put KEY_TBS_DOWNLOAD_V_TYPE is ".concat(String.valueOf(optInt)));
        }
        instance.a.put(TbsConfigKey.KEY_TBSDOWNLOADURL, string);
        instance.a.put(TbsConfigKey.KEY_DOWNLOADURL_LIST, optString);
        instance.a.put(TbsConfigKey.KEY_RESPONSECODE, Integer.valueOf(i3));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_MAXFLOW, Integer.valueOf(i5));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_MIN_FREE_SPACE, Integer.valueOf(i6));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_MAX_RETRYTIMES, Integer.valueOf(i7));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_FAILED_MAX_RETRYTIMES, Integer.valueOf(i8));
        instance.a.put(TbsConfigKey.KEY_DOWNLOAD_SINGLE_TIMEOUT, Long.valueOf(j));
        instance.a.put(TbsConfigKey.KEY_TBSAPKFILESIZE, Long.valueOf(j2));
        instance.commit();
        if (obj != null) {
            instance.a.put(TbsConfigKey.KEY_TBSAPK_MD5, obj);
        }
        if (z2 || !an.a().b(c, i4)) {
            TbsLogInfo tbsLogInfo;
            if (!z2) {
                ag agVar = g;
                z3 = i3 == 1 || i3 == 2;
                if (agVar.a(z2, z3)) {
                    instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                    tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                    tbsLogInfo.setErrorCode(100);
                    tbsLogInfo.setFailDetail("use local backup apk in needDownload" + g.a);
                    if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                        TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                    } else {
                        TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    }
                    TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##7 set needDownload=false");
                }
            }
            if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1 && g.a()) {
                instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
                tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                tbsLogInfo.setErrorCode(100);
                tbsLogInfo.setFailDetail("installDecoupleCoreFromBackup" + g.a);
                if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
                    TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                } else {
                    TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##8 set needDownload=false");
            } else {
                if (!z) {
                    instance.setDownloadInterruptCode(-216);
                }
                instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
                TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##9 set needDownload=true");
            }
        } else {
            if (z) {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-113));
            } else {
                instance.a.put(TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf(-213));
                instance.setDownloadInterruptCode(-213);
            }
            instance.a.put(TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
            TbsLog.i(LOGTAG, "[TbsDownloader.readResponse] ##6 set needDownload=false");
        }
        if (jSONObject.optInt("stop_pre_oat", 0) == 1) {
            instance.a.put(TbsConfigKey.KEY_STOP_PRE_OAT, Boolean.TRUE);
        }
        instance.commit();
        AppMethodBeat.o(64375);
        return true;
    }

    protected static File b(int i) {
        AppMethodBeat.i(64381);
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        File file = null;
        int length = coreProviderAppList.length;
        int i2 = 0;
        while (i2 < length) {
            String str = coreProviderAppList[i2];
            File file2 = new File(k.a(c, str, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (!file2.exists() || a.a(c, file2) != i) {
                file = new File(k.a(c, str, 4, false), "x5.tbs.decouple");
                if (file.exists() && a.a(c, file) == i) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                }
                i2++;
            } else {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                file = file2;
                break;
            }
        }
        AppMethodBeat.o(64381);
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
    private static JSONObject b(boolean z, boolean z2, boolean z3) {
        Object obj;
        Object simCountryIso;
        JSONObject jSONObject;
        int n;
        int i;
        boolean z4;
        boolean booleanValue;
        AppMethodBeat.i(64371);
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData]isQuery: " + z + " forDecoupleCore is " + z3);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        String a = a(c);
        String d = b.d(c);
        String c = b.c(c);
        String f = b.f(c);
        String str = "";
        String str2 = "";
        String id = TimeZone.getDefault().getID();
        if (id != null) {
            obj = id;
        } else {
            String obj2 = str;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) c.getSystemService("phone");
            if (telephonyManager != null) {
                simCountryIso = telephonyManager.getSimCountryIso();
                if (simCountryIso == null) {
                    str = str2;
                }
                jSONObject = new JSONObject();
                jSONObject.put("TIMEZONEID", obj2);
                jSONObject.put("COUNTRYISO", simCountryIso);
                jSONObject.put("PROTOCOLVERSION", 1);
                if (TbsShareManager.isThirdPartyApp(c)) {
                    n = an.a().n(c);
                    if (n == 0 && an.a().m(c)) {
                        n = -1;
                        if (TbsConfig.APP_QQ.equals(c.getApplicationInfo().packageName)) {
                            TbsDownloadUpload.clear();
                            TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(c);
                            instance2.a.put(TbsUploadKey.KEY_LOCAL_CORE_VERSION, Integer.valueOf(-1));
                            instance2.commit();
                            TbsPVConfig.releaseInstance();
                            if (TbsPVConfig.getInstance(c).getLocalCoreVersionMoreTimes() == 1) {
                                n = an.a().j(c);
                            }
                        }
                    }
                    TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] tbsLocalVersion=" + n + " isDownloadForeground=" + z2);
                    if (!z2) {
                        i = n;
                        if (z) {
                            jSONObject.put("FUNCTION", 2);
                        } else {
                            jSONObject.put("FUNCTION", i == 0 ? 0 : 1);
                        }
                        JSONArray f2;
                        if (TbsShareManager.isThirdPartyApp(c)) {
                            f2 = f();
                            jSONObject.put("TBSVLARR", f2);
                            instance.a.put(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, f2.toString());
                            instance.commit();
                            if (QbSdk.c) {
                                jSONObject.put("THIRDREQ", 1);
                            }
                        } else {
                            f2 = h();
                            if (Apn.getApnType(c) != 3 && f2.length() != 0 && i == 0 && z) {
                                jSONObject.put("TBSBACKUPARR", f2);
                            }
                        }
                        jSONObject.put("APPN", c.getPackageName());
                        jSONObject.put("APPVN", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                        jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                        jSONObject.put("APPMETA", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
                        jSONObject.put("TBSSDKV", 43644);
                        jSONObject.put("TBSV", i);
                        jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                        instance.a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
                        instance.commit();
                        if (i != 0) {
                            jSONObject.put("TBSBACKUPV", g.b());
                        }
                        jSONObject.put("CPU", e);
                        jSONObject.put("UA", a);
                        jSONObject.put("IMSI", a(d));
                        jSONObject.put("IMEI", a(c));
                        jSONObject.put("ANDROID_ID", a(f));
                        if (!TbsShareManager.isThirdPartyApp(c)) {
                            if (i != 0) {
                                jSONObject.put("STATUS", QbSdk.a(c, i) ? 0 : 1);
                            } else {
                                jSONObject.put("STATUS", 0);
                            }
                            jSONObject.put("TBSDV", an.a().i(c));
                        }
                        z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
                        simCountryIso = QbSdk.a(c, "can_unlzma", null);
                        booleanValue = (simCountryIso == null && (simCountryIso instanceof Boolean)) ? ((Boolean) simCountryIso).booleanValue() : false;
                        simCountryIso = booleanValue ? !z4 ? 1 : null : null;
                        if (simCountryIso != null) {
                            jSONObject.put("REQUEST_LZMA", 1);
                        }
                        if (getOverSea(c)) {
                            jSONObject.put("OVERSEA", 1);
                        }
                        if (z2) {
                            jSONObject.put("DOWNLOAD_FOREGROUND", 1);
                        }
                        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                        AppMethodBeat.o(64371);
                        return jSONObject;
                    } else if (!an.a().m(c)) {
                        n = 0;
                    }
                } else {
                    n = QbSdk.c ? TbsShareManager.a(c, false) : TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
                }
                i = n;
                if (z) {
                }
                if (TbsShareManager.isThirdPartyApp(c)) {
                }
                jSONObject.put("APPN", c.getPackageName());
                jSONObject.put("APPVN", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
                jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
                jSONObject.put("APPMETA", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
                jSONObject.put("TBSSDKV", 43644);
                jSONObject.put("TBSV", i);
                if (z3) {
                }
                jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
                if (z3) {
                }
                instance.a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
                instance.commit();
                if (i != 0) {
                }
                jSONObject.put("CPU", e);
                jSONObject.put("UA", a);
                jSONObject.put("IMSI", a(d));
                jSONObject.put("IMEI", a(c));
                jSONObject.put("ANDROID_ID", a(f));
                if (TbsShareManager.isThirdPartyApp(c)) {
                }
                z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
                simCountryIso = QbSdk.a(c, "can_unlzma", null);
                if (simCountryIso == null) {
                }
                if (booleanValue) {
                }
                if (simCountryIso != null) {
                }
                if (getOverSea(c)) {
                }
                if (z2) {
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
                AppMethodBeat.o(64371);
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
            if (TbsShareManager.isThirdPartyApp(c)) {
            }
            i = n;
            if (z) {
            }
            if (TbsShareManager.isThirdPartyApp(c)) {
            }
            jSONObject.put("APPN", c.getPackageName());
            jSONObject.put("APPVN", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_VERSIONNAME, null)));
            jSONObject.put("APPVC", instance.mPreferences.getInt(TbsConfigKey.KEY_APP_VERSIONCODE, 0));
            jSONObject.put("APPMETA", a(instance.mPreferences.getString(TbsConfigKey.KEY_APP_METADATA, null)));
            jSONObject.put("TBSSDKV", 43644);
            jSONObject.put("TBSV", i);
            if (z3) {
            }
            jSONObject.put("DOWNLOADDECOUPLECORE", z3 ? 1 : 0);
            if (z3) {
            }
            instance.a.put(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, Integer.valueOf(z3 ? 1 : 0));
            instance.commit();
            if (i != 0) {
            }
            jSONObject.put("CPU", e);
            jSONObject.put("UA", a);
            jSONObject.put("IMSI", a(d));
            jSONObject.put("IMEI", a(c));
            jSONObject.put("ANDROID_ID", a(f));
            if (TbsShareManager.isThirdPartyApp(c)) {
            }
            z4 = TbsDownloadConfig.getInstance(c).mPreferences.getBoolean(TbsConfigKey.KEY_FULL_PACKAGE, false);
            simCountryIso = QbSdk.a(c, "can_unlzma", null);
            if (simCountryIso == null) {
            }
            if (booleanValue) {
            }
            if (simCountryIso != null) {
            }
            if (getOverSea(c)) {
            }
            if (z2) {
            }
        } catch (Exception e2) {
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.postJsonData] jsonData=" + jSONObject.toString());
        AppMethodBeat.o(64371);
        return jSONObject;
    }

    @TargetApi(11)
    static void b(Context context) {
        AppMethodBeat.i(64378);
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        ag.c(context);
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_extension_config", 4) : context.getSharedPreferences("tbs_extension_config", 0)).edit().clear().commit();
        (VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0)).edit().clear().commit();
        AppMethodBeat.o(64378);
    }

    private static void b(JSONArray jSONArray) {
        Object obj = null;
        AppMethodBeat.i(64368);
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a = an.a().a(TbsShareManager.getHostCorePathAppDefined());
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
        AppMethodBeat.o(64368);
    }

    private static boolean b(boolean z, boolean z2) {
        AppMethodBeat.i(64373);
        boolean c = c(z, z2, false);
        AppMethodBeat.o(64373);
        return c;
    }

    private static synchronized void c() {
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(64363);
            if (h == null) {
                h = al.a();
                try {
                    g = new ag(c);
                    d = new aj(h.getLooper());
                } catch (Exception e) {
                    i = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
                    AppMethodBeat.o(64363);
                }
            }
            AppMethodBeat.o(64363);
        }
        return;
    }

    private static void c(JSONArray jSONArray) {
        AppMethodBeat.i(64370);
        if (!TbsPVConfig.getInstance(c).isDisableHostBackupCore()) {
            for (String str : e()) {
                Context packageContext;
                int i;
                boolean z;
                int backupCoreVersion = TbsShareManager.getBackupCoreVersion(c, str);
                if (backupCoreVersion > 0) {
                    packageContext = TbsShareManager.getPackageContext(c, str, false);
                    if (packageContext == null || an.a().f(packageContext)) {
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
                        TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                    }
                }
                backupCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(c, str);
                if (backupCoreVersion > 0) {
                    packageContext = TbsShareManager.getPackageContext(c, str, false);
                    if (packageContext == null || an.a().f(packageContext)) {
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
                        TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                    }
                }
            }
        }
        AppMethodBeat.o(64370);
    }

    private static boolean c(boolean z, boolean z2, boolean z3) {
        TbsDownloadUpload instance;
        AppMethodBeat.i(64374);
        if (z) {
            instance = TbsDownloadUpload.getInstance(c);
            instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(144));
            instance.commit();
        } else if (!z3) {
            instance = TbsDownloadUpload.getInstance(c);
            instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_5));
            instance.commit();
        }
        if (QbSdk.n != null && QbSdk.n.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) && QbSdk.n.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            if (z) {
                instance = TbsDownloadUpload.getInstance(c);
                instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(145));
                instance.commit();
            } else if (!z3) {
                instance = TbsDownloadUpload.getInstance(c);
                instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_6));
                instance.commit();
            }
            AppMethodBeat.o(64374);
            return false;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
        if (an.a().c(c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
            if (z) {
                instance = TbsDownloadUpload.getInstance(c);
                instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(146));
                instance.commit();
            } else if (!z3) {
                instance = TbsDownloadUpload.getInstance(c);
                instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(166));
                instance.commit();
            }
            AppMethodBeat.o(64374);
            return false;
        }
        int i;
        boolean a;
        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(c);
        File file = new File(k.a(c, 1), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file2 = new File(k.a(c, 2), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file3 = new File(k.a(c, 3), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        File file4 = new File(k.a(c, 4), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
        if (!file4.exists()) {
            if (file3.exists()) {
                file3.renameTo(file4);
            } else if (file2.exists()) {
                file2.renameTo(file4);
            } else if (file.exists()) {
                file.renameTo(file4);
            }
        }
        if (e == null) {
            e = b.a();
            instance2.a.put(TbsConfigKey.KEY_DEVICE_CPUABI, e);
            instance2.commit();
        }
        Object obj = null;
        if (!TextUtils.isEmpty(e)) {
            Matcher matcher = null;
            try {
                matcher = Pattern.compile("i686|mips|x86_64").matcher(e);
            } catch (Exception e) {
            }
            if (matcher != null && matcher.find()) {
                if (TbsShareManager.isThirdPartyApp(c)) {
                    TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(c).tbsLogInfo();
                    if (z) {
                        instance2.setDownloadInterruptCode(ZipJNI.UNZ_INTERNALERROR);
                        tbsLogInfo.setErrorCode(ZipJNI.UNZ_INTERNALERROR);
                    } else {
                        instance2.setDownloadInterruptCode(-205);
                        tbsLogInfo.setErrorCode(-205);
                    }
                    tbsLogInfo.setFailDetail("mycpu is " + e);
                    TbsLogReport.getInstance(c).eventReport(EventType.TYPE_DOWNLOAD, tbsLogInfo);
                } else if (z) {
                    instance2.setDownloadInterruptCode(ZipJNI.UNZ_INTERNALERROR);
                } else {
                    instance2.setDownloadInterruptCode(-205);
                }
                obj = 1;
            }
        }
        instance2.a.put(TbsConfigKey.KEY_APP_VERSIONNAME, b.a(c));
        instance2.a.put(TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.b(c)));
        instance2.commit();
        JSONObject b = b(z, z2, z3);
        int i2 = -1;
        try {
            i = b.getInt("TBSV");
        } catch (Exception e2) {
            i = i2;
        }
        if (!(obj == null && i == -1)) {
            long currentTimeMillis = System.currentTimeMillis();
            if (TbsShareManager.isThirdPartyApp(c)) {
                instance2.a.put(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(currentTimeMillis - instance2.mPreferences.getLong(TbsConfigKey.KEY_REQUEST_FAIL, 0) < instance2.getRetryInterval() * 1000 ? 1 + instance2.mPreferences.getLong(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0) : 1));
            }
            instance2.a.put(TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(currentTimeMillis));
            instance2.a.put(TbsConfigKey.KEY_APP_VERSIONNAME, b.a(c));
            instance2.a.put(TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.b(c)));
            instance2.a.put(TbsConfigKey.KEY_APP_METADATA, b.a(c, TBS_METADATA));
            instance2.commit();
            if (obj != null) {
                if (z) {
                    instance = TbsDownloadUpload.getInstance(c);
                    instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_8));
                    instance.commit();
                } else if (!z3) {
                    instance = TbsDownloadUpload.getInstance(c);
                    instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_8));
                    instance.commit();
                }
                AppMethodBeat.o(64374);
                return false;
            }
        }
        if (i != -1) {
            try {
                String d = v.a(c).d();
                TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(d)));
                TbsDownloadUpload instance3;
                if (z) {
                    instance3 = TbsDownloadUpload.getInstance(c);
                    instance3.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(148));
                    instance3.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, Integer.valueOf(1));
                    instance3.commit();
                    TbsLog.i(LOGTAG, "sendRequest query 148");
                } else if (!z3) {
                    instance3 = TbsDownloadUpload.getInstance(c);
                    instance3.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(168));
                    instance3.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_SENT, Integer.valueOf(1));
                    instance3.commit();
                    TbsLog.i(LOGTAG, "sendRequest download 168");
                }
                a = a(n.a(d, b.toString().getBytes(ProtocolPackage.ServerEncoding), new ak(instance2, z), false), i, z, z2);
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
            instance = TbsDownloadUpload.getInstance(c);
            instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(149));
            instance.commit();
            a = false;
        } else {
            if (!z3) {
                instance = TbsDownloadUpload.getInstance(c);
                instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(169));
                instance.commit();
            }
            a = false;
        }
        AppMethodBeat.o(64374);
        return a;
    }

    private static boolean d() {
        AppMethodBeat.i(64365);
        try {
            boolean equals = TbsDownloadConfig.getInstance(c).mPreferences.getString(TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(f().toString());
            AppMethodBeat.o(64365);
            return equals;
        } catch (Exception e) {
            AppMethodBeat.o(64365);
            return false;
        }
    }

    private static String[] e() {
        String[] strArr;
        AppMethodBeat.i(64366);
        if (QbSdk.getOnlyDownload()) {
            strArr = new String[]{c.getApplicationContext().getPackageName()};
        } else {
            String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
            String packageName = c.getApplicationContext().getPackageName();
            if (packageName.equals(TbsShareManager.f(c))) {
                int length = coreProviderAppList.length;
                strArr = new String[(length + 1)];
                System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
                strArr[length] = packageName;
            } else {
                strArr = coreProviderAppList;
            }
        }
        AppMethodBeat.o(64366);
        return strArr;
    }

    private static JSONArray f() {
        AppMethodBeat.i(64369);
        if (TbsShareManager.isThirdPartyApp(c)) {
            JSONArray jSONArray = new JSONArray();
            a(jSONArray);
            c(jSONArray);
            b(jSONArray);
            AppMethodBeat.o(64369);
            return jSONArray;
        }
        AppMethodBeat.o(64369);
        return null;
    }

    private static boolean g() {
        AppMethodBeat.i(64379);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
        if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            instance.setDownloadInterruptCode(-115);
            AppMethodBeat.o(64379);
            return false;
        } else if (instance.mPreferences.getInt(TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            instance.setDownloadInterruptCode(-116);
            AppMethodBeat.o(64379);
            return false;
        } else if (k.b(c)) {
            if (System.currentTimeMillis() - instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= 86400000) {
                long j = instance.mPreferences.getLong(TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=".concat(String.valueOf(j)));
                if (j >= instance.getDownloadMaxflow()) {
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    instance.setDownloadInterruptCode(-120);
                    AppMethodBeat.o(64379);
                    return false;
                }
            }
            AppMethodBeat.o(64379);
            return true;
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            instance.setDownloadInterruptCode(-117);
            AppMethodBeat.o(64379);
            return false;
        }
    }

    public static int getCoreShareDecoupleCoreVersion() {
        AppMethodBeat.i(64357);
        int i = an.a().i(c);
        AppMethodBeat.o(64357);
        return i;
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        AppMethodBeat.i(64356);
        int i = an.a().i(context);
        AppMethodBeat.o(64356);
        return i;
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(64372);
            if (!k) {
                k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains(TbsConfigKey.KEY_IS_OVERSEA)) {
                    j = instance.mPreferences.getBoolean(TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + j);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + j);
            }
            z = j;
            AppMethodBeat.o(64372);
        }
        return z;
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return h;
    }

    private static JSONArray h() {
        AppMethodBeat.i(64382);
        JSONArray jSONArray = new JSONArray();
        for (String a : TbsShareManager.getCoreProviderAppList()) {
            File file = new File(k.a(c, a, 4, false), getOverSea(c) ? "x5.oversea.tbs.org" : "x5.tbs.org");
            if (file.exists()) {
                long a2 = (long) a.a(c, file);
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
        AppMethodBeat.o(64382);
        return jSONArray;
    }

    public static boolean isDownloadForeground() {
        AppMethodBeat.i(64362);
        if (g == null || !g.e()) {
            AppMethodBeat.o(64362);
            return false;
        }
        AppMethodBeat.o(64362);
        return true;
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(64361);
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + a);
            z = a;
            AppMethodBeat.o(64361);
        }
        return z;
    }

    public static boolean needDownload(Context context, boolean z) {
        AppMethodBeat.i(64352);
        boolean needDownload = needDownload(context, z, false, null);
        AppMethodBeat.o(64352);
        return needDownload;
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        AppMethodBeat.i(64353);
        TbsDownloadUpload.clear();
        TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
        instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(140));
        instance.commit();
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        TbsLog.initIfNeed(context);
        if (an.b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_FALSE_1));
            instance.commit();
            AppMethodBeat.o(64353);
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        c = applicationContext;
        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(applicationContext);
        instance2.setDownloadInterruptCode(-100);
        if (a(c, z, tbsDownloaderCallback)) {
            c();
            if (i) {
                if (tbsDownloaderCallback != null) {
                    tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
                }
                instance2.setDownloadInterruptCode(ZipJNI.UNZ_CRCERROR);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
                instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_3));
                instance.commit();
                instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_FALSE_3));
                instance.commit();
                AppMethodBeat.o(64353);
                return false;
            }
            boolean contains;
            boolean z3;
            boolean z4;
            boolean a = a(c, z2, false);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=".concat(String.valueOf(a)));
            if (a) {
                a(z2, tbsDownloaderCallback);
                instance2.setDownloadInterruptCode(-114);
            } else {
                instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_4));
                instance.commit();
            }
            d.removeMessages(102);
            Message.obtain(d, 102).sendToTarget();
            if (QbSdk.c || !TbsShareManager.isThirdPartyApp(context)) {
                contains = instance2.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=".concat(String.valueOf(contains)));
                z3 = (contains || TbsShareManager.isThirdPartyApp(context)) ? instance2.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false) : true;
            } else {
                z3 = false;
                contains = false;
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z3 + ",hasNeedDownloadKey=" + contains);
            if (!z3) {
                int n = an.a().n(c);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + n + ",needSendRequest=" + a);
                if (a || n <= 0) {
                    d.removeMessages(103);
                    if (n > 0 || a) {
                        Message.obtain(d, 103, 1, 0, c).sendToTarget();
                    } else {
                        Message.obtain(d, 103, 0, 0, c).sendToTarget();
                    }
                    instance2.setDownloadInterruptCode(-121);
                    z4 = z3;
                } else {
                    instance2.setDownloadInterruptCode(-119);
                    z4 = z3;
                }
            } else if (g()) {
                instance2.setDownloadInterruptCode(-118);
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
                z4 = z3;
            } else {
                TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
                z4 = false;
            }
            if (!(a || tbsDownloaderCallback == null)) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(z4)));
            instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z4 ? ErrorCode.NEEDDOWNLOAD_TRUE : ErrorCode.NEEDDOWNLOAD_FALSE_4));
            instance.commit();
            AppMethodBeat.o(64353);
            return z4;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
        instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(141));
        instance.commit();
        instance.a.put(TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(ErrorCode.NEEDDOWNLOAD_FALSE_2));
        instance.commit();
        AppMethodBeat.o(64353);
        return false;
    }

    public static boolean needDownloadDecoupleCore() {
        AppMethodBeat.i(64358);
        if (TbsShareManager.isThirdPartyApp(c)) {
            AppMethodBeat.o(64358);
            return false;
        } else if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            AppMethodBeat.o(64358);
            return false;
        } else {
            long j = TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
            if (System.currentTimeMillis() - j < 1000 * TbsDownloadConfig.getInstance(c).getRetryInterval()) {
                AppMethodBeat.o(64358);
                return false;
            }
            int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            if (i <= 0 || i == an.a().i(c) || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i) {
                AppMethodBeat.o(64358);
                return false;
            }
            AppMethodBeat.o(64358);
            return true;
        }
    }

    public static boolean needSendRequest(Context context, boolean z) {
        boolean z2 = true;
        AppMethodBeat.i(64349);
        c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (a(c, z, null)) {
            int n = an.a().n(context);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(n)));
            if (n > 0) {
                AppMethodBeat.o(64349);
                return false;
            } else if (a(c, false, true)) {
                AppMethodBeat.o(64349);
                return true;
            } else {
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(c);
                boolean contains = instance.mPreferences.contains(TbsConfigKey.KEY_NEEDDOWNLOAD);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=".concat(String.valueOf(contains)));
                boolean z3 = !contains ? true : instance.mPreferences.getBoolean(TbsConfigKey.KEY_NEEDDOWNLOAD, false);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=".concat(String.valueOf(z3)));
                if (!(z3 && g())) {
                    z2 = false;
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=".concat(String.valueOf(z2)));
                AppMethodBeat.o(64349);
                return z2;
            }
        }
        AppMethodBeat.o(64349);
        return false;
    }

    public static void setAppContext(Context context) {
        AppMethodBeat.i(64348);
        if (!(context == null || context.getApplicationContext() == null)) {
            c = context.getApplicationContext();
        }
        AppMethodBeat.o(64348);
    }

    public static void setRetryIntervalInSeconds(Context context, long j) {
        AppMethodBeat.i(64376);
        if (context == null) {
            AppMethodBeat.o(64376);
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            l = j;
        }
        TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
        AppMethodBeat.o(64376);
    }

    public static boolean startDecoupleCoreIfNeeded() {
        AppMethodBeat.i(64359);
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(c)) {
            AppMethodBeat.o(64359);
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            AppMethodBeat.o(64359);
            return false;
        } else if (d == null) {
            AppMethodBeat.o(64359);
            return false;
        } else {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
            long j = TbsDownloadConfig.getInstance(c).mPreferences.getLong(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
            if (System.currentTimeMillis() - j < 1000 * TbsDownloadConfig.getInstance(c).getRetryInterval()) {
                AppMethodBeat.o(64359);
                return false;
            }
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
            int i = TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            if (i <= 0 || i == an.a().i(c)) {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i + " getTbsCoreShareDecoupleCoreVersion is " + an.a().i(c));
            } else if (TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i || TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
                a = true;
                d.removeMessages(108);
                Message obtain = Message.obtain(d, 108, QbSdk.m);
                obtain.arg1 = 0;
                obtain.sendToTarget();
                TbsDownloadConfig.getInstance(c).a.put(TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(64359);
                return true;
            } else {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + " deCoupleCoreVersion is " + i + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(c).mPreferences.getInt(TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0));
            }
            AppMethodBeat.o(64359);
            return false;
        }
    }

    public static void startDownload(Context context) {
        AppMethodBeat.i(64354);
        startDownload(context, false);
        AppMethodBeat.o(64354);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        int i = 1;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(64355);
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
            instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(160));
            instance.commit();
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + c);
            if (an.b) {
                instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(161));
                instance.commit();
                AppMethodBeat.o(64355);
            } else {
                a = true;
                Context applicationContext = context.getApplicationContext();
                c = applicationContext;
                TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
                if (VERSION.SDK_INT < 8) {
                    QbSdk.m.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-201);
                    instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_3));
                    instance.commit();
                    AppMethodBeat.o(64355);
                } else {
                    c();
                    if (i) {
                        QbSdk.m.onDownloadFinish(121);
                        TbsDownloadConfig.getInstance(c).setDownloadInterruptCode(-202);
                        instance.a.put(TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(ErrorCode.STARTDOWNLOAD_4));
                        instance.commit();
                        AppMethodBeat.o(64355);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        d.removeMessages(101);
                        d.removeMessages(100);
                        Message obtain = Message.obtain(d, 101, QbSdk.m);
                        if (!z) {
                            i = 0;
                        }
                        obtain.arg1 = i;
                        obtain.sendToTarget();
                        AppMethodBeat.o(64355);
                    }
                }
            }
        }
    }

    public static void stopDownload() {
        AppMethodBeat.i(64360);
        if (i) {
            AppMethodBeat.o(64360);
            return;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        if (g != null) {
            g.c();
        }
        if (d != null) {
            d.removeMessages(100);
            d.removeMessages(101);
            d.removeMessages(108);
        }
        AppMethodBeat.o(64360);
    }
}
