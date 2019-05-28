package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a zym;
    private long zyj = Calendar.getInstance().getTimeInMillis();
    private long zyk;
    private long zyl;

    public static a dJg() {
        AppMethodBeat.i(107323);
        if (zym == null) {
            synchronized (a.class) {
                try {
                    zym = new a();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(107323);
                    }
                }
            }
        }
        a aVar = zym;
        AppMethodBeat.o(107323);
        return aVar;
    }

    private a() {
        AppMethodBeat.i(107324);
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.zyk = instance.getTimeInMillis();
        instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.zyl = instance.getTimeInMillis();
        AppMethodBeat.o(107324);
    }

    public final long b(Date date) {
        AppMethodBeat.i(107325);
        if (date.getTime() >= this.zyk) {
            AppMethodBeat.o(107325);
            return Long.MAX_VALUE;
        } else if (date.getTime() >= this.zyl) {
            AppMethodBeat.o(107325);
            return 9223372036854775806L;
        } else {
            long c = c(date);
            AppMethodBeat.o(107325);
            return c;
        }
    }

    public static long nv(long j) {
        AppMethodBeat.i(107326);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.o(107326);
        return timeInMillis;
    }

    private static long c(Date date) {
        AppMethodBeat.i(107327);
        long year = (long) ((date.getYear() * 100) + date.getMonth());
        AppMethodBeat.o(107327);
        return year;
    }

    public final String a(Date date, Context context) {
        AppMethodBeat.i(107328);
        String string;
        if (date.getTime() >= this.zyk) {
            string = context.getString(R.string.evw);
            AppMethodBeat.o(107328);
            return string;
        } else if (date.getTime() >= this.zyl) {
            string = context.getString(R.string.evv);
            AppMethodBeat.o(107328);
            return string;
        } else {
            string = String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
            AppMethodBeat.o(107328);
            return string;
        }
    }
}
