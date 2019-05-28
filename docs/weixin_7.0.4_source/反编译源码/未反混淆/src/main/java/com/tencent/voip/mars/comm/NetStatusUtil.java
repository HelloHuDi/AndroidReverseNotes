package com.tencent.voip.mars.comm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.voip.mars.xlog.Log;
import java.util.List;

public class NetStatusUtil {
    public static final int CMNET = 6;
    public static final int CMWAP = 5;
    public static final int CTNET = 8;
    public static final int CTWAP = 7;
    public static final int LTE = 10;
    public static final int MOBILE = 9;
    public static final int NETTYPE_NOT_WIFI = 0;
    public static final int NETTYPE_WIFI = 1;
    public static final int NET_3G = 4;
    public static final int NON_NETWORK = -1;
    public static final int NO_SIM_OPERATOR = 0;
    public static final int POLICY_NONE = 0;
    public static final int POLICY_REJECT_METERED_BACKGROUND = 1;
    private static final String TAG = "MicroMsg.NetStatusUtil";
    public static final int TBACKGROUND_DATA_LIMITED = 2;
    public static final int TBACKGROUND_NOT_LIMITED = 0;
    public static final int TBACKGROUND_PROCESS_LIMITED = 1;
    public static final int TBACKGROUND_WIFI_LIMITED = 3;
    public static final int UNINET = 1;
    public static final int UNIWAP = 2;
    public static final int UNKNOW_TYPE = 999;
    public static final int WAP_3G = 3;
    public static final int WIFI = 0;
    private static int nowStrength = 0;

