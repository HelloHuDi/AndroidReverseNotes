package com.tencent.p177mm.plugin.brandservice.p349ui.p1242b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.GregorianCalendar;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.brandservice.ui.b.b */
public final class C42809b {
    private static HashMap<Long, Long> jZc = new HashMap();
    private static HashMap<Long, String> jZd = new HashMap();

    public static synchronized void clean() {
        synchronized (C42809b.class) {
            AppMethodBeat.m2504i(14447);
            jZc.clear();
            jZd.clear();
            AppMethodBeat.m2505o(14447);
        }
    }

    static {
        AppMethodBeat.m2504i(14449);
        AppMethodBeat.m2505o(14449);
    }

    /* renamed from: e */
    public static synchronized String m75917e(Context context, long j) {
        String str;
        synchronized (C42809b.class) {
            AppMethodBeat.m2504i(14448);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
                AppMethodBeat.m2505o(14448);
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (jZc.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) jZc.get(Long.valueOf(j))).longValue() >= 60000) {
                        jZc.remove(Long.valueOf(j));
                    } else if (jZd.containsKey(Long.valueOf(j))) {
                        str = (String) jZd.get(Long.valueOf(j));
                        AppMethodBeat.m2505o(14448);
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
                    AppMethodBeat.m2505o(14448);
                } else {
                    long timeInMillis2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
                    long j2 = j - timeInMillis2;
                    if (j2 <= 0 || j2 > 86400000) {
                        j2 = (j - timeInMillis2) + 86400000;
                        if (j2 <= 0 || j2 > 86400000) {
                            i = (int) (((timeInMillis2 + 86400000) - j) / 86400000);
                            if (i <= 0) {
                                i = 1;
                            }
                            str = context.getResources().getQuantityString(C25738R.plurals.f9600l, i, new Object[]{Integer.valueOf(i)});
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.m2505o(14448);
                        } else {
                            str = context.getString(C25738R.string.byb);
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.m2505o(14448);
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(C25738R.plurals.f9598j, i, new Object[]{Integer.valueOf(i)});
                        jZd.put(Long.valueOf(j), str);
                        jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        AppMethodBeat.m2505o(14448);
                    }
                }
            }
        }
        return str;
    }
}
