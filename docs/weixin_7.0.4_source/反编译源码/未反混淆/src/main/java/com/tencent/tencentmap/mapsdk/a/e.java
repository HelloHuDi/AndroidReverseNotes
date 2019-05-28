package com.tencent.tencentmap.mapsdk.a;

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
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.tencentmap.mapsdk.maps.a.aa;
import com.tencent.tencentmap.mapsdk.maps.a.ac;
import com.tencent.tencentmap.mapsdk.maps.a.ag;
import com.tencent.tencentmap.mapsdk.maps.a.an;
import com.tencent.tencentmap.mapsdk.maps.a.aq;
import com.tencent.tencentmap.mapsdk.maps.a.av;
import com.tencent.tencentmap.mapsdk.maps.a.ax;
import com.tencent.tencentmap.mapsdk.maps.a.p;
import com.tencent.tencentmap.mapsdk.maps.a.r;
import com.tencent.tencentmap.mapsdk.maps.a.y;
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

public final class e {
    private static e a;

    private static NetworkInfo o(Context context) {
        AppMethodBeat.i(97824);
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                AppMethodBeat.o(97824);
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            AppMethodBeat.o(97824);
            return activeNetworkInfo;
        } catch (Throwable th) {
            ag.a(th);
            AppMethodBeat.o(97824);
            return null;
        }
    }

    public static int j(Context context) {
        AppMethodBeat.i(97796);
        ag.a(" RecordDAO.countRecordNum() start", new Object[0]);
        if (context == null) {
            ag.d(" countRecordNum() have null args!", new Object[0]);
            AppMethodBeat.o(97796);
            return -1;
        }
        int b = p.b(context, new int[]{1});
        AppMethodBeat.o(97796);
        return b;
    }

    public static ac a(av avVar) {
        AppMethodBeat.i(97794);
        if (avVar == null || !"UA".equals(avVar.b())) {
            AppMethodBeat.o(97794);
            return null;
        }
        Map e = avVar.e();
        if (e == null) {
            AppMethodBeat.o(97794);
            return null;
        }
        try {
            ac acVar = new ac();
            acVar.a = (String) e.get("A19");
            acVar.c = avVar.d();
            acVar.h = avVar.c();
            acVar.b = (String) e.get("A28");
            acVar.f = Long.parseLong((String) e.get("A26"));
            acVar.d = Boolean.parseBoolean((String) e.get("A25"));
            acVar.e = Long.parseLong((String) e.get("A27"));
            e.remove("A19");
            e.remove("A28");
            e.remove("A26");
            e.remove("A25");
            e.remove("A27");
            acVar.g = a(e);
            AppMethodBeat.o(97794);
            return acVar;
        } catch (Throwable th) {
            ag.a(th);
            ag.d(th.getMessage(), new Object[0]);
            AppMethodBeat.o(97794);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:50:0x00d0 A:{SYNTHETIC, Splitter:B:50:0x00d0} */
    /* JADX WARNING: Missing block: B:31:0x00a2, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(97789);
     */
    /* JADX WARNING: Missing block: B:63:?, code skipped:
            return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static Object[] a(Context context, String str) {
        Cursor cursor;
        Throwable th;
        Cursor cursor2 = null;
        AppMethodBeat.i(97789);
        synchronized (r.a) {
            if (context == null) {
                try {
                    ag.c("context == null ", new Object[0]);
                } finally {
                    AppMethodBeat.o(97789);
                }
            } else if (str == null) {
                ag.c("key == null ", new Object[0]);
                AppMethodBeat.o(97789);
                return null;
            } else {
                try {
                    SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ag.c("getWritableDatabase fail! ", new Object[0]);
                        AppMethodBeat.o(97789);
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
                            AppMethodBeat.o(97789);
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            cursor2 = query;
                            if (cursor2 != null) {
                            }
                            AppMethodBeat.o(97789);
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
                    AppMethodBeat.o(97789);
                    throw th;
                }
            }
            return cursor2;
        }
    }

    public static synchronized boolean a(Context context, y yVar) {
        boolean z = true;
        boolean z2 = false;
        synchronized (e.class) {
            AppMethodBeat.i(97791);
            if (context == null || yVar == null) {
                ag.c("context == null || bean == null}", new Object[0]);
                AppMethodBeat.o(97791);
            } else {
                try {
                    SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ag.d("get db fail!,return false ", new Object[0]);
                        AppMethodBeat.o(97791);
                    } else {
                        ContentValues contentValues;
                        if (yVar == null) {
                            contentValues = null;
                        } else {
                            contentValues = new ContentValues();
                            if (yVar.a() >= 0) {
                                contentValues.put("_id", Long.valueOf(yVar.a()));
                            }
                            contentValues.put("_key", Integer.valueOf(yVar.b()));
                            contentValues.put("_datas", yVar.c());
                        }
                        if (contentValues != null) {
                            long replace = writableDatabase.replace("t_strategy", "_id", contentValues);
                            if (replace < 0) {
                                ag.c("insert failure! return false ", new Object[0]);
                                AppMethodBeat.o(97791);
                            } else {
                                yVar.a(replace);
                                ag.e("update strategy  %d true ", Integer.valueOf(yVar.b()));
                            }
                        } else {
                            z = false;
                        }
                        z2 = z;
                        AppMethodBeat.o(97791);
                    }
                } catch (Throwable th) {
                    ag.d("Error strategy update!  %s", th.toString());
                }
            }
        }
        return z2;
    }

    public static synchronized e a(Context context) {
        e eVar;
        synchronized (e.class) {
            AppMethodBeat.i(97776);
            if (a == null && context != null) {
                a = new e();
            }
            eVar = a;
            AppMethodBeat.o(97776);
        }
        return eVar;
    }

    public static boolean l(Context context) {
        AppMethodBeat.i(97825);
        NetworkInfo o = o(context);
        if (o == null || o.getType() != 1) {
            AppMethodBeat.o(97825);
            return false;
        }
        AppMethodBeat.o(97825);
        return true;
    }

    public static Long[] a(Context context, List<av> list) {
        int i = 0;
        AppMethodBeat.i(97797);
        ag.a(" RecordDAO.insertList() start", new Object[0]);
        if (context == null || list == null) {
            ag.d(" insertList() have null args!", new Object[0]);
            AppMethodBeat.o(97797);
            return null;
        }
        int size = list.size();
        if (size == 0) {
            ag.b(" list siez == 0 , return true!", new Object[0]);
            AppMethodBeat.o(97797);
            return null;
        }
        Long[] lArr = new Long[size];
        List<p> arrayList = new ArrayList();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = (av) list.get(i2);
            if (obj == null || obj.b() == null || !obj.b().equals("UA")) {
                ag.d(" bean's type is error!", new Object[0]);
            } else {
                try {
                    arrayList.add(new p(obj.c(), a(obj)));
                } catch (Throwable th) {
                    ag.a(th);
                }
            }
        }
        if (p.a(context, (List) arrayList)) {
            for (p pVar : arrayList) {
                if (i < size) {
                    lArr[i] = Long.valueOf(pVar.a);
                }
                i++;
            }
            AppMethodBeat.o(97797);
            return lArr;
        }
        AppMethodBeat.o(97797);
        return null;
    }

    private e() {
    }

    public static boolean m(Context context) {
        AppMethodBeat.i(97826);
        NetworkInfo o = o(context);
        if (o == null || !o.isConnected()) {
            AppMethodBeat.o(97826);
            return false;
        }
        AppMethodBeat.o(97826);
        return true;
    }

    public static String a() {
        AppMethodBeat.i(97777);
        String str;
        try {
            str = Build.MODEL;
            AppMethodBeat.o(97777);
            return str;
        } catch (Throwable th) {
            ag.d("getDeviceName error", new Object[0]);
            ag.a(th);
            str = "";
            AppMethodBeat.o(97777);
            return str;
        }
    }

    public static Date d(String str) {
        Date date = null;
        AppMethodBeat.i(97807);
        if (str == null || str.trim().length() <= 0) {
            AppMethodBeat.o(97807);
        } else {
            try {
                date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(str);
                AppMethodBeat.o(97807);
            } catch (ParseException e) {
                ag.a(e);
                AppMethodBeat.o(97807);
            }
        }
        return date;
    }

    public static String n(Context context) {
        AppMethodBeat.i(97827);
        NetworkInfo o = o(context);
        String str;
        if (o == null) {
            str = "unknown";
            AppMethodBeat.o(97827);
            return str;
        } else if (o.getType() == 1) {
            str = "wifi";
            AppMethodBeat.o(97827);
            return str;
        } else {
            str = o.getExtraInfo();
            if (str != null && str.length() > 64) {
                str = str.substring(0, 64);
            }
            AppMethodBeat.o(97827);
            return str;
        }
    }

    public static String b() {
        AppMethodBeat.i(97778);
        String str;
        try {
            str = VERSION.RELEASE;
            AppMethodBeat.o(97778);
            return str;
        } catch (Throwable th) {
            ag.d("getVersion error", new Object[0]);
            ag.a(th);
            str = "";
            AppMethodBeat.o(97778);
            return str;
        }
    }

    public static String b(String str) {
        AppMethodBeat.i(97804);
        String str2 = "unknown";
        if (str == null || str.trim().length() == 0) {
            AppMethodBeat.o(97804);
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
                AppMethodBeat.o(97804);
            } else {
                ag.c("channelID is invalid!! channelID should be Numeric! channelID:".concat(String.valueOf(str)), new Object[0]);
                AppMethodBeat.o(97804);
            }
        }
        return str2;
    }

    public static av a(Context context, String str, boolean z, long j, long j2, Map<String, String> map, boolean z2) {
        AppMethodBeat.i(97795);
        if (str == null) {
            AppMethodBeat.o(97795);
            return null;
        }
        c m = c.m();
        if (m == null) {
            ag.d("  CommonInfo or DeviceInfo have not been Created return null!", new Object[0]);
            AppMethodBeat.o(97795);
            return null;
        }
        an.a();
        long time = new Date().getTime() + m.h();
        String g = m.g();
        Object n = n(context);
        if (n == null) {
            n = BuildConfig.COMMAND;
        }
        Map hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        Object obj = null;
        if (ax.d().g().h() && !str.startsWith("rqd_")) {
            obj = 1;
        }
        aq a = aq.a(context);
        if (obj == null) {
            String b = an.b();
            if (!(b == null || b.equals(""))) {
                hashMap.put("QQ", b);
            }
            hashMap.put("A2", m.i());
            hashMap.put("A4", a.c());
            hashMap.put("A6", a.b());
            hashMap.put("A7", a.d());
            hashMap.put("A23", m.k());
            hashMap.put("A31", a.f());
            hashMap.put("A67", a.i(context));
            hashMap.put("A76", a.a());
            hashMap.put("A95", a.e(context));
        }
        hashMap.put("A19", n);
        hashMap.put("A28", g);
        hashMap.put("A25", String.valueOf(z));
        hashMap.put("A26", String.valueOf(j));
        hashMap.put("A27", String.valueOf(j2));
        av avVar = new av();
        avVar.b(str);
        avVar.b(time);
        avVar.a("UA");
        avVar.a(hashMap);
        avVar.a(z2);
        AppMethodBeat.o(97795);
        return avVar;
    }

    /* JADX WARNING: Missing block: B:9:0x0015, code skipped:
            com.tencent.matrix.trace.core.AppMethodBeat.o(97790);
     */
    /* JADX WARNING: Missing block: B:22:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(Context context, String str, Object[] objArr) {
        boolean z;
        AppMethodBeat.i(97790);
        synchronized (r.a) {
            if (!(context == null || str == null || objArr == null)) {
                try {
                    if (objArr.length != 0) {
                        try {
                            SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                            writableDatabase.delete("t_conf", "_key = '" + str + "'", null);
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("_key", str);
                            contentValues.put("_value", (String) objArr[0]);
                            contentValues.put("_vdate", (Long) objArr[1]);
                            contentValues.put("_time", Long.valueOf(new Date().getTime()));
                            if (writableDatabase.insert("t_conf", null, contentValues) < 0) {
                                ag.d(" insertOrUpdateByKey failure! return false!", new Object[0]);
                                z = false;
                            } else {
                                z = true;
                            }
                        } catch (Exception e) {
                            z = false;
                        }
                    }
                } finally {
                    AppMethodBeat.o(97790);
                }
            }
        }
        return z;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0077 A:{SYNTHETIC, Splitter:B:37:0x0077} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] a(Object obj) {
        Throwable th;
        byte[] bArr = null;
        AppMethodBeat.i(97808);
        ag.b("en obj 2 bytes ", new Object[0]);
        if (obj == null || !Serializable.class.isInstance(obj)) {
            ag.c("not serial obj ", new Object[0]);
            AppMethodBeat.o(97808);
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
                        ag.a(e);
                    }
                    try {
                        byteArrayOutputStream.close();
                    } catch (IOException e2) {
                        ag.a(e2);
                    }
                    AppMethodBeat.o(97808);
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
                        ag.a(e3);
                    }
                }
                byteArrayOutputStream.close();
                AppMethodBeat.o(97808);
                throw th;
            }
        }
        return bArr;
    }

    public static String c() {
        AppMethodBeat.i(97779);
        String str;
        try {
            str = VERSION.SDK;
            AppMethodBeat.o(97779);
            return str;
        } catch (Throwable th) {
            ag.d("getApiLevel error", new Object[0]);
            ag.a(th);
            str = "";
            AppMethodBeat.o(97779);
            return str;
        }
    }

    private static byte[] a(String str, byte[] bArr) {
        AppMethodBeat.i(97801);
        if (str == null || bArr == null) {
            AppMethodBeat.o(97801);
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
        AppMethodBeat.o(97801);
        return doFinal;
    }

    private static byte[] a(byte[] bArr) {
        AppMethodBeat.i(97800);
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
                AppMethodBeat.o(97800);
                return bArr2;
            }
        }
    }

    public static String b(Context context) {
        AppMethodBeat.i(97780);
        String str = "";
        if (context == null) {
            ag.d("getImei but context == null!", new Object[0]);
            AppMethodBeat.o(97780);
            return str;
        }
        String deviceId;
        try {
            if (a.f(context)) {
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
            ag.a("IMEI:".concat(String.valueOf(deviceId)), new Object[0]);
        } catch (Throwable th2) {
            deviceId = str;
            ag.d("getImei error!", new Object[0]);
            AppMethodBeat.o(97780);
            return deviceId;
        }
        AppMethodBeat.o(97780);
        return deviceId;
    }

    private static String a(Map<String, String> map) {
        AppMethodBeat.i(97805);
        ag.b("map 2 str", new Object[0]);
        String str;
        if (map == null) {
            str = "";
            AppMethodBeat.o(97805);
            return str;
        }
        Set<String> keySet = map.keySet();
        if (keySet == null) {
            str = "";
            AppMethodBeat.o(97805);
            return str;
        }
        if (keySet.size() > 50) {
            ag.c("The Map<String, String> params size is more than 50, effective size is <= 50!", new Object[0]);
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (String str2 : keySet) {
            int length = str2.trim().length();
            if (length <= 0 || !c(str2)) {
                ag.c("The Map<String, String> params key is invalid!! key should be ASCII code in 32-126! key:".concat(String.valueOf(str2)), new Object[0]);
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
        AppMethodBeat.o(97805);
        return str2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x008f A:{SYNTHETIC, Splitter:B:34:0x008f} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00e6 A:{SYNTHETIC, Splitter:B:50:0x00e6} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized y h(Context context) {
        y yVar;
        Throwable th;
        y yVar2;
        y yVar3 = null;
        synchronized (e.class) {
            AppMethodBeat.i(97792);
            if (context == null) {
                ag.c("context == null}", new Object[0]);
                AppMethodBeat.o(97792);
                yVar = null;
            } else {
                Cursor query;
                try {
                    SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ag.c("getWritableDatabase fail! ", new Object[0]);
                        AppMethodBeat.o(97792);
                        yVar = null;
                    } else {
                        query = writableDatabase.query("t_strategy", null, String.format(Locale.US, " %s = %d ", new Object[]{"_key", Integer.valueOf(101)}), null, null, null, null);
                        if (query != null) {
                            try {
                                if (query.moveToNext()) {
                                    if (!(query == null || query.isBeforeFirst() || query.isAfterLast())) {
                                        ag.b("parse bean}", new Object[0]);
                                        yVar = new y();
                                        yVar.a(query.getLong(query.getColumnIndex("_id")));
                                        yVar.a(query.getInt(query.getColumnIndex("_key")));
                                        yVar.a(query.getBlob(query.getColumnIndex("_datas")));
                                        yVar3 = yVar;
                                    }
                                    if (yVar3 != null) {
                                        try {
                                            ag.g("read strategy key: %d", Integer.valueOf(yVar3.b()));
                                        } catch (Throwable th2) {
                                            th = th2;
                                            yVar2 = yVar3;
                                            try {
                                                ag.a(th);
                                                if (query != null) {
                                                }
                                                yVar = yVar2;
                                                AppMethodBeat.o(97792);
                                                return yVar;
                                            } catch (Throwable th3) {
                                                th = th3;
                                                if (!(query == null || query.isClosed())) {
                                                    query.close();
                                                }
                                                AppMethodBeat.o(97792);
                                                throw th;
                                            }
                                        }
                                    }
                                    yVar2 = yVar3;
                                    if (query != null) {
                                        if (!query.isClosed()) {
                                            query.close();
                                            yVar = yVar2;
                                            AppMethodBeat.o(97792);
                                        }
                                    }
                                    yVar = yVar2;
                                    AppMethodBeat.o(97792);
                                }
                            } catch (Throwable th4) {
                                th = th4;
                                yVar2 = null;
                                ag.a(th);
                                if (query != null) {
                                    if (!query.isClosed()) {
                                        query.close();
                                        yVar = yVar2;
                                        AppMethodBeat.o(97792);
                                        return yVar;
                                    }
                                }
                                yVar = yVar2;
                                AppMethodBeat.o(97792);
                                return yVar;
                            }
                        }
                        yVar2 = null;
                        if (query != null) {
                        }
                        yVar = yVar2;
                        AppMethodBeat.o(97792);
                    }
                } catch (Throwable th5) {
                    th = th5;
                    query = null;
                    query.close();
                    AppMethodBeat.o(97792);
                    throw th;
                }
            }
        }
        return yVar;
    }

    public static List<av> a(Context context, int i) {
        AppMethodBeat.i(97798);
        ag.a(" RecordDAO.queryRecentRecord() start", new Object[0]);
        if (context == null) {
            ag.d(" queryRecentRecord() have null args!", new Object[0]);
            AppMethodBeat.o(97798);
            return null;
        }
        List a = p.a(context, new int[]{1}, i);
        if (a == null || a.size() <= 0) {
            AppMethodBeat.o(97798);
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = a.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            try {
                Object b = b(pVar.b);
                if (b != null && av.class.isInstance(b)) {
                    av avVar = (av) av.class.cast(b);
                    avVar.a(pVar.a);
                    arrayList.add(avVar);
                    it.remove();
                }
            } catch (Throwable th) {
                ag.a(th);
                ag.d(" query have error!", new Object[0]);
            }
        }
        if (a.size() > 0) {
            ag.a(" there are error datas ,should be remove " + a.size(), new Object[0]);
            Long[] lArr = new Long[a.size()];
            for (int i2 = 0; i2 < a.size(); i2++) {
                lArr[i2] = Long.valueOf(((p) a.get(i2)).a);
            }
            p.a(context, lArr);
        }
        ag.a(" RecordDAO.queryRecentRecord() end", new Object[0]);
        AppMethodBeat.o(97798);
        return arrayList;
    }

    private static byte[] b(String str, byte[] bArr) {
        AppMethodBeat.i(97802);
        if (str == null || bArr == null) {
            AppMethodBeat.o(97802);
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
        AppMethodBeat.o(97802);
        return doFinal;
    }

    public static String c(Context context) {
        AppMethodBeat.i(97781);
        String str = "";
        if (context == null) {
            ag.d("getImsi but context == null!", new Object[0]);
            AppMethodBeat.o(97781);
            return str;
        }
        String toLowerCase;
        try {
            if (a.f(context)) {
                str = ((TelephonyManager) context.getSystemService("phone")).getSubscriberId();
                toLowerCase = str == null ? "" : str.toLowerCase();
            } else {
                toLowerCase = str;
            }
        } catch (Throwable th) {
            toLowerCase = str;
            ag.d("getImsi error!", new Object[0]);
        }
        AppMethodBeat.o(97781);
        return toLowerCase;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0064 A:{SYNTHETIC, Splitter:B:37:0x0064} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Object b(byte[] bArr) {
        Object readObject;
        Throwable th;
        ObjectInputStream readObject2 = null;
        AppMethodBeat.i(97809);
        ag.b("de byte 2 obj ", new Object[0]);
        if (bArr == null || bArr.length < 0) {
            AppMethodBeat.o(97809);
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
                        ag.a(e);
                    }
                    try {
                        byteArrayInputStream.close();
                    } catch (IOException e2) {
                        ag.a(e2);
                    }
                    AppMethodBeat.o(97809);
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
                        ag.a(e3);
                    }
                }
                byteArrayInputStream.close();
                AppMethodBeat.o(97809);
                throw th;
            }
        }
        return readObject2;
    }

    public static byte[] a(String str) {
        AppMethodBeat.i(97803);
        if (str == null) {
            AppMethodBeat.o(97803);
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
        AppMethodBeat.o(97803);
        return doFinal;
    }

    public static String d(Context context) {
        AppMethodBeat.i(97782);
        String str = "";
        if (context == null) {
            ag.d("getAndroidId but context == null!", new Object[0]);
            AppMethodBeat.o(97782);
        } else {
            try {
                str = Secure.getString(context.getContentResolver(), "android_id");
                if (str == null) {
                    str = "";
                } else {
                    str = str.toLowerCase();
                }
            } catch (Throwable th) {
                ag.d("getAndroidId error!", new Object[0]);
                ag.a(th);
            }
            AppMethodBeat.o(97782);
        }
        return str;
    }

    public static String e(Context context) {
        Throwable th;
        int i = 0;
        AppMethodBeat.i(97783);
        String str = "";
        if (context == null) {
            ag.d("getMacAddress but context == null!", new Object[0]);
            AppMethodBeat.o(97783);
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
                    AppMethodBeat.o(97783);
                    return macAddress;
                }
                macAddress = macAddress.toLowerCase();
                AppMethodBeat.o(97783);
                return macAddress;
            }
            String[] strArr = new String[]{"/sys/class/net/wlan0/address", "/sys/devices/virtual/net/wlan0/address"};
            macAddress = str;
            while (i < 2) {
                macAddress = e(strArr[i]).toString().trim();
                if (macAddress != null && macAddress.length() > 0) {
                    macAddress = macAddress.toLowerCase();
                    break;
                }
                i++;
            }
            AppMethodBeat.o(97783);
            return macAddress;
        } catch (Throwable th3) {
            th = th3;
            macAddress = str;
            ag.a(th);
            AppMethodBeat.o(97783);
            return macAddress;
        }
    }

    private static byte[] a(byte[] bArr, int i, String str) {
        AppMethodBeat.i(97810);
        if (bArr == null || i == -1) {
            AppMethodBeat.o(97810);
            return bArr;
        }
        ag.b("enD:} %d %d", Integer.valueOf(bArr.length), Integer.valueOf(i));
        if (i == 1) {
            if (str == null || bArr == null) {
                try {
                    AppMethodBeat.o(97810);
                    return null;
                } catch (Throwable th) {
                    ag.a(th);
                    ag.d("err enD: %s", th.toString());
                    AppMethodBeat.o(97810);
                    return null;
                }
            }
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(1, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
            bArr = instance.doFinal(bArr);
            AppMethodBeat.o(97810);
            return bArr;
        } else if (i == 3) {
            bArr = b(str, bArr);
            AppMethodBeat.o(97810);
            return bArr;
        } else {
            AppMethodBeat.o(97810);
            return null;
        }
    }

    public static boolean c(String str) {
        AppMethodBeat.i(97806);
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
                AppMethodBeat.o(97806);
                return z;
            }
        }
    }

    public static synchronized int i(Context context) {
        Throwable th;
        int i = 0;
        synchronized (e.class) {
            AppMethodBeat.i(97793);
            if (context == null) {
                ag.c("context == null ||key < -1}", new Object[0]);
                AppMethodBeat.o(97793);
            } else {
                int delete;
                try {
                    SQLiteDatabase writableDatabase = r.a(context).getWritableDatabase();
                    if (writableDatabase == null) {
                        ag.d("get db fail!,return ", new Object[0]);
                        AppMethodBeat.o(97793);
                    } else {
                        delete = writableDatabase.delete("t_strategy", String.format("%s = %d", new Object[]{"_key", Integer.valueOf(101)}), null);
                        try {
                            ag.g("delete Strategy key} %d , num} %d", Integer.valueOf(101), Integer.valueOf(delete));
                            i = delete;
                        } catch (Throwable th2) {
                            th = th2;
                            ag.a(th);
                            i = delete;
                            AppMethodBeat.o(97793);
                            return i;
                        }
                        AppMethodBeat.o(97793);
                    }
                } catch (Throwable th3) {
                    th = th3;
                    delete = 0;
                }
            }
        }
        return i;
    }

    private static byte[] b(byte[] bArr, int i, String str) {
        AppMethodBeat.i(97811);
        if (bArr == null || i == -1) {
            AppMethodBeat.o(97811);
            return bArr;
        } else if (i == 1) {
            if (str == null || bArr == null) {
                try {
                    AppMethodBeat.o(97811);
                    return null;
                } catch (Throwable th) {
                    ag.a(th);
                    ag.d("err unD: %s", th.toString());
                    AppMethodBeat.o(97811);
                    return null;
                }
            }
            Cipher instance = Cipher.getInstance("DES/CBC/PKCS5Padding");
            instance.init(2, SecretKeyFactory.getInstance("DES").generateSecret(new DESKeySpec(str.getBytes("UTF-8"))), new IvParameterSpec(str.getBytes("UTF-8")));
            bArr = instance.doFinal(bArr);
            AppMethodBeat.o(97811);
            return bArr;
        } else if (i == 3) {
            bArr = a(str, bArr);
            AppMethodBeat.o(97811);
            return bArr;
        } else {
            AppMethodBeat.o(97811);
            return null;
        }
    }

    private static byte[] a(byte[] bArr, int i) {
        AppMethodBeat.i(97812);
        if (bArr == null || i == -1) {
            AppMethodBeat.o(97812);
            return bArr;
        }
        ag.b("zp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
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
                AppMethodBeat.o(97812);
                return bArr;
            } catch (Throwable th) {
                ag.a(th);
                ag.d("err zp : %s", th.toString());
                AppMethodBeat.o(97812);
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
            AppMethodBeat.o(97812);
            return bArr;
        } else {
            AppMethodBeat.o(97812);
            return null;
        }
    }

    private static byte[] b(byte[] bArr, int i) {
        AppMethodBeat.i(97813);
        if (bArr == null || i == -1) {
            AppMethodBeat.o(97813);
            return bArr;
        }
        ag.b("unzp: %s len: %s", Integer.valueOf(i), Integer.valueOf(bArr.length));
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
                AppMethodBeat.o(97813);
                return bArr;
            } catch (Throwable th) {
                ag.a(th);
                ag.d("err unzp}" + th.toString(), new Object[0]);
                AppMethodBeat.o(97813);
                return null;
            }
        } else if (i == 2) {
            bArr = a(bArr);
            AppMethodBeat.o(97813);
            return bArr;
        } else {
            AppMethodBeat.o(97813);
            return null;
        }
    }

    public static int a(Context context, Long[] lArr) {
        AppMethodBeat.i(97799);
        ag.a(" RecordDAO.deleteRecordList() start", new Object[0]);
        if (context == null) {
            ag.d(" deleteRecordList() have null args!", new Object[0]);
            AppMethodBeat.o(97799);
            return -1;
        }
        ag.a(" RecordDAO.deleteRecordList() end", new Object[0]);
        int a = p.a(context, lArr);
        AppMethodBeat.o(97799);
        return a;
    }

    public static aa a(int i, c cVar, byte[] bArr, int i2, int i3) {
        AppMethodBeat.i(97814);
        ag.b("en2Req", new Object[0]);
        if (cVar == null) {
            ag.d("error no com info! ", new Object[0]);
            AppMethodBeat.o(97814);
            return null;
        }
        try {
            aa aaVar = new aa();
            synchronized (cVar) {
                aaVar.j = cVar.a();
                aaVar.k = cVar.b();
                aaVar.a = cVar.c();
                aaVar.b = cVar.j();
                aaVar.c = cVar.d();
                aaVar.d = cVar.e();
                aaVar.e = cVar.f();
                aaVar.l = "";
                if (i == 100) {
                    Map hashMap = new HashMap();
                    hashMap.put("A1", an.a());
                    hashMap.put("A2", cVar.i());
                    aq a = aq.a(cVar.l());
                    hashMap.put("A4", a.c());
                    hashMap.put("A6", a.b());
                    hashMap.put("A7", a.d());
                    hashMap.put("A3", a.e());
                    hashMap.put("A23", cVar.k());
                    hashMap.put("A31", a.f());
                    a(cVar.l());
                    hashMap.put("A33", g(cVar.l()));
                    if (a.g(cVar.l())) {
                        hashMap.put("A66", "F");
                    } else {
                        hashMap.put("A66", "B");
                    }
                    hashMap.put("A67", a.i(cVar.l()));
                    hashMap.put("A68", a.h(cVar.l()));
                    hashMap.put("A85", a.b ? "Y" : "N");
                    aaVar.l = a(hashMap);
                }
            }
            if (i == 4 || i == 2 || i == 1) {
                aaVar.l = a(an.c());
            }
            aaVar.f = i;
            aaVar.h = (byte) i3;
            aaVar.i = (byte) i2;
            if (bArr == null) {
                bArr = "".getBytes();
            }
            aaVar.g = bArr;
            AppMethodBeat.o(97814);
            return aaVar;
        } catch (Throwable th) {
            ag.a(th);
            AppMethodBeat.o(97814);
            return null;
        }
    }

    public static String d() {
        AppMethodBeat.i(97784);
        String str = null;
        try {
            str = Build.BRAND;
        } catch (Throwable th) {
            ag.d("getBrand error!", new Object[0]);
            ag.a(th);
        }
        AppMethodBeat.o(97784);
        return str;
    }

    public static String e() {
        AppMethodBeat.i(97785);
        String str = null;
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long blockSize = (long) statFs.getBlockSize();
            str = (((((long) statFs.getBlockCount()) * blockSize) / 1024) / 1024);
        } catch (Throwable th) {
            ag.d("getDisplayMetrics error!", new Object[0]);
            ag.a(th);
        }
        AppMethodBeat.o(97785);
        return str;
    }

    public static String f(Context context) {
        AppMethodBeat.i(97786);
        String g;
        if (a != null) {
            g = g(context);
            AppMethodBeat.o(97786);
            return g;
        }
        g = "unknown";
        AppMethodBeat.o(97786);
        return g;
    }

    public static String g(Context context) {
        AppMethodBeat.i(97787);
        String str = "unknown";
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                AppMethodBeat.o(97787);
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
            AppMethodBeat.o(97787);
            return str2;
        } catch (Exception e) {
            ag.a(e);
        }
    }

    public static byte[] a(byte[] bArr, int i, int i2, String str) {
        byte[] bArr2 = null;
        AppMethodBeat.i(97815);
        if (bArr == null) {
            AppMethodBeat.o(97815);
        } else {
            try {
                bArr2 = a(a(bArr, i), i2, str);
                AppMethodBeat.o(97815);
            } catch (Throwable th) {
                ag.a(th);
                AppMethodBeat.o(97815);
            }
        }
        return bArr2;
    }

    public static byte[] b(byte[] bArr, int i, int i2, String str) {
        AppMethodBeat.i(97816);
        try {
            byte[] b = b(b(bArr, i2, str), i);
            AppMethodBeat.o(97816);
            return b;
        } catch (Exception e) {
            ag.a(e);
            AppMethodBeat.o(97816);
            return null;
        }
    }

    public static String f() {
        AppMethodBeat.i(97788);
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
            ag.a(e);
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(97788);
        return stringBuilder2;
    }

    public static String g() {
        AppMethodBeat.i(97817);
        String format;
        try {
            format = new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
            AppMethodBeat.o(97817);
            return format;
        } catch (Throwable th) {
            ag.a(th);
            format = "";
            AppMethodBeat.o(97817);
            return format;
        }
    }

    public static String e(String str) {
        AppMethodBeat.i(97818);
        String str2 = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            byte[] bArr = new byte[fileInputStream.available()];
            fileInputStream.read(bArr);
            str2 = EncodingUtils.getString(bArr, "UTF-8");
            fileInputStream.close();
        } catch (Exception e) {
            ag.d("Read file %s failed.", str);
        }
        AppMethodBeat.o(97818);
        return str2;
    }

    private static String f(String str) {
        AppMethodBeat.i(97819);
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
            ag.a(e);
        }
        AppMethodBeat.o(97819);
        return str;
    }

    private static String g(String str) {
        AppMethodBeat.i(97820);
        String f = f(str);
        if (f != null) {
            try {
                f = f.substring(8, 24);
            } catch (Exception e) {
            }
        }
        AppMethodBeat.o(97820);
        return f;
    }

    public static String b(Context context, int i) {
        AppMethodBeat.i(97821);
        try {
            aq a = aq.a(context);
            String a2 = a.a();
            String g = g(a2 + "_" + a.b() + "_" + new Date().getTime() + "_" + i);
            AppMethodBeat.o(97821);
            return g;
        } catch (Exception e) {
            AppMethodBeat.o(97821);
            return null;
        }
    }

    public static String k(Context context) {
        AppMethodBeat.i(97822);
        try {
            String d = aq.a(context).d();
            String str = "";
            c m = c.m();
            if (m != null) {
                str = m.j();
            }
            str = g(str + "_" + d + "_" + new Date().getTime() + "_" + ((int) (Math.random() * 2.147483647E9d)));
            AppMethodBeat.o(97822);
            return str;
        } catch (Exception e) {
            AppMethodBeat.o(97822);
            return null;
        }
    }

    public static HashSet<String> a(ArrayList<String> arrayList) {
        AppMethodBeat.i(97823);
        int size = arrayList.size();
        if (arrayList == null || size <= 0) {
            AppMethodBeat.o(97823);
            return null;
        }
        HashSet<String> hashSet = new HashSet(size);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            hashSet.add((String) it.next());
        }
        AppMethodBeat.o(97823);
        return hashSet;
    }
}
