package com.tencent.p177mm.game.report.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.game.report.api.d */
public final class C45406d {
    public int eBH;
    public String eBI;

    public C45406d(int i, String str) {
        this.eBH = i;
        this.eBI = str;
    }

    /* renamed from: b */
    public static C45406d m83611b(int i, Object... objArr) {
        AppMethodBeat.m2504i(128610);
        C45406d c45406d = new C45406d();
        c45406d.eBH = i;
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuilder.append(String.valueOf(objArr[i2])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        c45406d.eBI = stringBuilder.toString();
        C4990ab.m7411d("MicroMsg.GameReportInfo", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString());
        AppMethodBeat.m2505o(128610);
        return c45406d;
    }
}
