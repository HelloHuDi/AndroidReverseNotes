package com.tencent.tencentmap.mapsdk.maps.a;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public final class eu {
    private static String a = "";
    private static String b = "";
    private static String c = "";
    private static String d = "";

    public static int a(int i, int i2, int i3) {
        AppMethodBeat.i(98844);
        int min = Math.min(Math.max(i, i2), i3);
        AppMethodBeat.o(98844);
        return min;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A:{SYNTHETIC, Splitter:B:14:0x0041} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004d A:{SYNTHETIC, Splitter:B:20:0x004d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(int i) {
        Throwable th;
        BufferedReader bufferedReader;
        String str = null;
        AppMethodBeat.i(98842);
        BufferedReader bufferedReader2;
        try {
            bufferedReader2 = new BufferedReader(new FileReader("/proc/" + i + "/cmdline"));
            try {
                String readLine = bufferedReader2.readLine();
                str = !TextUtils.isEmpty(readLine) ? readLine.trim() : readLine;
                try {
                    bufferedReader2.close();
                } catch (IOException e) {
                }
                AppMethodBeat.o(98842);
            } catch (Exception e2) {
                if (bufferedReader2 != null) {
                }
                AppMethodBeat.o(98842);
                return str;
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
                if (bufferedReader != null) {
                }
                AppMethodBeat.o(98842);
                throw th;
            }
        } catch (Exception e3) {
            bufferedReader2 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(98842);
            return str;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e5) {
                }
            }
            AppMethodBeat.o(98842);
            throw th;
        }
        return str;
    }

    public static String a(long j, String str) {
        AppMethodBeat.i(98834);
        String format;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str);
            Calendar instance = Calendar.getInstance();
            instance.setTimeInMillis(j);
            format = simpleDateFormat.format(instance.getTime());
            AppMethodBeat.o(98834);
            return format;
        } catch (Exception e) {
            format = "";
            AppMethodBeat.o(98834);
            return format;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:8:0x001b  */
    /* JADX WARNING: Removed duplicated region for block: B:5:0x0014  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(Context context, int i) {
        ActivityManager activityManager;
        AppMethodBeat.i(98841);
        Object systemService = context.getSystemService("activity");
        if (systemService != null) {
            try {
                activityManager = (ActivityManager) systemService;
            } catch (Throwable th) {
            }
            if (activityManager != null) {
                AppMethodBeat.o(98841);
                return null;
            }
            String str;
            List runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                int size = runningAppProcesses.size();
                for (int i2 = 0; i2 < size; i2++) {
                    RunningAppProcessInfo runningAppProcessInfo = (RunningAppProcessInfo) runningAppProcesses.get(i2);
                    if (runningAppProcessInfo != null && runningAppProcessInfo.pid == i) {
                        str = runningAppProcessInfo.processName;
                        break;
                    }
                }
            }
            str = null;
            AppMethodBeat.o(98841);
            return str;
        }
        activityManager = null;
        if (activityManager != null) {
        }
    }

    public static String a(Throwable th) {
        AppMethodBeat.i(98833);
        String stackTraceString = Log.getStackTraceString(th);
        if (TextUtils.isEmpty(stackTraceString)) {
            stackTraceString = "";
            AppMethodBeat.o(98833);
            return stackTraceString;
        }
        String[] split = stackTraceString.split(IOUtils.LINE_SEPARATOR_UNIX);
        if (split.length >= 2) {
            stackTraceString = split[0] + split[1];
            AppMethodBeat.o(98833);
            return stackTraceString;
        } else if (split.length == 1) {
            stackTraceString = split[0];
            AppMethodBeat.o(98833);
            return stackTraceString;
        } else {
            stackTraceString = "";
            AppMethodBeat.o(98833);
            return stackTraceString;
        }
    }

    private static String a(InetAddress inetAddress) {
        AppMethodBeat.i(98847);
        String substring;
        try {
            byte[] address = inetAddress.getAddress();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (i < address.length) {
                stringBuilder.append("." + (address[i] < (byte) 0 ? address[i] + 256 : address[i]));
                i++;
            }
            substring = stringBuilder.substring(1);
            AppMethodBeat.o(98847);
            return substring;
        } catch (Throwable th) {
            substring = "";
            AppMethodBeat.o(98847);
            return substring;
        }
    }

    public static boolean a(String str) {
        AppMethodBeat.i(98835);
        if (str == null) {
            AppMethodBeat.o(98835);
            return true;
        } else if (str.trim().length() == 0) {
            AppMethodBeat.o(98835);
            return true;
        } else {
            AppMethodBeat.o(98835);
            return false;
        }
    }

    public static boolean a(byte[] bArr) {
        return bArr == null || bArr.length <= 0;
    }

    public static String b(String str) {
        AppMethodBeat.i(98837);
        String str2;
        if (TextUtils.isEmpty(str)) {
            str2 = "";
            AppMethodBeat.o(98837);
            return str2;
        }
        try {
            str2 = URLEncoder.encode(str, "UTF-8");
            AppMethodBeat.o(98837);
            return str2;
        } catch (Throwable th) {
            str2 = "";
            AppMethodBeat.o(98837);
            return str2;
        }
    }

    public static String c(String str) {
        AppMethodBeat.i(98846);
        String str2 = "";
        try {
            str2 = a(InetAddress.getByName(str));
        } catch (Throwable th) {
        }
        AppMethodBeat.o(98846);
        return str2;
    }

    public static boolean d(String str) {
        AppMethodBeat.i(98850);
        if (TextUtils.isEmpty(str)) {
            AppMethodBeat.o(98850);
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length != 4) {
            AppMethodBeat.o(98850);
            return false;
        }
        int length = split.length;
        int i = 0;
        while (i < length) {
            try {
                int parseInt = Integer.parseInt(split[i]);
                if (parseInt < 0 || parseInt > 255) {
                    AppMethodBeat.o(98850);
                    return false;
                }
                i++;
            } catch (NumberFormatException e) {
                AppMethodBeat.o(98850);
                return false;
            }
        }
        AppMethodBeat.o(98850);
        return true;
    }

    public static String f() {
        AppMethodBeat.i(98849);
        String str;
        try {
            str = "35" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) + (Build.CPU_ABI.length() % 10) + (Build.DEVICE.length() % 10) + (Build.DISPLAY.length() % 10) + (Build.HOST.length() % 10) + (Build.ID.length() % 10) + (Build.MANUFACTURER.length() % 10) + (Build.MODEL.length() % 10) + (Build.PRODUCT.length() % 10) + (Build.TAGS.length() % 10) + (Build.TYPE.length() % 10) + (Build.USER.length() % 10);
            AppMethodBeat.o(98849);
            return str;
        } catch (Throwable th) {
            str = "";
            AppMethodBeat.o(98849);
            return str;
        }
    }

    public static String b(byte[] bArr) {
        AppMethodBeat.i(98836);
        String str;
        if (bArr == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(98836);
            return str;
        }
        int length = bArr.length;
        if (bArr == null) {
            str = BuildConfig.COMMAND;
            AppMethodBeat.o(98836);
            return str;
        }
        int min = Math.min(length, bArr.length);
        StringBuffer stringBuffer = new StringBuffer("size:" + min + ",content:");
        for (length = 0; length < min; length++) {
            stringBuffer.append(Integer.toHexString((bArr[length] >> 4) & 15));
            stringBuffer.append(Integer.toHexString(bArr[length] & 15));
        }
        str = stringBuffer.toString();
        AppMethodBeat.o(98836);
        return str;
    }

    public static String a() {
        String deviceId;
        Object obj = 1;
        AppMethodBeat.i(98838);
        try {
            String str = a;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) bt.a().getSystemService("phone");
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                    if (deviceId == null) {
                        deviceId = "NOIMEI";
                    }
                    a = deviceId;
                }
            }
        } catch (Throwable th) {
        }
        deviceId = a;
        AppMethodBeat.o(98838);
        return deviceId;
    }

    public static String b() {
        String subscriberId;
        Object obj = 1;
        AppMethodBeat.i(98839);
        try {
            String str = b;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                TelephonyManager telephonyManager = (TelephonyManager) bt.a().getSystemService("phone");
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                    if (subscriberId == null) {
                        subscriberId = "NOIMSI";
                    }
                    b = subscriberId;
                }
            }
        } catch (Throwable th) {
        }
        subscriberId = b;
        AppMethodBeat.o(98839);
        return subscriberId;
    }

    public static String c() {
        String macAddress;
        Object obj = 1;
        AppMethodBeat.i(98840);
        try {
            String str = c;
            if (str != null) {
                if (str.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                WifiManager wifiManager = (WifiManager) bt.a().getApplicationContext().getSystemService("wifi");
                if (wifiManager != null) {
                    WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        macAddress = connectionInfo.getMacAddress();
                        if (macAddress == null) {
                            macAddress = "NOMAC";
                        }
                        c = macAddress;
                    }
                }
            }
        } catch (Throwable th) {
        }
        macAddress = c;
        AppMethodBeat.o(98840);
        return macAddress;
    }

    public static int a(int i, int i2, int i3, int i4) {
        AppMethodBeat.i(98843);
        if ((i < i2 || i > i3) && i4 >= i2 && i4 <= i3) {
            AppMethodBeat.o(98843);
            return i4;
        }
        i4 = Math.min(Math.max(i, i2), i3);
        AppMethodBeat.o(98843);
        return i4;
    }

    public static String d() {
        String a;
        AppMethodBeat.i(98845);
        try {
            StringBuilder stringBuilder = new StringBuilder("");
            stringBuilder.append(a());
            stringBuilder.append(c());
            stringBuilder.append(System.currentTimeMillis());
            stringBuilder.append(b());
            stringBuilder.append((int) (Math.random() * 2.147483647E9d));
            a = et.a(stringBuilder.toString());
        } catch (Throwable th) {
            a = "";
        }
        AppMethodBeat.o(98845);
        return a;
    }

    public static String e() {
        Object obj = 1;
        AppMethodBeat.i(98848);
        String str;
        try {
            String str2 = d;
            if (str2 != null) {
                if (str2.trim().length() != 0) {
                    obj = null;
                }
            }
            if (obj != null) {
                d = Secure.getString(bt.a().getContentResolver(), "android_id");
            }
            str = d;
            AppMethodBeat.o(98848);
            return str;
        } catch (Throwable th) {
            str = "";
            AppMethodBeat.o(98848);
            return str;
        }
    }
}
