package com.tencent.mm.plugin.collect.model;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class e {
    public static String a(Context context, long j, int i) {
        AppMethodBeat.i(40930);
        long j2 = 1000 * j;
        String format;
        if (i == 0) {
            format = new SimpleDateFormat(context.getString(R.string.ar7)).format(new Date(j2));
            AppMethodBeat.o(40930);
            return format;
        } else if (i == 1) {
            format = new SimpleDateFormat(context.getString(R.string.ar8)).format(new Date(j2));
            AppMethodBeat.o(40930);
            return format;
        } else {
            format = new SimpleDateFormat(context.getString(R.string.ar9)).format(new Date(j2));
            AppMethodBeat.o(40930);
            return format;
        }
    }

    public static String tG(int i) {
        AppMethodBeat.i(40931);
        String format = String.format("%.2f", new Object[]{Double.valueOf(((double) i) / 100.0d)});
        AppMethodBeat.o(40931);
        return format;
    }
}
