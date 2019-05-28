package com.tencent.mm.booter.notification.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class g {
    public c eeA;
    public d eeB;
    public h eeC;
    private f eeD;
    public a eeE;
    public int eeF;
    public int eeG;
    public int eeH;
    public int eeI;
    public boolean eeJ;
    private int eeK = -1;
    private int eeL = -1;
    public boolean eeM;
    public boolean eeN;
    public b eez;
    public Context mContext;

    public g(Context context) {
        AppMethodBeat.i(16035);
        this.mContext = context;
        this.eez = new b();
        this.eeA = new c();
        this.eeB = new d();
        this.eeC = new h();
        this.eeE = new a();
        this.eeD = a.eey;
        AppMethodBeat.o(16035);
    }

    public final void jU(String str) {
        AppMethodBeat.i(16036);
        this.eeD.jT(str);
        AppMethodBeat.o(16036);
    }

    public static String b(long[] jArr) {
        AppMethodBeat.i(16037);
        if (jArr == null) {
            AppMethodBeat.o(16037);
            return null;
        }
        String str = "";
        for (long valueOf : jArr) {
            str = str + String.valueOf(valueOf) + ",";
        }
        if (str.isEmpty()) {
            AppMethodBeat.o(16037);
            return str;
        }
        str = str.substring(0, str.length() - 1);
        AppMethodBeat.o(16037);
        return str;
    }
}
