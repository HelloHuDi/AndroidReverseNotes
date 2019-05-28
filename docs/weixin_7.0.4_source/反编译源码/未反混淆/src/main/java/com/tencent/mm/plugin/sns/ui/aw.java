package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class aw {
    private static HashMap<Long, Long> jZc = new HashMap();
    private static HashMap<Long, String> jZd = new HashMap();
    private static Map<String, List<String>> nnv = new HashMap();
    private static Map<String, List<String>> nnw = new HashMap();

    static {
        AppMethodBeat.i(39614);
        AppMethodBeat.o(39614);
    }

    private static CharSequence i(Context context, long j) {
        AppMethodBeat.i(39603);
        CharSequence format = DateFormat.format(context.getString(R.string.bxq), j);
        AppMethodBeat.o(39603);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String l(Context context, long j) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(39604);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        int i4 = instance.get(1) == instance2.get(1) ? 1 : 0;
        if (i4 == 0 || instance.get(2) != instance2.get(2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) != instance2.get(5)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) - 1 != instance2.get(5)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            int i5;
            if (i4 != 0 && instance.get(2) - 1 == instance2.get(2)) {
                i5 = 1;
            } else if (instance.get(1) - instance2.get(1) == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                instance.add(5, -1);
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                    i3 = 1;
                }
                String str;
                if (i2 == 0) {
                    str = (String) i(context, j);
                    AppMethodBeat.o(39604);
                    return str;
                } else if (i3 != 0) {
                    str = context.getString(R.string.byb) + " " + ((String) i(context, j));
                    AppMethodBeat.o(39604);
                    return str;
                } else {
                    if (i4 != 0) {
                        str = (String) DateFormat.format(context.getString(R.string.bww), j);
                    } else {
                        str = (String) DateFormat.format(context.getString(R.string.bxe), j);
                    }
                    if (str.indexOf("-") > 0) {
                        i3 = instance2.get(2) + 1;
                        str = instance2.get(5) + " " + V(context, i3);
                        if (i4 == 0) {
                            str = str + " " + instance2.get(1);
                        }
                    }
                    str = str + " " + ((String) i(context, j));
                    AppMethodBeat.o(39604);
                    return str;
                }
            }
        }
        i3 = i;
        if (i2 == 0) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m(Context context, long j) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.i(39605);
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTimeInMillis(j);
        int i4 = instance.get(1) == instance2.get(1) ? 1 : 0;
        if (i4 == 0 || instance.get(2) != instance2.get(2)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) != instance2.get(5)) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (i4 == 0 || i == 0 || instance.get(5) - 1 != instance2.get(5)) {
            i = 0;
        } else {
            i = 1;
        }
        if (i == 0) {
            int i5;
            if (i4 != 0 && instance.get(2) - 1 == instance2.get(2)) {
                i5 = 1;
            } else if (instance.get(1) - instance2.get(1) == 1) {
                i5 = 1;
            } else {
                i5 = 0;
            }
            if (i5 != 0) {
                instance.add(5, -1);
                if (instance.get(1) == instance2.get(1) && instance.get(2) == instance2.get(2) && instance.get(5) == instance2.get(5)) {
                    i3 = 1;
                }
                String str;
                if (i2 == 0) {
                    str = (String) i(context, j);
                    AppMethodBeat.o(39605);
                    return str;
                } else if (i3 != 0) {
                    str = context.getString(R.string.byb) + " " + ((String) i(context, j));
                    AppMethodBeat.o(39605);
                    return str;
                } else {
                    str = (String) DateFormat.format(context.getString(R.string.bxe), j);
                    if (str.indexOf("-") > 0) {
                        i3 = instance2.get(2) + 1;
                        str = instance2.get(5) + " " + V(context, i3);
                        if (i4 == 0) {
                            str = str + " " + instance2.get(1);
                        }
                    }
                    str = str + " " + ((String) i(context, j));
                    AppMethodBeat.o(39605);
                    return str;
                }
            }
        }
        i3 = i;
        if (i2 == 0) {
        }
    }

    public static synchronized void clean() {
        synchronized (aw.class) {
            AppMethodBeat.i(39606);
            jZc.clear();
            jZd.clear();
            AppMethodBeat.o(39606);
        }
    }

    public static synchronized String h(Context context, long j) {
        String str;
        synchronized (aw.class) {
            AppMethodBeat.i(39607);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
                AppMethodBeat.o(39607);
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (jZc.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) jZc.get(Long.valueOf(j))).longValue() >= 60000) {
                        jZc.remove(Long.valueOf(j));
                    } else if (jZd.containsKey(Long.valueOf(j))) {
                        str = (String) jZd.get(Long.valueOf(j));
                        AppMethodBeat.o(39607);
                    }
                }
                int i;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i = (int) ((timeInMillis - j) / 60000);
                    if (i <= 0) {
                        i = 1;
                    }
                    str = context.getResources().getQuantityString(R.plurals.k, i, new Object[]{Integer.valueOf(i)});
                    jZd.put(Long.valueOf(j), str);
                    jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                    AppMethodBeat.o(39607);
                } else {
                    GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                    long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                            i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                            if (i <= 0) {
                                i = 1;
                            }
                            str = context.getResources().getQuantityString(R.plurals.l, i, new Object[]{Integer.valueOf(i)});
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(39607);
                        } else {
                            str = context.getString(R.string.byb);
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(39607);
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(R.plurals.j, i, new Object[]{Integer.valueOf(i)});
                        jZd.put(Long.valueOf(j), str);
                        jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        AppMethodBeat.o(39607);
                    }
                }
            }
        }
        return str;
    }

    private static void aS(Context context, String str) {
        AppMethodBeat.i(39608);
        String[] stringArray = context.getResources().getStringArray(R.array.aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        nnw.put(str, arrayList);
        AppMethodBeat.o(39608);
    }

    private static String V(Context context, int i) {
        AppMethodBeat.i(39609);
        String[] stringArray = context.getResources().getStringArray(R.array.aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        String str;
        if (i >= arrayList.size()) {
            str = "";
            AppMethodBeat.o(39609);
            return str;
        }
        str = (String) arrayList.get(i);
        AppMethodBeat.o(39609);
        return str;
    }

    public static String x(Context context, String str, String str2) {
        AppMethodBeat.i(39610);
        if (nnw.get(str2) == null) {
            aS(context, str2);
        }
        int i = bo.getInt(str, 0);
        List list = (List) nnw.get(str2);
        if (i >= list.size() || list.get(i) == null || ((String) list.get(i)).equals("")) {
            aS(context, str2);
        }
        list = (List) nnw.get(str2);
        String str3;
        if (i < list.size()) {
            str3 = (String) list.get(i);
            AppMethodBeat.o(39610);
            return str3;
        }
        str3 = "";
        AppMethodBeat.o(39610);
        return str3;
    }

    public static CharSequence a(Context context, long j, boolean z) {
        AppMethodBeat.i(39611);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            String str = "";
            AppMethodBeat.o(39611);
            return str;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        CharSequence format;
        if (timeInMillis <= 0 || timeInMillis > 86400000 || !z) {
            long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000 || !z) {
                new GregorianCalendar().setTimeInMillis(j);
                format = DateFormat.format(context.getString(R.string.bwx), j);
                AppMethodBeat.o(39611);
                return format;
            }
            format = context.getString(R.string.byb);
            AppMethodBeat.o(39611);
            return format;
        }
        format = context.getString(R.string.by3);
        AppMethodBeat.o(39611);
        return format;
    }

    public static int getYear() {
        AppMethodBeat.i(39613);
        int i = new GregorianCalendar().get(1);
        AppMethodBeat.o(39613);
        return i;
    }

    public static CharSequence kL(long j) {
        int i;
        AppMethodBeat.i(39612);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > 86400000) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            String string = ah.getContext().getResources().getString(R.string.by3);
            AppMethodBeat.o(39612);
            return string;
        }
        gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        i = gregorianCalendar.get(7) - 1;
        if (i == 0) {
            i = 7;
        }
        long timeInMillis2 = gregorianCalendar2.getTimeInMillis() + (((long) (7 - i)) * 86400000);
        if (j < gregorianCalendar2.getTimeInMillis() - (((long) i) * 86400000) || j >= timeInMillis2) {
            i = 0;
        } else {
            i = 1;
        }
        CharSequence string2;
        if (i != 0) {
            string2 = ah.getContext().getResources().getString(R.string.bx6);
            AppMethodBeat.o(39612);
            return string2;
        }
        string2 = DateFormat.format(ah.getContext().getString(R.string.bz4), j);
        AppMethodBeat.o(39612);
        return string2;
    }
}
