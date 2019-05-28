package com.tencent.mm.plugin.wenote.model.nativenote.spans;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import java.util.ArrayList;

public final class u {
    public static final j uSA = new j();
    public static final c uSB = new c();
    public static final l uSC = new l();
    public static final h uSD = new h();
    public static final ArrayList<t> uSE;
    public static final b uSz = new b();

    static {
        AppMethodBeat.i(26975);
        ArrayList arrayList = new ArrayList();
        uSE = arrayList;
        arrayList.add(uSz);
        uSE.add(uSB);
        uSE.add(uSC);
        uSE.add(uSA);
        AppMethodBeat.o(26975);
    }

    public static void a(WXRTEditText wXRTEditText, t... tVarArr) {
        AppMethodBeat.i(26973);
        a(wXRTEditText, uSD, tVarArr);
        a(wXRTEditText, uSB, tVarArr);
        a(wXRTEditText, uSC, tVarArr);
        a(wXRTEditText, uSA, tVarArr);
        AppMethodBeat.o(26973);
    }

    private static void a(WXRTEditText wXRTEditText, o oVar, t... tVarArr) {
        AppMethodBeat.i(26974);
        for (t tVar : tVarArr) {
            if (oVar == tVar) {
                AppMethodBeat.o(26974);
                return;
            }
        }
        oVar.a(wXRTEditText, null, null);
        AppMethodBeat.o(26974);
    }
}
