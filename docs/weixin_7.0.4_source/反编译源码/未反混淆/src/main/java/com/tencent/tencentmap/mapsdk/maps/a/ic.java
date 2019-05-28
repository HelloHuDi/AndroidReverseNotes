package com.tencent.tencentmap.mapsdk.maps.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.lib.util.StringUtil;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.tencentmap.mapsdk.a.aq;
import com.tencent.tencentmap.mapsdk.a.db;
import com.tencent.tencentmap.mapsdk.a.du;
import com.tencent.tencentmap.mapsdk.a.r;
import com.tencent.tencentmap.mapsdk.a.t;
import com.tencent.tencentmap.mapsdk.a.v;
import com.tencent.tencentmap.mapsdk.a.w;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class ic {
    private static String A = null;
    private static String B = null;
    private static int C = 0;
    private static String D = null;
    private static int E = 0;
    public static String a = null;
    public static String b = "TencentMapSDK";
    public static String c = "undefined";
    public static float d = 1.0f;
    public static int e = 2;
    public static int f = 0;
    public static int g = 0;
    public static int h = 0;
    public static boolean i = false;
    public static Bitmap j = null;
    public static final int k = Color.argb(200, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    public static String l = "tencentmap/mapsdk_vector/mark_location_big.png";
    public static int m = 2;
    public static int n = 4000000;
    public static int o = 53500000;
    public static int p = 73670000;
    public static int q = 135100000;
    public static int r = 160;
    public static float s = 0.0f;
    public static aq t = null;
    private static String u = null;
    private static String v = null;
    private static String w = null;
    private static String x = null;
    private static String y = null;
    private static String z = null;

    static {
        AppMethodBeat.i(99834);
        AppMethodBeat.o(99834);
    }

    public static String a() {
        if (z == null) {
            return "";
        }
        return z;
    }

    public static String b() {
        if (A == null) {
            return "";
        }
        return A;
    }

    private static String d(String str) {
        AppMethodBeat.i(99803);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(99803);
            return str2;
        }
        str2 = str.replace("&", "").replace("#", "").replace("?", "");
        AppMethodBeat.o(99803);
        return str2;
    }

    private static String e(String str) {
        AppMethodBeat.i(99804);
        String trim = Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
        AppMethodBeat.o(99804);
        return trim;
    }

    public static void a(Context context) {
        String str;
        AppMethodBeat.i(99805);
        if (D == null) {
            try {
                str = Build.MODEL;
                D = str;
                str = d(str);
                D = str;
                D = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e) {
            }
        }
        if (C == 0) {
            C = VERSION.SDK_INT;
        }
        if (B == null) {
            try {
                str = context.getPackageName();
                B = str;
                str = d(str);
                B = str;
                B = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e2) {
            }
        }
        if (w == null) {
            try {
                str = g(context);
                w = str;
                str = d(str);
                w = str;
                w = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e3) {
            }
        }
        if (x == null) {
            try {
                str = h(context);
                x = str;
                str = d(str);
                x = str;
                x = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e4) {
            }
        }
        if (y == null) {
            try {
                str = i(context);
                y = str;
                str = d(str);
                y = str;
                y = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e5) {
            }
        }
        if (z == null) {
            try {
                str = f(context);
                z = str;
                str = d(str);
                z = str;
                z = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e6) {
            }
        }
        if (A == null) {
            try {
                str = du.c(context);
                A = str;
                str = d(str);
                A = str;
                A = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e7) {
            }
        }
        if (v == null) {
            try {
                str = e(context);
                v = str;
                str = e(str);
                v = str;
                v = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e8) {
            }
        }
        if (u == null) {
            try {
                str = d(context);
                u = str;
                str = d(str);
                u = str;
                u = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e9) {
            }
        }
        if (a == null) {
            try {
                str = c(context);
                a = str;
                a = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e10) {
            }
        }
        if (d == 1.0f) {
            d = 320.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
        }
        s = context.getResources().getDisplayMetrics().density;
        i = w.a(context).c("worldMapEnabled");
        AppMethodBeat.o(99805);
    }

    public static String a(String str, String str2) {
        AppMethodBeat.i(99806);
        String str3 = "";
        String str4 = "";
        if (StringUtil.isEmpty(str)) {
            str = str3;
        }
        if (StringUtil.isEmpty(str2)) {
            str2 = str4;
        }
        str3 = String.format("https://apikey.map.qq.com/mkey/index.php/mkey/check?key=%s&pid=%s&key2=%s&pid2=%s&channel=1&output=json&uuid=unknown&hm=%s&suid=%s&os=%s&psv=%s&ver=%s&dpi=%s&pf=%s&nt=%s", new Object[]{a, B, str, str2, D, z, Integer.valueOf(C), x, "4.2.2.1", y, "androidsdk", A});
        AppMethodBeat.o(99806);
        return str3;
    }

    public static String a(String str) {
        AppMethodBeat.i(99807);
        String format = String.format("/fileupdate?sdkver=%s&pf=%s&fr=02001&imei=%s&appsuid=%s&nettp=%s&api_key=%s", new Object[]{"4.2.2", "androidsdk", a(), B, A, str});
        AppMethodBeat.o(99807);
        return format;
    }

    public static String a(int i) {
        AppMethodBeat.i(99808);
        String format = String.format("key=%s&appid=sdk&logid=ditu&ver=%s&suid=%s&pf=%s&hm=%s&os=%s&nt=%s&dpi=%s&scrn=%s&pname=%s&pid=%s&psv=%s&wtc=%s", new Object[]{a, "4.2.2.1", z, "androidsdk", D, Integer.toString(C), A, Integer.toString(r), y, w, B, x, Integer.toString(i)});
        AppMethodBeat.o(99808);
        return format;
    }

    private static String c(Context context) {
        AppMethodBeat.i(99809);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99809);
            return str;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            str = "";
            AppMethodBeat.o(99809);
            return str;
        } else if (applicationInfo.metaData == null) {
            str = "";
            AppMethodBeat.o(99809);
            return str;
        } else {
            str = applicationInfo.metaData.getString(b);
            AppMethodBeat.o(99809);
            return str;
        }
    }

    private static String d(Context context) {
        AppMethodBeat.i(99810);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99810);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.o(99810);
            return str;
        }
        str = telephonyManager.getSubscriberId();
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(99810);
        return str;
    }

    private static String e(Context context) {
        AppMethodBeat.i(99811);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str;
        if (wifiManager == null) {
            str = "";
            AppMethodBeat.o(99811);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = "";
            AppMethodBeat.o(99811);
            return str;
        }
        str = connectionInfo.getMacAddress();
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(99811);
        return str;
    }

    private static String f(Context context) {
        AppMethodBeat.i(99812);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99812);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.o(99812);
            return str;
        }
        str = telephonyManager.getDeviceId();
        if (str == null) {
            str = "";
        }
        AppMethodBeat.o(99812);
        return str;
    }

    private static String g(Context context) {
        AppMethodBeat.i(99813);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99813);
            return str;
        }
        CharSequence loadLabel;
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        String str2 = "can't find app name";
        if (applicationInfo != null) {
            loadLabel = applicationInfo.loadLabel(packageManager);
        } else {
            Object loadLabel2 = str2;
        }
        str2 = "";
        try {
            str = URLEncoder.encode(loadLabel2.toString(), ProtocolPackage.ServerEncoding);
        } catch (Exception e2) {
            str = str2;
        }
        AppMethodBeat.o(99813);
        return str;
    }

    private static String h(Context context) {
        AppMethodBeat.i(99814);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99814);
            return str;
        }
        str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName + Integer.toString(packageInfo.versionCode);
        } catch (Exception e) {
        }
        AppMethodBeat.o(99814);
        return str;
    }

    private static String i(Context context) {
        AppMethodBeat.i(99815);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.o(99815);
            return str;
        }
        str = "";
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            str = Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Exception e) {
        }
        AppMethodBeat.o(99815);
        return str;
    }

    private static void a(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(99816);
        Field field = null;
        try {
            field = displayMetrics.getClass().getField("densityDpi");
        } catch (NoSuchFieldException | SecurityException e) {
        }
        if (field != null) {
            try {
                r = field.getInt(displayMetrics);
                c();
                AppMethodBeat.o(99816);
                return;
            } catch (IllegalArgumentException e2) {
                AppMethodBeat.o(99816);
                return;
            } catch (IllegalAccessException e3) {
                AppMethodBeat.o(99816);
                return;
            }
        }
        d();
        AppMethodBeat.o(99816);
    }

    private static void b(DisplayMetrics displayMetrics) {
        AppMethodBeat.i(99817);
        r = displayMetrics.densityDpi;
        c();
        AppMethodBeat.o(99817);
    }

    private static void c() {
        AppMethodBeat.i(99818);
        if (r <= 120) {
            m = 1;
            AppMethodBeat.o(99818);
        } else if (r <= 160) {
            m = 2;
            AppMethodBeat.o(99818);
        } else if (r <= 240) {
            m = 3;
            AppMethodBeat.o(99818);
        } else {
            d();
            AppMethodBeat.o(99818);
        }
    }

    private static void d() {
        if (E > 153600) {
            m = 3;
        } else if (E < 153600) {
            m = 1;
        } else {
            m = 2;
        }
    }

    public static void b(Context context) {
        AppMethodBeat.i(99819);
        if (context == null) {
            AppMethodBeat.o(99819);
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        E = displayMetrics.widthPixels * displayMetrics.heightPixels;
        if (VERSION.SDK_INT < 24) {
            a(displayMetrics);
            AppMethodBeat.o(99819);
            return;
        }
        b(displayMetrics);
        AppMethodBeat.o(99819);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A:{SYNTHETIC, Splitter:B:29:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final Bitmap a(Context context, String str) {
        InputStream fileInputStream;
        Throwable th;
        InputStream inputStream;
        Bitmap bitmap = null;
        AppMethodBeat.i(99820);
        if (str != null) {
            try {
                if (str.trim().length() != 0) {
                    String str2;
                    if (str.trim().charAt(0) != IOUtils.DIR_SEPARATOR_UNIX) {
                        str2 = context.getFilesDir() + "/" + str;
                    } else {
                        str2 = context.getFilesDir() + str;
                    }
                    fileInputStream = new FileInputStream(str2);
                    try {
                        bitmap = BitmapFactory.decodeStream(fileInputStream);
                        try {
                            fileInputStream.close();
                        } catch (Exception e) {
                        }
                    } catch (Exception e2) {
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = fileInputStream;
                        if (inputStream != null) {
                        }
                        AppMethodBeat.o(99820);
                        throw th;
                    }
                    AppMethodBeat.o(99820);
                    return bitmap;
                }
            } catch (Exception e3) {
                fileInputStream = bitmap;
            } catch (Throwable th3) {
                th = th3;
                inputStream = bitmap;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Exception e4) {
                    }
                }
                AppMethodBeat.o(99820);
                throw th;
            }
        }
        AppMethodBeat.o(99820);
        return bitmap;
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception e5) {
            }
        }
        AppMethodBeat.o(99820);
        return bitmap;
    }

    public static final Bitmap a(Bitmap bitmap) {
        AppMethodBeat.i(99821);
        Bitmap bitmap2 = null;
        try {
            bitmap2 = Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError e) {
        }
        AppMethodBeat.o(99821);
        return bitmap2;
    }

    public static final Bitmap b(String str) {
        AppMethodBeat.i(99822);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e) {
        }
        AppMethodBeat.o(99822);
        return bitmap;
    }

    public static final Bitmap b(Context context, String str) {
        Closeable b;
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.i(99823);
        try {
            b = v.b(r.a(context).e() + str);
            if (b == null) {
                try {
                    if (t.a() != null) {
                        b = t.b(context, t.a() + str);
                    } else if (t.b() != null) {
                        b = v.b(t.b() + str);
                    }
                } catch (Exception e) {
                    v.a(b);
                    AppMethodBeat.o(99823);
                    return bitmap;
                } catch (OutOfMemoryError e2) {
                    v.a(b);
                    AppMethodBeat.o(99823);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = b;
                    v.a(closeable);
                    AppMethodBeat.o(99823);
                    throw th;
                }
            }
            if (b == null) {
                b = t.b(context, "tencentmap/mapsdk_vector/".concat(String.valueOf(str)));
            }
            bitmap = BitmapFactory.decodeStream(b);
            v.a(b);
        } catch (Exception e3) {
            b = null;
        } catch (OutOfMemoryError e4) {
            b = null;
            v.a(b);
            AppMethodBeat.o(99823);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            v.a(closeable);
            AppMethodBeat.o(99823);
            throw th;
        }
        AppMethodBeat.o(99823);
        return bitmap;
    }

    public static Bitmap a(Context context, int i) {
        AppMethodBeat.i(99824);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeResource(context.getResources(), i);
        } catch (OutOfMemoryError e) {
        }
        AppMethodBeat.o(99824);
        return bitmap;
    }

    public static Bitmap b(Bitmap bitmap) {
        AppMethodBeat.i(99825);
        if (bitmap != null) {
            try {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / d), (int) (((float) bitmap.getHeight()) / d), true);
            } catch (OutOfMemoryError e) {
                AppMethodBeat.o(99825);
                return null;
            }
        }
        AppMethodBeat.o(99825);
        return bitmap;
    }

    public static final Bitmap c(Context context, String str) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.i(99826);
        Closeable open;
        try {
            open = context.getAssets().open(str);
            try {
                bitmap = BitmapFactory.decodeStream(open);
                v.a(open);
            } catch (Exception e) {
                v.a(open);
                AppMethodBeat.o(99826);
                return bitmap;
            } catch (OutOfMemoryError e2) {
                v.a(open);
                AppMethodBeat.o(99826);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                closeable = open;
                v.a(closeable);
                AppMethodBeat.o(99826);
                throw th;
            }
        } catch (Exception e3) {
            open = bitmap;
        } catch (OutOfMemoryError e4) {
            open = bitmap;
            v.a(open);
            AppMethodBeat.o(99826);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            closeable = bitmap;
            v.a(closeable);
            AppMethodBeat.o(99826);
            throw th;
        }
        AppMethodBeat.o(99826);
        return bitmap;
    }

    public static GeoPoint a(db dbVar) {
        AppMethodBeat.i(99827);
        if (dbVar == null) {
            AppMethodBeat.o(99827);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint((int) (dbVar.a * 1000000.0d), (int) (dbVar.b * 1000000.0d));
        AppMethodBeat.o(99827);
        return geoPoint;
    }

    public static List<GeoPoint> a(List<db> list) {
        AppMethodBeat.i(99828);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.o(99828);
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            db dbVar = (db) list.get(i);
            if (dbVar != null) {
                GeoPoint a = a(dbVar);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        AppMethodBeat.o(99828);
        return arrayList;
    }

    public static db a(GeoPoint geoPoint) {
        AppMethodBeat.i(99829);
        if (geoPoint == null) {
            AppMethodBeat.o(99829);
            return null;
        }
        db dbVar = new db(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
        AppMethodBeat.o(99829);
        return dbVar;
    }

    public static String c(String str) {
        AppMethodBeat.i(99830);
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!TextUtils.isEmpty(z)) {
            stringBuilder.append("&deviceid=");
            stringBuilder.append(z);
        }
        if (!TextUtils.isEmpty(B)) {
            stringBuilder.append("&appid=");
            stringBuilder.append(B);
        }
        if (!TextUtils.isEmpty("4.2.2")) {
            stringBuilder.append("&sdkver=");
            stringBuilder.append("4.2.2");
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append("&ui=");
            stringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(c)) {
            stringBuilder.append("&appsuid=");
            try {
                stringBuilder.append(URLEncoder.encode(c, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                stringBuilder.append(e(c));
            }
        }
        stringBuilder.append("&api_key=" + a);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(99830);
        return stringBuilder2;
    }

    public static void a(boolean z) {
        if (z) {
            p = 73670000;
            q = 135100000;
            o = 53500000;
            n = 4000000;
            return;
        }
        p = -180000000;
        q = 180000000;
        o = 85000000;
        n = -85000000;
    }

    public static double a(double d, double d2) {
        AppMethodBeat.i(99831);
        double cos = (6.698324247899813d * d) / Math.cos(0.017453292519943295d * d2);
        AppMethodBeat.o(99831);
        return cos;
    }

    public static int b(String str, String str2) {
        AppMethodBeat.i(99832);
        if (StringUtil.isEmpty(str2)) {
            AppMethodBeat.o(99832);
            return 1;
        } else if (StringUtil.isEmpty(str)) {
            AppMethodBeat.o(99832);
            return -1;
        } else {
            String[] split = str.split("\\.");
            String[] split2 = str2.split("\\.");
            int length = split.length;
            if (length > split2.length) {
                length = split2.length;
            }
            int i = 0;
            while (i < length) {
                if (Integer.valueOf(split2[i]).intValue() < Integer.valueOf(split[i]).intValue()) {
                    AppMethodBeat.o(99832);
                    return 1;
                } else if (Integer.valueOf(split2[i]).intValue() > Integer.valueOf(split[i]).intValue()) {
                    AppMethodBeat.o(99832);
                    return -1;
                } else {
                    i++;
                }
            }
            if (split.length > split2.length) {
                AppMethodBeat.o(99832);
                return 1;
            } else if (split.length == split2.length) {
                AppMethodBeat.o(99832);
                return 0;
            } else {
                AppMethodBeat.o(99832);
                return -1;
            }
        }
    }

    public static db a(db dbVar, db dbVar2) {
        AppMethodBeat.i(99833);
        db dbVar3 = new db((dbVar.a * 2.0d) - dbVar2.a, (dbVar.b * 2.0d) - dbVar2.b);
        AppMethodBeat.o(99833);
        return dbVar3;
    }
}
