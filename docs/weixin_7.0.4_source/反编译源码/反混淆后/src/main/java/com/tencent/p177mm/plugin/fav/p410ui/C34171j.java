package com.tencent.p177mm.plugin.fav.p410ui;

import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.util.GregorianCalendar;

/* renamed from: com.tencent.mm.plugin.fav.ui.j */
public final class C34171j {
    /* renamed from: B */
    public static CharSequence m56018B(Context context, int i) {
        AppMethodBeat.m2504i(74163);
        if (i <= 0) {
            String string = context.getString(C25738R.string.brd, new Object[]{Integer.valueOf(0), Integer.valueOf(0)});
            AppMethodBeat.m2505o(74163);
            return string;
        }
        int i2 = i % 60;
        CharSequence string2 = context.getString(C25738R.string.brd, new Object[]{Integer.valueOf(i / 60), Integer.valueOf(i2)});
        AppMethodBeat.m2505o(74163);
        return string2;
    }

    /* renamed from: g */
    public static CharSequence m56019g(Context context, long j) {
        AppMethodBeat.m2504i(74164);
        if (j < 3600000) {
            String str = "";
            AppMethodBeat.m2505o(74164);
            return str;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        CharSequence format;
        if (timeInMillis <= 0 || timeInMillis > 86400000) {
            long timeInMillis2 = gregorianCalendar2.getTimeInMillis() - j;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                new GregorianCalendar().setTimeInMillis(j);
                int timeInMillis3 = (int) ((gregorianCalendar.getTimeInMillis() - j) / 86400000);
                if (timeInMillis3 <= 0) {
                    timeInMillis3 = 1;
                }
                if (timeInMillis3 > 30) {
                    format = DateFormat.format(context.getString(C25738R.string.bpk), j);
                    AppMethodBeat.m2505o(74164);
                    return format;
                }
                format = context.getResources().getQuantityString(C25738R.plurals.f9600l, timeInMillis3, new Object[]{Integer.valueOf(timeInMillis3)});
                AppMethodBeat.m2505o(74164);
                return format;
            }
            format = context.getString(C25738R.string.byb);
            AppMethodBeat.m2505o(74164);
            return format;
        }
        format = context.getString(C25738R.string.by3);
        AppMethodBeat.m2505o(74164);
        return format;
    }
}
