package com.tencent.smtt.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.internal.Utility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.NetworkInterface;
import java.security.cert.Certificate;
import java.util.Collections;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class b {
    public static String a = "";
    public static String b = "";
    public static String c = "";
    public static String d = "";
    public static String e = "";

    private static PackageInfo a(String str, int i) {
        AppMethodBeat.i(65185);
        try {
            Class cls = Class.forName("android.content.pm.PackageParser");
            for (Class cls2 : cls.getDeclaredClasses()) {
                if (cls2.getName().compareTo("android.content.pm.PackageParser$Package") == 0) {
                    break;
                }
            }
            Class cls22 = null;
            Constructor constructor = cls.getConstructor(new Class[]{String.class});
            Method declaredMethod = cls.getDeclaredMethod("parsePackage", new Class[]{File.class, String.class, DisplayMetrics.class, Integer.TYPE});
            Method declaredMethod2 = cls.getDeclaredMethod("collectCertificates", new Class[]{cls22, Integer.TYPE});
            Method declaredMethod3 = cls.getDeclaredMethod("generatePackageInfo", new Class[]{cls22, int[].class, Integer.TYPE, Long.TYPE, Long.TYPE});
            constructor.setAccessible(true);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            declaredMethod3.setAccessible(true);
            Object newInstance = constructor.newInstance(new Object[]{str});
            new DisplayMetrics().setToDefaults();
            if (declaredMethod.invoke(newInstance, new Object[]{new File(str), str, new DisplayMetrics(), Integer.valueOf(0)}) == null) {
                AppMethodBeat.o(65185);
                return null;
            }
            if ((i & 64) != 0) {
                declaredMethod2.invoke(newInstance, new Object[]{r3, Integer.valueOf(0)});
            }
            PackageInfo packageInfo = (PackageInfo) declaredMethod3.invoke(null, new Object[]{r3, null, Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(0)});
            AppMethodBeat.o(65185);
            return packageInfo;
        } catch (Exception e) {
            AppMethodBeat.o(65185);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x006c A:{SYNTHETIC, Splitter:B:25:0x006c} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0071 A:{SYNTHETIC, Splitter:B:28:0x0071} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007d A:{SYNTHETIC, Splitter:B:34:0x007d} */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0082 A:{SYNTHETIC, Splitter:B:37:0x0082} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a() {
        String a;
        Throwable th;
        BufferedReader bufferedReader;
        AppMethodBeat.i(65178);
        if (TextUtils.isEmpty(c)) {
            InputStreamReader inputStreamReader;
            BufferedReader bufferedReader2;
            try {
                inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("getprop ro.product.cpu.abi").getInputStream());
                try {
                    bufferedReader2 = new BufferedReader(inputStreamReader);
                    try {
                        a = bufferedReader2.readLine().contains("x86") ? a("i686") : a(System.getProperty("os.arch"));
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e) {
                            }
                        }
                        if (inputStreamReader != null) {
                            try {
                                inputStreamReader.close();
                            } catch (IOException e2) {
                            }
                        }
                    } catch (Throwable th2) {
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    AppMethodBeat.o(65178);
                    throw th;
                }
            } catch (Throwable th32) {
                th = th32;
                bufferedReader = null;
                inputStreamReader = null;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e3) {
                    }
                }
                if (inputStreamReader != null) {
                    try {
                        inputStreamReader.close();
                    } catch (IOException e4) {
                    }
                }
                AppMethodBeat.o(65178);
                throw th;
            }
            AppMethodBeat.o(65178);
            return a;
        }
        a = c;
        AppMethodBeat.o(65178);
        return a;
    }

    public static String a(Context context) {
        AppMethodBeat.i(65173);
        String str = null;
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
        }
        AppMethodBeat.o(65173);
        return str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(Context context, File file, boolean z) {
        Signature signature;
        String str = null;
        AppMethodBeat.i(65183);
        PackageInfo a = z ? a(file.getAbsolutePath(), 65) : context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 65);
        if (a != null) {
            if (a.signatures == null || a.signatures.length <= 0) {
                TbsLog.w("AppUtil", "[getSignatureFromApk] pkgInfo is not null BUT signatures is null!");
            } else {
                signature = a.signatures[0];
                if (signature != null) {
                    str = signature.toCharsString();
                }
                AppMethodBeat.o(65183);
                return str;
            }
        }
        signature = null;
        if (signature != null) {
        }
        AppMethodBeat.o(65183);
        return str;
    }

    public static String a(Context context, String str) {
        AppMethodBeat.i(65175);
        String str2 = null;
        try {
            try {
                str2 = String.valueOf(Integer.toHexString(Integer.parseInt(String.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get(str)))));
            } catch (Exception e) {
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(65175);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A:{Catch:{ Throwable -> 0x0079 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d A:{Catch:{ Throwable -> 0x0079 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String a(Context context, boolean z, File file) {
        Throwable th;
        RandomAccessFile randomAccessFile;
        AppMethodBeat.i(65182);
        String str;
        if (file == null || !file.exists()) {
            str = "";
            AppMethodBeat.o(65182);
            return str;
        }
        if (z) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                byte[] bArr = new byte[2];
                RandomAccessFile randomAccessFile3 = new RandomAccessFile(file, "r");
                try {
                    randomAccessFile3.read(bArr);
                    if (new String(bArr).equalsIgnoreCase("PK")) {
                        randomAccessFile3.close();
                    } else {
                        str = "";
                        try {
                            randomAccessFile3.close();
                        } catch (IOException e) {
                        }
                        AppMethodBeat.o(65182);
                        return str;
                    }
                } catch (Exception e2) {
                    randomAccessFile2 = randomAccessFile3;
                    try {
                        randomAccessFile2.close();
                    } catch (IOException e3) {
                    }
                    if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                    }
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
                    str = a(context, file, false);
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=".concat(String.valueOf(str)));
                    if (str == null) {
                    }
                    if (str == null) {
                    }
                    AppMethodBeat.o(65182);
                    return str;
                } catch (Throwable th2) {
                    th = th2;
                    randomAccessFile = randomAccessFile3;
                    try {
                        randomAccessFile.close();
                    } catch (IOException e4) {
                    }
                    AppMethodBeat.o(65182);
                    throw th;
                }
            } catch (Exception e5) {
                randomAccessFile2.close();
                if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                }
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
                str = a(context, file, false);
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=".concat(String.valueOf(str)));
                if (str == null) {
                }
                if (str == null) {
                }
                AppMethodBeat.o(65182);
                return str;
            } catch (Throwable th3) {
                th = th3;
                randomAccessFile = null;
                randomAccessFile.close();
                AppMethodBeat.o(65182);
                throw th;
            }
        }
        try {
            if (context.getApplicationContext().getPackageName().contains("com.jd.jrapp")) {
                TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #1");
                str = a(file);
                if (str != null) {
                    TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #2");
                    AppMethodBeat.o(65182);
                    return str;
                }
            }
        } catch (Throwable th4) {
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #3");
        }
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  #4");
        str = a(context, file, false);
        TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android api signature=".concat(String.valueOf(str)));
        if (str == null) {
            str = a(file);
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  java get signature=".concat(String.valueOf(str)));
        }
        if (str == null) {
            str = a(context, file, true);
            TbsLog.i("AppUtil", "[AppUtil.getSignatureFromApk]  android reflection signature=".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(65182);
        return str;
    }

    private static String a(File file) {
        String a;
        AppMethodBeat.i(65184);
        try {
            JarFile jarFile = new JarFile(file);
            byte[] bArr = new byte[Utility.DEFAULT_STREAM_BUFFER_SIZE];
            String a2 = a(a(jarFile, jarFile.getJarEntry("AndroidManifest.xml"), bArr)[0].getEncoded());
            Enumeration entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry jarEntry = (JarEntry) entries.nextElement();
                String name = jarEntry.getName();
                if (name != null) {
                    Certificate[] a3 = a(jarFile, jarEntry, bArr);
                    a = a3 != null ? a(a3[0].getEncoded()) : null;
                    if (a == null) {
                        if (!name.startsWith("META-INF/")) {
                            a = null;
                            break;
                        }
                    } else if (!a.equals(a2)) {
                        a = null;
                        break;
                    }
                }
            }
            a = a2;
        } catch (Exception e) {
            a = null;
        }
        AppMethodBeat.o(65184);
        return a;
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    private static String a(byte[] bArr) {
        AppMethodBeat.i(65187);
        int length = bArr.length;
        char[] cArr = new char[(length * 2)];
        for (int i = 0; i < length; i++) {
            byte b = bArr[i];
            int i2 = (b >> 4) & 15;
            cArr[i * 2] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
            i2 = b & 15;
            cArr[(i * 2) + 1] = (char) (i2 >= 10 ? (i2 + 97) - 10 : i2 + 48);
        }
        String str = new String(cArr);
        AppMethodBeat.o(65187);
        return str;
    }

    private static Certificate[] a(JarFile jarFile, JarEntry jarEntry, byte[] bArr) {
        AppMethodBeat.i(65186);
        InputStream inputStream = jarFile.getInputStream(jarEntry);
        do {
        } while (inputStream.read(bArr, 0, bArr.length) != -1);
        inputStream.close();
        if (jarEntry != null) {
            Certificate[] certificates = jarEntry.getCertificates();
            AppMethodBeat.o(65186);
            return certificates;
        }
        AppMethodBeat.o(65186);
        return null;
    }

    public static int b(Context context) {
        int i = 0;
        AppMethodBeat.i(65174);
        try {
            i = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Exception e) {
        }
        AppMethodBeat.o(65174);
        return i;
    }

    public static String b() {
        String str;
        AppMethodBeat.i(65180);
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        str = "";
                        AppMethodBeat.o(65180);
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
                    str = stringBuilder.toString();
                    AppMethodBeat.o(65180);
                    return str;
                }
            }
        } catch (Exception e) {
        }
        str = "02:00:00:00:00:00";
        AppMethodBeat.o(65180);
        return str;
    }

    public static String c(Context context) {
        String deviceId;
        AppMethodBeat.i(65176);
        String str = "";
        if (TextUtils.isEmpty(a)) {
            try {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
            } catch (Exception e) {
                deviceId = str;
            }
        } else {
            deviceId = a;
        }
        AppMethodBeat.o(65176);
        return deviceId;
    }

    public static String d(Context context) {
        String subscriberId;
        AppMethodBeat.i(65177);
        String str = "";
        if (TextUtils.isEmpty(b)) {
            try {
                subscriberId = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
            } catch (Exception e) {
                subscriberId = str;
            }
        } else {
            subscriberId = b;
        }
        AppMethodBeat.o(65177);
        return subscriberId;
    }

    public static String e(Context context) {
        AppMethodBeat.i(65179);
        if (TextUtils.isEmpty(d)) {
            if (VERSION.SDK_INT < 23) {
                try {
                    WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                    WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                    d = connectionInfo == null ? "" : connectionInfo.getMacAddress();
                } catch (Exception e) {
                }
            } else {
                d = b();
            }
        }
        String str = d;
        AppMethodBeat.o(65179);
        return str;
    }

    public static String f(Context context) {
        AppMethodBeat.i(65181);
        String str;
        if (TextUtils.isEmpty(e)) {
            try {
                e = Secure.getString(context.getContentResolver(), "android_id");
            } catch (Exception e) {
            }
            str = e;
            AppMethodBeat.o(65181);
            return str;
        }
        str = e;
        AppMethodBeat.o(65181);
        return str;
    }
}
