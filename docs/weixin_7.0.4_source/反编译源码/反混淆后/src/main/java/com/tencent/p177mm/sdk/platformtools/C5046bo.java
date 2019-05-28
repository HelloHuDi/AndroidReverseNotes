package com.tencent.p177mm.sdk.platformtools;

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
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p178a.C1178g;
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

/* renamed from: com.tencent.mm.sdk.platformtools.bo */
public final class C5046bo {
    private static final TimeZone GMT = TimeZone.getTimeZone("GMT");
    public static final long[] gjH = new long[]{300, 200, 300, 200};
    private static final char[] iRk = new char[]{'<', '>', '\"', '\'', '&', 13, 10, ' ', 9};
    private static final String[] iRl = new String[]{"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;"};
    private static final long[] xCg = new long[]{300, 50, 300, 50};
    private static final BigInteger xCh = BigInteger.ONE.shiftLeft(64);

    /* renamed from: com.tencent.mm.sdk.platformtools.bo$1 */
    static class C50441 implements OnTouchListener {
        C50441() {
        }

        public final boolean onTouch(final View view, MotionEvent motionEvent) {
            AppMethodBeat.m2504i(52290);
            switch (motionEvent.getAction()) {
                case 0:
                    view.setPressed(true);
                    break;
                case 1:
                case 3:
                case 4:
                    view.post(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(52289);
                            view.setPressed(false);
                            AppMethodBeat.m2505o(52289);
                        }
                    });
                    break;
            }
            AppMethodBeat.m2505o(52290);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.sdk.platformtools.bo$a */
    public static class C5045a {
        private Context context;

        public C5045a(Context context) {
            this.context = context;
        }

        public final String toString() {
            AppMethodBeat.m2504i(52291);
            String gY = C5045a.m7497gY(this.context);
            AppMethodBeat.m2505o(52291);
            return gY;
        }

        /* renamed from: gY */
        private static String m7497gY(Context context) {
            AppMethodBeat.m2504i(52292);
            if (context == null) {
                AppMethodBeat.m2505o(52292);
                return null;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String packageName = context.getPackageName();
            if (activityManager == null || C5046bo.isNullOrNil(packageName)) {
                AppMethodBeat.m2505o(52292);
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
                AppMethodBeat.m2505o(52292);
                return stringBuffer;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                stringBuffer = "";
                AppMethodBeat.m2505o(52292);
                return stringBuffer;
            }
        }
    }

    /* renamed from: vA */
    public static String m7586vA(String str) {
        AppMethodBeat.m2504i(52293);
        if (str != null) {
            str = str.replace("\\[", "[[]").replace("%", "").replace("\\^", "").replace("'", "").replace("\\{", "").replace("\\}", "").replace("\"", "");
        }
        AppMethodBeat.m2505o(52293);
        return str;
    }

    public static String amS(String str) {
        AppMethodBeat.m2504i(52294);
        if (str != null) {
            str = str.replace("../", "");
        }
        AppMethodBeat.m2505o(52294);
        return str;
    }

    /* renamed from: c */
    public static String m7536c(List<String> list, String str) {
        AppMethodBeat.m2504i(52295);
        String str2;
        if (list == null) {
            str2 = "";
            AppMethodBeat.m2505o(52295);
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
                AppMethodBeat.m2505o(52295);
                return str2;
            }
        }
    }

    /* renamed from: hT */
    public static List<String> m7569hT(String str, String str2) {
        AppMethodBeat.m2504i(52296);
        if (TextUtils.isEmpty(str)) {
            List list = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(52296);
            return list;
        }
        String[] split = str.split(str2);
        List<String> list2;
        if (split == null) {
            list2 = Collections.EMPTY_LIST;
            AppMethodBeat.m2505o(52296);
            return list2;
        }
        list2 = Arrays.asList(split);
        AppMethodBeat.m2505o(52296);
        return list2;
    }

    /* renamed from: P */
    public static ArrayList<String> m7508P(String[] strArr) {
        AppMethodBeat.m2504i(52297);
        if (strArr == null || strArr.length == 0) {
            AppMethodBeat.m2505o(52297);
            return null;
        }
        ArrayList<String> arrayList = new ArrayList();
        for (Object add : strArr) {
            arrayList.add(add);
        }
        AppMethodBeat.m2505o(52297);
        return arrayList;
    }

