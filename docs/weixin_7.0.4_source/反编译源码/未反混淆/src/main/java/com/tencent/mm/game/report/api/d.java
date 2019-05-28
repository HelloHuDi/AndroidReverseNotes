package com.tencent.mm.game.report.api;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class d {
    public int eBH;
    public String eBI;

    public d(int i, String str) {
        this.eBH = i;
        this.eBI = str;
    }

    public static d b(int i, Object... objArr) {
        AppMethodBeat.i(128610);
        d dVar = new d();
        dVar.eBH = i;
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i2 = 0; i2 < length; i2++) {
            stringBuilder.append(String.valueOf(objArr[i2])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        dVar.eBI = stringBuilder.toString();
        ab.d("MicroMsg.GameReportInfo", "appStat logID=%d, vals.size=%d, val = %s", Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString());
        AppMethodBeat.o(128610);
        return dVar;
    }
}
