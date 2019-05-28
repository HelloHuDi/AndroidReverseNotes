package com.tencent.p177mm.sdk.platformtools;

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

/* renamed from: com.tencent.mm.sdk.platformtools.at */
public final class C5023at {
    private static int nowStrength = Downloads.MIN_WAIT_FOR_NETWORK;
    private static int nwY = -1;
    private static PhoneStateListener xAt = null;
    private static int xAu = Downloads.MIN_WAIT_FOR_NETWORK;

    /* renamed from: com.tencent.mm.sdk.platformtools.at$1 */
    static class C50211 extends PhoneStateListener {
        C50211() {
        }

        public final void onSignalStrengthsChanged(SignalStrength signalStrength) {
            AppMethodBeat.m2504i(52170);
            super.onSignalStrengthsChanged(signalStrength);
            if (C5023at.nwY == 2) {
                C5023at.nowStrength = signalStrength.getCdmaDbm();
            }
            if (C5023at.nwY == 1) {
                C5023at.nowStrength = (signalStrength.getGsmSignalStrength() * 2) - 113;
            }
            C4990ab.m7417i("MicroMsg.NetStatusUtil", "PhoneStateListener  type:%d  strength:%d", Integer.valueOf(C5023at.nwY), Integer.valueOf(C5023at.nowStrength));
            AppMethodBeat.m2505o(52170);
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.at$a */
    public static class C5022a {
        public String org;
        public String orh;
        public String ori;
        public String systemId;
        public String type;
        public String tzp;
        public String tzr;
        public String tzs;
        public String tzt;

        public C5022a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
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

    /* renamed from: gA */
    public static String m7470gA(Context context) {
        AppMethodBeat.m2504i(52171);
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
            stringBuilder.append("is2G " + C5023at.is2G(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("is3G " + C5023at.is3G(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("is4G " + C5023at.is4G(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            stringBuilder.append("isWifi " + C5023at.isWifi(context) + IOUtils.LINE_SEPARATOR_WINDOWS);
            C4990ab.m7416i("MicroMsg.NetStatusUtil", "netstatus " + stringBuilder.toString());
        } catch (Exception e) {
            C4990ab.m7416i("MicroMsg.NetStatusUtil", e.getMessage());
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(52171);
        return stringBuilder2;
    }

    public static boolean isConnected(Context context) {
        AppMethodBeat.m2504i(52172);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(52172);
            return false;
        }
        boolean isConnected;
        try {
            isConnected = connectivityManager.getActiveNetworkInfo().isConnected();
        } catch (Exception e) {
            isConnected = false;
        }
        AppMethodBeat.m2505o(52172);
        return isConnected;
    }

    public static String getNetTypeString(Context context) {
        AppMethodBeat.m2504i(52173);
        String str;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                str = "NON_NETWORK";
                AppMethodBeat.m2505o(52173);
                return str;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                str = "NON_NETWORK";
                AppMethodBeat.m2505o(52173);
                return str;
            } else if (activeNetworkInfo.getType() == 1) {
                str = "WIFI";
                AppMethodBeat.m2505o(52173);
                return str;
            } else {
                C4990ab.m7411d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
                if (activeNetworkInfo.getExtraInfo() != null) {
                    str = activeNetworkInfo.getExtraInfo();
                    AppMethodBeat.m2505o(52173);
                    return str;
                }
                str = "MOBILE";
                AppMethodBeat.m2505o(52173);
                return str;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            str = "NON_NETWORK";
            AppMethodBeat.m2505o(52173);
            return str;
        }
    }

    /* renamed from: gB */
    public static String m7471gB(Context context) {
        AppMethodBeat.m2504i(52174);
        String str;
        if (C5023at.is2G(context)) {
            str = "2G";
            AppMethodBeat.m2505o(52174);
            return str;
        } else if (C5023at.is3G(context)) {
            str = "3G";
            AppMethodBeat.m2505o(52174);
            return str;
        } else if (C5023at.is4G(context)) {
            str = "4G";
            AppMethodBeat.m2505o(52174);
            return str;
        } else if (C5023at.isWifi(context)) {
            str = "WIFI";
            AppMethodBeat.m2505o(52174);
            return str;
        } else {
            str = C5023at.getNetTypeString(context);
            AppMethodBeat.m2505o(52174);
            return str;
        }
    }

    /* renamed from: gC */
    public static int m7472gC(Context context) {
        AppMethodBeat.m2504i(52175);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52175);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52175);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.m2505o(52175);
                return 2;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.m2505o(52175);
                return 4;
            } else {
                if (activeNetworkInfo.getSubtype() >= 3) {
                    AppMethodBeat.m2505o(52175);
                    return 3;
                }
                AppMethodBeat.m2505o(52175);
                return 0;
            }
        } catch (Exception e) {
        }
    }

    /* renamed from: gD */
    public static int m7473gD(Context context) {
        AppMethodBeat.m2504i(52176);
        try {
            int netType = C5023at.getNetType(context);
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52176);
                return 0;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52176);
                return 1;
            } else if (activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 2) {
                AppMethodBeat.m2505o(52176);
                return 3;
            } else if (activeNetworkInfo.getSubtype() >= 13) {
                AppMethodBeat.m2505o(52176);
                return 5;
            } else if (activeNetworkInfo.getSubtype() >= 3) {
                AppMethodBeat.m2505o(52176);
                return 4;
            } else {
                if (C5023at.isWap(netType)) {
                    AppMethodBeat.m2505o(52176);
                    return 2;
                }
                AppMethodBeat.m2505o(52176);
                return 0;
            }
        } catch (Exception e) {
        }
    }

