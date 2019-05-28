package com.tencent.soter.p663a.p1107c;

import android.content.SharedPreferences;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.soter.a.c.a */
public class C16167a {
    private static volatile C16167a AvN = null;
    public SparseArray<String> AvO = new SparseArray(10);
    public SharedPreferences AvP = null;
    public boolean bZi = false;
    public boolean cul = false;

    public C16167a() {
        AppMethodBeat.m2504i(10465);
        AppMethodBeat.m2505o(10465);
    }

    public static C16167a dRe() {
        AppMethodBeat.m2504i(10466);
        C16167a c16167a;
        if (AvN == null) {
            synchronized (C16167a.class) {
                try {
                    if (AvN == null) {
                        AvN = new C16167a();
                    }
                    c16167a = AvN;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10466);
                }
            }
            return c16167a;
        }
        c16167a = AvN;
        AppMethodBeat.m2505o(10466);
        return c16167a;
    }

    public final boolean isInit() {
        boolean z;
        synchronized (C16167a.class) {
            z = this.bZi;
        }
        return z;
    }

    public final void dRf() {
        synchronized (C16167a.class) {
            this.bZi = true;
        }
    }

    public final boolean dRc() {
        boolean z;
        synchronized (C16167a.class) {
            z = this.cul;
        }
        return z;
    }

    /* renamed from: rq */
    public final void mo28991rq(boolean z) {
        synchronized (C16167a.class) {
            this.cul = z;
        }
    }

    public final SparseArray<String> dRg() {
        SparseArray sparseArray;
        synchronized (C16167a.class) {
            sparseArray = this.AvO;
        }
        return sparseArray;
    }

    public final SharedPreferences dRh() {
        SharedPreferences sharedPreferences;
        synchronized (C16167a.class) {
            sharedPreferences = this.AvP;
        }
        return sharedPreferences;
    }
}
