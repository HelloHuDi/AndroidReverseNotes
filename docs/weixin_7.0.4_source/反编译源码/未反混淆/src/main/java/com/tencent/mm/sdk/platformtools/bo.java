package com.tencent.mm.sdk.platformtools;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.app.ActivityManager.MemoryInfo;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Color;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.DocumentsContract;
import android.provider.MediaStore.Audio;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Video;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.inputmethod.InputMethodManager;
import android.webkit.URLUtil;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.FilterEnum4Shaka;
import com.tencent.ttpic.baseutils.IOUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Character.UnicodeBlock;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TimeZone;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import javax.net.ssl.HttpsURLConnection;
import junit.framework.Assert;

public final class bo {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final long[] gjH = new long[]{300, 200, 300, 200};
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', 13, 10, ' ', 9};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};
    private static final long[] xCg = new long[]{300, 50, 300, 50};
    private static final BigInteger xCh = BigInteger.ONE.shiftLeft(64);

    public static class a {
        private Context context;

        public a(Context context) {
            this.context = context;
        }

        public final String toString() {
            AppMethodBeat.i(52291);
            String gY = gY(this.context);
            AppMethodBeat.o(52291);
            return gY;
        }

        private static String gY(Context context) {
            AppMethodBeat.i(52292);
            if (context == null) {
                AppMethodBeat.o(52292);
                return null;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String packageName = context.getPackageName();
            if (activityManager == null || bo.isNullOrNil(packageName)) {
                AppMethodBeat.o(52292);
                return null;
            }
            String stringBuffer;
            try {
                List<RunningTaskInfo> runningTasks = activityManager.getRunningTasks(100);
                StringBuffer stringBuffer2 = new StringBuffer();
                for (RunningTaskInfo runningTaskInfo : runningTasks) {
                    if (runningTaskInfo.baseActivity.getClassName().startsWith(packageName) || runningTaskInfo.topActivity.getClassName().startsWith(packageName)) {
                        stringBuffer2.append(String.format("{id:%d num:%d/%d top:%s base:%s}", new Object[]{Integer.valueOf(runningTaskInfo.id), Integer.valueOf(runningTaskInfo.numRunning), Integer.valueOf(runningTaskInfo.numActivities), runningTaskInfo.topActivity.getShortClassName(), runningTaskInfo.baseActivity.getShortClassName()}));
                    }
                }
                stringBuffer = stringBuffer2.toString();
                AppMethodBeat.o(52292);
                return stringBuffer;
            } catch (Exception e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                stringBuffer = "";
                AppMethodBeat.o(52292);
                return stringBuffer;
            }
        }
    }

    public static String vA(String str) {
        AppMethodBeat.i(52293);
        if (str != null) {
            str = str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        AppMethodBeat.o(52293);
        return str;
    }

    public static String amS(String str) {
        AppMethodBeat.i(52294);
        if (str != null) {
            str = str.replace("../", "");
        }
        AppMethodBeat.o(52294);
        return str;
    }

    public static String c(List<String> list, String str) {
        AppMethodBeat.i(52295);
        String str2;
        if (list == null) {
            str2 = "";
            AppMethodBeat.o(52295);
            return str2;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                if (i2 == list.size() - 1) {
                    stringBuilder.append(((String) list.get(i2)).trim());
                } else {
                    stringBuilder.append(((String) list.get(i2)).trim() + str);
                }
                i = i2 + 1;
            } else {
                str2 = stringBuilder.toString();
                AppMethodBeat.o(52295);
                return str2;
            }
        }
    }

    public static List<String> hT(String str, String str2) {
        AppMethodBeat.i(52296);
        if (TextUtils.isEmpty(str)) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.o(52296);
            return list;
        }
        String[] split = str.split(str2);
        List<String> list2;
        if (split == null) {
            list2 = Collections.EMPTY_LIST;
            AppMethodBeat.o(52296);
            return list2;
        }
        list2 = Arrays.asList(split);
        AppMethodBeat.o(52296);
        return list2;
    }

    public static ArrayList<String> P(String[] strArr) {
        AppMethodBeat.i(52297);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.o(52297);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        AppMethodBeat.o(52297);
        return arrayList;
    }

