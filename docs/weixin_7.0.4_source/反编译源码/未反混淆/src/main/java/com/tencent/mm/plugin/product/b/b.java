package com.tencent.mm.plugin.product.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.protocal.protobuf.ze;
import com.tencent.mm.sdk.platformtools.bo;

public final class b {
    public static String s(int i, int i2, String str) {
        AppMethodBeat.i(43948);
        String d;
        if (i == i2) {
            d = d((double) i, str);
            AppMethodBeat.o(43948);
            return d;
        }
        d = String.format("%s~%s", new Object[]{d((double) i2, str), d((double) i, str)});
        AppMethodBeat.o(43948);
        return d;
    }

    public static String d(double d, String str) {
        AppMethodBeat.i(43949);
        String format;
        if ("CNY".equals(str) || "1".equals(str) || bo.isNullOrNil(str)) {
            format = String.format("¥%.2f", new Object[]{Double.valueOf(d / 100.0d)});
            AppMethodBeat.o(43949);
            return format;
        }
        format = String.format("%s%.2f", new Object[]{str, Double.valueOf(d / 100.0d)});
        AppMethodBeat.o(43949);
        return format;
    }

    public static String a(Context context, ze zeVar) {
        AppMethodBeat.i(43950);
        String str;
        if (zeVar.vQt > 0) {
            str = zeVar.Name + " " + d((double) zeVar.vQt, zeVar.PriceType);
            AppMethodBeat.o(43950);
            return str;
        }
        str = context.getString(R.string.cy5);
        AppMethodBeat.o(43950);
        return str;
    }
}
