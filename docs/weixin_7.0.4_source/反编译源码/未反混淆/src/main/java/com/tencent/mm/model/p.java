package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class p {
    public static String m(String str, long j) {
        AppMethodBeat.i(59722);
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(j));
        if (str == null || str.length() <= 1) {
            format = format + "fffffff";
        } else {
            format = format + g.x(str.getBytes()).substring(0, 7);
        }
        format = (format + String.format("%04x", new Object[]{Long.valueOf(j % 65535)})) + ((j % 7) + 100);
        AppMethodBeat.o(59722);
        return format;
    }
}