    public static String[] ej(List<String> list) {
        AppMethodBeat.i(52298);
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                strArr[i2] = (String) list.get(i2);
                i = i2 + 1;
            } else {
                AppMethodBeat.o(52298);
                return strArr;
            }
        }
    }

    public static int gV(int i, int i2) {
        AppMethodBeat.i(52299);
        Assert.assertTrue(i > i2);
        int nextInt = new Random(System.currentTimeMillis()).nextInt((i - i2) + 1) + i2;
        AppMethodBeat.o(52299);
        return nextInt;
    }

    public static byte[] dpz() {
        byte[] bArr;
        AppMethodBeat.i(52300);
        try {
            FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
            bArr = new byte[16];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read == 16) {
                AppMethodBeat.o(52300);
                return bArr;
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        bArr = g.y((UUID.randomUUID().toString() + System.currentTimeMillis()).getBytes());
        AppMethodBeat.o(52300);
        return bArr;
    }

    public static String dpA() {
        int i;
        AppMethodBeat.i(52301);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i = 1;
        } else {
            i = 0;
        }
        String format = String.format("%.2f", new Object[]{Double.valueOf((((double) rawOffset) / 3600.0d) + ((double) i))});
        AppMethodBeat.o(52301);
        return format;
    }

    public static String mw(long j) {
        AppMethodBeat.i(52302);
        String format = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(j));
        AppMethodBeat.o(52302);
        return format;
    }

    public static String mx(long j) {
        AppMethodBeat.i(52303);
        String format = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000 * j));
        AppMethodBeat.o(52303);
        return format;
    }

    public static boolean y(char c) {
        AppMethodBeat.i(52304);
        UnicodeBlock of = UnicodeBlock.of(c);
        if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            AppMethodBeat.o(52304);
            return true;
        }
        AppMethodBeat.o(52304);
        return false;
    }

    public static boolean amT(String str) {
        AppMethodBeat.i(52305);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52305);
            return false;
        }
        boolean find = Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(str).find();
        AppMethodBeat.o(52305);
        return find;
    }

    public static boolean z(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean amU(String str) {
        AppMethodBeat.i(52306);
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                AppMethodBeat.o(52306);
                return false;
            }
        }
        AppMethodBeat.o(52306);
        return true;
    }

    public static boolean A(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean amV(String str) {
        AppMethodBeat.i(52307);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(52307);
            return false;
        }
        try {
            long longValue = Long.valueOf(str.trim()).longValue();
            if (longValue <= 0 || longValue > 4294967295L) {
                AppMethodBeat.o(52307);
                return false;
            }
            AppMethodBeat.o(52307);
            return true;
        } catch (NumberFormatException e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            AppMethodBeat.o(52307);
            return false;
        }
    }

    public static boolean amW(String str) {
        AppMethodBeat.i(52308);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(52308);
            return false;
        }
        boolean matches = str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        AppMethodBeat.o(52308);
        return matches;
    }

    public static byte[] an(Bitmap bitmap) {
        AppMethodBeat.i(52309);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        ab.i("MicroMsg.Util", "recycle bitmap:%s", bitmap);
        bitmap.recycle();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        AppMethodBeat.o(52309);
        return toByteArray;
    }

    public static boolean amX(String str) {
        AppMethodBeat.i(52310);
        if (str == null) {
            AppMethodBeat.o(52310);
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20) {
            AppMethodBeat.o(52310);
            return false;
        } else if (z(trim.charAt(0))) {
            int i = 0;
            while (i < trim.length()) {
                char charAt = trim.charAt(i);
                if (z(charAt) || A(charAt) || charAt == '-' || charAt == '_') {
                    i++;
                } else {
                    AppMethodBeat.o(52310);
                    return false;
                }
            }
            AppMethodBeat.o(52310);
            return true;
        } else {
            AppMethodBeat.o(52310);
            return false;
        }
    }

    public static boolean amY(String str) {
        AppMethodBeat.i(52311);
        if (str == null) {
            AppMethodBeat.o(52311);
            return false;
        } else if (str.length() < 8) {
            AppMethodBeat.o(52311);
            return false;
        } else {
            try {
                Long.parseLong(str);
                AppMethodBeat.o(52311);
                return false;
            } catch (NumberFormatException e) {
                AppMethodBeat.o(52311);
                return true;
            }
        }
    }

    public static String b(long j, double d) {
        AppMethodBeat.i(52313);
        String str = (((double) Math.round((((double) j) * d) / 1048576.0d)) / d) + " MB";
        AppMethodBeat.o(52313);
        return str;
    }

    public static String my(long j) {
        AppMethodBeat.i(52314);
        String b = b(j, 10.0d);
        AppMethodBeat.o(52314);
        return b;
    }

    public static String c(long j, double d) {
        AppMethodBeat.i(52315);
        String str = (((double) Math.round((((double) j) * d) / 1.073741824E9d)) / d) + " GB";
        AppMethodBeat.o(52315);
        return str;
    }

    public static String bZ(byte[] bArr) {
        AppMethodBeat.i(52316);
        String W = W(bArr, 0);
        AppMethodBeat.o(52316);
        return W;
    }

    public static String W(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.i(52317);
        String str;
        if (bArr == null) {
            str = "(null)";
            AppMethodBeat.o(52317);
            return str;
        }
        if (i <= 0) {
            i = bArr.length;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] cArr2 = new char[((i * 3) + (i / 16))];
        int i3 = 0;
        while (true) {
            int i4 = i2;
            if (i3 < i + 0) {
                byte b = bArr[i3];
                int i5 = i4 + 1;
                cArr2[i4] = ' ';
                i4 = i5 + 1;
                cArr2[i5] = cArr[(b >>> 4) & 15];
                i5 = i4 + 1;
                cArr2[i4] = cArr[b & 15];
                if (i3 % 16 != 0 || i3 <= 0) {
                    i2 = i5;
                } else {
                    i2 = i5 + 1;
                    cArr2[i5] = 10;
                }
                i3++;
            } else {
                str = new String(cArr2);
                AppMethodBeat.o(52317);
                return str;
            }
        }
    }

    public static String ca(byte[] bArr) {
        AppMethodBeat.i(52318);
        String str;
        if (bArr == null) {
            str = "(null)";
            AppMethodBeat.o(52318);
            return str;
        }
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        int length = bArr.length;
        char[] cArr2 = new char[(length * 3)];
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArr[i];
            int i3 = i2 + 1;
            cArr2[i2] = ' ';
            i2 = i3 + 1;
            cArr2[i3] = cArr[(b >>> 4) & 15];
            i3 = i2 + 1;
            cArr2[i2] = cArr[b & 15];
            i++;
            i2 = i3;
        }
        str = new String(cArr2);
        AppMethodBeat.o(52318);
        return str;
    }

    static {
        AppMethodBeat.i(52439);
        AppMethodBeat.o(52439);
    }

    public static void z(Context context, boolean z) {
        AppMethodBeat.i(52320);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            ab.w("MicroMsg.Util", "shake:vibrator is null!");
            AppMethodBeat.o(52320);
        } else if (z) {
            vibrator.vibrate(gjH, -1);
            AppMethodBeat.o(52320);
        } else {
            vibrator.cancel();
            AppMethodBeat.o(52320);
        }
    }

    public static void gM(Context context) {
        AppMethodBeat.i(52321);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            AppMethodBeat.o(52321);
            return;
        }
        vibrator.vibrate(xCg, -1);
        AppMethodBeat.o(52321);
    }

    public static long anT() {
        AppMethodBeat.i(52322);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.o(52322);
        return currentTimeMillis;
    }

    public static String mK(int i) {
        AppMethodBeat.i(52323);
        String format = String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
        AppMethodBeat.o(52323);
        return format;
    }

    public static long fp(long j) {
        AppMethodBeat.i(52324);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        AppMethodBeat.o(52324);
        return currentTimeMillis;
    }

    public static long az(long j) {
        AppMethodBeat.i(52325);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AppMethodBeat.o(52325);
        return elapsedRealtime;
    }

    public static long yz() {
        AppMethodBeat.i(52326);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.o(52326);
        return elapsedRealtime;
    }

    public static long dpC() {
        AppMethodBeat.i(52328);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(52328);
        return timeInMillis;
    }

    public static boolean L(long j, long j2) {
        AppMethodBeat.i(52329);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        if (instance.get(1) == instance2.get(1) && instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2)) {
            AppMethodBeat.o(52329);
            return true;
        }
        AppMethodBeat.o(52329);
        return false;
    }

    public static String gN(Context context) {
        AppMethodBeat.i(52330);
        if (context == null) {
            AppMethodBeat.o(52330);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                AppMethodBeat.o(52330);
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId == null) {
                AppMethodBeat.o(52330);
                return null;
            }
            deviceId = deviceId.trim();
            AppMethodBeat.o(52330);
            return deviceId;
        } catch (SecurityException e) {
            ab.e("MicroMsg.Util", "summerdeviceid getDeviceId failed, security exception[%s]", e);
            AppMethodBeat.o(52330);
            return null;
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Util", e2, "summerdeviceid", new Object[0]);
            AppMethodBeat.o(52330);
            return null;
        }
    }

    public static long dpD() {
        AppMethodBeat.i(52331);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long availableBlocks;
            if (VERSION.SDK_INT < 18) {
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                AppMethodBeat.o(52331);
                return availableBlocks;
            }
            availableBlocks = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            AppMethodBeat.o(52331);
            return availableBlocks;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "getDataAvailableSize exception:%s", e.getMessage());
            AppMethodBeat.o(52331);
            return 0;
        }
    }

    public static long gO(Context context) {
        AppMethodBeat.i(52332);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            AppMethodBeat.o(52332);
            return 0;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = (memoryInfo.availMem / 1024) / 1024;
        AppMethodBeat.o(52332);
        return j;
    }

    public static String gP(Context context) {
        AppMethodBeat.i(52333);
        if (context == null) {
            AppMethodBeat.o(52333);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                ab.e("MicroMsg.Util", "getLine1Number failed, null tm");
                AppMethodBeat.o(52333);
                return null;
            }
            String line1Number = telephonyManager.getLine1Number();
            AppMethodBeat.o(52333);
            return line1Number;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "getLine1Number failed:%s ", an.l(e));
            AppMethodBeat.o(52333);
            return null;
        }
    }

    public static String gQ(Context context) {
        AppMethodBeat.i(52334);
        String str;
        if (context == null) {
            ab.w("MicroMsg.Util", "getSimCountryCode context is null.");
            str = "";
            AppMethodBeat.o(52334);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getSimCountryIso();
            if (isNullOrNil(str)) {
                str = "";
                AppMethodBeat.o(52334);
                return str;
            }
            str = str.toUpperCase().trim();
            AppMethodBeat.o(52334);
            return str;
        }
        str = "";
        AppMethodBeat.o(52334);
        return str;
    }

    public static boolean cv(Context context) {
        AppMethodBeat.i(52335);
        String name = context.getClass().getName();
        String cc = cc(context);
        ab.d("MicroMsg.Util", "top activity=" + cc + ", context=" + name);
        boolean equalsIgnoreCase = cc.equalsIgnoreCase(name);
        AppMethodBeat.o(52335);
        return equalsIgnoreCase;
    }

    public static boolean bH(Context context, String str) {
        AppMethodBeat.i(52336);
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(BaseClientBuilder.API_PRIORITY_OTHER)) {
            if (runningServiceInfo != null && runningServiceInfo.service != null && runningServiceInfo.service.getClassName().toString().equals(str)) {
                ab.w("MicroMsg.Util", "service " + str + " is running");
                AppMethodBeat.o(52336);
                return true;
            }
        }
        ab.w("MicroMsg.Util", "service " + str + " is not running");
        AppMethodBeat.o(52336);
        return false;
    }

    public static boolean bI(Context context, String str) {
        AppMethodBeat.i(52337);
        try {
            if (str.equals("com.tencent.mm") || str.startsWith("com.tencent.mm:") || VERSION.SDK_INT < 21) {
                ab.i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", str);
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    AppMethodBeat.o(52337);
                    return false;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                        ab.w("MicroMsg.Util", "process " + str + " is running");
                        AppMethodBeat.o(52337);
                        return true;
                    }
                }
            } else {
                ab.i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", str);
                for (String str2 : dpI()) {
                    ab.d("MicroMsg.Util", "isProcessRunning, process command line = %s", str2);
                    if (str2 != null && str2.contains(str)) {
                        String[] split = str2.split("\\s+");
                        for (Object equals : split) {
                            if (str.equals(equals)) {
                                ab.i("MicroMsg.Util", "process %s is running", str);
                                AppMethodBeat.o(52337);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            ab.w("MicroMsg.Util", "process " + str + " is not running");
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        AppMethodBeat.o(52337);
        return false;
    }

    public static String cc(Context context) {
        AppMethodBeat.i(52338);
        String className;
        try {
            className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            AppMethodBeat.o(52338);
            return className;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            className = "(null)";
            AppMethodBeat.o(52338);
            return className;
        }
    }

    public static boolean gR(Context context) {
        AppMethodBeat.i(52339);
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            String packageName = context.getPackageName();
            ab.d("MicroMsg.Util", "top activity=" + className + ", context=" + packageName);
            boolean contains = className.contains(packageName);
            AppMethodBeat.o(52339);
            return contains;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            AppMethodBeat.o(52339);
            return false;
        }
    }

    public static boolean k(Context context, Intent intent) {
        AppMethodBeat.i(52340);
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            AppMethodBeat.o(52340);
            return false;
        }
        AppMethodBeat.o(52340);
        return true;
    }

    public static List<ResolveInfo> H(Context context, Intent intent) {
        AppMethodBeat.i(52341);
        if (context == null || intent == null) {
            AppMethodBeat.o(52341);
            return null;
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        AppMethodBeat.o(52341);
        return queryIntentActivities;
    }

    public static String cD(Object obj) {
        AppMethodBeat.i(52342);
        String obj2;
        if (obj != null) {
            obj2 = obj.toString();
            AppMethodBeat.o(52342);
            return obj2;
        }
        obj2 = BuildConfig.COMMAND;
        AppMethodBeat.o(52342);
        return obj2;
    }

    public static int h(Integer num) {
        AppMethodBeat.i(52343);
        if (num == null) {
            AppMethodBeat.o(52343);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.o(52343);
        return intValue;
    }

    public static long c(Long l) {
        AppMethodBeat.i(52344);
        if (l == null) {
            AppMethodBeat.o(52344);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.o(52344);
        return longValue;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static boolean d(Boolean bool) {
        AppMethodBeat.i(52345);
        if (bool == null) {
            AppMethodBeat.o(52345);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(52345);
        return booleanValue;
    }

    public static boolean e(Boolean bool) {
        AppMethodBeat.i(52346);
        if (bool == null) {
            AppMethodBeat.o(52346);
            return false;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.o(52346);
        return booleanValue;
    }

    public static int a(Integer num, int i) {
        AppMethodBeat.i(52347);
        if (num == null) {
            AppMethodBeat.o(52347);
            return i;
        }
        i = num.intValue();
        AppMethodBeat.o(52347);
        return i;
    }

    public static byte[] l(byte[] bArr, byte[] bArr2) {
        return bArr == null ? bArr2 : bArr;
    }

    public static long a(Long l, long j) {
        AppMethodBeat.i(52348);
        if (l == null) {
            AppMethodBeat.o(52348);
            return j;
        }
        j = l.longValue();
        AppMethodBeat.o(52348);
        return j;
    }

    public static boolean a(Boolean bool, boolean z) {
        AppMethodBeat.i(52349);
        if (bool == null) {
            AppMethodBeat.o(52349);
            return z;
        }
        z = bool.booleanValue();
        AppMethodBeat.o(52349);
        return z;
    }

    public static String bc(String str, String str2) {
        return str == null ? str2 : str;
    }

    public static int g(Object obj, int i) {
        AppMethodBeat.i(52350);
        if (obj == null) {
            AppMethodBeat.o(52350);
            return i;
        } else if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
            AppMethodBeat.o(52350);
            return i;
        } else if (obj instanceof Long) {
            i = ((Long) obj).intValue();
            AppMethodBeat.o(52350);
            return i;
        } else {
            AppMethodBeat.o(52350);
            return i;
        }
    }

    public static long cE(Object obj) {
        AppMethodBeat.i(52351);
        if (obj == null) {
            AppMethodBeat.o(52351);
            return 0;
        } else if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            AppMethodBeat.o(52351);
            return longValue;
        } else {
            AppMethodBeat.o(52351);
            return 0;
        }
    }

    public static boolean ek(List list) {
        AppMethodBeat.i(52352);
        if (list == null || list.size() == 0) {
            AppMethodBeat.o(52352);
            return true;
        }
        AppMethodBeat.o(52352);
        return false;
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(52353);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(52353);
            return true;
        }
        AppMethodBeat.o(52353);
        return false;
    }

    public static boolean ac(CharSequence charSequence) {
        AppMethodBeat.i(52354);
        if (charSequence == null || charSequence.length() <= 0) {
            AppMethodBeat.o(52354);
            return true;
        }
        AppMethodBeat.o(52354);
        return false;
    }

    public static boolean cb(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return true;
        }
        return false;
    }

    public static boolean Q(String... strArr) {
        boolean z = false;
        AppMethodBeat.i(52355);
        for (String isNullOrNil : strArr) {
            if (isNullOrNil(isNullOrNil)) {
                z = true;
                break;
            }
        }
        AppMethodBeat.o(52355);
        return z;
    }

    public static int amZ(String str) {
        AppMethodBeat.i(52356);
        if (str == null) {
            AppMethodBeat.o(52356);
            return -1;
        }
        int length = str.length();
        AppMethodBeat.o(52356);
        return length;
    }

    public static int ana(String str) {
        AppMethodBeat.i(52357);
        if (str == null) {
            AppMethodBeat.o(52357);
            return -1;
        }
        int length = str.getBytes(Charset.forName("UTF-8")).length;
        AppMethodBeat.o(52357);
        return length;
    }

    public static int cc(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public static int anb(String str) {
        int i = 0;
        AppMethodBeat.i(52358);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52358);
            return i;
        }
        try {
            i = (int) (new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime() / 1000);
            AppMethodBeat.o(52358);
            return i;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[i]);
            AppMethodBeat.o(52358);
            return i;
        }
    }

    public static int getInt(String str, int i) {
        AppMethodBeat.i(52359);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                    AppMethodBeat.o(52359);
                    return i;
                }
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(52359);
            }
        }
        AppMethodBeat.o(52359);
        return i;
    }

    public static long getLong(String str, long j) {
        AppMethodBeat.i(52360);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j = Long.decode(str).longValue();
                    AppMethodBeat.o(52360);
                    return j;
                }
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(52360);
            }
        }
        AppMethodBeat.o(52360);
        return j;
    }

    public static String mz(long j) {
        AppMethodBeat.i(52361);
        BigInteger valueOf = BigInteger.valueOf(j);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(xCh);
        }
        String bigInteger = valueOf.toString();
        AppMethodBeat.o(52361);
        return bigInteger;
    }

    public static boolean getBoolean(String str, boolean z) {
        AppMethodBeat.i(52362);
        if (str == null) {
            try {
                AppMethodBeat.o(52362);
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(52362);
            }
        } else {
            z = Boolean.parseBoolean(str);
            AppMethodBeat.o(52362);
        }
        return z;
    }

    public static float getFloat(String str, float f) {
        AppMethodBeat.i(52363);
        if (str == null) {
            try {
                AppMethodBeat.o(52363);
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(52363);
            }
        } else {
            f = Float.parseFloat(str);
            AppMethodBeat.o(52363);
        }
        return f;
    }

    public static double getDouble(String str, double d) {
        AppMethodBeat.i(52364);
        if (str == null) {
            try {
                AppMethodBeat.o(52364);
            } catch (NumberFormatException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.o(52364);
            }
        } else {
            d = Double.parseDouble(str);
            AppMethodBeat.o(52364);
        }
        return d;
    }

    public static int anc(String str) {
        int i = 0;
        AppMethodBeat.i(52365);
        if (str == null) {
            AppMethodBeat.o(52365);
            return i;
        }
        try {
            i = (int) (Long.decode(str).longValue() & 4294967295L);
            AppMethodBeat.o(52365);
            return i;
        } catch (NumberFormatException e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[i]);
            AppMethodBeat.o(52365);
            return i;
        }
    }

    public static boolean hideVKB(View view) {
        AppMethodBeat.i(52366);
        boolean hideSoftInputFromWindow;
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                AppMethodBeat.o(52366);
                return false;
            }
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            ab.v("MicroMsg.Util", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
            AppMethodBeat.o(52366);
            return hideSoftInputFromWindow;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            ab.e("MicroMsg.Util", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
    }

    public static String and(String str) {
        AppMethodBeat.i(52367);
        if (str == null) {
            str = "";
        }
        String x;
        if (str.length() <= 16) {
            x = g.x(str.getBytes());
            AppMethodBeat.o(52367);
            return x;
        }
        x = g.x(str.substring(0, 16).getBytes());
        AppMethodBeat.o(52367);
        return x;
    }

    public static String ane(String str) {
        AppMethodBeat.i(138964);
        String x = g.x(str.getBytes());
        AppMethodBeat.o(138964);
        return x;
    }

    public static String cd(byte[] bArr) {
        AppMethodBeat.i(52369);
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(52369);
        return stringBuilder2;
    }

    public static byte[] anf(String str) {
        AppMethodBeat.i(52370);
        byte[] bArr;
        if (str == null || str.length() <= 0) {
            bArr = new byte[0];
            AppMethodBeat.o(52370);
            return bArr;
        }
        try {
            bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & 255);
            }
            AppMethodBeat.o(52370);
            return bArr;
        } catch (NumberFormatException e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            bArr = new byte[0];
            AppMethodBeat.o(52370);
            return bArr;
        }
    }

    public static int[] ang(String str) {
        int i = 0;
        AppMethodBeat.i(52371);
        if (str == null) {
            AppMethodBeat.o(52371);
            return null;
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Exception e) {
                    ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    ab.e("MicroMsg.Util", "invalid port num, ignore");
                }
            }
        }
        int[] iArr = new int[arrayList.size()];
        while (true) {
            int i2 = i;
            if (i2 < iArr.length) {
                iArr[i2] = ((Integer) arrayList.get(i2)).intValue();
                i = i2 + 1;
            } else {
                AppMethodBeat.o(52371);
                return iArr;
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0061=Splitter:B:15:0x0061, B:28:0x00ae=Splitter:B:28:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f A:{SYNTHETIC, Splitter:B:18:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc A:{SYNTHETIC, Splitter:B:31:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc A:{SYNTHETIC, Splitter:B:39:0x00cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int hU(String str, String str2) {
        Throwable e;
        AppMethodBeat.i(52372);
        ZipInputStream zipInputStream;
        try {
            zipInputStream = new ZipInputStream(new FileInputStream(str));
            while (true) {
                try {
                    ZipEntry nextEntry = zipInputStream.getNextEntry();
                    if (nextEntry != null) {
                        String name = nextEntry.getName();
                        if (!(name.contains("../") || name.contains("..\\"))) {
                            if (nextEntry.isDirectory()) {
                                new File(str2 + File.separator + name.substring(0, name.length() - 1)).mkdirs();
                            } else {
                                File file = new File(str2 + File.separator + name);
                                file.createNewFile();
                                FileOutputStream fileOutputStream = new FileOutputStream(file);
                                byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
                                while (true) {
                                    int read = zipInputStream.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    fileOutputStream.write(bArr, 0, read);
                                    fileOutputStream.flush();
                                }
                                fileOutputStream.close();
                            }
                        }
                    } else {
                        try {
                            break;
                        } catch (IOException e2) {
                            ab.e("MicroMsg.Util", "close zip stream failed.");
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                        if (zipInputStream != null) {
                        }
                        AppMethodBeat.o(52372);
                        return -1;
                    } catch (Throwable th) {
                        e = th;
                        if (zipInputStream != null) {
                        }
                        AppMethodBeat.o(52372);
                        throw e;
                    }
                } catch (IOException e4) {
                    e = e4;
                    ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    if (zipInputStream != null) {
                    }
                    AppMethodBeat.o(52372);
                    return -2;
                }
            }
            zipInputStream.close();
            AppMethodBeat.o(52372);
            return 0;
        } catch (FileNotFoundException e5) {
            e = e5;
            zipInputStream = null;
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e6) {
                    ab.e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            AppMethodBeat.o(52372);
            return -1;
        } catch (IOException e7) {
            e = e7;
            zipInputStream = null;
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e8) {
                    ab.e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            AppMethodBeat.o(52372);
            return -2;
        } catch (Throwable th2) {
            e = th2;
            zipInputStream = null;
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e9) {
                    ab.e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            AppMethodBeat.o(52372);
            throw e;
        }
    }

    public static final String anh(String str) {
        AppMethodBeat.i(52373);
        if (isNullOrNil(str)) {
            str = "";
            AppMethodBeat.o(52373);
            return str;
        }
        try {
            str = new URL(str).getHost();
            AppMethodBeat.o(52373);
            return str;
        } catch (MalformedURLException e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            ab.w("MicroMsg.Util", "get host error");
            AppMethodBeat.o(52373);
            return str;
        }
    }

    public static boolean M(Context context, String str) {
        AppMethodBeat.i(52374);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (k(context, intent)) {
            context.startActivity(intent);
            AppMethodBeat.o(52374);
            return true;
        }
        ab.e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(str)));
        AppMethodBeat.o(52374);
        return false;
    }

    public static String ani(String str) {
        AppMethodBeat.i(52375);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.o(52375);
            return str2;
        }
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            Object obj = 1;
            for (int length2 = iRk.length - 1; length2 >= 0; length2--) {
                if (iRk[length2] == charAt) {
                    stringBuffer.append(iRl[length2]);
                    obj = null;
                    break;
                }
            }
            if (i == length - 1 && Character.isHighSurrogate(charAt)) {
                obj = null;
            }
            if (obj != null) {
                stringBuffer.append(charAt);
            }
        }
        str2 = stringBuffer.toString();
        AppMethodBeat.o(52375);
        return str2;
    }

    public static String anj(String str) {
        AppMethodBeat.i(52376);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(52376);
            return str;
        } else if (VERSION.SDK_INT < 8) {
            int length = str.length();
            char[] cArr = new char[length];
            int i = 0;
            int i2 = 0;
            int i3 = -1;
            while (i < length) {
                int i4;
                char charAt = str.charAt(i);
                int i5 = i2 + 1;
                cArr[i2] = charAt;
                if (charAt == '&' && i3 == -1) {
                    i2 = i5;
                    i4 = i5;
                } else if (i3 == -1 || Character.isLetter(charAt) || Character.isDigit(charAt) || charAt == '#') {
                    i2 = i5;
                    i4 = i3;
                } else if (charAt == ';') {
                    i2 = a(cArr, i3, (i5 - i3) - 1);
                    if (i2 > CdnLogic.kBizGeneric) {
                        i5 = i2 - 65536;
                        cArr[i3 - 1] = (char) ((i5 >> 10) + 55296);
                        cArr[i3] = (char) ((i5 & FilterEnum4Shaka.MIC_SHAKA_ADD_4) + 56320);
                        i3++;
                    } else if (i2 != 0) {
                        cArr[i3 - 1] = (char) i2;
                    } else {
                        i3 = i5;
                    }
                    i2 = i3;
                    i4 = -1;
                } else {
                    i2 = i5;
                    i4 = -1;
                }
                i++;
                i3 = i4;
            }
            str = new String(cArr, 0, i2);
            AppMethodBeat.o(52376);
            return str;
        } else {
            AppMethodBeat.o(52376);
            return str;
        }
    }

    private static int a(char[] cArr, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.i(52377);
        if (i2 <= 0) {
            AppMethodBeat.o(52377);
        } else if (cArr[i] != '#') {
            String str = new String(cArr, i, i2);
            AppMethodBeat.o(52377);
        } else if (i2 <= 1 || !(cArr[i + 1] == 'x' || cArr[i + 1] == 'X')) {
            try {
                i3 = Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
                AppMethodBeat.o(52377);
            } catch (NumberFormatException e) {
                AppMethodBeat.o(52377);
            }
        } else {
            try {
                i3 = Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
                AppMethodBeat.o(52377);
            } catch (NumberFormatException e2) {
                AppMethodBeat.o(52377);
            }
        }
        return i3;
    }

    public static String a(LinkedHashMap<String, String> linkedHashMap) {
        AppMethodBeat.i(52378);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<key>");
        for (Entry entry : linkedHashMap.entrySet()) {
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (key == null) {
                key = "unknow";
            }
            if (value == null) {
                value = "unknow";
            }
            stringBuilder.append("<" + key + ">");
            stringBuilder.append(value);
            stringBuilder.append("</" + key + ">");
        }
        stringBuilder.append("</key>");
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(52378);
        return stringBuilder2;
    }

    public static int ank(String str) {
        AppMethodBeat.i(52379);
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            if (str != null) {
                ab.e("MicroMsg.Util", "parserInt error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(52379);
        return i;
    }

    public static long anl(String str) {
        AppMethodBeat.i(52380);
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            if (str != null) {
                ab.e("MicroMsg.Util", "parseLong error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(52380);
        return j;
    }

    public static double anm(String str) {
        AppMethodBeat.i(52381);
        double d = 0.0d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            if (str != null) {
                ab.e("MicroMsg.Util", "parseDouble error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(52381);
        return d;
    }

    public static float ann(String str) {
        AppMethodBeat.i(52382);
        float f = 0.0f;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
            if (str != null) {
                ab.e("MicroMsg.Util", "parseFloat error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.o(52382);
        return f;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.i(52383);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52383);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.o(52383);
            return true;
        } else if (file.isDirectory()) {
            AppMethodBeat.o(52383);
            return false;
        } else {
            boolean delete = file.delete();
            AppMethodBeat.o(52383);
            return delete;
        }
    }

    public static void o(String str, String str2, long j) {
        AppMethodBeat.i(52384);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52384);
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.o(52384);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().startsWith(str2) && (System.currentTimeMillis() - file2.lastModified()) - j >= 0) {
                    file2.delete();
                }
            }
            AppMethodBeat.o(52384);
            return;
        }
        AppMethodBeat.o(52384);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2 A:{SYNTHETIC, Splitter:B:37:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A:{SYNTHETIC, Splitter:B:29:0x00a9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(String str) {
        Throwable e;
        AppMethodBeat.i(52385);
        if (isNullOrNil(str)) {
            ab.w("MicroMsg.Util", "readFromFile error, path is null or empty");
            AppMethodBeat.o(52385);
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            FileInputStream fileInputStream;
            try {
                int length = (int) file.length();
                fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[length];
                    if (fileInputStream.read(bArr) != length) {
                        ab.w("MicroMsg.Util", "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream.read(bArr)));
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                        }
                        AppMethodBeat.o(52385);
                        return null;
                    }
                    ab.d("MicroMsg.Util", "readFromFile ok!");
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        ab.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                    }
                    AppMethodBeat.o(52385);
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(52385);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(52385);
                        throw e;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        ab.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(52385);
                return null;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e32) {
                        ab.printErrStackTrace("MicroMsg.Util", e32, "", new Object[0]);
                    }
                }
                AppMethodBeat.o(52385);
                throw e;
            }
        }
        ab.w("MicroMsg.Util", "readFromFile error, file is not exit, path = %s", str);
        AppMethodBeat.o(52385);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A:{SYNTHETIC, Splitter:B:20:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A:{SYNTHETIC, Splitter:B:28:0x007b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean z(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.i(52386);
        if (isNullOrNil(str) || cb(bArr)) {
            ab.w("MicroMsg.Util", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.o(52386);
            return false;
        }
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(str);
            try {
                fileOutputStream.write(bArr);
                fileOutputStream.flush();
                try {
                    fileOutputStream.close();
                } catch (IOException e2) {
                    ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                }
                ab.d("MicroMsg.Util", "writeToFile ok!");
                AppMethodBeat.o(52386);
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    ab.w("MicroMsg.Util", "write to file error");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            ab.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.o(52386);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.o(52386);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            ab.w("MicroMsg.Util", "write to file error");
            if (fileOutputStream != null) {
            }
            AppMethodBeat.o(52386);
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    ab.printErrStackTrace("MicroMsg.Util", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.o(52386);
            throw e;
        }
    }

    public static String gS(Context context) {
        AppMethodBeat.i(52387);
        if (context == null) {
            AppMethodBeat.o(52387);
            return null;
        }
        String l = l(context.getPackageName(), context);
        AppMethodBeat.o(52387);
        return l;
    }

    public static String l(String str, Context context) {
        String str2 = null;
        AppMethodBeat.i(52388);
        if (context == null || isNullOrNil(str)) {
            AppMethodBeat.o(52388);
            return str2;
        }
        try {
            str2 = g.x(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            AppMethodBeat.o(52388);
            return str2;
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            AppMethodBeat.o(52388);
            return str2;
        }
    }

    public static boolean gT(Context context) {
        AppMethodBeat.i(52389);
        if (Locale.getDefault().getCountry().equalsIgnoreCase("CN")) {
            if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
                AppMethodBeat.o(52389);
                return true;
            } else if (context == null) {
                ab.w("MicroMsg.Util", "isOverseasUser context is null");
                AppMethodBeat.o(52389);
                return false;
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (!(isNullOrNil(networkCountryIso) || networkCountryIso.contains("cn") || networkCountryIso.contains("CN"))) {
                        AppMethodBeat.o(52389);
                        return true;
                    }
                }
                AppMethodBeat.o(52389);
                return false;
            }
        }
        AppMethodBeat.o(52389);
        return true;
    }

    public static OnTouchListener dpE() {
        AppMethodBeat.i(52390);
        AnonymousClass1 anonymousClass1 = new OnTouchListener() {
            public final boolean onTouch(final View view, MotionEvent motionEvent) {
                AppMethodBeat.i(52290);
                switch (motionEvent.getAction()) {
                    case 0:
                        view.setPressed(true);
                        break;
                    case 1:
                    case 3:
                    case 4:
                        view.post(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(52289);
                                view.setPressed(false);
                                AppMethodBeat.o(52289);
                            }
                        });
                        break;
                }
                AppMethodBeat.o(52290);
                return false;
            }
        };
        AppMethodBeat.o(52390);
        return anonymousClass1;
    }

    public static byte[] ano(String str) {
        AppMethodBeat.i(52391);
        byte[] anr;
        if (str == null || str.length() == 0) {
            ab.e("MicroMsg.Util", "httpGet, url is null");
            AppMethodBeat.o(52391);
            return null;
        } else if (URLUtil.isDataUrl(str)) {
            anr = anr(str);
            AppMethodBeat.o(52391);
            return anr;
        } else if (URLUtil.isHttpsUrl(str)) {
            anr = anq(str);
            AppMethodBeat.o(52391);
            return anr;
        } else {
            anr = anp(str);
            AppMethodBeat.o(52391);
            return anr;
        }
    }

    private static byte[] anp(String str) {
        AppMethodBeat.i(52392);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() != 200) {
                ab.e("MicroMsg.Util", "http get response code = %d", Integer.valueOf(httpURLConnection.getResponseCode()));
                AppMethodBeat.o(52392);
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            httpURLConnection.disconnect();
            AppMethodBeat.o(52392);
            return toByteArray;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "http download failed : %s", e.getMessage());
            AppMethodBeat.o(52392);
            return null;
        }
    }

    private static byte[] anq(String str) {
        AppMethodBeat.i(52393);
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            if (httpsURLConnection.getResponseCode() != 200) {
                ab.e("MicroMsg.Util", "https get response code = %d", Integer.valueOf(httpsURLConnection.getResponseCode()));
                AppMethodBeat.o(52393);
                return null;
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpsURLConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[4096];
            for (int read = bufferedInputStream.read(bArr); read > 0; read = bufferedInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, read);
            }
            byte[] toByteArray = byteArrayOutputStream.toByteArray();
            bufferedInputStream.close();
            byteArrayOutputStream.close();
            AppMethodBeat.o(52393);
            return toByteArray;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "getHttpsData failed : %s", e.getMessage());
            AppMethodBeat.o(52393);
            return null;
        }
    }

    private static byte[] anr(String str) {
        AppMethodBeat.i(52394);
        try {
            int indexOf = str.indexOf("base64");
            if (indexOf > 0) {
                str = str.substring(indexOf + 7);
            }
            byte[] decode = Base64.decode(str, 0);
            AppMethodBeat.o(52394);
            return decode;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "decode base64 url failed : %s", e.getMessage());
            AppMethodBeat.o(52394);
            return null;
        }
    }

    public static CharSequence ad(CharSequence charSequence) {
        AppMethodBeat.i(52395);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(52395);
        return stringBuffer2;
    }

    public static String PA(String str) {
        AppMethodBeat.i(52396);
        String trim = str.replaceAll("[\\.\\-]", "").trim();
        AppMethodBeat.o(52396);
        return trim;
    }

    public static String ans(String str) {
        int i = 0;
        AppMethodBeat.i(52397);
        if (isNullOrNil(str) || str.startsWith("+")) {
            str = "";
            AppMethodBeat.o(52397);
            return str;
        } else if (str.length() > 5) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.subSequence(0, 3));
            while (i < str.length() - 5) {
                char charAt = str.charAt(i + 3);
                if (charAt < '0' || charAt > '9') {
                    stringBuffer.append(charAt);
                } else {
                    stringBuffer.append('*');
                }
                i++;
            }
            stringBuffer.append(str.charAt(str.length() - 2));
            stringBuffer.append(str.charAt(str.length() - 1));
            str = stringBuffer.toString();
            AppMethodBeat.o(52397);
            return str;
        } else {
            AppMethodBeat.o(52397);
            return str;
        }
    }

    public static Boolean ant(String str) {
        AppMethodBeat.i(52398);
        boolean z = Pattern.compile("^[+][0-9]{10,13}$").matcher(str).matches() || Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.o(52398);
        return valueOf;
    }

    public static String I(InputStream inputStream) {
        AppMethodBeat.i(52399);
        if (inputStream == null) {
            AppMethodBeat.o(52399);
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    stringBuffer.append(new String(bArr, 0, read));
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    }
                }
            }
            inputStream.close();
        } catch (Exception e2) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                ab.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e32) {
                ab.printErrStackTrace("MicroMsg.Util", e32, "", new Object[0]);
            }
            AppMethodBeat.o(52399);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(52399);
        return stringBuffer2;
    }

    public static String anu(String str) {
        AppMethodBeat.i(52400);
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf("@");
            if (lastIndexOf != -1) {
                str = str.substring(0, lastIndexOf);
                AppMethodBeat.o(52400);
                return str;
            }
        }
        AppMethodBeat.o(52400);
        return str;
    }

    public static String anv(String str) {
        AppMethodBeat.i(52401);
        String str2;
        if (isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(52401);
            return str2;
        }
        int length = str.length();
        if (length < 4) {
            str2 = "*~".concat(String.valueOf(length));
            AppMethodBeat.o(52401);
            return str2;
        } else if (length < 8) {
            str2 = str.substring(0, 1) + "*" + str.substring(length - 2, length - 1) + "~" + length;
            AppMethodBeat.o(52401);
            return str2;
        } else {
            str2 = str.substring(0, 2) + "*" + str.substring(length - 3, length - 1) + "~" + length;
            AppMethodBeat.o(52401);
            return str2;
        }
    }

    public static String l(Throwable th) {
        AppMethodBeat.i(138965);
        String l = an.l(th);
        AppMethodBeat.o(138965);
        return l;
    }

    public static int dpF() {
        AppMethodBeat.i(52403);
        int nextInt = new Random().nextInt();
        AppMethodBeat.o(52403);
        return nextInt;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static String a(Context context, Uri uri, String str, String[] strArr) {
        Cursor query;
        String string;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.i(52404);
        try {
            query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        if (columnIndexOrThrow == -1) {
                            ab.e("MicroMsg.Util", "getDataColumn : columnIdx is -1, column with columnName = _data does not exist");
                            query.close();
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.o(52404);
                            return null;
                        }
                        string = query.getString(columnIndexOrThrow);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.o(52404);
                        return string;
                    }
                } catch (Exception e) {
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.o(52404);
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.o(52404);
            return null;
        } catch (Exception e2) {
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.o(52404);
            throw th;
        }
        try {
            string = uri.getPath();
            if (d.iW(24)) {
                string = string.replace("external_files", "");
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.o(52404);
            return string;
        } catch (Throwable th4) {
            th = th4;
            query = cursor;
            if (query != null) {
            }
            AppMethodBeat.o(52404);
            throw th;
        }
    }

    @TargetApi(19)
    public static String h(Context context, Uri uri) {
        Uri uri2 = null;
        AppMethodBeat.i(52405);
        if (context == null || uri == null) {
            ab.e("MicroMsg.Util", "getFilePath : context is null or uri is null");
            AppMethodBeat.o(52405);
            return null;
        }
        String scheme = uri.getScheme();
        String path;
        if (isNullOrNil(scheme)) {
            ab.e("MicroMsg.Util", "input uri error. %s", uri);
            AppMethodBeat.o(52405);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            ab.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
            path = uri.getPath();
            AppMethodBeat.o(52405);
            return path;
        } else {
            if (scheme.equalsIgnoreCase(b.CONTENT)) {
                ab.i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    path = uri.getLastPathSegment();
                    AppMethodBeat.o(52405);
                    return path;
                }
                try {
                    context.grantUriPermission(uri.getAuthority(), uri, 1);
                    scheme = a(context, uri, null, null);
                } catch (SecurityException e) {
                    ab.e("MicroMsg.Util", "getFilePath : exception = ".concat(String.valueOf(e)));
                    scheme = null;
                }
                if (!isNullOrNil(scheme)) {
                    AppMethodBeat.o(52405);
                    return scheme;
                } else if (VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
                    String[] split;
                    if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                        split = DocumentsContract.getDocumentId(uri).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if ("primary".equalsIgnoreCase(split[0])) {
                            path = Environment.getExternalStorageDirectory() + "/" + split[1];
                            AppMethodBeat.o(52405);
                            return path;
                        }
                        AppMethodBeat.o(52405);
                        return null;
                    } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        path = a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                        AppMethodBeat.o(52405);
                        return path;
                    } else if ("com.android.providers.media.documents".equals(uri.getAuthority())) {
                        Object obj = DocumentsContract.getDocumentId(uri).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D)[0];
                        if ("image".equals(obj)) {
                            uri2 = Media.EXTERNAL_CONTENT_URI;
                        } else if ("video".equals(obj)) {
                            uri2 = Video.Media.EXTERNAL_CONTENT_URI;
                        } else if (SlookAirButtonRecentMediaAdapter.AUDIO_TYPE.equals(obj)) {
                            uri2 = Audio.Media.EXTERNAL_CONTENT_URI;
                        }
                        path = a(context, uri2, "_id=?", new String[]{split[1]});
                        AppMethodBeat.o(52405);
                        return path;
                    }
                }
            }
            ab.e("MicroMsg.Util", "unknown scheme");
            AppMethodBeat.o(52405);
            return null;
        }
    }

    public static boolean v(Uri uri) {
        AppMethodBeat.i(52406);
        if (uri == null) {
            AppMethodBeat.o(52406);
            return false;
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            boolean anw = anw(uri.getPath());
            AppMethodBeat.o(52406);
            return anw;
        } else {
            AppMethodBeat.o(52406);
            return true;
        }
    }

    public static boolean anw(String str) {
        AppMethodBeat.i(52407);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52407);
            return false;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            if (canonicalPath.contains("/com.tencent.mm/cache/")) {
                AppMethodBeat.o(52407);
                return true;
            } else if (canonicalPath.contains("/com.tencent.mm/")) {
                AppMethodBeat.o(52407);
                return false;
            } else {
                AppMethodBeat.o(52407);
                return true;
            }
        } catch (IOException e) {
            AppMethodBeat.o(52407);
            return false;
        }
    }

    public static boolean anx(String str) {
        AppMethodBeat.i(52408);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52408);
            return false;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            AppMethodBeat.o(52408);
            return false;
        }
        boolean any = any(str.substring(lastIndexOf + 1));
        AppMethodBeat.o(52408);
        return any;
    }

    public static boolean any(String str) {
        AppMethodBeat.i(52409);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52409);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equals("webp") && VERSION.SDK_INT >= 14) {
            AppMethodBeat.o(52409);
            return true;
        } else if (toLowerCase.equals("heic") && VERSION.SDK_INT >= 28) {
            AppMethodBeat.o(52409);
            return true;
        } else if (toLowerCase.equals("jpg") || toLowerCase.equals("gif") || toLowerCase.equals("bmp") || toLowerCase.equals("jpeg") || toLowerCase.equals("png")) {
            AppMethodBeat.o(52409);
            return true;
        } else {
            AppMethodBeat.o(52409);
            return false;
        }
    }

    public static a gU(Context context) {
        AppMethodBeat.i(52410);
        a aVar = new a(context);
        AppMethodBeat.o(52410);
        return aVar;
    }

    public static ComponentName gV(Context context) {
        AppMethodBeat.i(52411);
        try {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                AppMethodBeat.o(52411);
                return null;
            }
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            AppMethodBeat.o(52411);
            return componentName;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "get Top Activity Exception:%s", e.getMessage());
            AppMethodBeat.o(52411);
            return null;
        }
    }

    public static String gW(Context context) {
        AppMethodBeat.i(52412);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    str = "";
                    AppMethodBeat.o(52412);
                    return str;
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.o(52412);
                        return null;
                    }
                    str = componentName.getClassName();
                    if (str.contains(".")) {
                        str = str.substring(str.lastIndexOf(".") + 1);
                    }
                    AppMethodBeat.o(52412);
                    return str;
                }
                str = "";
                AppMethodBeat.o(52412);
                return str;
            }
            str = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (str.contains(".")) {
                str = str.substring(str.lastIndexOf(".") + 1);
            }
            AppMethodBeat.o(52412);
            return str;
        } catch (Exception e) {
            ab.e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", e.getMessage(), an.l(e));
        }
    }

    public static RunningTaskInfo av(Context context, int i) {
        AppMethodBeat.i(52413);
        for (RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1000)) {
            if (runningTaskInfo.id == i) {
                AppMethodBeat.o(52413);
                return runningTaskInfo;
            }
        }
        AppMethodBeat.o(52413);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2 A:{SYNTHETIC, Splitter:B:44:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bc A:{SYNTHETIC, Splitter:B:50:0x00bc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String aw(Context context, int i) {
        Throwable e;
        AppMethodBeat.i(52414);
        String str;
        if (context == null || i <= 0) {
            str = "";
            AppMethodBeat.o(52414);
            return str;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName != null && !runningAppProcessInfo.processName.equals("")) {
                    str = runningAppProcessInfo.processName;
                    AppMethodBeat.o(52414);
                    return str;
                }
            }
        } catch (Exception e2) {
            ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
        }
        byte[] bArr = new byte[128];
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream("/proc/" + i + "/cmdline");
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    int i2 = 0;
                    while (i2 < read) {
                        if (bArr[i2] > Byte.MIN_VALUE || bArr[i2] <= (byte) 0) {
                            read = i2;
                            break;
                        }
                        i2++;
                    }
                    str = new String(bArr, 0, read);
                    try {
                        fileInputStream.close();
                    } catch (Exception e3) {
                    }
                    AppMethodBeat.o(52414);
                    return str;
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                str = "";
                AppMethodBeat.o(52414);
                return str;
            } catch (Exception e5) {
                e = e5;
                try {
                    ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    str = "";
                    AppMethodBeat.o(52414);
                    return str;
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(52414);
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e7) {
                }
            }
            str = "";
            AppMethodBeat.o(52414);
            return str;
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e8) {
                }
            }
            AppMethodBeat.o(52414);
            throw e;
        }
    }

    public static an dpG() {
        AppMethodBeat.i(52415);
        an anVar = new an();
        AppMethodBeat.o(52415);
        return anVar;
    }

    public static long anU() {
        AppMethodBeat.i(138966);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.o(138966);
        return currentTimeMillis;
    }

    public static long gb(long j) {
        AppMethodBeat.i(52417);
        long currentTimeMillis = System.currentTimeMillis() - j;
        AppMethodBeat.o(52417);
        return currentTimeMillis;
    }

    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.i(52418);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    stringBuilder.append(readLine + IOUtils.LINE_SEPARATOR_UNIX);
                } else {
                    try {
                        break;
                    } catch (IOException e) {
                        ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    }
                }
            } catch (IOException e2) {
                ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                try {
                    inputStream.close();
                } catch (IOException e22) {
                    ab.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    ab.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                }
                AppMethodBeat.o(52418);
            }
        }
        inputStream.close();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(52418);
        return stringBuilder2;
    }

    public static String aC(float f) {
        AppMethodBeat.i(52419);
        String format;
        if (f < 1024.0f) {
            format = String.format("%.1fB", new Object[]{Float.valueOf(f)});
            AppMethodBeat.o(52419);
            return format;
        } else if (f < 1048576.0f) {
            format = String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
            AppMethodBeat.o(52419);
            return format;
        } else if (f < 1.07374182E9f) {
            format = String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
            AppMethodBeat.o(52419);
            return format;
        } else {
            format = String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
            AppMethodBeat.o(52419);
            return format;
        }
    }

    public static String anz(String str) {
        AppMethodBeat.i(52420);
        if (str == null) {
            AppMethodBeat.o(52420);
            return null;
        }
        int length = str.length();
        while (length > 0) {
            if (str.charAt(length - 1) == 10 || str.charAt(length - 1) == 13) {
                length--;
            } else {
                str = str.substring(0, length);
                AppMethodBeat.o(52420);
                return str;
            }
        }
        AppMethodBeat.o(52420);
        return str;
    }

    public static boolean B(Object obj, Object obj2) {
        boolean z = true;
        AppMethodBeat.i(52421);
        if (obj != obj2 && (obj == null || obj2 == null || !obj.equals(obj2))) {
            z = false;
        }
        AppMethodBeat.o(52421);
        return z;
    }

    public static void b(Closeable closeable) {
        AppMethodBeat.i(52422);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                ab.printErrStackTrace("MicroMsg.Util", e, "qualityClose", new Object[0]);
                AppMethodBeat.o(52422);
                return;
            }
        }
        AppMethodBeat.o(52422);
    }

    public static String Mb(int i) {
        AppMethodBeat.i(52423);
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str.charAt(random.nextInt(62)));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.o(52423);
        return stringBuffer2;
    }

    public static void n(View view, int i, int i2, int i3, int i4) {
        AppMethodBeat.i(52424);
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i4;
        rect.left -= i;
        rect.right += i3;
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (View.class.isInstance(view.getParent())) {
            ((View) view.getParent()).setTouchDelegate(touchDelegate);
        }
        AppMethodBeat.o(52424);
    }

    public static String anA(String str) {
        AppMethodBeat.i(52425);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52425);
            return str;
        }
        str = str.replaceAll("‮", "");
        AppMethodBeat.o(52425);
        return str;
    }

    public static int bf(byte[] bArr) {
        AppMethodBeat.i(52426);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        int i = wrap.getInt();
        AppMethodBeat.o(52426);
        return i;
    }

    public static final String anB(String str) {
        AppMethodBeat.i(52427);
        if (isNullOrNil(str)) {
            AppMethodBeat.o(52427);
            return null;
        }
        String host = Uri.parse(str).getHost();
        AppMethodBeat.o(52427);
        return host;
    }

    public static boolean dpH() {
        AppMethodBeat.i(52428);
        String property = System.getProperty("java.vm.version");
        if (isNullOrNil(property) || !property.startsWith("2")) {
            AppMethodBeat.o(52428);
            return false;
        }
        AppMethodBeat.o(52428);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A:{SYNTHETIC, Splitter:B:14:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d A:{SYNTHETIC, Splitter:B:29:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static List<String> dpI() {
        Exception e;
        Throwable th;
        AppMethodBeat.i(52429);
        ArrayList arrayList = new ArrayList();
        LineNumberReader lineNumberReader;
        try {
            Process exec = Runtime.getRuntime().exec("ps");
            lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
            while (true) {
                try {
                    String readLine = lineNumberReader.readLine();
                    if (readLine == null) {
                        break;
                    } else if (readLine.length() > 0) {
                        arrayList.add(readLine);
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        ab.e("MicroMsg.Util", "getRunningAppProcessesByPs fail, ex = %s", e.getMessage());
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e3) {
                                ab.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                            }
                        }
                        ab.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
                        AppMethodBeat.o(52429);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e4) {
                                ab.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e4.getMessage());
                            }
                        }
                        AppMethodBeat.o(52429);
                        throw th;
                    }
                }
            }
            exec.waitFor();
            exec.destroy();
            try {
                lineNumberReader.close();
            } catch (Exception e32) {
                ab.e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
            }
        } catch (Exception e5) {
            e32 = e5;
            lineNumberReader = null;
            ab.e("MicroMsg.Util", "getRunningAppProcessesByPs fail, ex = %s", e32.getMessage());
            if (lineNumberReader != null) {
            }
            ab.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
            AppMethodBeat.o(52429);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
            if (lineNumberReader != null) {
            }
            AppMethodBeat.o(52429);
            throw th;
        }
        ab.i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.o(52429);
        return arrayList;
    }

    public static boolean isEqual(String str, String str2) {
        AppMethodBeat.i(52430);
        if (isNullOrNil(str) && isNullOrNil(str2)) {
            AppMethodBeat.o(52430);
            return true;
        } else if (isNullOrNil(str) && !isNullOrNil(str2)) {
            AppMethodBeat.o(52430);
            return false;
        } else if (isNullOrNil(str) || !isNullOrNil(str2)) {
            boolean equals = str.equals(str2);
            AppMethodBeat.o(52430);
            return equals;
        } else {
            AppMethodBeat.o(52430);
            return false;
        }
    }

    public static boolean gW(int i, int i2) {
        return i == i2;
    }

    public static boolean af(long j, long j2) {
        return j == j2;
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(52431);
        boolean equals = Arrays.equals(bArr, bArr2);
        AppMethodBeat.o(52431);
        return equals;
    }

    public static boolean C(Object obj, Object obj2) {
        AppMethodBeat.i(52432);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.o(52432);
            return true;
        }
        AppMethodBeat.o(52432);
        return false;
    }

    public static int gX(Context context) {
        AppMethodBeat.i(52433);
        if (context == null) {
            ab.i("MicroMsg.Util", "getSelfMemInMB context is null.");
            AppMethodBeat.o(52433);
            return -1;
        }
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            AppMethodBeat.o(52433);
            return 0;
        }
        int totalPss = processMemoryInfo[0].getTotalPss() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        AppMethodBeat.o(52433);
        return totalPss;
    }

    public static String t(String str, Object... objArr) {
        AppMethodBeat.i(52434);
        try {
            str = String.format(str, objArr);
        } catch (Exception e) {
            ab.i("MicroMsg.Util", "error safeFormatString %s", e.getMessage());
        }
        AppMethodBeat.o(52434);
        return str;
    }

    public static Intent I(Context context, Intent intent) {
        AppMethodBeat.i(52435);
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            AppMethodBeat.o(52435);
            return null;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        ab.d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        ComponentName componentName = new ComponentName(r1, r0);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        AppMethodBeat.o(52435);
        return intent2;
    }

    public static int bS(String str, int i) {
        AppMethodBeat.i(52436);
        try {
            i = Color.parseColor(str);
            AppMethodBeat.o(52436);
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.Util", e, "colorString:%s", str);
            AppMethodBeat.o(52436);
        }
        return i;
    }

    public static int mA(long j) {
        AppMethodBeat.i(52437);
        int round = Math.round(((float) j) / 1000.0f);
        AppMethodBeat.o(52437);
        return round;
    }

    public static String F(double d) {
        AppMethodBeat.i(52438);
        String format = String.format("%.2f", new Object[]{Double.valueOf(d)});
        AppMethodBeat.o(52438);
        return format;
    }

    public static String ga(long j) {
        AppMethodBeat.i(52312);
        String c;
        if ((j >> 30) > 0) {
            c = c(j, 10.0d);
            AppMethodBeat.o(52312);
            return c;
        } else if ((j >> 20) > 0) {
            c = b(j, 10.0d);
            AppMethodBeat.o(52312);
            return c;
        } else if ((j >> 9) > 0) {
            c = (((double) Math.round((((double) j) * 10.0d) / 1024.0d)) / 10.0d) + " KB";
            AppMethodBeat.o(52312);
            return c;
        } else {
            c = j + " B";
            AppMethodBeat.o(52312);
            return c;
        }
    }

    public static void k(String str, Context context) {
        AppMethodBeat.i(52319);
        boolean z = (str == null || str.equals("")) ? false : true;
        Assert.assertTrue(z);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
        AppMethodBeat.o(52319);
    }

    public static long dpB() {
        AppMethodBeat.i(52327);
        long currentTimeMillis = (System.currentTimeMillis() / 86400000) * 86400000;
        AppMethodBeat.o(52327);
        return currentTimeMillis;
    }
}
