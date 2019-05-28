package com.tencent.d.f;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.Proxy;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;

public final class d {

    public enum a {
        CONN_WIFI,
        CONN_CMWAP,
        CONN_CMNET,
        CONN_NONE;

        static {
            AppMethodBeat.o(114600);
        }
    }

    public static String getIMEI(Context context) {
        String deviceId;
        AppMethodBeat.i(114601);
        String str = "";
        try {
            deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
        } catch (Throwable th) {
            h.db("getIMEI: ".concat(String.valueOf(th)));
            deviceId = str;
        }
        AppMethodBeat.o(114601);
        return deviceId;
    }

    public static String iK(Context context) {
        String subscriberId;
        AppMethodBeat.i(114602);
        String str = "";
        try {
            subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
        } catch (Throwable th) {
            h.db("getIMSI: ".concat(String.valueOf(th)));
            subscriberId = str;
        }
        AppMethodBeat.o(114602);
        return subscriberId;
    }

    public static int dQD() {
        AppMethodBeat.i(114603);
        try {
            int parseInt = Integer.parseInt(VERSION.SDK);
            AppMethodBeat.o(114603);
            return parseInt;
        } catch (Throwable th) {
            h.db("getSDKVersion: ".concat(String.valueOf(th)));
            AppMethodBeat.o(114603);
            return 0;
        }
    }

