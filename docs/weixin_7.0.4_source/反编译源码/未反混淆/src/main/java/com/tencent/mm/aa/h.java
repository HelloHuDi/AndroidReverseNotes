package com.tencent.mm.aa;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    private static volatile int eIB = 0;
    private static volatile boolean eIC = false;
    private static e eID;

    public static void initialize() {
    }

    public static JSONObject lw(String str) {
        AppMethodBeat.i(117625);
        if (eIB == 1) {
            i iVar = new i(str);
            AppMethodBeat.o(117625);
            return iVar;
        }
        JSONObject jSONObject = new JSONObject(str);
        AppMethodBeat.o(117625);
        return jSONObject;
    }

    public static c QC() {
        AppMethodBeat.i(117626);
        if (eIB == 1) {
            l lVar = new l();
            AppMethodBeat.o(117626);
            return lVar;
        }
        c dVar = new d();
        AppMethodBeat.o(117626);
        return dVar;
    }

    public static c j(Map map) {
        AppMethodBeat.i(117627);
        if (eIB == 1) {
            l lVar = new l(map);
            AppMethodBeat.o(117627);
            return lVar;
        }
        c dVar = new d(map);
        AppMethodBeat.o(117627);
        return dVar;
    }

    public static c lx(String str) {
        AppMethodBeat.i(117628);
        if (eIB == 1) {
            l lVar = new l(str);
            AppMethodBeat.o(117628);
            return lVar;
        }
        c dVar = new d(str);
        AppMethodBeat.o(117628);
        return dVar;
    }

    public static a QD() {
        AppMethodBeat.i(117629);
        if (eIB == 1) {
            k kVar = new k();
            AppMethodBeat.o(117629);
            return kVar;
        }
        a bVar = new b();
        AppMethodBeat.o(117629);
        return bVar;
    }

    public static a ly(String str) {
        AppMethodBeat.i(117630);
        if (eIB == 1) {
            k kVar = new k(str);
            AppMethodBeat.o(117630);
            return kVar;
        }
        a bVar = new b(str);
        AppMethodBeat.o(117630);
        return bVar;
    }

    public static void jM(int i) {
        eIB = i;
        eIC = true;
    }

    public static int QE() {
        return eIB;
    }

    public static void a(e eVar) {
        eID = eVar;
    }
}
