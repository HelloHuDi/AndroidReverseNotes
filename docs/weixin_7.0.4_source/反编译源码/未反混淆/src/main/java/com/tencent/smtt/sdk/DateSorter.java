package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter {
    public static int DAY_COUNT = 5;
    private android.webkit.DateSorter a;
    private IX5DateSorter b;

    static {
        AppMethodBeat.i(63898);
        a();
        AppMethodBeat.o(63898);
    }

    public DateSorter(Context context) {
        AppMethodBeat.i(63893);
        bv a = bv.a();
        if (a == null || !a.b()) {
            this.a = new android.webkit.DateSorter(context);
            AppMethodBeat.o(63893);
            return;
        }
        this.b = a.c().h(context);
        AppMethodBeat.o(63893);
    }

    private static boolean a() {
        AppMethodBeat.i(63897);
        boolean z = false;
        bv a = bv.a();
        if (a != null && a.b()) {
            z = true;
        }
        AppMethodBeat.o(63897);
        return z;
    }

    public long getBoundary(int i) {
        AppMethodBeat.i(63896);
        bv a = bv.a();
        long boundary;
        if (a == null || !a.b()) {
            boundary = this.a.getBoundary(i);
            AppMethodBeat.o(63896);
            return boundary;
        }
        boundary = this.b.getBoundary(i);
        AppMethodBeat.o(63896);
        return boundary;
    }

    public int getIndex(long j) {
        AppMethodBeat.i(63894);
        bv a = bv.a();
        int index;
        if (a == null || !a.b()) {
            index = this.a.getIndex(j);
            AppMethodBeat.o(63894);
            return index;
        }
        index = this.b.getIndex(j);
        AppMethodBeat.o(63894);
        return index;
    }

    public String getLabel(int i) {
        AppMethodBeat.i(63895);
        bv a = bv.a();
        String label;
        if (a == null || !a.b()) {
            label = this.a.getLabel(i);
            AppMethodBeat.o(63895);
            return label;
        }
        label = this.b.getLabel(i);
        AppMethodBeat.o(63895);
        return label;
    }
}
