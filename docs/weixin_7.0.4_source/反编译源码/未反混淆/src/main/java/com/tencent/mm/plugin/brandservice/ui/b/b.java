package com.tencent.mm.plugin.brandservice.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.GregorianCalendar;
import java.util.HashMap;

public final class b {
    private static HashMap<Long, Long> jZc = new HashMap();
    private static HashMap<Long, String> jZd = new HashMap();

    public static synchronized void clean() {
        synchronized (b.class) {
            AppMethodBeat.i(14447);
            jZc.clear();
            jZd.clear();
            AppMethodBeat.o(14447);
        }
    }

    static {
        AppMethodBeat.i(14449);
        AppMethodBeat.o(14449);
    }

    public static synchronized String e(Context context, long j) {
        String str;
        synchronized (b.class) {
            AppMethodBeat.i(14448);
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                str = "";
                AppMethodBeat.o(14448);
            } else {
                long timeInMillis = gregorianCalendar.getTimeInMillis();
                if (jZc.containsKey(Long.valueOf(j))) {
                    if (timeInMillis - ((Long) jZc.get(Long.valueOf(j))).longValue() >= 60000) {
                        jZc.remove(Long.valueOf(j));
                    } else if (jZd.containsKey(Long.valueOf(j))) {
                        str = (String) jZd.get(Long.valueOf(j));
                        AppMethodBeat.o(14448);
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
                    AppMethodBeat.o(14448);
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
                            str = context.getResources().getQuantityString(R.plurals.l, i, new Object[]{Integer.valueOf(i)});
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(14448);
                        } else {
                            str = context.getString(R.string.byb);
                            jZd.put(Long.valueOf(j), str);
                            jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                            AppMethodBeat.o(14448);
                        }
                    } else {
                        i = (int) ((timeInMillis - j) / 3600000);
                        if (i <= 0) {
                            i = 1;
                        }
                        str = context.getResources().getQuantityString(R.plurals.j, i, new Object[]{Integer.valueOf(i)});
                        jZd.put(Long.valueOf(j), str);
                        jZc.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                        AppMethodBeat.o(14448);
                    }
                }
            }
        }
        return str;
    }
}
