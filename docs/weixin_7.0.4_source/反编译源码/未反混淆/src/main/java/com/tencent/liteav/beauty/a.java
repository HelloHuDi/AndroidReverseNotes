package com.tencent.liteav.beauty;

import android.content.Context;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private static a a = null;
    private static Context b = null;
    private static boolean c = false;
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    private static boolean m = false;
    private static boolean n = false;
    private static boolean o = false;
    private String p = "ReportDuaManage";

    public static a a() {
        AppMethodBeat.i(66895);
        if (a == null) {
            a = new a();
        }
        a aVar = a;
        AppMethodBeat.o(66895);
        return aVar;
    }

    public void a(Context context) {
        AppMethodBeat.i(66896);
        f();
        b = context.getApplicationContext();
        if (!c) {
            TXCLog.i(this.p, "reportSDKInit");
            TXCDRApi.txReportDAU(b, 1201, 0, "reportSDKInit!");
        }
        c = true;
        AppMethodBeat.o(66896);
    }

    public void b() {
        AppMethodBeat.i(66897);
        if (!d) {
            TXCLog.i(this.p, "reportBeautyDua");
            TXCDRApi.txReportDAU(b, 1202, 0, "reportBeautyDua");
        }
        d = true;
        AppMethodBeat.o(66897);
    }

    public void c() {
        AppMethodBeat.i(66898);
        if (!e) {
            TXCLog.i(this.p, "reportWhiteDua");
            TXCDRApi.txReportDAU(b, 1203, 0, "reportWhiteDua");
        }
        e = true;
        AppMethodBeat.o(66898);
    }

    public void d() {
        AppMethodBeat.i(66899);
        if (!j) {
            TXCLog.i(this.p, "reportFilterImageDua");
            TXCDRApi.txReportDAU(b, 1208, 0, "reportFilterImageDua");
        }
        j = true;
        AppMethodBeat.o(66899);
    }

    public void e() {
        AppMethodBeat.i(66900);
        if (!n) {
            TXCLog.i(this.p, "reportWarterMarkDua");
            TXCDRApi.txReportDAU(b, 1212, 0, "reportWarterMarkDua");
        }
        n = true;
        AppMethodBeat.o(66900);
    }

    private void f() {
        AppMethodBeat.i(66901);
        TXCLog.i(this.p, "resetReportState");
        c = false;
        d = false;
        e = false;
        f = false;
        g = false;
        h = false;
        i = false;
        j = false;
        k = false;
        l = false;
        m = false;
        n = false;
        o = false;
        AppMethodBeat.o(66901);
    }
}
