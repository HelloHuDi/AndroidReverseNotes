package com.tencent.p177mm.p1174aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.aa.h */
public final class C41725h {
    private static volatile int eIB = 0;
    private static volatile boolean eIC = false;
    private static C32220e eID;

    public static void initialize() {
    }

    /* renamed from: lw */
    public static JSONObject m73457lw(String str) {
        AppMethodBeat.m2504i(117625);
        if (eIB == 1) {
            C41726i c41726i = new C41726i(str);
            AppMethodBeat.m2505o(117625);
            return c41726i;
        }
        JSONObject jSONObject = new JSONObject(str);
        AppMethodBeat.m2505o(117625);
        return jSONObject;
    }

    /* renamed from: QC */
    public static C17868c m73451QC() {
        AppMethodBeat.m2504i(117626);
        if (eIB == 1) {
            C25742l c25742l = new C25742l();
            AppMethodBeat.m2505o(117626);
            return c25742l;
        }
        C17868c c24653d = new C24653d();
        AppMethodBeat.m2505o(117626);
        return c24653d;
    }

    /* renamed from: j */
    public static C17868c m73455j(Map map) {
        AppMethodBeat.m2504i(117627);
        if (eIB == 1) {
            C25742l c25742l = new C25742l(map);
            AppMethodBeat.m2505o(117627);
            return c25742l;
        }
        C17868c c24653d = new C24653d(map);
        AppMethodBeat.m2505o(117627);
        return c24653d;
    }

    /* renamed from: lx */
    public static C17868c m73458lx(String str) {
        AppMethodBeat.m2504i(117628);
        if (eIB == 1) {
            C25742l c25742l = new C25742l(str);
            AppMethodBeat.m2505o(117628);
            return c25742l;
        }
        C17868c c24653d = new C24653d(str);
        AppMethodBeat.m2505o(117628);
        return c24653d;
    }

    /* renamed from: QD */
    public static C41723a m73452QD() {
        AppMethodBeat.m2504i(117629);
        if (eIB == 1) {
            C17870k c17870k = new C17870k();
            AppMethodBeat.m2505o(117629);
            return c17870k;
        }
        C41723a c17867b = new C17867b();
        AppMethodBeat.m2505o(117629);
        return c17867b;
    }

    /* renamed from: ly */
    public static C41723a m73459ly(String str) {
        AppMethodBeat.m2504i(117630);
        if (eIB == 1) {
            C17870k c17870k = new C17870k(str);
            AppMethodBeat.m2505o(117630);
            return c17870k;
        }
        C41723a c17867b = new C17867b(str);
        AppMethodBeat.m2505o(117630);
        return c17867b;
    }

    /* renamed from: jM */
    public static void m73456jM(int i) {
        eIB = i;
        eIC = true;
    }

    /* renamed from: QE */
    public static int m73453QE() {
        return eIB;
    }

    /* renamed from: a */
    public static void m73454a(C32220e c32220e) {
        eID = c32220e;
    }
}
