package com.tencent.mm.plugin.game.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class f {
    public static void Oa(String str) {
        AppMethodBeat.i(111518);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111518);
            return;
        }
        FileDownloadTaskInfo Ir = d.bij().Ir(str);
        d Ob = ((c) g.K(c.class)).bDa().Ob(str);
        if (Ir == null || Ir.id <= 0) {
            if (Ob != null) {
                a(str, 0, "", 0, 3, 0, Ob.field_noWifi, Ob.field_noSdcard, Ob.field_noEnoughSpace, Ob.field_lowBattery, Ob.field_continueDelay, "");
                AppMethodBeat.o(111518);
                return;
            }
            a(str, 0, "", 0, 3, 0, false, false, false, false, false, "");
            AppMethodBeat.o(111518);
        } else if (Ob != null) {
            a(str, Ir.id, Ir.url, Ir.jrb == 0 ? 0 : (int) ((Ir.kNr * 100) / Ir.jrb), 3, 0, Ob.field_noWifi, Ob.field_noSdcard, Ob.field_noEnoughSpace, Ob.field_lowBattery, Ob.field_continueDelay, "");
            AppMethodBeat.o(111518);
        } else {
            a(str, Ir.id, Ir.url, Ir.jrb == 0 ? 0 : (int) ((Ir.kNr * 100) / Ir.jrb), 3, 0, false, false, false, false, false, "");
            AppMethodBeat.o(111518);
        }
    }

    static void X(String str, int i, int i2) {
        AppMethodBeat.i(111519);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111519);
            return;
        }
        if (((c) g.K(c.class)).bDa().Ob(str) != null) {
            E(str, i, i2);
        }
        AppMethodBeat.o(111519);
    }

    static void E(String str, int i, int i2) {
        AppMethodBeat.i(111520);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(111520);
            return;
        }
        FileDownloadTaskInfo Ir = d.bij().Ir(str);
        if (Ir == null || Ir.id <= 0) {
            a(str, 0, "", 0, i, i2, false, false, false, false, false, "");
            AppMethodBeat.o(111520);
            return;
        }
        a(str, Ir.id, Ir.url, Ir.jrb == 0 ? 0 : (int) ((Ir.kNr * 100) / Ir.jrb), i, i2, false, false, false, false, false, "");
        AppMethodBeat.o(111520);
    }

    private static void a(String str, long j, String str2, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3) {
        String str4;
        AppMethodBeat.i(111521);
        ab.i("MicroMsg.GameSilentDownloadReporter", "reportInfo, appId:%s, downloadId:%d, downloadUrl:%s, downloadedPct:%d, finishType:%d, errCode:%d, noWifi:%b, noSdcard:%b, noEnoughSpace:%b, lowBattery:%b, continueDelay:%b", str, Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5));
        try {
            if (bo.isNullOrNil(str2)) {
                str4 = str2;
            } else {
                str4 = URLEncoder.encode(str2, "UTF-8");
            }
            try {
                if (!bo.isNullOrNil(str3)) {
                    str3 = URLEncoder.encode(str3, "UTF-8");
                }
            } catch (UnsupportedEncodingException e) {
            }
        } catch (UnsupportedEncodingException e2) {
            str4 = str2;
        }
        Object[] objArr = new Object[12];
        objArr[0] = str;
        objArr[1] = Long.valueOf(j);
        objArr[2] = str4;
        objArr[3] = Integer.valueOf(i);
        objArr[4] = Integer.valueOf(i2);
        objArr[5] = Integer.valueOf(i3);
        objArr[6] = Integer.valueOf(z ? 1 : 0);
        objArr[7] = Integer.valueOf(z2 ? 1 : 0);
        objArr[8] = Integer.valueOf(z3 ? 1 : 0);
        objArr[9] = Integer.valueOf(z4 ? 1 : 0);
        objArr[10] = Integer.valueOf(z5 ? 1 : 0);
        objArr[11] = str3;
        com.tencent.mm.game.report.api.c.eBG.a(new com.tencent.mm.game.report.api.d(15547, q(objArr)));
        AppMethodBeat.o(111521);
    }

    private static String q(Object... objArr) {
        AppMethodBeat.i(111522);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[11]));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.o(111522);
        return stringBuilder2;
    }
}
