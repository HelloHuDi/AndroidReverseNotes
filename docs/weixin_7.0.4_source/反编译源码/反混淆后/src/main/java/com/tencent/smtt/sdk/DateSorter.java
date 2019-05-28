package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.interfaces.IX5DateSorter;

public class DateSorter {
    public static int DAY_COUNT = 5;
    /* renamed from: a */
    private android.webkit.DateSorter f17965a;
    /* renamed from: b */
    private IX5DateSorter f17966b;

    static {
        AppMethodBeat.m2504i(63898);
        m88573a();
        AppMethodBeat.m2505o(63898);
    }

    public DateSorter(Context context) {
        AppMethodBeat.m2504i(63893);
        C40978bv a = C40978bv.m71073a();
        if (a == null || !a.mo64921b()) {
            this.f17965a = new android.webkit.DateSorter(context);
            AppMethodBeat.m2505o(63893);
            return;
        }
        this.f17966b = a.mo64922c().mo57595h(context);
        AppMethodBeat.m2505o(63893);
    }

    /* renamed from: a */
    private static boolean m88573a() {
        AppMethodBeat.m2504i(63897);
        boolean z = false;
        C40978bv a = C40978bv.m71073a();
        if (a != null && a.mo64921b()) {
            z = true;
        }
        AppMethodBeat.m2505o(63897);
        return z;
    }

    public long getBoundary(int i) {
        AppMethodBeat.m2504i(63896);
        C40978bv a = C40978bv.m71073a();
        long boundary;
        if (a == null || !a.mo64921b()) {
            boundary = this.f17965a.getBoundary(i);
            AppMethodBeat.m2505o(63896);
            return boundary;
        }
        boundary = this.f17966b.getBoundary(i);
        AppMethodBeat.m2505o(63896);
        return boundary;
    }

    public int getIndex(long j) {
        AppMethodBeat.m2504i(63894);
        C40978bv a = C40978bv.m71073a();
        int index;
        if (a == null || !a.mo64921b()) {
            index = this.f17965a.getIndex(j);
            AppMethodBeat.m2505o(63894);
            return index;
        }
        index = this.f17966b.getIndex(j);
        AppMethodBeat.m2505o(63894);
        return index;
    }

    public String getLabel(int i) {
        AppMethodBeat.m2504i(63895);
        C40978bv a = C40978bv.m71073a();
        String label;
        if (a == null || !a.mo64921b()) {
            label = this.f17965a.getLabel(i);
            AppMethodBeat.m2505o(63895);
            return label;
        }
        label = this.f17966b.getLabel(i);
        AppMethodBeat.m2505o(63895);
        return label;
    }
}