    public static String iL(Context context) {
        AppMethodBeat.i(114604);
        String string;
        try {
            string = Secure.getString(context.getContentResolver(), "android_id");
            AppMethodBeat.o(114604);
            return string;
        } catch (Throwable th) {
            h.db("getAndroidId: ".concat(String.valueOf(th)));
            string = "";
            AppMethodBeat.o(114604);
            return string;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a9 A:{SYNTHETIC, Splitter:B:42:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A:{SYNTHETIC, Splitter:B:45:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A:{SYNTHETIC, Splitter:B:33:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e A:{SYNTHETIC, Splitter:B:36:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a9 A:{SYNTHETIC, Splitter:B:42:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A:{SYNTHETIC, Splitter:B:45:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0099 A:{SYNTHETIC, Splitter:B:33:0x0099} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e A:{SYNTHETIC, Splitter:B:36:0x009e} */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00a9 A:{SYNTHETIC, Splitter:B:42:0x00a9} */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ae A:{SYNTHETIC, Splitter:B:45:0x00ae} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String ro(boolean z) {
        String str;
        Object obj;
        String readLine;
        BufferedReader bufferedReader;
        Throwable th;
        BufferedReader bufferedReader2 = null;
        AppMethodBeat.i(114605);
        if (z) {
            str = "/sys/block/mmcblk0/device/";
            obj = "MMC";
        } else {
            str = "/sys/block/mmcblk1/device/";
            obj = "SD";
        }
        BufferedReader bufferedReader3;
        try {
            bufferedReader3 = new BufferedReader(new FileReader(str + "type"));
            try {
                String readLine2 = bufferedReader3.readLine();
                if (readLine2 != null && readLine2.toUpperCase().equals(obj)) {
                    BufferedReader bufferedReader4 = new BufferedReader(new FileReader(str + "cid"));
                    try {
                        readLine = bufferedReader4.readLine();
                        if (readLine != null) {
                            readLine = readLine.trim();
                            try {
                                bufferedReader3.close();
                            } catch (IOException e) {
                            }
                            try {
                                bufferedReader4.close();
                            } catch (IOException e2) {
                            }
                            AppMethodBeat.o(114605);
                            return readLine;
                        }
                        bufferedReader2 = bufferedReader4;
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader4;
                        if (bufferedReader3 != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        AppMethodBeat.o(114605);
                        throw th;
                    }
                }
                try {
                    bufferedReader3.close();
                } catch (IOException e3) {
                }
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                bufferedReader = null;
                if (bufferedReader3 != null) {
                }
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(114605);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedReader = null;
            bufferedReader3 = null;
            if (bufferedReader3 != null) {
                try {
                    bufferedReader3.close();
                } catch (IOException e5) {
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e6) {
                }
            }
            AppMethodBeat.o(114605);
            throw th;
        }
        readLine = "";
        AppMethodBeat.o(114605);
        return readLine;
    }

    public static String dQE() {
        FileInputStream fileInputStream;
        StringBuilder stringBuilder;
        AppMethodBeat.i(114606);
        String str = "";
        try {
            fileInputStream = new FileInputStream("/proc/version");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            stringBuilder = new StringBuilder("");
            while (true) {
                try {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(str);
                    } else {
                        try {
                            break;
                        } catch (Throwable th) {
                            h.dc(th);
                        }
                    }
                } catch (Throwable th2) {
                    h.dc(th2);
                }
            }
            bufferedReader.close();
            try {
                fileInputStream.close();
            } catch (Throwable th22) {
                h.dc(th22);
            }
            str = stringBuilder.toString();
            AppMethodBeat.o(114606);
        } catch (Throwable th3) {
            h.dc(th3);
            AppMethodBeat.o(114606);
        }
        return str;
        fileInputStream.close();
        str = stringBuilder.toString();
        AppMethodBeat.o(114606);
        return str;
        str = stringBuilder.toString();
        AppMethodBeat.o(114606);
        return str;
    }

    public static a iM(Context context) {
        AppMethodBeat.i(114607);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        a aVar;
        if (activeNetworkInfo == null || !(activeNetworkInfo.getState() == State.CONNECTING || activeNetworkInfo.getState() == State.CONNECTED)) {
            aVar = a.CONN_NONE;
            AppMethodBeat.o(114607);
            return aVar;
        } else if (activeNetworkInfo.getType() == 1) {
            aVar = a.CONN_WIFI;
            AppMethodBeat.o(114607);
            return aVar;
        } else if (activeNetworkInfo.getType() != 0) {
            aVar = a.CONN_NONE;
            AppMethodBeat.o(114607);
            return aVar;
        } else if (Proxy.getDefaultHost() == null && Proxy.getHost(context) == null) {
            aVar = a.CONN_CMNET;
            AppMethodBeat.o(114607);
            return aVar;
        } else {
            aVar = a.CONN_CMWAP;
            AppMethodBeat.o(114607);
            return aVar;
        }
    }

    public static String atU(String str) {
        String str2;
        Object th;
        AppMethodBeat.i(114608);
        String str3 = "";
        try {
            Method method = Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class});
            method.setAccessible(true);
            str2 = (String) method.invoke(null, new Object[]{str});
            if (str2 == null) {
                try {
                    str2 = "";
                } catch (Throwable th2) {
                    th = th2;
                    h.db(" getBuildPropByReflect: ".concat(String.valueOf(th)));
                    AppMethodBeat.o(114608);
                    return str2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = str3;
            h.db(" getBuildPropByReflect: ".concat(String.valueOf(th)));
            AppMethodBeat.o(114608);
            return str2;
        }
        AppMethodBeat.o(114608);
        return str2;
    }

    public static String iN(Context context) {
        String macAddress;
        AppMethodBeat.i(114609);
        String str = "";
        try {
            WifiInfo connectionInfo = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
            if (connectionInfo != null) {
                macAddress = connectionInfo.getMacAddress();
                if (TextUtils.isEmpty(macAddress) || macAddress.equals("02:00:00:00:00:00")) {
                    macAddress = dQF();
                }
                AppMethodBeat.o(114609);
                return macAddress;
            }
        } catch (Throwable th) {
            h.db("getMac: ".concat(String.valueOf(th)));
        }
        macAddress = str;
        macAddress = dQF();
        AppMethodBeat.o(114609);
        return macAddress;
    }

    private static String dQF() {
        AppMethodBeat.i(114610);
        String str = "";
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces == null) {
                h.db("[tomys] getMac2, itfs is null.");
                AppMethodBeat.o(114610);
                return str;
            }
            String stringBuilder;
            for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress != null) {
                        StringBuilder stringBuilder2 = new StringBuilder();
                        int length = hardwareAddress.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder2.append(String.format("%02x:", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                        }
                        if (stringBuilder2.length() > 0) {
                            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                        }
                        stringBuilder = stringBuilder2.toString();
                        AppMethodBeat.o(114610);
                        return stringBuilder;
                    }
                }
            }
            stringBuilder = str;
            AppMethodBeat.o(114610);
            return stringBuilder;
        } catch (Throwable th) {
            h.db("getMac2: ".concat(String.valueOf(th)));
        }
    }
}
