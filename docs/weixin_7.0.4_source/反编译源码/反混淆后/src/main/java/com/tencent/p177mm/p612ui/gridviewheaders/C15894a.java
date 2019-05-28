package com.tencent.p177mm.p612ui.gridviewheaders;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.Calendar;
import java.util.Date;

/* renamed from: com.tencent.mm.ui.gridviewheaders.a */
public class C15894a {
    private static C15894a zym;
    private long zyj = Calendar.getInstance().getTimeInMillis();
    private long zyk;
    private long zyl;

    public static C15894a dJg() {
        AppMethodBeat.m2504i(107323);
        if (zym == null) {
            synchronized (C15894a.class) {
                try {
                    zym = new C15894a();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(107323);
                    }
                }
            }
        }
        C15894a c15894a = zym;
        AppMethodBeat.m2505o(107323);
        return c15894a;
    }

    private C15894a() {
        AppMethodBeat.m2504i(107324);
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
        AppMethodBeat.m2505o(107324);
    }

    /* renamed from: b */
    public final long mo28138b(Date date) {
        AppMethodBeat.m2504i(107325);
        if (date.getTime() >= this.zyk) {
            AppMethodBeat.m2505o(107325);
            return Long.MAX_VALUE;
        } else if (date.getTime() >= this.zyl) {
            AppMethodBeat.m2505o(107325);
            return 9223372036854775806L;
        } else {
            long c = C15894a.m24212c(date);
            AppMethodBeat.m2505o(107325);
            return c;
        }
    }

    /* renamed from: nv */
    public static long m24213nv(long j) {
        AppMethodBeat.m2504i(107326);
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        AppMethodBeat.m2505o(107326);
        return timeInMillis;
    }

    /* renamed from: c */
    private static long m24212c(Date date) {
        AppMethodBeat.m2504i(107327);
        long year = (long) ((date.getYear() * 100) + date.getMonth());
        AppMethodBeat.m2505o(107327);
        return year;
    }

    /* renamed from: a */
    public final String mo28137a(Date date, Context context) {
        AppMethodBeat.m2504i(107328);
        String string;
        if (date.getTime() >= this.zyk) {
            string = context.getString(C25738R.string.evw);
            AppMethodBeat.m2505o(107328);
            return string;
        } else if (date.getTime() >= this.zyl) {
            string = context.getString(C25738R.string.evv);
            AppMethodBeat.m2505o(107328);
            return string;
        } else {
            string = String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
            AppMethodBeat.m2505o(107328);
            return string;
        }
    }
}
