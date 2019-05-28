package p077c.p078t.p079m.p080c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.preference.PreferenceManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: c.t.m.c.q */
public class C37150q {
    /* renamed from: a */
    public static final Object f15844a = new Object();
    /* renamed from: b */
    public static String f15845b = "complist_loading";
    /* renamed from: c */
    public static long f15846c = 0;

    static {
        AppMethodBeat.m2504i(136434);
        AppMethodBeat.m2505o(136434);
    }

    /* renamed from: a */
    public static boolean m62212a(Context context, String str, String str2) {
        AppMethodBeat.m2504i(136401);
        boolean commit = PreferenceManager.getDefaultSharedPreferences(context).edit().putString(str, str2).commit();
        AppMethodBeat.m2505o(136401);
        return commit;
    }

    /* renamed from: a */
    public static boolean m62211a(Context context, String str, Long l) {
        AppMethodBeat.m2504i(136402);
        boolean commit = PreferenceManager.getDefaultSharedPreferences(context).edit().putLong(str, l.longValue()).commit();
        AppMethodBeat.m2505o(136402);
        return commit;
    }

    /* renamed from: b */
    public static String m62221b(Context context, String str, String str2) {
        AppMethodBeat.m2504i(136403);
        String string = PreferenceManager.getDefaultSharedPreferences(context).getString(str, str2);
        AppMethodBeat.m2505o(136403);
        return string;
    }

    /* renamed from: b */
    public static Long m62217b(Context context, String str, Long l) {
        AppMethodBeat.m2504i(136404);
        Long valueOf = Long.valueOf(PreferenceManager.getDefaultSharedPreferences(context).getLong(str, l.longValue()));
        AppMethodBeat.m2505o(136404);
        return valueOf;
    }