    public static class StrengthListener extends PhoneStateListener {
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            AppMethodBeat.i(92750);
            super.onSignalStrengthsChanged(signalStrength);
            if (signalStrength.isGsm()) {
                NetStatusUtil.nowStrength = signalStrength.getGsmSignalStrength();
                AppMethodBeat.o(92750);
                return;
            }
            NetStatusUtil.nowStrength = signalStrength.getCdmaDbm();
            AppMethodBeat.o(92750);
        }
    }

    public static void dumpNetStatus(Context context) {
        AppMethodBeat.i(92764);
        try {
            Log.i(TAG, ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().toString());
            AppMethodBeat.o(92764);
        } catch (Exception e) {
            Log.e(TAG, "", e);
            AppMethodBeat.o(92764);
        }
    }

    public static boolean isConnected(Context context) {
        AppMethodBeat.i(92765);
        boolean z = false;
        try {
            z = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
        }
        AppMethodBeat.o(92765);
        return z;
    }

    public static String getNetTypeString(Context context) {
        AppMethodBeat.i(92766);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        String str;
        if (connectivityManager == null) {
            str = "NON_NETWORK";
            AppMethodBeat.o(92766);
            return str;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            str = "NON_NETWORK";
            AppMethodBeat.o(92766);
            return str;
        } else if (activeNetworkInfo.getType() == 1) {
            str = "WIFI";
            AppMethodBeat.o(92766);
            return str;
        } else if (activeNetworkInfo.getExtraInfo() != null) {
            str = activeNetworkInfo.getExtraInfo();
            AppMethodBeat.o(92766);
            return str;
        } else {
            str = "MOBILE";
            AppMethodBeat.o(92766);
            return str;
        }
    }

    public static int getNetWorkType(Context context) {
        AppMethodBeat.i(92767);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                AppMethodBeat.o(92767);
                return type;
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(92767);
        return -1;
    }

    public static int getNetType(Context context) {
        AppMethodBeat.i(92768);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(92768);
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(92768);
            return -1;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(92768);
            return 0;
        } else {
            if (activeNetworkInfo.getExtraInfo() != null) {
                if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                    AppMethodBeat.o(92768);
                    return 1;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                    AppMethodBeat.o(92768);
                    return 2;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                    AppMethodBeat.o(92768);
                    return 3;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                    AppMethodBeat.o(92768);
                    return 4;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                    AppMethodBeat.o(92768);
                    return 5;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                    AppMethodBeat.o(92768);
                    return 6;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                    AppMethodBeat.o(92768);
                    return 7;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                    AppMethodBeat.o(92768);
                    return 8;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE")) {
                    AppMethodBeat.o(92768);
                    return 10;
                }
            }
            AppMethodBeat.o(92768);
            return 9;
        }
    }

    public static int getISPCode(Context context) {
        AppMethodBeat.i(92769);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            AppMethodBeat.o(92769);
            return 0;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            AppMethodBeat.o(92769);
            return 0;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int length = simOperator.length();
            if (length > 6) {
                length = 6;
            }
            for (int i = 0; i < length; i++) {
                if (Character.isDigit(simOperator.charAt(i))) {
                    stringBuilder.append(simOperator.charAt(i));
                } else if (stringBuilder.length() <= 0) {
                }
            }
            length = Integer.valueOf(stringBuilder.toString()).intValue();
            AppMethodBeat.o(92769);
            return length;
        } catch (Exception e) {
            AppMethodBeat.o(92769);
            return 0;
        }
    }

    public static String getISPName(Context context) {
        AppMethodBeat.i(92770);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        String str;
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.o(92770);
            return str;
        } else if (telephonyManager.getSimOperatorName().length() <= 100) {
            str = telephonyManager.getSimOperatorName();
            AppMethodBeat.o(92770);
            return str;
        } else {
            str = telephonyManager.getSimOperatorName().substring(0, 100);
            AppMethodBeat.o(92770);
            return str;
        }
    }

    public static int guessNetSpeed(Context context) {
        AppMethodBeat.i(92771);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(92771);
                return 102400;
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                    AppMethodBeat.o(92771);
                    return 4096;
                case 2:
                    AppMethodBeat.o(92771);
                    return Utility.DEFAULT_STREAM_BUFFER_SIZE;
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                    AppMethodBeat.o(92771);
                    return 102400;
            }
            AppMethodBeat.o(92771);
            return 102400;
        } catch (Exception e) {
        }
    }

    public static boolean isMobile(Context context) {
        AppMethodBeat.i(92772);
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType() != 1) {
                AppMethodBeat.o(92772);
                return true;
            }
            AppMethodBeat.o(92772);
            return false;
        } catch (Exception e) {
            AppMethodBeat.o(92772);
            return false;
        }
    }

    public static boolean is2G(Context context) {
        AppMethodBeat.i(92773);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(92773);
                return false;
            }
            if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                AppMethodBeat.o(92773);
                return true;
            }
            AppMethodBeat.o(92773);
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean is4G(Context context) {
        AppMethodBeat.i(92774);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(92774);
                return false;
            }
            if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(92774);
                return true;
            }
            AppMethodBeat.o(92774);
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean isWap(Context context) {
        AppMethodBeat.i(92775);
        boolean isWap = isWap(getNetType(context));
        AppMethodBeat.o(92775);
        return isWap;
    }

    public static boolean isWap(int i) {
        return i == 2 || i == 5 || i == 7 || i == 3;
    }

    public static boolean is3G(Context context) {
        AppMethodBeat.i(92776);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(92776);
                return false;
            }
            if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                AppMethodBeat.o(92776);
                return true;
            }
            AppMethodBeat.o(92776);
            return false;
        } catch (Exception e) {
        }
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.i(92777);
        boolean isWifi = isWifi(getNetType(context));
        AppMethodBeat.o(92777);
        return isWifi;
    }

    public static boolean isWifi(int i) {
        return i == 0;
    }

    public static WifiInfo getWifiInfo(Context context) {
        AppMethodBeat.i(92778);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(92778);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                AppMethodBeat.o(92778);
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                AppMethodBeat.o(92778);
                return null;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.o(92778);
            return connectionInfo;
        } catch (Exception e) {
            AppMethodBeat.o(92778);
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        AppMethodBeat.i(92779);
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            int i2 = 0;
                            while (i2 < size) {
                                try {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        AppMethodBeat.o(92779);
                                        return intent2;
                                    }
                                    i2++;
                                } catch (Exception e) {
                                }
                            }
                            continue;
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                    }
                }
            }
        } catch (Exception e3) {
        }
        AppMethodBeat.o(92779);
        return null;
    }

    public static void startSettingItent(Context context, int i) {
        AppMethodBeat.i(92780);
        Intent intent;
        switch (i) {
            case 0:
                AppMethodBeat.o(92780);
                return;
            case 1:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    AppMethodBeat.o(92780);
                    return;
                } catch (Exception e) {
                    searchIntentByClass(context, "DevelopmentSettings");
                    AppMethodBeat.o(92780);
                    return;
                }
            case 2:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    AppMethodBeat.o(92780);
                    return;
                } catch (Exception e2) {
                    try {
                        intent = new Intent("/");
                        intent.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent.setAction("android.intent.action.VIEW");
                        context.startActivity(intent);
                        AppMethodBeat.o(92780);
                        return;
                    } catch (Exception e3) {
                        searchIntentByClass(context, "ManageAccountsSettings");
                        AppMethodBeat.o(92780);
                        return;
                    }
                }
            case 3:
                try {
                    intent = new Intent();
                    intent.setAction("android.settings.WIFI_IP_SETTINGS");
                    context.startActivity(intent);
                    AppMethodBeat.o(92780);
                    return;
                } catch (Exception e4) {
                    searchIntentByClass(context, "AdvancedSettings");
                    break;
                }
        }
        AppMethodBeat.o(92780);
    }

    public static int getWifiSleeepPolicy(Context context) {
        AppMethodBeat.i(92781);
        int i = System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
        AppMethodBeat.o(92781);
        return i;
    }

    public static boolean isLimited(int i) {
        return i == 2 || i == 1 || i == 3;
    }

    public static int getBackgroundLimitType(Context context) {
        AppMethodBeat.i(92782);
        if (VERSION.SDK_INT >= 14) {
            try {
                Class cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    AppMethodBeat.o(92782);
                    return 1;
                }
            } catch (Exception e) {
            }
        }
        try {
            int wifiSleeepPolicy = getWifiSleeepPolicy(context);
            if (wifiSleeepPolicy == 2 || getNetType(context) != 0) {
                AppMethodBeat.o(92782);
                return 0;
            }
            if (wifiSleeepPolicy == 1 || wifiSleeepPolicy == 0) {
                AppMethodBeat.o(92782);
                return 3;
            }
            AppMethodBeat.o(92782);
            return 0;
        } catch (Exception e2) {
        }
    }

    public static boolean isImmediatelyDestroyActivities(Context context) {
        AppMethodBeat.i(92783);
        if (System.getInt(context.getContentResolver(), "always_finish_activities", 0) != 0) {
            AppMethodBeat.o(92783);
            return true;
        }
        AppMethodBeat.o(92783);
        return false;
    }

    public static int getProxyInfo(Context context, StringBuffer stringBuffer) {
        AppMethodBeat.i(92784);
        try {
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null || defaultHost.length() <= 0 || defaultPort <= 0) {
                defaultHost = System.getProperty("http.proxyHost");
                String property = System.getProperty("http.proxyPort");
                defaultPort = 80;
                if (property != null && property.length() > 0) {
                    defaultPort = Integer.parseInt(property);
                }
                if (defaultHost != null && defaultHost.length() > 0) {
                    stringBuffer.append(defaultHost);
                    AppMethodBeat.o(92784);
                    return defaultPort;
                }
                AppMethodBeat.o(92784);
                return 0;
            }
            stringBuffer.append(defaultHost);
            AppMethodBeat.o(92784);
            return defaultPort;
        } catch (Exception e) {
        }
    }

    public static boolean isKnownDirectNet(Context context) {
        AppMethodBeat.i(92785);
        int netType = getNetType(context);
        if (6 == netType || 1 == netType || 4 == netType || 8 == netType || 10 == netType || netType == 0) {
            AppMethodBeat.o(92785);
            return true;
        }
        AppMethodBeat.o(92785);
        return false;
    }

    public static boolean isNetworkConnected(Context context) {
        AppMethodBeat.i(92786);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(92786);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(92786);
            return false;
        } else if (activeNetworkInfo.getState() == State.CONNECTED) {
            AppMethodBeat.o(92786);
            return true;
        } else {
            AppMethodBeat.o(92786);
            return false;
        }
    }

    public static int getNetTypeForStat(Context context) {
        AppMethodBeat.i(92787);
        if (context == null) {
            AppMethodBeat.o(92787);
            return 999;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(92787);
                return 999;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(92787);
                return 999;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(92787);
                return 1;
            } else {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 0) {
                    AppMethodBeat.o(92787);
                    return 999;
                }
                subtype *= 1000;
                AppMethodBeat.o(92787);
                return subtype;
            }
        } catch (Exception e) {
            AppMethodBeat.o(92787);
            return 999;
        }
    }

    public static int getStrength(Context context) {
        AppMethodBeat.i(92788);
        if (context == null) {
            AppMethodBeat.o(92788);
            return 0;
        }
        try {
            int abs;
            if (getNetTypeForStat(context) == 1) {
                abs = Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
                AppMethodBeat.o(92788);
                return abs;
            }
            ((TelephonyManager) context.getSystemService("phone")).listen(new StrengthListener(), 256);
            abs = Math.abs(nowStrength);
            AppMethodBeat.o(92788);
            return abs;
        } catch (Exception e) {
            AppMethodBeat.o(92788);
            return 0;
        }
    }
}
