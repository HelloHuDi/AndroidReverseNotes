package com.google.android.exoplayer2.i;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.text.TextUtils;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.o;
import com.google.android.gms.common.util.CrashUtils.ErrorDialogData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class v {
    public static final String DEVICE = Build.DEVICE;
    public static final String MANUFACTURER = Build.MANUFACTURER;
    public static final String MODEL = Build.MODEL;
    public static final int SDK_INT;
    public static final String brM = (DEVICE + ", " + MODEL + ", " + MANUFACTURER + ", " + SDK_INT);
    private static final Pattern brN = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)([\\.,](\\d+))?([Zz]|((\\+|\\-)(\\d?\\d):?(\\d\\d)))?");
    private static final Pattern brO = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");
    private static final Pattern brP = Pattern.compile("%([A-Fa-f0-9]{2})");
    private static final int[] brQ = new int[]{0, 79764919, 159529838, 222504665, 319059676, 398814059, 445009330, 507990021, 638119352, 583659535, 797628118, 726387553, 890018660, 835552979, 1015980042, 944750013, 1276238704, 1221641927, 1167319070, 1095957929, 1595256236, 1540665371, 1452775106, 1381403509, 1780037320, 1859660671, 1671105958, 1733955601, 2031960084, 2111593891, 1889500026, 1952343757, -1742489888, -1662866601, -1851683442, -1788833735, -1960329156, -1880695413, -2103051438, -2040207643, -1104454824, -1159051537, -1213636554, -1284997759, -1389417084, -1444007885, -1532160278, -1603531939, -734892656, -789352409, -575645954, -646886583, -952755380, -1007220997, -827056094, -898286187, -231047128, -151282273, -71779514, -8804623, -515967244, -436212925, -390279782, -327299027, 881225847, 809987520, 1023691545, 969234094, 662832811, 591600412, 771767749, 717299826, 311336399, 374308984, 453813921, 533576470, 25881363, 88864420, 134795389, 214552010, 2023205639, 2086057648, 1897238633, 1976864222, 1804852699, 1867694188, 1645340341, 1724971778, 1587496639, 1516133128, 1461550545, 1406951526, 1302016099, 1230646740, 1142491917, 1087903418, -1398421865, -1469785312, -1524105735, -1578704818, -1079922613, -1151291908, -1239184603, -1293773166, -1968362705, -1905510760, -2094067647, -2014441994, -1716953613, -1654112188, -1876203875, -1796572374, -525066777, -462094256, -382327159, -302564546, -206542021, -143559028, -97365931, -17609246, -960696225, -1031934488, -817968335, -872425850, -709327229, -780559564, -600130067, -654598054, 1762451694, 1842216281, 1619975040, 1682949687, 2047383090, 2127137669, 1938468188, 2001449195, 1325665622, 1271206113, 1183200824, 1111960463, 1543535498, 1489069629, 1434599652, 1363369299, 622672798, 568075817, 748617968, 677256519, 907627842, 853037301, 1067152940, 995781531, 51762726, 131386257, 177728840, 240578815, 269590778, 349224269, 429104020, 491947555, -248556018, -168932423, -122852000, -60002089, -500490030, -420856475, -341238852, -278395381, -685261898, -739858943, -559578920, -630940305, -1004286614, -1058877219, -845023740, -916395085, -1119974018, -1174433591, -1262701040, -1333941337, -1371866206, -1426332139, -1481064244, -1552294533, -1690935098, -1611170447, -1833673816, -1770699233, -2009983462, -1930228819, -2119160460, -2056179517, 1569362073, 1498123566, 1409854455, 1355396672, 1317987909, 1246755826, 1192025387, 1137557660, 2072149281, 2135122070, 1912620623, 1992383480, 1753615357, 1816598090, 1627664531, 1707420964, 295390185, 358241886, 404320391, 483945776, 43990325, 106832002, 186451547, 266083308, 932423249, 861060070, 1041341759, 986742920, 613929101, 542559546, 756411363, 701822548, -978770311, -1050133554, -869589737, -924188512, -693284699, -764654318, -550540341, -605129092, -475935807, -413084042, -366743377, -287118056, -257573603, -194731862, -114850189, -35218492, -1984365303, -1921392450, -2143631769, -2063868976, -1698919467, -1635936670, -1824608069, -1744851700, -1347415887, -1418654458, -1506661409, -1561119128, -1129027987, -1200260134, -1254728445, -1309196108};

    static {
        AppMethodBeat.i(95975);
        int i = (VERSION.SDK_INT == 25 && VERSION.CODENAME.charAt(0) == 'O') ? 26 : VERSION.SDK_INT;
        SDK_INT = i;
        AppMethodBeat.o(95975);
    }

    public static boolean o(Uri uri) {
        AppMethodBeat.i(95953);
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme) || scheme.equals("file")) {
            AppMethodBeat.o(95953);
            return true;
        }
        AppMethodBeat.o(95953);
        return false;
    }

    public static boolean j(Object obj, Object obj2) {
        AppMethodBeat.i(95954);
        if (obj != null) {
            boolean equals = obj.equals(obj2);
            AppMethodBeat.o(95954);
            return equals;
        } else if (obj2 == null) {
            AppMethodBeat.o(95954);
            return true;
        } else {
            AppMethodBeat.o(95954);
            return false;
        }
    }

    public static ExecutorService aO(final String str) {
        AppMethodBeat.i(95955);
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor(new ThreadFactory() {
            public final Thread newThread(Runnable runnable) {
                AppMethodBeat.i(95952);
                Thread thread = new Thread(runnable, str);
                AppMethodBeat.o(95952);
                return thread;
            }
        });
        AppMethodBeat.o(95955);
        return newSingleThreadExecutor;
    }

    public static void a(f fVar) {
        AppMethodBeat.i(95956);
        if (fVar != null) {
            try {
                fVar.close();
            } catch (IOException e) {
                AppMethodBeat.o(95956);
                return;
            }
        }
        AppMethodBeat.o(95956);
    }

    public static void closeQuietly(Closeable closeable) {
        AppMethodBeat.i(95957);
        try {
            closeable.close();
            AppMethodBeat.o(95957);
        } catch (IOException e) {
            AppMethodBeat.o(95957);
        }
    }

    public static String aP(String str) {
        AppMethodBeat.i(95958);
        if (str == null) {
            AppMethodBeat.o(95958);
            return null;
        }
        String language = new Locale(str).getLanguage();
        AppMethodBeat.o(95958);
        return language;
    }

    public static byte[] aQ(String str) {
        AppMethodBeat.i(95959);
        byte[] bytes = str.getBytes(Charset.forName("UTF-8"));
        AppMethodBeat.o(95959);
        return bytes;
    }

    public static boolean eQ(int i) {
        return i == 10 || i == 13;
    }

    public static String aR(String str) {
        AppMethodBeat.i(95960);
        if (str == null) {
            AppMethodBeat.o(95960);
            return null;
        }
        String toLowerCase = str.toLowerCase(Locale.US);
        AppMethodBeat.o(95960);
        return toLowerCase;
    }

    public static int bi(int i, int i2) {
        return ((i + i2) - 1) / i2;
    }

    public static int u(int i, int i2, int i3) {
        AppMethodBeat.i(95961);
        int max = Math.max(i2, Math.min(i, i3));
        AppMethodBeat.o(95961);
        return max;
    }

    public static long l(long j, long j2) {
        AppMethodBeat.i(95962);
        long max = Math.max(0, Math.min(j, j2));
        AppMethodBeat.o(95962);
        return max;
    }

    public static float h(float f, float f2, float f3) {
        AppMethodBeat.i(95963);
        float max = Math.max(f2, Math.min(f, f3));
        AppMethodBeat.o(95963);
        return max;
    }

    public static int a(long[] jArr, long j, boolean z) {
        AppMethodBeat.i(95964);
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else {
            do {
                binarySearch--;
                if (binarySearch < 0) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            binarySearch++;
        }
        if (z) {
            binarySearch = Math.max(0, binarySearch);
            AppMethodBeat.o(95964);
            return binarySearch;
        }
        AppMethodBeat.o(95964);
        return binarySearch;
    }

    public static int a(long[] jArr, long j, boolean z, boolean z2) {
        AppMethodBeat.i(95965);
        int binarySearch = Arrays.binarySearch(jArr, j);
        if (binarySearch < 0) {
            binarySearch ^= -1;
        } else {
            do {
                binarySearch++;
                if (binarySearch >= jArr.length) {
                    break;
                }
            } while (jArr[binarySearch] == j);
            if (z) {
                binarySearch--;
            }
        }
        if (z2) {
            binarySearch = Math.min(jArr.length - 1, binarySearch);
            AppMethodBeat.o(95965);
            return binarySearch;
        }
        AppMethodBeat.o(95965);
        return binarySearch;
    }

    public static <T> int a(List<? extends Comparable<? super T>> list, T t, boolean z) {
        AppMethodBeat.i(95966);
        int binarySearch = Collections.binarySearch(list, t);
        if (binarySearch < 0) {
            binarySearch = -(binarySearch + 2);
        } else {
            int i;
            while (true) {
                i = binarySearch - 1;
                if (i < 0 || ((Comparable) list.get(i)).compareTo(t) != 0) {
                    binarySearch = i + 1;
                } else {
                    binarySearch = i;
                }
            }
            binarySearch = i + 1;
        }
        if (z) {
            binarySearch = Math.max(0, binarySearch);
            AppMethodBeat.o(95966);
            return binarySearch;
        }
        AppMethodBeat.o(95966);
        return binarySearch;
    }

    public static long aS(String str) {
        AppMethodBeat.i(95967);
        Matcher matcher = brN.matcher(str);
        if (matcher.matches()) {
            int i;
            if (matcher.group(9) == null) {
                i = 0;
            } else if (matcher.group(9).equalsIgnoreCase("Z")) {
                i = 0;
            } else {
                int parseInt = (Integer.parseInt(matcher.group(12)) * 60) + Integer.parseInt(matcher.group(13));
                i = matcher.group(11).equals("-") ? parseInt * -1 : parseInt;
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            gregorianCalendar.clear();
            gregorianCalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
            if (!TextUtils.isEmpty(matcher.group(8))) {
                gregorianCalendar.set(14, new BigDecimal("0." + matcher.group(8)).movePointRight(3).intValue());
            }
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            if (i != 0) {
                timeInMillis -= (long) (60000 * i);
            }
            AppMethodBeat.o(95967);
            return timeInMillis;
        }
        o oVar = new o("Invalid date/time format: ".concat(String.valueOf(str)));
        AppMethodBeat.o(95967);
        throw oVar;
    }

    public static long b(long j, long j2, long j3) {
        if (j3 >= j2 && j3 % j2 == 0) {
            return j / (j3 / j2);
        }
        if (j3 >= j2 || j2 % j3 != 0) {
            return (long) ((((double) j2) / ((double) j3)) * ((double) j));
        }
        return (j2 / j3) * j;
    }

    public static void a(long[] jArr, long j) {
        int i = 0;
        long j2;
        if (j >= 1000000 && j % 1000000 == 0) {
            j2 = j / 1000000;
            while (i < jArr.length) {
                jArr[i] = jArr[i] / j2;
                i++;
            }
        } else if (j >= 1000000 || 1000000 % j != 0) {
            double d = 1000000.0d / ((double) j);
            while (i < jArr.length) {
                jArr[i] = (long) (((double) jArr[i]) * d);
                i++;
            }
        } else {
            j2 = 1000000 / j;
            while (i < jArr.length) {
                jArr[i] = jArr[i] * j2;
                i++;
            }
        }
    }

    public static int[] z(List<Integer> list) {
        AppMethodBeat.i(95968);
        if (list == null) {
            AppMethodBeat.o(95968);
            return null;
        }
        int size = list.size();
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = ((Integer) list.get(i)).intValue();
        }
        AppMethodBeat.o(95968);
        return iArr;
    }

    public static int aT(String str) {
        boolean z;
        AppMethodBeat.i(95969);
        int length = str.length();
        if (length <= 4) {
            z = true;
        } else {
            z = false;
        }
        a.checkArgument(z);
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            i = str.charAt(i2) | (i << 8);
        }
        AppMethodBeat.o(95969);
        return i;
    }

    public static byte[] aU(String str) {
        AppMethodBeat.i(95970);
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            bArr[i] = (byte) (Character.digit(str.charAt(i2 + 1), 16) + (Character.digit(str.charAt(i2), 16) << 4));
        }
        AppMethodBeat.o(95970);
        return bArr;
    }

    public static String d(Object[] objArr) {
        AppMethodBeat.i(95971);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < objArr.length; i++) {
            stringBuilder.append(objArr[i].getClass().getSimpleName());
            if (i < objArr.length - 1) {
                stringBuilder.append(", ");
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(95971);
        return stringBuilder2;
    }

    public static String i(Context context, String str) {
        String str2;
        AppMethodBeat.i(95972);
        try {
            str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            str2 = "?";
        }
        str2 = str + "/" + str2 + " (Linux;Android " + VERSION.RELEASE + ") ExoPlayerLib/2.5.4";
        AppMethodBeat.o(95972);
        return str2;
    }

    public static int eR(int i) {
        switch (i) {
            case 8:
                return 3;
            case 16:
                return 2;
            case 24:
                return j.INVALID_ID;
            case 32:
                return ErrorDialogData.SUPPRESSED;
            default:
                return 0;
        }
    }

    public static int bj(int i, int i2) {
        AppMethodBeat.i(95973);
        switch (i) {
            case j.INVALID_ID /*-2147483648*/:
                i2 *= 3;
                AppMethodBeat.o(95973);
                return i2;
            case 2:
                i2 *= 2;
                AppMethodBeat.o(95973);
                return i2;
            case 3:
                AppMethodBeat.o(95973);
                return i2;
            case ErrorDialogData.SUPPRESSED /*1073741824*/:
                i2 *= 4;
                AppMethodBeat.o(95973);
                return i2;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
                AppMethodBeat.o(95973);
                throw illegalArgumentException;
        }
    }

    public static int eS(int i) {
        switch (i) {
            case 2:
                return 0;
            case 3:
                return 8;
            case 4:
                return 4;
            case 5:
            case 7:
            case 8:
            case 9:
            case 10:
                return 5;
            case 6:
                return 2;
            case 13:
                return 1;
            default:
                return 3;
        }
    }

    public static int eT(int i) {
        AppMethodBeat.i(95974);
        switch (i) {
            case 0:
                AppMethodBeat.o(95974);
                return 16777216;
            case 1:
                AppMethodBeat.o(95974);
                return 3538944;
            case 2:
                AppMethodBeat.o(95974);
                return 13107200;
            case 3:
                AppMethodBeat.o(95974);
                return WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            case 4:
                AppMethodBeat.o(95974);
                return WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            default:
                IllegalStateException illegalStateException = new IllegalStateException();
                AppMethodBeat.o(95974);
                throw illegalStateException;
        }
    }

    public static int m(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i; i3++) {
            i2 = (i2 << 8) ^ brQ[((i2 >>> 24) ^ (bArr[i3] & 255)) & 255];
        }
        return i2;
    }
}
