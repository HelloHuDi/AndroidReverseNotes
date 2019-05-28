package com.tencent.p177mm.plugin.game.model.p978a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.game.report.api.C37860c;
import com.tencent.p177mm.game.report.api.C45406d;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.model.C2896d;
import com.tencent.p177mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.p177mm.plugin.game.p1268a.C45983c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/* renamed from: com.tencent.mm.plugin.game.model.a.f */
public final class C20989f {
    /* renamed from: Oa */
    public static void m32247Oa(String str) {
        AppMethodBeat.m2504i(111518);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111518);
            return;
        }
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        C20985d Ob = ((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36303Ob(str);
        if (Ir == null || Ir.f16167id <= 0) {
            if (Ob != null) {
                C20989f.m32249a(str, 0, "", 0, 3, 0, Ob.field_noWifi, Ob.field_noSdcard, Ob.field_noEnoughSpace, Ob.field_lowBattery, Ob.field_continueDelay, "");
                AppMethodBeat.m2505o(111518);
                return;
            }
            C20989f.m32249a(str, 0, "", 0, 3, 0, false, false, false, false, false, "");
            AppMethodBeat.m2505o(111518);
        } else if (Ob != null) {
            C20989f.m32249a(str, Ir.f16167id, Ir.url, Ir.jrb == 0 ? 0 : (int) ((Ir.kNr * 100) / Ir.jrb), 3, 0, Ob.field_noWifi, Ob.field_noSdcard, Ob.field_noEnoughSpace, Ob.field_lowBattery, Ob.field_continueDelay, "");
            AppMethodBeat.m2505o(111518);
        } else {
            C20989f.m32249a(str, Ir.f16167id, Ir.url, Ir.jrb == 0 ? 0 : (int) ((Ir.kNr * 100) / Ir.jrb), 3, 0, false, false, false, false, false, "");
            AppMethodBeat.m2505o(111518);
        }
    }

    /* renamed from: X */
    static void m32248X(String str, int i, int i2) {
        AppMethodBeat.m2504i(111519);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111519);
            return;
        }
        if (((C45983c) C1720g.m3528K(C45983c.class)).bDa().mo36303Ob(str) != null) {
            C20989f.m32246E(str, i, i2);
        }
        AppMethodBeat.m2505o(111519);
    }

    /* renamed from: E */
    static void m32246E(String str, int i, int i2) {
        AppMethodBeat.m2504i(111520);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(111520);
            return;
        }
        FileDownloadTaskInfo Ir = C2896d.bij().mo7040Ir(str);
        if (Ir == null || Ir.f16167id <= 0) {
            C20989f.m32249a(str, 0, "", 0, i, i2, false, false, false, false, false, "");
            AppMethodBeat.m2505o(111520);
            return;
        }
        C20989f.m32249a(str, Ir.f16167id, Ir.url, Ir.jrb == 0 ? 0 : (int) ((Ir.kNr * 100) / Ir.jrb), i, i2, false, false, false, false, false, "");
        AppMethodBeat.m2505o(111520);
    }

    /* renamed from: a */
    private static void m32249a(String str, long j, String str2, int i, int i2, int i3, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, String str3) {
        String str4;
        AppMethodBeat.m2504i(111521);
        C4990ab.m7417i("MicroMsg.GameSilentDownloadReporter", "reportInfo, appId:%s, downloadId:%d, downloadUrl:%s, downloadedPct:%d, finishType:%d, errCode:%d, noWifi:%b, noSdcard:%b, noEnoughSpace:%b, lowBattery:%b, continueDelay:%b", str, Long.valueOf(j), str2, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4), Boolean.valueOf(z5));
        try {
            if (C5046bo.isNullOrNil(str2)) {
                str4 = str2;
            } else {
                str4 = URLEncoder.encode(str2, "UTF-8");
            }
            try {
                if (!C5046bo.isNullOrNil(str3)) {
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
        C37860c.eBG.mo60578a(new C45406d(15547, C20989f.m32250q(objArr)));
        AppMethodBeat.m2505o(111521);
    }

    /* renamed from: q */
    private static String m32250q(Object... objArr) {
        AppMethodBeat.m2504i(111522);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 11; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[11]));
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(111522);
        return stringBuilder2;
    }
}
