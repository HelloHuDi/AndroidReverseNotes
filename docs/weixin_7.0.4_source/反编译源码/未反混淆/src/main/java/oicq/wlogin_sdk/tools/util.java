package oicq.wlogin_sdk.tools;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.WebView;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.Key;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import oicq.wlogin_sdk.request.i;

public class util {
    public static int BWa = CdnLogic.kBizGeneric;
    public static int BWb = 128;
    public static int BWc = 0;
    public static int BWd = 1;
    public static int BWe = 2;
    public static int BWf = 3;
    public static int BWg = 4;
    public static int BWh = 5;
    public static int BWi = 6;
    public static int BWj = 7;
    public static int BWk = 8;
    public static int BWl = 9;
    public static int BWm = 10;
    public static int BWn = 11;
    public static int BWo = 12;
    public static int BWp = 13;
    public static int BWq = 14;
    public static int BWr = 1;
    public static b BWs = null;
    public static boolean BWt = false;
    public static int BWu = 5;

    public static byte[] emL() {
        AppMethodBeat.i(96518);
        byte[] bytes = new String("android").getBytes();
        AppMethodBeat.o(96518);
        return bytes;
    }

    public static byte[] emM() {
        AppMethodBeat.i(96519);
        byte[] bytes = VERSION.RELEASE.getBytes();
        AppMethodBeat.o(96519);
        return bytes;
    }

    public static void M(byte[] bArr, int i, int i2) {
        bArr[i + 0] = (byte) (i2 >> 0);
    }

    public static void N(byte[] bArr, int i, int i2) {
        bArr[i + 1] = (byte) (i2 >> 0);
        bArr[i + 0] = (byte) (i2 >> 8);
    }