    /* renamed from: ej */
    public static String[] m7547ej(List<String> list) {
        AppMethodBeat.m2504i(52298);
        String[] strArr = new String[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                strArr[i2] = (String) list.get(i2);
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(52298);
                return strArr;
            }
        }
    }

    /* renamed from: gV */
    public static int m7560gV(int i, int i2) {
        AppMethodBeat.m2504i(52299);
        Assert.assertTrue(i > i2);
        int nextInt = new Random(System.currentTimeMillis()).nextInt((i - i2) + 1) + i2;
        AppMethodBeat.m2505o(52299);
        return nextInt;
    }

    public static byte[] dpz() {
        byte[] bArr;
        AppMethodBeat.m2504i(52300);
        try {
            FileInputStream fileInputStream = new FileInputStream("/dev/urandom");
            bArr = new byte[16];
            int read = fileInputStream.read(bArr);
            fileInputStream.close();
            if (read == 16) {
                AppMethodBeat.m2505o(52300);
                return bArr;
            }
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        bArr = C1178g.m2592y((UUID.randomUUID().toString() + System.currentTimeMillis()).getBytes());
        AppMethodBeat.m2505o(52300);
        return bArr;
    }

    public static String dpA() {
        int i;
        AppMethodBeat.m2504i(52301);
        TimeZone timeZone = TimeZone.getDefault();
        int rawOffset = timeZone.getRawOffset() / 1000;
        if (timeZone.useDaylightTime() && timeZone.inDaylightTime(new Date(System.currentTimeMillis()))) {
            i = 1;
        } else {
            i = 0;
        }
        String format = String.format("%.2f", new Object[]{Double.valueOf((((double) rawOffset) / 3600.0d) + ((double) i))});
        AppMethodBeat.m2505o(52301);
        return format;
    }

    /* renamed from: mw */
    public static String m7578mw(long j) {
        AppMethodBeat.m2504i(52302);
        String format = new SimpleDateFormat("HH:mm:ss").format(new java.util.Date(j));
        AppMethodBeat.m2505o(52302);
        return format;
    }

    /* renamed from: mx */
    public static String m7579mx(long j) {
        AppMethodBeat.m2504i(52303);
        String format = new SimpleDateFormat("[yy-MM-dd HH:mm:ss]").format(new java.util.Date(1000 * j));
        AppMethodBeat.m2505o(52303);
        return format;
    }

    /* renamed from: y */
    public static boolean m7587y(char c) {
        AppMethodBeat.m2504i(52304);
        UnicodeBlock of = UnicodeBlock.of(c);
        if (of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            AppMethodBeat.m2505o(52304);
            return true;
        }
        AppMethodBeat.m2505o(52304);
        return false;
    }

    public static boolean amT(String str) {
        AppMethodBeat.m2504i(52305);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52305);
            return false;
        }
        boolean find = Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(str).find();
        AppMethodBeat.m2505o(52305);
        return find;
    }

    /* renamed from: z */
    public static boolean m7590z(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    public static boolean amU(String str) {
        AppMethodBeat.m2504i(52306);
        for (char c : str.toCharArray()) {
            if ((c < 'a' || c > 'z') && (c < 'A' || c > 'Z')) {
                AppMethodBeat.m2505o(52306);
                return false;
            }
        }
        AppMethodBeat.m2505o(52306);
        return true;
    }

    /* renamed from: A */
    public static boolean m7498A(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean amV(String str) {
        AppMethodBeat.m2504i(52307);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(52307);
            return false;
        }
        try {
            long longValue = Long.valueOf(str.trim()).longValue();
            if (longValue <= 0 || longValue > 4294967295L) {
                AppMethodBeat.m2505o(52307);
                return false;
            }
            AppMethodBeat.m2505o(52307);
            return true;
        } catch (NumberFormatException e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            AppMethodBeat.m2505o(52307);
            return false;
        }
    }

    public static boolean amW(String str) {
        AppMethodBeat.m2504i(52308);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(52308);
            return false;
        }
        boolean matches = str.trim().matches("^[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w\\.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z\\.]*[a-zA-Z]$");
        AppMethodBeat.m2505o(52308);
        return matches;
    }

    /* renamed from: an */
    public static byte[] m7522an(Bitmap bitmap) {
        AppMethodBeat.m2504i(52309);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
        C4990ab.m7417i("MicroMsg.Util", "recycle bitmap:%s", bitmap);
        bitmap.recycle();
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(52309);
        return toByteArray;
    }

    public static boolean amX(String str) {
        AppMethodBeat.m2504i(52310);
        if (str == null) {
            AppMethodBeat.m2505o(52310);
            return false;
        }
        String trim = str.trim();
        if (trim.length() < 6 || trim.length() > 20) {
            AppMethodBeat.m2505o(52310);
            return false;
        } else if (C5046bo.m7590z(trim.charAt(0))) {
            int i = 0;
            while (i < trim.length()) {
                char charAt = trim.charAt(i);
                if (C5046bo.m7590z(charAt) || C5046bo.m7498A(charAt) || charAt == '-' || charAt == '_') {
                    i++;
                } else {
                    AppMethodBeat.m2505o(52310);
                    return false;
                }
            }
            AppMethodBeat.m2505o(52310);
            return true;
        } else {
            AppMethodBeat.m2505o(52310);
            return false;
        }
    }

    public static boolean amY(String str) {
        AppMethodBeat.m2504i(52311);
        if (str == null) {
            AppMethodBeat.m2505o(52311);
            return false;
        } else if (str.length() < 8) {
            AppMethodBeat.m2505o(52311);
            return false;
        } else {
            try {
                Long.parseLong(str);
                AppMethodBeat.m2505o(52311);
                return false;
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(52311);
                return true;
            }
        }
    }

    /* renamed from: b */
    public static String m7526b(long j, double d) {
        AppMethodBeat.m2504i(52313);
        String str = (((double) Math.round((((double) j) * d) / 1048576.0d)) / d) + " MB";
        AppMethodBeat.m2505o(52313);
        return str;
    }

    /* renamed from: my */
    public static String m7580my(long j) {
        AppMethodBeat.m2504i(52314);
        String b = C5046bo.m7526b(j, 10.0d);
        AppMethodBeat.m2505o(52314);
        return b;
    }

    /* renamed from: c */
    public static String m7535c(long j, double d) {
        AppMethodBeat.m2504i(52315);
        String str = (((double) Math.round((((double) j) * d) / 1.073741824E9d)) / d) + " GB";
        AppMethodBeat.m2505o(52315);
        return str;
    }

    /* renamed from: bZ */
    public static String m7531bZ(byte[] bArr) {
        AppMethodBeat.m2504i(52316);
        String W = C5046bo.m7511W(bArr, 0);
        AppMethodBeat.m2505o(52316);
        return W;
    }

    /* renamed from: W */
    public static String m7511W(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(52317);
        String str;
        if (bArr == null) {
            str = "(null)";
            AppMethodBeat.m2505o(52317);
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
                AppMethodBeat.m2505o(52317);
                return str;
            }
        }
    }

    /* renamed from: ca */
    public static String m7539ca(byte[] bArr) {
        AppMethodBeat.m2504i(52318);
        String str;
        if (bArr == null) {
            str = "(null)";
            AppMethodBeat.m2505o(52318);
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
        AppMethodBeat.m2505o(52318);
        return str;
    }

    static {
        AppMethodBeat.m2504i(52439);
        AppMethodBeat.m2505o(52439);
    }

    /* renamed from: z */
    public static void m7589z(Context context, boolean z) {
        AppMethodBeat.m2504i(52320);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            C4990ab.m7420w("MicroMsg.Util", "shake:vibrator is null!");
            AppMethodBeat.m2505o(52320);
        } else if (z) {
            vibrator.vibrate(gjH, -1);
            AppMethodBeat.m2505o(52320);
        } else {
            vibrator.cancel();
            AppMethodBeat.m2505o(52320);
        }
    }

    /* renamed from: gM */
    public static void m7551gM(Context context) {
        AppMethodBeat.m2504i(52321);
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        if (vibrator == null) {
            AppMethodBeat.m2505o(52321);
            return;
        }
        vibrator.vibrate(xCg, -1);
        AppMethodBeat.m2505o(52321);
    }

    public static long anT() {
        AppMethodBeat.m2504i(52322);
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        AppMethodBeat.m2505o(52322);
        return currentTimeMillis;
    }

    /* renamed from: mK */
    public static String m7577mK(int i) {
        AppMethodBeat.m2504i(52323);
        String format = String.format("%d:%02d", new Object[]{Long.valueOf(((long) i) / 60), Long.valueOf(((long) i) % 60)});
        AppMethodBeat.m2505o(52323);
        return format;
    }

    /* renamed from: fp */
    public static long m7549fp(long j) {
        AppMethodBeat.m2504i(52324);
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j;
        AppMethodBeat.m2505o(52324);
        return currentTimeMillis;
    }

    /* renamed from: az */
    public static long m7525az(long j) {
        AppMethodBeat.m2504i(52325);
        long elapsedRealtime = SystemClock.elapsedRealtime() - j;
        AppMethodBeat.m2505o(52325);
        return elapsedRealtime;
    }

    /* renamed from: yz */
    public static long m7588yz() {
        AppMethodBeat.m2504i(52326);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AppMethodBeat.m2505o(52326);
        return elapsedRealtime;
    }

    public static long dpC() {
        AppMethodBeat.m2504i(52328);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.m2505o(52328);
        return timeInMillis;
    }

    /* renamed from: L */
    public static boolean m7505L(long j, long j2) {
        AppMethodBeat.m2504i(52329);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j2);
        if (instance.get(1) == instance2.get(1) && instance.get(5) == instance2.get(5) && instance.get(2) == instance2.get(2)) {
            AppMethodBeat.m2505o(52329);
            return true;
        }
        AppMethodBeat.m2505o(52329);
        return false;
    }

    /* renamed from: gN */
    public static String m7552gN(Context context) {
        AppMethodBeat.m2504i(52330);
        if (context == null) {
            AppMethodBeat.m2505o(52330);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                AppMethodBeat.m2505o(52330);
                return null;
            }
            String deviceId = telephonyManager.getDeviceId();
            if (deviceId == null) {
                AppMethodBeat.m2505o(52330);
                return null;
            }
            deviceId = deviceId.trim();
            AppMethodBeat.m2505o(52330);
            return deviceId;
        } catch (SecurityException e) {
            C4990ab.m7413e("MicroMsg.Util", "summerdeviceid getDeviceId failed, security exception[%s]", e);
            AppMethodBeat.m2505o(52330);
            return null;
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e2, "summerdeviceid", new Object[0]);
            AppMethodBeat.m2505o(52330);
            return null;
        }
    }

    public static long dpD() {
        AppMethodBeat.m2504i(52331);
        try {
            StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
            long availableBlocks;
            if (VERSION.SDK_INT < 18) {
                availableBlocks = ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
                AppMethodBeat.m2505o(52331);
                return availableBlocks;
            }
            availableBlocks = statFs.getAvailableBlocksLong() * statFs.getBlockSizeLong();
            AppMethodBeat.m2505o(52331);
            return availableBlocks;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "getDataAvailableSize exception:%s", e.getMessage());
            AppMethodBeat.m2505o(52331);
            return 0;
        }
    }

    /* renamed from: gO */
    public static long m7553gO(Context context) {
        AppMethodBeat.m2504i(52332);
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager == null) {
            AppMethodBeat.m2505o(52332);
            return 0;
        }
        MemoryInfo memoryInfo = new MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        long j = (memoryInfo.availMem / 1024) / 1024;
        AppMethodBeat.m2505o(52332);
        return j;
    }

    /* renamed from: gP */
    public static String m7554gP(Context context) {
        AppMethodBeat.m2504i(52333);
        if (context == null) {
            AppMethodBeat.m2505o(52333);
            return null;
        }
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                C4990ab.m7412e("MicroMsg.Util", "getLine1Number failed, null tm");
                AppMethodBeat.m2505o(52333);
                return null;
            }
            String line1Number = telephonyManager.getLine1Number();
            AppMethodBeat.m2505o(52333);
            return line1Number;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "getLine1Number failed:%s ", C5007an.m7449l(e));
            AppMethodBeat.m2505o(52333);
            return null;
        }
    }

    /* renamed from: gQ */
    public static String m7555gQ(Context context) {
        AppMethodBeat.m2504i(52334);
        String str;
        if (context == null) {
            C4990ab.m7420w("MicroMsg.Util", "getSimCountryCode context is null.");
            str = "";
            AppMethodBeat.m2505o(52334);
            return str;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            str = telephonyManager.getSimCountryIso();
            if (C5046bo.isNullOrNil(str)) {
                str = "";
                AppMethodBeat.m2505o(52334);
                return str;
            }
            str = str.toUpperCase().trim();
            AppMethodBeat.m2505o(52334);
            return str;
        }
        str = "";
        AppMethodBeat.m2505o(52334);
        return str;
    }

    /* renamed from: cv */
    public static boolean m7544cv(Context context) {
        AppMethodBeat.m2504i(52335);
        String name = context.getClass().getName();
        String cc = C5046bo.m7542cc(context);
        C4990ab.m7410d("MicroMsg.Util", "top activity=" + cc + ", context=" + name);
        boolean equalsIgnoreCase = cc.equalsIgnoreCase(name);
        AppMethodBeat.m2505o(52335);
        return equalsIgnoreCase;
    }

    /* renamed from: bH */
    public static boolean m7528bH(Context context, String str) {
        AppMethodBeat.m2504i(52336);
        for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(BaseClientBuilder.API_PRIORITY_OTHER)) {
            if (runningServiceInfo != null && runningServiceInfo.service != null && runningServiceInfo.service.getClassName().toString().equals(str)) {
                C4990ab.m7420w("MicroMsg.Util", "service " + str + " is running");
                AppMethodBeat.m2505o(52336);
                return true;
            }
        }
        C4990ab.m7420w("MicroMsg.Util", "service " + str + " is not running");
        AppMethodBeat.m2505o(52336);
        return false;
    }

    /* renamed from: bI */
    public static boolean m7529bI(Context context, String str) {
        AppMethodBeat.m2504i(52337);
        try {
            if (str.equals("com.tencent.mm") || str.startsWith("com.tencent.mm:") || VERSION.SDK_INT < 21) {
                C4990ab.m7417i("MicroMsg.Util", "isProcessRunning, use ActivityManager. process = %s", str);
                List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses == null) {
                    AppMethodBeat.m2505o(52337);
                    return false;
                }
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo != null && runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                        C4990ab.m7420w("MicroMsg.Util", "process " + str + " is running");
                        AppMethodBeat.m2505o(52337);
                        return true;
                    }
                }
            } else {
                C4990ab.m7417i("MicroMsg.Util", "isProcessRunning, use ps command. process = %s", str);
                for (String str2 : C5046bo.dpI()) {
                    C4990ab.m7411d("MicroMsg.Util", "isProcessRunning, process command line = %s", str2);
                    if (str2 != null && str2.contains(str)) {
                        String[] split = str2.split("\\s+");
                        for (Object equals : split) {
                            if (str.equals(equals)) {
                                C4990ab.m7417i("MicroMsg.Util", "process %s is running", str);
                                AppMethodBeat.m2505o(52337);
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            C4990ab.m7420w("MicroMsg.Util", "process " + str + " is not running");
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
        }
        AppMethodBeat.m2505o(52337);
        return false;
    }

    /* renamed from: cc */
    public static String m7542cc(Context context) {
        AppMethodBeat.m2504i(52338);
        String className;
        try {
            className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            AppMethodBeat.m2505o(52338);
            return className;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            className = "(null)";
            AppMethodBeat.m2505o(52338);
            return className;
        }
    }

    /* renamed from: gR */
    public static boolean m7556gR(Context context) {
        AppMethodBeat.m2504i(52339);
        try {
            String className = ((RunningTaskInfo) ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0)).topActivity.getClassName();
            String packageName = context.getPackageName();
            C4990ab.m7410d("MicroMsg.Util", "top activity=" + className + ", context=" + packageName);
            boolean contains = className.contains(packageName);
            AppMethodBeat.m2505o(52339);
            return contains;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            AppMethodBeat.m2505o(52339);
            return false;
        }
    }

    /* renamed from: k */
    public static boolean m7572k(Context context, Intent intent) {
        AppMethodBeat.m2504i(52340);
        List queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        if (queryIntentActivities == null || queryIntentActivities.size() <= 0) {
            AppMethodBeat.m2505o(52340);
            return false;
        }
        AppMethodBeat.m2505o(52340);
        return true;
    }

    /* renamed from: H */
    public static List<ResolveInfo> m7502H(Context context, Intent intent) {
        AppMethodBeat.m2504i(52341);
        if (context == null || intent == null) {
            AppMethodBeat.m2505o(52341);
            return null;
        }
        List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
        AppMethodBeat.m2505o(52341);
        return queryIntentActivities;
    }

    /* renamed from: cD */
    public static String m7537cD(Object obj) {
        AppMethodBeat.m2504i(52342);
        String obj2;
        if (obj != null) {
            obj2 = obj.toString();
            AppMethodBeat.m2505o(52342);
            return obj2;
        }
        obj2 = BuildConfig.COMMAND;
        AppMethodBeat.m2505o(52342);
        return obj2;
    }

    /* renamed from: h */
    public static int m7567h(Integer num) {
        AppMethodBeat.m2504i(52343);
        if (num == null) {
            AppMethodBeat.m2505o(52343);
            return 0;
        }
        int intValue = num.intValue();
        AppMethodBeat.m2505o(52343);
        return intValue;
    }

    /* renamed from: c */
    public static long m7534c(Long l) {
        AppMethodBeat.m2504i(52344);
        if (l == null) {
            AppMethodBeat.m2505o(52344);
            return 0;
        }
        long longValue = l.longValue();
        AppMethodBeat.m2505o(52344);
        return longValue;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: d */
    public static boolean m7545d(Boolean bool) {
        AppMethodBeat.m2504i(52345);
        if (bool == null) {
            AppMethodBeat.m2505o(52345);
            return true;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(52345);
        return booleanValue;
    }

    /* renamed from: e */
    public static boolean m7546e(Boolean bool) {
        AppMethodBeat.m2504i(52346);
        if (bool == null) {
            AppMethodBeat.m2505o(52346);
            return false;
        }
        boolean booleanValue = bool.booleanValue();
        AppMethodBeat.m2505o(52346);
        return booleanValue;
    }

    /* renamed from: a */
    public static int m7512a(Integer num, int i) {
        AppMethodBeat.m2504i(52347);
        if (num == null) {
            AppMethodBeat.m2505o(52347);
            return i;
        }
        i = num.intValue();
        AppMethodBeat.m2505o(52347);
        return i;
    }

    /* renamed from: l */
    public static byte[] m7575l(byte[] bArr, byte[] bArr2) {
        return bArr == null ? bArr2 : bArr;
    }

    /* renamed from: a */
    public static long m7514a(Long l, long j) {
        AppMethodBeat.m2504i(52348);
        if (l == null) {
            AppMethodBeat.m2505o(52348);
            return j;
        }
        j = l.longValue();
        AppMethodBeat.m2505o(52348);
        return j;
    }

    /* renamed from: a */
    public static boolean m7517a(Boolean bool, boolean z) {
        AppMethodBeat.m2504i(52349);
        if (bool == null) {
            AppMethodBeat.m2505o(52349);
            return z;
        }
        z = bool.booleanValue();
        AppMethodBeat.m2505o(52349);
        return z;
    }

    /* renamed from: bc */
    public static String m7532bc(String str, String str2) {
        return str == null ? str2 : str;
    }

    /* renamed from: g */
    public static int m7550g(Object obj, int i) {
        AppMethodBeat.m2504i(52350);
        if (obj == null) {
            AppMethodBeat.m2505o(52350);
            return i;
        } else if (obj instanceof Integer) {
            i = ((Integer) obj).intValue();
            AppMethodBeat.m2505o(52350);
            return i;
        } else if (obj instanceof Long) {
            i = ((Long) obj).intValue();
            AppMethodBeat.m2505o(52350);
            return i;
        } else {
            AppMethodBeat.m2505o(52350);
            return i;
        }
    }

    /* renamed from: cE */
    public static long m7538cE(Object obj) {
        AppMethodBeat.m2504i(52351);
        if (obj == null) {
            AppMethodBeat.m2505o(52351);
            return 0;
        } else if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            AppMethodBeat.m2505o(52351);
            return longValue;
        } else {
            AppMethodBeat.m2505o(52351);
            return 0;
        }
    }

    /* renamed from: ek */
    public static boolean m7548ek(List list) {
        AppMethodBeat.m2504i(52352);
        if (list == null || list.size() == 0) {
            AppMethodBeat.m2505o(52352);
            return true;
        }
        AppMethodBeat.m2505o(52352);
        return false;
    }

    public static boolean isNullOrNil(String str) {
        AppMethodBeat.m2504i(52353);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(52353);
            return true;
        }
        AppMethodBeat.m2505o(52353);
        return false;
    }

    /* renamed from: ac */
    public static boolean m7519ac(CharSequence charSequence) {
        AppMethodBeat.m2504i(52354);
        if (charSequence == null || charSequence.length() <= 0) {
            AppMethodBeat.m2505o(52354);
            return true;
        }
        AppMethodBeat.m2505o(52354);
        return false;
    }

    /* renamed from: cb */
    public static boolean m7540cb(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            return true;
        }
        return false;
    }

    /* renamed from: Q */
    public static boolean m7510Q(String... strArr) {
        boolean z = false;
        AppMethodBeat.m2504i(52355);
        for (String isNullOrNil : strArr) {
            if (C5046bo.isNullOrNil(isNullOrNil)) {
                z = true;
                break;
            }
        }
        AppMethodBeat.m2505o(52355);
        return z;
    }

    public static int amZ(String str) {
        AppMethodBeat.m2504i(52356);
        if (str == null) {
            AppMethodBeat.m2505o(52356);
            return -1;
        }
        int length = str.length();
        AppMethodBeat.m2505o(52356);
        return length;
    }

    public static int ana(String str) {
        AppMethodBeat.m2504i(52357);
        if (str == null) {
            AppMethodBeat.m2505o(52357);
            return -1;
        }
        int length = str.getBytes(Charset.forName("UTF-8")).length;
        AppMethodBeat.m2505o(52357);
        return length;
    }

    /* renamed from: cc */
    public static int m7541cc(byte[] bArr) {
        if (bArr == null) {
            return -1;
        }
        return bArr.length;
    }

    public static int anb(String str) {
        int i = 0;
        AppMethodBeat.m2504i(52358);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52358);
            return i;
        }
        try {
            i = (int) (new SimpleDateFormat("yyyy-MM-dd").parse(str).getTime() / 1000);
            AppMethodBeat.m2505o(52358);
            return i;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[i]);
            AppMethodBeat.m2505o(52358);
            return i;
        }
    }

    public static int getInt(String str, int i) {
        AppMethodBeat.m2504i(52359);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.decode(str).intValue();
                    AppMethodBeat.m2505o(52359);
                    return i;
                }
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(52359);
            }
        }
        AppMethodBeat.m2505o(52359);
        return i;
    }

    public static long getLong(String str, long j) {
        AppMethodBeat.m2504i(52360);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    j = Long.decode(str).longValue();
                    AppMethodBeat.m2505o(52360);
                    return j;
                }
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(52360);
            }
        }
        AppMethodBeat.m2505o(52360);
        return j;
    }

    /* renamed from: mz */
    public static String m7581mz(long j) {
        AppMethodBeat.m2504i(52361);
        BigInteger valueOf = BigInteger.valueOf(j);
        if (valueOf.signum() < 0) {
            valueOf = valueOf.add(xCh);
        }
        String bigInteger = valueOf.toString();
        AppMethodBeat.m2505o(52361);
        return bigInteger;
    }

    public static boolean getBoolean(String str, boolean z) {
        AppMethodBeat.m2504i(52362);
        if (str == null) {
            try {
                AppMethodBeat.m2505o(52362);
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(52362);
            }
        } else {
            z = Boolean.parseBoolean(str);
            AppMethodBeat.m2505o(52362);
        }
        return z;
    }

    public static float getFloat(String str, float f) {
        AppMethodBeat.m2504i(52363);
        if (str == null) {
            try {
                AppMethodBeat.m2505o(52363);
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(52363);
            }
        } else {
            f = Float.parseFloat(str);
            AppMethodBeat.m2505o(52363);
        }
        return f;
    }

    public static double getDouble(String str, double d) {
        AppMethodBeat.m2504i(52364);
        if (str == null) {
            try {
                AppMethodBeat.m2505o(52364);
            } catch (NumberFormatException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                AppMethodBeat.m2505o(52364);
            }
        } else {
            d = Double.parseDouble(str);
            AppMethodBeat.m2505o(52364);
        }
        return d;
    }

    public static int anc(String str) {
        int i = 0;
        AppMethodBeat.m2504i(52365);
        if (str == null) {
            AppMethodBeat.m2505o(52365);
            return i;
        }
        try {
            i = (int) (Long.decode(str).longValue() & 4294967295L);
            AppMethodBeat.m2505o(52365);
            return i;
        } catch (NumberFormatException e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[i]);
            AppMethodBeat.m2505o(52365);
            return i;
        }
    }

    public static boolean hideVKB(View view) {
        AppMethodBeat.m2504i(52366);
        boolean hideSoftInputFromWindow;
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) view.getContext().getSystemService("input_method");
            if (inputMethodManager == null) {
                AppMethodBeat.m2505o(52366);
                return false;
            }
            hideSoftInputFromWindow = inputMethodManager.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
            C4990ab.m7419v("MicroMsg.Util", "hide VKB result %B", Boolean.valueOf(hideSoftInputFromWindow));
            AppMethodBeat.m2505o(52366);
            return hideSoftInputFromWindow;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            C4990ab.m7413e("MicroMsg.Util", "hide VKB exception %s", e);
            hideSoftInputFromWindow = false;
        }
    }

    public static String and(String str) {
        AppMethodBeat.m2504i(52367);
        if (str == null) {
            str = "";
        }
        String x;
        if (str.length() <= 16) {
            x = C1178g.m2591x(str.getBytes());
            AppMethodBeat.m2505o(52367);
            return x;
        }
        x = C1178g.m2591x(str.substring(0, 16).getBytes());
        AppMethodBeat.m2505o(52367);
        return x;
    }

    public static String ane(String str) {
        AppMethodBeat.m2504i(138964);
        String x = C1178g.m2591x(str.getBytes());
        AppMethodBeat.m2505o(138964);
        return x;
    }

    /* renamed from: cd */
    public static String m7543cd(byte[] bArr) {
        AppMethodBeat.m2504i(52369);
        StringBuilder stringBuilder = new StringBuilder("");
        if (bArr != null) {
            for (int i = 0; i < bArr.length; i++) {
                stringBuilder.append(String.format("%02x", new Object[]{Integer.valueOf(bArr[i] & 255)}));
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(52369);
        return stringBuilder2;
    }

    public static byte[] anf(String str) {
        AppMethodBeat.m2504i(52370);
        byte[] bArr;
        if (str == null || str.length() <= 0) {
            bArr = new byte[0];
            AppMethodBeat.m2505o(52370);
            return bArr;
        }
        try {
            bArr = new byte[(str.length() / 2)];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) (Integer.parseInt(str.substring(i * 2, (i * 2) + 2), 16) & 255);
            }
            AppMethodBeat.m2505o(52370);
            return bArr;
        } catch (NumberFormatException e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            bArr = new byte[0];
            AppMethodBeat.m2505o(52370);
            return bArr;
        }
    }

    public static int[] ang(String str) {
        int i = 0;
        AppMethodBeat.m2504i(52371);
        if (str == null) {
            AppMethodBeat.m2505o(52371);
            return null;
        }
        String[] split = str.split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            if (str2 != null && str2.length() > 0) {
                try {
                    arrayList.add(Integer.valueOf(Integer.valueOf(str2).intValue()));
                } catch (Exception e) {
                    C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    C4990ab.m7412e("MicroMsg.Util", "invalid port num, ignore");
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
                AppMethodBeat.m2505o(52371);
                return iArr;
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:15:0x0061=Splitter:B:15:0x0061, B:28:0x00ae=Splitter:B:28:0x00ae} */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006f A:{SYNTHETIC, Splitter:B:18:0x006f} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bc A:{SYNTHETIC, Splitter:B:31:0x00bc} */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00cc A:{SYNTHETIC, Splitter:B:39:0x00cc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hU */
    public static int m7570hU(String str, String str2) {
        Throwable e;
        AppMethodBeat.m2504i(52372);
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
                            C4990ab.m7412e("MicroMsg.Util", "close zip stream failed.");
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e = e3;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                        if (zipInputStream != null) {
                        }
                        AppMethodBeat.m2505o(52372);
                        return -1;
                    } catch (Throwable th) {
                        e = th;
                        if (zipInputStream != null) {
                        }
                        AppMethodBeat.m2505o(52372);
                        throw e;
                    }
                } catch (IOException e4) {
                    e = e4;
                    C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    if (zipInputStream != null) {
                    }
                    AppMethodBeat.m2505o(52372);
                    return -2;
                }
            }
            zipInputStream.close();
            AppMethodBeat.m2505o(52372);
            return 0;
        } catch (FileNotFoundException e5) {
            e = e5;
            zipInputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e6) {
                    C4990ab.m7412e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            AppMethodBeat.m2505o(52372);
            return -1;
        } catch (IOException e7) {
            e = e7;
            zipInputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e8) {
                    C4990ab.m7412e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            AppMethodBeat.m2505o(52372);
            return -2;
        } catch (Throwable th2) {
            e = th2;
            zipInputStream = null;
            if (zipInputStream != null) {
                try {
                    zipInputStream.close();
                } catch (IOException e9) {
                    C4990ab.m7412e("MicroMsg.Util", "close zip stream failed.");
                }
            }
            AppMethodBeat.m2505o(52372);
            throw e;
        }
    }

    public static final String anh(String str) {
        AppMethodBeat.m2504i(52373);
        if (C5046bo.isNullOrNil(str)) {
            str = "";
            AppMethodBeat.m2505o(52373);
            return str;
        }
        try {
            str = new URL(str).getHost();
            AppMethodBeat.m2505o(52373);
            return str;
        } catch (MalformedURLException e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.Util", "get host error");
            AppMethodBeat.m2505o(52373);
            return str;
        }
    }

    /* renamed from: M */
    public static boolean m7506M(Context context, String str) {
        AppMethodBeat.m2504i(52374);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
        if (C5046bo.m7572k(context, intent)) {
            context.startActivity(intent);
            AppMethodBeat.m2505o(52374);
            return true;
        }
        C4990ab.m7412e("MicroMsg.Util", "jump to url failed, ".concat(String.valueOf(str)));
        AppMethodBeat.m2505o(52374);
        return false;
    }

    public static String ani(String str) {
        AppMethodBeat.m2504i(52375);
        String str2;
        if (str == null) {
            str2 = "";
            AppMethodBeat.m2505o(52375);
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
        AppMethodBeat.m2505o(52375);
        return str2;
    }

    public static String anj(String str) {
        AppMethodBeat.m2504i(52376);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(52376);
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
                    i2 = C5046bo.m7513a(cArr, i3, (i5 - i3) - 1);
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
            AppMethodBeat.m2505o(52376);
            return str;
        } else {
            AppMethodBeat.m2505o(52376);
            return str;
        }
    }

    /* renamed from: a */
    private static int m7513a(char[] cArr, int i, int i2) {
        int i3 = 0;
        AppMethodBeat.m2504i(52377);
        if (i2 <= 0) {
            AppMethodBeat.m2505o(52377);
        } else if (cArr[i] != '#') {
            String str = new String(cArr, i, i2);
            AppMethodBeat.m2505o(52377);
        } else if (i2 <= 1 || !(cArr[i + 1] == 'x' || cArr[i + 1] == 'X')) {
            try {
                i3 = Integer.parseInt(new String(cArr, i + 1, i2 - 1), 10);
                AppMethodBeat.m2505o(52377);
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(52377);
            }
        } else {
            try {
                i3 = Integer.parseInt(new String(cArr, i + 2, i2 - 2), 16);
                AppMethodBeat.m2505o(52377);
            } catch (NumberFormatException e2) {
                AppMethodBeat.m2505o(52377);
            }
        }
        return i3;
    }

    /* renamed from: a */
    public static String m7516a(LinkedHashMap<String, String> linkedHashMap) {
        AppMethodBeat.m2504i(52378);
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
        AppMethodBeat.m2505o(52378);
        return stringBuilder2;
    }

    public static int ank(String str) {
        AppMethodBeat.m2504i(52379);
        int i = 0;
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
            if (str != null) {
                C4990ab.m7412e("MicroMsg.Util", "parserInt error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.m2505o(52379);
        return i;
    }

    public static long anl(String str) {
        AppMethodBeat.m2504i(52380);
        long j = 0;
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
            if (str != null) {
                C4990ab.m7412e("MicroMsg.Util", "parseLong error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.m2505o(52380);
        return j;
    }

    public static double anm(String str) {
        AppMethodBeat.m2504i(52381);
        double d = 0.0d;
        try {
            d = Double.parseDouble(str);
        } catch (Exception e) {
            if (str != null) {
                C4990ab.m7412e("MicroMsg.Util", "parseDouble error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.m2505o(52381);
        return d;
    }

    public static float ann(String str) {
        AppMethodBeat.m2504i(52382);
        float f = 0.0f;
        try {
            f = Float.parseFloat(str);
        } catch (Exception e) {
            if (str != null) {
                C4990ab.m7412e("MicroMsg.Util", "parseFloat error ".concat(String.valueOf(str)));
            }
        }
        AppMethodBeat.m2505o(52382);
        return f;
    }

    public static boolean deleteFile(String str) {
        AppMethodBeat.m2504i(52383);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52383);
            return false;
        }
        File file = new File(str);
        if (!file.exists()) {
            AppMethodBeat.m2505o(52383);
            return true;
        } else if (file.isDirectory()) {
            AppMethodBeat.m2505o(52383);
            return false;
        } else {
            boolean delete = file.delete();
            AppMethodBeat.m2505o(52383);
            return delete;
        }
    }

    /* renamed from: o */
    public static void m7583o(String str, String str2, long j) {
        AppMethodBeat.m2504i(52384);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52384);
            return;
        }
        File file = new File(str);
        if (file.exists() && file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles == null || listFiles.length == 0) {
                AppMethodBeat.m2505o(52384);
                return;
            }
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.getName().startsWith(str2) && (System.currentTimeMillis() - file2.lastModified()) - j >= 0) {
                    file2.delete();
                }
            }
            AppMethodBeat.m2505o(52384);
            return;
        }
        AppMethodBeat.m2505o(52384);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c2 A:{SYNTHETIC, Splitter:B:37:0x00c2} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a9 A:{SYNTHETIC, Splitter:B:29:0x00a9} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFromFile(String str) {
        Throwable e;
        AppMethodBeat.m2504i(52385);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7420w("MicroMsg.Util", "readFromFile error, path is null or empty");
            AppMethodBeat.m2505o(52385);
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
                        C4990ab.m7421w("MicroMsg.Util", "readFromFile error, size is not equal, path = %s, file length is %d, count is %d", str, Integer.valueOf(length), Integer.valueOf(fileInputStream.read(bArr)));
                        try {
                            fileInputStream.close();
                        } catch (IOException e2) {
                            C4990ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                        }
                        AppMethodBeat.m2505o(52385);
                        return null;
                    }
                    C4990ab.m7410d("MicroMsg.Util", "readFromFile ok!");
                    try {
                        fileInputStream.close();
                    } catch (IOException e3) {
                        C4990ab.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                    }
                    AppMethodBeat.m2505o(52385);
                    return bArr;
                } catch (Exception e4) {
                    e = e4;
                    try {
                        C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(52385);
                        return null;
                    } catch (Throwable th) {
                        e = th;
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.m2505o(52385);
                        throw e;
                    }
                }
            } catch (Exception e5) {
                e = e5;
                fileInputStream = null;
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e22) {
                        C4990ab.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(52385);
                return null;
            } catch (Throwable th2) {
                e = th2;
                fileInputStream = null;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e32) {
                        C4990ab.printErrStackTrace("MicroMsg.Util", e32, "", new Object[0]);
                    }
                }
                AppMethodBeat.m2505o(52385);
                throw e;
            }
        }
        C4990ab.m7421w("MicroMsg.Util", "readFromFile error, file is not exit, path = %s", str);
        AppMethodBeat.m2505o(52385);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0063 A:{SYNTHETIC, Splitter:B:20:0x0063} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007b A:{SYNTHETIC, Splitter:B:28:0x007b} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: z */
    public static boolean m7591z(String str, byte[] bArr) {
        Throwable e;
        AppMethodBeat.m2504i(52386);
        if (C5046bo.isNullOrNil(str) || C5046bo.m7540cb(bArr)) {
            C4990ab.m7420w("MicroMsg.Util", "write to file error, path is null or empty, or data is empty");
            AppMethodBeat.m2505o(52386);
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
                    C4990ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                }
                C4990ab.m7410d("MicroMsg.Util", "writeToFile ok!");
                AppMethodBeat.m2505o(52386);
                return true;
            } catch (Exception e3) {
                e = e3;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    C4990ab.m7420w("MicroMsg.Util", "write to file error");
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e22) {
                            C4990ab.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                        }
                    }
                    AppMethodBeat.m2505o(52386);
                    return false;
                } catch (Throwable th) {
                    e = th;
                    if (fileOutputStream != null) {
                    }
                    AppMethodBeat.m2505o(52386);
                    throw e;
                }
            }
        } catch (Exception e4) {
            e = e4;
            fileOutputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            C4990ab.m7420w("MicroMsg.Util", "write to file error");
            if (fileOutputStream != null) {
            }
            AppMethodBeat.m2505o(52386);
            return false;
        } catch (Throwable th2) {
            e = th2;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e5) {
                    C4990ab.printErrStackTrace("MicroMsg.Util", e5, "", new Object[0]);
                }
            }
            AppMethodBeat.m2505o(52386);
            throw e;
        }
    }

    /* renamed from: gS */
    public static String m7557gS(Context context) {
        AppMethodBeat.m2504i(52387);
        if (context == null) {
            AppMethodBeat.m2505o(52387);
            return null;
        }
        String l = C5046bo.m7573l(context.getPackageName(), context);
        AppMethodBeat.m2505o(52387);
        return l;
    }

    /* renamed from: l */
    public static String m7573l(String str, Context context) {
        String str2 = null;
        AppMethodBeat.m2504i(52388);
        if (context == null || C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52388);
            return str2;
        }
        try {
            str2 = C1178g.m2591x(context.getPackageManager().getPackageInfo(str, 64).signatures[0].toByteArray());
            AppMethodBeat.m2505o(52388);
            return str2;
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            AppMethodBeat.m2505o(52388);
            return str2;
        }
    }

    /* renamed from: gT */
    public static boolean m7558gT(Context context) {
        AppMethodBeat.m2504i(52389);
        if (Locale.getDefault().getCountry().equalsIgnoreCase("CN")) {
            if (TimeZone.getDefault().getRawOffset() != TimeZone.getTimeZone("GMT+08:00").getRawOffset()) {
                AppMethodBeat.m2505o(52389);
                return true;
            } else if (context == null) {
                C4990ab.m7420w("MicroMsg.Util", "isOverseasUser context is null");
                AppMethodBeat.m2505o(52389);
                return false;
            } else {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    String networkCountryIso = telephonyManager.getNetworkCountryIso();
                    if (!(C5046bo.isNullOrNil(networkCountryIso) || networkCountryIso.contains("cn") || networkCountryIso.contains("CN"))) {
                        AppMethodBeat.m2505o(52389);
                        return true;
                    }
                }
                AppMethodBeat.m2505o(52389);
                return false;
            }
        }
        AppMethodBeat.m2505o(52389);
        return true;
    }

    public static OnTouchListener dpE() {
        AppMethodBeat.m2504i(52390);
        C50441 c50441 = new C50441();
        AppMethodBeat.m2505o(52390);
        return c50441;
    }

    public static byte[] ano(String str) {
        AppMethodBeat.m2504i(52391);
        byte[] anr;
        if (str == null || str.length() == 0) {
            C4990ab.m7412e("MicroMsg.Util", "httpGet, url is null");
            AppMethodBeat.m2505o(52391);
            return null;
        } else if (URLUtil.isDataUrl(str)) {
            anr = C5046bo.anr(str);
            AppMethodBeat.m2505o(52391);
            return anr;
        } else if (URLUtil.isHttpsUrl(str)) {
            anr = C5046bo.anq(str);
            AppMethodBeat.m2505o(52391);
            return anr;
        } else {
            anr = C5046bo.anp(str);
            AppMethodBeat.m2505o(52391);
            return anr;
        }
    }

    private static byte[] anp(String str) {
        AppMethodBeat.m2504i(52392);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            if (httpURLConnection.getResponseCode() != 200) {
                C4990ab.m7413e("MicroMsg.Util", "http get response code = %d", Integer.valueOf(httpURLConnection.getResponseCode()));
                AppMethodBeat.m2505o(52392);
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
            AppMethodBeat.m2505o(52392);
            return toByteArray;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "http download failed : %s", e.getMessage());
            AppMethodBeat.m2505o(52392);
            return null;
        }
    }

    private static byte[] anq(String str) {
        AppMethodBeat.m2504i(52393);
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
            httpsURLConnection.setRequestMethod("GET");
            if (httpsURLConnection.getResponseCode() != 200) {
                C4990ab.m7413e("MicroMsg.Util", "https get response code = %d", Integer.valueOf(httpsURLConnection.getResponseCode()));
                AppMethodBeat.m2505o(52393);
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
            AppMethodBeat.m2505o(52393);
            return toByteArray;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "getHttpsData failed : %s", e.getMessage());
            AppMethodBeat.m2505o(52393);
            return null;
        }
    }

    private static byte[] anr(String str) {
        AppMethodBeat.m2504i(52394);
        try {
            int indexOf = str.indexOf("base64");
            if (indexOf > 0) {
                str = str.substring(indexOf + 7);
            }
            byte[] decode = Base64.decode(str, 0);
            AppMethodBeat.m2505o(52394);
            return decode;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "decode base64 url failed : %s", e.getMessage());
            AppMethodBeat.m2505o(52394);
            return null;
        }
    }

    /* renamed from: ad */
    public static CharSequence m7520ad(CharSequence charSequence) {
        AppMethodBeat.m2504i(52395);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            if (charAt >= '0' && charAt <= '9') {
                stringBuffer.append(charAt);
            }
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(52395);
        return stringBuffer2;
    }

    /* renamed from: PA */
    public static String m7509PA(String str) {
        AppMethodBeat.m2504i(52396);
        String trim = str.replaceAll("[\\.\\-]", "").trim();
        AppMethodBeat.m2505o(52396);
        return trim;
    }

    public static String ans(String str) {
        int i = 0;
        AppMethodBeat.m2504i(52397);
        if (C5046bo.isNullOrNil(str) || str.startsWith("+")) {
            str = "";
            AppMethodBeat.m2505o(52397);
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
            AppMethodBeat.m2505o(52397);
            return str;
        } else {
            AppMethodBeat.m2505o(52397);
            return str;
        }
    }

    public static Boolean ant(String str) {
        AppMethodBeat.m2504i(52398);
        boolean z = Pattern.compile("^[+][0-9]{10,13}$").matcher(str).matches() || Pattern.compile("^1[0-9]{10}$").matcher(str).matches();
        Boolean valueOf = Boolean.valueOf(z);
        AppMethodBeat.m2505o(52398);
        return valueOf;
    }

    /* renamed from: I */
    public static String m7504I(InputStream inputStream) {
        AppMethodBeat.m2504i(52399);
        if (inputStream == null) {
            AppMethodBeat.m2505o(52399);
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
                        C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    }
                }
            }
            inputStream.close();
        } catch (Exception e2) {
            try {
                inputStream.close();
            } catch (IOException e3) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
            }
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e32) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e32, "", new Object[0]);
            }
            AppMethodBeat.m2505o(52399);
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(52399);
        return stringBuffer2;
    }

    public static String anu(String str) {
        AppMethodBeat.m2504i(52400);
        if (str != null && str.length() > 0) {
            int lastIndexOf = str.lastIndexOf("@");
            if (lastIndexOf != -1) {
                str = str.substring(0, lastIndexOf);
                AppMethodBeat.m2505o(52400);
                return str;
            }
        }
        AppMethodBeat.m2505o(52400);
        return str;
    }

    public static String anv(String str) {
        AppMethodBeat.m2504i(52401);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(52401);
            return str2;
        }
        int length = str.length();
        if (length < 4) {
            str2 = "*~".concat(String.valueOf(length));
            AppMethodBeat.m2505o(52401);
            return str2;
        } else if (length < 8) {
            str2 = str.substring(0, 1) + "*" + str.substring(length - 2, length - 1) + "~" + length;
            AppMethodBeat.m2505o(52401);
            return str2;
        } else {
            str2 = str.substring(0, 2) + "*" + str.substring(length - 3, length - 1) + "~" + length;
            AppMethodBeat.m2505o(52401);
            return str2;
        }
    }

    /* renamed from: l */
    public static String m7574l(Throwable th) {
        AppMethodBeat.m2504i(138965);
        String l = C5007an.m7449l(th);
        AppMethodBeat.m2505o(138965);
        return l;
    }

    public static int dpF() {
        AppMethodBeat.m2504i(52403);
        int nextInt = new Random().nextInt();
        AppMethodBeat.m2505o(52403);
        return nextInt;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x007f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static String m7515a(Context context, Uri uri, String str, String[] strArr) {
        Cursor query;
        String string;
        Throwable th;
        Cursor cursor = null;
        AppMethodBeat.m2504i(52404);
        try {
            query = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                        if (columnIndexOrThrow == -1) {
                            C4990ab.m7412e("MicroMsg.Util", "getDataColumn : columnIdx is -1, column with columnName = _data does not exist");
                            query.close();
                            if (query != null) {
                                query.close();
                            }
                            AppMethodBeat.m2505o(52404);
                            return null;
                        }
                        string = query.getString(columnIndexOrThrow);
                        if (query != null) {
                            query.close();
                        }
                        AppMethodBeat.m2505o(52404);
                        return string;
                    }
                } catch (Exception e) {
                    cursor = query;
                } catch (Throwable th2) {
                    th = th2;
                    if (query != null) {
                        query.close();
                    }
                    AppMethodBeat.m2505o(52404);
                    throw th;
                }
            }
            if (query != null) {
                query.close();
            }
            AppMethodBeat.m2505o(52404);
            return null;
        } catch (Exception e2) {
        } catch (Throwable th3) {
            th = th3;
            query = null;
            if (query != null) {
            }
            AppMethodBeat.m2505o(52404);
            throw th;
        }
        try {
            string = uri.getPath();
            if (C1443d.m3068iW(24)) {
                string = string.replace("external_files", "");
            }
            if (cursor != null) {
                cursor.close();
            }
            AppMethodBeat.m2505o(52404);
            return string;
        } catch (Throwable th4) {
            th = th4;
            query = cursor;
            if (query != null) {
            }
            AppMethodBeat.m2505o(52404);
            throw th;
        }
    }

    @TargetApi(19)
    /* renamed from: h */
    public static String m7568h(Context context, Uri uri) {
        Uri uri2 = null;
        AppMethodBeat.m2504i(52405);
        if (context == null || uri == null) {
            C4990ab.m7412e("MicroMsg.Util", "getFilePath : context is null or uri is null");
            AppMethodBeat.m2505o(52405);
            return null;
        }
        String scheme = uri.getScheme();
        String path;
        if (C5046bo.isNullOrNil(scheme)) {
            C4990ab.m7413e("MicroMsg.Util", "input uri error. %s", uri);
            AppMethodBeat.m2505o(52405);
            return null;
        } else if (scheme.equalsIgnoreCase("file")) {
            C4990ab.m7416i("MicroMsg.Util", "getFilePath : scheme is SCHEME_FILE");
            path = uri.getPath();
            AppMethodBeat.m2505o(52405);
            return path;
        } else {
            if (scheme.equalsIgnoreCase(C8741b.CONTENT)) {
                C4990ab.m7416i("MicroMsg.Util", "getFilePath : scheme is SCHEME_CONTENT: " + uri.toString());
                if ("com.google.android.apps.photos.content".equals(uri.getAuthority())) {
                    path = uri.getLastPathSegment();
                    AppMethodBeat.m2505o(52405);
                    return path;
                }
                try {
                    context.grantUriPermission(uri.getAuthority(), uri, 1);
                    scheme = C5046bo.m7515a(context, uri, null, null);
                } catch (SecurityException e) {
                    C4990ab.m7412e("MicroMsg.Util", "getFilePath : exception = ".concat(String.valueOf(e)));
                    scheme = null;
                }
                if (!C5046bo.isNullOrNil(scheme)) {
                    AppMethodBeat.m2505o(52405);
                    return scheme;
                } else if (VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri(context, uri)) {
                    String[] split;
                    if ("com.android.externalstorage.documents".equals(uri.getAuthority())) {
                        split = DocumentsContract.getDocumentId(uri).split(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D);
                        if ("primary".equalsIgnoreCase(split[0])) {
                            path = Environment.getExternalStorageDirectory() + "/" + split[1];
                            AppMethodBeat.m2505o(52405);
                            return path;
                        }
                        AppMethodBeat.m2505o(52405);
                        return null;
                    } else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())) {
                        path = C5046bo.m7515a(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                        AppMethodBeat.m2505o(52405);
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
                        path = C5046bo.m7515a(context, uri2, "_id=?", new String[]{split[1]});
                        AppMethodBeat.m2505o(52405);
                        return path;
                    }
                }
            }
            C4990ab.m7412e("MicroMsg.Util", "unknown scheme");
            AppMethodBeat.m2505o(52405);
            return null;
        }
    }

    /* renamed from: v */
    public static boolean m7585v(Uri uri) {
        AppMethodBeat.m2504i(52406);
        if (uri == null) {
            AppMethodBeat.m2505o(52406);
            return false;
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            boolean anw = C5046bo.anw(uri.getPath());
            AppMethodBeat.m2505o(52406);
            return anw;
        } else {
            AppMethodBeat.m2505o(52406);
            return true;
        }
    }

    public static boolean anw(String str) {
        AppMethodBeat.m2504i(52407);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52407);
            return false;
        }
        try {
            String canonicalPath = new File(str).getCanonicalPath();
            if (canonicalPath.contains("/com.tencent.mm/cache/")) {
                AppMethodBeat.m2505o(52407);
                return true;
            } else if (canonicalPath.contains("/com.tencent.mm/")) {
                AppMethodBeat.m2505o(52407);
                return false;
            } else {
                AppMethodBeat.m2505o(52407);
                return true;
            }
        } catch (IOException e) {
            AppMethodBeat.m2505o(52407);
            return false;
        }
    }

    public static boolean anx(String str) {
        AppMethodBeat.m2504i(52408);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52408);
            return false;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf == -1) {
            AppMethodBeat.m2505o(52408);
            return false;
        }
        boolean any = C5046bo.any(str.substring(lastIndexOf + 1));
        AppMethodBeat.m2505o(52408);
        return any;
    }

    public static boolean any(String str) {
        AppMethodBeat.m2504i(52409);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52409);
            return false;
        }
        String toLowerCase = str.toLowerCase();
        if (toLowerCase.equals("webp") && VERSION.SDK_INT >= 14) {
            AppMethodBeat.m2505o(52409);
            return true;
        } else if (toLowerCase.equals("heic") && VERSION.SDK_INT >= 28) {
            AppMethodBeat.m2505o(52409);
            return true;
        } else if (toLowerCase.equals("jpg") || toLowerCase.equals("gif") || toLowerCase.equals("bmp") || toLowerCase.equals("jpeg") || toLowerCase.equals("png")) {
            AppMethodBeat.m2505o(52409);
            return true;
        } else {
            AppMethodBeat.m2505o(52409);
            return false;
        }
    }

    /* renamed from: gU */
    public static C5045a m7559gU(Context context) {
        AppMethodBeat.m2504i(52410);
        C5045a c5045a = new C5045a(context);
        AppMethodBeat.m2505o(52410);
        return c5045a;
    }

    /* renamed from: gV */
    public static ComponentName m7561gV(Context context) {
        AppMethodBeat.m2504i(52411);
        try {
            List runningTasks = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1);
            if (runningTasks == null || runningTasks.size() <= 0) {
                AppMethodBeat.m2505o(52411);
                return null;
            }
            ComponentName componentName = ((RunningTaskInfo) runningTasks.get(0)).topActivity;
            AppMethodBeat.m2505o(52411);
            return componentName;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "get Top Activity Exception:%s", e.getMessage());
            AppMethodBeat.m2505o(52411);
            return null;
        }
    }

    /* renamed from: gW */
    public static String m7562gW(Context context) {
        AppMethodBeat.m2504i(52412);
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            String str;
            if (VERSION.SDK_INT >= 23) {
                List appTasks = activityManager.getAppTasks();
                if (appTasks == null || appTasks.size() <= 0) {
                    str = "";
                    AppMethodBeat.m2505o(52412);
                    return str;
                }
                Iterator it = appTasks.iterator();
                if (it.hasNext()) {
                    ComponentName componentName = ((AppTask) it.next()).getTaskInfo().topActivity;
                    if (componentName == null) {
                        AppMethodBeat.m2505o(52412);
                        return null;
                    }
                    str = componentName.getClassName();
                    if (str.contains(".")) {
                        str = str.substring(str.lastIndexOf(".") + 1);
                    }
                    AppMethodBeat.m2505o(52412);
                    return str;
                }
                str = "";
                AppMethodBeat.m2505o(52412);
                return str;
            }
            str = ((RunningTaskInfo) activityManager.getRunningTasks(1).get(0)).topActivity.getClassName();
            if (str.contains(".")) {
                str = str.substring(str.lastIndexOf(".") + 1);
            }
            AppMethodBeat.m2505o(52412);
            return str;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.Util", "getTopActivityName Exception:%s stack:%s", e.getMessage(), C5007an.m7449l(e));
        }
    }

    /* renamed from: av */
    public static RunningTaskInfo m7523av(Context context, int i) {
        AppMethodBeat.m2504i(52413);
        for (RunningTaskInfo runningTaskInfo : ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1000)) {
            if (runningTaskInfo.id == i) {
                AppMethodBeat.m2505o(52413);
                return runningTaskInfo;
            }
        }
        AppMethodBeat.m2505o(52413);
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00b2 A:{SYNTHETIC, Splitter:B:44:0x00b2} */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x00bc A:{SYNTHETIC, Splitter:B:50:0x00bc} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aw */
    public static String m7524aw(Context context, int i) {
        Throwable e;
        AppMethodBeat.m2504i(52414);
        String str;
        if (context == null || i <= 0) {
            str = "";
            AppMethodBeat.m2505o(52414);
            return str;
        }
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.pid == i && runningAppProcessInfo.processName != null && !runningAppProcessInfo.processName.equals("")) {
                    str = runningAppProcessInfo.processName;
                    AppMethodBeat.m2505o(52414);
                    return str;
                }
            }
        } catch (Exception e2) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
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
                    AppMethodBeat.m2505o(52414);
                    return str;
                }
                try {
                    fileInputStream.close();
                } catch (Exception e4) {
                }
                str = "";
                AppMethodBeat.m2505o(52414);
                return str;
            } catch (Exception e5) {
                e = e5;
                try {
                    C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    if (fileInputStream != null) {
                    }
                    str = "";
                    AppMethodBeat.m2505o(52414);
                    return str;
                } catch (Throwable th) {
                    e = th;
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.m2505o(52414);
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            fileInputStream = null;
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e7) {
                }
            }
            str = "";
            AppMethodBeat.m2505o(52414);
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
            AppMethodBeat.m2505o(52414);
            throw e;
        }
    }

    public static C5007an dpG() {
        AppMethodBeat.m2504i(52415);
        C5007an c5007an = new C5007an();
        AppMethodBeat.m2505o(52415);
        return c5007an;
    }

    public static long anU() {
        AppMethodBeat.m2504i(138966);
        long currentTimeMillis = System.currentTimeMillis();
        AppMethodBeat.m2505o(138966);
        return currentTimeMillis;
    }

    /* renamed from: gb */
    public static long m7566gb(long j) {
        AppMethodBeat.m2504i(52417);
        long currentTimeMillis = System.currentTimeMillis() - j;
        AppMethodBeat.m2505o(52417);
        return currentTimeMillis;
    }

    public static String convertStreamToString(InputStream inputStream) {
        AppMethodBeat.m2504i(52418);
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
                        C4990ab.printErrStackTrace("MicroMsg.Util", e, "", new Object[0]);
                    }
                }
            } catch (IOException e2) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e2, "", new Object[0]);
                try {
                    inputStream.close();
                } catch (IOException e22) {
                    C4990ab.printErrStackTrace("MicroMsg.Util", e22, "", new Object[0]);
                }
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException e3) {
                    C4990ab.printErrStackTrace("MicroMsg.Util", e3, "", new Object[0]);
                }
                AppMethodBeat.m2505o(52418);
            }
        }
        inputStream.close();
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(52418);
        return stringBuilder2;
    }

    /* renamed from: aC */
    public static String m7518aC(float f) {
        AppMethodBeat.m2504i(52419);
        String format;
        if (f < 1024.0f) {
            format = String.format("%.1fB", new Object[]{Float.valueOf(f)});
            AppMethodBeat.m2505o(52419);
            return format;
        } else if (f < 1048576.0f) {
            format = String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
            AppMethodBeat.m2505o(52419);
            return format;
        } else if (f < 1.07374182E9f) {
            format = String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
            AppMethodBeat.m2505o(52419);
            return format;
        } else {
            format = String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
            AppMethodBeat.m2505o(52419);
            return format;
        }
    }

    public static String anz(String str) {
        AppMethodBeat.m2504i(52420);
        if (str == null) {
            AppMethodBeat.m2505o(52420);
            return null;
        }
        int length = str.length();
        while (length > 0) {
            if (str.charAt(length - 1) == 10 || str.charAt(length - 1) == 13) {
                length--;
            } else {
                str = str.substring(0, length);
                AppMethodBeat.m2505o(52420);
                return str;
            }
        }
        AppMethodBeat.m2505o(52420);
        return str;
    }

    /* renamed from: B */
    public static boolean m7499B(Object obj, Object obj2) {
        boolean z = true;
        AppMethodBeat.m2504i(52421);
        if (obj != obj2 && (obj == null || obj2 == null || !obj.equals(obj2))) {
            z = false;
        }
        AppMethodBeat.m2505o(52421);
        return z;
    }

    /* renamed from: b */
    public static void m7527b(Closeable closeable) {
        AppMethodBeat.m2504i(52422);
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C4990ab.printErrStackTrace("MicroMsg.Util", e, "qualityClose", new Object[0]);
                AppMethodBeat.m2505o(52422);
                return;
            }
        }
        AppMethodBeat.m2505o(52422);
    }

    /* renamed from: Mb */
    public static String m7507Mb(int i) {
        AppMethodBeat.m2504i(52423);
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuffer.append(str.charAt(random.nextInt(62)));
        }
        String stringBuffer2 = stringBuffer.toString();
        AppMethodBeat.m2505o(52423);
        return stringBuffer2;
    }

    /* renamed from: n */
    public static void m7582n(View view, int i, int i2, int i3, int i4) {
        AppMethodBeat.m2504i(52424);
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
        AppMethodBeat.m2505o(52424);
    }

    public static String anA(String str) {
        AppMethodBeat.m2504i(52425);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52425);
            return str;
        }
        str = str.replaceAll("‮", "");
        AppMethodBeat.m2505o(52425);
        return str;
    }

    /* renamed from: bf */
    public static int m7533bf(byte[] bArr) {
        AppMethodBeat.m2504i(52426);
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        int i = wrap.getInt();
        AppMethodBeat.m2505o(52426);
        return i;
    }

    public static final String anB(String str) {
        AppMethodBeat.m2504i(52427);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(52427);
            return null;
        }
        String host = Uri.parse(str).getHost();
        AppMethodBeat.m2505o(52427);
        return host;
    }

    public static boolean dpH() {
        AppMethodBeat.m2504i(52428);
        String property = System.getProperty("java.vm.version");
        if (C5046bo.isNullOrNil(property) || !property.startsWith("2")) {
            AppMethodBeat.m2505o(52428);
            return false;
        }
        AppMethodBeat.m2505o(52428);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x004d A:{SYNTHETIC, Splitter:B:14:0x004d} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d A:{SYNTHETIC, Splitter:B:29:0x009d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static List<String> dpI() {
        Exception e;
        Throwable th;
        AppMethodBeat.m2504i(52429);
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
                        C4990ab.m7413e("MicroMsg.Util", "getRunningAppProcessesByPs fail, ex = %s", e.getMessage());
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e3) {
                                C4990ab.m7413e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                            }
                        }
                        C4990ab.m7417i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
                        AppMethodBeat.m2505o(52429);
                        return arrayList;
                    } catch (Throwable th2) {
                        th = th2;
                        if (lineNumberReader != null) {
                            try {
                                lineNumberReader.close();
                            } catch (Exception e4) {
                                C4990ab.m7413e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e4.getMessage());
                            }
                        }
                        AppMethodBeat.m2505o(52429);
                        throw th;
                    }
                }
            }
            exec.waitFor();
            exec.destroy();
            try {
                lineNumberReader.close();
            } catch (Exception e32) {
                C4990ab.m7413e("MicroMsg.Util", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
            }
        } catch (Exception e5) {
            e32 = e5;
            lineNumberReader = null;
            C4990ab.m7413e("MicroMsg.Util", "getRunningAppProcessesByPs fail, ex = %s", e32.getMessage());
            if (lineNumberReader != null) {
            }
            C4990ab.m7417i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
            AppMethodBeat.m2505o(52429);
            return arrayList;
        } catch (Throwable th3) {
            th = th3;
            lineNumberReader = null;
            if (lineNumberReader != null) {
            }
            AppMethodBeat.m2505o(52429);
            throw th;
        }
        C4990ab.m7417i("MicroMsg.Util", "getRunningAppProcessesByPs, result list size = %d", Integer.valueOf(arrayList.size()));
        AppMethodBeat.m2505o(52429);
        return arrayList;
    }

    public static boolean isEqual(String str, String str2) {
        AppMethodBeat.m2504i(52430);
        if (C5046bo.isNullOrNil(str) && C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(52430);
            return true;
        } else if (C5046bo.isNullOrNil(str) && !C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(52430);
            return false;
        } else if (C5046bo.isNullOrNil(str) || !C5046bo.isNullOrNil(str2)) {
            boolean equals = str.equals(str2);
            AppMethodBeat.m2505o(52430);
            return equals;
        } else {
            AppMethodBeat.m2505o(52430);
            return false;
        }
    }

    /* renamed from: gW */
    public static boolean m7563gW(int i, int i2) {
        return i == i2;
    }

    /* renamed from: af */
    public static boolean m7521af(long j, long j2) {
        return j == j2;
    }

    public static boolean isEqual(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.m2504i(52431);
        boolean equals = Arrays.equals(bArr, bArr2);
        AppMethodBeat.m2505o(52431);
        return equals;
    }

    /* renamed from: C */
    public static boolean m7500C(Object obj, Object obj2) {
        AppMethodBeat.m2504i(52432);
        if (obj == obj2 || (obj != null && obj.equals(obj2))) {
            AppMethodBeat.m2505o(52432);
            return true;
        }
        AppMethodBeat.m2505o(52432);
        return false;
    }

    /* renamed from: gX */
    public static int m7564gX(Context context) {
        AppMethodBeat.m2504i(52433);
        if (context == null) {
            C4990ab.m7416i("MicroMsg.Util", "getSelfMemInMB context is null.");
            AppMethodBeat.m2505o(52433);
            return -1;
        }
        Debug.MemoryInfo[] processMemoryInfo = ((ActivityManager) context.getSystemService("activity")).getProcessMemoryInfo(new int[]{Process.myPid()});
        if (processMemoryInfo == null || processMemoryInfo.length <= 0) {
            AppMethodBeat.m2505o(52433);
            return 0;
        }
        int totalPss = processMemoryInfo[0].getTotalPss() / WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;
        AppMethodBeat.m2505o(52433);
        return totalPss;
    }

    /* renamed from: t */
    public static String m7584t(String str, Object... objArr) {
        AppMethodBeat.m2504i(52434);
        try {
            str = String.format(str, objArr);
        } catch (Exception e) {
            C4990ab.m7417i("MicroMsg.Util", "error safeFormatString %s", e.getMessage());
        }
        AppMethodBeat.m2505o(52434);
        return str;
    }

    /* renamed from: I */
    public static Intent m7503I(Context context, Intent intent) {
        AppMethodBeat.m2504i(52435);
        List queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            AppMethodBeat.m2505o(52435);
            return null;
        }
        ResolveInfo resolveInfo = (ResolveInfo) queryIntentServices.get(0);
        C4990ab.m7411d("MicroMsg.Util", "createExplicitFromImplicitIntent pa:%s, cl:%s", resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        ComponentName componentName = new ComponentName(r1, r0);
        Intent intent2 = new Intent(intent);
        intent2.setComponent(componentName);
        AppMethodBeat.m2505o(52435);
        return intent2;
    }

    /* renamed from: bS */
    public static int m7530bS(String str, int i) {
        AppMethodBeat.m2504i(52436);
        try {
            i = Color.parseColor(str);
            AppMethodBeat.m2505o(52436);
        } catch (Exception e) {
            C4990ab.printErrStackTrace("MicroMsg.Util", e, "colorString:%s", str);
            AppMethodBeat.m2505o(52436);
        }
        return i;
    }

    /* renamed from: mA */
    public static int m7576mA(long j) {
        AppMethodBeat.m2504i(52437);
        int round = Math.round(((float) j) / 1000.0f);
        AppMethodBeat.m2505o(52437);
        return round;
    }

    /* renamed from: F */
    public static String m7501F(double d) {
        AppMethodBeat.m2504i(52438);
        String format = String.format("%.2f", new Object[]{Double.valueOf(d)});
        AppMethodBeat.m2505o(52438);
        return format;
    }

    /* renamed from: ga */
    public static String m7565ga(long j) {
        AppMethodBeat.m2504i(52312);
        String c;
        if ((j >> 30) > 0) {
            c = C5046bo.m7535c(j, 10.0d);
            AppMethodBeat.m2505o(52312);
            return c;
        } else if ((j >> 20) > 0) {
            c = C5046bo.m7526b(j, 10.0d);
            AppMethodBeat.m2505o(52312);
            return c;
        } else if ((j >> 9) > 0) {
            c = (((double) Math.round((((double) j) * 10.0d) / 1024.0d)) / 10.0d) + " KB";
            AppMethodBeat.m2505o(52312);
            return c;
        } else {
            c = j + " B";
            AppMethodBeat.m2505o(52312);
            return c;
        }
    }

    /* renamed from: k */
    public static void m7571k(String str, Context context) {
        AppMethodBeat.m2504i(52319);
        boolean z = (str == null || str.equals("")) ? false : true;
        Assert.assertTrue(z);
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(268435456);
        intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
        context.startActivity(intent);
        AppMethodBeat.m2505o(52319);
    }

    public static long dpB() {
        AppMethodBeat.m2504i(52327);
        long currentTimeMillis = (System.currentTimeMillis() / 86400000) * 86400000;
        AppMethodBeat.m2505o(52327);
        return currentTimeMillis;
    }
}
