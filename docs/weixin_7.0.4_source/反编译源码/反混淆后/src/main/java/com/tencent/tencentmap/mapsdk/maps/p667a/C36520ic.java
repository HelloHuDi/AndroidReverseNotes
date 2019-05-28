package com.tencent.tencentmap.mapsdk.maps.p667a;

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
import com.tencent.tencentmap.mapsdk.p666a.C24331aq;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;
import com.tencent.tencentmap.mapsdk.p666a.C31015v;
import com.tencent.tencentmap.mapsdk.p666a.C31016w;
import com.tencent.tencentmap.mapsdk.p666a.C46765r;
import com.tencent.tencentmap.mapsdk.p666a.C46766t;
import com.tencent.tencentmap.mapsdk.p666a.C5846du;
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

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ic */
public class C36520ic {
    /* renamed from: A */
    private static String f15391A = null;
    /* renamed from: B */
    private static String f15392B = null;
    /* renamed from: C */
    private static int f15393C = 0;
    /* renamed from: D */
    private static String f15394D = null;
    /* renamed from: E */
    private static int f15395E = 0;
    /* renamed from: a */
    public static String f15396a = null;
    /* renamed from: b */
    public static String f15397b = "TencentMapSDK";
    /* renamed from: c */
    public static String f15398c = "undefined";
    /* renamed from: d */
    public static float f15399d = 1.0f;
    /* renamed from: e */
    public static int f15400e = 2;
    /* renamed from: f */
    public static int f15401f = 0;
    /* renamed from: g */
    public static int f15402g = 0;
    /* renamed from: h */
    public static int f15403h = 0;
    /* renamed from: i */
    public static boolean f15404i = false;
    /* renamed from: j */
    public static Bitmap f15405j = null;
    /* renamed from: k */
    public static final int f15406k = Color.argb(200, 0, ErrorCode.STARTDOWNLOAD_4, 255);
    /* renamed from: l */
    public static String f15407l = "tencentmap/mapsdk_vector/mark_location_big.png";
    /* renamed from: m */
    public static int f15408m = 2;
    /* renamed from: n */
    public static int f15409n = 4000000;
    /* renamed from: o */
    public static int f15410o = 53500000;
    /* renamed from: p */
    public static int f15411p = 73670000;
    /* renamed from: q */
    public static int f15412q = 135100000;
    /* renamed from: r */
    public static int f15413r = 160;
    /* renamed from: s */
    public static float f15414s = 0.0f;
    /* renamed from: t */
    public static C24331aq f15415t = null;
    /* renamed from: u */
    private static String f15416u = null;
    /* renamed from: v */
    private static String f15417v = null;
    /* renamed from: w */
    private static String f15418w = null;
    /* renamed from: x */
    private static String f15419x = null;
    /* renamed from: y */
    private static String f15420y = null;
    /* renamed from: z */
    private static String f15421z = null;

    static {
        AppMethodBeat.m2504i(99834);
        AppMethodBeat.m2505o(99834);
    }

    /* renamed from: a */
    public static String m60473a() {
        if (f15421z == null) {
            return "";
        }
        return f15421z;
    }

    /* renamed from: b */
    public static String m60485b() {
        if (f15391A == null) {
            return "";
        }
        return f15391A;
    }