    public static int getNetWorkType(Context context) {
        AppMethodBeat.m2504i(52177);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                AppMethodBeat.m2505o(52177);
                return type;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(52177);
        return -1;
    }

    public static int getNetType(Context context) {
        AppMethodBeat.m2504i(52178);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(52178);
            return -1;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(52178);
            return -1;
        } else if (activeNetworkInfo.getType() == 1) {
            AppMethodBeat.m2505o(52178);
            return 0;
        } else {
            C4990ab.m7411d("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", activeNetworkInfo.getExtraInfo(), Integer.valueOf(activeNetworkInfo.getType()));
            if (activeNetworkInfo.getExtraInfo() != null) {
                if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uninet")) {
                    AppMethodBeat.m2505o(52178);
                    return 1;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("uniwap")) {
                    AppMethodBeat.m2505o(52178);
                    return 2;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gwap")) {
                    AppMethodBeat.m2505o(52178);
                    return 3;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("3gnet")) {
                    AppMethodBeat.m2505o(52178);
                    return 4;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmwap")) {
                    AppMethodBeat.m2505o(52178);
                    return 5;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("cmnet")) {
                    AppMethodBeat.m2505o(52178);
                    return 6;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctwap")) {
                    AppMethodBeat.m2505o(52178);
                    return 7;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("ctnet")) {
                    AppMethodBeat.m2505o(52178);
                    return 8;
                } else if (activeNetworkInfo.getExtraInfo().equalsIgnoreCase("LTE")) {
                    AppMethodBeat.m2505o(52178);
                    return 10;
                }
            }
            AppMethodBeat.m2505o(52178);
            return 9;
        }
    }

    public static int getISPCode(Context context) {
        AppMethodBeat.m2504i(52179);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            AppMethodBeat.m2505o(52179);
            return 0;
        }
        String simOperator = telephonyManager.getSimOperator();
        if (simOperator == null || simOperator.length() < 5) {
            AppMethodBeat.m2505o(52179);
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
            AppMethodBeat.m2505o(52179);
            return length;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(52179);
            return 0;
        }
    }

    public static String getISPName(Context context) {
        AppMethodBeat.m2504i(52180);
        String str;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                str = "";
                AppMethodBeat.m2505o(52180);
                return str;
            }
            C4990ab.m7411d("MicroMsg.NetStatusUtil", "getISPName ISPName=%s", telephonyManager.getSimOperatorName());
            if (telephonyManager.getSimOperatorName().length() <= 100) {
                str = telephonyManager.getSimOperatorName();
                AppMethodBeat.m2505o(52180);
                return str;
            }
            str = telephonyManager.getSimOperatorName().substring(0, 100);
            AppMethodBeat.m2505o(52180);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.m2505o(52180);
            return str;
        }
    }

    public static boolean isMobile(Context context) {
        AppMethodBeat.m2504i(52181);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52181);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52181);
                return false;
            } else {
                AppMethodBeat.m2505o(52181);
                return true;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(52181);
            return false;
        }
    }

    public static boolean is2G(Context context) {
        AppMethodBeat.m2504i(52182);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52182);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52182);
                return false;
            } else {
                C4990ab.m7411d("MicroMsg.NetStatusUtil", "is2G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() == 2 || activeNetworkInfo.getSubtype() == 1 || activeNetworkInfo.getSubtype() == 4) {
                    AppMethodBeat.m2505o(52182);
                    return true;
                }
                AppMethodBeat.m2505o(52182);
                return false;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
    }

    public static boolean is4G(Context context) {
        AppMethodBeat.m2504i(52183);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52183);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52183);
                return false;
            } else {
                C4990ab.m7411d("MicroMsg.NetStatusUtil", "is4G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 13) {
                    AppMethodBeat.m2505o(52183);
                    return true;
                }
                AppMethodBeat.m2505o(52183);
                return false;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
    }

    public static boolean isWap(Context context) {
        AppMethodBeat.m2504i(52184);
        boolean isWap = C5023at.isWap(C5023at.getNetType(context));
        AppMethodBeat.m2505o(52184);
        return isWap;
    }

    public static boolean isWap(int i) {
        if (i == 2 || i == 5 || i == 7 || i == 3) {
            return true;
        }
        return false;
    }

    public static boolean is3G(Context context) {
        AppMethodBeat.m2504i(52185);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52185);
                return false;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52185);
                return false;
            } else {
                C4990ab.m7411d("MicroMsg.NetStatusUtil", "is3G subtype %d", Integer.valueOf(activeNetworkInfo.getSubtype()));
                if (activeNetworkInfo.getSubtype() >= 5 && activeNetworkInfo.getSubtype() < 13) {
                    AppMethodBeat.m2505o(52185);
                    return true;
                }
                AppMethodBeat.m2505o(52185);
                return false;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
        }
    }

    public static boolean isWifi(Context context) {
        AppMethodBeat.m2504i(52186);
        if (C5023at.getNetType(context) == 0) {
            AppMethodBeat.m2505o(52186);
            return true;
        }
        AppMethodBeat.m2505o(52186);
        return false;
    }

    public static boolean isWifi(int i) {
        if (i == 0) {
            return true;
        }
        return false;
    }

    public static WifiInfo getWifiInfo(Context context) {
        AppMethodBeat.m2504i(52187);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.m2505o(52187);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || 1 != activeNetworkInfo.getType()) {
                AppMethodBeat.m2505o(52187);
                return null;
            }
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager == null) {
                AppMethodBeat.m2505o(52187);
                return null;
            }
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.m2505o(52187);
            return connectionInfo;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(52187);
            return null;
        }
    }

    private static Intent searchIntentByClass(Context context, String str) {
        AppMethodBeat.m2504i(52188);
        try {
            PackageManager packageManager = context.getPackageManager();
            List installedPackages = packageManager.getInstalledPackages(0);
            if (installedPackages != null && installedPackages.size() > 0) {
                C4990ab.m7412e("MicroMsg.NetStatusUtil", "package  size" + installedPackages.size());
                for (int i = 0; i < installedPackages.size(); i++) {
                    try {
                        C4990ab.m7412e("MicroMsg.NetStatusUtil", "package " + ((PackageInfo) installedPackages.get(i)).packageName);
                        Intent intent = new Intent();
                        intent.setPackage(((PackageInfo) installedPackages.get(i)).packageName);
                        List queryIntentActivities = packageManager.queryIntentActivities(intent, 0);
                        int size = queryIntentActivities != null ? queryIntentActivities.size() : 0;
                        if (size > 0) {
                            try {
                                C4990ab.m7412e("MicroMsg.NetStatusUtil", "activityName count ".concat(String.valueOf(size)));
                                for (int i2 = 0; i2 < size; i2++) {
                                    ActivityInfo activityInfo = ((ResolveInfo) queryIntentActivities.get(i2)).activityInfo;
                                    if (activityInfo.name.contains(str)) {
                                        Intent intent2 = new Intent("/");
                                        intent2.setComponent(new ComponentName(activityInfo.packageName, activityInfo.name));
                                        intent2.setAction("android.intent.action.VIEW");
                                        context.startActivity(intent2);
                                        AppMethodBeat.m2505o(52188);
                                        return intent2;
                                    }
                                }
                                continue;
                            } catch (Exception e) {
                                C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
                            }
                        } else {
                            continue;
                        }
                    } catch (Exception e2) {
                        C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e2, "", new Object[0]);
                    }
                }
            }
        } catch (Exception e22) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e22, "", new Object[0]);
        }
        AppMethodBeat.m2505o(52188);
        return null;
    }

    public static void startSettingItent(Context context, int i) {
        AppMethodBeat.m2504i(52189);
        Intent intent;
        switch (i) {
            case 0:
                AppMethodBeat.m2505o(52189);
                return;
            case 1:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.DevelopmentSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(52189);
                    return;
                } catch (Exception e) {
                    C5023at.searchIntentByClass(context, "DevelopmentSettings");
                    AppMethodBeat.m2505o(52189);
                    return;
                }
            case 2:
                try {
                    intent = new Intent("/");
                    intent.setComponent(new ComponentName("com.android.providers.subscribedfeeds", "com.android.settings.ManageAccountsSettings"));
                    intent.setAction("android.intent.action.VIEW");
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(52189);
                    return;
                } catch (Exception e2) {
                    try {
                        intent = new Intent("/");
                        intent.setComponent(new ComponentName("com.htc.settings.accountsync", "com.htc.settings.accountsync.ManageAccountsSettings"));
                        intent.setAction("android.intent.action.VIEW");
                        context.startActivity(intent);
                        AppMethodBeat.m2505o(52189);
                        return;
                    } catch (Exception e3) {
                        C5023at.searchIntentByClass(context, "ManageAccountsSettings");
                        AppMethodBeat.m2505o(52189);
                        return;
                    }
                }
            case 3:
                try {
                    intent = new Intent();
                    intent.setAction("android.settings.WIFI_IP_SETTINGS");
                    context.startActivity(intent);
                    AppMethodBeat.m2505o(52189);
                    return;
                } catch (Exception e4) {
                    C5023at.searchIntentByClass(context, "AdvancedSettings");
                    break;
                }
        }
        AppMethodBeat.m2505o(52189);
    }

    /* renamed from: gE */
    public static String m7474gE(Context context) {
        AppMethodBeat.m2504i(52190);
        String str;
        if (C5023at.getNetType(context) != 0) {
            C4990ab.m7416i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiSsid() is empty");
            str = "";
            AppMethodBeat.m2505o(52190);
            return str;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            str = "";
            AppMethodBeat.m2505o(52190);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = "";
            AppMethodBeat.m2505o(52190);
            return str;
        }
        String ssid = connectionInfo.getSSID();
        if (VERSION.SDK_INT >= 27) {
            for (WifiConfiguration wifiConfiguration : wifiManager.getConfiguredNetworks()) {
                if (wifiConfiguration.networkId == connectionInfo.getNetworkId()) {
                    C4990ab.m7417i("MicroMsg.NetStatusUtil", "get wifi config ssid %s", wifiConfiguration.SSID);
                    str = wifiConfiguration.SSID;
                    break;
                }
            }
        }
        str = ssid;
        str = C5046bo.nullAsNil(str);
        C4990ab.m7416i("MicroMsg.NetStatusUtil", "getConnectedWifiSsid()=" + C5023at.m7469Mv(str));
        str = C5023at.m7469Mv(str);
        AppMethodBeat.m2505o(52190);
        return str;
    }

    /* renamed from: gF */
    public static String m7475gF(Context context) {
        AppMethodBeat.m2504i(52191);
        String str;
        if (C5023at.getNetType(context) != 0) {
            C4990ab.m7416i("MicroMsg.NetStatusUtil", "wifi not connected. getConnectedWifiBssid() is empty");
            str = "";
            AppMethodBeat.m2505o(52191);
            return str;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager == null) {
            str = "";
            AppMethodBeat.m2505o(52191);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = "";
            AppMethodBeat.m2505o(52191);
            return str;
        }
        str = C5046bo.nullAsNil(connectionInfo.getBSSID()).toLowerCase();
        C4990ab.m7416i("MicroMsg.NetStatusUtil", "getConnectedWifiBssid()=".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(52191);
        return str;
    }

    /* renamed from: gG */
    public static String m7476gG(Context context) {
        AppMethodBeat.m2504i(52192);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str;
        if (wifiManager == null) {
            C4990ab.m7412e("MicroMsg.NetStatusUtil", "error wifiManager is null!!");
            str = "";
            AppMethodBeat.m2505o(52192);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            C4990ab.m7412e("MicroMsg.NetStatusUtil", "error wifiInfo is null!!");
            str = "";
            AppMethodBeat.m2505o(52192);
            return str;
        }
        str = connectionInfo.getMacAddress();
        if (VERSION.SDK_INT > 22 && (str == null || str.equals("02:00:00:00:00:00"))) {
            str = C5023at.dpd();
        }
        str = C5046bo.nullAsNil(str).toLowerCase();
        C4990ab.m7416i("MicroMsg.NetStatusUtil", "getConnectedWifiClientMac()=".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(52192);
        return str;
    }

    private static String dpd() {
        String str;
        AppMethodBeat.m2504i(52193);
        long currentTimeMillis = System.currentTimeMillis();
        try {
            String str2 = "wlan0";
            if (NetworkInterface.getNetworkInterfaces() != null) {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase(str2)) {
                        byte[] hardwareAddress = networkInterface.getHardwareAddress();
                        if (hardwareAddress == null) {
                            C4990ab.m7410d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                            str = "02:00:00:00:00:00";
                            AppMethodBeat.m2505o(52193);
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
                        C4990ab.m7410d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
                        str = stringBuilder.toString();
                        AppMethodBeat.m2505o(52193);
                        return str;
                    }
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.NetStatusUtil", "get mobile mac from net fail!".concat(String.valueOf(e)));
        }
        C4990ab.m7410d("MicroMsg.NetStatusUtil", "et mobile mac from net time cost :" + (System.currentTimeMillis() - currentTimeMillis));
        str = "02:00:00:00:00:00";
        AppMethodBeat.m2505o(52193);
        return str;
    }

    /* renamed from: Mv */
    private static String m7469Mv(String str) {
        AppMethodBeat.m2504i(52194);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(52194);
            return str;
        }
        if (str.startsWith("\"") && str.endsWith("\"")) {
            str = str.substring(1, str.length() - 1);
        }
        AppMethodBeat.m2505o(52194);
        return str;
    }

    public static boolean isLimited(int i) {
        if (i == 2 || i == 1 || i == 3) {
            return true;
        }
        return false;
    }

    public static int getBackgroundLimitType(Context context) {
        AppMethodBeat.m2504i(52195);
        if (VERSION.SDK_INT >= 14) {
            try {
                Class cls = Class.forName("android.app.ActivityManagerNative");
                Object invoke = cls.getMethod("getDefault", new Class[0]).invoke(cls, new Object[0]);
                if (((Integer) invoke.getClass().getMethod("getProcessLimit", new Class[0]).invoke(invoke, new Object[0])).intValue() == 0) {
                    AppMethodBeat.m2505o(52195);
                    return 1;
                }
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            }
        }
        try {
            int i = System.getInt(context.getContentResolver(), "wifi_sleep_policy", 2);
            if (i == 2 || C5023at.getNetType(context) != 0) {
                AppMethodBeat.m2505o(52195);
                return 0;
            }
            if (i == 1 || i == 0) {
                AppMethodBeat.m2505o(52195);
                return 3;
            }
            AppMethodBeat.m2505o(52195);
            return 0;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e2, "", new Object[0]);
        }
    }

    public static boolean isNetworkConnected(Context context) {
        AppMethodBeat.m2504i(52196);
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            AppMethodBeat.m2505o(52196);
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            AppMethodBeat.m2505o(52196);
            return false;
        } else if (activeNetworkInfo.getState() != State.CONNECTED) {
            AppMethodBeat.m2505o(52196);
            return false;
        } else {
            AppMethodBeat.m2505o(52196);
            return true;
        }
    }

    public static int getNetTypeForStat(Context context) {
        AppMethodBeat.m2504i(52197);
        if (context == null) {
            AppMethodBeat.m2505o(52197);
            return 999;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.m2505o(52197);
                return 999;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(52197);
                return 999;
            } else if (activeNetworkInfo.getType() == 1) {
                AppMethodBeat.m2505o(52197);
                return 1;
            } else {
                int subtype = activeNetworkInfo.getSubtype();
                if (subtype == 0) {
                    AppMethodBeat.m2505o(52197);
                    return 999;
                }
                subtype *= 1000;
                AppMethodBeat.m2505o(52197);
                return subtype;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
            AppMethodBeat.m2505o(52197);
            return 999;
        }
    }

    /* renamed from: gH */
    public static boolean m7477gH(Context context) {
        AppMethodBeat.m2504i(52198);
        int netType = C5023at.getNetType(context);
        if (netType == 0 || netType == 10) {
            C4990ab.m7410d("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
            AppMethodBeat.m2505o(52198);
            return true;
        }
        C4990ab.m7410d("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
        AppMethodBeat.m2505o(52198);
        return false;
    }

    /* renamed from: gI */
    public static synchronized void m7478gI(Context context) {
        synchronized (C5023at.class) {
            AppMethodBeat.m2504i(52199);
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            nwY = telephonyManager.getPhoneType();
            if (xAt == null) {
                xAt = new C50211();
                telephonyManager.listen(xAt, 256);
            }
            AppMethodBeat.m2505o(52199);
        }
    }

    public static synchronized int getStrength(Context context) {
        int i;
        synchronized (C5023at.class) {
            AppMethodBeat.m2504i(52200);
            if (context == null) {
                AppMethodBeat.m2505o(52200);
                i = 0;
            } else {
                try {
                    if (C5023at.getNetTypeForStat(context) == 1) {
                        i = Math.abs(((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getRssi());
                        AppMethodBeat.m2505o(52200);
                    } else {
                        if (xAt == null) {
                            C4990ab.m7412e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
                        }
                        i = Math.abs(nowStrength);
                        AppMethodBeat.m2505o(52200);
                    }
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e, "", new Object[0]);
                    AppMethodBeat.m2505o(52200);
                    i = 0;
                }
            }
        }
        return i;
    }

    /* renamed from: gJ */
    public static synchronized List<C5022a> m7479gJ(Context context) {
        List<C5022a> list;
        GsmCellLocation gsmCellLocation;
        int cid;
        int lac;
        List<NeighboringCellInfo> neighboringCellInfo;
        synchronized (C5023at.class) {
            AppMethodBeat.m2504i(52201);
            if (xAt == null) {
                C4990ab.m7412e("MicroMsg.NetStatusUtil", "getStrength phone Listener has not been inited");
                list = null;
                AppMethodBeat.m2505o(52201);
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
                                    linkedList.add(new C5022a(str, networkOperator, "", "", str3, "cdma", cdmaCellLocation.getBaseStationId(), cdmaCellLocation.getNetworkId(), cdmaCellLocation.getSystemId()));
                                }
                            }
                        } catch (Exception e) {
                            try {
                                gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
                                if (gsmCellLocation != null) {
                                    cid = gsmCellLocation.getCid();
                                    lac = gsmCellLocation.getLac();
                                    if (!(lac >= CdnLogic.kBizGeneric || lac == -1 || cid == -1)) {
                                        linkedList.add(new C5022a(str, networkOperator, String.valueOf(lac), String.valueOf(cid), "", "gsm", "", "", ""));
                                    }
                                }
                            } catch (Exception e2) {
                                C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e2, "", new Object[0]);
                            }
                            neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                            if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                                for (NeighboringCellInfo neighboringCellInfo2 : neighboringCellInfo) {
                                    if (!(neighboringCellInfo2.getCid() == -1 || neighboringCellInfo2.getLac() > CdnLogic.kBizGeneric || neighboringCellInfo2.getLac() == -1)) {
                                        linkedList.add(new C5022a(str, networkOperator, neighboringCellInfo2.getLac(), neighboringCellInfo2.getCid(), ((neighboringCellInfo2.getRssi() * 2) - 113), "gsm", "", "", ""));
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
                                    linkedList.add(new C5022a(str, networkOperator, String.valueOf(lac), String.valueOf(cid), nowStrength == xAu ? "" : nowStrength, "gsm", "", "", ""));
                                }
                            }
                        } catch (Exception e22) {
                            C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e22, "", new Object[0]);
                        }
                        neighboringCellInfo = telephonyManager.getNeighboringCellInfo();
                        if (neighboringCellInfo != null && neighboringCellInfo.size() > 0) {
                            for (NeighboringCellInfo neighboringCellInfo22 : neighboringCellInfo) {
                                if (neighboringCellInfo22.getCid() != -1 && neighboringCellInfo22.getLac() <= CdnLogic.kBizGeneric) {
                                    str3 = ((neighboringCellInfo22.getRssi() * 2) - 113);
                                    C4990ab.m7418v("checked", "lac:" + neighboringCellInfo22.getLac() + "  cid:" + neighboringCellInfo22.getCid() + " dbm:" + str3);
                                    linkedList.add(new C5022a(str, networkOperator, neighboringCellInfo22.getLac(), neighboringCellInfo22.getCid(), str3, "gsm", "", "", ""));
                                }
                            }
                        }
                    }
                    AppMethodBeat.m2505o(52201);
                    list2 = linkedList;
                } catch (Exception e222) {
                    C4990ab.printErrStackTrace("MicroMsg.NetStatusUtil", e222, "", new Object[0]);
                    AppMethodBeat.m2505o(52201);
                    list2 = linkedList;
                }
            }
        }
        return list2;
    }
}
