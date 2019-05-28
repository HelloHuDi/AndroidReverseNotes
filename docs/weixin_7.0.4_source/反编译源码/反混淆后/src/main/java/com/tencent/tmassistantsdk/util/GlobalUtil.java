package com.tencent.tmassistantsdk.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.tmassistantsdk.common.TMAssistantDownloadSDKErrorCode;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class GlobalUtil {
    static final int NET_TYPE_WIFI = 4;
    protected static final String SharedPreferencesName = "TMAssistantSDKSharedPreference";
    private static final String TAG = "GlobalUtil";
    protected static GlobalUtil mInstance = null;
    protected static int mMemUUID = 0;
    public final int JCE_CMDID_Empty;
    public final int JCE_CMDID_GetAppSimpleDetail;
    public final int JCE_CMDID_GetAppUpdate;
    public final int JCE_CMDID_GetAuthorized;
    public final int JCE_CMDID_GetSettings;
    public final int JCE_CMDID_ReportLog;
    protected Context mContext;
    public HashMap<Integer, String> mJCECmdIdMap;
    public String mQUA;

    protected GlobalUtil() {
        AppMethodBeat.m2504i(76235);
        this.mQUA = "";
        this.JCE_CMDID_Empty = 0;
        this.JCE_CMDID_ReportLog = 1;
        this.JCE_CMDID_GetSettings = 2;
        this.JCE_CMDID_GetAppUpdate = 3;
        this.JCE_CMDID_GetAuthorized = 4;
        this.JCE_CMDID_GetAppSimpleDetail = 5;
        this.mJCECmdIdMap = null;
        this.mJCECmdIdMap = new HashMap();
        this.mJCECmdIdMap.put(Integer.valueOf(1), "ReportLog");
        this.mJCECmdIdMap.put(Integer.valueOf(2), "GetSettings");
        this.mJCECmdIdMap.put(Integer.valueOf(3), "GetAppUpdate");
        this.mJCECmdIdMap.put(Integer.valueOf(4), "GetAuthorized");
        this.mJCECmdIdMap.put(Integer.valueOf(5), "GetAppSimpleDetail");
        AppMethodBeat.m2505o(76235);
    }

    public static synchronized GlobalUtil getInstance() {
        GlobalUtil globalUtil;
        synchronized (GlobalUtil.class) {
            AppMethodBeat.m2504i(76236);
            if (mInstance == null) {
                mInstance = new GlobalUtil();
            }
            globalUtil = mInstance;
            AppMethodBeat.m2505o(76236);
        }
        return globalUtil;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void setContext(Context context) {
        AppMethodBeat.m2504i(76237);
        this.mContext = context;
        this.mQUA = new QUASetting(context).buildQUA();
        AppMethodBeat.m2505o(76237);
    }

    public void destroy() {
        this.mContext = null;
        mInstance = null;
    }

    public int getJceCmdIdByClassName(String str) {
        AppMethodBeat.m2504i(76238);
        if (str == null) {
            AppMethodBeat.m2505o(76238);
            return 0;
        }
        if (this.mJCECmdIdMap != null) {
            for (Entry entry : this.mJCECmdIdMap.entrySet()) {
                if (entry != null) {
                    Integer num = (Integer) entry.getKey();
                    String str2 = (String) entry.getValue();
                    if (str2 != null && str2.equals(str)) {
                        int intValue = num.intValue();
                        AppMethodBeat.m2505o(76238);
                        return intValue;
                    }
                }
            }
        }
        AppMethodBeat.m2505o(76238);
        return 0;
    }

    public String getNetworkOperator() {
        AppMethodBeat.m2504i(76239);
        String str;
        if (this.mContext == null) {
            str = "";
            AppMethodBeat.m2505o(76239);
            return str;
        }
        str = ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkOperator();
        AppMethodBeat.m2505o(76239);
        return str;
    }

    public int getNetworkType() {
        AppMethodBeat.m2504i(76240);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76240);
            return 0;
        }
        int networkType = ((TelephonyManager) this.mContext.getSystemService("phone")).getNetworkType();
        AppMethodBeat.m2505o(76240);
        return networkType;
    }

    public static String getAppPackageName(Context context) {
        AppMethodBeat.m2504i(76241);
        String packageName;
        if (context != null) {
            packageName = context.getPackageName();
            AppMethodBeat.m2505o(76241);
            return packageName;
        }
        packageName = "";
        AppMethodBeat.m2505o(76241);
        return packageName;
    }

    public static int getAppVersionCode(Context context) {
        int i = 0;
        AppMethodBeat.m2504i(76242);
        if (context != null) {
            try {
                i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                AppMethodBeat.m2505o(76242);
            } catch (NameNotFoundException e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[i]);
                AppMethodBeat.m2505o(76242);
            }
        } else {
            AppMethodBeat.m2505o(76242);
        }
        return i;
    }

    public String getAndroidIdInPhone() {
        AppMethodBeat.m2504i(76243);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76243);
            return null;
        }
        String string = Secure.getString(getContext().getContentResolver(), "android_id");
        AppMethodBeat.m2505o(76243);
        return string;
    }

    public String getPhoneGuid() {
        AppMethodBeat.m2504i(76244);
        String str;
        if (this.mContext == null) {
            str = "";
            AppMethodBeat.m2505o(76244);
            return str;
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("TMAssistantSDKPhoneGUID", "");
            AppMethodBeat.m2505o(76244);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(76244);
        return str;
    }

    public void setPhoneGuid(String str) {
        AppMethodBeat.m2504i(76245);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76245);
            return;
        }
        if (str != null) {
            SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putString("TMAssistantSDKPhoneGUID", str).commit();
            }
        }
        AppMethodBeat.m2505o(76245);
    }

    public String getImei() {
        AppMethodBeat.m2504i(76246);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76246);
            return null;
        }
        String deviceId;
        String str = "";
        try {
            deviceId = ((TelephonyManager) getContext().getSystemService("phone")).getDeviceId();
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "getImei:", new Object[0]);
            deviceId = str;
        }
        AppMethodBeat.m2505o(76246);
        return deviceId;
    }

    public String getImsi() {
        AppMethodBeat.m2504i(76247);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76247);
            return null;
        }
        String subscriberId;
        String str = "";
        try {
            subscriberId = ((TelephonyManager) getContext().getSystemService("phone")).getSubscriberId();
        } catch (Exception e) {
            C4990ab.printErrStackTrace(TAG, e, "getImsi:", new Object[0]);
            subscriberId = str;
        }
        AppMethodBeat.m2505o(76247);
        return subscriberId;
    }

    public String getMacAddress() {
        AppMethodBeat.m2504i(76248);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76248);
            return null;
        }
        String macAddress;
        try {
            WifiInfo connectionInfo = ((WifiManager) getContext().getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                macAddress = connectionInfo.getMacAddress();
                AppMethodBeat.m2505o(76248);
                return macAddress;
            }
            macAddress = "";
            AppMethodBeat.m2505o(76248);
            return macAddress;
        } catch (Exception e) {
            macAddress = "";
            AppMethodBeat.m2505o(76248);
            return macAddress;
        }
    }

    public static String calcMD5AsString(String str) {
        AppMethodBeat.m2504i(76249);
        String str2 = "";
        if (!TextUtils.isEmpty(str)) {
            byte[] bytes = str.getBytes();
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.reset();
                instance.update(bytes, 0, bytes.length);
                byte[] digest = instance.digest();
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b : digest) {
                    stringBuffer.append(Integer.toHexString(b & 255));
                }
                str2 = stringBuffer.toString();
            } catch (NoSuchAlgorithmException e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            }
        }
        AppMethodBeat.m2505o(76249);
        return str2;
    }

    public static synchronized int getMemUUID() {
        int i;
        synchronized (GlobalUtil.class) {
            i = mMemUUID;
            mMemUUID = i + 1;
        }
        return i;
    }

    public static ArrayList<String> String2List(String str) {
        AppMethodBeat.m2504i(76250);
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(",");
            for (CharSequence charSequence : split) {
                if (!TextUtils.isEmpty(charSequence)) {
                    arrayList.add(charSequence);
                }
            }
        }
        AppMethodBeat.m2505o(76250);
        return arrayList;
    }

    public void setNetTypeValue(byte b) {
        AppMethodBeat.m2504i(76251);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76251);
            return;
        }
        SharedPreferences sharedPreferences = this.mContext.getSharedPreferences(SharedPreferencesName, 0);
        if (!(sharedPreferences == null || Byte.parseByte(sharedPreferences.getString("TMAssistantSDKNetType", AppEventsConstants.EVENT_PARAM_VALUE_NO)) == b)) {
            sharedPreferences.edit().putString("TMAssistantSDKNetType", String.valueOf(b)).commit();
        }
        AppMethodBeat.m2505o(76251);
    }

    public boolean canReportValue() {
        return false;
    }

    public int getQQDownloaderAPILevel() {
        int i = 0;
        AppMethodBeat.m2504i(76252);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76252);
        } else {
            try {
                ApplicationInfo applicationInfo = this.mContext.getPackageManager().getApplicationInfo("com.tencent.android.qqdownloader", 128);
                if (applicationInfo == null || applicationInfo.metaData == null) {
                    AppMethodBeat.m2505o(76252);
                } else {
                    i = applicationInfo.metaData.getInt("com.tencent.android.qqdownloader.sdk.apilevel");
                    AppMethodBeat.m2505o(76252);
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
                AppMethodBeat.m2505o(76252);
            }
        }
        return i;
    }

    public int getQQDownloaderVersionCode() {
        int i = 0;
        AppMethodBeat.m2504i(76253);
        if (this.mContext == null) {
            AppMethodBeat.m2505o(76253);
        } else {
            PackageManager packageManager = this.mContext.getPackageManager();
            if (packageManager != null) {
                try {
                    PackageInfo packageInfo = packageManager.getPackageInfo("com.tencent.android.qqdownloader", 0);
                    if (packageInfo == null) {
                        AppMethodBeat.m2505o(76253);
                    } else {
                        i = packageInfo.versionCode;
                        AppMethodBeat.m2505o(76253);
                    }
                } catch (NameNotFoundException e) {
                    C4990ab.printErrStackTrace(TAG, e, "", new Object[i]);
                    AppMethodBeat.m2505o(76253);
                }
            } else {
                AppMethodBeat.m2505o(76253);
            }
        }
        return i;
    }

    public static void updateFilePathAuthorized(String str) {
        AppMethodBeat.m2504i(76254);
        File file = new File(str);
        String parent = file.getParent();
        String parent2 = new File(parent).getParent();
        String parent3 = new File(parent2).getParent();
        try {
            Runtime.getRuntime().exec("chmod 777 " + file.getAbsolutePath());
            Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(parent)));
            Runtime.getRuntime().exec("chmod 777 ".concat(String.valueOf(parent2)));
            Runtime.getRuntime().exec("chmod 777".concat(String.valueOf(parent3)));
            AppMethodBeat.m2505o(76254);
        } catch (IOException e) {
            C4990ab.printErrStackTrace(TAG, e, "", new Object[0]);
            AppMethodBeat.m2505o(76254);
        }
    }

    public static int assistantState2SDKState(int i) {
        switch (i) {
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 5;
            case 4:
                return 4;
            case 6:
                return 1;
            case 9:
                return 6;
            default:
                return 0;
        }
    }

    public static int assistantErrorCode2SDKErrorCode(int i) {
        switch (i) {
            case DownloadResult.CODE_EXCEPTION /*-28*/:
                return 701;
            case DownloadResult.CODE_IO_EXCEPTION /*-27*/:
                return 606;
            case DownloadResult.CODE_SOCKET_TIMEOUT_EXCEPTION /*-25*/:
                return 602;
            case DownloadResult.CODE_CONNECTION_TIMEOUT_EXCEPTION /*-23*/:
                return 601;
            case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_CLIENT_PROTOCOL_EXCEPTION;
            case DownloadResult.CODE_URL_ERROR /*-21*/:
                return 700;
            case -16:
                return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_URL_EMPTY;
            case -15:
                return 1;
            case -13:
                return 703;
            case -12:
                return TMAssistantDownloadSDKErrorCode.DownloadSDKErrorCode_SPACE_NOT_ENOUGH;
            case -11:
                return 708;
            case -1:
                return 709;
            case 0:
                return 0;
            default:
                return 604;
        }
    }

    public static boolean isDBExist(String str) {
        AppMethodBeat.m2504i(76255);
        if (getInstance().getContext() == null || !getInstance().getContext().getDatabasePath(str).exists()) {
            AppMethodBeat.m2505o(76255);
            return false;
        }
        AppMethodBeat.m2505o(76255);
        return true;
    }

    public static void deleteOldDB(String str) {
        AppMethodBeat.m2504i(76256);
        if (getInstance().getContext() != null) {
            File databasePath = getInstance().getContext().getDatabasePath(str);
            if (databasePath.exists()) {
                try {
                    databasePath.delete();
                    TMLog.m60588i(TAG, "deleteDB");
                    AppMethodBeat.m2505o(76256);
                    return;
                } catch (Exception e) {
                    TMLog.m60588i(TAG, "deleteDB failed");
                }
            }
        }
        AppMethodBeat.m2505o(76256);
    }
}