    /* renamed from: d */
    private static String m60493d(String str) {
        AppMethodBeat.m2504i(99803);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(99803);
            return str2;
        }
        str2 = str.replace("&", "").replace("#", "").replace("?", "");
        AppMethodBeat.m2505o(99803);
        return str2;
    }

    /* renamed from: e */
    private static String m60496e(String str) {
        AppMethodBeat.m2504i(99804);
        String trim = Pattern.compile("[^a-zA-Z0-9]").matcher(str).replaceAll("").trim();
        AppMethodBeat.m2505o(99804);
        return trim;
    }

    /* renamed from: a */
    public static void m60478a(Context context) {
        String str;
        AppMethodBeat.m2504i(99805);
        if (f15394D == null) {
            try {
                str = Build.MODEL;
                f15394D = str;
                str = C36520ic.m60493d(str);
                f15394D = str;
                f15394D = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e) {
            }
        }
        if (f15393C == 0) {
            f15393C = VERSION.SDK_INT;
        }
        if (f15392B == null) {
            try {
                str = context.getPackageName();
                f15392B = str;
                str = C36520ic.m60493d(str);
                f15392B = str;
                f15392B = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e2) {
            }
        }
        if (f15418w == null) {
            try {
                str = C36520ic.m60498g(context);
                f15418w = str;
                str = C36520ic.m60493d(str);
                f15418w = str;
                f15418w = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e3) {
            }
        }
        if (f15419x == null) {
            try {
                str = C36520ic.m60499h(context);
                f15419x = str;
                str = C36520ic.m60493d(str);
                f15419x = str;
                f15419x = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e4) {
            }
        }
        if (f15420y == null) {
            try {
                str = C36520ic.m60500i(context);
                f15420y = str;
                str = C36520ic.m60493d(str);
                f15420y = str;
                f15420y = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e5) {
            }
        }
        if (f15421z == null) {
            try {
                str = C36520ic.m60497f(context);
                f15421z = str;
                str = C36520ic.m60493d(str);
                f15421z = str;
                f15421z = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e6) {
            }
        }
        if (f15391A == null) {
            try {
                str = C5846du.m8975c(context);
                f15391A = str;
                str = C36520ic.m60493d(str);
                f15391A = str;
                f15391A = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e7) {
            }
        }
        if (f15417v == null) {
            try {
                str = C36520ic.m60495e(context);
                f15417v = str;
                str = C36520ic.m60496e(str);
                f15417v = str;
                f15417v = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e8) {
            }
        }
        if (f15416u == null) {
            try {
                str = C36520ic.m60492d(context);
                f15416u = str;
                str = C36520ic.m60493d(str);
                f15416u = str;
                f15416u = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e9) {
            }
        }
        if (f15396a == null) {
            try {
                str = C36520ic.m60489c(context);
                f15396a = str;
                f15396a = URLEncoder.encode(str, ProtocolPackage.ServerEncoding);
            } catch (Exception e10) {
            }
        }
        if (f15399d == 1.0f) {
            f15399d = 320.0f / ((float) context.getResources().getDisplayMetrics().densityDpi);
        }
        f15414s = context.getResources().getDisplayMetrics().density;
        f15404i = C31016w.m49806a(context).mo65089c("worldMapEnabled");
        AppMethodBeat.m2505o(99805);
    }

    /* renamed from: a */
    public static String m60476a(String str, String str2) {
        AppMethodBeat.m2504i(99806);
        String str3 = "";
        String str4 = "";
        if (StringUtil.isEmpty(str)) {
            str = str3;
        }
        if (StringUtil.isEmpty(str2)) {
            str2 = str4;
        }
        str3 = String.format("https://apikey.map.qq.com/mkey/index.php/mkey/check?key=%s&pid=%s&key2=%s&pid2=%s&channel=1&output=json&uuid=unknown&hm=%s&suid=%s&os=%s&psv=%s&ver=%s&dpi=%s&pf=%s&nt=%s", new Object[]{f15396a, f15392B, str, str2, f15394D, f15421z, Integer.valueOf(f15393C), f15419x, "4.2.2.1", f15420y, "androidsdk", f15391A});
        AppMethodBeat.m2505o(99806);
        return str3;
    }

    /* renamed from: a */
    public static String m60475a(String str) {
        AppMethodBeat.m2504i(99807);
        String format = String.format("/fileupdate?sdkver=%s&pf=%s&fr=02001&imei=%s&appsuid=%s&nettp=%s&api_key=%s", new Object[]{"4.2.2", "androidsdk", C36520ic.m60473a(), f15392B, f15391A, str});
        AppMethodBeat.m2505o(99807);
        return format;
    }

    /* renamed from: a */
    public static String m60474a(int i) {
        AppMethodBeat.m2504i(99808);
        String format = String.format("key=%s&appid=sdk&logid=ditu&ver=%s&suid=%s&pf=%s&hm=%s&os=%s&nt=%s&dpi=%s&scrn=%s&pname=%s&pid=%s&psv=%s&wtc=%s", new Object[]{f15396a, "4.2.2.1", f15421z, "androidsdk", f15394D, Integer.toString(f15393C), f15391A, Integer.toString(f15413r), f15420y, f15418w, f15392B, f15419x, Integer.toString(i)});
        AppMethodBeat.m2505o(99808);
        return format;
    }

    /* renamed from: c */
    private static String m60489c(Context context) {
        AppMethodBeat.m2504i(99809);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99809);
            return str;
        }
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
        } catch (NameNotFoundException e) {
        }
        if (applicationInfo == null) {
            str = "";
            AppMethodBeat.m2505o(99809);
            return str;
        } else if (applicationInfo.metaData == null) {
            str = "";
            AppMethodBeat.m2505o(99809);
            return str;
        } else {
            str = applicationInfo.metaData.getString(f15397b);
            AppMethodBeat.m2505o(99809);
            return str;
        }
    }

    /* renamed from: d */
    private static String m60492d(Context context) {
        AppMethodBeat.m2504i(99810);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99810);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.m2505o(99810);
            return str;
        }
        str = telephonyManager.getSubscriberId();
        if (str == null) {
            str = "";
        }
        AppMethodBeat.m2505o(99810);
        return str;
    }

    /* renamed from: e */
    private static String m60495e(Context context) {
        AppMethodBeat.m2504i(99811);
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        String str;
        if (wifiManager == null) {
            str = "";
            AppMethodBeat.m2505o(99811);
            return str;
        }
        WifiInfo connectionInfo = wifiManager.getConnectionInfo();
        if (connectionInfo == null) {
            str = "";
            AppMethodBeat.m2505o(99811);
            return str;
        }
        str = connectionInfo.getMacAddress();
        if (str == null) {
            str = "";
        }
        AppMethodBeat.m2505o(99811);
        return str;
    }

    /* renamed from: f */
    private static String m60497f(Context context) {
        AppMethodBeat.m2504i(99812);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99812);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            str = "";
            AppMethodBeat.m2505o(99812);
            return str;
        }
        str = telephonyManager.getDeviceId();
        if (str == null) {
            str = "";
        }
        AppMethodBeat.m2505o(99812);
        return str;
    }

    /* renamed from: g */
    private static String m60498g(Context context) {
        AppMethodBeat.m2504i(99813);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99813);
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
        AppMethodBeat.m2505o(99813);
        return str;
    }

    /* renamed from: h */
    private static String m60499h(Context context) {
        AppMethodBeat.m2504i(99814);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99814);
            return str;
        }
        str = "";
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            str = packageInfo.versionName + Integer.toString(packageInfo.versionCode);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(99814);
        return str;
    }

    /* renamed from: i */
    private static String m60500i(Context context) {
        AppMethodBeat.m2504i(99815);
        String str;
        if (context == null) {
            str = "";
            AppMethodBeat.m2505o(99815);
            return str;
        }
        str = "";
        try {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            str = Integer.toString(displayMetrics.widthPixels) + "*" + Integer.toString(displayMetrics.heightPixels);
        } catch (Exception e) {
        }
        AppMethodBeat.m2505o(99815);
        return str;
    }

    /* renamed from: a */
    private static void m60479a(DisplayMetrics displayMetrics) {
        AppMethodBeat.m2504i(99816);
        Field field = null;
        try {
            field = displayMetrics.getClass().getField("densityDpi");
        } catch (NoSuchFieldException | SecurityException e) {
        }
        if (field != null) {
            try {
                f15413r = field.getInt(displayMetrics);
                C36520ic.m60491c();
                AppMethodBeat.m2505o(99816);
                return;
            } catch (IllegalArgumentException e2) {
                AppMethodBeat.m2505o(99816);
                return;
            } catch (IllegalAccessException e3) {
                AppMethodBeat.m2505o(99816);
                return;
            }
        }
        C36520ic.m60494d();
        AppMethodBeat.m2505o(99816);
    }

    /* renamed from: b */
    private static void m60487b(DisplayMetrics displayMetrics) {
        AppMethodBeat.m2504i(99817);
        f15413r = displayMetrics.densityDpi;
        C36520ic.m60491c();
        AppMethodBeat.m2505o(99817);
    }

    /* renamed from: c */
    private static void m60491c() {
        AppMethodBeat.m2504i(99818);
        if (f15413r <= 120) {
            f15408m = 1;
            AppMethodBeat.m2505o(99818);
        } else if (f15413r <= 160) {
            f15408m = 2;
            AppMethodBeat.m2505o(99818);
        } else if (f15413r <= 240) {
            f15408m = 3;
            AppMethodBeat.m2505o(99818);
        } else {
            C36520ic.m60494d();
            AppMethodBeat.m2505o(99818);
        }
    }

    /* renamed from: d */
    private static void m60494d() {
        if (f15395E > 153600) {
            f15408m = 3;
        } else if (f15395E < 153600) {
            f15408m = 1;
        } else {
            f15408m = 2;
        }
    }

    /* renamed from: b */
    public static void m60486b(Context context) {
        AppMethodBeat.m2504i(99819);
        if (context == null) {
            AppMethodBeat.m2505o(99819);
            return;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        f15395E = displayMetrics.widthPixels * displayMetrics.heightPixels;
        if (VERSION.SDK_INT < 24) {
            C36520ic.m60479a(displayMetrics);
            AppMethodBeat.m2505o(99819);
            return;
        }
        C36520ic.m60487b(displayMetrics);
        AppMethodBeat.m2505o(99819);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0077 A:{SYNTHETIC, Splitter:B:29:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static final Bitmap m60468a(Context context, String str) {
        InputStream fileInputStream;
        Throwable th;
        InputStream inputStream;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(99820);
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
                        AppMethodBeat.m2505o(99820);
                        throw th;
                    }
                    AppMethodBeat.m2505o(99820);
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
                AppMethodBeat.m2505o(99820);
                throw th;
            }
        }
        AppMethodBeat.m2505o(99820);
        return bitmap;
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (Exception e5) {
            }
        }
        AppMethodBeat.m2505o(99820);
        return bitmap;
    }

    /* renamed from: a */
    public static final Bitmap m60469a(Bitmap bitmap) {
        AppMethodBeat.m2504i(99821);
        Bitmap bitmap2 = null;
        try {
            bitmap2 = Bitmap.createBitmap(bitmap);
        } catch (OutOfMemoryError e) {
        }
        AppMethodBeat.m2505o(99821);
        return bitmap2;
    }

    /* renamed from: b */
    public static final Bitmap m60484b(String str) {
        AppMethodBeat.m2504i(99822);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeFile(str);
        } catch (OutOfMemoryError e) {
        }
        AppMethodBeat.m2505o(99822);
        return bitmap;
    }

    /* renamed from: b */
    public static final Bitmap m60482b(Context context, String str) {
        Closeable b;
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(99823);
        try {
            b = C31015v.m49804b(C46765r.m88663a(context).mo75321e() + str);
            if (b == null) {
                try {
                    if (C46766t.m88676a() != null) {
                        b = C46766t.m88679b(context, C46766t.m88676a() + str);
                    } else if (C46766t.m88680b() != null) {
                        b = C31015v.m49804b(C46766t.m88680b() + str);
                    }
                } catch (Exception e) {
                    C31015v.m49801a(b);
                    AppMethodBeat.m2505o(99823);
                    return bitmap;
                } catch (OutOfMemoryError e2) {
                    C31015v.m49801a(b);
                    AppMethodBeat.m2505o(99823);
                    return bitmap;
                } catch (Throwable th2) {
                    th = th2;
                    closeable = b;
                    C31015v.m49801a(closeable);
                    AppMethodBeat.m2505o(99823);
                    throw th;
                }
            }
            if (b == null) {
                b = C46766t.m88679b(context, "tencentmap/mapsdk_vector/".concat(String.valueOf(str)));
            }
            bitmap = BitmapFactory.decodeStream(b);
            C31015v.m49801a(b);
        } catch (Exception e3) {
            b = null;
        } catch (OutOfMemoryError e4) {
            b = null;
            C31015v.m49801a(b);
            AppMethodBeat.m2505o(99823);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            C31015v.m49801a(closeable);
            AppMethodBeat.m2505o(99823);
            throw th;
        }
        AppMethodBeat.m2505o(99823);
        return bitmap;
    }

    /* renamed from: a */
    public static Bitmap m60467a(Context context, int i) {
        AppMethodBeat.m2504i(99824);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeResource(context.getResources(), i);
        } catch (OutOfMemoryError e) {
        }
        AppMethodBeat.m2505o(99824);
        return bitmap;
    }

    /* renamed from: b */
    public static Bitmap m60483b(Bitmap bitmap) {
        AppMethodBeat.m2504i(99825);
        if (bitmap != null) {
            try {
                bitmap = Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) / f15399d), (int) (((float) bitmap.getHeight()) / f15399d), true);
            } catch (OutOfMemoryError e) {
                AppMethodBeat.m2505o(99825);
                return null;
            }
        }
        AppMethodBeat.m2505o(99825);
        return bitmap;
    }

    /* renamed from: c */
    public static final Bitmap m60488c(Context context, String str) {
        Throwable th;
        Closeable closeable;
        Bitmap bitmap = null;
        AppMethodBeat.m2504i(99826);
        Closeable open;
        try {
            open = context.getAssets().open(str);
            try {
                bitmap = BitmapFactory.decodeStream(open);
                C31015v.m49801a(open);
            } catch (Exception e) {
                C31015v.m49801a(open);
                AppMethodBeat.m2505o(99826);
                return bitmap;
            } catch (OutOfMemoryError e2) {
                C31015v.m49801a(open);
                AppMethodBeat.m2505o(99826);
                return bitmap;
            } catch (Throwable th2) {
                th = th2;
                closeable = open;
                C31015v.m49801a(closeable);
                AppMethodBeat.m2505o(99826);
                throw th;
            }
        } catch (Exception e3) {
            open = bitmap;
        } catch (OutOfMemoryError e4) {
            open = bitmap;
            C31015v.m49801a(open);
            AppMethodBeat.m2505o(99826);
            return bitmap;
        } catch (Throwable th3) {
            th = th3;
            closeable = bitmap;
            C31015v.m49801a(closeable);
            AppMethodBeat.m2505o(99826);
            throw th;
        }
        AppMethodBeat.m2505o(99826);
        return bitmap;
    }

    /* renamed from: a */
    public static GeoPoint m60470a(C24343db c24343db) {
        AppMethodBeat.m2504i(99827);
        if (c24343db == null) {
            AppMethodBeat.m2505o(99827);
            return null;
        }
        GeoPoint geoPoint = new GeoPoint((int) (c24343db.f4615a * 1000000.0d), (int) (c24343db.f4616b * 1000000.0d));
        AppMethodBeat.m2505o(99827);
        return geoPoint;
    }

    /* renamed from: a */
    public static List<GeoPoint> m60477a(List<C24343db> list) {
        AppMethodBeat.m2504i(99828);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(99828);
            return null;
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            C24343db c24343db = (C24343db) list.get(i);
            if (c24343db != null) {
                GeoPoint a = C36520ic.m60470a(c24343db);
                if (a != null) {
                    arrayList.add(a);
                }
            }
        }
        AppMethodBeat.m2505o(99828);
        return arrayList;
    }

    /* renamed from: a */
    public static C24343db m60471a(GeoPoint geoPoint) {
        AppMethodBeat.m2504i(99829);
        if (geoPoint == null) {
            AppMethodBeat.m2505o(99829);
            return null;
        }
        C24343db c24343db = new C24343db(((double) geoPoint.getLatitudeE6()) / 1000000.0d, ((double) geoPoint.getLongitudeE6()) / 1000000.0d);
        AppMethodBeat.m2505o(99829);
        return c24343db;
    }

    /* renamed from: c */
    public static String m60490c(String str) {
        AppMethodBeat.m2504i(99830);
        StringBuilder stringBuilder = new StringBuilder(256);
        if (!TextUtils.isEmpty(f15421z)) {
            stringBuilder.append("&deviceid=");
            stringBuilder.append(f15421z);
        }
        if (!TextUtils.isEmpty(f15392B)) {
            stringBuilder.append("&appid=");
            stringBuilder.append(f15392B);
        }
        if (!TextUtils.isEmpty("4.2.2")) {
            stringBuilder.append("&sdkver=");
            stringBuilder.append("4.2.2");
        }
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append("&ui=");
            stringBuilder.append(str);
        }
        if (!TextUtils.isEmpty(f15398c)) {
            stringBuilder.append("&appsuid=");
            try {
                stringBuilder.append(URLEncoder.encode(f15398c, "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                stringBuilder.append(C36520ic.m60496e(f15398c));
            }
        }
        stringBuilder.append("&api_key=" + f15396a);
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(99830);
        return stringBuilder2;
    }

    /* renamed from: a */
    public static void m60480a(boolean z) {
        if (z) {
            f15411p = 73670000;
            f15412q = 135100000;
            f15410o = 53500000;
            f15409n = 4000000;
            return;
        }
        f15411p = -180000000;
        f15412q = 180000000;
        f15410o = 85000000;
        f15409n = -85000000;
    }

    /* renamed from: a */
    public static double m60466a(double d, double d2) {
        AppMethodBeat.m2504i(99831);
        double cos = (6.698324247899813d * d) / Math.cos(0.017453292519943295d * d2);
        AppMethodBeat.m2505o(99831);
        return cos;
    }

    /* renamed from: b */
    public static int m60481b(String str, String str2) {
        AppMethodBeat.m2504i(99832);
        if (StringUtil.isEmpty(str2)) {
            AppMethodBeat.m2505o(99832);
            return 1;
        } else if (StringUtil.isEmpty(str)) {
            AppMethodBeat.m2505o(99832);
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
                    AppMethodBeat.m2505o(99832);
                    return 1;
                } else if (Integer.valueOf(split2[i]).intValue() > Integer.valueOf(split[i]).intValue()) {
                    AppMethodBeat.m2505o(99832);
                    return -1;
                } else {
                    i++;
                }
            }
            if (split.length > split2.length) {
                AppMethodBeat.m2505o(99832);
                return 1;
            } else if (split.length == split2.length) {
                AppMethodBeat.m2505o(99832);
                return 0;
            } else {
                AppMethodBeat.m2505o(99832);
                return -1;
            }
        }
    }

    /* renamed from: a */
    public static C24343db m60472a(C24343db c24343db, C24343db c24343db2) {
        AppMethodBeat.m2504i(99833);
        C24343db c24343db3 = new C24343db((c24343db.f4615a * 2.0d) - c24343db2.f4615a, (c24343db.f4616b * 2.0d) - c24343db2.f4616b);
        AppMethodBeat.m2505o(99833);
        return c24343db3;
    }
}
