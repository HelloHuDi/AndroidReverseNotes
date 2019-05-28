package com.tencent.p177mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p178a.C1178g;
import java.text.SimpleDateFormat;
import java.util.Date;

/* renamed from: com.tencent.mm.model.p */
public final class C1851p {
    /* renamed from: m */
    public static String m3818m(String str, long j) {
        AppMethodBeat.m2504i(59722);
        String format = new SimpleDateFormat("ssHHmmMMddyy").format(new Date(j));
        if (str == null || str.length() <= 1) {
            format = format + "fffffff";
        } else {
            format = format + C1178g.m2591x(str.getBytes()).substring(0, 7);
        }
        format = (format + String.format("%04x", new Object[]{Long.valueOf(j % 65535)})) + ((j % 7) + 100);
        AppMethodBeat.m2505o(59722);
        return format;
    }
}