    public static void O(byte[] bArr, int i, int i2) {
        bArr[i + 3] = (byte) (i2 >> 0);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 0] = (byte) (i2 >> 24);
    }

    public static void c(byte[] bArr, int i, long j) {
        bArr[i + 7] = (byte) ((int) (j >> null));
        bArr[i + 6] = (byte) ((int) (j >> 8));
        bArr[i + 5] = (byte) ((int) (j >> 16));
        bArr[i + 4] = (byte) ((int) (j >> 24));
        bArr[i + 3] = (byte) ((int) (j >> 32));
        bArr[i + 2] = (byte) ((int) (j >> 40));
        bArr[i + 1] = (byte) ((int) (j >> 48));
        bArr[i + 0] = (byte) ((int) (j >> 56));
    }

    public static void d(byte[] bArr, int i, long j) {
        bArr[i + 3] = (byte) ((int) (j >> null));
        bArr[i + 2] = (byte) ((int) (j >> 8));
        bArr[i + 1] = (byte) ((int) (j >> 16));
        bArr[i + 0] = (byte) ((int) (j >> 24));
    }

    public static int ae(byte[] bArr, int i) {
        return bArr[i] & 255;
    }

    public static int af(byte[] bArr, int i) {
        return ((bArr[i] << 8) & 65280) + ((bArr[i + 1] << 0) & 255);
    }

    public static int ag(byte[] bArr, int i) {
        return ((((bArr[i] << 24) & WebView.NIGHT_MODE_COLOR) + ((bArr[i + 1] << 16) & 16711680)) + ((bArr[i + 2] << 8) & 65280)) + ((bArr[i + 3] << 0) & 255);
    }

    public static int emN() {
        AppMethodBeat.i(96520);
        int random = (int) (Math.random() * 2.147483647E9d);
        AppMethodBeat.o(96520);
        return random;
    }

    public static byte[] emO() {
        AppMethodBeat.i(96521);
        byte[] seed = SecureRandom.getSeed(16);
        AppMethodBeat.o(96521);
        return seed;
    }

    public static byte[] cN(byte[] bArr) {
        AppMethodBeat.i(96522);
        byte[] seed = SecureRandom.getSeed(16);
        byte[] bArr2 = new byte[(seed.length + bArr.length)];
        System.arraycopy(seed, 0, bArr2, 0, seed.length);
        System.arraycopy(bArr, 0, bArr2, seed.length, bArr.length);
        seed = c.cM(bArr2);
        AppMethodBeat.o(96522);
        return seed;
    }

    public static long emP() {
        AppMethodBeat.i(96523);
        long emE = i.emE();
        AppMethodBeat.o(96523);
        return emE;
    }

    public static String cO(byte[] bArr) {
        AppMethodBeat.i(96524);
        String str;
        if (bArr == null) {
            str = "";
            AppMethodBeat.o(96524);
            return str;
        }
        str = "";
        for (int i = 0; i < bArr.length; i++) {
            str = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str)).append(Integer.toHexString((bArr[i] >> 4) & 15)).toString())).append(Integer.toHexString(bArr[i] & 15)).toString();
        }
        AppMethodBeat.o(96524);
        return str;
    }

    public static long cP(byte[] bArr) {
        if (bArr == null) {
            return 0;
        }
        return (long) bArr.length;
    }

    private static byte d(byte b) {
        if (b >= (byte) 48 && b <= (byte) 57) {
            return (byte) (b - 48);
        }
        if (b >= (byte) 97 && b <= (byte) 102) {
            return (byte) ((b - 97) + 10);
        }
        if (b < (byte) 65 || b > (byte) 70) {
            return (byte) 0;
        }
        return (byte) ((b - 65) + 10);
    }

    private static byte[] awE(String str) {
        int i = 0;
        AppMethodBeat.i(96525);
        if (str == null) {
            byte[] bArr = new byte[0];
            AppMethodBeat.o(96525);
            return bArr;
        }
        byte[] bArr2 = new byte[(str.length() / 2)];
        while (i < str.length() / 2) {
            bArr2[i] = (byte) ((d((byte) str.charAt(i * 2)) << 4) + d((byte) str.charAt((i * 2) + 1)));
            i++;
        }
        AppMethodBeat.o(96525);
        return bArr2;
    }

    public static byte[] jH(Context context) {
        byte[] bytes;
        AppMethodBeat.i(96526);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                String macAddress = connectionInfo.getMacAddress();
                if (macAddress != null) {
                    bytes = macAddress.getBytes();
                    AppMethodBeat.o(96526);
                    return bytes;
                }
            }
        }
        bytes = new byte[0];
        AppMethodBeat.o(96526);
        return bytes;
    }

    public static byte[] jI(Context context) {
        byte[] bytes;
        AppMethodBeat.i(96527);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId != null) {
                bytes = deviceId.getBytes();
                AppMethodBeat.o(96527);
                return bytes;
            }
        }
        bytes = new byte[0];
        AppMethodBeat.o(96527);
        return bytes;
    }

    public static byte[] jJ(Context context) {
        String deviceId;
        String str = null;
        AppMethodBeat.i(96528);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            deviceId = telephonyManager.getDeviceId();
        } else {
            deviceId = null;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo != null) {
                str = connectionInfo.getMacAddress();
            }
        }
        String str2 = "";
        if (deviceId != null) {
            str2 = new StringBuilder(String.valueOf(str2)).append(deviceId).toString();
        }
        if (str != null) {
            str2 = new StringBuilder(String.valueOf(str2)).append(str).toString();
        }
        byte[] bArr;
        if (str2.length() <= 0) {
            bArr = new byte[0];
            AppMethodBeat.o(96528);
            return bArr;
        }
        bArr = c.cM(str2.getBytes());
        AppMethodBeat.o(96528);
        return bArr;
    }

    public static byte[] jK(Context context) {
        AppMethodBeat.i(96529);
        byte[] bytes;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager.getSimState() == 5) {
                bytes = telephonyManager.getSimOperatorName().getBytes();
                AppMethodBeat.o(96529);
                return bytes;
            }
            bytes = new byte[0];
            AppMethodBeat.o(96529);
            return bytes;
        } catch (Throwable th) {
            bytes = new byte[0];
            AppMethodBeat.o(96529);
            return bytes;
        }
    }

    public static int jL(Context context) {
        int type;
        AppMethodBeat.i(96530);
        try {
            type = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo().getType();
        } catch (Exception e) {
            type = 0;
        }
        if (type == 0) {
            AppMethodBeat.o(96530);
            return 1;
        } else if (type == 1) {
            AppMethodBeat.o(96530);
            return 2;
        } else {
            AppMethodBeat.o(96530);
            return 0;
        }
    }

    public static int jM(Context context) {
        AppMethodBeat.i(96531);
        int i = context.getSharedPreferences("WLOGIN_SERVER_INFO", 0).getInt("network_type", 0);
        AppMethodBeat.o(96531);
        return i;
    }

    public static void aF(Context context, int i) {
        AppMethodBeat.i(96532);
        Editor edit = context.getSharedPreferences("WLOGIN_SERVER_INFO", 0).edit();
        edit.putInt("network_type", i);
        edit.commit();
        AppMethodBeat.o(96532);
    }

    public static void jN(Context context) {
        AppMethodBeat.i(96533);
        Editor edit = context.getSharedPreferences("WLOGIN_NET_RETRY_TYPE", 0).edit();
        edit.putInt("type", 0);
        edit.commit();
        AppMethodBeat.o(96533);
    }

    public static String jO(Context context) {
        AppMethodBeat.i(96534);
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            String extraInfo;
            if (activeNetworkInfo.getType() == 0) {
                extraInfo = activeNetworkInfo.getExtraInfo();
                if (extraInfo != null) {
                    AppMethodBeat.o(96534);
                    return extraInfo;
                }
                extraInfo = "wifi";
                AppMethodBeat.o(96534);
                return extraInfo;
            }
            extraInfo = "wifi";
            AppMethodBeat.o(96534);
            return extraInfo;
        } catch (Exception e) {
        }
    }

    public static void a(Context context, byte[] bArr) {
        AppMethodBeat.i(96535);
        byte[] jP = jP(context);
        if (jP == null || jP.length <= 0) {
            Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            edit.putString("ksid", cO(bArr));
            edit.commit();
        }
        AppMethodBeat.o(96535);
    }

    public static byte[] jP(Context context) {
        byte[] awE;
        AppMethodBeat.i(96536);
        byte[] bytes = new String("").getBytes();
        try {
            awE = awE(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("ksid", new String("")));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            ji("exception", stringWriter.toString());
            awE = bytes;
        }
        if (awE == null || awE.length <= 0) {
            anG("get_ksid:null");
        } else {
            anG("get_ksid:" + cO(awE));
        }
        AppMethodBeat.o(96536);
        return awE;
    }

    public static void b(Context context, byte[] bArr) {
        AppMethodBeat.i(96537);
        if (bArr != null && bArr.length > 0) {
            Editor edit = context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).edit();
            edit.putString("imei", cO(bArr));
            edit.commit();
        }
        AppMethodBeat.o(96537);
    }

    public static byte[] jQ(Context context) {
        AppMethodBeat.i(96538);
        byte[] bArr = new byte[0];
        try {
            bArr = awE(context.getSharedPreferences("WLOGIN_DEVICE_INFO", 0).getString("imei", new String("")));
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter, true);
            e.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            ji("exception", stringWriter.toString());
        }
        if (bArr.length <= 0) {
            bArr = new byte[0];
        } else {
            anG("get_imei:" + cO(bArr));
        }
        AppMethodBeat.o(96538);
        return bArr;
    }

    public static byte[] jR(Context context) {
        AppMethodBeat.i(96539);
        byte[] bytes = context.getPackageName().getBytes();
        AppMethodBeat.o(96539);
        return bytes;
    }

    public static byte[] cl(Context context, String str) {
        AppMethodBeat.i(96540);
        byte[] bytes;
        try {
            bytes = context.getPackageManager().getPackageInfo(str, 0).versionName.getBytes();
            AppMethodBeat.o(96540);
            return bytes;
        } catch (Exception e) {
            bytes = new byte[0];
            AppMethodBeat.o(96540);
            return bytes;
        }
    }

    public static byte[] cm(Context context, String str) {
        AppMethodBeat.i(96541);
        byte[] cM;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo.signatures == null || packageInfo.signatures.length <= 0 || packageInfo.signatures[0] == null) {
                AppMethodBeat.o(96541);
                return null;
            }
            cM = c.cM(packageInfo.signatures[0].toByteArray());
            AppMethodBeat.o(96541);
            return cM;
        } catch (Throwable th) {
            cM = new byte[0];
            AppMethodBeat.o(96541);
            return cM;
        }
    }

    private static String emQ() {
        AppMethodBeat.i(96542);
        String str;
        try {
            StackTraceElement stackTraceElement = new Throwable().getStackTrace()[2];
            str = "[" + stackTraceElement.getFileName() + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D + stackTraceElement.getLineNumber() + "]";
            AppMethodBeat.o(96542);
            return str;
        } catch (Exception e) {
            str = "";
            AppMethodBeat.o(96542);
            return str;
        }
    }

    public static void awF(String str) {
        AppMethodBeat.i(96543);
        try {
            if (BWr > 0) {
                if (BWs != null) {
                    BWs.t(1, str);
                    AppMethodBeat.o(96543);
                    return;
                } else if (BWt) {
                    new StringBuilder("wlogin_sdk").append(emQ());
                    AppMethodBeat.o(96543);
                    return;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(96543);
    }

    public static void anG(String str) {
        AppMethodBeat.i(96544);
        try {
            if (BWr >= 2) {
                if (BWs != null) {
                    BWs.t(2, str);
                    AppMethodBeat.o(96544);
                    return;
                } else if (BWt) {
                    new StringBuilder("wlogin_sdk").append(emQ());
                    AppMethodBeat.o(96544);
                    return;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(96544);
    }

    public static void jh(String str, String str2) {
        AppMethodBeat.i(96545);
        try {
            if (BWr >= 2) {
                if (BWs != null) {
                    BWs.OnLog(2, str, str2);
                    AppMethodBeat.o(96545);
                    return;
                } else if (BWt) {
                    new StringBuilder("wlogin_sdk").append(emQ());
                    new StringBuilder(String.valueOf(str)).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2);
                    AppMethodBeat.o(96545);
                    return;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(96545);
    }

    public static void ji(String str, String str2) {
        AppMethodBeat.i(96546);
        try {
            if (BWr >= 0) {
                if (BWs != null) {
                    BWs.OnLog(0, str, str2);
                    AppMethodBeat.o(96546);
                    return;
                } else if (BWt) {
                    new StringBuilder("wlogin_sdk").append(emQ());
                    new StringBuilder(String.valueOf(str)).append(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D).append(str2);
                    AppMethodBeat.o(96546);
                    return;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.o(96546);
    }

    public static void l(Exception exception) {
        AppMethodBeat.i(96547);
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter, true);
        exception.printStackTrace(printWriter);
        printWriter.flush();
        stringWriter.flush();
        ji("exception:", stringWriter.toString());
        AppMethodBeat.o(96547);
    }

    public static boolean isFileExist(String str) {
        AppMethodBeat.i(96548);
        try {
            boolean exists = new File(str).exists();
            AppMethodBeat.o(96548);
            return exists;
        } catch (Exception e) {
            AppMethodBeat.o(96548);
            return false;
        }
    }

    public static String emR() {
        AppMethodBeat.i(96549);
        String str = new String("2014/02/28 14:20");
        AppMethodBeat.o(96549);
        return str;
    }

    public static Key RSAPubKeyFromJNI(byte[] bArr) {
        int i = 1;
        AppMethodBeat.i(96550);
        if (bArr == null) {
            AppMethodBeat.o(96550);
            return null;
        }
        byte[] bArr2 = new byte[22];
        bArr2[0] = (byte) 48;
        bArr2[1] = (byte) -127;
        bArr2[2] = (byte) -97;
        bArr2[3] = (byte) 48;
        bArr2[4] = (byte) 13;
        bArr2[5] = (byte) 6;
        bArr2[6] = (byte) 9;
        bArr2[7] = (byte) 42;
        bArr2[8] = (byte) -122;
        bArr2[9] = (byte) 72;
        bArr2[10] = (byte) -122;
        bArr2[11] = (byte) -9;
        bArr2[12] = (byte) 13;
        bArr2[13] = (byte) 1;
        bArr2[14] = (byte) 1;
        bArr2[15] = (byte) 1;
        bArr2[16] = (byte) 5;
        bArr2[18] = (byte) 3;
        bArr2[19] = (byte) -127;
        bArr2[20] = (byte) -115;
        byte[] bArr3 = new byte[(bArr.length + 22)];
        if (bArr.length >= 22) {
            for (int i2 = 0; i2 < 22; i2++) {
                if (bArr2[i2] != bArr[i2]) {
                    i = 0;
                    break;
                }
            }
        }
        if (i == 0) {
            System.arraycopy(bArr2, 0, bArr3, 0, 22);
            System.arraycopy(bArr, 0, bArr3, 22, bArr.length);
            bArr = bArr3;
        }
        try {
            Key generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
            AppMethodBeat.o(96550);
            return generatePublic;
        } catch (Exception e) {
            l(e);
            AppMethodBeat.o(96550);
            return null;
        }
    }

    public static Key RSAPrivKeyFromJNI(byte[] bArr) {
        AppMethodBeat.i(96551);
        if (bArr == null) {
            AppMethodBeat.o(96551);
            return null;
        }
        r0 = new byte[26];
        int length = bArr.length - 607;
        r0[3] = (byte) (r0[3] + length);
        r0[25] = (byte) (length + r0[25]);
        byte[] bArr2 = new byte[(bArr.length + 26)];
        System.arraycopy(r0, 0, bArr2, 0, 26);
        System.arraycopy(bArr, 0, bArr2, 26, bArr.length);
        try {
            Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
            AppMethodBeat.o(96551);
            return generatePrivate;
        } catch (Exception e) {
            l(e);
            AppMethodBeat.o(96551);
            return null;
        }
    }
}
