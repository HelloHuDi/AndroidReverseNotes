package com.tencent.p177mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.plugin.collect.model.e */
public final class C38804e {
    /* renamed from: a */
    public static String m65843a(Context context, long j, int i) {
        AppMethodBeat.m2504i(40930);
        long j2 = 1000 * j;
        String format;
        if (i == 0) {
            format = new SimpleDateFormat(context.getString(C25738R.string.ar7)).format(new Date(j2));
            AppMethodBeat.m2505o(40930);
            return format;
        } else if (i == 1) {
            format = new SimpleDateFormat(context.getString(C25738R.string.ar8)).format(new Date(j2));
            AppMethodBeat.m2505o(40930);
            return format;
        } else {
            format = new SimpleDateFormat(context.getString(C25738R.string.ar9)).format(new Date(j2));
            AppMethodBeat.m2505o(40930);
            return format;
        }
    }

    /* renamed from: tG */
    public static String m65844tG(int i) {
        AppMethodBeat.m2504i(40931);
        String format = String.format("%.2f", new Object[]{Double.valueOf(((double) i) / 100.0d)});
        AppMethodBeat.m2505o(40931);
        return format;
    }
}
