package com.tencent.tencentmap.mapsdk.p666a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.util.Base64;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tencentmap.mapsdk.maps.p667a.C16205ag;
import com.tencent.tencentmap.mapsdk.maps.p667a.C24356av;
import com.tencent.tencentmap.mapsdk.maps.p667a.C25011ax;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31019an;
import com.tencent.tencentmap.mapsdk.maps.p667a.C31082r;
import com.tencent.tencentmap.mapsdk.maps.p667a.C36481aa;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44539p;
import com.tencent.tencentmap.mapsdk.maps.p667a.C44544y;
import com.tencent.tencentmap.mapsdk.maps.p667a.C46768aq;
import com.tencent.tencentmap.mapsdk.maps.p667a.C5853ac;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.http.util.EncodingUtils;

/* renamed from: com.tencent.tencentmap.mapsdk.a.e */
public final class C24349e {
    /* renamed from: a */
    private static C24349e f4624a;

    /* renamed from: o */
    private static NetworkInfo m37623o(Context context) {
        AppMethodBeat.m2504i(97824);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.m2505o(97824);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            AppMethodBeat.m2505o(97824);
            return activeNetworkInfo;
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            AppMethodBeat.m2505o(97824);
            return null;
        }
    }

    /* renamed from: j */
    public static int m37618j(Context context) {
        AppMethodBeat.m2504i(97796);
        C16205ag.m24683a(" RecordDAO.countRecordNum() start", new Object[0]);
        if (context == null) {
            C16205ag.m24687d(" countRecordNum() have null args!", new Object[0]);
            AppMethodBeat.m2505o(97796);
            return -1;
        }
        int b = C44539p.m80857b(context, new int[]{1});
        AppMethodBeat.m2505o(97796);
        return b;
    }

    /* renamed from: a */
    public static C5853ac m37575a(C24356av c24356av) {
        AppMethodBeat.m2504i(97794);
        if (c24356av == null || !"UA".equals(c24356av.mo40532b())) {
            AppMethodBeat.m2505o(97794);
            return null;
        }
        Map e = c24356av.mo40537e();
        if (e == null) {
            AppMethodBeat.m2505o(97794);
            return null;
        }
        try {
            C5853ac c5853ac = new C5853ac();
            c5853ac.f1509a = (String) e.get("A19");
            c5853ac.f1511c = c24356av.mo40536d();
            c5853ac.f1516h = c24356av.mo40535c();
            c5853ac.f1510b = (String) e.get("A28");
            c5853ac.f1514f = Long.parseLong((String) e.get("A26"));
            c5853ac.f1512d = Boolean.parseBoolean((String) e.get("A25"));
            c5853ac.f1513e = Long.parseLong((String) e.get("A27"));
            e.remove("A19");
            e.remove("A28");
            e.remove("A26");
            e.remove("A25");
            e.remove("A27");
            c5853ac.f1515g = C24349e.m37578a(e);
            AppMethodBeat.m2505o(97794);
            return c5853ac;
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            C16205ag.m24687d(th.getMessage(), new Object[0]);
            AppMethodBeat.m2505o(97794);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0 A:{SYNTHETIC, Splitter:B:50:0x00d0} */
    /* JADX WARNING: Missing block: B:31:0x00a2, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(97789);
     */
    /* JADX WARNING: Missing block: B:63:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static Object[] m37591a(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.m2504i(97789);
        synchronized (C31082r.f14320a) {
            if (context == null) {
                try {
                    C16205ag.m24686c("context == null ", new Object[0]);
                } finally {
                    AppMethodBeat.m2505o(97789);
                }
            } else if (str == null) {
                C16205ag.m24686c("key == null ", new Object[0]);
                AppMethodBeat.m2505o(97789);
                return null;
            } else {
                try {
                    SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        C16205ag.m24686c("getWritableDatabase fail! ", new Object[0]);
                        AppMethodBeat.m2505o(97789);
                        return null;
                    }
                    Cursor query = writableDatabase.query("t_conf", null, "_key = '" + str + "'", null, null, null, null);
                    if (query != null) {
                        try {
                            if (query.moveToNext()) {
                                Object[] objArr = new Object[]{str, query.getString(query.getColumnIndex("_value")), Long.valueOf(query.getLong(query.getColumnIndex("_vdate")))};
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                    }
                                }
                            }
                        } catch (Exception e) {
                            cursor = query;
                            if (cursor != null) {
                                if (!cursor.isClosed()) {
                                    cursor.close();
                                }
                            }
                            AppMethodBeat.m2505o(97789);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = query;
                            if (cursor2 != null) {
                            }
                            AppMethodBeat.m2505o(97789);
                            throw th;
                        }
                    }
                    if (query != null) {
                        if (!query.isClosed()) {
                            query.close();
                        }
                    }
                } catch (Exception e2) {
                    cursor = null;
                } catch (Throwable th3) {
                    th = th3;
                    if (cursor2 != null) {
                        if (!cursor2.isClosed()) {
                            cursor2.close();
                        }
                    }
                    AppMethodBeat.m2505o(97789);
                    throw th;
                }
            }
            return cursor2;
        }
    }

    /* renamed from: a */
    public static synchronized boolean m37581a(Context context, C44544y c44544y) {
        boolean z = true;
        boolean z2 = false;
        synchronized (C24349e.class) {
            AppMethodBeat.m2504i(97791);
            if (context == null || c44544y == null) {
                C16205ag.m24686c("context == null || bean == null}", new Object[0]);
                AppMethodBeat.m2505o(97791);
            } else {
                try {
                    SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        C16205ag.m24687d("get db fail!,return false ", new Object[0]);
                        AppMethodBeat.m2505o(97791);
                    } else {
                        ContentValues contentValues;
                        if (c44544y == null) {
                            contentValues = null;
                        } else {
                            contentValues = new ContentValues();
                            if (c44544y.mo70961a() >= 0) {
                                contentValues.put("_id", Long.valueOf(c44544y.mo70961a()));
                            }
                            contentValues.put("_key", Integer.valueOf(c44544y.mo70965b()));
                            contentValues.put("_datas", c44544y.mo70966c());
                        }
                        if (contentValues != null) {
                            long replace = writableDatabase.replace("t_strategy", "_id", contentValues);
                            if (replace < 0) {
                                C16205ag.m24686c("insert failure! return false ", new Object[0]);
                                AppMethodBeat.m2505o(97791);
                            } else {
                                c44544y.mo70963a(replace);
                                C16205ag.m24688e("update strategy  %d true ", Integer.valueOf(c44544y.mo70965b()));
                            }
                        } else {
                            z = false;
                        }
                        z2 = z;
                        AppMethodBeat.m2505o(97791);
                    }
                } catch (Throwable th) {
                    C16205ag.m24687d("Error strategy update!  %s", th.toString());
                }
            }
        }
        return z2;
    }

    /* renamed from: a */
    public static synchronized C24349e m37573a(Context context) {
        C24349e c24349e;
        synchronized (C24349e.class) {
            AppMethodBeat.m2504i(97776);
            if (f4624a == null && context != null) {
                f4624a = new C24349e();
            }
            c24349e = f4624a;
            AppMethodBeat.m2505o(97776);
        }
        return c24349e;
    }

    /* renamed from: l */
    public static boolean m37620l(Context context) {
        AppMethodBeat.m2504i(97825);
        NetworkInfo o = C24349e.m37623o(context);
        if (o == null || o.getType() != 1) {
            AppMethodBeat.m2505o(97825);
            return false;
        }
        AppMethodBeat.m2505o(97825);
        return true;
    }

    /* renamed from: a */
    public static Long[] m37590a(Context context, List<C24356av> list) {
        int i = 0;
        AppMethodBeat.m2504i(97797);
        C16205ag.m24683a(" RecordDAO.insertList() start", new Object[0]);
        if (context == null || list == null) {
            C16205ag.m24687d(" insertList() have null args!", new Object[0]);
            AppMethodBeat.m2505o(97797);
            return null;
        }
        int size = list.size();
        if (size == 0) {
            C16205ag.m24685b(" list siez == 0 , return true!", new Object[0]);
            AppMethodBeat.m2505o(97797);
            return null;
        }
        Long[] lArr = new Long[size];
        List<C44539p> arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = (C24356av) list.get(i2);
            if (obj == null || obj.mo40532b() == null || !obj.mo40532b().equals("UA")) {
                C16205ag.m24687d(" bean's type is error!", new Object[0]);
            } else {
                try {
                    arrayList.add(new C44539p(obj.mo40535c(), C24349e.m37583a(obj)));
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                }
            }
        }
        if (C44539p.m80855a(context, (List) arrayList)) {
            for (C44539p c44539p : arrayList) {
                if (i < size) {
                    lArr[i] = Long.valueOf(c44539p.f17495a);
                }
                i++;
            }
            AppMethodBeat.m2505o(97797);
            return lArr;
        }
        AppMethodBeat.m2505o(97797);
        return null;
    }

    private C24349e() {
    }

    /* renamed from: m */
    public static boolean m37621m(Context context) {
        AppMethodBeat.m2504i(97826);
        NetworkInfo o = C24349e.m37623o(context);
        if (o == null || !o.isConnected()) {
            AppMethodBeat.m2505o(97826);
            return false;
        }
        AppMethodBeat.m2505o(97826);
        return true;
    }

    /* renamed from: a */
    public static String m37577a() {
        AppMethodBeat.m2504i(97777);
        String str;
        try {
            str = Build.MODEL;
            AppMethodBeat.m2505o(97777);
            return str;
        } catch (Throwable th) {
            C16205ag.m24687d("getDeviceName error", new Object[0]);
            C16205ag.m24684a(th);
            str = "";
            AppMethodBeat.m2505o(97777);
            return str;
        }
    }

    /* renamed from: d */
    public static Date m37606d(String str) {
        Date date = null;
        AppMethodBeat.m2504i(97807);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.m2505o(97807);
        } else {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
                AppMethodBeat.m2505o(97807);
            } catch (ParseException e) {
                C16205ag.m24684a(e);
                AppMethodBeat.m2505o(97807);
            }
        }
        return date;
    }

    /* renamed from: n */
    public static String m37622n(Context context) {
        AppMethodBeat.m2504i(97827);
        NetworkInfo o = C24349e.m37623o(context);
        String str;
        if (o == null) {
            str = "unknown";
            AppMethodBeat.m2505o(97827);
            return str;
        } else if (o.getType() == 1) {
            str = "wifi";
            AppMethodBeat.m2505o(97827);
            return str;
        } else {
            str = o.getExtraInfo();
            if (str != null && str.length() > 64) {
                str = str.substring(0, 64);
            }
            AppMethodBeat.m2505o(97827);
            return str;
        }
    }

    /* renamed from: b */
    public static String m37593b() {
        AppMethodBeat.m2504i(97778);
        String str;
        try {
            str = VERSION.RELEASE;
            AppMethodBeat.m2505o(97778);
            return str;
        } catch (Throwable th) {
            C16205ag.m24687d("getVersion error", new Object[0]);
            C16205ag.m24684a(th);
            str = "";
            AppMethodBeat.m2505o(97778);
            return str;
        }
    }

    /* renamed from: b */
    public static String m37596b(String str) {
        AppMethodBeat.m2504i(97804);
        String str2 = "unknown";
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.m2505o(97804);
        } else {
            String trim = str.trim();
            int length = trim.length();
            char charAt;
            do {
                length--;
                if (length < 0) {
                    length = 1;
                    break;
                }
                charAt = trim.charAt(length);
                if (charAt < '0') {
                    break;
                }
            } while (charAt <= '9');
            length = 0;
            if (length != 0) {
                str2 = str.trim();
                if (str2.length() > 16) {
                    str2 = str2.substring(0, 16);
                }
                AppMethodBeat.m2505o(97804);
            } else {
                C16205ag.m24686c("channelID is invalid!! channelID should be Numeric! channelID:".concat(String.valueOf(str)), new Object[0]);
                AppMethodBeat.m2505o(97804);
            }
        }
        return str2;
    }

    /* renamed from: a */
    public static C24356av m37576a(Context context, String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        AppMethodBeat.m2504i(97795);
        if (str == null) {
            AppMethodBeat.m2505o(97795);
            return null;
        }
        C41014c m = C41014c.m71224m();
        if (m == null) {
            C16205ag.m24687d("  CommonInfo or DeviceInfo have not been Created return null!", new Object[0]);
            AppMethodBeat.m2505o(97795);
            return null;
        }
        C31019an.m49815a();
        long time = new Date().getTime() + m.mo65058h();
        String g = m.mo65057g();
        Object n = C24349e.m37622n(context);
        if (n == null) {
            n = BuildConfig.COMMAND;
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        Object obj = null;
        if (C25011ax.m39275d().mo41926g().mo75354h() && !str.startsWith("rqd_")) {
            obj = 1;
        }
        C46768aq a = C46768aq.m88698a(context);
        if (obj == null) {
            String b = C31019an.m49823b();
            if (!(b == null || b.equals(""))) {
                hashMap.put("QQ", b);
            }
            hashMap.put("A2", m.mo65059i());
            hashMap.put("A4", a.mo75338c());
            hashMap.put("A6", a.mo75337b());
            hashMap.put("A7", a.mo75339d());
            hashMap.put("A23", m.mo65061k());
            hashMap.put("A31", a.mo75341f());
            hashMap.put("A67", C41003a.m71131i(context));
            hashMap.put("A76", C41003a.m71113a());
            hashMap.put("A95", C41003a.m71126e(context));
        }
        hashMap.put("A19", n);
        hashMap.put("A28", g);
        hashMap.put("A25", String.valueOf(z));
        hashMap.put("A26", String.valueOf(j));
        hashMap.put("A27", String.valueOf(j2));
        C24356av c24356av = new C24356av();
        c24356av.mo40534b(str);
        c24356av.mo40533b(time);
        c24356av.mo40529a("UA");
        c24356av.mo40530a(hashMap);
        c24356av.mo40531a(z2);
        AppMethodBeat.m2505o(97795);
        return c24356av;
    }

    /* JADX WARNING: Missing block: B:9:0x0015, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.m2505o(97790);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public static boolean m37582a(Context context, String str, Object[] objArr) {
        boolean z;
        AppMethodBeat.m2504i(97790);
        synchronized (C31082r.f14320a) {
            if (!(context == null || str == null || objArr == null)) {
                try {
                    if (objArr.length != 0) {
                        try {
                            SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                            writableDatabase.delete("t_conf", "_key = '" + str + "'", null);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_key", str);
                            contentValues.put("_value", (String) objArr[0]);
                            contentValues.put("_vdate", (Long) objArr[1]);
                            contentValues.put("_time", Long.valueOf(new Date().getTime()));
                            if (writableDatabase.insert("t_conf", null, contentValues) < 0) {
                                C16205ag.m24687d(" insertOrUpdateByKey failure! return false!", new Object[0]);
                                z = false;
                            } else {
                                z = true;
                            }
                        } catch (Exception e) {
                            z = false;
                        }
                    }
                } finally {
                    AppMethodBeat.m2505o(97790);
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0077 A:{SYNTHETIC, Splitter:B:37:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static byte[] m37583a(Object obj) {
        Throwable th;
        byte[] bArr = null;
        AppMethodBeat.m2504i(97808);
        C16205ag.m24685b("en obj 2 bytes ", new Object[0]);
        if (obj == null || !Serializable.class.isInstance(obj)) {
            C16205ag.m24686c("not serial obj ", new Object[0]);
            AppMethodBeat.m2505o(97808);
        } else {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream;
            try {
                objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
                try {
                    objectOutputStream.writeObject(obj);
                    objectOutputStream.flush();
                    bArr = byteArrayOutputStream.toByteArray();
                    try {
                        objectOutputStream.close();
                    } catch (IOException e) {
                        C16205ag.m24684a(e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        C16205ag.m24684a(e2);
                    }
                    AppMethodBeat.m2505o(97808);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                objectOutputStream = bArr;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (IOException e3) {
                        C16205ag.m24684a(e3);
                    }
                }
                byteArrayOutputStream.close();
                AppMethodBeat.m2505o(97808);
                throw th;
            }
        }
        return bArr;
    }

    /* renamed from: c */
    public static String m37601c() {
        AppMethodBeat.m2504i(97779);
        String str;
        try {
            str = VERSION.SDK;
            AppMethodBeat.m2505o(97779);
            return str;
        } catch (Throwable th) {
            C16205ag.m24687d("getApiLevel error", new Object[0]);
            C16205ag.m24684a(th);
            str = "";
            AppMethodBeat.m2505o(97779);
            return str;
        }
    }

    /* renamed from: a */
    private static byte[] m37585a(String str, byte[] bArr) {
        AppMethodBeat.m2504i(97801);
        if (str == null || bArr == null) {
            AppMethodBeat.m2505o(97801);
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String substring = str.substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(2, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.m2505o(97801);
        return doFinal;
    }

    /* renamed from: a */
    private static byte[] m37586a(byte[] bArr) {
        AppMethodBeat.m2504i(97800);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
        byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int read = gZIPInputStream.read(bArr2, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            if (read != -1) {
                byteArrayOutputStream.write(bArr2, 0, read);
            } else {
                bArr2 = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
                AppMethodBeat.m2505o(97800);
                return bArr2;
            }
        }
    }

    /* renamed from: b */
    public static String m37594b(Context context) {
        AppMethodBeat.m2504i(97780);
        String str = "";
        if (context == null) {
            C16205ag.m24687d("getImei but context == null!", new Object[0]);
            AppMethodBeat.m2505o(97780);
            return str;
        }
        String deviceId;
        try {
            if (C41003a.m71128f(context)) {
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId == null) {
                    try {
                        deviceId = "";
                    } catch (Throwable th) {
                    }
                } else {
                    deviceId = deviceId.toLowerCase();
                }
            } else {
                deviceId = str;
            }
            C16205ag.m24683a("IMEI:".concat(String.valueOf(deviceId)), new Object[0]);
        } catch (Throwable th2) {
            deviceId = str;
            C16205ag.m24687d("getImei error!", new Object[0]);
            AppMethodBeat.m2505o(97780);
            return deviceId;
        }
        AppMethodBeat.m2505o(97780);
        return deviceId;
    }

    /* renamed from: a */
    private static String m37578a(Map<String, String> map) {
        AppMethodBeat.m2504i(97805);
        C16205ag.m24685b("map 2 str", new Object[0]);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.m2505o(97805);
            return str;
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            str = "";
            AppMethodBeat.m2505o(97805);
            return str;
        }
        if (keySet.size() > 50) {
            C16205ag.m24686c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : keySet) {
            int length = str2.trim().length();
            if (length <= 0 || !C24349e.m37603c(str2)) {
                C16205ag.m24686c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:".concat(String.valueOf(str2)), new Object[0]);
            } else {
                String trim = str2.trim();
                if (length > 64) {
                    trim = trim.substring(0, 64);
                }
                stringBuffer.append("&");
                stringBuffer.append(trim.replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                stringBuffer.append("=");
                str2 = (String) map.get(str2);
                if (str2 != null) {
                    str2 = str2.trim();
                    if (str2.contains(";")) {
                        if (str2.length() > 10240) {
                            str2 = str2.substring(0, 10240);
                            str2 = str2.substring(0, str2.lastIndexOf(";"));
                        }
                    } else if (str2.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                        str2 = str2.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                    }
                    stringBuffer.append(str2.replace(10, ' ').replace(13, ' ').replace("|", "%7C").replace("&", "%26").replace("=", "%3D"));
                }
            }
        }
        str2 = stringBuffer.substring(1);
        stringBuffer.setLength(0);
        AppMethodBeat.m2505o(97805);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A:{SYNTHETIC, Splitter:B:34:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6 A:{SYNTHETIC, Splitter:B:50:0x00e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public static synchronized C44544y m37616h(Context context) {
        C44544y c44544y;
        Throwable th;
        C44544y c44544y2;
        C44544y c44544y3 = null;
        synchronized (C24349e.class) {
            AppMethodBeat.m2504i(97792);
            if (context == null) {
                C16205ag.m24686c("context == null}", new Object[0]);
                AppMethodBeat.m2505o(97792);
                c44544y = null;
            } else {
                Cursor query;
                try {
                    SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        C16205ag.m24686c("getWritableDatabase fail! ", new Object[0]);
                        AppMethodBeat.m2505o(97792);
                        c44544y = null;
                    } else {
                        query = writableDatabase.query("t_strategy", null, String.format(Locale.US, " %s = %d ", new Object[]{"_key", Integer.valueOf(101)}), null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.moveToNext()) {
                                    if (!(query == null || query.isBeforeFirst() || query.isAfterLast())) {
                                        C16205ag.m24685b("parse bean}", new Object[0]);
                                        c44544y = new C44544y();
                                        c44544y.mo70963a(query.getLong(query.getColumnIndex("_id")));
                                        c44544y.mo70962a(query.getInt(query.getColumnIndex("_key")));
                                        c44544y.mo70964a(query.getBlob(query.getColumnIndex("_datas")));
                                        c44544y3 = c44544y;
                                    }
                                    if (c44544y3 != null) {
                                        try {
                                            C16205ag.m24690g("read strategy key: %d", Integer.valueOf(c44544y3.mo70965b()));
                                        } catch (Throwable th2) {
                                            th = th2;
                                            c44544y2 = c44544y3;
                                            try {
                                                C16205ag.m24684a(th);
                                                if (query != null) {
                                                }
                                                c44544y = c44544y2;
                                                AppMethodBeat.m2505o(97792);
                                                return c44544y;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (!(query == null || query.isClosed())) {
                                                    query.close();
                                                }
                                                AppMethodBeat.m2505o(97792);
                                                throw th;
                                            }
                                        }
                                    }
                                    c44544y2 = c44544y3;
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                            c44544y = c44544y2;
                                            AppMethodBeat.m2505o(97792);
                                        }
                                    }
                                    c44544y = c44544y2;
                                    AppMethodBeat.m2505o(97792);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                c44544y2 = null;
                                C16205ag.m24684a(th);
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                        c44544y = c44544y2;
                                        AppMethodBeat.m2505o(97792);
                                        return c44544y;
                                    }
                                }
                                c44544y = c44544y2;
                                AppMethodBeat.m2505o(97792);
                                return c44544y;
                            }
                        }
                        c44544y2 = null;
                        if (query != null) {
                        }
                        c44544y = c44544y2;
                        AppMethodBeat.m2505o(97792);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    query = null;
                    query.close();
                    AppMethodBeat.m2505o(97792);
                    throw th;
                }
            }
        }
        return c44544y;
    }

    /* renamed from: a */
    public static List<C24356av> m37580a(Context context, int i) {
        AppMethodBeat.m2504i(97798);
        C16205ag.m24683a(" RecordDAO.queryRecentRecord() start", new Object[0]);
        if (context == null) {
            C16205ag.m24687d(" queryRecentRecord() have null args!", new Object[0]);
            AppMethodBeat.m2505o(97798);
            return null;
        }
        List a = C44539p.m80852a(context, new int[]{1}, i);
        if (a == null || a.size() <= 0) {
            AppMethodBeat.m2505o(97798);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            C44539p c44539p = (C44539p) it.next();
            try {
                Object b = C24349e.m37592b(c44539p.f17496b);
                if (b != null && C24356av.class.isInstance(b)) {
                    C24356av c24356av = (C24356av) C24356av.class.cast(b);
                    c24356av.mo40528a(c44539p.f17495a);
                    arrayList.add(c24356av);
                    it.remove();
                }
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                C16205ag.m24687d(" query have error!", new Object[0]);
            }
        }
        if (a.size() > 0) {
            C16205ag.m24683a(" there are error datas ,should be remove " + a.size(), new Object[0]);
            Long[] lArr = new Long[a.size()];
            for (int i2 = 0; i2 < a.size(); i2++) {
                lArr[i2] = Long.valueOf(((C44539p) a.get(i2)).f17495a);
            }
            C44539p.m80850a(context, lArr);
        }
        C16205ag.m24683a(" RecordDAO.queryRecentRecord() end", new Object[0]);
        AppMethodBeat.m2505o(97798);
        return arrayList;
    }

    /* renamed from: b */
    private static byte[] m37597b(String str, byte[] bArr) {
        AppMethodBeat.m2504i(97802);
        if (str == null || bArr == null) {
            AppMethodBeat.m2505o(97802);
            return null;
        }
        for (int length = str.length(); length < 16; length++) {
            str = str + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        }
        String substring = str.substring(0, 16);
        SecretKeySpec secretKeySpec = new SecretKeySpec(substring.getBytes(), "AES");
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
        instance.init(1, secretKeySpec, new IvParameterSpec(substring.getBytes()));
        byte[] doFinal = instance.doFinal(bArr);
        AppMethodBeat.m2505o(97802);
        return doFinal;
    }

    /* renamed from: c */
    public static String m37602c(Context context) {
        AppMethodBeat.m2504i(97781);
        String str = "";
        if (context == null) {
            C16205ag.m24687d("getImsi but context == null!", new Object[0]);
            AppMethodBeat.m2505o(97781);
            return str;
        }
        String toLowerCase;
        try {
            if (C41003a.m71128f(context)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                toLowerCase = str == null ? "" : str.toLowerCase();
            } else {
                toLowerCase = str;
            }
        } catch (Throwable th) {
            toLowerCase = str;
            C16205ag.m24687d("getImsi error!", new Object[0]);
        }
        AppMethodBeat.m2505o(97781);
        return toLowerCase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064 A:{SYNTHETIC, Splitter:B:37:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    private static Object m37592b(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream readObject2 = null;
        AppMethodBeat.m2504i(97809);
        C16205ag.m24685b("de byte 2 obj ", new Object[0]);
        if (bArr == null || bArr.length < 0) {
            AppMethodBeat.m2505o(97809);
        } else {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            ObjectInputStream objectInputStream;
            try {
                objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    readObject2 = objectInputStream.readObject();
                    try {
                        objectInputStream.close();
                    } catch (IOException e) {
                        C16205ag.m24684a(e);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e2) {
                        C16205ag.m24684a(e2);
                    }
                    AppMethodBeat.m2505o(97809);
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Throwable th3) {
                th = th3;
                objectInputStream = readObject2;
                if (objectInputStream != null) {
                    try {
                        objectInputStream.close();
                    } catch (IOException e3) {
                        C16205ag.m24684a(e3);
                    }
                }
                byteArrayInputStream.close();
                AppMethodBeat.m2505o(97809);
                throw th;
            }
        }
        return readObject2;
    }

    /* renamed from: a */
    public static byte[] m37584a(String str) {
        AppMethodBeat.m2504i(97803);
        if (str == null) {
            AppMethodBeat.m2505o(97803);
            return null;
        }
        byte[] doFinal;
        try {
            RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA", "BC").generatePublic(new X509EncodedKeySpec(Base64.decode("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCsAxNCSLyNUCOP1QqYStE8ZeiU\nv4afaMqEmoLCKb0mUZYvYOoVN7LPMi2IVY2MRaFJvuND3glVw1RDm2VJJtjQkwUd\n3kpR9TrHAf7UQOVTpNo3Vi7pXTOqZ6bh3ZA/fs56jDCCKV6+wT/pCeu8N6vVnPrD\nz3SdHIeNeWb/woazCwIDAQAB", 0)));
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(1, rSAPublicKey);
            doFinal = instance.doFinal(str.getBytes());
        } catch (Exception e) {
            doFinal = null;
        }
        AppMethodBeat.m2505o(97803);
        return doFinal;
    }

    /* renamed from: d */
    public static String m37605d(Context context) {
        AppMethodBeat.m2504i(97782);
        String str = "";
        if (context == null) {
            C16205ag.m24687d("getAndroidId but context == null!", new Object[0]);
            AppMethodBeat.m2505o(97782);
        } else {
            try {
                str = Secure.getString(context.getContentResolver(), "android_id");
                if (str == null) {
                    str = "";
                } else {
                    str = str.toLowerCase();
                }
            } catch (Throwable th) {
                C16205ag.m24687d("getAndroidId error!", new Object[0]);
                C16205ag.m24684a(th);
            }
            AppMethodBeat.m2505o(97782);
        }
        return str;
    }

    /* renamed from: e */
    public static String m37608e(Context context) {
        Throwable th;
        int i = 0;
        AppMethodBeat.m2504i(97783);
        String str = "";
        if (context == null) {
            C16205ag.m24687d("getMacAddress but context == null!", new Object[0]);
            AppMethodBeat.m2505o(97783);
            return str;
        }
        String macAddress;
        try {
            if (Integer.valueOf(VERSION.SDK).intValue() < 23) {
                macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
                if (macAddress == null) {
                    try {
                        macAddress = "";
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    AppMethodBeat.m2505o(97783);
                    return macAddress;
                }
                macAddress = macAddress.toLowerCase();
                AppMethodBeat.m2505o(97783);
                return macAddress;
            }
            String[] strArr = new String[]{"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
            macAddress = str;
            while (i < 2) {
                macAddress = C24349e.m37609e(strArr[i]).toString().trim();
                if (macAddress != null && macAddress.length() > 0) {
                    macAddress = macAddress.toLowerCase();
                    break;
                }
                i++;
            }
            AppMethodBeat.m2505o(97783);
            return macAddress;
        } catch (Throwable th3) {
            th = th3;
            macAddress = str;
            C16205ag.m24684a(th);
            AppMethodBeat.m2505o(97783);
            return macAddress;
        }
    }

    /* renamed from: a */
    private static byte[] m37589a(byte[] bArr, int i, String str) {
        AppMethodBeat.m2504i(97810);
        if (bArr == null || i == -1) {
            AppMethodBeat.m2505o(97810);
            return bArr;
        }
        C16205ag.m24685b("enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
        if (i == 1) {
            if (str == null || bArr == null) {
                try {
                    AppMethodBeat.m2505o(97810);
                    return null;
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                    C16205ag.m24687d("err enD: %s", th.toString());
                    AppMethodBeat.m2505o(97810);
                    return null;
                }
            }
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
            bArr = instance.doFinal(bArr);
            AppMethodBeat.m2505o(97810);
            return bArr;
        } else if (i == 3) {
            bArr = C24349e.m37597b(str, bArr);
            AppMethodBeat.m2505o(97810);
            return bArr;
        } else {
            AppMethodBeat.m2505o(97810);
            return null;
        }
    }

    /* renamed from: c */
    public static boolean m37603c(String str) {
        AppMethodBeat.m2504i(97806);
        boolean z = true;
        int length = str.length();
        while (true) {
            length--;
            if (length >= 0) {
                char charAt = str.charAt(length);
                if (charAt < ' ' || charAt >= 127) {
                    z = false;
                }
            } else {
                AppMethodBeat.m2505o(97806);
                return z;
            }
        }
    }

    /* renamed from: i */
    public static synchronized int m37617i(Context context) {
        Throwable th;
        int i = 0;
        synchronized (C24349e.class) {
            AppMethodBeat.m2504i(97793);
            if (context == null) {
                C16205ag.m24686c("context == null ||key < -1}", new Object[0]);
                AppMethodBeat.m2505o(97793);
            } else {
                int delete;
                try {
                    SQLiteDatabase writableDatabase = C31082r.m50139a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        C16205ag.m24687d("get db fail!,return ", new Object[0]);
                        AppMethodBeat.m2505o(97793);
                    } else {
                        delete = writableDatabase.delete("t_strategy", String.format("%s = %d", new Object[]{"_key", Integer.valueOf(101)}), null);
                        try {
                            C16205ag.m24690g("delete Strategy key} %d , num} %d", Integer.valueOf(101), Integer.valueOf(delete));
                            i = delete;
                        } catch (Throwable th2) {
                            th = th2;
                            C16205ag.m24684a(th);
                            i = delete;
                            AppMethodBeat.m2505o(97793);
                            return i;
                        }
                        AppMethodBeat.m2505o(97793);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    delete = 0;
                }
            }
        }
        return i;
    }

    /* renamed from: b */
    private static byte[] m37600b(byte[] bArr, int i, String str) {
        AppMethodBeat.m2504i(97811);
        if (bArr == null || i == -1) {
            AppMethodBeat.m2505o(97811);
            return bArr;
        } else if (i == 1) {
            if (str == null || bArr == null) {
                try {
                    AppMethodBeat.m2505o(97811);
                    return null;
                } catch (Throwable th) {
                    C16205ag.m24684a(th);
                    C16205ag.m24687d("err unD: %s", th.toString());
                    AppMethodBeat.m2505o(97811);
                    return null;
                }
            }
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
            bArr = instance.doFinal(bArr);
            AppMethodBeat.m2505o(97811);
            return bArr;
        } else if (i == 3) {
            bArr = C24349e.m37585a(str, bArr);
            AppMethodBeat.m2505o(97811);
            return bArr;
        } else {
            AppMethodBeat.m2505o(97811);
            return null;
        }
    }

    /* renamed from: a */
    private static byte[] m37587a(byte[] bArr, int i) {
        AppMethodBeat.m2504i(97812);
        if (bArr == null || i == -1) {
            AppMethodBeat.m2505o(97812);
            return bArr;
        }
        C16205ag.m24685b("zp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
        ByteArrayOutputStream byteArrayOutputStream;
        if (i == 1) {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ZipOutputStream zipOutputStream = new ZipOutputStream(byteArrayOutputStream);
                ZipEntry zipEntry = new ZipEntry("zip");
                zipEntry.setSize((long) bArr.length);
                zipOutputStream.putNextEntry(zipEntry);
                zipOutputStream.write(bArr);
                zipOutputStream.closeEntry();
                zipOutputStream.close();
                bArr = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                AppMethodBeat.m2505o(97812);
                return bArr;
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                C16205ag.m24687d("err zp : %s", th.toString());
                AppMethodBeat.m2505o(97812);
                return null;
            }
        } else if (i == 2) {
            byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.finish();
            gZIPOutputStream.close();
            bArr = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            AppMethodBeat.m2505o(97812);
            return bArr;
        } else {
            AppMethodBeat.m2505o(97812);
            return null;
        }
    }

    /* renamed from: b */
    private static byte[] m37598b(byte[] bArr, int i) {
        AppMethodBeat.m2504i(97813);
        if (bArr == null || i == -1) {
            AppMethodBeat.m2505o(97813);
            return bArr;
        }
        C16205ag.m24685b("unzp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
        if (i == 1) {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                ZipInputStream zipInputStream = new ZipInputStream(byteArrayInputStream);
                bArr = null;
                while (zipInputStream.getNextEntry() != null) {
                    byte[] bArr2 = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    while (true) {
                        int read = zipInputStream.read(bArr2, 0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        if (read == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(bArr2, 0, read);
                    }
                    bArr = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                }
                zipInputStream.close();
                byteArrayInputStream.close();
                AppMethodBeat.m2505o(97813);
                return bArr;
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                C16205ag.m24687d("err unzp}" + th.toString(), new Object[0]);
                AppMethodBeat.m2505o(97813);
                return null;
            }
        } else if (i == 2) {
            bArr = C24349e.m37586a(bArr);
            AppMethodBeat.m2505o(97813);
            return bArr;
        } else {
            AppMethodBeat.m2505o(97813);
            return null;
        }
    }

    /* renamed from: a */
    public static int m37572a(Context context, Long[] lArr) {
        AppMethodBeat.m2504i(97799);
        C16205ag.m24683a(" RecordDAO.deleteRecordList() start", new Object[0]);
        if (context == null) {
            C16205ag.m24687d(" deleteRecordList() have null args!", new Object[0]);
            AppMethodBeat.m2505o(97799);
            return -1;
        }
        C16205ag.m24683a(" RecordDAO.deleteRecordList() end", new Object[0]);
        int a = C44539p.m80850a(context, lArr);
        AppMethodBeat.m2505o(97799);
        return a;
    }

    /* renamed from: a */
    public static C36481aa m37574a(int i, C41014c c41014c, byte[] bArr, int i2, int i3) {
        AppMethodBeat.m2504i(97814);
        C16205ag.m24685b("en2Req", new Object[0]);
        if (c41014c == null) {
            C16205ag.m24687d("error no com info! ", new Object[0]);
            AppMethodBeat.m2505o(97814);
            return null;
        }
        try {
            C36481aa c36481aa = new C36481aa();
            synchronized (c41014c) {
                c36481aa.f15253j = c41014c.mo65047a();
                c36481aa.f15254k = c41014c.mo65050b();
                c36481aa.f15244a = c41014c.mo65052c();
                c36481aa.f15245b = c41014c.mo65060j();
                c36481aa.f15246c = c41014c.mo65054d();
                c36481aa.f15247d = c41014c.mo65055e();
                c36481aa.f15248e = c41014c.mo65056f();
                c36481aa.f15255l = "";
                if (i == 100) {
                    Map hashMap = new HashMap();
                    hashMap.put("A1", C31019an.m49815a());
                    hashMap.put("A2", c41014c.mo65059i());
                    C46768aq a = C46768aq.m88698a(c41014c.mo65062l());
                    hashMap.put("A4", a.mo75338c());
                    hashMap.put("A6", a.mo75337b());
                    hashMap.put("A7", a.mo75339d());
                    hashMap.put("A3", a.mo75340e());
                    hashMap.put("A23", c41014c.mo65061k());
                    hashMap.put("A31", a.mo75341f());
                    C24349e.m37573a(c41014c.mo65062l());
                    hashMap.put("A33", C24349e.m37614g(c41014c.mo65062l()));
                    if (C41003a.m71129g(c41014c.mo65062l())) {
                        hashMap.put("A66", "F");
                    } else {
                        hashMap.put("A66", "B");
                    }
                    hashMap.put("A67", C41003a.m71131i(c41014c.mo65062l()));
                    hashMap.put("A68", C41003a.m71130h(c41014c.mo65062l()));
                    hashMap.put("A85", C41003a.f16326b ? "Y" : "N");
                    c36481aa.f15255l = C24349e.m37578a(hashMap);
                }
            }
            if (i == 4 || i == 2 || i == 1) {
                c36481aa.f15255l = C24349e.m37578a(C31019an.m49825c());
            }
            c36481aa.f15249f = i;
            c36481aa.f15251h = (byte) i3;
            c36481aa.f15252i = (byte) i2;
            if (bArr == null) {
                bArr = "".getBytes();
            }
            c36481aa.f15250g = bArr;
            AppMethodBeat.m2505o(97814);
            return c36481aa;
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            AppMethodBeat.m2505o(97814);
            return null;
        }
    }

    /* renamed from: d */
    public static String m37604d() {
        AppMethodBeat.m2504i(97784);
        String str = null;
        try {
            str = Build.BRAND;
        } catch (Throwable th) {
            C16205ag.m24687d("getBrand error!", new Object[0]);
            C16205ag.m24684a(th);
        }
        AppMethodBeat.m2505o(97784);
        return str;
    }

    /* renamed from: e */
    public static String m37607e() {
        AppMethodBeat.m2504i(97785);
        String str = null;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = (((((long) statFs.getBlockCount()) * blockSize) / 1024) / 1024);
        } catch (Throwable th) {
            C16205ag.m24687d("getDisplayMetrics error!", new Object[0]);
            C16205ag.m24684a(th);
        }
        AppMethodBeat.m2505o(97785);
        return str;
    }

    /* renamed from: f */
    public static String m37611f(Context context) {
        AppMethodBeat.m2504i(97786);
        String g;
        if (f4624a != null) {
            g = C24349e.m37614g(context);
            AppMethodBeat.m2505o(97786);
            return g;
        }
        g = "unknown";
        AppMethodBeat.m2505o(97786);
        return g;
    }

    /* renamed from: g */
    public static String m37614g(Context context) {
        AppMethodBeat.m2504i(97787);
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.m2505o(97787);
                return str;
            }
            String str2;
            if (activeNetworkInfo.getType() == 1) {
                str2 = "wifi";
            } else {
                if (activeNetworkInfo.getType() == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        switch (telephonyManager.getNetworkType()) {
                            case 1:
                                str2 = "GPRS";
                                break;
                            case 2:
                                str2 = "EDGE";
                                break;
                            case 3:
                                str2 = "UMTS";
                                break;
                            case 4:
                                str2 = "CDMA";
                                break;
                            case 5:
                                str2 = "EVDO_0";
                                break;
                            case 6:
                                str2 = "EVDO_A";
                                break;
                            case 7:
                                str2 = "1xRTT";
                                break;
                            case 8:
                                str2 = "HSDPA";
                                break;
                            case 9:
                                str2 = "HSUPA";
                                break;
                            case 10:
                                str2 = "HSPA";
                                break;
                            case 11:
                                str2 = "iDen";
                                break;
                            case 12:
                                str2 = "EVDO_B";
                                break;
                            case 13:
                                str2 = "LTE";
                                break;
                            case 14:
                                str2 = "eHRPD";
                                break;
                            case 15:
                                str2 = "HSPA+";
                                break;
                            default:
                                str2 = "unknown";
                                break;
                        }
                    }
                }
                str2 = str;
            }
            AppMethodBeat.m2505o(97787);
            return str2;
        } catch (Exception e) {
            C16205ag.m24684a(e);
        }
    }

    /* renamed from: a */
    public static byte[] m37588a(byte[] bArr, int i, int i2, String str) {
        byte[] bArr2 = null;
        AppMethodBeat.m2504i(97815);
        if (bArr == null) {
            AppMethodBeat.m2505o(97815);
        } else {
            try {
                bArr2 = C24349e.m37589a(C24349e.m37587a(bArr, i), i2, str);
                AppMethodBeat.m2505o(97815);
            } catch (Throwable th) {
                C16205ag.m24684a(th);
                AppMethodBeat.m2505o(97815);
            }
        }
        return bArr2;
    }

    /* renamed from: b */
    public static byte[] m37599b(byte[] bArr, int i, int i2, String str) {
        AppMethodBeat.m2504i(97816);
        try {
            byte[] b = C24349e.m37598b(C24349e.m37600b(bArr, i2, str), i);
            AppMethodBeat.m2505o(97816);
            return b;
        } catch (Exception e) {
            C16205ag.m24684a(e);
            AppMethodBeat.m2505o(97816);
            return null;
        }
    }

    /* renamed from: f */
    public static String m37610f() {
        AppMethodBeat.m2504i(97788);
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/type")));
            String readLine = bufferedReader.readLine();
            bufferedReader.close();
            stringBuilder.append(readLine).append(",");
            bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/name")));
            readLine = bufferedReader.readLine();
            bufferedReader.close();
            stringBuilder.append(readLine).append(",");
            bufferedReader = new BufferedReader(new FileReader(new File("/sys/block/mmcblk0/device/cid")));
            readLine = bufferedReader.readLine();
            bufferedReader.close();
            stringBuilder.append(readLine);
        } catch (Exception e) {
            C16205ag.m24684a(e);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(97788);
        return stringBuilder2;
    }

    /* renamed from: g */
    public static String m37613g() {
        AppMethodBeat.m2504i(97817);
        String format;
        try {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
            AppMethodBeat.m2505o(97817);
            return format;
        } catch (Throwable th) {
            C16205ag.m24684a(th);
            format = "";
            AppMethodBeat.m2505o(97817);
            return format;
        }
    }

    /* renamed from: e */
    public static String m37609e(String str) {
        AppMethodBeat.m2504i(97818);
        String str2 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            fileInputStream.close();
        } catch (Exception e) {
            C16205ag.m24687d("Read file %s failed.", str);
        }
        AppMethodBeat.m2505o(97818);
        return str2;
    }

    /* renamed from: f */
    private static String m37612f(String str) {
        AppMethodBeat.m2504i(97819);
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append(0);
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            str = stringBuffer.toString();
        } catch (Exception e) {
            C16205ag.m24684a(e);
        }
        AppMethodBeat.m2505o(97819);
        return str;
    }

    /* renamed from: g */
    private static String m37615g(String str) {
        AppMethodBeat.m2504i(97820);
        String f = C24349e.m37612f(str);
        if (f != null) {
            try {
                f = f.substring(8, 24);
            } catch (Exception e) {
            }
        }
        AppMethodBeat.m2505o(97820);
        return f;
    }

    /* renamed from: b */
    public static String m37595b(Context context, int i) {
        AppMethodBeat.m2504i(97821);
        try {
            C46768aq a = C46768aq.m88698a(context);
            String a2 = a.mo75336a();
            String g = C24349e.m37615g(a2 + "_" + a.mo75337b() + "_" + new Date().getTime() + "_" + i);
            AppMethodBeat.m2505o(97821);
            return g;
        } catch (Exception e) {
            AppMethodBeat.m2505o(97821);
            return null;
        }
    }

    /* renamed from: k */
    public static String m37619k(Context context) {
        AppMethodBeat.m2504i(97822);
        try {
            String d = C46768aq.m88698a(context).mo75339d();
            String str = "";
            C41014c m = C41014c.m71224m();
            if (m != null) {
                str = m.mo65060j();
            }
            str = C24349e.m37615g(str + "_" + d + "_" + new Date().getTime() + "_" + ((int) (Math.random() * 2.147483647E9d)));
            AppMethodBeat.m2505o(97822);
            return str;
        } catch (Exception e) {
            AppMethodBeat.m2505o(97822);
            return null;
        }
    }

    /* renamed from: a */
    public static HashSet<String> m37579a(ArrayList<String> arrayList) {
        AppMethodBeat.m2504i(97823);
        int size = arrayList.size();
        if (arrayList == null || size <= 0) {
            AppMethodBeat.m2505o(97823);
            return null;
        }
        HashSet<String> hashSet = new HashSet(size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        AppMethodBeat.m2505o(97823);
        return hashSet;
    }
}