    /* renamed from: a */
    public static String m62205a(Context context) {
        String str;
        AppMethodBeat.m2504i(136405);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName;
            int i = packageInfo.versionCode;
            if (str == null || str.trim().length() <= 0) {
                str = String.valueOf(i);
                AppMethodBeat.m2505o(136405);
                return str;
            }
        } catch (Exception e) {
            str = "";
        }
        AppMethodBeat.m2505o(136405);
        return str;
    }

    /* renamed from: b */
    public static String m62219b(Context context) {
        AppMethodBeat.m2504i(136406);
        String str = context.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        AppMethodBeat.m2505o(136406);
        return str;
    }

    /* renamed from: c */
    public static List<String> m62228c(Context context) {
        AppMethodBeat.m2504i(136407);
        File file = new File(context.getFilesDir(), "TencentLocation/comp");
        List<String> list = null;
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null && listFiles.length > 0) {
                list = new ArrayList();
                for (File file2 : listFiles) {
                    list.add(file2.getName() + "," + file2.length());
                }
            }
        }
        AppMethodBeat.m2505o(136407);
        return list;
    }

    /* renamed from: d */
    public static String m62230d(Context context) {
        String string;
        AppMethodBeat.m2504i(136408);
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                if (bundle.containsKey("TencentGeoLocationSDK")) {
                    string = bundle.getString("TencentGeoLocationSDK");
                    AppMethodBeat.m2505o(136408);
                    return string;
                } else if (bundle.containsKey("TencentMapSDK")) {
                    string = bundle.getString("TencentMapSDK");
                    AppMethodBeat.m2505o(136408);
                    return string;
                } else {
                    string = "";
                    AppMethodBeat.m2505o(136408);
                    return string;
                }
            }
        } catch (Exception e) {
        }
        string = "";
        AppMethodBeat.m2505o(136408);
        return string;
    }

    /* renamed from: a */
    public static String m62204a() {
        AppMethodBeat.m2504i(136409);
        String replaceAll;
        try {
            replaceAll = Build.MODEL.replaceAll("[_]", "");
            AppMethodBeat.m2505o(136409);
            return replaceAll;
        } catch (Throwable th) {
            replaceAll = "";
            AppMethodBeat.m2505o(136409);
            return replaceAll;
        }
    }

    /* renamed from: b */
    public static String m62218b() {
        AppMethodBeat.m2504i(136410);
        String replaceAll;
        try {
            replaceAll = Build.MANUFACTURER.replaceAll("[_]", "");
            AppMethodBeat.m2505o(136410);
            return replaceAll;
        } catch (Throwable th) {
            replaceAll = "";
            AppMethodBeat.m2505o(136410);
            return replaceAll;
        }
    }

    /* renamed from: c */
    public static int m62225c() {
        return VERSION.SDK_INT;
    }

    /* renamed from: e */
    public static String m62232e(Context context) {
        AppMethodBeat.m2504i(136411);
        String str = "";
        if (context == null) {
            AppMethodBeat.m2505o(136411);
            return str;
        }
        String toLowerCase;
        try {
            if (C37150q.m62210a(context, "android.permission.READ_PHONE_STATE")) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (VERSION.SDK_INT >= 26) {
                    str = telephonyManager.getImei();
                } else {
                    str = telephonyManager.getDeviceId();
                }
                toLowerCase = str == null ? "" : str.toLowerCase();
            } else {
                toLowerCase = str;
            }
        } catch (Throwable th) {
            toLowerCase = str;
        }
        AppMethodBeat.m2505o(136411);
        return toLowerCase;
    }

    /* renamed from: a */
    public static boolean m62210a(Context context, String str) {
        boolean z = true;
        int i = 0;
        AppMethodBeat.m2504i(136412);
        if (context == null || str == null) {
            AppMethodBeat.m2505o(136412);
            return false;
        }
        boolean z2 = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0;
        if (!z2) {
            try {
                String[] strArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
                if (strArr != null) {
                    int length = strArr.length;
                    while (i < length) {
                        if (str.equals(strArr[i])) {
                            break;
                        }
                        i++;
                    }
                }
                z = z2;
            } catch (Throwable th) {
            }
            AppMethodBeat.m2505o(136412);
            return z;
        }
        z = z2;
        AppMethodBeat.m2505o(136412);
        return z;
    }

    /* renamed from: a */
    public static String m62206a(File file) {
        AppMethodBeat.m2504i(136413);
        if (file.isFile()) {
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                FileInputStream fileInputStream = new FileInputStream(file);
                while (true) {
                    int read = fileInputStream.read(bArr, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    if (read != -1) {
                        instance.update(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        String c = C37150q.m62227c(instance.digest());
                        AppMethodBeat.m2505o(136413);
                        return c;
                    }
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(136413);
                return null;
            }
        }
        AppMethodBeat.m2505o(136413);
        return null;
    }

    /* renamed from: a */
    public static String m62207a(String str) {
        AppMethodBeat.m2504i(136414);
        try {
            str = C37150q.m62227c(MessageDigest.getInstance("MD5").digest(str.getBytes()));
            AppMethodBeat.m2505o(136414);
        } catch (Exception e) {
            AppMethodBeat.m2505o(136414);
        }
        return str;
    }

    /* renamed from: c */
    private static String m62227c(byte[] bArr) {
        AppMethodBeat.m2504i(136415);
        String str;
        if (bArr == null) {
            str = "";
            AppMethodBeat.m2505o(136415);
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuffer.append(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            stringBuffer.append(toHexString);
        }
        str = stringBuffer.toString().toLowerCase();
        AppMethodBeat.m2505o(136415);
        return str;
    }

    /* renamed from: d */
    public static long m62229d() {
        AppMethodBeat.m2504i(136416);
        long j = 0;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            j = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(136416);
        return j;
    }

    /* renamed from: f */
    public static boolean m62234f(Context context) {
        AppMethodBeat.m2504i(136417);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager != null) {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                    AppMethodBeat.m2505o(136417);
                    return true;
                }
            }
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(136417);
        return false;
    }

    /* renamed from: a */
    public static void m62209a(long j) {
        AppMethodBeat.m2504i(136418);
        try {
            Thread.sleep(j);
            AppMethodBeat.m2505o(136418);
        } catch (InterruptedException e) {
            AppMethodBeat.m2505o(136418);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A:{SYNTHETIC, Splitter:B:36:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0063 A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0070 A:{SYNTHETIC, Splitter:B:46:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0075 A:{Catch:{ Exception -> 0x0081 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007a A:{Catch:{ Exception -> 0x0081 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032 A:{SYNTHETIC, Splitter:B:21:0x0032} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037 A:{Catch:{ Exception -> 0x0099 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A:{Catch:{ Exception -> 0x0099 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A:{SYNTHETIC, Splitter:B:36:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0063 A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0070 A:{SYNTHETIC, Splitter:B:46:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0075 A:{Catch:{ Exception -> 0x0081 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007a A:{Catch:{ Exception -> 0x0081 }} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0032 A:{SYNTHETIC, Splitter:B:21:0x0032} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0037 A:{Catch:{ Exception -> 0x0099 }} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x003c A:{Catch:{ Exception -> 0x0099 }} */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0059 A:{SYNTHETIC, Splitter:B:36:0x0059} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x005e A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0063 A:{Catch:{ Exception -> 0x0067 }} */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0070 A:{SYNTHETIC, Splitter:B:46:0x0070} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0075 A:{Catch:{ Exception -> 0x0081 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x007a A:{Catch:{ Exception -> 0x0081 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static byte[] m62216a(byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPInputStream gZIPInputStream;
        Throwable th;
        GZIPInputStream gZIPInputStream2;
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(136419);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(136419);
        } else {
            ByteArrayInputStream byteArrayInputStream;
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byteArrayInputStream = new ByteArrayInputStream(bArr);
                    try {
                        gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
                    } catch (Exception e) {
                        gZIPInputStream = bArr2;
                        if (gZIPInputStream != null) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(136419);
                        return bArr2;
                    } catch (Error e2) {
                        gZIPInputStream = bArr2;
                        if (gZIPInputStream != null) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(136419);
                        return bArr2;
                    } catch (Throwable th2) {
                        th = th2;
                        gZIPInputStream2 = bArr2;
                        if (gZIPInputStream2 != null) {
                        }
                        if (byteArrayInputStream != null) {
                        }
                        if (byteArrayOutputStream != null) {
                        }
                        AppMethodBeat.m2505o(136419);
                        throw th;
                    }
                } catch (Exception e3) {
                    gZIPInputStream = bArr2;
                    byteArrayInputStream = bArr2;
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(136419);
                    return bArr2;
                } catch (Error e4) {
                    gZIPInputStream = bArr2;
                    byteArrayInputStream = bArr2;
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(136419);
                    return bArr2;
                } catch (Throwable th22) {
                    th = th22;
                    gZIPInputStream2 = bArr2;
                    byteArrayInputStream = bArr2;
                    if (gZIPInputStream2 != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(136419);
                    throw th;
                }
                try {
                    byte[] bArr3 = new byte[307200];
                    while (true) {
                        int read = gZIPInputStream.read(bArr3);
                        if (read < 0) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr3, 0, read);
                    }
                    bArr2 = byteArrayOutputStream.toByteArray();
                    try {
                        gZIPInputStream.close();
                        byteArrayInputStream.close();
                        byteArrayOutputStream.close();
                    } catch (Exception e5) {
                    }
                } catch (Exception e6) {
                } catch (Error e7) {
                    if (gZIPInputStream != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(136419);
                    return bArr2;
                } catch (Throwable th3) {
                    th = th3;
                    gZIPInputStream2 = gZIPInputStream;
                    if (gZIPInputStream2 != null) {
                    }
                    if (byteArrayInputStream != null) {
                    }
                    if (byteArrayOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(136419);
                    throw th;
                }
            } catch (Exception e8) {
                gZIPInputStream = bArr2;
                byteArrayInputStream = bArr2;
                byteArrayOutputStream = bArr2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e9) {
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                AppMethodBeat.m2505o(136419);
                return bArr2;
            } catch (Error e10) {
                gZIPInputStream = bArr2;
                byteArrayInputStream = bArr2;
                byteArrayOutputStream = bArr2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (Exception e11) {
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                AppMethodBeat.m2505o(136419);
                return bArr2;
            } catch (Throwable th222) {
                th = th222;
                gZIPInputStream2 = bArr2;
                byteArrayInputStream = bArr2;
                byteArrayOutputStream = bArr2;
                if (gZIPInputStream2 != null) {
                    try {
                        gZIPInputStream2.close();
                    } catch (Exception e12) {
                        AppMethodBeat.m2505o(136419);
                        throw th;
                    }
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                AppMethodBeat.m2505o(136419);
                throw th;
            }
            AppMethodBeat.m2505o(136419);
        }
        return bArr2;
    }

    /* renamed from: b */
    public static byte[] m62224b(byte[] bArr) {
        AppMethodBeat.m2504i(136420);
        byte[] bArr2 = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length);
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Throwable th) {
        }
        AppMethodBeat.m2505o(136420);
        return bArr2;
    }

    /* renamed from: a */
    public static byte[] m62215a(int i) {
        AppMethodBeat.m2504i(136421);
        byte[] bArr = new byte[2];
        for (int i2 = 0; i2 < 2; i2++) {
            bArr[i2] = Integer.valueOf(i & 255).byteValue();
            i >>= 8;
        }
        AppMethodBeat.m2505o(136421);
        return bArr;
    }

    /* renamed from: b */
    public static List<C44972a> m62222b(String str) {
        AppMethodBeat.m2504i(136422);
        ArrayList arrayList = new ArrayList();
        try {
            for (String split : str.split(";")) {
                String[] split2 = split.split(",");
                if (split2.length >= 5) {
                    try {
                        C44972a c44972a = new C44972a();
                        c44972a.f17709a = Integer.valueOf(split2[0]).intValue();
                        c44972a.f17710b = split2[1];
                        c44972a.f17711c = split2[2];
                        c44972a.f17712d = Integer.valueOf(split2[3]).intValue();
                        c44972a.f17713e = split2[4];
                        if (split2.length > 5) {
                            c44972a.f17714f = split2[5];
                        }
                        arrayList.add(c44972a);
                    } catch (Exception e) {
                    }
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.m2505o(136422);
        return arrayList;
    }

    /* renamed from: c */
    public static String m62226c(String str) {
        AppMethodBeat.m2504i(136423);
        try {
            JSONObject jSONObject = new JSONObject(str);
            String string = jSONObject.getString("status");
            C25383e.m40075a().mo42397a("DRG", "statucode:".concat(String.valueOf(string)));
            if (string.equals("-3")) {
                AppMethodBeat.m2505o(136423);
                return null;
            } else if (string.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                string = "";
                JSONArray jSONArray = jSONObject.getJSONArray("compList");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    int i2 = jSONObject2.getInt("compId");
                    String string2 = jSONObject2.getString("compVer");
                    string = string + i2 + "," + string2 + "," + jSONObject2.getString("compName") + "," + jSONObject2.getInt("size") + "," + jSONObject2.getString("md5") + ",;";
                }
                AppMethodBeat.m2505o(136423);
                return string;
            } else if (string.equals("-1")) {
                AppMethodBeat.m2505o(136423);
                return null;
            } else if (string.equals("-2")) {
                AppMethodBeat.m2505o(136423);
                return null;
            } else if (string.equals("-4")) {
                AppMethodBeat.m2505o(136423);
                return null;
            } else {
                if (string.equals("-5")) {
                    AppMethodBeat.m2505o(136423);
                    return null;
                }
                AppMethodBeat.m2505o(136423);
                return null;
            }
        } catch (Exception e) {
            C25383e.m40075a().mo42397a("DRG", "statucode:" + e.toString());
        }
    }

    /* renamed from: a */
    public static String m62208a(List<C44972a> list) {
        AppMethodBeat.m2504i(136424);
        StringBuilder stringBuilder = new StringBuilder();
        for (C44972a c44972a : list) {
            stringBuilder.append(c44972a.f17709a).append(",");
            stringBuilder.append(c44972a.f17710b).append(",");
            if (!c44972a.f17711c.contains(".dex")) {
                c44972a.f17711c += ".dex";
            }
            stringBuilder.append(c44972a.f17711c).append(",");
            stringBuilder.append(c44972a.f17712d).append(",");
            stringBuilder.append(c44972a.f17713e).append(",");
            stringBuilder.append(c44972a.f17714f).append(";");
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(136424);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static boolean m62214a(Context context, List<C44972a> list) {
        AppMethodBeat.m2504i(136425);
        List b = C37150q.m62222b(C37150q.m62221b(context, "__SP_Tencent_Loc_COMP_INFO__", ""));
        if (b.size() == 0 || list.size() == 0) {
            AppMethodBeat.m2505o(136425);
            return false;
        }
        for (int i = 0; i < b.size(); i++) {
            C44972a c44972a = (C44972a) b.get(i);
            for (int i2 = 0; i2 < list.size(); i2++) {
                C44972a c44972a2 = (C44972a) list.get(i2);
                if (c44972a2.f17709a == c44972a.f17709a) {
                    c44972a.f17711c = c44972a2.f17711c;
                    c44972a.f17710b = c44972a2.f17710b;
                    c44972a.f17712d = c44972a2.f17712d;
                    c44972a.f17713e = c44972a2.f17713e;
                    break;
                }
            }
        }
        boolean a = C37150q.m62212a(context, "__SP_Tencent_Loc_COMP_INFO__", C37150q.m62208a(b));
        AppMethodBeat.m2505o(136425);
        return a;
    }

    /* renamed from: a */
    public static boolean m62213a(Context context, String str, String str2, String str3, long j, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.m2504i(136426);
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            InputStream open = context.getResources().getAssets().open(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            open.available();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str4, true), WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byteArrayOutputStream.close();
            byte[] a = C37150q.m62216a(C17501m.m27327b(byteArrayOutputStream.toByteArray(), "sE0zy%DVqLnXA$hmNZ8NBwcg7FDrvi!q"));
            if (a != null) {
                bufferedOutputStream.write(a);
                bufferedOutputStream.close();
                z = true;
            }
            open.close();
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(136426);
        return z;
    }

    /* renamed from: d */
    public static boolean m62231d(String str) {
        int i = 0;
        AppMethodBeat.m2504i(136427);
        File file = new File(str);
        if (file.exists()) {
            String[] list = file.list();
            int length = list.length;
            while (i < length) {
                File file2 = new File(str, list[i]);
                if (file2.isDirectory()) {
                    C37150q.m62231d(file2.getAbsolutePath());
                    file2.delete();
                } else {
                    file2.delete();
                }
                i++;
            }
            AppMethodBeat.m2505o(136427);
            return true;
        }
        AppMethodBeat.m2505o(136427);
        return false;
    }

    /* renamed from: b */
    public static boolean m62223b(Context context, String str, String str2, String str3, long j, byte[] bArr) {
        boolean z = false;
        AppMethodBeat.m2504i(136428);
        String str4 = str2 + File.separator + str3;
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdir();
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str4);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.close();
            z = true;
            fileInputStream.close();
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(136428);
        return z;
    }

    /* renamed from: e */
    public static boolean m62233e(String str) {
        AppMethodBeat.m2504i(136429);
        File file = new File(str);
        if (file.exists()) {
            for (String file2 : file.list()) {
                File file3 = new File(str, file2);
                if (file3.isDirectory()) {
                    C37150q.m62231d(file3.getAbsolutePath());
                    file3.delete();
                } else {
                    file3.delete();
                }
            }
            AppMethodBeat.m2505o(136429);
        } else {
            file.mkdirs();
            AppMethodBeat.m2505o(136429);
        }
        return true;
    }

    /* renamed from: b */
    public static String m62220b(Context context, String str) {
        AppMethodBeat.m2504i(136430);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream open = context.getAssets().open(str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuilder.append(readLine);
            }
            bufferedReader.close();
            open.close();
        } catch (IOException | UnsupportedEncodingException e) {
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(136430);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static double m62203a(double d, double d2, double d3, double d4) {
        AppMethodBeat.m2504i(136431);
        double a = C37150q.m62202a(d);
        double a2 = C37150q.m62202a(d3);
        double a3 = C37150q.m62202a(d2) - C37150q.m62202a(d4);
        a = (((double) Math.round(((Math.asin(Math.sqrt(((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin(a3 / 2.0d), 2.0d)) + Math.pow(Math.sin((a - a2) / 2.0d), 2.0d))) * 2.0d) * 6378.137d) * 10000.0d)) / 10000.0d) * 1000.0d;
        AppMethodBeat.m2505o(136431);
        return a;
    }

    /* renamed from: a */
    public static double m62202a(double d) {
        return (3.141592653589793d * d) / 180.0d;
    }

    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A:{SYNTHETIC, Splitter:B:19:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A:{SYNTHETIC, Splitter:B:19:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A:{SYNTHETIC, Splitter:B:19:0x003f} */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0065  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x009b  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: g */
    public static int m62235g(Context context) {
        int i;
        AppMethodBeat.m2504i(136432);
        if (context == null) {
            AppMethodBeat.m2505o(136432);
            return -1;
        }
        int i2;
        Object obj;
        Object obj2;
        Object obj3;
        LocationManager locationManager;
        boolean isProviderEnabled;
        boolean z;
        boolean h = C37150q.m62236h(context);
        Object obj4;
        try {
            Object i22;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    obj4 = 1;
                } else {
                    obj4 = null;
                }
                try {
                    if (VERSION.SDK_INT < 18 || !wifiManager.isScanAlwaysAvailable()) {
                        i22 = 1;
                    } else {
                        obj = 1;
                        obj2 = 1;
                        obj3 = obj4;
                        locationManager = (LocationManager) context.getSystemService(C8741b.LOCATION);
                        if (locationManager == null) {
                            try {
                                i = Secure.getInt(context.getContentResolver(), "location_mode");
                            } catch (Throwable th) {
                                i = 0;
                            }
                            try {
                                isProviderEnabled = locationManager.isProviderEnabled("gps");
                                List allProviders = locationManager.getAllProviders();
                                if (allProviders == null) {
                                    z = false;
                                } else {
                                    z = allProviders.contains("gps");
                                }
                            } catch (Exception e) {
                                i22 = i;
                            }
                        } else {
                            z = false;
                            i = 0;
                            isProviderEnabled = false;
                        }
                        if (h) {
                            i22 = 0;
                        } else {
                            i22 = 1;
                        }
                        if (obj3 == null) {
                            i22 += 2;
                        }
                        if (!isProviderEnabled) {
                            i22 += 4;
                        }
                        if (obj == null) {
                            i22 += 8;
                        }
                        if (!z) {
                            i22 += 16;
                        }
                        if (obj2 == null) {
                            i22 += 32;
                        }
                        switch (i) {
                            case 0:
                                i22 += 64;
                                break;
                            case 1:
                                i22 += 128;
                                break;
                            case 2:
                                i22 += 256;
                                break;
                            case 3:
                                i22 += 512;
                                break;
                        }
                        AppMethodBeat.m2505o(136432);
                        return i22;
                    }
                } catch (Throwable th2) {
                    obj = null;
                    obj2 = null;
                    obj3 = obj4;
                    locationManager = (LocationManager) context.getSystemService(C8741b.LOCATION);
                    if (locationManager == null) {
                    }
                    if (h) {
                    }
                    if (obj3 == null) {
                    }
                    if (isProviderEnabled) {
                    }
                    if (obj == null) {
                    }
                    if (z) {
                    }
                    if (obj2 == null) {
                    }
                    switch (i) {
                        case 0:
                            break;
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                    }
                    AppMethodBeat.m2505o(136432);
                    return i22;
                }
            }
            i22 = null;
            obj4 = null;
            obj = i22;
            obj2 = null;
            obj3 = obj4;
        } catch (Throwable th3) {
            obj4 = null;
            obj = null;
            obj2 = null;
            obj3 = obj4;
            locationManager = (LocationManager) context.getSystemService(C8741b.LOCATION);
            if (locationManager == null) {
            }
            if (h) {
            }
            if (obj3 == null) {
            }
            if (isProviderEnabled) {
            }
            if (obj == null) {
            }
            if (z) {
            }
            if (obj2 == null) {
            }
            switch (i) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            AppMethodBeat.m2505o(136432);
            return i22;
        }
        try {
            locationManager = (LocationManager) context.getSystemService(C8741b.LOCATION);
            if (locationManager == null) {
            }
        } catch (Exception e2) {
            i22 = 0;
            z = false;
            i = i22;
            isProviderEnabled = false;
            if (h) {
            }
            if (obj3 == null) {
            }
            if (isProviderEnabled) {
            }
            if (obj == null) {
            }
            if (z) {
            }
            if (obj2 == null) {
            }
            switch (i) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
            AppMethodBeat.m2505o(136432);
            return i22;
        }
        if (h) {
        }
        if (obj3 == null) {
        }
        if (isProviderEnabled) {
        }
        if (obj == null) {
        }
        if (z) {
        }
        if (obj2 == null) {
        }
        switch (i) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
        AppMethodBeat.m2505o(136432);
        return i22;
    }

    /* renamed from: h */
    private static boolean m62236h(Context context) {
        AppMethodBeat.m2504i(136433);
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                AppMethodBeat.m2505o(136433);
                return false;
            } else if (telephonyManager.getSimState() == 5) {
                AppMethodBeat.m2505o(136433);
                return true;
            } else {
                AppMethodBeat.m2505o(136433);
                return false;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(136433);
            return false;
        }
    }
}
