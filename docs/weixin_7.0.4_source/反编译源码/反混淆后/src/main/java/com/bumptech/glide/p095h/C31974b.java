package com.bumptech.glide.p095h;

import android.support.p057v4.p065f.C0417m;
import android.support.p057v4.p065f.C6197a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.bumptech.glide.h.b */
public final class C31974b<K, V> extends C6197a<K, V> {
    private int aBR;

    public final void clear() {
        AppMethodBeat.m2504i(92553);
        this.aBR = 0;
        super.clear();
        AppMethodBeat.m2505o(92553);
    }

    public final V setValueAt(int i, V v) {
        AppMethodBeat.m2504i(92554);
        this.aBR = 0;
        Object valueAt = super.setValueAt(i, v);
        AppMethodBeat.m2505o(92554);
        return valueAt;
    }

    public final V put(K k, V v) {
        AppMethodBeat.m2504i(92555);
        this.aBR = 0;
        Object put = super.put(k, v);
        AppMethodBeat.m2505o(92555);
        return put;
    }

    /* renamed from: a */
    public final void mo828a(C0417m<? extends K, ? extends V> c0417m) {
        AppMethodBeat.m2504i(92556);
        this.aBR = 0;
        super.mo828a(c0417m);
        AppMethodBeat.m2505o(92556);
    }

    public final V removeAt(int i) {
        AppMethodBeat.m2504i(92557);
        this.aBR = 0;
        Object removeAt = super.removeAt(i);
        AppMethodBeat.m2505o(92557);
        return removeAt;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(92558);
        if (this.aBR == 0) {
            this.aBR = super.hashCode();
        }
        int i = this.aBR;
        AppMethodBeat.m2505o(92558);
        return i;
    }
}
