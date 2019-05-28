package com.tencent.mm.sdk.platformtools;

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
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.System;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import com.tencent.ttpic.baseutils.IOUtils;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public final class at {
    private static int nowStrength = Downloads.MIN_WAIT_FOR_NETWORK;
    private static int nwY = -1;
    private static PhoneStateListener xAt = null;
    private static int xAu = Downloads.MIN_WAIT_FOR_NETWORK;

    public static class a {
        public String org;
        public String orh;
        public String ori;
        public String systemId;
        public String type;
        public String tzp;
        public String tzr;
        public String tzs;
        public String tzt;

        public a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
            this.org = str;
            this.orh = str2;
            this.tzp = str3;
            this.type = str6;
            this.ori = str4;
            this.tzr = str7;
            this.tzs = str8;
            this.systemId = str9;
            this.tzt = str5;
        }
    }

    public static String gA(Context context) {
        AppMethodBeat.i(52171);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            stringBuilder.append("isAvailable " + activeNetworkInfo.isAvailable() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("isAvailable " + activeNetworkInfo.isAvailable() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("isConnected " + activeNetworkInfo.isConnected() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("isRoaming " + activeNetworkInfo.isRoaming() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("isFailover " + activeNetworkInfo.isFailover() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("getSubtypeName " + activeNetworkInfo.getSubtypeName() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("getSubtype " + activeNetworkInfo.getSubtype() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("getType " + activeNetworkInfo.getType() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("getExtraInfo " + activeNetworkInfo.getExtraInfo() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("activeNetInfo " + activeNetworkInfo.toString() + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("is2G " + is2G(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("is3G " + is3G(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("is4G " + is4G(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("isWifi " + isWifi(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            ab.i("MicroMsg.NetStatusUtil", "netstatus " + stringBuilder.toString());
        } catch (Exception e) {
            ab.i("MicroMsg.NetStatusUtil", e.getMessage());
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(52171);
        return stringBuilder2;
    }

    public static boolean isConnected(Context context) {
        AppMethodBeat.i(52172);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(52172);
            return false;
        }
        boolean isConnected;
        try {
            isConnected = connectivityManager.getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            isConnected = false;
        }
        AppMethodBeat.o(52172);
        return isConnected;
    }

    public static String getNetTypeString(Context context) {
        AppMethodBeat.i(52173);
        String str;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                str = "NON_NETWORK";
                AppMethodBeat.o(52173);
                return str;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = "NON_NETWORK";
                AppMethodBeat.o(52173);
                return str;
            } else if (activeNetworkInfo.getType() == 1) {
                str = "WIFI";
                AppMethodBeat.o(52173);
                return str;
            } else {
                ab.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
                if (activeNetworkInfo.getExtraInfo() != null) {
                    str = activeNetworkInfo.getExtraInfo();
                    AppMethodBeat.o(52173);
                    return str;
                }
                str = "MOBILE";
                AppMethodBeat.o(52173);
                return str;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            str = "NON_NETWORK";
            AppMethodBeat.o(52173);
            return str;
        }
    }

    public static String gB(Context context) {
        AppMethodBeat.i(52174);
        String str;
        if (is2G(context)) {
            str = "2G";
            AppMethodBeat.o(52174);
            return str;
        } else if (is3G(context)) {
            str = "3G";
            AppMethodBeat.o(52174);
            return str;
        } else if (is4G(context)) {
            str = "4G";
            AppMethodBeat.o(52174);
            return str;
        } else if (isWifi(context)) {
            str = "WIFI";
            AppMethodBeat.o(52174);
            return str;
        } else {
            str = getNetTypeString(context);
            AppMethodBeat.o(52174);
            return str;
        }
    }

    public static int gC(Context context) {
        AppMethodBeat.i(52175);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52175);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52175);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.o(52175);
                return 2;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(52175);
                return 4;
            } else {
                if (activeNetworkInfo.getSubtype() >= 3) {
                    AppMethodBeat.o(52175);
                    return 3;
                }
                AppMethodBeat.o(52175);
                return 0;
            }
        } catch (Exception e) {
        }
    }

    public static int gD(Context context) {
        AppMethodBeat.i(52176);
        try {
            int netType = getNetType(context);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52176);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52176);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.o(52176);
                return 3;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.o(52176);
                return 5;
            } else if (activeNetworkInfo.getSubtype() >= 3) {
                AppMethodBeat.o(52176);
                return 4;
            } else {
                if (isWap(netType)) {
                    AppMethodBeat.o(52176);
                    return 2;
                }
                AppMethodBeat.o(52176);
                return 0;
            }
        } catch (Exception e) {
        }
    }

    public static int getNetWorkType(Context context) {
        AppMethodBeat.i(52177);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                AppMethodBeat.o(52177);
                return type;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
        AppMethodBeat.o(52177);
        return -1;
    }

    public static int getNetType(Context context) {
        AppMethodBeat.i(52178);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(52178);
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(52178);
            return -1;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.o(52178);
            return 0;
        } else {
            ab.d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
            if (activeNetworkInfo.getExtraInfo() != null) {
                if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                    AppMethodBeat.o(52178);
                    return 1;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                    AppMethodBeat.o(52178);
                    return 2;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                    AppMethodBeat.o(52178);
                    return 3;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                    AppMethodBeat.o(52178);
                    return 4;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                    AppMethodBeat.o(52178);
                    return 5;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                    AppMethodBeat.o(52178);
                    return 6;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                    AppMethodBeat.o(52178);
                    return 7;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                    AppMethodBeat.o(52178);
                    return 8;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE")) {
                    AppMethodBeat.o(52178);
                    return 10;
                }
            }
            AppMethodBeat.o(52178);
            return 9;
        }
    }

    public static int getISPCode(Context context) {
        AppMethodBeat.i(52179);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            AppMethodBeat.o(52179);
            return 0;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            AppMethodBeat.o(52179);
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
            AppMethodBeat.o(52179);
            return length;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.o(52179);
            return 0;
        }
    }

    public static String getISPName(Context context) {
        AppMethodBeat.i(52180);
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                str = "";
                AppMethodBeat.o(52180);
                return str;
            }
            ab.d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimOperatorName().length() <= 100) {
                str = telephonyManager.getSimOperatorName();
                AppMethodBeat.o(52180);
                return str;
            }
            str = telephonyManager.getSimOperatorName().substring(0, 100);
            AppMethodBeat.o(52180);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.o(52180);
            return str;
        }
    }

    public static boolean isMobile(Context context) {
        AppMethodBeat.i(52181);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52181);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52181);
                return false;
            } else {
                AppMethodBeat.o(52181);
                return true;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.o(52181);
            return false;
        }
    }

    public static boolean is2G(Context context) {
        AppMethodBeat.i(52182);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52182);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52182);
                return false;
            } else {
                ab.d("MicroMsg.NetStatusUtil", "is2G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                    AppMethodBeat.o(52182);
                    return true;
                }
                AppMethodBeat.o(52182);
                return false;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
    }

    public static boolean is4G(Context context) {
        AppMethodBeat.i(52183);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52183);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52183);
                return false;
            } else {
                ab.d("MicroMsg.NetStatusUtil", "is4G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 13) {
                    AppMethodBeat.o(52183);
                    return true;
                }
                AppMethodBeat.o(52183);
                return false;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
    }

    public static boolean isWap(Context context) {
        AppMethodBeat.i(52184);
        boolean isWap = isWap(getNetType(context));
        AppMethodBeat.o(52184);
        return isWap;
    }

    public static boolean isWap(int i) {
        if (i == 2 || i == 5 || i == 7 || i == 3) {
            return true;
        }
        return false;
    }

    public static boolean is3G(Context context) {
        AppMethodBeat.i(52185);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52185);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52185);
                return false;
            } else {
                ab.d("MicroMsg.NetStatusUtil", "is3G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.o(52185);
                    return true;
                }
                AppMethodBeat.o(52185);
                return false;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.i(52186);
        if (getNetType(context) == 0) {
            AppMethodBeat.o(52186);
            return true;
        }
        AppMethodBeat.o(52186);
        return false;
    }

    public static boolean isWifi(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static WifiInfo getWifiInfo(Context context) {
        AppMethodBeat.i(52187);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(52187);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                AppMethodBeat.o(52187);
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                AppMethodBeat.o(52187);
                return null;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.o(52187);
            return connectionInfo;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.o(52187);
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        AppMethodBeat.i(52188);
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                ab.e("MicroMsg.NetStatusUtil", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        ab.e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                ab.e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(size)));
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        AppMethodBeat.o(52188);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Exception e) {
                                ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                        ab.printErrStackTrace("MicroMsg.NetStatusUtil", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Exception e22) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e22, "", new Object[0]);
        }
        AppMethodBeat.o(52188);
        return null;
    }

    public static void startSettingItent(Context context, int i) {
        AppMethodBeat.i(52189);
        Intent intent;
        switch (i) {
            case 0:
                AppMethodBeat.o(52189);
                return;
            case 1:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    AppMethodBeat.o(52189);
                    return;
                } catch (Exception e) {
                    searchIntentByClass(context, "DevelopmentSettings");
                    AppMethodBeat.o(52189);
                    return;
                }
            case 2:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    AppMethodBeat.o(52189);
                    return;
                } catch (Exception e2) {
                    try {
                        intent = new Intent("/");
                        intent.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent.setAction("android.intent.action.VIEW");
                        context.startActivity(intent);
                        AppMethodBeat.o(52189);
                        return;
                    } catch (Exception e3) {
                        searchIntentByClass(context, "ManageAccountsSettings");
                        AppMethodBeat.o(52189);
                        return;
                    }
                }
            case 3:
                try {
                    intent = new Intent();
                    intent.setAction("android.settings.WIFI_IP_SETTINGS");
                    context.startActivity(intent);
                    AppMethodBeat.o(52189);
                    return;
                } catch (Exception e4) {
                    searchIntentByClass(context, "AdvancedSettings");
                    break;
                }
        }
        AppMethodBeat.o(52189);
    }

    public static String gE(Context context) {
        AppMethodBeat.i(52190);
        String str;
        if (getNetType(context) != 0) {
            ab.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiSsid() is empty");
            str = "";
            AppMethodBeat.o(52190);
            return str;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            str = "";
            AppMethodBeat.o(52190);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = "";
            AppMethodBeat.o(52190);
            return str;
        }
        String ssid = connectionInfo.getSSID();
        if (VERSION.SDK_INT >= 27) {
            for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                if (wifiConfiguration.networkId == connectionInfo.getNetworkId()) {
                    ab.i("MicroMsg.NetStatusUtil", "get wifi config ssid %s", wifiConfiguration.SSID);
                    str = wifiConfiguration.SSID;
                    break;
                }
            }
        }
        str = ssid;
        str = bo.nullAsNil(str);
        ab.i("MicroMsg.NetStatusUtil", "getConnectedWifiSsid()=" + Mv(str));
        str = Mv(str);
        AppMethodBeat.o(52190);
        return str;
    }

    public static String gF(Context context) {
        AppMethodBeat.i(52191);
        String str;
        if (getNetType(context) != 0) {
            ab.i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiBssid() is empty");
            str = "";
            AppMethodBeat.o(52191);
            return str;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            str = "";
            AppMethodBeat.o(52191);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = "";
            AppMethodBeat.o(52191);
            return str;
        }
        str = bo.nullAsNil(connectionInfo.getBSSID()).toLowerCase();
        ab.i("MicroMsg.NetStatusUtil", "getConnectedWifiBssid()=".concat(String.valueOf(str)));
        AppMethodBeat.o(52191);
        return str;
    }

    public static String gG(Context context) {
        AppMethodBeat.i(52192);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str;
        if (wifiManager == null) {
            ab.e("MicroMsg.NetStatusUtil", "error wifiManager is null!!");
            str = "";
            AppMethodBeat.o(52192);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            ab.e("MicroMsg.NetStatusUtil", "error wifiInfo is null!!");
            str = "";
            AppMethodBeat.o(52192);
            return str;
        }
        str = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
            str = dpd();
        }
        str = bo.nullAsNil(str).toLowerCase();
        ab.i("MicroMsg.NetStatusUtil", "getConnectedWifiClientMac()=".concat(String.valueOf(str)));
        AppMethodBeat.o(52192);
        return str;
    }

    private static String dpd() {
        String str;
        AppMethodBeat.i(52193);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str2 = "wlan0";
            if (NetworkInterface.getNetworkInterfaces() != null) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase(str2)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            ab.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                            str = "02:00:00:00:00:00";
                            AppMethodBeat.o(52193);
                            return str;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder.append(String.format("%02X:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder.length() > 0) {
                            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                        }
                        ab.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        str = stringBuilder.toString();
                        AppMethodBeat.o(52193);
                        return str;
                    }
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.NetStatusUtil", "get mobile mac from net fail!".concat(String.valueOf(e)));
        }
        ab.d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        str = "02:00:00:00:00:00";
        AppMethodBeat.o(52193);
        return str;
    }

    private static String Mv(String str) {
        AppMethodBeat.i(52194);
        if (bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(52194);
            return str;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        AppMethodBeat.o(52194);
        return str;
    }

    public static boolean isLimited(int i) {
        if (i == 2 || i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public static int getBackgroundLimitType(Context context) {
        AppMethodBeat.i(52195);
        if (VERSION.SDK_INT >= 14) {
            try {
                Class cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    AppMethodBeat.o(52195);
                    return 1;
                }
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            }
        }
        try {
            int i = System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
            if (i == 2 || getNetType(context) != 0) {
                AppMethodBeat.o(52195);
                return 0;
            }
            if (i == 1 || i == 0) {
                AppMethodBeat.o(52195);
                return 3;
            }
            AppMethodBeat.o(52195);
            return 0;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e2, "", new Object[0]);
        }
    }

    public static boolean isNetworkConnected(Context context) {
        AppMethodBeat.i(52196);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.o(52196);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.o(52196);
            return false;
        } else if (activeNetworkInfo.getState() != State.CONNECTED) {
            AppMethodBeat.o(52196);
            return false;
        } else {
            AppMethodBeat.o(52196);
            return true;
        }
    }

    public static int getNetTypeForStat(Context context) {
        AppMethodBeat.i(52197);
        if (context == null) {
            AppMethodBeat.o(52197);
            return 999;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(52197);
                return 999;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(52197);
                return 999;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.o(52197);
                return 1;
            } else {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 0) {
                    AppMethodBeat.o(52197);
                    return 999;
                }
                subtype *= 1000;
                AppMethodBeat.o(52197);
                return subtype;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.o(52197);
            return 999;
        }
    }

    public static boolean gH(Context context) {
        AppMethodBeat.i(52198);
        int netType = getNetType(context);
        if (netType == 0 || netType == 10) {
            ab.d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
            AppMethodBeat.o(52198);
            return true;
        }
        ab.d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
        AppMethodBeat.o(52198);
        return false;
    }

    public static synchronized void gI(Context context) {
        synchronized (at.class) {
            AppMethodBeat.i(52199);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            nwY = telephonyManager.getPhoneType();
            if (xAt == null) {
                xAt = new PhoneStateListener() {
                    public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
                        AppMethodBeat.i(52170);
                        super.onSignalStrengthsChanged(signalStrength);
                        if (at.nwY == 2) {
                            at.nowStrength = signalStrength.getCdmaDbm();
                        }
                        if (at.nwY == 1) {
                            at.nowStrength = (signalStrength.getGsmSignalStrength() * 2) - 113;
                        }
                        ab.i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", Integer.valueOf(at.nwY), Integer.valueOf(at.nowStrength));
                        AppMethodBeat.o(52170);
                    }
                };
                telephonyManager.listen(xAt, 256);
            }
            AppMethodBeat.o(52199);
        }
    }

    public static synchronized int getStrength(Context context) {
        int i;
        synchronized (at.class) {
            AppMethodBeat.i(52200);
            if (context == null) {
                AppMethodBeat.o(52200);
                i = 0;
            } else {
                try {
                    if (getNetTypeForStat(context) == 1) {
                        i = Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
                        AppMethodBeat.o(52200);
                    } else {
                        if (xAt == null) {
                            ab.e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
                        }
                        i = Math.abs(nowStrength);
                        AppMethodBeat.o(52200);
                    }
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
                    AppMethodBeat.o(52200);
                    i = 0;
                }
            }
        }
        return i;
    }

    public static synchronized List<a> gJ(Context context) {
        List<a> list;
        GsmCellLocation gsmCellLocation;
        int cid;
        int lac;
        List<NeighboringCellInfo> neighboringCellInfo;
        synchronized (at.class) {
            AppMethodBeat.i(52201);
            if (xAt == null) {
                ab.e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
                list = null;
                AppMethodBeat.o(52201);
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                LinkedList linkedList = new LinkedList();
                String str = "460";
                String str2 = "";
                Object list2;
                try {
                    String networkOperator = telephonyManager.getNetworkOperator();
                    if (networkOperator == null || networkOperator.equals("")) {
                        networkOperator = telephonyManager.getSimOperator();
                        if (!(networkOperator == null || networkOperator.equals(""))) {
                            str = networkOperator.substring(0, 3);
                            str2 = networkOperator.substring(3, 5);
                        }
                        networkOperator = str2;
                    } else {
                        str = networkOperator.substring(0, 3);
                        networkOperator = networkOperator.substring(3, 5);
                    }
                    String str3;
                    if (telephonyManager.getPhoneType() == 2) {
                        try {
                            CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                            if (cdmaCellLocation != null) {
                                str3 = nowStrength == xAu ? "" : nowStrength;
                                if (!(cdmaCellLocation.getBaseStationId() == -1 || cdmaCellLocation.getNetworkId() == -1 || cdmaCellLocation.getSystemId() == -1)) {
                                    linkedList.add(new a(str, networkOperator, "", "", str3, "cdma", cdmaCellLocation.getBaseStationId(), cdmaCellLocation.getNetworkId(), cdmaCellLocation.getSystemId()));
                                }
                            }
                        } catch (Exception e) {
                            try {
                                gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                                if (gsmCellLocation != null) {
                                    cid = gsmCellLocation.getCid();
                                    lac = gsmCellLocation.getLac();
                                    if (!(lac >= CdnLogic.kBizGeneric || lac == -1 || cid == -1)) {
                                        linkedList.add(new a(str, networkOperator, String.valueOf(lac), String.valueOf(cid), "", "gsm", "", "", ""));
                                    }
                                }
                            } catch (Exception e2) {
                                ab.printErrStackTrace("MicroMsg.NetStatusUtil", e2, "", new Object[0]);
                            }
                            neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                            if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                                    if (!(neighboringCellInfo2.getCid() == -1 || neighboringCellInfo2.getLac() > CdnLogic.kBizGeneric || neighboringCellInfo2.getLac() == -1)) {
                                        linkedList.add(new a(str, networkOperator, neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid(), ((neighboringCellInfo2.getRssi() * 2) - 113), "gsm", "", "", ""));
                                    }
                                }
                            }
                        }
                    } else {
                        try {
                            gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                            if (gsmCellLocation != null) {
                                cid = gsmCellLocation.getCid();
                                lac = gsmCellLocation.getLac();
                                if (!(lac >= CdnLogic.kBizGeneric || lac == -1 || cid == -1)) {
                                    linkedList.add(new a(str, networkOperator, String.valueOf(lac), String.valueOf(cid), nowStrength == xAu ? "" : nowStrength, "gsm", "", "", ""));
                                }
                            }
                        } catch (Exception e22) {
                            ab.printErrStackTrace("MicroMsg.NetStatusUtil", e22, "", new Object[0]);
                        }
                        neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                        if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                            for (NeighboringCellInfo neighboringCellInfo22 : neighboringCellInfo) {
                                if (neighboringCellInfo22.getCid() != -1 && neighboringCellInfo22.getLac() <= CdnLogic.kBizGeneric) {
                                    str3 = ((neighboringCellInfo22.getRssi() * 2) - 113);
                                    ab.v("checked", "lac:" + neighboringCellInfo22.getLac() + "  cid:" + neighboringCellInfo22.getCid() + " dbm:" + str3);
                                    linkedList.add(new a(str, networkOperator, neighboringCellInfo22.getLac(), neighboringCellInfo22.getCid(), str3, "gsm", "", "", ""));
                                }
                            }
                        }
                    }
                    AppMethodBeat.o(52201);
                    list2 = linkedList;
                } catch (Exception e222) {
                    ab.printErrStackTrace("MicroMsg.NetStatusUtil", e222, "", new Object[0]);
                    AppMethodBeat.o(52201);
                    list2 = linkedList;
                }
            }
        }
        return list2;
    }
}
