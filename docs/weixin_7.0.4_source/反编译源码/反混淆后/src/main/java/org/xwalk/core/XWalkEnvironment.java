package org.xwalk.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.webkit.WebView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.view.C31128d;
import com.tencent.xweb.C16384e;
import com.tencent.xweb.C31146m;
import com.tencent.xweb.WebView.C44570d;
import com.tencent.xweb.p1115c.C44581k;
import com.tencent.xweb.util.C24532f;
import com.tencent.xweb.util.C41131b;
import com.tencent.xweb.xwalk.p686a.C36602e;
import dalvik.system.DexClassLoader;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class XWalkEnvironment {
    private static final String APK_DIR = "apk";
    public static final String DOWNLOAD_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig.xml";
    public static final String DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL = "http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml";
    public static final String DOWNLOAD_PLUGIN_UPDATE_TEST_CONFIG_DEFAULT_URL = "http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig_test.xml";
    public static final String DOWNLOAD_X86_CONFIG_URL = "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86.xml";
    public static final int LOCAL_TEST_VERSION = 100000;
    public static final String LOCAL_TEST_ZIP_NAME = "runtime_package.zip";
    public static final String[] MANDATORY_RESOURCES = new String[]{XWALK_CORE_CLASSES_DEX, "icudtl.dat", "xwalk.pak", "xwalk_100_percent.pak", "xweb_fullscreen_video.js"};
    private static final String META_XWALK_DOWNCONFIG_URL = "xwalk_downconfig_url";
    public static final String MM_PACKAGE_NAME = "com.tencent.mm";
    private static final String OPTIMIZED_DEX_DIR = "dex";
    private static final String PACKAGE_RE = "[a-z]+\\.[a-z0-9]+\\.[a-z0-9]+.*";
    private static final String PATCH_ZIP_TEMP_DECOMPRESS_DIR = "patch_temp_decompress";
    public static final int SDK_SUPPORT_INVOKE_NOTIFY_MIN_APKVERSION = 153;
    public static final int SDK_SUPPORT_INVOKE_RUNTIME_MIN_APKVERSION = 255;
    public static final int SDK_SUPPORT_MIN_APKVERSION = 49;
    public static final int SDK_VERSION = 190301;
    private static final int SPECIAL_TEST_USER_ID = 10001;
    private static final String SP_KEY_DEVICE_RD = "sNDeviceRd";
    private static final String SP_KEY_FILE_READER_RECORD = "xwalk_reader_record";
    private static final String SP_KEY_GRAY_VALUE = "GRAY_VALUE";
    private static final String SP_KEY_GRAY_VALUE_TEST = "TEST_GRAY_VALUE";
    private static final String SP_KEY_IP_TYPE = "IP_TYPE";
    public static final String SP_KEY_PLUGIN_AVAILABLE_VERSION = "availableVersion";
    private static final String SP_KEY_PLUGIN_TEST_CONFIG_URL = "XWEB_PLUGIN_TEST_CONFIG_URL";
    public static final String SP_KEY_PLUGIN_UPDATE_CONFIG_LAST_FETCH_TIME = "nLastFetchPluginConfigTime";
    public static final String SP_KEY_PLUGIN_UPDATE_PROCESS_ID = "nUpdatingProcessId";
    private static final String SP_NAME_PLUGIN_UPDATE_INFO = "xwalk_plugin_update_info";
    private static final String SP_NAME_PLUGIN_VERSION_INFO_PREFIX = "xwalk_plugin_version_info_";
    private static final String SP_NAME_VERSION_INFO = "XWALKINFOS";
    private static final String TAG = "XWalkEnvironment";
    public static final int TEST_APK_START_VERSION = 100000;
    public static String UPDATEINFOTAG = "xwalk_update_info";
    public static final String XWALK_CORE_APK_NAME = "base.apk";
    public static final String XWALK_CORE_CLASSES_DEX = "classes.dex";
    private static final String XWALK_CORE_EXTRACTED_DIR = "extracted_xwalkcore";
    public static final String XWALK_CORE_FILELIST_CONFIG_NAME = "filelist.config";
    private static final String XWALK_CORE_NAME_PREFIX = "xwalk_";
    private static final String XWALK_CORE_PATCH_CONFIG_NAME = "patch.config";
    private static final String XWALK_CORE_PATCH_NAME = "patch.zip";
    public static final String[] XWALK_CORE_PROVIDER_LIST = new String[]{"com.tencent.mm"};
    private static final String XWALK_CORE_RES_FILELIST_CONFIG_NAME = "reslist.config";
    private static final String XWALK_CORE_ZIP_NAME = "base.zip";
    public static final String XWALK_ENV_MAP_KEY_ISGPVERSION = "isgpversion";
    public static final String XWALK_ENV_MAP_KEY_PROCESSNAME = "processname";
    public static final int XWALK_GET_FROM_PROVIDER_MAX_COUNT = 2;
    private static final String XWALK_PLUGIN_BASE_DIR = "xwalkplugin";
    public static final String XWALK_PLUGIN_NAME_FILE_READER = "FileReader";
    public static final String XWALK_PLUGIN_NAME_FULL_SCREEN_VIDEO = "FullScreenVideo";
    private static final String XWALK_PLUGIN_UPDATE_CONFIG_NAME = "pluginUpdateConfig.xml";
    private static final String XWALK_UPDATE_CONFIG_DIR = "xwalkconfig";
    private static final String ZIP_DIR = "zip";
    private static Context sApplicationContext;
    private static String sApplicationName;
    private static int sAvailableVersion = -1;
    static boolean sBHasInitedSafePsProvider = false;
    static boolean sBIsIpTypeChanged = false;
    private static String sDeviceAbi;
    private static Boolean sIsDownloadMode = Boolean.TRUE;
    private static Boolean sIsDownloadModeUpdate = Boolean.TRUE;
    private static boolean sIsForbidDownloadCode = false;
    private static boolean sIsPluginInited = false;
    private static Boolean sIsXWalkVerify;
    static Method sMMKVMethod;
    static int sNChromiuVersion = -1;
    static int sNDeviceRd = 0;
    static int sPid = Process.myPid();
    private static String sRuntimeAbi;
    static C16384e sSPProvider = null;
    static String sStrCurentProcessName;
    static String sStrDeviceId = null;
    private static String sStrTempUpdateConfigUrl;
    private static String sStrVersionDetail;
    private static boolean sUsingCustomContext = false;
    private static String sXWalkApkUrl;
    private static String sXWalkDownConfigUrl;
    static HashMap<String, Object> sXWebArgs;
    static int s_grayValue = 0;

    static {
        AppMethodBeat.m2504i(4296);
        AppMethodBeat.m2505o(4296);
    }

    public static void init(Context context) {
        AppMethodBeat.m2504i(4199);
        if (context == null || sApplicationContext != null) {
            AppMethodBeat.m2505o(4199);
            return;
        }
        sApplicationContext = context.getApplicationContext();
        if (sAvailableVersion == -1) {
            sAvailableVersion = getSharedPreferencesForVersionInfo().getInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
            sStrVersionDetail = getSharedPreferencesForVersionInfo().getString("versionDetail", "");
            if (sAvailableVersion != -1) {
                getSharedPreferences().edit().putString("XWALK_CORE_EXTRACTED_DIR", getExtractedCoreDir(sAvailableVersion)).commit();
            }
        }
        if (!sIsPluginInited) {
            sIsPluginInited = initXWalkPlugins();
        }
        C31146m.m50231jy(context);
        AppMethodBeat.m2505o(4199);
    }

    private static boolean initXWalkPlugins() {
        AppMethodBeat.m2504i(4200);
        boolean dVP = C36602e.dVP();
        AppMethodBeat.m2505o(4200);
        return dVP;
    }

    public static boolean isForbidDownloadCode() {
        return sIsForbidDownloadCode;
    }

    public static void setIsForbidDownloadCode(boolean z) {
        AppMethodBeat.m2504i(4201);
        sIsForbidDownloadCode = z;
        addXWalkInitializeLog(TAG, "setIsForbidDownloadCode: " + sIsForbidDownloadCode);
        AppMethodBeat.m2505o(4201);
    }

    static void initSafePsProvider() {
        AppMethodBeat.m2504i(4202);
        if (sBHasInitedSafePsProvider) {
            AppMethodBeat.m2505o(4202);
            return;
        }
        try {
            sMMKVMethod = Class.forName("com.tencent.mm.cj.b").getMethod("getMMKV", new Class[]{Context.class, String.class, Integer.TYPE, Boolean.TYPE});
        } catch (Exception e) {
        }
        if (sMMKVMethod == null) {
            C24532f.m38181nI(178);
            Log.m81046e(TAG, "initSafePsProvider failed");
        } else {
            Log.m81049i(TAG, "initSafePsProvider suscsess");
        }
        sBHasInitedSafePsProvider = true;
        AppMethodBeat.m2505o(4202);
    }

    public static synchronized void setXWebInitArgs(HashMap hashMap) {
        synchronized (XWalkEnvironment.class) {
            sXWebArgs = hashMap;
        }
    }

    public static synchronized Object getXWebInitArgs(String str) {
        Object obj;
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.m2504i(4203);
            if (sXWebArgs == null || !sXWebArgs.containsKey(str)) {
                obj = null;
                AppMethodBeat.m2505o(4203);
            } else {
                obj = sXWebArgs.get(str);
                AppMethodBeat.m2505o(4203);
            }
        }
        return obj;
    }

    public static synchronized boolean getXWebInitArgs(String str, boolean z) {
        synchronized (XWalkEnvironment.class) {
            AppMethodBeat.m2504i(4204);
            Object xWebInitArgs = getXWebInitArgs(str);
            if (xWebInitArgs == null) {
                AppMethodBeat.m2505o(4204);
            } else {
                try {
                    z = Boolean.valueOf(xWebInitArgs.toString()).booleanValue();
                    AppMethodBeat.m2505o(4204);
                } catch (Exception e) {
                    Log.m81046e(TAG, "getXWebInitArgs boolean parse failed");
                    AppMethodBeat.m2505o(4204);
                }
            }
        }
        return z;
    }

    public static SharedPreferences getProcessSafePreferences(String str, int i) {
        AppMethodBeat.m2504i(4205);
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences(str, i);
        AppMethodBeat.m2505o(4205);
        return sharedPreferences;
    }

    public static synchronized void setSharedPreferenceProvider(C16384e c16384e) {
        synchronized (XWalkEnvironment.class) {
            if (c16384e != null) {
                sSPProvider = c16384e;
            }
        }
    }

    public static SharedPreferences getMMKVSharedPreferences(String str) {
        AppMethodBeat.m2504i(4206);
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx(str, 4, false);
        AppMethodBeat.m2505o(4206);
        return mMKVSharedPreferencesEx;
    }

    public static SharedPreferences getMMKVSharedTransportOld(String str) {
        AppMethodBeat.m2504i(4207);
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx(str, 4, true);
        AppMethodBeat.m2505o(4207);
        return mMKVSharedPreferencesEx;
    }

    public static SharedPreferences getMMKVSharedPreferencesEx(String str, int i, boolean z) {
        SharedPreferences x;
        AppMethodBeat.m2504i(4208);
        if (sSPProvider != null) {
            try {
                C16384e c16384e = sSPProvider;
                getApplicationContext();
                x = c16384e.mo4784x(str, i, z);
            } catch (Exception e) {
                Log.m81046e(TAG, "got sp from mmkv callback failed " + e.getMessage());
                x = null;
            }
            if (x != null) {
                AppMethodBeat.m2505o(4208);
                return x;
            }
            C24532f.m38181nI(176);
        } else {
            C24532f.m38181nI(177);
        }
        initSafePsProvider();
        if (sMMKVMethod == null) {
            x = sApplicationContext.getSharedPreferences(str, i);
            AppMethodBeat.m2505o(4208);
            return x;
        }
        try {
            Object invoke = sMMKVMethod.invoke(null, new Object[]{getApplicationContext(), str, Integer.valueOf(i), Boolean.valueOf(z)});
            if (invoke == null || !(invoke instanceof SharedPreferences)) {
                Log.m81046e(TAG, "get mmmkv from reflection failed");
                C24532f.m38181nI(179);
                x = sApplicationContext.getSharedPreferences(str, i);
                AppMethodBeat.m2505o(4208);
                return x;
            }
            x = (SharedPreferences) invoke;
            AppMethodBeat.m2505o(4208);
            return x;
        } catch (Exception e2) {
        }
    }

    public static SharedPreferences getSharedPreferencesForUpdateConfig() {
        AppMethodBeat.m2504i(4209);
        SharedPreferences processSafePreferences = getProcessSafePreferences("UPDATEINFOTAG", 4);
        AppMethodBeat.m2505o(4209);
        return processSafePreferences;
    }

    public static SharedPreferences getSharedPreferencesForVersionInfo() {
        AppMethodBeat.m2504i(4210);
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences(SP_NAME_VERSION_INFO, 4);
        AppMethodBeat.m2505o(4210);
        return sharedPreferences;
    }

    public static SharedPreferences getSharedPreferencesForLog() {
        AppMethodBeat.m2504i(4211);
        if (sApplicationContext == null) {
            AppMethodBeat.m2505o(4211);
            return null;
        }
        SharedPreferences mMKVSharedPreferencesEx = getMMKVSharedPreferencesEx("UPDATELOG", 4, true);
        AppMethodBeat.m2505o(4211);
        return mMKVSharedPreferencesEx;
    }

    public static SharedPreferences getSharedPreferencesForPluginUpdateInfo() {
        AppMethodBeat.m2504i(4212);
        if (sApplicationContext == null) {
            AppMethodBeat.m2505o(4212);
            return null;
        }
        SharedPreferences processSafePreferences = getProcessSafePreferences(SP_NAME_PLUGIN_UPDATE_INFO, 4);
        AppMethodBeat.m2505o(4212);
        return processSafePreferences;
    }

    public static SharedPreferences getSharedPreferencesForPluginVersionInfo(String str) {
        AppMethodBeat.m2504i(4213);
        if (sApplicationContext == null) {
            AppMethodBeat.m2505o(4213);
            return null;
        }
        SharedPreferences processSafePreferences = getProcessSafePreferences(SP_NAME_PLUGIN_VERSION_INFO_PREFIX.concat(String.valueOf(str)), 4);
        AppMethodBeat.m2505o(4213);
        return processSafePreferences;
    }

    public static SharedPreferences getSharedPreferencesForFileReaderRecord() {
        AppMethodBeat.m2504i(4214);
        if (sApplicationContext == null) {
            AppMethodBeat.m2505o(4214);
            return null;
        }
        SharedPreferences processSafePreferences = getProcessSafePreferences(SP_KEY_FILE_READER_RECORD, 4);
        AppMethodBeat.m2505o(4214);
        return processSafePreferences;
    }

    public static String getPluginUpdateConfigFilePath() {
        AppMethodBeat.m2504i(4215);
        String str;
        if (sApplicationContext == null) {
            str = "";
            AppMethodBeat.m2505o(4215);
            return str;
        }
        str = getUpdateConfigDir() + File.separator + XWALK_PLUGIN_UPDATE_CONFIG_NAME;
        AppMethodBeat.m2505o(4215);
        return str;
    }

    public static String getPluginBaseDir() {
        AppMethodBeat.m2504i(4216);
        String str;
        if (sApplicationContext == null) {
            str = "";
            AppMethodBeat.m2505o(4216);
            return str;
        }
        str = sApplicationContext.getDir(XWALK_PLUGIN_BASE_DIR, 0).getAbsolutePath();
        AppMethodBeat.m2505o(4216);
        return str;
    }

    public static Context getApplicationContext() {
        return sApplicationContext;
    }

    public static SharedPreferences getSharedPreferences() {
        AppMethodBeat.m2504i(4217);
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences("libxwalkcore", 4);
        AppMethodBeat.m2505o(4217);
        return sharedPreferences;
    }

    public static boolean isCurrentVersionSupportExtendPluginForAppbrand() {
        AppMethodBeat.m2504i(4218);
        if (!hasAvailableVersion() || getAvailableVersion() < 300) {
            AppMethodBeat.m2505o(4218);
            return false;
        }
        AppMethodBeat.m2505o(4218);
        return true;
    }

    public static boolean isCurrentVersionSupportMapExtendPluginForAppbrand() {
        AppMethodBeat.m2504i(4219);
        if (hasAvailableVersion() && getFeatureSupport(1011)) {
            AppMethodBeat.m2505o(4219);
            return true;
        }
        AppMethodBeat.m2505o(4219);
        return false;
    }

    public static boolean isCurrentVersionSupportCustomContext() {
        AppMethodBeat.m2504i(4220);
        if (hasAvailableVersion() && getFeatureSupport(1020)) {
            AppMethodBeat.m2505o(4220);
            return true;
        }
        AppMethodBeat.m2505o(4220);
        return false;
    }

    public static void setUsingCustomContext(boolean z) {
        AppMethodBeat.m2504i(4221);
        sUsingCustomContext = z;
        Log.m81049i(TAG, "setUsingCustomContext usingCustomContext:".concat(String.valueOf(z)));
        AppMethodBeat.m2505o(4221);
    }

    public static boolean getUsingCustomContext() {
        return sUsingCustomContext;
    }

    private static boolean getFeatureSupport(int i) {
        AppMethodBeat.m2504i(4222);
        boolean booleanValue = ((Boolean) C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_FEATURE_SUPPORT", new Object[]{Integer.valueOf(i)})).booleanValue();
        AppMethodBeat.m2505o(4222);
        return booleanValue;
    }

    public static boolean hasAvailableVersion() {
        AppMethodBeat.m2504i(4223);
        if (49 > getAvailableVersion()) {
            AppMethodBeat.m2505o(4223);
            return false;
        }
        AppMethodBeat.m2505o(4223);
        return true;
    }

    public static int getAvailableVersion() {
        return sAvailableVersion;
    }

    public static int getInstalledNewstVersion() {
        AppMethodBeat.m2504i(4224);
        int i = getSharedPreferencesForVersionInfo().getInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
        AppMethodBeat.m2505o(4224);
        return i;
    }

    public static int getInstalledNewstVersion(Context context) {
        AppMethodBeat.m2504i(4225);
        if (context == null) {
            AppMethodBeat.m2505o(4225);
            return 0;
        }
        int i = context.getSharedPreferences(SP_NAME_VERSION_INFO, 4).getInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
        AppMethodBeat.m2505o(4225);
        return i;
    }

    public static String getAvailableVersionDetail() {
        return sStrVersionDetail;
    }

    public static boolean setAvailableVersion(int i, String str) {
        AppMethodBeat.m2504i(4226);
        Log.m81049i(TAG, "setAvailableVersion:".concat(String.valueOf(i)));
        Editor edit = getSharedPreferencesForVersionInfo().edit();
        edit.putInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, i);
        edit.putString("versionDetail", str);
        boolean commit = edit.commit();
        addXWalkInitializeLog(TAG, "set xwalk version to " + i + " suc = " + commit);
        AppMethodBeat.m2505o(4226);
        return commit;
    }

    public static String getVesionDir(int i) {
        AppMethodBeat.m2504i(4227);
        String absolutePath = sApplicationContext.getDir(XWALK_CORE_NAME_PREFIX.concat(String.valueOf(i)), 0).getAbsolutePath();
        File file = new File(absolutePath);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(4227);
        return absolutePath;
    }

    public static void clearAllVersion(Context context) {
        AppMethodBeat.m2504i(4228);
        if (context == null || context.getApplicationInfo() == null || context.getApplicationInfo().dataDir == null) {
            AppMethodBeat.m2505o(4228);
            return;
        }
        File[] listFiles = new File(context.getApplicationInfo().dataDir).listFiles();
        if (listFiles == null) {
            AppMethodBeat.m2505o(4228);
            return;
        }
        for (File file : listFiles) {
            if (file.getName().startsWith("app_xwalk_") && file.isDirectory()) {
                C41131b.avl(file.getAbsolutePath());
            }
        }
        setAvailableVersion(-1, "");
        AppMethodBeat.m2505o(4228);
    }

    public static void addXWalkInitializeLog(String str, String str2) {
        AppMethodBeat.m2504i(4229);
        addXWalkInitializeLog(str + ": " + str2);
        AppMethodBeat.m2505o(4229);
    }

    public static void addXWalkInitializeLog(String str) {
        AppMethodBeat.m2504i(4230);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(4230);
            return;
        }
        Log.m81049i("XWalkUpdater", str);
        String str2 = sPid + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + new SimpleDateFormat("MM-dd hh:mm:ss").format(new Date()) + " : " + str;
        SharedPreferences sharedPreferencesForLog = getSharedPreferencesForLog();
        String string = sharedPreferencesForLog.getString("log", "");
        if (string.length() > 10240) {
            string = string.substring(0, 5120);
        }
        sharedPreferencesForLog.edit().putString("log", str2 + IOUtils.LINE_SEPARATOR_UNIX + string).apply();
        AppMethodBeat.m2505o(4230);
    }

    public static int getGrayValue() {
        AppMethodBeat.m2504i(4231);
        int i;
        if (s_grayValue != 0) {
            i = s_grayValue;
            AppMethodBeat.m2505o(4231);
            return i;
        }
        try {
            i = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE_TEST, -1);
            s_grayValue = i;
            if (i <= 0) {
                s_grayValue = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE, -1);
            }
            if (s_grayValue <= 0) {
                s_grayValue = getDeviceRd();
            }
        } catch (Exception e) {
            Log.m81046e(TAG, "match gray rate exception: " + e.getMessage());
        }
        i = s_grayValue;
        AppMethodBeat.m2505o(4231);
        return i;
    }

    public static String getXWalkInitializeLog() {
        AppMethodBeat.m2504i(4232);
        SharedPreferences sharedPreferencesForLog = getSharedPreferencesForLog();
        String str;
        if (sharedPreferencesForLog == null) {
            str = "";
            AppMethodBeat.m2505o(4232);
            return str;
        }
        str = sharedPreferencesForLog.getString("log", "");
        AppMethodBeat.m2505o(4232);
        return str;
    }

    public static String getUpdateConfigDir() {
        AppMethodBeat.m2504i(4233);
        String absolutePath = sApplicationContext.getDir(XWALK_UPDATE_CONFIG_DIR, 0).getAbsolutePath();
        AppMethodBeat.m2505o(4233);
        return absolutePath;
    }

    public static String getUpdateConfigFullPath() {
        AppMethodBeat.m2504i(4234);
        String str = getUpdateConfigDir() + File.separator + "updateConfg.xml";
        AppMethodBeat.m2505o(4234);
        return str;
    }

    public static String getExtractedCoreDir(int i) {
        AppMethodBeat.m2504i(4235);
        String str = getVesionDir(i) + File.separator + XWALK_CORE_EXTRACTED_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(4235);
        return str;
    }

    public static String getExtractedCoreFile(int i, String str) {
        AppMethodBeat.m2504i(4236);
        String str2 = getVesionDir(i) + File.separator + XWALK_CORE_EXTRACTED_DIR;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        str2 = str2 + File.separator + str;
        AppMethodBeat.m2505o(4236);
        return str2;
    }

    public static String getOptimizedDexDir(int i) {
        AppMethodBeat.m2504i(4237);
        String str = getVesionDir(i) + File.separator + OPTIMIZED_DEX_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(4237);
        return str;
    }

    public static String getDownloadZipDir(int i) {
        AppMethodBeat.m2504i(4238);
        String str = getVesionDir(i) + File.separator + ZIP_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        str = str + File.separator + XWALK_CORE_ZIP_NAME;
        AppMethodBeat.m2505o(4238);
        return str;
    }

    public static String getPatchZipTempDecompressPath(int i) {
        AppMethodBeat.m2504i(4239);
        String str = getVesionDir(i) + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(4239);
        return str;
    }

    public static String getPatchZipTempDecompressFilePath(int i, String str) {
        AppMethodBeat.m2504i(4240);
        String str2 = getVesionDir(i) + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        str2 = str2 + File.separator + str;
        AppMethodBeat.m2505o(4240);
        return str2;
    }

    public static String getDownloadZipFileListConfig(int i) {
        AppMethodBeat.m2504i(4241);
        String extractedCoreFile = getExtractedCoreFile(i, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.m2505o(4241);
        return extractedCoreFile;
    }

    public static String getDownloadResFileListConfig(int i) {
        AppMethodBeat.m2504i(4242);
        String extractedCoreFile = getExtractedCoreFile(i, XWALK_CORE_RES_FILELIST_CONFIG_NAME);
        AppMethodBeat.m2505o(4242);
        return extractedCoreFile;
    }

    public static String getPatchFileListConfig(int i) {
        AppMethodBeat.m2504i(4243);
        String patchZipTempDecompressFilePath = getPatchZipTempDecompressFilePath(i, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.m2505o(4243);
        return patchZipTempDecompressFilePath;
    }

    public static String getPatchConfig(int i) {
        AppMethodBeat.m2504i(4244);
        String patchZipTempDecompressFilePath = getPatchZipTempDecompressFilePath(i, XWALK_CORE_PATCH_CONFIG_NAME);
        AppMethodBeat.m2505o(4244);
        return patchZipTempDecompressFilePath;
    }

    public static String getDownloadApkDir(int i) {
        AppMethodBeat.m2504i(4245);
        String str = getVesionDir(i) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        AppMethodBeat.m2505o(4245);
        return str;
    }

    public static String getDownloadApkPath(int i) {
        AppMethodBeat.m2504i(4246);
        String str = getVesionDir(i) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        str = str + File.separator + XWALK_CORE_APK_NAME;
        AppMethodBeat.m2505o(4246);
        return str;
    }

    public static String getDownloadPatchPath(int i) {
        AppMethodBeat.m2504i(4247);
        String str = getVesionDir(i) + File.separator + APK_DIR;
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        str = str + File.separator + XWALK_CORE_PATCH_NAME;
        AppMethodBeat.m2505o(4247);
        return str;
    }

    public static String getClassDexFilePath(int i) {
        AppMethodBeat.m2504i(4248);
        String str = getExtractedCoreDir(i) + File.separator + XWALK_CORE_CLASSES_DEX;
        AppMethodBeat.m2505o(4248);
        return str;
    }

    public static boolean isInTestMode() {
        AppMethodBeat.m2504i(4249);
        String testDownLoadUrl = getTestDownLoadUrl(getApplicationContext());
        if (testDownLoadUrl == null || testDownLoadUrl.isEmpty()) {
            AppMethodBeat.m2505o(4249);
            return false;
        }
        AppMethodBeat.m2505o(4249);
        return true;
    }

    public static int getChromiunVersion() {
        AppMethodBeat.m2504i(4250);
        if (sNChromiuVersion < 0) {
            sNChromiuVersion = _getChromiunVersion();
        }
        int i = sNChromiuVersion;
        AppMethodBeat.m2505o(4250);
        return i;
    }

    public static int safeGetChromiunVersion() {
        int verFromVersionName;
        AppMethodBeat.m2504i(4251);
        if (sNChromiuVersion < 0) {
            try {
                PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
                if (packageInfo != null) {
                    verFromVersionName = getVerFromVersionName(packageInfo.versionName);
                    if (verFromVersionName > 0) {
                        sNChromiuVersion = verFromVersionName;
                        AppMethodBeat.m2505o(4251);
                        return verFromVersionName;
                    }
                }
            } catch (Exception e) {
                Log.m81046e(TAG, "Android System WebView is not found");
            }
        }
        verFromVersionName = sNChromiuVersion;
        AppMethodBeat.m2505o(4251);
        return verFromVersionName;
    }

    static int _getChromiunVersion() {
        int verFromVersionName;
        AppMethodBeat.m2504i(4252);
        try {
            PackageInfo packageInfo = getApplicationContext().getPackageManager().getPackageInfo("com.google.android.webview", 0);
            if (packageInfo != null) {
                verFromVersionName = getVerFromVersionName(packageInfo.versionName);
                if (verFromVersionName > 0) {
                    AppMethodBeat.m2505o(4252);
                    return verFromVersionName;
                }
            }
        } catch (Exception e) {
            Log.m81046e(TAG, "Android System WebView is not found");
        }
        try {
            String userAgentString = new WebView(getApplicationContext()).getSettings().getUserAgentString();
            if (userAgentString != null) {
                String[] split = userAgentString.split("Chrome/");
                if (split == null || split.length == 0 || (split.length == 1 && split[0].length() == userAgentString.length())) {
                    AppMethodBeat.m2505o(4252);
                    return 0;
                }
                verFromVersionName = getVerFromVersionName(split[1]);
                AppMethodBeat.m2505o(4252);
                return verFromVersionName;
            }
        } catch (Exception e2) {
            Log.m81046e(TAG, "Android System WebView is not found");
        }
        AppMethodBeat.m2505o(4252);
        return 0;
    }

    static int getVerFromVersionName(String str) {
        int i = 0;
        AppMethodBeat.m2504i(4253);
        if (str == null || str.isEmpty()) {
            AppMethodBeat.m2505o(4253);
        } else {
            try {
                i = Integer.parseInt(str.split("\\.")[0]);
                AppMethodBeat.m2505o(4253);
            } catch (Exception e) {
                Log.m81046e(TAG, "parse to int error str is :".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(4253);
            }
        }
        return i;
    }

    public static String getTestDownLoadUrl(Context context) {
        AppMethodBeat.m2504i(4254);
        String string = context.getSharedPreferences("TESTXWEB", 4).getString("XWEB_TEST_CONFIG_URL", "");
        AppMethodBeat.m2505o(4254);
        return string;
    }

    public static void setTestDownLoadUrl(Context context, String str) {
        AppMethodBeat.m2504i(4255);
        sXWalkDownConfigUrl = null;
        if (str == null || str.isEmpty()) {
            context.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", "").commit();
            getXWalkUpdateConfigUrl();
            AppMethodBeat.m2505o(4255);
            return;
        }
        context.getSharedPreferences("TESTXWEB", 4).edit().putString("XWEB_TEST_CONFIG_URL", str).commit();
        getXWalkUpdateConfigUrl();
        AppMethodBeat.m2505o(4255);
    }

    public static synchronized void setTempUpdateConfigUrl(String str) {
        synchronized (XWalkEnvironment.class) {
            sStrTempUpdateConfigUrl = str;
        }
    }

    public static synchronized String getTempUpdateConfigUrl() {
        String str;
        synchronized (XWalkEnvironment.class) {
            str = sStrTempUpdateConfigUrl;
        }
        return str;
    }

    public static String getXWalkUpdateConfigUrl() {
        AppMethodBeat.m2504i(4256);
        String testDownLoadUrl = getTestDownLoadUrl(getApplicationContext());
        sXWalkDownConfigUrl = testDownLoadUrl;
        if (testDownLoadUrl == null || sXWalkDownConfigUrl.trim().isEmpty()) {
            testDownLoadUrl = getTempUpdateConfigUrl();
            sXWalkDownConfigUrl = testDownLoadUrl;
            if (testDownLoadUrl != null && !sXWalkDownConfigUrl.trim().isEmpty()) {
                addXWalkInitializeLog("use temp config url : " + sXWalkDownConfigUrl);
            } else if (isIaDevice()) {
                sXWalkDownConfigUrl = DOWNLOAD_X86_CONFIG_URL;
            } else {
                sXWalkDownConfigUrl = DOWNLOAD_CONFIG_URL;
            }
        } else {
            addXWalkInitializeLog("use test config url : " + sXWalkDownConfigUrl);
        }
        Log.m81049i(TAG, "use update config url = " + sXWalkDownConfigUrl);
        testDownLoadUrl = sXWalkDownConfigUrl;
        AppMethodBeat.m2505o(4256);
        return testDownLoadUrl;
    }

    public static SharedPreferences getSharedPreferencesForTestXWeb() {
        AppMethodBeat.m2504i(4257);
        if (sApplicationContext == null) {
            Log.m81046e(TAG, "getSharedPreferencesForTestXWeb context is null");
            AppMethodBeat.m2505o(4257);
            return null;
        }
        SharedPreferences sharedPreferences = sApplicationContext.getSharedPreferences("TESTXWEB", 4);
        AppMethodBeat.m2505o(4257);
        return sharedPreferences;
    }

    public static String getPluginConfigUrl() {
        AppMethodBeat.m2504i(4258);
        SharedPreferences sharedPreferencesForTestXWeb = getSharedPreferencesForTestXWeb();
        String str;
        if (sharedPreferencesForTestXWeb == null) {
            Log.m81046e(TAG, "getPluginConfigUrl sp is null, use default");
            str = DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL;
            AppMethodBeat.m2505o(4258);
            return str;
        }
        str = sharedPreferencesForTestXWeb.getString(SP_KEY_PLUGIN_TEST_CONFIG_URL, "");
        if (str.trim().isEmpty()) {
            addXWalkInitializeLog("plugin use release config url");
            Log.m81049i(TAG, "plugin use release config url: http://dldir1.qq.com/weixin/android/wxweb/plugin/pluginUpdateConfig.xml");
            str = DOWNLOAD_PLUGIN_UPDATE_CONFIG_URL;
            AppMethodBeat.m2505o(4258);
            return str;
        }
        addXWalkInitializeLog("plugin use test config url");
        Log.m81049i(TAG, "plugin use test config url: ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(4258);
        return str;
    }

    public static boolean hasPluginTestConfigUrl() {
        AppMethodBeat.m2504i(4259);
        SharedPreferences sharedPreferencesForTestXWeb = getSharedPreferencesForTestXWeb();
        if (sharedPreferencesForTestXWeb == null) {
            Log.m81046e(TAG, "hasPluginTestConfigUrl sp is null");
            AppMethodBeat.m2505o(4259);
            return false;
        } else if (sharedPreferencesForTestXWeb.getString(SP_KEY_PLUGIN_TEST_CONFIG_URL, "").trim().isEmpty()) {
            AppMethodBeat.m2505o(4259);
            return false;
        } else {
            AppMethodBeat.m2505o(4259);
            return true;
        }
    }

    public static boolean setPluginTestConfigUrl(String str) {
        AppMethodBeat.m2504i(4260);
        SharedPreferences sharedPreferencesForTestXWeb = getSharedPreferencesForTestXWeb();
        if (sharedPreferencesForTestXWeb == null) {
            Log.m81046e(TAG, "setPluginTestConfigUrl sp is null");
            AppMethodBeat.m2505o(4260);
            return false;
        }
        Editor edit = sharedPreferencesForTestXWeb.edit();
        if (str == null || str.trim().isEmpty()) {
            edit.remove(SP_KEY_PLUGIN_TEST_CONFIG_URL);
        } else {
            edit.putString(SP_KEY_PLUGIN_TEST_CONFIG_URL, str);
        }
        boolean commit = edit.commit();
        AppMethodBeat.m2505o(4260);
        return commit;
    }

    public static String getApplicationName() {
        AppMethodBeat.m2504i(4261);
        if (sApplicationName == null) {
            try {
                PackageManager packageManager = sApplicationContext.getPackageManager();
                sApplicationName = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(sApplicationContext.getPackageName(), 0));
            } catch (NameNotFoundException e) {
            }
            if (sApplicationName == null || sApplicationName.isEmpty() || sApplicationName.matches(PACKAGE_RE)) {
                sApplicationName = "this application";
            }
            Log.m81045d(TAG, "Crosswalk application name: " + sApplicationName);
        }
        String str = sApplicationName;
        AppMethodBeat.m2505o(4261);
        return str;
    }

    public static boolean isDownloadMode() {
        AppMethodBeat.m2504i(4262);
        boolean booleanValue = sIsDownloadMode.booleanValue();
        AppMethodBeat.m2505o(4262);
        return booleanValue;
    }

    public static boolean isDownloadModeUpdate() {
        AppMethodBeat.m2504i(4263);
        boolean booleanValue = sIsDownloadModeUpdate.booleanValue();
        AppMethodBeat.m2505o(4263);
        return booleanValue;
    }

    public static boolean isIaDevice() {
        AppMethodBeat.m2504i(4264);
        String deviceAbi = getDeviceAbi();
        if (deviceAbi.equals("x86") || deviceAbi.equals("x86_64")) {
            AppMethodBeat.m2505o(4264);
            return true;
        }
        AppMethodBeat.m2505o(4264);
        return false;
    }

    public static boolean is64bitDevice() {
        AppMethodBeat.m2504i(4265);
        String deviceAbi = getDeviceAbi();
        if (deviceAbi.equals("arm64-v8a") || deviceAbi.equals("x86_64")) {
            AppMethodBeat.m2505o(4265);
            return true;
        }
        AppMethodBeat.m2505o(4265);
        return false;
    }

    public static boolean is64bitApp() {
        AppMethodBeat.m2504i(4266);
        String runtimeAbi = getRuntimeAbi();
        if (runtimeAbi.equals("arm64-v8a") || runtimeAbi.equals("x86_64")) {
            AppMethodBeat.m2505o(4266);
            return true;
        }
        AppMethodBeat.m2505o(4266);
        return false;
    }

    /* JADX WARNING: Missing block: B:50:0x00f9, code skipped:
            if (r4.equals("x86") != false) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getRuntimeAbi() {
        Object obj = null;
        AppMethodBeat.m2504i(4267);
        if (sRuntimeAbi == null) {
            try {
                if (VERSION.SDK_INT >= 21) {
                    NoSuchFieldError noSuchFieldError = new NoSuchFieldError();
                    AppMethodBeat.m2505o(4267);
                    throw noSuchFieldError;
                }
                Object obj2;
                String toLowerCase = Build.CPU_ABI.toLowerCase();
                int obj22;
                switch (toLowerCase.hashCode()) {
                    case -806050265:
                        if (toLowerCase.equals("x86_64")) {
                            obj22 = 4;
                            break;
                        }
                    case -738963905:
                        if (toLowerCase.equals("armeabi")) {
                            obj22 = null;
                            break;
                        }
                    case 117110:
                        if (toLowerCase.equals("x86")) {
                            obj22 = 3;
                            break;
                        }
                    case 145444210:
                        if (toLowerCase.equals("armeabi-v7a")) {
                            obj22 = 1;
                            break;
                        }
                    case 1431565292:
                        if (toLowerCase.equals("arm64-v8a")) {
                            obj22 = 2;
                            break;
                        }
                    default:
                        obj22 = -1;
                        break;
                }
                switch (obj22) {
                    case null:
                    case 1:
                        sRuntimeAbi = "armeabi-v7a";
                        break;
                    case 2:
                        sRuntimeAbi = "arm64-v8a";
                        break;
                    case 3:
                        sRuntimeAbi = "x86";
                        break;
                    case 4:
                        sRuntimeAbi = "x86_64";
                        break;
                    default:
                        RuntimeException runtimeException = new RuntimeException("Unexpected CPU_ABI: ".concat(String.valueOf(toLowerCase)));
                        AppMethodBeat.m2505o(4267);
                        throw runtimeException;
                }
                if (sRuntimeAbi.equals("armeabi-v7a")) {
                    if (isIaDevice()) {
                        sRuntimeAbi = "x86";
                    }
                } else if (sRuntimeAbi.equals("arm64-v8a") && isIaDevice()) {
                    sRuntimeAbi = "x86_64";
                }
                Log.m81045d(TAG, "Runtime ABI: " + sRuntimeAbi);
            } catch (NoSuchFieldError e) {
                String toLowerCase2 = System.getProperty("os.arch").toLowerCase();
                int obj3;
                switch (toLowerCase2.hashCode()) {
                    case -1409295825:
                        if (toLowerCase2.equals("armv7l")) {
                            obj3 = 6;
                            break;
                        }
                    case -1221096139:
                        if (toLowerCase2.equals("aarch64")) {
                            obj3 = 9;
                            break;
                        }
                    case -806050265:
                        if (toLowerCase2.equals("x86_64")) {
                            obj3 = 5;
                            break;
                        }
                    case -738963905:
                        if (toLowerCase2.equals("armeabi")) {
                            obj3 = 7;
                            break;
                        }
                    case 117046:
                        if (toLowerCase2.equals("x64")) {
                            obj3 = 4;
                            break;
                        }
                    case 117110:
                        break;
                    case 3178856:
                        if (toLowerCase2.equals("i386")) {
                            obj3 = 2;
                            break;
                        }
                    case 3181739:
                        if (toLowerCase2.equals("i686")) {
                            obj3 = 1;
                            break;
                        }
                    case 3222903:
                        if (toLowerCase2.equals("ia32")) {
                            obj3 = 3;
                            break;
                        }
                    case 93084186:
                        if (toLowerCase2.equals("arm64")) {
                            obj3 = 11;
                            break;
                        }
                    case 93086174:
                        if (toLowerCase2.equals("armv8")) {
                            obj3 = 10;
                            break;
                        }
                    case 145444210:
                        if (toLowerCase2.equals("armeabi-v7a")) {
                            obj3 = 8;
                            break;
                        }
                    default:
                        obj3 = -1;
                        break;
                }
                switch (obj3) {
                    case null:
                    case 1:
                    case 2:
                    case 3:
                        sRuntimeAbi = "x86";
                        break;
                    case 4:
                    case 5:
                        if (!is64bitDevice()) {
                            sRuntimeAbi = "x86";
                            break;
                        }
                        sRuntimeAbi = "x86_64";
                        break;
                    case 6:
                    case 7:
                    case 8:
                        sRuntimeAbi = "armeabi-v7a";
                        break;
                    case 9:
                    case 10:
                    case 11:
                        if (!is64bitDevice()) {
                            sRuntimeAbi = "armeabi-v7a";
                            break;
                        }
                        sRuntimeAbi = "arm64-v8a";
                        break;
                    default:
                        RuntimeException runtimeException2 = new RuntimeException("Unexpected os.arch: ".concat(String.valueOf(toLowerCase2)));
                        AppMethodBeat.m2505o(4267);
                        throw runtimeException2;
                }
            }
        }
        String str = sRuntimeAbi;
        AppMethodBeat.m2505o(4267);
        return str;
    }

    public static int getDeviceRd() {
        int i;
        AppMethodBeat.m2504i(4268);
        if (sNDeviceRd <= 0) {
            i = getSharedPreferences().getInt(SP_KEY_DEVICE_RD, -1);
            sNDeviceRd = i;
            if (i <= 0) {
                sNDeviceRd = new Random().nextInt(10000000) + 1;
                getSharedPreferences().edit().putInt(SP_KEY_DEVICE_RD, sNDeviceRd).apply();
            }
        }
        i = (sNDeviceRd % Downloads.MIN_WAIT_FOR_NETWORK) + 1;
        AppMethodBeat.m2505o(4268);
        return i;
    }

    public static void setGrayValueForTest(int i) {
        AppMethodBeat.m2504i(4269);
        if (i != 10001) {
            s_grayValue = i % Downloads.MIN_WAIT_FOR_NETWORK;
        }
        getSharedPreferences().edit().putInt(SP_KEY_GRAY_VALUE_TEST, s_grayValue).commit();
        AppMethodBeat.m2505o(4269);
    }

    public static void setIpType(int i) {
        AppMethodBeat.m2504i(4270);
        int ipType = getIpType();
        if (i != ipType) {
            getSharedPreferences().edit().putInt(SP_KEY_IP_TYPE, i).commit();
            addXWalkInitializeLog("setIpType", " to  ".concat(String.valueOf(i)));
            if (ipType == 0 && i == 1) {
                C24532f.m38181nI(197);
            } else if (ipType == 1 && i == 0) {
                C24532f.m38181nI(198);
            }
            if (ipType > 0 || i > 0) {
                sBIsIpTypeChanged = true;
                C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
            }
        }
        AppMethodBeat.m2505o(4270);
    }

    public static int getIpType() {
        AppMethodBeat.m2504i(4271);
        int i = getSharedPreferences().getInt(SP_KEY_IP_TYPE, -2);
        AppMethodBeat.m2505o(4271);
        return i;
    }

    public static int getUserType() {
        AppMethodBeat.m2504i(4272);
        int ipType = getIpType();
        AppMethodBeat.m2505o(4272);
        return ipType;
    }

    public static void setGrayValueByUserId(int i) {
        AppMethodBeat.m2504i(4273);
        if (i == 0) {
            AppMethodBeat.m2505o(4273);
            return;
        }
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest("xweb_gray_value".concat(String.valueOf(4294967295L & ((long) i))).getBytes());
            if (digest == null || digest.length <= 3) {
                AppMethodBeat.m2505o(4273);
                return;
            }
            int i2 = ((digest[0] & C31128d.MIC_SketchMark) << 24) | (((digest[3] & 255) | ((digest[2] & 255) << 8)) | ((digest[1] & 255) << 16));
            if (i2 == 0) {
                AppMethodBeat.m2505o(4273);
                return;
            }
            s_grayValue = (i2 % Downloads.MIN_WAIT_FOR_NETWORK) + 1;
            i2 = getSharedPreferences().getInt(SP_KEY_GRAY_VALUE, -1);
            getSharedPreferences().edit().putInt(SP_KEY_GRAY_VALUE, s_grayValue).commit();
            if (i2 != s_grayValue) {
                Log.m81049i(TAG, "gray value changed to " + s_grayValue);
                C44581k.m80968f(C44570d.WV_KIND_CW).excute("STR_CMD_SET_RECHECK_COMMAND", null);
            }
            AppMethodBeat.m2505o(4273);
        } catch (Exception e) {
            s_grayValue = 0;
        }
    }

    public static String getDeviceId() {
        AppMethodBeat.m2504i(4274);
        if (sStrDeviceId == null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) getApplicationContext().getSystemService("phone");
                if (telephonyManager == null) {
                    sStrDeviceId = "";
                } else {
                    sStrDeviceId = telephonyManager.getDeviceId();
                }
            } catch (Exception e) {
                sStrDeviceId = "";
                Log.m81046e(TAG, "getDeviceId failed " + e.getMessage());
            }
        }
        String str = sStrDeviceId;
        AppMethodBeat.m2505o(4274);
        return str;
    }

    static void tryClose(Closeable closeable) {
        AppMethodBeat.m2504i(4275);
        if (closeable == null) {
            AppMethodBeat.m2505o(4275);
            return;
        }
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception e) {
                Log.m81046e(TAG, "closeable close  failed " + e.getMessage());
                AppMethodBeat.m2505o(4275);
                return;
            }
        }
        AppMethodBeat.m2505o(4275);
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00d5  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String getDeviceAbi() {
        Exception e;
        Closeable bufferedReader;
        Throwable th;
        AppMethodBeat.m2504i(4276);
        if (sDeviceAbi == null) {
            try {
                if (VERSION.SDK_INT >= 21) {
                    sDeviceAbi = Build.SUPPORTED_ABIS[0].toLowerCase();
                }
            } catch (Exception e2) {
                Log.m81046e(TAG, "Build.SUPPORTED_ABIS excpet " + e2.getMessage());
            } catch (NoSuchFieldError e3) {
                Log.m81046e(TAG, "Build.SUPPORTED_ABIS NoSuchFieldError " + e3.getMessage());
            }
            if (sDeviceAbi == null) {
                Closeable inputStreamReader;
                try {
                    inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader);
                    } catch (Exception e4) {
                        e2 = e4;
                        bufferedReader = null;
                        try {
                            Log.m81046e(TAG, "Device ABI: " + e2.getMessage());
                            tryClose(inputStreamReader);
                            tryClose(bufferedReader);
                            Log.m81045d(TAG, "Device ABI: " + sDeviceAbi);
                            if (sDeviceAbi != null) {
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            tryClose(inputStreamReader);
                            tryClose(bufferedReader);
                            AppMethodBeat.m2505o(4276);
                            throw th;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader = null;
                        tryClose(inputStreamReader);
                        tryClose(bufferedReader);
                        AppMethodBeat.m2505o(4276);
                        throw th;
                    }
                    try {
                        sDeviceAbi = bufferedReader.readLine().toLowerCase();
                        tryClose(inputStreamReader);
                        tryClose(bufferedReader);
                    } catch (Exception e5) {
                        e2 = e5;
                        Log.m81046e(TAG, "Device ABI: " + e2.getMessage());
                        tryClose(inputStreamReader);
                        tryClose(bufferedReader);
                        Log.m81045d(TAG, "Device ABI: " + sDeviceAbi);
                        if (sDeviceAbi != null) {
                        }
                    }
                } catch (Exception e6) {
                    e2 = e6;
                    bufferedReader = null;
                    inputStreamReader = null;
                    Log.m81046e(TAG, "Device ABI: " + e2.getMessage());
                    tryClose(inputStreamReader);
                    tryClose(bufferedReader);
                    Log.m81045d(TAG, "Device ABI: " + sDeviceAbi);
                    if (sDeviceAbi != null) {
                    }
                } catch (Throwable th4) {
                    th = th4;
                    bufferedReader = null;
                    inputStreamReader = null;
                    tryClose(inputStreamReader);
                    tryClose(bufferedReader);
                    AppMethodBeat.m2505o(4276);
                    throw th;
                }
            }
            Log.m81045d(TAG, "Device ABI: " + sDeviceAbi);
        }
        String str;
        if (sDeviceAbi != null) {
            str = "";
            AppMethodBeat.m2505o(4276);
            return str;
        }
        str = sDeviceAbi;
        AppMethodBeat.m2505o(4276);
        return str;
    }

    private static String getApplicationMetaData(String str) {
        AppMethodBeat.m2504i(4277);
        try {
            String obj = sApplicationContext.getPackageManager().getApplicationInfo(sApplicationContext.getPackageName(), 128).metaData.get(str).toString();
            AppMethodBeat.m2505o(4277);
            return obj;
        } catch (NameNotFoundException | NullPointerException e) {
            AppMethodBeat.m2505o(4277);
            return null;
        }
    }

    public static boolean checkApiVersionAvailable(int i) {
        AppMethodBeat.m2504i(4278);
        try {
            String extractedCoreDir = getExtractedCoreDir(i);
            String classDexFilePath = getClassDexFilePath(i);
            if (new File(classDexFilePath).exists()) {
                try {
                    Class loadClass = new DexClassLoader(classDexFilePath, getOptimizedDexDir(i), extractedCoreDir, ClassLoader.getSystemClassLoader()).loadClass("org.xwalk.core.internal.XWalkCoreVersion");
                    classDexFilePath = "";
                    try {
                        classDexFilePath = (String) new ReflectField(loadClass, "XWALK_BUILD_VERSION").get();
                    } catch (RuntimeException e) {
                    }
                    int intValue = ((Integer) new ReflectField(loadClass, "API_VERSION").get()).intValue();
                    Log.m81045d(TAG, "[Lib Version] build:" + classDexFilePath + ", api:" + intValue + ", min_api:" + ((Integer) new ReflectField(loadClass, "MIN_API_VERSION").get()).intValue());
                    AppMethodBeat.m2505o(4278);
                    return true;
                } catch (Exception e2) {
                    AppMethodBeat.m2505o(4278);
                    return false;
                }
            }
            AppMethodBeat.m2505o(4278);
            return false;
        } catch (Exception e3) {
            AppMethodBeat.m2505o(4278);
            return false;
        }
    }

    public static boolean checkApiVersionAllFileExist(int i) {
        AppMethodBeat.m2504i(4279);
        if (checkApiVersionExtractResourceExist(i) && checkApiVersionBaseApkExist(i)) {
            AppMethodBeat.m2505o(4279);
            return true;
        }
        AppMethodBeat.m2505o(4279);
        return false;
    }

    public static boolean checkApiVersionBaseApkExist(int i) {
        AppMethodBeat.m2504i(4280);
        if (new File(getDownloadApkPath(i)).exists()) {
            AppMethodBeat.m2505o(4280);
            return true;
        }
        AppMethodBeat.m2505o(4280);
        return false;
    }

    private static boolean checkApiVersionExtractResourceExist(int i) {
        AppMethodBeat.m2504i(4281);
        for (String str : MANDATORY_RESOURCES) {
            if (!str.equals("xweb_fullscreen_video.js")) {
                File file = new File(getExtractedCoreDir(i) + str);
                if (!file.exists()) {
                    Log.m81049i(TAG, "XWalkEnvironment checkApiVersionExtractResourceExist not exist Version:" + i + ", resource name:" + str + ", Path:" + file.getAbsolutePath());
                    AppMethodBeat.m2505o(4281);
                    return false;
                }
            }
        }
        AppMethodBeat.m2505o(4281);
        return true;
    }

    public static boolean delApiVersion(int i) {
        AppMethodBeat.m2504i(4282);
        boolean avl = C41131b.avl(getVesionDir(i));
        AppMethodBeat.m2505o(4282);
        return avl;
    }

    public static String getProcessName() {
        AppMethodBeat.m2504i(4283);
        String str;
        if (sStrCurentProcessName != null) {
            str = sStrCurentProcessName;
            AppMethodBeat.m2505o(4283);
            return str;
        }
        Object xWebInitArgs = getXWebInitArgs(XWALK_ENV_MAP_KEY_PROCESSNAME);
        if (xWebInitArgs != null) {
            str = xWebInitArgs.toString();
            sStrCurentProcessName = str;
            AppMethodBeat.m2505o(4283);
            return str;
        }
        Context applicationContext = getApplicationContext();
        int myPid = Process.myPid();
        if (applicationContext == null) {
            AppMethodBeat.m2505o(4283);
            return null;
        }
        ActivityManager activityManager = (ActivityManager) applicationContext.getSystemService("activity");
        if (activityManager != null) {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == myPid) {
                        sStrCurentProcessName = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
        }
        str = sStrCurentProcessName;
        AppMethodBeat.m2505o(4283);
        return str;
    }

    public static ContentResolver getContentResolver() {
        AppMethodBeat.m2504i(4284);
        if (sApplicationContext == null) {
            Log.m81046e(TAG, "getContentResolver sApplicationContext is null");
            AppMethodBeat.m2505o(4284);
            return null;
        }
        ContentResolver contentResolver = sApplicationContext.getContentResolver();
        AppMethodBeat.m2505o(4284);
        return contentResolver;
    }

    public static Context getPackageContext(String str) {
        Context context = null;
        AppMethodBeat.m2504i(4285);
        if (sApplicationContext == null) {
            Log.m81046e(TAG, "getTargetPackageContext sApplicationContext is null");
            AppMethodBeat.m2505o(4285);
        } else {
            try {
                context = sApplicationContext.createPackageContext(str, 2);
            } catch (Exception e) {
                Log.m81046e(TAG, e.getMessage());
            }
            AppMethodBeat.m2505o(4285);
        }
        return context;
    }

    public static boolean isSelfProvider() {
        AppMethodBeat.m2504i(4286);
        if (sApplicationContext == null) {
            Log.m81046e(TAG, "isSelfProvider sApplicationContext is null");
            AppMethodBeat.m2505o(4286);
            return true;
        }
        boolean isProvider = isProvider(sApplicationContext.getPackageName());
        AppMethodBeat.m2505o(4286);
        return isProvider;
    }

    public static boolean isProvider(String str) {
        AppMethodBeat.m2504i(4287);
        if (str == null || str.isEmpty()) {
            Log.m81046e(TAG, "isProvider packageName is null or empty");
            AppMethodBeat.m2505o(4287);
            return false;
        }
        for (String equals : XWALK_CORE_PROVIDER_LIST) {
            if (equals.equals(str)) {
                AppMethodBeat.m2505o(4287);
                return true;
            }
        }
        AppMethodBeat.m2505o(4287);
        return false;
    }

    public static String getPackageName() {
        AppMethodBeat.m2504i(4288);
        String str;
        if (sApplicationContext == null) {
            Log.m81046e(TAG, "getPackageName sApplicationContext is null");
            str = "";
            AppMethodBeat.m2505o(4288);
            return str;
        }
        str = sApplicationContext.getPackageName();
        AppMethodBeat.m2505o(4288);
        return str;
    }

    public static String getVesionDir(Context context, int i) {
        AppMethodBeat.m2504i(4289);
        String str;
        if (context == null) {
            Log.m81046e(TAG, "getVersionDir with context, context is null");
            str = "";
            AppMethodBeat.m2505o(4289);
            return str;
        }
        str = context.getDir(XWALK_CORE_NAME_PREFIX.concat(String.valueOf(i)), 0).getAbsolutePath();
        AppMethodBeat.m2505o(4289);
        return str;
    }

    public static String getDownloadApkPath(Context context, int i) {
        AppMethodBeat.m2504i(4290);
        String str;
        if (context == null) {
            Log.m81046e(TAG, "getDownloadApkPath with context, context is null");
            str = "";
            AppMethodBeat.m2505o(4290);
            return str;
        }
        str = getVesionDir(context, i);
        if (str.isEmpty()) {
            Log.m81046e(TAG, "getDownloadApkPath with context, versionDir is empty");
            str = "";
            AppMethodBeat.m2505o(4290);
            return str;
        }
        str = str + File.separator + APK_DIR + File.separator + XWALK_CORE_APK_NAME;
        AppMethodBeat.m2505o(4290);
        return str;
    }

    public static String getExtractedCoreFile(Context context, int i, String str) {
        AppMethodBeat.m2504i(4291);
        String str2;
        if (context == null) {
            Log.m81046e(TAG, "getExtractedCoreFile with context, context is null");
            str2 = "";
            AppMethodBeat.m2505o(4291);
            return str2;
        }
        str2 = getVesionDir(context, i);
        if (str2.isEmpty()) {
            Log.m81046e(TAG, "getExtractedCoreFile with context, versionDir is empty");
            str2 = "";
            AppMethodBeat.m2505o(4291);
            return str2;
        }
        str2 = str2 + File.separator + XWALK_CORE_EXTRACTED_DIR + File.separator + str;
        AppMethodBeat.m2505o(4291);
        return str2;
    }

    public static String getPatchZipTempDecompressFilePath(Context context, int i, String str) {
        AppMethodBeat.m2504i(4292);
        String str2;
        if (context == null) {
            Log.m81046e(TAG, "getPatchZipTempDecompressFilePath with context, context is null");
            str2 = "";
            AppMethodBeat.m2505o(4292);
            return str2;
        }
        str2 = getVesionDir(context, i);
        if (str2.isEmpty()) {
            Log.m81046e(TAG, "getPatchZipTempDecompressFilePath with context, versionDir is empty");
            str2 = "";
            AppMethodBeat.m2505o(4292);
            return str2;
        }
        str2 = str2 + File.separator + PATCH_ZIP_TEMP_DECOMPRESS_DIR + File.separator + str;
        AppMethodBeat.m2505o(4292);
        return str2;
    }

    public static String getDownloadZipFileListConfig(Context context, int i) {
        AppMethodBeat.m2504i(4293);
        String extractedCoreFile = getExtractedCoreFile(context, i, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.m2505o(4293);
        return extractedCoreFile;
    }

    public static String getPatchFileListConfig(Context context, int i) {
        AppMethodBeat.m2504i(4294);
        String patchZipTempDecompressFilePath = getPatchZipTempDecompressFilePath(context, i, XWALK_CORE_FILELIST_CONFIG_NAME);
        AppMethodBeat.m2505o(4294);
        return patchZipTempDecompressFilePath;
    }

    public static int readAvailableVersionFromSP(Context context) {
        AppMethodBeat.m2504i(4295);
        if (context == null) {
            Log.m81046e(TAG, "readAvailableVersionFromSP context is null");
            AppMethodBeat.m2505o(4295);
            return -1;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(SP_NAME_VERSION_INFO, 4);
        if (sharedPreferences == null) {
            Log.m81046e(TAG, "readAvailableVersionFromSP sp is null");
            AppMethodBeat.m2505o(4295);
            return -1;
        }
        int i = sharedPreferences.getInt(SP_KEY_PLUGIN_AVAILABLE_VERSION, -1);
        AppMethodBeat.m2505o(4295);
        return i;
    }

    public static boolean isTestVersion(int i) {
        return i >= 100000;
    }
}
