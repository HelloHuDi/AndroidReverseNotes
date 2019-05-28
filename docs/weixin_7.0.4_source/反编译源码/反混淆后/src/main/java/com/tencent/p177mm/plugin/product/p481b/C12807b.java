package com.tencent.p177mm.plugin.product.p481b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.protocal.protobuf.C35968ze;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.product.b.b */
public final class C12807b {
    /* renamed from: s */
    public static String m20799s(int i, int i2, String str) {
        AppMethodBeat.m2504i(43948);
        String d;
        if (i == i2) {
            d = C12807b.m20798d((double) i, str);
            AppMethodBeat.m2505o(43948);
            return d;
        }
        d = String.format("%s~%s", new Object[]{C12807b.m20798d((double) i2, str), C12807b.m20798d((double) i, str)});
        AppMethodBeat.m2505o(43948);
        return d;
    }

    /* renamed from: d */
    public static String m20798d(double d, String str) {
        AppMethodBeat.m2504i(43949);
        String format;
        if ("CNY".equals(str) || "1".equals(str) || C5046bo.isNullOrNil(str)) {
            format = String.format("¥%.2f", new Object[]{Double.valueOf(d / 100.0d)});
            AppMethodBeat.m2505o(43949);
            return format;
        }
        format = String.format("%s%.2f", new Object[]{str, Double.valueOf(d / 100.0d)});
        AppMethodBeat.m2505o(43949);
        return format;
    }

    /* renamed from: a */
    public static String m20797a(Context context, C35968ze c35968ze) {
        AppMethodBeat.m2504i(43950);
        String str;
        if (c35968ze.vQt > 0) {
            str = c35968ze.Name + " " + C12807b.m20798d((double) c35968ze.vQt, c35968ze.PriceType);
            AppMethodBeat.m2505o(43950);
            return str;
        }
        str = context.getString(C25738R.string.cy5);
        AppMethodBeat.m2505o(43950);
        return str;
    }
}
