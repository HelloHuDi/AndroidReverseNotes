package com.tencent.soter.a.c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class a {
    private static volatile a AvN = null;
    public SparseArray<String> AvO = new SparseArray(10);
    public SharedPreferences AvP = null;
    public boolean bZi = false;
    public boolean cul = false;

    public a() {
        AppMethodBeat.i(10465);
        AppMethodBeat.o(10465);
    }

    public static a dRe() {
        AppMethodBeat.i(10466);
        a aVar;
        if (AvN == null) {
            synchronized (a.class) {
                try {
                    if (AvN == null) {
                        AvN = new a();
                    }
                    aVar = AvN;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(10466);
                }
            }
            return aVar;
        }
        aVar = AvN;
        AppMethodBeat.o(10466);
        return aVar;
    }

    public final boolean isInit() {
        boolean z;
        synchronized (a.class) {
            z = this.bZi;
        }
        return z;
    }

    public final void dRf() {
        synchronized (a.class) {
            this.bZi = true;
        }
    }

    public final boolean dRc() {
        boolean z;
        synchronized (a.class) {
            z = this.cul;
        }
        return z;
    }

    public final void rq(boolean z) {
        synchronized (a.class) {
            this.cul = z;
        }
    }

    public final SparseArray<String> dRg() {
        SparseArray sparseArray;
        synchronized (a.class) {
            sparseArray = this.AvO;
        }
        return sparseArray;
    }

    public final SharedPreferences dRh() {
        SharedPreferences sharedPreferences;
        synchronized (a.class) {
            sharedPreferences = this.AvP;
        }
        return sharedPreferences;
    }
}
