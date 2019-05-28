package com.tencent.p177mm.plugin.sns.p520ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.sns.ui.aw */
public final class C29198aw {
    private static HashMap<Long, Long> jZc = new HashMap();
    private static HashMap<Long, String> jZd = new HashMap();
    private static Map<String, List<String>> nnv = new HashMap();
    private static Map<String, List<String>> nnw = new HashMap();

    static {
        AppMethodBeat.m2504i(39614);
        AppMethodBeat.m2505o(39614);
    }

    /* renamed from: i */
    private static CharSequence m46374i(Context context, long j) {
        AppMethodBeat.m2504i(39603);
        CharSequence format = DateFormat.format(context.getString(C25738R.string.bxq), j);
        AppMethodBeat.m2505o(39603);
        return format;
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0085  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    public static String m46376l(Context context, long j) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(39604);
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
                    str = (String) C29198aw.m46374i(context, j);
                    AppMethodBeat.m2505o(39604);
                    return str;
                } else if (i3 != 0) {
                    str = context.getString(C25738R.string.byb) + " " + ((String) C29198aw.m46374i(context, j));
                    AppMethodBeat.m2505o(39604);
                    return str;
                } else {
                    if (i4 != 0) {
                        str = (String) DateFormat.format(context.getString(C25738R.string.bww), j);
                    } else {
                        str = (String) DateFormat.format(context.getString(C25738R.string.bxe), j);
                    }
                    if (str.indexOf("-") > 0) {
                        i3 = instance2.get(2) + 1;
                        str = instance2.get(5) + " " + C29198aw.m46370V(context, i3);
                        if (i4 == 0) {
                            str = str + " " + instance2.get(1);
                        }
                    }
                    str = str + " " + ((String) C29198aw.m46374i(context, j));
                    AppMethodBeat.m2505o(39604);
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
    /* renamed from: m */
    public static String m46377m(Context context, long j) {
        int i;
        int i2;
        int i3 = 0;
        AppMethodBeat.m2504i(39605);
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
                    str = (String) C29198aw.m46374i(context, j);
                    AppMethodBeat.m2505o(39605);
                    return str;
                } else if (i3 != 0) {
                    str = context.getString(C25738R.string.byb) + " " + ((String) C29198aw.m46374i(context, j));
                    AppMethodBeat.m2505o(39605);
                    return str;
                } else {
                    str = (String) DateFormat.format(context.getString(C25738R.string.bxe), j);
                    if (str.indexOf("-") > 0) {
                        i3 = instance2.get(2) + 1;
                        str = instance2.get(5) + " " + C29198aw.m46370V(context, i3);
                        if (i4 == 0) {
                            str = str + " " + instance2.get(1);
                        }
                    }
                    str = str + " " + ((String) C29198aw.m46374i(context, j));
                    AppMethodBeat.m2505o(39605);
                    return str;
                }
            }
        }
        i3 = i;
        if (i2 == 0) {
        }
    }

    public static synchronized void clean() {
        synchronized (C29198aw.class) {
            AppMethodBeat.m2504i(39606);
            jZc.clear();
            jZd.clear();
            AppMethodBeat.m2505o(39606);
        }
    }

    /* renamed from: h */
    public static synchronized String m46373h(Context context, long j) {
        String str;
        synchronized (C29198aw.class) {
            AppMethodBeat.m2504i(39607);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
                AppMethodBeat.m2505o(39607);
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (jZc.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) jZc.get(Long.valueOf(j))).longValue() >= 60000) {
                        jZc.remove(Long.valueOf(j));
                    } else if (jZd.containsKey(Long.valueOf(j))) {
                        str = (String) jZd.get(Long.valueOf(j));
                        AppMethodBeat.m2505o(39607);
                    }
                }
                int i;
                if ((timeInMillis - j) / 3600000 == 0) {
                    i = (int) ((timeInMillis - j) / 60000);
                    if (i <= 0) {
                        i = 1;
                    }
                    str = context.getResources().getQuantityString(C25738R.plurals.f9599k, i, new Object[]{Integer.valueOf(i)});
                    jZd.put(Long.valueOf(j), str);
                    jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                    AppMethodBeat.m2505o(39607);
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
                            str = context.getResources().getQuantityString(C25738R.plurals.f9600l, i, new Object[]{Integer.valueOf(i)});
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.m2505o(39607);
                        } else {
                            str = context.getString(C25738R.string.byb);
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.m2505o(39607);
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(C25738R.plurals.f9598j, i, new Object[]{Integer.valueOf(i)});
                        jZd.put(Long.valueOf(j), str);
                        jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        AppMethodBeat.m2505o(39607);
                    }
                }
            }
        }
        return str;
    }

    /* renamed from: aS */
    private static void m46372aS(Context context, String str) {
        AppMethodBeat.m2504i(39608);
        String[] stringArray = context.getResources().getStringArray(C25738R.array.f12637aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        nnw.put(str, arrayList);
        AppMethodBeat.m2505o(39608);
    }

    /* renamed from: V */
    private static String m46370V(Context context, int i) {
        AppMethodBeat.m2504i(39609);
        String[] stringArray = context.getResources().getStringArray(C25738R.array.f12637aq);
        ArrayList arrayList = new ArrayList();
        arrayList.add("");
        for (Object add : stringArray) {
            arrayList.add(add);
        }
        String str;
        if (i >= arrayList.size()) {
            str = "";
            AppMethodBeat.m2505o(39609);
            return str;
        }
        str = (String) arrayList.get(i);
        AppMethodBeat.m2505o(39609);
        return str;
    }

    /* renamed from: x */
    public static String m46378x(Context context, String str, String str2) {
        AppMethodBeat.m2504i(39610);
        if (nnw.get(str2) == null) {
            C29198aw.m46372aS(context, str2);
        }
        int i = C5046bo.getInt(str, 0);
        List list = (List) nnw.get(str2);
        if (i >= list.size() || list.get(i) == null || ((String) list.get(i)).equals("")) {
            C29198aw.m46372aS(context, str2);
        }
        list = (List) nnw.get(str2);
        String str3;
        if (i < list.size()) {
            str3 = (String) list.get(i);
            AppMethodBeat.m2505o(39610);
            return str3;
        }
        str3 = "";
        AppMethodBeat.m2505o(39610);
        return str3;
    }

    /* renamed from: a */
    public static CharSequence m46371a(Context context, long j, boolean z) {
        AppMethodBeat.m2504i(39611);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            String str = "";
            AppMethodBeat.m2505o(39611);
            return str;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        CharSequence format;
        if (timeInMillis <= 0 || timeInMillis > 86400000 || !z) {
            long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000 || !z) {
                new GregorianCalendar().setTimeInMillis(j);
                format = DateFormat.format(context.getString(C25738R.string.bwx), j);
                AppMethodBeat.m2505o(39611);
                return format;
            }
            format = context.getString(C25738R.string.byb);
            AppMethodBeat.m2505o(39611);
            return format;
        }
        format = context.getString(C25738R.string.by3);
        AppMethodBeat.m2505o(39611);
        return format;
    }

    public static int getYear() {
        AppMethodBeat.m2504i(39613);
        int i = new GregorianCalendar().get(1);
        AppMethodBeat.m2505o(39613);
        return i;
    }

    /* renamed from: kL */
    public static CharSequence m46375kL(long j) {
        int i;
        AppMethodBeat.m2504i(39612);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
        if (timeInMillis <= 0 || timeInMillis > 86400000) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            String string = C4996ah.getContext().getResources().getString(C25738R.string.by3);
            AppMethodBeat.m2505o(39612);
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
            string2 = C4996ah.getContext().getResources().getString(C25738R.string.bx6);
            AppMethodBeat.m2505o(39612);
            return string2;
        }
        string2 = DateFormat.format(C4996ah.getContext().getString(C25738R.string.bz4), j);
        AppMethodBeat.m2505o(39612);
        return string2;
    }
}
