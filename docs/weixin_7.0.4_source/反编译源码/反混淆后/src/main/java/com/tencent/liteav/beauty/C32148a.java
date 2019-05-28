package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.liteav.beauty.a */
public class C32148a {
    /* renamed from: a */
    private static C32148a f14754a = null;
    /* renamed from: b */
    private static Context f14755b = null;
    /* renamed from: c */
    private static boolean f14756c = false;
    /* renamed from: d */
    private static boolean f14757d = false;
    /* renamed from: e */
    private static boolean f14758e = false;
    /* renamed from: f */
    private static boolean f14759f = false;
    /* renamed from: g */
    private static boolean f14760g = false;
    /* renamed from: h */
    private static boolean f14761h = false;
    /* renamed from: i */
    private static boolean f14762i = false;
    /* renamed from: j */
    private static boolean f14763j = false;
    /* renamed from: k */
    private static boolean f14764k = false;
    /* renamed from: l */
    private static boolean f14765l = false;
    /* renamed from: m */
    private static boolean f14766m = false;
    /* renamed from: n */
    private static boolean f14767n = false;
    /* renamed from: o */
    private static boolean f14768o = false;
    /* renamed from: p */
    private String f14769p = "ReportDuaManage";

    /* renamed from: a */
    public static C32148a m52321a() {
        AppMethodBeat.m2504i(66895);
        if (f14754a == null) {
            f14754a = new C32148a();
        }
        C32148a c32148a = f14754a;
        AppMethodBeat.m2505o(66895);
        return c32148a;
    }

    /* renamed from: a */
    public void mo52741a(Context context) {
        AppMethodBeat.m2504i(66896);
        m52322f();
        f14755b = context.getApplicationContext();
        if (!f14756c) {
            TXCLog.m15677i(this.f14769p, "reportSDKInit");
            TXCDRApi.txReportDAU(f14755b, 1201, 0, "reportSDKInit!");
        }
        f14756c = true;
        AppMethodBeat.m2505o(66896);
    }

    /* renamed from: b */
    public void mo52742b() {
        AppMethodBeat.m2504i(66897);
        if (!f14757d) {
            TXCLog.m15677i(this.f14769p, "reportBeautyDua");
            TXCDRApi.txReportDAU(f14755b, 1202, 0, "reportBeautyDua");
        }
        f14757d = true;
        AppMethodBeat.m2505o(66897);
    }

    /* renamed from: c */
    public void mo52743c() {
        AppMethodBeat.m2504i(66898);
        if (!f14758e) {
            TXCLog.m15677i(this.f14769p, "reportWhiteDua");
            TXCDRApi.txReportDAU(f14755b, 1203, 0, "reportWhiteDua");
        }
        f14758e = true;
        AppMethodBeat.m2505o(66898);
    }

    /* renamed from: d */
    public void mo52744d() {
        AppMethodBeat.m2504i(66899);
        if (!f14763j) {
            TXCLog.m15677i(this.f14769p, "reportFilterImageDua");
            TXCDRApi.txReportDAU(f14755b, 1208, 0, "reportFilterImageDua");
        }
        f14763j = true;
        AppMethodBeat.m2505o(66899);
    }

    /* renamed from: e */
    public void mo52745e() {
        AppMethodBeat.m2504i(66900);
        if (!f14767n) {
            TXCLog.m15677i(this.f14769p, "reportWarterMarkDua");
            TXCDRApi.txReportDAU(f14755b, 1212, 0, "reportWarterMarkDua");
        }
        f14767n = true;
        AppMethodBeat.m2505o(66900);
    }

    /* renamed from: f */
    private void m52322f() {
        AppMethodBeat.m2504i(66901);
        TXCLog.m15677i(this.f14769p, "resetReportState");
        f14756c = false;
        f14757d = false;
        f14758e = false;
        f14759f = false;
        f14760g = false;
        f14761h = false;
        f14762i = false;
        f14763j = false;
        f14764k = false;
        f14765l = false;
        f14766m = false;
        f14767n = false;
        f14768o = false;
        AppMethodBeat.m2505o(66901);
    }
}
